/*
Navicat MySQL Data Transfer

Source Server         : dev-aiplatform-mgmt
Source Server Version : 50621
Source Host           : 10.1.228.202:31366
Source Database       : mgmt

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-08-05 13:10:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `company_id` varchar(64) NOT NULL COMMENT '归属公司',
  `office_id` varchar(64) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(1024) DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `tenant_id` varchar(64) DEFAULT NULL,
  `category` char(1) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `theme` varchar(16) DEFAULT NULL COMMENT '用户当前主题',
  PRIMARY KEY (`id`),
  KEY `sys_user_office_id` (`office_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '2', 'thinkgem', 'aY1RoZ2KEhzlgUmde3AWaA==', '0001', '系统管理员', '', '867533', '867533', '', '', '127.0.0.1', '2016-08-05 12:10:13', '1', '1', '2013-05-27 08:00:00', '1', '2016-01-13 09:27:55', '最高管理员', '0', 'changhong', null, null, '1970-01-01 08:00:00', '2017-01-01 08:00:00', 'cerulean');
INSERT INTO `sys_user` VALUES ('10', '7', '11', 'jn_jsb', 'jn_jsb', '0010', '济南技术部', null, null, null, null, null, '127.0.0.1', '2016-07-29 10:46:36', '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, '2016-07-01 08:00:00', '2018-01-01 08:00:00', '测试');
INSERT INTO `sys_user` VALUES ('11', '12', '13', 'lc_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0011', '济南历城领导', null, null, null, null, null, '0:0:0:0:0:0:0:1', '2016-01-08 09:20:59', '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, '2016-08-01 08:00:00', '2019-01-01 08:00:00', null);
INSERT INTO `sys_user` VALUES ('12', '12', '18', 'lx_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0012', '济南历下领导', '1011726562@qq.com', '13200', null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, '2016-08-01 08:00:00', '2019-01-01 08:00:00', null);
INSERT INTO `sys_user` VALUES ('13', '22', '23', 'gx_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0013', '济南高新领导', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '1', 'changhong', null, null, '2016-08-01 08:00:00', '2019-01-01 08:00:00', null);
INSERT INTO `sys_user` VALUES ('2', '1', '11', 'sd_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0002', '管理员', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, '2016-08-01 08:00:00', '2019-01-01 08:00:00', null);
INSERT INTO `sys_user` VALUES ('3', '1', '3', 'sd_zhb', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0003', '综合部', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('4', '1', '4', 'sd_scb', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0004', '市场部', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('5', '1', '5', 'sd_jsb', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0005', '技术部', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('6', '1', '6', 'sd_yfb', 'E10ADC3949BA59ABBE56E057F20F883E', '0006', '研发部', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('7', '7', '8', 'jn_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0007', '济南领导', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '1', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('8', '7', '9', 'jn_zhb', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0008', '济南综合部', null, null, null, null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('9', '7', '10', 'zxh', 'lueSGJZetyySpUndWjMBEg==', '0009', '济南市场部', null, null, null, null, null, '127.0.0.1', '2016-08-03 11:47:34', '1', '1', '2013-05-27 08:00:00', '1', '2016-08-03 11:47:18', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('90d42964244e4772acb52d028ef51987', '7', '11', 'meteor', 'aY1RoZ2KEhzlgUmde3AWaA==', '43434', 'zhou', '', '', '', '', '', '127.0.0.1', '2016-08-03 11:02:22', '1', '10', '2016-07-29 10:51:59', '10', '2016-07-29 10:51:59', '', '1', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('aiopt-aiplatform-id-1', '1', '6', 'user001', 'E10ADC3949BA59ABBE56E057F20F883E', '0006', '张三', 'user001@asiainfo.com', '010-82166666', '13100000000', null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('aiopt-aiplatform-id-2', '1', '6', 'user002', 'E10ADC3949BA59ABBE56E057F20F883E', '0006', '李四', 'user002@asiainfo.com', '010-82166666', '13200000000', null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('aiopt-aiplatform-id-3', '1', '6', 'user003', 'E10ADC3949BA59ABBE56E057F20F883E', '0006', '王五', 'user003@asiainfo.com', '010-82166666', '13300000000', null, null, null, null, '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0', 'changhong', null, null, null, null, null);
