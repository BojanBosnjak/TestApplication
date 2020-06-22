CREATE DATABASE  IF NOT EXISTS `cyrillics` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `cyrillics`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: bojanmysql.mysql.database.azure.com    Database: cyrillics
-- ------------------------------------------------------
-- Server version	5.6.42.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `UK_jfarbv64d68y4tm9c9ms5fh7b` (`account_name`),
  KEY `FK7m8ru44m93ukyb61dfxw0apf6` (`user_id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) /*!50100 TABLESPACE `innodb_system` */ ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'account1',5),(2,'account2',6),(6,'account6',3),(7,'account7',4);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_crkjmjk1oj8gb6j6t5kt7gcxm` (`name`),
  KEY `FKn9x2k8svpxj3r328iy1rpur83` (`account_id`),
  CONSTRAINT `FKn9x2k8svpxj3r328iy1rpur83` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE
) /*!50100 TABLESPACE `innodb_system` */ ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'customer1',1),(2,'customer2',2),(8,'customer7',6),(9,'customer10',7);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farm`
--

DROP TABLE IF EXISTS `farm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farm` (
  `farm_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`farm_id`),
  UNIQUE KEY `UK_gsdkhedj9vcy5hlihk2533mv0` (`name`),
  KEY `FKg6i87mvm9ba5m0yuf7f4ih720` (`account_id`),
  KEY `FKoe5kxt8uypeompw71ylg5c48w` (`user_id`),
  CONSTRAINT `FKg6i87mvm9ba5m0yuf7f4ih720` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKoe5kxt8uypeompw71ylg5c48w` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) /*!50100 TABLESPACE `innodb_system` */ ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farm`
--

LOCK TABLES `farm` WRITE;
/*!40000 ALTER TABLE `farm` DISABLE KEYS */;
INSERT INTO `farm` VALUES (1,'farm1',1,4),(3,'farm3',1,4),(4,'farm4',7,8),(5,'farm5',2,8),(6,'farm6',6,3),(10,'farm11',2,7);
/*!40000 ALTER TABLE `farm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` tinyint(4) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`)
) /*!50100 TABLESPACE `innodb_system` */ ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'$2a$10$rzYmSYvtgHaji6SmtbPvPepZI/B9Wn.BgRugB3GkweUkiLbQlYB7i','ROLE_USER','user1'),(3,1,'$2a$10$rzYmSYvtgHaji6SmtbPvPepZI/B9Wn.BgRugB3GkweUkiLbQlYB7i','ROLE_USER','user3'),(4,1,'$2a$10$D1L.mB459nVbFFVVxXuV2eLPxBfBZ0iLeCil2.i9LVFalws8Urv3q','ROLE_USER','user4'),(5,1,'$2a$10$hjFbHkqrmlXf9KOeXhLpLeR4xA7WVhG593DrvKxUJwXwdPSZzblV2','ROLE_USER','user5'),(6,1,'$2a$10$4moQaoOmBYj14An1BKBF0uX20vifMPsoTdCrn3Q2xMbGUEFCsnQd2','ROLE_USER','user6'),(7,1,'$2a$10$0SJgXKV.4uKNXZFM9Y9Adu0T0YgXsdVPWfoQfOB/H1NuwEknMngZm','ROLE_USER','user7'),(8,1,'$2a$10$IqAL9SgGLGMYKuZoEJ6L0u1qLVaACd7LhQFmsr9FcyGen0V4A7NgG','ROLE_USER','user8');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cyrillics'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23  0:58:26
