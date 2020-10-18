/*
 Navicat Premium Data Transfer

 Source Server         : local_dev
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : content-center

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/10/2020 16:33:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mid_user_share
-- ----------------------------
DROP TABLE IF EXISTS `mid_user_share`;
CREATE TABLE `mid_user_share`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `share_id` int(0) NOT NULL COMMENT 'share.id',
  `user_id` int(0) NOT NULL COMMENT 'user.id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_mid_user_share_share1_idx`(`share_id`) USING BTREE,
  INDEX `fk_mid_user_share_user1_idx`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '用户-分享中间表【描述用户购买的分享】' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mid_user_share
-- ----------------------------
INSERT INTO `mid_user_share` VALUES (1, 1, 10);
INSERT INTO `mid_user_share` VALUES (2, 2, 10);
INSERT INTO `mid_user_share` VALUES (3, 3, 10);
INSERT INTO `mid_user_share` VALUES (4, 4, 10);
INSERT INTO `mid_user_share` VALUES (5, 14, 10);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '内容',
  `show_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否显示 0:否 1:是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '习近平在联合国成立75周年纪念峰会上的讲话', 0, '2020-09-22 15:28:55');
INSERT INTO `notice` VALUES (2, '关注你我之书', 1, '2020-10-05 12:50:59');
INSERT INTO `notice` VALUES (3, '国庆假期结束', 0, '2020-10-03 12:51:29');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(0) NOT NULL DEFAULT 0 COMMENT '发布人id',
  `title` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '标题',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `is_original` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否原创 0:否 1:是',
  `author` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '作者',
  `cover` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '封面',
  `summary` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '概要信息',
  `price` int(0) NOT NULL DEFAULT 0 COMMENT '价格（需要的积分）',
  `download_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '下载地址',
  `buy_count` int(0) NOT NULL DEFAULT 0 COMMENT '下载数 ',
  `show_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否显示 0:否 1:是',
  `audit_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '0' COMMENT '审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过',
  `reason` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '分享表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of share
-- ----------------------------
INSERT INTO `share` VALUES (1, 8, 'Python编程', '2020-09-08 15:24:05', '2020-09-16 15:24:09', 0, '别来无恙', 'https://img9.doubanio.com/view/subject/s/public/s28891775.jpg', '悄悄学会Python编程', 30, 'https://book.douban.com/', 5, 1, 'PASS', '');
INSERT INTO `share` VALUES (2, 1, '你代码大全', '2020-09-08 15:26:44', '2020-09-09 15:26:48', 1, '星空', 'https://img1.doubanio.com/view/subject/s/public/s1495029.jpg', 'java代码大全', 11, 'https://book.douban.com/', 5, 1, 'PASS', 'PASS');
INSERT INTO `share` VALUES (3, 2, '程序员修炼之道', '2020-09-01 20:53:30', '2020-09-04 20:53:37', 1, '云风', 'https://img3.doubanio.com/view/subject/s/public/s33607450.jpg', '程序员修炼之道', 77, 'https://book.douban.com/', 10, 1, 'PASS', 'PASS');
INSERT INTO `share` VALUES (4, 1, '微服务技术', '2020-10-07 00:00:00', '2020-10-07 00:00:00', 0, '空白', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017204301.png', '微服务学习笔记', 13, 'https://book.douban.com/', 11, 1, 'PASS', '');
INSERT INTO `share` VALUES (5, 2, 'vue框架', '2020-10-07 00:00:00', '2020-10-07 00:00:00', 1, '景天', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017204354.png', 'vue前端技术', 35, 'https://book.douban.com/', 50, 1, 'PASS', '');
INSERT INTO `share` VALUES (6, 2, '课堂笔记', '2020-10-07 00:00:00', '2020-10-07 00:00:00', 0, 'martin', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017204452.png', 'vue spring课堂笔记', 99, 'https://book.douban.com/', 30, 1, 'PASS', '');
INSERT INTO `share` VALUES (13, 10, '全球高武', '2020-10-17 14:11:12', '2020-10-17 14:11:12', 0, '老鹰吃小鸡', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017204609.png', '重生过去、畅想未来', 13, 'https://book.douban.com/', 0, 0, 'PASS', 'no');
INSERT INTO `share` VALUES (14, 10, '\r\n基因时代', '2020-10-17 14:11:12', '2020-10-17 14:11:12', 0, '猪三不', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017204706.png', '心潮澎湃，无限幻想', 17, 'https://book.douban.com/', 0, 0, 'PASS', 'no');
INSERT INTO `share` VALUES (15, 10, '时空斗甲行 ', '2020-10-17 14:11:12', '2020-10-17 14:11:12', 0, '萧潜', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017203416.png', '星海漫游，时空穿梭', 23, 'https://book.douban.com/', 0, 1, 'PASS', 'no');
INSERT INTO `share` VALUES (16, 3, '大奉打更人 ', '2020-10-17 14:11:12', '2020-10-17 14:11:12', 1, '卖报小郎君', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201017204132.png', '修仙觅长生，热血任逍遥', 24, 'https://book.douban.com/', 0, 1, 'PASS', 'no');
INSERT INTO `share` VALUES (17, 10, '北国谍影 ', '2020-10-17 12:30:46', '2020-10-18 12:30:51', 0, '寻青藤', 'https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20201018123015.png', '热血战斗，保家卫国', 3, 'https://book.douban.com/', 0, 0, 'NOT_YET', '');
INSERT INTO `share` VALUES (23, 10, '11', '2020-10-18 13:45:57', '2020-10-18 13:45:57', 0, '123', 'https://img1.doubanio.com/view/subject/s/public/s1495029.jpg', 'summaey', 12, 'no', 10, 0, 'NOT_YET', 'no');

-- ----------------------------
-- Table structure for t_rocketmq_transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `t_rocketmq_transaction_log`;
CREATE TABLE `t_rocketmq_transaction_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `transaction_Id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL COMMENT '事务id',
  `log` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL COMMENT '日志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = 'RocketMQ事务日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_rocketmq_transaction_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
