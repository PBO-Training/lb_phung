-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: asset_management
-- ------------------------------------------------------
-- Server version	8.0.21
create database asset_management;
use asset_management
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
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset` (
  `asset_id` bigint NOT NULL AUTO_INCREMENT,
  `asset_code` varchar(255) DEFAULT NULL,
  `asset_day_exp` date DEFAULT NULL,
  `asset_name` varchar(255) DEFAULT NULL,
  `asset_price` varchar(255) DEFAULT NULL,
  `create_by` int NOT NULL,
  `create_date` date DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `update_by` int NOT NULL,
  `update_date` date DEFAULT NULL,
  `asset_type_id` bigint DEFAULT NULL,
  `do_not_use` bigint NOT NULL,
  `used` int NOT NULL,
  PRIMARY KEY (`asset_id`),
  KEY `FK4udnqglbxg2lpibsun3s0mtf6` (`asset_type_id`),
  CONSTRAINT `FK4udnqglbxg2lpibsun3s0mtf6` FOREIGN KEY (`asset_type_id`) REFERENCES `asset_type` (`asset_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (1,'TB','2020-01-04','Table','1',1,'2020-01-04',_binary '\0',1,'2020-01-04',2,1,2),(2,'CP','2020-01-04','Computer','1',0,NULL,_binary '\0',0,NULL,2,1,4),(3,'CH','2020-01-06','Chair','2',0,NULL,_binary '\0',0,NULL,3,1,5),(4,'Fa','2020-01-06','Fan','2',0,NULL,_binary '\0',0,NULL,2,1,3),(5,'AC','2020-02-02','Air conditioning','2',0,NULL,_binary '\0',0,NULL,1,1,3),(38,'asd','2020-01-02','asd','12',0,NULL,_binary '',0,NULL,2,1,2),(39,'ád','2022-02-02','áda','1',0,NULL,_binary '',0,NULL,1,1,1);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_employee`
--

DROP TABLE IF EXISTS `asset_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_employee` (
  `asset_employe_date_range` date DEFAULT NULL,
  `asset_employee_name` varchar(255) DEFAULT NULL,
  `create_by` int NOT NULL,
  `create_date` date DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `update_by` int NOT NULL,
  `update_date` date DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  `asset_id` bigint NOT NULL,
  PRIMARY KEY (`employee_id`,`asset_id`),
  KEY `FKmw73952bv0dtjx311bs4xu5tw` (`asset_id`),
  CONSTRAINT `FKf3b36ih462t7ynxjehwgpj50n` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKmw73952bv0dtjx311bs4xu5tw` FOREIGN KEY (`asset_id`) REFERENCES `asset` (`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_employee`
--

LOCK TABLES `asset_employee` WRITE;
/*!40000 ALTER TABLE `asset_employee` DISABLE KEYS */;
INSERT INTO `asset_employee` VALUES ('2020-01-01','aa',1,NULL,_binary '\0',1,NULL,1,1),('2020-01-01','bb',1,NULL,_binary '\0',1,NULL,1,2),('2020-01-01','cc',1,NULL,_binary '\0',1,NULL,2,3),('2020-01-01','dd',1,NULL,_binary '\0',1,NULL,2,4),('2020-01-01','ee',1,NULL,_binary '\0',1,NULL,3,1),('2020-01-01','gg',1,NULL,_binary '\0',1,NULL,3,5);
/*!40000 ALTER TABLE `asset_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_type`
--

DROP TABLE IF EXISTS `asset_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_type` (
  `asset_type_id` bigint NOT NULL AUTO_INCREMENT,
  `asset_type_code` varchar(255) DEFAULT NULL,
  `asset_type_name` varchar(255) DEFAULT NULL,
  `create_by` int NOT NULL,
  `create_date` date DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `update_by` int NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`asset_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_type`
--

LOCK TABLES `asset_type` WRITE;
/*!40000 ALTER TABLE `asset_type` DISABLE KEYS */;
INSERT INTO `asset_type` VALUES (1,'HA','Houses, architectural materials',0,NULL,_binary '\0',0,NULL),(2,'DV','Devicessd',0,NULL,_binary '\0',0,NULL),(3,'TE','Transmission equipment',0,NULL,_binary '\0',0,NULL),(4,'EM','Equipment, management tools',0,NULL,_binary '\0',0,NULL),(5,'OT','Other types of fixed assets',0,NULL,_binary '\0',0,NULL),(27,'DE','Devices',0,NULL,_binary '\0',0,NULL),(34,'sdfs','sdfsdf',0,NULL,_binary '',0,NULL);
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` int NOT NULL,
  `create_date` date DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `update_by` int NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'2020-01-02','C1','Lê Văn Anh',_binary '\0',1,'2020-01-02'),(2,0,NULL,'C2','Trần Phạm',_binary '\0',0,NULL),(3,0,NULL,'C3','Nguyễn Văn',_binary '\0',0,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-25  8:31:17
