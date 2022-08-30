-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.17-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for sistema_evaluacion
CREATE DATABASE IF NOT EXISTS `sistema_evaluacion` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `sistema_evaluacion`;

-- Dumping structure for table sistema_evaluacion.rols
CREATE TABLE IF NOT EXISTS `rols` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table sistema_evaluacion.rols: ~0 rows (approximately)
/*!40000 ALTER TABLE `rols` DISABLE KEYS */;
INSERT INTO `rols` (`id`, `name`) VALUES
	(1, 'administrador'),
	(2, 'normal');
/*!40000 ALTER TABLE `rols` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `profile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table sistema_evaluacion.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.users_rols
CREATE TABLE IF NOT EXISTS `users_rols` (
  `user_id` bigint(20) NOT NULL,
  `rol_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rol_id`,`user_id`),
  KEY `FKeck3xcnvcvc3wuyytw9lcribr` (`user_id`),
  CONSTRAINT `FKeck3xcnvcvc3wuyytw9lcribr` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKgr0k3ky7tj1046wywamix34sp` FOREIGN KEY (`rol_id`) REFERENCES `rols` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table sistema_evaluacion.users_rols: ~0 rows (approximately)
/*!40000 ALTER TABLE `users_rols` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_rols` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
rolssistema_evaluacionrols