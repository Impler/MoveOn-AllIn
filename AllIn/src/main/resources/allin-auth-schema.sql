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
-- Table structure for t_auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_resource`;
CREATE TABLE `t_auth_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `name` varchar(30) DEFAULT NULL COMMENT '资源名称',
  `description` varchar(50) DEFAULT NULL COMMENT '资源描述',
  `type` int(10) DEFAULT NULL COMMENT '资源类型',
  `url` varchar(50) DEFAULT NULL COMMENT '资源路径',
  `url_style` int(11) DEFAULT NULL COMMENT 'url类型：1 字面值Url，2 Ant Url',
  `method` varchar(10) DEFAULT NULL COMMENT '请求方式',
  `seq` int(11) DEFAULT '0' COMMENT '顺序',
  `level` int(11) DEFAULT NULL COMMENT '资源级别',
  `parent_id` int(11) DEFAULT NULL COMMENT 'parent resource id',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

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
