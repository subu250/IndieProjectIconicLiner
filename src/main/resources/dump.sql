-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
-- Host: 127.0.0.1    Database: Cosmetic
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `product`;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(25)  NULL,
                          `last_name` varchar(25)  NULL,
                          `user_name` varchar(25) NOT NULL,
                          `email` varchar(25)  NULL,
                          `password` varchar(25) NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `user_name_UNIQUE` (`user_name`)) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1, 'Kathy','Sierra','ksierra'),(2,'Herbert','Schilt','hschilt'),(3,'Joseph','Ottinger','jotti');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `brand` varchar(70) DEFAULT NULL,
                        `type` varchar(70) DEFAULT NULL,
                        `user_name` int not null,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `product_id_uindex` (`id`),
                        KEY `product_user_id_fk` (`user_name`),
                        CONSTRAINT `product_user_id_fk` FOREIGN KEY (`user_name`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Loreal','eyeliner',1),(2,'Rimmel','Liquid eyeliner',3),(4,'Revlon','eyepencil',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
