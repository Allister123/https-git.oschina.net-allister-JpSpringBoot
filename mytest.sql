/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-07-28 15:00:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jp_user
-- ----------------------------
DROP TABLE IF EXISTS `jp_user`;
CREATE TABLE `jp_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(1) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT '88888888',
  `age` int(3) DEFAULT '0',
  `address` varchar(200) DEFAULT '中国',
  `forbiden` int(1) DEFAULT NULL,
  `male` int(1) DEFAULT '1',
  `birthday` date DEFAULT NULL,
  `header_pic` varchar(200) DEFAULT NULL,
  `questionone` int(3) DEFAULT NULL,
  `questiontwo` int(3) DEFAULT NULL,
  `answerone` varchar(100) DEFAULT NULL,
  `answertwo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `jp_user_email_password` (`email`,`password`,`is_delete`,`forbiden`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jp_user
-- ----------------------------
INSERT INTO `jp_user` VALUES ('36', '阿龙', '123456', 'test@ic2c.cc', '2016-12-25 22:44:34', '2016-04-22 14:15:24', '0', '888888888888', '22', '中国深圳', '1', '1', '0000-00-00', 'avatar.png', '0', '4', ' ', ' ');
