package com.xsj284.training.dao;

import com.xsj284.training.entity.User;
import com.xsj284.training.entity.UserPwd;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xsj284
 * <p>created date: 2022/5/14</p>
 */
@Repository
public interface UserDao {
    @Insert("insert into tb_user " +
            "(username, sex, birthday, address, profile_photo, personal_signature) " +
            "values " +
            "(#{username}, #{sex}, #{birthday}, #{address}, #{profilePhoto}, #{personalSignature});")
    int insertUser(User user);

    @Update("update tb_user set " +
            "username = #{username}, " +
            "sex = #{sex}, " +
            "birthday = #{birthday}, " +
            "address = #{address}, " +
            "profile_photo = #{profilePhoto}, " +
            "personal_signature = #{personalSignature} " +
            "where id=#{id};")
    int updateUser(User user);

    @Delete("delete from tb_user where id=#{id};")
    int deleteUser(int id);

    @Select("select " +
            "* " +
            "from tb_user where id=#{id};")
    @Results({@Result(column = "profile_photo", property = "profilePhoto"),
            @Result(column = "personal_signature", property = "personalSignature")})
    User selectUserById(int id);

    @Select("select exists(select * from tb_user where username=#{username});")
    int isExistsByName(String username);

    @Select("select id from tb_user where username=#{username};")
    int selectIdByName(String username);

    @Select("select * from tb_user;")
    List<User> selectAll();

    @Insert("insert into tb_user_pwd (id, pwd) values (#{id}, #{pwd});")
    int insertUserPwd(UserPwd userPwd);

    @Update("update tb_user_pwd set pwd = #{pwd} where id=#{id};")
    int updateUserPwd(UserPwd userPwd);

    @Delete("delete from tb_user_pwd where id=#{id};")
    int deleteUserPwd(int userId);

    @Select("select pwd from tb_user_pwd where id=#{id};")
    String selectUserPwd(int userId);
}
