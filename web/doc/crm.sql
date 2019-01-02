/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-14 14:40:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_care
-- ----------------------------
DROP TABLE IF EXISTS `customer_care`;
CREATE TABLE `customer_care` (
  `care_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `care_theme` varchar(50) DEFAULT NULL,
  `care_way` varchar(50) DEFAULT NULL,
  `care_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `care_remark` varchar(1000) DEFAULT NULL,
  `care_nexttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `care_people` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`care_id`),
  KEY `FK_Reference_15` (`customer_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_condition
-- ----------------------------
DROP TABLE IF EXISTS `customer_condition`;
CREATE TABLE `customer_condition` (
  `condition_id` int(10) NOT NULL AUTO_INCREMENT,
  `condition_name` varchar(50) DEFAULT NULL,
  `condition_explain` varchar(1000) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`condition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `condition_id` int(10) DEFAULT NULL,
  `source_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `type_id` int(10) DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `customer_sex` varchar(10) DEFAULT NULL,
  `customer_mobile` varchar(20) DEFAULT NULL,
  `customer_qq` varchar(20) DEFAULT NULL,
  `customer_address` varchar(500) DEFAULT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `customer_remark` varchar(1000) DEFAULT NULL,
  `customer_job` varchar(100) DEFAULT NULL,
  `customer_blog` varchar(100) DEFAULT NULL,
  `customer_tel` varbinary(20) DEFAULT NULL,
  `customer_msn` varchar(50) DEFAULT NULL,
  `birth_day` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `customer_addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `customer_addman` varchar(50) DEFAULT NULL,
  `customer_changtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `change_man` varchar(20) DEFAULT NULL,
  `customer_company` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`customer_id`),
  KEY `FK_Reference_16` (`condition_id`),
  KEY `FK_Reference_17` (`source_id`),
  KEY `FK_Reference_18` (`type_id`),
  KEY `FK_Reference_23` (`user_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`condition_id`) REFERENCES `customer_condition` (`condition_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`source_id`) REFERENCES `customer_source` (`source_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`type_id`) REFERENCES `customer_type` (`type_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_linkman
-- ----------------------------
DROP TABLE IF EXISTS `customer_linkman`;
CREATE TABLE `customer_linkman` (
  `linkman_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `linkman_name` varchar(50) DEFAULT NULL,
  `linkman_sex` varchar(20) DEFAULT NULL,
  `linkman_job` varchar(100) DEFAULT NULL,
  `linkman_mobile` varchar(20) DEFAULT NULL,
  `linkman_age` int(10) DEFAULT NULL,
  `linkman_relation` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`linkman_id`),
  KEY `FK_Reference_20` (`customer_id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_linkreord
-- ----------------------------
DROP TABLE IF EXISTS `customer_linkreord`;
CREATE TABLE `customer_linkreord` (
  `record_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `link_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `who_link` varchar(50) DEFAULT NULL,
  `link_type` varchar(50) DEFAULT NULL,
  `link_theme` varchar(200) DEFAULT NULL,
  `link_nexttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `link_remark` varchar(1000) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`record_id`),
  KEY `FK_Reference_19` (`customer_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_source
-- ----------------------------
DROP TABLE IF EXISTS `customer_source`;
CREATE TABLE `customer_source` (
  `source_id` int(10) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_type
-- ----------------------------
DROP TABLE IF EXISTS `customer_type`;
CREATE TABLE `customer_type` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `department_id` int(10) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) DEFAULT NULL,
  `department_desc` varchar(500) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for email_info
-- ----------------------------
DROP TABLE IF EXISTS `email_info`;
CREATE TABLE `email_info` (
  `email_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `email_content` varchar(2000) DEFAULT NULL,
  `email_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `email_state` varchar(50) DEFAULT NULL,
  `email_theme` varchar(200) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`email_id`),
  KEY `FK_Reference_14` (`user_id`),
  KEY `FK_Reference_21` (`customer_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for house_info
-- ----------------------------
DROP TABLE IF EXISTS `house_info`;
CREATE TABLE `house_info` (
  `house_id` int(10) NOT NULL AUTO_INCREMENT,
  `type_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `house_address` varchar(500) DEFAULT NULL,
  `house_price` int(20) DEFAULT NULL,
  `house_ambient` varchar(1000) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`house_id`),
  KEY `FK_Reference_13` (`user_id`),
  KEY `FK_Reference_26` (`type_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`type_id`) REFERENCES `house_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for house_type
-- ----------------------------
DROP TABLE IF EXISTS `house_type`;
CREATE TABLE `house_type` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notice_info
-- ----------------------------
DROP TABLE IF EXISTS `notice_info`;
CREATE TABLE `notice_info` (
  `notice_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `notice_item` varchar(100) DEFAULT NULL,
  `notice_content` varchar(2000) DEFAULT NULL,
  `notice_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `notice_endtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`notice_id`),
  KEY `FK_Reference_12` (`user_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `department_id` int(10) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_mobile` varchar(20) DEFAULT NULL,
  `user_age` int(10) DEFAULT NULL,
  `user_address` varchar(500) DEFAULT NULL,
  `user_num` varchar(100) DEFAULT NULL,
  `user_pw` varchar(50) DEFAULT NULL,
  `user_tel` varchar(20) DEFAULT NULL,
  `user_idnum` varchar(20) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_addman` varchar(50) DEFAULT NULL,
  `user_changetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_changeman` varchar(50) DEFAULT NULL,
  `user_intest` varchar(1000) DEFAULT NULL,
  `user_diploma` varchar(20) DEFAULT NULL,
  `user_bankcard` varchar(20) DEFAULT NULL,
  `user_nation` varchar(20) DEFAULT NULL,
  `is_married` varchar(10) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_22` (`department_id`),
  KEY `FK_Reference_24` (`role_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`department_id`) REFERENCES `department_info` (`department_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `role_power` int(10) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
