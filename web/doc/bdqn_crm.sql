/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : bdqn_crm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-01-25 09:18:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_care
-- ----------------------------
DROP TABLE IF EXISTS `customer_care`;
CREATE TABLE `customer_care` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(11) DEFAULT NULL,
  `theme` varchar(50) DEFAULT NULL,
  `way` varchar(50) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(1000) DEFAULT NULL,
  `next_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `people` varchar(50) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_care
-- ----------------------------
INSERT INTO `customer_care` VALUES ('4', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('5', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('6', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('7', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('8', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('9', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('10', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('11', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('22', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('23', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('24', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('25', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('26', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('27', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('28', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('29', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('30', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');
INSERT INTO `customer_care` VALUES ('31', '4', '生日', '发短信', '2019-01-04 00:00:00', '的', '2019-01-12 00:00:00', '的', '0');

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `condition_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` int(10) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL,
  `blog` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `wechat` varchar(50) DEFAULT NULL,
  `birth_day` date DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_man` varchar(50) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_man` varchar(20) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('4', '16', '13', '-1', '20', '王小明', '1', '13677603400', '12312312', '重庆市', '996052600@qq.com', '2对方', '职员', 'as12', '023-123123', '123', '2019-01-12', '2019-01-25 09:17:56', '黎林', '2019-01-25 09:17:56', '平头哥', '重庆', '1');
INSERT INTO `customer_info` VALUES ('32', '15', '11', '18', '18', '刘明', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-24 09:27:09', '小明', '2019-01-24 09:27:09', '小明', '北大青鸟', '0');
INSERT INTO `customer_info` VALUES ('33', '17', '11', '15', '20', '小张', '1', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-23 21:55:46', '小明', '2019-01-23 11:52:00', '小明', '北大青鸟', '1');
INSERT INTO `customer_info` VALUES ('34', '15', '11', '18', '18', '常出现', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-24 12:11:53', '小明', '2019-01-24 12:11:53', '小明', '北大青鸟', '0');
INSERT INTO `customer_info` VALUES ('37', '15', '11', '15', '18', '小明01', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-23 11:52:00', '小明', '2019-01-23 11:52:00', '小明', '北大青鸟', '0');
INSERT INTO `customer_info` VALUES ('38', '15', '11', '15', '18', '小明01', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-23 11:52:00', '小明', '2019-01-23 11:52:00', '小明', '北大青鸟', '0');
INSERT INTO `customer_info` VALUES ('39', '15', '11', '15', '18', '小明01', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-23 11:52:00', '小明', '2019-01-23 11:52:00', '小明', '北大青鸟', '0');
INSERT INTO `customer_info` VALUES ('40', '15', '11', '15', '18', '小明01', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-23 11:52:00', '小明', '2019-01-23 11:52:00', '小明', '北大青鸟', '0');
INSERT INTO `customer_info` VALUES ('41', '15', '11', '15', '18', '小明02', '0', '13677603400', '12312323', '重庆红旗河沟', '234324@qq.com', '测试数据1', '普通职员', 'cccc', '023-123124321', 'weixinw', '2019-01-25', '2019-01-23 11:52:00', '小明', '2019-01-23 11:52:00', '小明', '北大青鸟', '0');

-- ----------------------------
-- Table structure for customer_linkman
-- ----------------------------
DROP TABLE IF EXISTS `customer_linkman`;
CREATE TABLE `customer_linkman` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `relation` varchar(50) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_linkman
-- ----------------------------
INSERT INTO `customer_linkman` VALUES ('1', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('2', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('3', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('4', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('5', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('6', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('8', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('9', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('10', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('12', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('13', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('14', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('15', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('16', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');
INSERT INTO `customer_linkman` VALUES ('17', '4', '李世民', '男', '皇帝', '13677603400', '30', '朋友', '0');

-- ----------------------------
-- Table structure for customer_linkreord
-- ----------------------------
DROP TABLE IF EXISTS `customer_linkreord`;
CREATE TABLE `customer_linkreord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `who_link` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `theme` varchar(200) DEFAULT NULL,
  `next_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `remark` varchar(1000) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_linkreord
-- ----------------------------
INSERT INTO `customer_linkreord` VALUES ('5', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('6', '4', '2019-01-05 00:00:00', '水电费', '自己上门', '讯买买房', '2019-01-31 00:00:00', '第三方', '0');
INSERT INTO `customer_linkreord` VALUES ('7', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('9', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('11', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('12', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('13', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('14', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('15', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('16', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('17', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('18', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');
INSERT INTO `customer_linkreord` VALUES ('19', '4', '2019-01-09 00:00:00', '张飞', '自己上门', '购房意向', '2019-01-31 00:00:00', '购房意向明确', '0');

-- ----------------------------
-- Table structure for dic_item
-- ----------------------------
DROP TABLE IF EXISTS `dic_item`;
CREATE TABLE `dic_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dic_item
-- ----------------------------
INSERT INTO `dic_item` VALUES ('11', '3', '自己上门', '', '0');
INSERT INTO `dic_item` VALUES ('12', '3', '朋友推荐', '', '0');
INSERT INTO `dic_item` VALUES ('13', '3', '网络媒体', '', '0');
INSERT INTO `dic_item` VALUES ('14', '3', '线下广告', '', '0');
INSERT INTO `dic_item` VALUES ('15', '7', '潜在客户', '', '0');
INSERT INTO `dic_item` VALUES ('16', '7', '意向客户', '', '0');
INSERT INTO `dic_item` VALUES ('17', '7', '交易客户', '', '0');
INSERT INTO `dic_item` VALUES ('18', '6', '客户', '', '0');
INSERT INTO `dic_item` VALUES ('19', '6', '合作伙伴', '', '0');
INSERT INTO `dic_item` VALUES ('20', '6', '供应商', '', '0');
INSERT INTO `dic_item` VALUES ('24', '10', '三室一厅', '', '0');
INSERT INTO `dic_item` VALUES ('25', '10', '三室两厅', '', '0');
INSERT INTO `dic_item` VALUES ('26', '10', '两室两厅', '', '0');
INSERT INTO `dic_item` VALUES ('27', '10', '两室一厅', '', '0');
INSERT INTO `dic_item` VALUES ('28', '10', '四室两厅', '', '0');

