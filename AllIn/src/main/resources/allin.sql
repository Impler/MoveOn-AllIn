/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : allin

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-10-11 17:29:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_auth_login_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_login_detail`;
CREATE TABLE `t_auth_login_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顺序编号',
  `username` varchar(64) DEFAULT NULL COMMENT '登录名',
  `ip` varchar(20) DEFAULT NULL COMMENT '登录ip',
  `login_device` varchar(255) DEFAULT NULL COMMENT '登录设备',
  `login_status` int(11) DEFAULT NULL COMMENT '登录状态',
  `login_exception` varchar(100) DEFAULT NULL COMMENT '登录异常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_login_detail
-- ----------------------------
INSERT INTO `t_auth_login_detail` VALUES ('15', 'admin', '127.0.0.1', null, '0', 'IncorrectCredentialsException', '2017-10-11 16:22:09');
INSERT INTO `t_auth_login_detail` VALUES ('16', 'admin', '127.0.0.1', null, '1', null, '2017-10-11 16:22:18');

-- ----------------------------
-- Table structure for t_auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_resource`;
CREATE TABLE `t_auth_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `name` varchar(30) DEFAULT NULL COMMENT '资源名称',
  `description` varchar(50) DEFAULT NULL COMMENT '资源描述',
  `type` int(10) DEFAULT NULL COMMENT '资源类型 1 menu; 2 link',
  `url` varchar(50) DEFAULT NULL COMMENT '资源路径',
  `url_style` int(11) DEFAULT NULL COMMENT 'url类型：1 字面值Url，2 Ant Url',
  `method` varchar(10) DEFAULT NULL COMMENT '请求方式',
  `seq` int(11) DEFAULT '0' COMMENT '顺序',
  `level` int(11) DEFAULT NULL COMMENT '资源级别',
  `parent_id` int(11) DEFAULT NULL COMMENT 'parent resource id',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_resource
-- ----------------------------
INSERT INTO `t_auth_resource` VALUES ('1', 'dashboard', 'dashboard', '2', '/auth/index.do', '1', 'GET', '0', null, null, null);
INSERT INTO `t_auth_resource` VALUES ('3', '角色管理', '角色管理', '1', '/auth/role.do', '1', 'GET', '0', '1', null, null);
INSERT INTO `t_auth_resource` VALUES ('4', '权限管理', '权限管理', '1', '/auth/resource.do', '1', 'GET', '0', '1', null, null);
INSERT INTO `t_auth_resource` VALUES ('5', '用户管理', '用户管理', '1', '/auth/user.do', '1', 'GET', '0', '1', null, null);

-- ----------------------------
-- Table structure for t_auth_resource_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_resource_ref`;
CREATE TABLE `t_auth_resource_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` int(11) DEFAULT NULL COMMENT '关联类型 1 user-role; 2 role-resource',
  `left_value` int(11) DEFAULT NULL COMMENT '左值',
  `right_value` int(11) DEFAULT NULL COMMENT '右值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_resource_ref
-- ----------------------------
INSERT INTO `t_auth_resource_ref` VALUES ('1', '1', '1', '1');
INSERT INTO `t_auth_resource_ref` VALUES ('3', '1', '1', '2');
INSERT INTO `t_auth_resource_ref` VALUES ('6', '2', '1', '3');
INSERT INTO `t_auth_resource_ref` VALUES ('8', '2', '2', '4');
INSERT INTO `t_auth_resource_ref` VALUES ('9', '2', '2', '5');
INSERT INTO `t_auth_resource_ref` VALUES ('11', '2', '1', '1');

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
-- Records of t_auth_role
-- ----------------------------
INSERT INTO `t_auth_role` VALUES ('1', '管理员角色', '管理员角色');
INSERT INTO `t_auth_role` VALUES ('32', '超级管理员', '超级管理员角色');
INSERT INTO `t_auth_role` VALUES ('33', '管理员角色', '管理员角色');
INSERT INTO `t_auth_role` VALUES ('34', 'string', 'string');
INSERT INTO `t_auth_role` VALUES ('35', 'string', 'string');
INSERT INTO `t_auth_role` VALUES ('36', '管理员角色', '管理员角色');
INSERT INTO `t_auth_role` VALUES ('37', '超级管理员', '超级管理员角色');
INSERT INTO `t_auth_role` VALUES ('38', 'n1', 'd1');
INSERT INTO `t_auth_role` VALUES ('39', '管理员角色', '管理员角色');

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
  `mobile_number` varchar(15) DEFAULT NULL COMMENT '登录失败次数',
  `login_failed_times` int(11) unsigned zerofill DEFAULT NULL,
  `is_locked` int(11) DEFAULT NULL COMMENT '是否锁定',
  `locked_time` datetime DEFAULT NULL COMMENT '锁定时间',
  `is_active` int(11) DEFAULT NULL COMMENT '是否激活',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_user
-- ----------------------------
INSERT INTO `t_auth_user` VALUES ('1', 'admin', 'administrator', 'e060fc011c4f570bd91d1ce88c5bbc83', '6ce2c83b783b4567a73e0611ef0706e5', 'test@qq.com', '18761876537', '00000000000', '0', null, '1', null);

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

-- ----------------------------
-- Records of t_wechat_mrgfnr
-- ----------------------------
INSERT INTO `t_wechat_mrgfnr` VALUES ('1', '1', 'a', '1', '2017-02-06', '12', null, '2017-02-06 14:36:04', '2017-02-06 14:36:07');
INSERT INTO `t_wechat_mrgfnr` VALUES ('2', '2', 'b', '1', '2017-02-06', '23', '你好', '2017-02-06 14:36:21', '2017-02-07 15:16:47');
INSERT INTO `t_wechat_mrgfnr` VALUES ('7', null, '里面', '1', '2017-02-07', '946', 'MSN', '2017-02-07 11:20:24', '2017-02-07 11:20:24');
INSERT INTO `t_wechat_mrgfnr` VALUES ('8', null, '你们', '1', '2017-02-07', '976', '小婆婆', '2017-02-07 11:24:25', '2017-02-07 11:24:25');
INSERT INTO `t_wechat_mrgfnr` VALUES ('9', null, '男人无所谓', '1', '2017-02-07', '9797', '和我一起', '2017-02-07 11:32:13', '2017-02-07 11:32:13');
INSERT INTO `t_wechat_mrgfnr` VALUES ('10', null, '你好', '1', '2017-02-07', '9766', '我去', '2017-02-07 14:07:14', '2017-02-07 15:16:00');
INSERT INTO `t_wechat_mrgfnr` VALUES ('11', null, '一上午', '1', '2017-02-05', '676', '替你', '2017-02-07 14:07:44', '2017-02-07 14:07:44');
INSERT INTO `t_wechat_mrgfnr` VALUES ('12', null, '民俗', '1', '2017-02-07', '346', '温柔', '2017-02-07 15:17:34', '2017-02-07 15:17:34');
