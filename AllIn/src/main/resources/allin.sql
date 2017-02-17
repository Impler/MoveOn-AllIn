/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : allin

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-01-22 11:11:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_permission`;
CREATE TABLE `t_auth_permission` (
  `id` int(11) NOT NULL COMMENT 'permission id',
  `name` varchar(50) DEFAULT NULL COMMENT 'permission name',
  `level` int(11) DEFAULT NULL COMMENT 'permission level',
  `path` varchar(50) DEFAULT NULL COMMENT 'permission path',
  `type` varchar(10) DEFAULT NULL COMMENT 'request method（get/post/delete/put）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_role`;
CREATE TABLE `t_auth_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'role id',
  `name` varchar(30) DEFAULT NULL COMMENT 'role name',
  `description` varchar(64) DEFAULT NULL COMMENT 'role description',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_user`;
CREATE TABLE `t_auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `username` varchar(32) DEFAULT NULL COMMENT 'username',
  `nickname` varchar(50) DEFAULT NULL COMMENT 'useralt nick name',
  `password` varchar(64) DEFAULT NULL COMMENT 'user password',
  `salt` varchar(64) DEFAULT NULL COMMENT 'user password salt',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_auth_resource_ref`;
CREATE TABLE `t_auth_resource_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` int(11) DEFAULT NULL COMMENT 'reference type',
  `left_value` int(11) DEFAULT NULL COMMENT 'key',
  `right_value` int(11) DEFAULT NULL COMMENT 'reference value',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

