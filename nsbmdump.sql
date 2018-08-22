-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nsbm1
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `bachelor`
--

DROP TABLE IF EXISTS `bachelor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bachelor` (
  `cid` varchar(256) NOT NULL,
  `cname` varchar(256) NOT NULL,
  `gyears` varchar(3) NOT NULL,
  `credits` varchar(3) NOT NULL,
  `syear` varchar(3) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bachelor`
--

LOCK TABLES `bachelor` WRITE;
/*!40000 ALTER TABLE `bachelor` DISABLE KEYS */;
INSERT INTO `bachelor` VALUES ('B001','Computing','3','37','4'),('B002','Business','3','35','4'),('B003','Administration','4','37','4');
/*!40000 ALTER TABLE `bachelor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bpayment`
--

DROP TABLE IF EXISTS `bpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bpayment` (
  `paymentid` varchar(256) NOT NULL,
  `anumber` varchar(256) NOT NULL,
  PRIMARY KEY (`paymentid`),
  KEY `x36` (`anumber`),
  CONSTRAINT `x35` FOREIGN KEY (`paymentid`) REFERENCES `payment` (`paymentid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x36` FOREIGN KEY (`anumber`) REFERENCES `ustudent` (`admission`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bpayment`
--

LOCK TABLES `bpayment` WRITE;
/*!40000 ALTER TABLE `bpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `bpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsubject`
--

DROP TABLE IF EXISTS `bsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsubject` (
  `bcourseid` varchar(256) DEFAULT NULL,
  `bsubid` varchar(256) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `day` varchar(11) DEFAULT NULL,
  `tfrom` varchar(6) DEFAULT NULL,
  `tto` varchar(6) DEFAULT NULL,
  `lecid` varchar(256) DEFAULT NULL,
  `credits` varchar(7) DEFAULT NULL,
  `type` varchar(256) DEFAULT NULL,
  `price` varchar(256) NOT NULL,
  PRIMARY KEY (`bsubid`),
  KEY `x21` (`bcourseid`),
  KEY `x22` (`lecid`),
  CONSTRAINT `x21` FOREIGN KEY (`bcourseid`) REFERENCES `bachelor` (`cid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x22` FOREIGN KEY (`lecid`) REFERENCES `lecturer` (`staffid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsubject`
--

LOCK TABLES `bsubject` WRITE;
/*!40000 ALTER TABLE `bsubject` DISABLE KEYS */;
INSERT INTO `bsubject` VALUES ('B001','SB001','Maths','Monday','11.00','11.30','L001','2','compusory',''),('B001','SB002','DSA','Monday','9.00','11.00','L003','3','compusory',''),('B001','SB003','Physics','Friday','9.00','11.00','L003','3','optional',''),('B001','SB004','SE1','Thursday','9.00','11.00','L001','2','optional',''),('B001','SB005','Discrete Maths','Tuesday','1.00','3.00','L002','2','optional',''),('B001','SB006','Computer systems','Monday','11.00','1.00','L002','2','optional',''),('B001','SB007','AAA','Tuesday','1','3','L003','3','optional','1300');
/*!40000 ALTER TABLE `bsubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructer`
--

DROP TABLE IF EXISTS `instructer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructer` (
  `staffid` varchar(256) NOT NULL,
  `name` varchar(256) NOT NULL,
  `dob` date NOT NULL,
  `contact` varchar(11) NOT NULL,
  `address` varchar(256) NOT NULL,
  `gender` varchar(7) NOT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructer`
--

LOCK TABLES `instructer` WRITE;
/*!40000 ALTER TABLE `instructer` DISABLE KEYS */;
INSERT INTO `instructer` VALUES ('I001','Ishab K.R.A.','1993-09-07','0715893215','AZX','Female');
/*!40000 ALTER TABLE `instructer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructersub`
--

DROP TABLE IF EXISTS `instructersub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructersub` (
  `bsubid` varchar(256) NOT NULL,
  `staffid` varchar(256) NOT NULL,
  `msubid` varchar(256) NOT NULL,
  PRIMARY KEY (`bsubid`,`staffid`,`msubid`),
  KEY `x20` (`staffid`),
  KEY `x33` (`msubid`),
  CONSTRAINT `x19` FOREIGN KEY (`bsubid`) REFERENCES `bsubject` (`bsubid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x20` FOREIGN KEY (`staffid`) REFERENCES `instructer` (`staffid`) ON UPDATE NO ACTION,
  CONSTRAINT `x33` FOREIGN KEY (`msubid`) REFERENCES `msubject` (`subid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructersub`
--

LOCK TABLES `instructersub` WRITE;
/*!40000 ALTER TABLE `instructersub` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructersub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab` (
  `labid` varchar(256) NOT NULL,
  `venue` varchar(256) DEFAULT NULL,
  `capacity` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`labid`),
  KEY `x9` (`venue`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab`
--

LOCK TABLES `lab` WRITE;
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
INSERT INTO `lab` VALUES ('LB001','oiu','13'),('LB002','oiu','13'),('LB003','oiu','13');
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laballocate`
--

DROP TABLE IF EXISTS `laballocate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laballocate` (
  `staffid` varchar(256) NOT NULL,
  `labid` varchar(256) NOT NULL,
  `day` varchar(256) NOT NULL,
  `tfrom` varchar(7) DEFAULT NULL,
  `tto` varchar(7) DEFAULT NULL,
  `msubid` varchar(256) DEFAULT NULL,
  `bsubid` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`staffid`,`labid`),
  KEY `x15` (`labid`),
  CONSTRAINT `x14` FOREIGN KEY (`staffid`) REFERENCES `instructer` (`staffid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `x15` FOREIGN KEY (`labid`) REFERENCES `lab` (`labid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laballocate`
--

LOCK TABLES `laballocate` WRITE;
/*!40000 ALTER TABLE `laballocate` DISABLE KEYS */;
INSERT INTO `laballocate` VALUES ('I001','LB001','Monday','','',NULL,'SB001');
/*!40000 ALTER TABLE `laballocate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `staffid` varchar(256) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `contact` varchar(11) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `gender` varchar(13) DEFAULT NULL,
  `office` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES ('L001','Gihan K.','2000-03-01','0147852367','aaa','Male','ASASFDAD'),('L002','AAA','1968-03-07','01236547899','adasfsadfadf','Male','fgdfdtghyrtwer'),('L003','Nimal Awindu','1975-03-07','0715467893','Male','11A,AXZ,ACV','AAA'),('L005','A.X.z.AXZ','1997-06-07',NULL,'AxZSczcdc','Female','qaz'),('null',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lusers`
--

DROP TABLE IF EXISTS `lusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lusers` (
  `uname` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lusers`
--

LOCK TABLES `lusers` WRITE;
/*!40000 ALTER TABLE `lusers` DISABLE KEYS */;
INSERT INTO `lusers` VALUES ('admin','admin');
/*!40000 ALTER TABLE `lusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterc`
--

DROP TABLE IF EXISTS `masterc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterc` (
  `cid` varchar(256) NOT NULL,
  `cname` varchar(256) NOT NULL,
  `credits` varchar(7) NOT NULL,
  `year` varchar(7) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterc`
--

LOCK TABLES `masterc` WRITE;
/*!40000 ALTER TABLE `masterc` DISABLE KEYS */;
INSERT INTO `masterc` VALUES ('C001','Business','13','2'),('C003','Computer','33','2'),('M001','Engineering','31','2');
/*!40000 ALTER TABLE `masterc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mpayment`
--

DROP TABLE IF EXISTS `mpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mpayment` (
  `paymentid` varchar(256) NOT NULL,
  `anumber` varchar(256) NOT NULL,
  PRIMARY KEY (`paymentid`),
  KEY `x39` (`anumber`),
  CONSTRAINT `x38` FOREIGN KEY (`paymentid`) REFERENCES `payment` (`paymentid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x39` FOREIGN KEY (`anumber`) REFERENCES `pstudent` (`admission`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mpayment`
--

LOCK TABLES `mpayment` WRITE;
/*!40000 ALTER TABLE `mpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `mpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msubject`
--

DROP TABLE IF EXISTS `msubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msubject` (
  `mcourse` varchar(256) NOT NULL,
  `subid` varchar(256) NOT NULL,
  `name` varchar(256) NOT NULL,
  `day` varchar(11) NOT NULL,
  `tfrom` varchar(6) NOT NULL,
  `tto` varchar(6) NOT NULL,
  `lecid` varchar(256) DEFAULT NULL,
  `credits` varchar(7) NOT NULL,
  `price` varchar(256) NOT NULL,
  `type` varchar(256) NOT NULL,
  PRIMARY KEY (`subid`),
  KEY `x23` (`mcourse`),
  KEY `x24` (`lecid`),
  CONSTRAINT `x23` FOREIGN KEY (`mcourse`) REFERENCES `masterc` (`cid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x24` FOREIGN KEY (`lecid`) REFERENCES `lecturer` (`staffid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msubject`
--

LOCK TABLES `msubject` WRITE;
/*!40000 ALTER TABLE `msubject` DISABLE KEYS */;
INSERT INTO `msubject` VALUES ('C001','SM001','Maths and analysis','Tuesday','9','1','L003','3','1300','compusory');
/*!40000 ALTER TABLE `msubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagrade`
--

DROP TABLE IF EXISTS `pagrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagrade` (
  `padmission` varchar(256) NOT NULL,
  `subid` varchar(256) NOT NULL,
  `asgnumber` varchar(3) NOT NULL,
  `marks` varchar(3) NOT NULL,
  `attempt` varchar(3) NOT NULL,
  PRIMARY KEY (`padmission`,`subid`,`asgnumber`,`attempt`),
  KEY `x32` (`subid`),
  CONSTRAINT `x31` FOREIGN KEY (`padmission`) REFERENCES `pstudent` (`admission`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x32` FOREIGN KEY (`subid`) REFERENCES `msubject` (`subid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagrade`
--

LOCK TABLES `pagrade` WRITE;
/*!40000 ALTER TABLE `pagrade` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `paymentid` varchar(256) NOT NULL,
  `year` varchar(7) NOT NULL,
  `semester` varchar(3) NOT NULL,
  `amount` varchar(256) NOT NULL,
  `date` varchar(256) NOT NULL,
  PRIMARY KEY (`paymentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('P001','2013','1','13100','8/6/18');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pstudent`
--

DROP TABLE IF EXISTS `pstudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pstudent` (
  `admission` varchar(256) NOT NULL,
  `courseid` varchar(256) NOT NULL,
  `name` varchar(256) NOT NULL,
  `dob` date NOT NULL,
  `joindate` date NOT NULL,
  `qualification` varchar(256) NOT NULL,
  `institute` varchar(256) NOT NULL,
  `gyear` year(4) NOT NULL,
  `address` varchar(256) NOT NULL,
  `gender` varchar(256) NOT NULL,
  `batch` varchar(256) NOT NULL,
  `email` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`admission`),
  KEY `x18` (`courseid`),
  CONSTRAINT `x18` FOREIGN KEY (`courseid`) REFERENCES `masterc` (`cid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pstudent`
--

LOCK TABLES `pstudent` WRITE;
/*!40000 ALTER TABLE `pstudent` DISABLE KEYS */;
INSERT INTO `pstudent` VALUES ('P002','M001','Kamal','1997-07-07','0006-05-17','AAA','A',2011,'a1x2c3','Female','MC77','duleepalwis0@gmail.com'),('P003','C001','K.L.Ihrindu','1999-01-01','0008-09-17','Bsc Cs','Ucsc',2011,'q1w2a3','Female','MC73','duleepalwis0@gmail.com');
/*!40000 ALTER TABLE `pstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pstudentgrade`
--

DROP TABLE IF EXISTS `pstudentgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pstudentgrade` (
  `number` int(127) NOT NULL AUTO_INCREMENT,
  `padmission` varchar(256) NOT NULL,
  `subid` varchar(256) NOT NULL,
  `attempts` int(3) NOT NULL,
  `grade` varchar(3) DEFAULT NULL,
  `marks` int(3) DEFAULT NULL,
  `year` varchar(7) DEFAULT NULL,
  `semester` varchar(7) DEFAULT NULL,
  `type` varchar(17) DEFAULT NULL,
  PRIMARY KEY (`number`,`padmission`,`subid`,`attempts`),
  KEY `x26` (`subid`),
  KEY `padmission___fk` (`padmission`),
  CONSTRAINT `padmission___fk` FOREIGN KEY (`padmission`) REFERENCES `pstudent` (`admission`) ON DELETE CASCADE,
  CONSTRAINT `subid___fk` FOREIGN KEY (`subid`) REFERENCES `msubject` (`subid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pstudentgrade`
--

LOCK TABLES `pstudentgrade` WRITE;
/*!40000 ALTER TABLE `pstudentgrade` DISABLE KEYS */;
/*!40000 ALTER TABLE `pstudentgrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uagrade`
--

DROP TABLE IF EXISTS `uagrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uagrade` (
  `uadmission` varchar(256) NOT NULL,
  `subid` varchar(256) NOT NULL,
  `asgnumber` int(3) NOT NULL,
  `marks` varchar(3) NOT NULL,
  `attempt` varchar(3) NOT NULL,
  PRIMARY KEY (`uadmission`,`subid`,`asgnumber`,`attempt`),
  KEY `x29` (`subid`),
  CONSTRAINT `x29` FOREIGN KEY (`uadmission`) REFERENCES `ustudent` (`admission`) ON DELETE CASCADE,
  CONSTRAINT `x30` FOREIGN KEY (`subid`) REFERENCES `bsubject` (`bsubid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uagrade`
--

LOCK TABLES `uagrade` WRITE;
/*!40000 ALTER TABLE `uagrade` DISABLE KEYS */;
INSERT INTO `uagrade` VALUES ('U001','SB001',1,'67','1'),('U001','SB001',2,'67','1'),('U001','SB001',3,'67','1');
/*!40000 ALTER TABLE `uagrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ustudent`
--

DROP TABLE IF EXISTS `ustudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ustudent` (
  `admission` varchar(256) NOT NULL,
  `Name` varchar(256) DEFAULT NULL,
  `courseid` varchar(256) DEFAULT NULL,
  `dob` varchar(256) DEFAULT NULL,
  `joindate` varchar(256) DEFAULT NULL,
  `stream` varchar(256) DEFAULT NULL,
  `sub1` varchar(256) DEFAULT NULL,
  `sub2` varchar(256) DEFAULT NULL,
  `sub3` varchar(256) NOT NULL,
  `address` varchar(256) NOT NULL,
  `batch` varchar(11) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `email` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`admission`),
  KEY `x17` (`courseid`),
  CONSTRAINT `x17` FOREIGN KEY (`courseid`) REFERENCES `bachelor` (`cid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ustudent`
--

LOCK TABLES `ustudent` WRITE;
/*!40000 ALTER TABLE `ustudent` DISABLE KEYS */;
INSERT INTO `ustudent` VALUES ('U001','K.L.Liyanagama','B001','1996-3-31','8/8/18','Maths','Maths-A','Physics-B','Chemistry-C','aaaaaaaaaaaaaaaa','B67','Male','duleepalwis@gmail.com'),('U002','A.L.Pande','B001','1997-6-3','6/6/17','Maths','Maths-A','Physics-A','ICT-A','uijkhbv','B67','Male','duleepalwis@gmail.com'),('U003','Sajun Sandaruwan','B001','1996-12-24','8/7/18','Maths','Maths-A','Physics-B','Chemistry-C','AAAA11111111122237','B67','Male','sajunsandaruwan@gmail.com');
/*!40000 ALTER TABLE `ustudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ustudentgrade`
--

DROP TABLE IF EXISTS `ustudentgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ustudentgrade` (
  `number` int(127) NOT NULL AUTO_INCREMENT,
  `uadmission` varchar(256) NOT NULL,
  `subid` varchar(256) NOT NULL,
  `attempts` varchar(3) NOT NULL,
  `grade` varchar(3) DEFAULT NULL,
  `marks` varchar(3) DEFAULT NULL,
  `year` varchar(7) DEFAULT NULL,
  `semester` varchar(3) DEFAULT NULL,
  `type` varchar(17) DEFAULT NULL,
  PRIMARY KEY (`number`,`uadmission`,`subid`,`attempts`),
  KEY `x28` (`subid`),
  KEY `x27` (`uadmission`),
  CONSTRAINT `x27` FOREIGN KEY (`uadmission`) REFERENCES `ustudent` (`admission`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `x28` FOREIGN KEY (`subid`) REFERENCES `bsubject` (`bsubid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ustudentgrade`
--

LOCK TABLES `ustudentgrade` WRITE;
/*!40000 ALTER TABLE `ustudentgrade` DISABLE KEYS */;
INSERT INTO `ustudentgrade` VALUES (67,'U001','SB001','1','B','77','2013','1',NULL),(68,'U001','SB002','1',NULL,NULL,'2013','1',NULL),(69,'U001','SB003','1',NULL,NULL,'2013','1',NULL),(70,'U001','SB004','1',NULL,NULL,'2013','1',NULL),(71,'U001','SB005','1',NULL,NULL,'2013','1',NULL),(72,'U001','SB007','1',NULL,NULL,'2013','1',NULL);
/*!40000 ALTER TABLE `ustudentgrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'nsbm1'
--

--
-- Dumping routines for database 'nsbm1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-22 22:07:22
