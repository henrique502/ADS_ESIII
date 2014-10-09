/*
Navicat MySQL Data Transfer

Source Server         : _localhost
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : db_gm

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-09-24 22:04:39
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `medicos`
-- ----------------------------
DROP TABLE IF EXISTS `medicos`;
CREATE TABLE `medicos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicos
-- ----------------------------
INSERT INTO `medicos` VALUES ('1', 'Guilherme Silveira');
INSERT INTO `medicos` VALUES ('2', 'Henrique Gelatti');
INSERT INTO `medicos` VALUES ('3', 'Otavio Savian');

-- ----------------------------
-- Table structure for `pacientes`
-- ----------------------------
DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pacientes
-- ----------------------------
INSERT INTO `pacientes` VALUES ('1', 'Adriano Casarim Duarte');
INSERT INTO `pacientes` VALUES ('2', 'Lucas Bernardes');
INSERT INTO `pacientes` VALUES ('3', 'Plinio Marques');
INSERT INTO `pacientes` VALUES ('4', 'Fabiano Brum Fontoura');

-- ----------------------------
-- Table structure for `consultas`
-- ----------------------------
DROP TABLE IF EXISTS `consultas`;
CREATE TABLE `consultas` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `medico` int(10) NOT NULL,
  `paciente` int(10) NOT NULL,
  `data` datetime NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `observacao` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medicos_has_pacientes_pacientes1_idx` (`paciente`),
  KEY `fk_medicos_has_pacientes_medicos_idx` (`medico`),
  CONSTRAINT `fk_medicos_has_pacientes_medicos` FOREIGN KEY (`medico`) REFERENCES `medicos` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicos_has_pacientes_pacientes1` FOREIGN KEY (`paciente`) REFERENCES `pacientes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consultas
-- ----------------------------
INSERT INTO `consultas` VALUES ('1', '2', '4', '2014-10-09 20:15:00', '0', '');
INSERT INTO `consultas` VALUES ('2', '3', '2', '2014-10-09 20:40:00', '0', 'Ira se atrazar');