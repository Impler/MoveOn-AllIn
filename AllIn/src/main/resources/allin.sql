/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : allin

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-11-29 17:57:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_wechat_mrgfnr
-- ----------------------------
DROP TABLE IF EXISTS `t_wechat_mrgfnr`;
CREATE TABLE `t_wechat_mrgfnr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key, serial number',
  `user_id` varchar(32) DEFAULT NULL COMMENT 'the user id',
  `name` varchar(32) DEFAULT NULL COMMENT 'event name',
  `type` tinyint(11) DEFAULT NULL COMMENT 'event type id',
  `date` date DEFAULT NULL COMMENT 'date of the event',
  `fee` float DEFAULT NULL COMMENT 'the costs',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `last_update_time` datetime DEFAULT NULL COMMENT 'last update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wechat_mrgfnr
-- ----------------------------
INSERT INTO `t_wechat_mrgfnr` VALUES ('1', '10001', 'testname', '1', '2016-11-29', '1212', '2016-11-29 10:01:42', '2016-11-29 10:01:45');
