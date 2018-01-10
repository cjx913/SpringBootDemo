/*
Navicat MySQL Data Transfer

Source Server         : MySQL_cjx913
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : movie

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-01-10 21:00:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `born` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of actor
-- ----------------------------
INSERT INTO `actor` VALUES ('5', '1989-05-30 00:00:00', '石川由依', '1');
INSERT INTO `actor` VALUES ('6', '1967-05-05 00:00:00', '子安武人', '0');
INSERT INTO `actor` VALUES ('7', '1976-03-29 00:00:00', '浪川大辅', '0');
INSERT INTO `actor` VALUES ('8', '1980-02-17 00:00:00', '远藤绫', '1');

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `show_data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('2', '紫罗兰永恒花园', '/images/ziluolanyonghenghuayuan.jpg', '2018-01-10 00:00:00');
INSERT INTO `movie` VALUES ('5', 'cccc', '/images/ziluolanyonghenghuayuan.jpg', '2018-01-13 00:00:00');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `actor_id` bigint(20) DEFAULT NULL,
  `movie_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_awl16vpxgvc4cibpo0w02nqat` (`actor_id`),
  KEY `FKowvo6n9ya7131krugjgxb2ua8` (`movie_id`),
  CONSTRAINT `FKhcvuc3dt3u55owiv7hblb5lfe` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`),
  CONSTRAINT `FKowvo6n9ya7131krugjgxb2ua8` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('5', '薇尔莉特·伊芙加登', '5', '2');
INSERT INTO `role` VALUES ('6', '克劳迪亚·霍金斯', '6', '2');
INSERT INTO `role` VALUES ('7', '基尔伯特·布甘比利亚', '7', '2');
INSERT INTO `role` VALUES ('8', '嘉德丽雅·波德莱尔', '8', '2');