-- ----------------------------
-- Table structure for dic_type
-- ----------------------------
DROP TABLE IF EXISTS `dic_type`;
CREATE TABLE `dic_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `key` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dic_type
-- ----------------------------
INSERT INTO `dic_type` VALUES ('2', '民族', null, null, '0');
INSERT INTO `dic_type` VALUES ('3', '客户来源', 'CUSTOMER_SOURCE', null, '0');
INSERT INTO `dic_type` VALUES ('6', '客户类型', 'CUSTOMER_TYPE', '客户类型', '0');
INSERT INTO `dic_type` VALUES ('7', '客户状态', 'CUSTOMER_CONDITION', '表示客户当前购房意向', '0');
INSERT INTO `dic_type` VALUES ('10', '房屋类型', 'HOUSE_TYPE', '', '0');

-- ----------------------------
-- Table structure for email_info
-- ----------------------------
DROP TABLE IF EXISTS `email_info`;
CREATE TABLE `email_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `theme` varchar(200) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` int(2) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_info
-- ----------------------------
INSERT INTO `email_info` VALUES ('7', '4', '15', '1', '2', '2019-01-24 17:15:12', '0', '0');
INSERT INTO `email_info` VALUES ('8', '4', '15', '22', '33', '2019-01-24 17:13:54', '0', '0');
INSERT INTO `email_info` VALUES ('9', '4', '15', '11', '22', '2019-01-24 17:03:43', '0', '0');
INSERT INTO `email_info` VALUES ('11', '4', '15', '11', '22312', '2019-01-24 16:38:00', '0', '0');
INSERT INTO `email_info` VALUES ('12', '4', '15', '测试发送', '测试发送内容', '2019-01-24 16:51:00', '0', '0');

-- ----------------------------
-- Table structure for houser_info
-- ----------------------------
DROP TABLE IF EXISTS `houser_info`;
CREATE TABLE `houser_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(2) DEFAULT NULL,
  `user_id` bigint(2) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `price` int(12) DEFAULT NULL COMMENT '房屋价格，单位M元/平米',
  `ambient` varchar(1000) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of houser_info
-- ----------------------------
INSERT INTO `houser_info` VALUES ('1', '24', '-1', '重庆红旗河沟', '1000', '大法师', '0');
INSERT INTO `houser_info` VALUES ('2', '24', '15', '重庆市第三方', '10000', '江景房', '0');

