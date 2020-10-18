/*
 Navicat Premium Data Transfer

 Source Server         : local_dev
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : user-center

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/10/2020 16:33:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bonus_event_log
-- ----------------------------
DROP TABLE IF EXISTS `bonus_event_log`;
CREATE TABLE `bonus_event_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT 'user.id',
  `value` int(0) NULL DEFAULT NULL COMMENT '积分操作值',
  `event` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发生的事件',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_bonus_event_log_user1_idx`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '积分变更记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bonus_event_log
-- ----------------------------
INSERT INTO `bonus_event_log` VALUES (4, 1, 50, 'CONTRIBUTE', '2020-10-08 16:26:42', '投稿加分');
INSERT INTO `bonus_event_log` VALUES (5, 2, 50, 'CONTRIBUTE', '2020-10-08 16:30:16', '投稿加分');
INSERT INTO `bonus_event_log` VALUES (7, 10, -20, 'BY', '2020-10-15 16:39:34', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (8, 10, -25, 'BY', '2020-10-15 17:50:34', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (9, 10, -30, 'BY', '2020-10-15 17:51:27', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (10, 10, -45, 'BY', '2020-10-15 17:53:32', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (11, 10, -20, 'BY', '2020-10-15 17:54:27', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (12, 10, -25, 'BY', '2020-10-15 18:03:48', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (13, 10, -45, 'BY', '2020-10-15 18:06:33', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (14, 10, -30, 'BY', '2020-10-15 18:11:59', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (15, 10, -20, 'BY', '2020-10-15 18:12:54', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (16, 10, -45, 'BY', '2020-10-15 18:16:31', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (17, 10, -30, 'BY', '2020-10-15 18:19:59', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (18, 10, -25, 'BY', '2020-10-15 18:22:52', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (19, 10, -15, 'BY', '2020-10-15 18:24:03', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (25, 10, -5, 'BY', '2020-10-16 10:44:36', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (70, 10, 20, 'SIGN_IN', '2020-10-16 15:59:11', '签到加分');
INSERT INTO `bonus_event_log` VALUES (71, 10, 20, 'SIGN_IN', '2020-10-17 13:59:34', '签到加分');
INSERT INTO `bonus_event_log` VALUES (72, 10, 50, 'CONTRIBUTE', '2020-10-18 12:16:26', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (73, 10, 50, 'CONTRIBUTE', '2020-10-18 12:18:23', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (74, 10, 50, 'CONTRIBUTE', '2020-10-18 12:22:51', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (75, 10, 50, 'CONTRIBUTE', '2020-10-18 12:25:25', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (76, 10, 50, 'CONTRIBUTE', '2020-10-18 12:26:27', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (77, 10, 50, 'CONTRIBUTE', '2020-10-18 12:32:41', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (81, 10, -13, 'BY', '2020-10-18 13:40:43', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (82, 10, 20, 'SIGN_IN', '2020-10-18 13:43:16', '签到加分');
INSERT INTO `bonus_event_log` VALUES (83, 10, 50, 'CONTRIBUTE', '2020-10-18 13:46:57', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (84, 10, -17, 'BY', '2020-10-18 13:48:01', '兑换分享');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `wx_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信id',
  `wx_nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信昵称',
  `roles` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `bonus` int(0) NOT NULL DEFAULT 300 COMMENT '积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分享' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', 'Sunny', 'user', 'https://wanghuanle.oss-cn-beijing.aliyuncs.com/avatar/a%20%2882%29.jpg', '2020-09-15 15:22:10', '2020-09-17 15:22:15', 50);
INSERT INTO `user` VALUES (2, '2', '别来无恙', 'user', 'https://wanghuanle.oss-cn-beijing.aliyuncs.com/avatar/a%20%2881%29.jpg', '2020-09-16 15:22:57', '2020-09-24 15:23:03', 50);
INSERT INTO `user` VALUES (10, 'oHydq5MhAvnJ070bvSPKUvBJcvo0', '空白', 'roles', 'https://thirdwx.qlogo.cn/mmopen/vi_32/lY02a9xgicia8ULd3SeibTiagwsYhRTPRe8OVedIpRtLtFFLV7ze1aogZ1GR3K9btSeMkqfre1CzmdRD8VZ9Io9ZOw/132', '2020-10-14 20:24:32', '2020-10-14 20:24:32', 820);

SET FOREIGN_KEY_CHECKS = 1;
