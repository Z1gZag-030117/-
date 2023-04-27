/*
 Navicat Premium Data Transfer

 Source Server         : MyNavicat
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : tilitili

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 22/04/2021 19:43:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT 'admin_user表的主键，不具有业务效应，仅保证唯一性',
  `login_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的登录账号',
  `login_pwd` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的登录密码',
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的昵称',
  `admin_description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员的个人介绍、描述',
  `admin_circle` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员所管理的瓜圈',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `login_name`(`login_name`) USING BTREE,
  UNIQUE INDEX `admin_name`(`admin_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'superadmin', '17c4520f6cfd1ab53d8745e84681eb49', '超级管理员', '超级管理员可以修改普通管理员的账号、密码、创建和删除瓜圈', 'NULL');
INSERT INTO `admin` VALUES (2, 'admin01', '18c6d818ae35a3e8279b5330eda01498', '郑爽瓜圈管理员', '对郑爽瓜圈进行管理', '郑爽瓜圈');
INSERT INTO `admin` VALUES (3, 'admin02', '6e60a28384bc05fa5b33cc579d040c56', '罗志祥瓜圈管理员', '对罗志祥瓜圈进行管理', '罗志祥瓜圈');
INSERT INTO `admin` VALUES (4, 'admin03', '7dc2466ad3ff5911f6a5e47e043e0abc', '华晨宇瓜圈管理员', '对华晨宇瓜圈进行管理', '华晨宇瓜圈');
INSERT INTO `admin` VALUES (5, 'admin04', '499c208ceafb4fbba162f077060955bd', '川建国瓜圈管理员', '对川建国瓜圈进行管理', '川建国瓜圈');
INSERT INTO `admin` VALUES (7, 'admin05', '3deffd4cb346737769a7a509c95cee17', '肖战瓜圈管理员', '对肖战瓜圈进行管理', '肖战瓜圈');

-- ----------------------------
-- Table structure for circles
-- ----------------------------
DROP TABLE IF EXISTS `circles`;
CREATE TABLE `circles`  (
  `circle_id` int NOT NULL AUTO_INCREMENT COMMENT '瓜圈表的主键，不具有业务逻辑',
  `circle_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '瓜圈的名字',
  `create_time` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '瓜圈创建时间',
  `circle_admin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '瓜圈的管理员',
  `circle_description` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '瓜圈简短描述',
  PRIMARY KEY (`circle_id`) USING BTREE,
  UNIQUE INDEX `circle_name`(`circle_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of circles
-- ----------------------------
INSERT INTO `circles` VALUES (1, '郑爽瓜圈', '2021-03-30 09:35:14', 'admin01', '郑爽瓜圈，来了就爽！');
INSERT INTO `circles` VALUES (2, '罗志祥瓜圈', '2021-03-30 17:17:12', 'admin02', '你知道多人运动的刺激吗？');
INSERT INTO `circles` VALUES (3, '华晨宇瓜圈', '2021-03-30 22:52:21', 'admin03', '花花瓜圈，欢乐多多！');
INSERT INTO `circles` VALUES (4, '川建国瓜圈', '2021-03-31 00:10:05', 'admin04', '且看川建国如何建国！');
INSERT INTO `circles` VALUES (6, '肖战瓜圈', '2021-04-03 13:18:32', 'admin05', '肖战瓜大哦，快来看看');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` int NOT NULL AUTO_INCREMENT COMMENT '收藏表的主键，不具有任何的业务逻辑',
  `incident_title` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作为incident表的逻辑外键，用于联表查询',
  `collector` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏人的名字',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (29, '震惊！罗志祥多人运动！', 'testUser01');
INSERT INTO `collection` VALUES (34, '震惊！罗志祥多人运动！', 'testUser02');
INSERT INTO `collection` VALUES (38, '郑爽在美国代孕', 'testUser03');
INSERT INTO `collection` VALUES (39, '华晨宇为什么为婚已有一女？', 'testUser04');
INSERT INTO `collection` VALUES (41, '郑爽在美国代孕', 'testUser05');
INSERT INTO `collection` VALUES (42, '川建国移交总统权力了！', 'testUser05');
INSERT INTO `collection` VALUES (44, '震惊！罗志祥多人运动！', 'testUser03');
INSERT INTO `collection` VALUES (46, '华晨宇为什么为婚已有一女？', 'testUser01');
INSERT INTO `collection` VALUES (52, '川建国移交总统权力了！', 'testUser01');
INSERT INTO `collection` VALUES (56, '郑爽在美国代孕', 'testUser01');
INSERT INTO `collection` VALUES (58, '郑爽在美国代孕', '佳豪');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int NOT NULL AUTO_INCREMENT COMMENT '主键，不具有业务逻辑',
  `comment_publisher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '该评论的评论人，即user表中的user_name，作为逻辑外键',
  `comment_content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '该评价的内容',
  `incident_title` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论的瓜的标题，作为相对于incident表的逻辑外键',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (64, 'testUser01', '可以哟~志祥哥', '震惊！罗志祥多人运动！');
INSERT INTO `comment` VALUES (65, 'testUser01', '郑爽还是你郑爽！', '郑爽在美国代孕');
INSERT INTO `comment` VALUES (67, 'testUser01', '666啊', '郑爽在美国代孕');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `follow_id` int NOT NULL AUTO_INCREMENT,
  `incident_title` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `follower` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`follow_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES (50, '震惊！罗志祥多人运动！', 'testUser07');
INSERT INTO `follow` VALUES (56, '震惊！罗志祥多人运动！', 'testUser02');
INSERT INTO `follow` VALUES (58, '华晨宇为什么为婚已有一女？', 'testUser04');
INSERT INTO `follow` VALUES (59, '郑爽在美国代孕', 'testUser05');
INSERT INTO `follow` VALUES (60, '川建国移交总统权力了！', 'testUser05');
INSERT INTO `follow` VALUES (61, '华晨宇为什么为婚已有一女？', 'testUser05');
INSERT INTO `follow` VALUES (63, '震惊！罗志祥多人运动！', 'testUser03');
INSERT INTO `follow` VALUES (75, '川建国移交总统权力了！', 'testUser01');
INSERT INTO `follow` VALUES (76, '震惊！罗志祥多人运动！', 'testUser01');
INSERT INTO `follow` VALUES (78, '肖战好帅啊~', 'testUser01');
INSERT INTO `follow` VALUES (79, '肖战就是牛逼', 'testUser01');
INSERT INTO `follow` VALUES (81, '郑爽在美国代孕', '佳豪');
INSERT INTO `follow` VALUES (83, '震惊！罗志祥多人运动！', '小佳豪');

-- ----------------------------
-- Table structure for incident
-- ----------------------------
DROP TABLE IF EXISTS `incident`;
CREATE TABLE `incident`  (
  `incident_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `incident_title` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '事件标题',
  `incident_content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '事件的内容',
  `publisher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '事件的发布者',
  `publish_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '事件发布的时间',
  `like_num` int NOT NULL COMMENT '点赞数',
  `belong_circle` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '逻辑外键，指向circles表的circle_name（瓜圈名）字段',
  PRIMARY KEY (`incident_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of incident
-- ----------------------------
INSERT INTO `incident` VALUES (2, '震惊！罗志祥多人运动！', '  周扬青发推文表示罗志祥性生活混乱，竟然和多名\n女艺人在一张床上进行多人运动！', 'testUser02', '2021-03-30 21:17:39 ', 5, '罗志祥瓜圈');
INSERT INTO `incident` VALUES (5, '川建国移交总统权力了！', '  迫于舆论的压力，川建国不得不总统权力交给拜登\n但是川建国表示自己依然不承认失败了！', 'testUser02', '2021-03-31 18:02:55', 2, '川建国瓜圈');
INSERT INTO `incident` VALUES (21, '郑爽在美国代孕', '震惊！郑爽居然在美国偷偷代孕，而且现在表示还不\n想抚养两个孩子。', 'testUser03', '2021-04-13 17:46:12', 2, '郑爽瓜圈');
INSERT INTO `incident` VALUES (22, '华晨宇为什么为婚已有一女？', '华晨宇未婚已有一女的原因居然时华晨宇和张碧晨发\n生了一夜情，没有做好安全措施...', 'testUser03', '2021-04-13 17:51:40', 2, '华晨宇瓜圈');
INSERT INTO `incident` VALUES (23, '肖战好帅啊~', '肖战是真的真的好帅好帅好帅啊~~~~~', 'testUser05', '2021-04-13 20:07:14', 1, '肖战瓜圈');
INSERT INTO `incident` VALUES (35, '肖战就是牛逼', '肖战他好牛逼的~', 'testUser01', '2021-04-20 09:07:45', 1, '肖战瓜圈');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `report_id` int NOT NULL AUTO_INCREMENT,
  `incident_title` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `incident_content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `report_reason` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `belong_circle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `reporter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '举报人',
  `incident_publisher` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`report_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT 'user表的主键，无业务效应',
  `login_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户登录的账号',
  `login_pwd` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户登录的密码',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户的昵称',
  `user_sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户的性别',
  `user_birthday` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户的生日',
  `user_description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户的个人描述',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `login_name`(`login_name`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '0', 'cfcd208495d565ef66e7dff9f98764da', 'testUser01', '女', '2001-10-12', '测试用户01...');
INSERT INTO `user` VALUES (2, '269139', 'e28a71175ee8ceb9c3142b4dc4c1b8c1', 'testUser02', '男', '2000-12-03', '测试用户02');
INSERT INTO `user` VALUES (3, '123456', 'e10adc3949ba59abbe56e057f20f883e', 'testUser03', '男', '2001-12-14', '测试用户03');
INSERT INTO `user` VALUES (4, '654321', 'c33367701511b4f6020ec61ded352059', 'testUser04', '男', '2001-12-14', '测试用户04');
INSERT INTO `user` VALUES (6, '456789', 'e35cf7b66449df565f93c607d5a81d09', 'testUser05', '女', '2001-12-23', '测试用户05');
INSERT INTO `user` VALUES (11, '111', '698d51a19d8a121ce581499d7b701668', '佳豪', '男', '2001-10-12', '阿离可爱呀~');
INSERT INTO `user` VALUES (12, '111111', '96e79218965eb72c92a549dd5a330112', '小点点', '女', '2001-10-14', '我是小点点');
INSERT INTO `user` VALUES (13, '2691397780', 'dfceddcaacbaeaf70c31500fed1e3653', '小佳豪', '男', '2001-10-12', '测试用户~');

SET FOREIGN_KEY_CHECKS = 1;
