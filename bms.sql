-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: BMS
-- ------------------------------------------------------
-- Server version	5.7.26-log

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
-- Table structure for table `assignproject`
--

DROP TABLE IF EXISTS `assignproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignproject` (
  `projectID` int(11) DEFAULT NULL,
  `empCode` int(11) DEFAULT NULL,
  KEY `empCode` (`empCode`),
  KEY `projectID` (`projectID`),
  CONSTRAINT `assignproject_ibfk_1` FOREIGN KEY (`empCode`) REFERENCES `employee` (`empCode`),
  CONSTRAINT `assignproject_ibfk_2` FOREIGN KEY (`projectID`) REFERENCES `project` (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignproject`
--

LOCK TABLES `assignproject` WRITE;
/*!40000 ALTER TABLE `assignproject` DISABLE KEYS */;
INSERT INTO `assignproject` VALUES (1002,103),(1001,108),(1003,109),(1003,103),(1001,108);
/*!40000 ALTER TABLE `assignproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bugreport`
--

DROP TABLE IF EXISTS `bugreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bugreport` (
  `bugNo` int(11) NOT NULL,
  `bugCode` int(11) DEFAULT NULL,
  `projectID` int(11) DEFAULT NULL,
  `Ecode` int(11) DEFAULT NULL,
  `Tcode` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `bugDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bugNo`),
  KEY `Ecode` (`Ecode`),
  KEY `Tcode` (`Tcode`),
  KEY `bugCode` (`bugCode`),
  KEY `projectID` (`projectID`),
  CONSTRAINT `bugreport_ibfk_1` FOREIGN KEY (`Ecode`) REFERENCES `employee` (`empCode`),
  CONSTRAINT `bugreport_ibfk_2` FOREIGN KEY (`Tcode`) REFERENCES `employee` (`empCode`),
  CONSTRAINT `bugreport_ibfk_3` FOREIGN KEY (`bugCode`) REFERENCES `bugtype` (`bugCode`),
  CONSTRAINT `bugreport_ibfk_4` FOREIGN KEY (`projectID`) REFERENCES `project` (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugreport`
--

LOCK TABLES `bugreport` WRITE;
/*!40000 ALTER TABLE `bugreport` DISABLE KEYS */;
INSERT INTO `bugreport` VALUES (2,2,1001,103,104,'Completed','Compilation Error occurs due to missing braces,semicolon etc.'),(3,1,1001,103,104,'Resolved','illegal start of expression'),(4,2,1001,103,104,'Unresolved','Compilation Error occurs due to missing braces,semicolon etc.'),(5,3,1001,103,104,'Pending',NULL);
/*!40000 ALTER TABLE `bugreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bugtype`
--

DROP TABLE IF EXISTS `bugtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bugtype` (
  `bugCode` int(11) NOT NULL,
  `bugCategory` varchar(30) DEFAULT NULL,
  `bugSeverty` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bugCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugtype`
--

LOCK TABLES `bugtype` WRITE;
/*!40000 ALTER TABLE `bugtype` DISABLE KEYS */;
INSERT INTO `bugtype` VALUES (1,'Functional Error.','Major'),(2,'Compilation Error.','Critical'),(3,'Missing Commands','Low'),(4,'Runtime Errors','Critical'),(5,'Communication Problems','Critical'),(6,'Logical Errors','Major'),(7,'Inappropriate Error Handling','Medium'),(8,'Calculation Issues','Medium');
/*!40000 ALTER TABLE `bugtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `empCode` int(11) NOT NULL DEFAULT '0',
  `empName` varchar(30) DEFAULT NULL,
  `empEmail` varchar(40) DEFAULT NULL,
  `empPassword` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `mobileNo` bigint(20) DEFAULT NULL,
  `Role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`empCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (101,'Apurv Agnihotri','apurv@gmail.com','apurv','Male','1999-01-01',9945415672,'Admin'),(102,'Ayush Dwivedi','ayushd@gmail.com','ayushd','Male','1998-03-05',6392919357,'Manager'),(103,'Ayush Srivastava','ayushs@gmail.com','ayushs','Male','1995-02-09',8924836813,'Developer'),(104,'mayank srivastava','mayank@gmail.com','mayank','Male','2014-02-12',8638780120,'Tester'),(108,'varsha ','varsha@gmail.com','varsha','Female','1999-04-18',6587423589,'Developer'),(109,'riya','riya@gmail.com','riya','Female','1998-04-25',9854789264,'Developer');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `projectID` int(11) NOT NULL,
  `projectName` varchar(30) DEFAULT NULL,
  `SDate` date DEFAULT NULL,
  `EDate` date DEFAULT NULL,
  `projectDec` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1001,'BTS','2019-03-04','2019-06-04','It is used in multi-national Companies for tracking bugs.'),(1002,'Prospect Encore','2019-06-01','2019-06-06','Car Company app'),(1003,'Inventory Management System','2019-07-02','2019-07-08','This project is for Shopkeeper');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-17 19:10:53
