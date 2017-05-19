/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : allin

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-05-19 17:02:52
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
  `remark` varchar(200) DEFAULT NULL COMMENT 'event remark',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `last_update_time` datetime DEFAULT NULL COMMENT 'last update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
