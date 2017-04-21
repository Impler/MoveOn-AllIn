/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : allin

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-04-21 17:49:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_resource`;
CREATE TABLE `t_auth_resource` (
  `id` int(11) NOT NULL COMMENT '资源编号',
  `name` varchar(30) DEFAULT NULL COMMENT '资源名称',
  `description` varchar(50) DEFAULT NULL COMMENT '资源描述',
  `type` int(10) DEFAULT NULL COMMENT '资源类型',
  `level` int(11) DEFAULT NULL COMMENT '资源级别',
  `url` varchar(50) DEFAULT NULL COMMENT '资源路径',
  `url_type` int(11) DEFAULT NULL COMMENT 'url类型：1 字面值Url，2 Ant Url',
  `seq` int(11) DEFAULT '0' COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_resource_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_resource_ref`;
CREATE TABLE `t_auth_resource_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` int(11) DEFAULT NULL COMMENT '关联类型',
  `left_value` int(11) DEFAULT NULL COMMENT '左值',
  `right_value` int(11) DEFAULT NULL COMMENT '右值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_role`;
CREATE TABLE `t_auth_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(64) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_user`;
CREATE TABLE `t_auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '密码盐值',
  `email_address` varchar(30) DEFAULT NULL,
  `mobile_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
