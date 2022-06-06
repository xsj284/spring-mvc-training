/*
 Navicat Premium Data Transfer

 Source Server         : Mine
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3308
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/05/2022 06:02:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '标题',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '佚名' COMMENT '作者',
  `content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '内容',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (9, 'dauwhwakf', 'xsj284', '/content/9.txt', '2022-05-30 05:24:19');
INSERT INTO `tb_article` VALUES (10, 'adasdasdasda', 'xsj284', '/content/10.txt', '2022-05-30 05:42:12');
INSERT INTO `tb_article` VALUES (11, 'asdafefacsaca', 'xsj284', '/content/11.txt', '2022-05-30 05:42:20');
INSERT INTO `tb_article` VALUES (12, 'wyjtest', 'wyj', '/content/12.txt', '2022-05-30 05:43:31');
INSERT INTO `tb_article` VALUES (13, '2814719wd', 'wyj', '/content/13.txt', '2022-05-30 05:43:40');
INSERT INTO `tb_article` VALUES (14, 'tsetffaf', 'xsj284', '/content/14.txt', '2022-05-30 05:54:27');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `sex` enum('男','女','未知') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '未知' COMMENT '性别',
  `birthday` date NOT NULL DEFAULT '2000-01-01' COMMENT '日期',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '地址',
  `profile_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'img/userProfile/default.png' COMMENT '头像图片地址',
  `personal_signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '个性留言',
  `admin` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'xsj284', '男', '2002-02-02', '江西省', 'img/userProfile/default.png', 'this', '1');
INSERT INTO `tb_user` VALUES (14, 'wyj', '男', '2000-01-01', '江西省', 'img/userProfile/default.png', 'this', '0');

-- ----------------------------
-- Table structure for tb_user_pwd
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_pwd`;
CREATE TABLE `tb_user_pwd`  (
  `id` int NOT NULL COMMENT 'id',
  `pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `tb_user_pwd_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_pwd
-- ----------------------------
INSERT INTO `tb_user_pwd` VALUES (1, '123456');
INSERT INTO `tb_user_pwd` VALUES (14, '123456');

SET FOREIGN_KEY_CHECKS = 1;
