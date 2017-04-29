# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: 127.0.0.1    Database: db_ssh
# ------------------------------------------------------
# Server version 5.5.21

#
# Source for table ssh_department
#

DROP TABLE IF EXISTS `ssh_department`;
CREATE TABLE `ssh_department` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table ssh_department
#

LOCK TABLES `ssh_department` WRITE;
/*!40000 ALTER TABLE `ssh_department` DISABLE KEYS */;
INSERT INTO `ssh_department` VALUES (1,'财务部');
INSERT INTO `ssh_department` VALUES (2,'技术部');
INSERT INTO `ssh_department` VALUES (3,'人事部');
/*!40000 ALTER TABLE `ssh_department` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ssh_employee
#

DROP TABLE IF EXISTS `ssh_employee`;
CREATE TABLE `ssh_employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `BIRTH` datetime DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `DEPARTMENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_kfaoihyj5oll835mvidvgsxp` (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table ssh_employee
#

LOCK TABLES `ssh_employee` WRITE;
/*!40000 ALTER TABLE `ssh_employee` DISABLE KEYS */;
INSERT INTO `ssh_employee` VALUES (1,'ssss','123','ss','2016-05-20','2017-02-22 20:11:10',2);
INSERT INTO `ssh_employee` VALUES (2,'BBB','123','BBB@qq.com','2016-03-20','2017-02-22 20:26:06',2);
/*!40000 ALTER TABLE `ssh_employee` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table ssh_employee
#

ALTER TABLE `ssh_employee`
ADD CONSTRAINT `FK_kfaoihyj5oll835mvidvgsxp` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `ssh_department` (`ID`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
