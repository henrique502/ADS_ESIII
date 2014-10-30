-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `db_gm`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consultas`
--

CREATE TABLE IF NOT EXISTS `consultas` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `medico` int(10) NOT NULL,
  `paciente` int(10) NOT NULL,
  `data` datetime NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `observacao` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medicos_has_pacientes_pacientes1_idx` (`paciente`),
  KEY `fk_medicos_has_pacientes_medicos_idx` (`medico`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

--
-- Extraindo dados da tabela `consultas`
--

INSERT INTO `consultas` (`id`, `medico`, `paciente`, `data`, `status`, `observacao`) VALUES
(1, 2, 4, '2014-10-02 20:15:00', 0, ''),
(2, 1, 4, '2014-10-02 09:20:00', 0, 'Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.'),
(3, 3, 1, '2014-10-21 16:00:00', 0, ''),
(5, 2, 1, '2014-10-21 13:20:00', 0, ''),
(6, 2, 1, '2014-10-21 13:30:00', 0, ''),
(7, 2, 1, '2014-10-21 13:40:00', 0, ''),
(8, 1, 3, '2014-10-21 13:50:00', 0, ''),
(9, 2, 1, '2014-10-21 14:00:00', 0, ''),
(10, 3, 2, '2014-10-21 14:10:00', 0, ''),
(11, 2, 1, '2014-10-21 14:20:00', 0, ''),
(12, 1, 2, '2014-10-21 14:30:00', 0, ''),
(13, 2, 3, '2014-10-21 14:40:00', 0, ''),
(14, 2, 1, '2014-10-21 14:50:00', 0, ''),
(15, 2, 1, '2014-10-21 15:00:00', 0, ''),
(16, 3, 2, '2014-10-21 15:10:00', 0, ''),
(17, 2, 1, '2014-10-21 15:20:00', 0, ''),
(18, 1, 2, '2014-10-21 15:30:00', 0, ''),
(19, 2, 3, '2014-10-21 15:40:00', 0, ''),
(20, 2, 1, '2014-10-21 15:50:00', 0, ''),
(21, 2, 1, '2014-10-21 16:00:00', 0, ''),
(22, 3, 2, '2014-10-21 16:10:00', 0, ''),
(23, 2, 1, '2014-10-21 16:20:00', 0, ''),
(24, 1, 2, '2014-10-21 16:30:00', 0, ''),
(25, 2, 3, '2014-10-21 16:40:00', 0, ''),
(26, 2, 1, '2014-10-21 16:50:00', 0, ''),
(27, 2, 1, '2014-10-21 17:00:00', 0, ''),
(28, 3, 2, '2014-10-21 17:10:00', 0, ''),
(29, 2, 1, '2014-10-21 17:20:00', 0, ''),
(30, 1, 2, '2014-10-21 17:30:00', 0, ''),
(31, 2, 3, '2014-10-21 17:40:00', 0, ''),
(32, 2, 1, '2014-10-21 17:50:00', 0, ''),
(33, 2, 1, '2014-10-21 18:00:00', 0, '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicos`
--

CREATE TABLE IF NOT EXISTS `medicos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `medicos`
--

INSERT INTO `medicos` (`id`, `nome`) VALUES
(1, 'Guilherme Silveira'),
(2, 'Henrique Gelatti'),
(3, 'Otavio Savian');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `pacientes`
--

INSERT INTO `pacientes` (`id`, `nome`) VALUES
(1, 'Adriano Casarim Duarte'),
(2, 'Lucas Bernardes'),
(3, 'Plinio Marques'),
(4, 'Fabiano Brum Fontoura');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `consultas`
--
ALTER TABLE `consultas`
  ADD CONSTRAINT `fk_medicos_has_pacientes_medicos` FOREIGN KEY (`medico`) REFERENCES `medicos` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_medicos_has_pacientes_pacientes1` FOREIGN KEY (`paciente`) REFERENCES `pacientes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