-- ----------------------------
-- Table structure for notice_info
-- ----------------------------
DROP TABLE IF EXISTS `notice_info`;
CREATE TABLE `notice_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `item` varchar(100) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice_info
-- ----------------------------
INSERT INTO `notice_info` VALUES ('4', '15', '房子大减价', '统统10块', '2019-01-01 00:00:00', '2019-01-27 00:00:00', '0');
INSERT INTO `notice_info` VALUES ('5', '15', '房子买一送一', '房子不要钱，买一送一', '2019-01-24 00:00:00', '2019-01-31 00:00:00', '0');
INSERT INTO `notice_info` VALUES ('6', '15', '房子促销活动', '房子促销活动', '2019-01-11 00:00:00', '2019-01-26 00:00:00', '0');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `role_power` int(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `num` varchar(100) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `idnum` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_man` varchar(50) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_man` varchar(50) DEFAULT NULL,
  `hobby` varchar(300) DEFAULT NULL,
  `diploma` varchar(20) DEFAULT NULL,
  `bank_card` varchar(20) DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `married` int(2) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('7', '估计要删', '0', '0', '平头哥', '1', '13677603400', '21', '重庆市渝北区', '100000', '123456', '023-12431256', '500231199803126052', '996052600@qq.com', '2019-01-25 09:16:42', '刘德华', '2019-01-13 15:19:13', '刘德华', '篮球,足球,羽毛球', '1', '100000000000000', '1', '1', '0');
INSERT INTO `user_info` VALUES ('8', '估计要删', '1', '0', '张三', '1', '13677603400', '31', '重庆市渝北区', '100007', '123456', '023-12431256', '500231198803126052', '996052600@qq.com', '2019-01-25 09:05:42', '刘德华', '2019-01-13 15:20:00', '刘德华', '篮球,足球,羽毛球', '1', '100000000000000', '0', '1', '0');
INSERT INTO `user_info` VALUES ('11', '估计要删', '1', '0', '黎林', '0', '13677603400', '20', '重庆市渝北区', '100009', '123456', '023-12431256', '500231199903126052', '996052600@qq.com', '2019-01-25 09:05:43', '黎林', '2019-01-13 15:27:14', '黎林', '篮球,足球,羽毛球', '0', '100000000000000', '0', '0', '0');
INSERT INTO `user_info` VALUES ('15', '估计要删', '1', '0', '小明', '0', '13677603400', '26', '重庆市渝北区', '100010', '123456', '023-12431256', '500231199303126052', '996052600@qq.com', '2019-01-25 09:16:38', '黎林', '2019-01-13 17:40:16', '黎林', '篮球,足球,羽毛球', '0', '100000000000000', '0', '0', '0');
INSERT INTO `user_info` VALUES ('16', '估计要删', '1', '0', '刘德华', '0', '13677603400', '26', '重庆市渝北区', '100012', '123456', '023-12431256', '500231199303126052', '996052600@qq.com', '2019-01-25 09:16:44', '小明', '2019-01-23 09:34:00', '小明', '篮球,足球,羽毛球', '0', '100000000000000', '0', '0', '0');
INSERT INTO `user_info` VALUES ('18', '估计要删', '1', '0', '张学友', '0', '13677603400', '26', '重庆市渝北区', '100014', '123456', '023-12431256', '500231199303126052', '996052600@qq.com', '2019-01-25 09:15:59', '小明', '2019-01-23 09:35:00', '小明', '篮球,足球,羽毛球', '0', '100000000000000', '0', '0', '0');
INSERT INTO `user_info` VALUES ('19', '估计要删', '1', '0', '郭富城', '0', '13677603400', '26', '重庆市渝北区', '100015', '123456', '023-12431256', '500231199303126052', '996052600@qq.com', '2019-01-25 09:16:02', '小明', '2019-01-23 09:35:00', '小明', '篮球,足球,羽毛球', '0', '100000000000000', '0', '0', '0');
INSERT INTO `user_info` VALUES ('21', '估计要删', '1', '0', '刘德华弟弟', '0', '13677603400', '26', '重庆市渝北区', '100017', '123456', '023-12431256', '500231199303126052', '996052600@qq.com', '2019-01-25 09:16:13', '小明', '2019-01-23 09:35:00', '小明', '篮球,足球,羽毛球', '0', '100000000000000', '0', '0', '0');
DROP TRIGGER IF EXISTS `no_num`;
DELIMITER ;;
CREATE TRIGGER `no_num` BEFORE INSERT ON `user_info` FOR EACH ROW BEGIN
	DECLARE
		n INT;
	SELECT
		IFNULL(MAX(ui.num+1), '100000') INTO n
	FROM user_info AS ui;
	SET  NEW.num = concat(n,'') ;
 
END
;;
DELIMITER ;
