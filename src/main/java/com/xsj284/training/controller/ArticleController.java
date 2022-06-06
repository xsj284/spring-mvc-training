package com.xsj284.training.controller;

import com.xsj284.training.entity.Article;
import com.xsj284.training.service.ArticleService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author xsj284
 * created date: <p>2022/5/29<p>
 */
@Controller
public class ArticleController {


    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "getArticleInfo")
    @ResponseBody
    public List<Article> getArticleInfo() {
        return articleService.getAllArticles();
    }

    @RequestMapping(value = "deleteArticle")
    @ResponseBody
    public int deleteArticle(@RequestBody String str, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject(str);
        int id = jsonObject.getInt("id");

        try {
            String s = request.getServletContext().getRealPath("/content") + "/" + id + ".txt";
            System.out.println(s);
            File file = new File(s);
            if (file.delete()) {
                System.out.println(file.getName() + " 文件已被删除！");
            } else {
                System.out.println("文件删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleService.deleteArticle(id);
    }

    @RequestMapping(value = "getArticleContent", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getArticleContent(@RequestBody String str, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject(str);
        StringBuilder content = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    request.getSession().getServletContext().getRealPath(
                            "/content") + "/" + jsonObject.get("id") + ".txt"));
            while ((str = in.readLine()) != null) {
                content.append(str).append("<br>");
            }
        } catch (IOException ignored) {
        }
        str = content.toString();
        return str;
    }

    @RequestMapping(value = "addArticleInfo", produces = "application/form-data;charset=UTF-8")
    @ResponseBody
    public String addArticleInfo(@RequestParam("crowd_file") MultipartFile file, String title,
                              String author, HttpServletRequest request) {
        int code = articleService.addArticleInfo(title, author, "");
        if (code == 0) {
            return "0";
        }
        int id = articleService.selIdByAuthor(author);
        String orgFileName = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(orgFileName);
        String fileName = id + ext;
        try {
            File targetFile = new File(request.getSession().getServletContext().getRealPath("/content"), fileName);
            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
            Article article = new Article();
            article.setId(id);
            article.setTitle(title);
            article.setAuthor(author);
            article.setContent("/content/" + fileName);
            articleService.updateArticle(article);
            return "1";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "0";
    }
}
