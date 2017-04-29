# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: exam
# ------------------------------------------------------
# Server version 5.5.21

#
# Source for table tb_answer
#

DROP TABLE IF EXISTS `tb_answer`;
CREATE TABLE `tb_answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT,
  `mark` varchar(255) DEFAULT NULL,
  `yes` tinyint(1) DEFAULT NULL,
  `sqrId` int(11) DEFAULT NULL,
  `aIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`answerId`),
  KEY `FK_8jqlg43lufjvkp0t09ifqfqag` (`sqrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_answer
#

LOCK TABLES `tb_answer` WRITE;
/*!40000 ALTER TABLE `tb_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_answer` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_exam
#

DROP TABLE IF EXISTS `tb_exam`;
CREATE TABLE `tb_exam` (
  `examId` int(11) NOT NULL AUTO_INCREMENT,
  `examName` varchar(255) DEFAULT NULL,
  `examQuestionCount` int(11) DEFAULT NULL,
  `examTime` int(11) DEFAULT NULL,
  `examTotalScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`examId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_exam
#

LOCK TABLES `tb_exam` WRITE;
/*!40000 ALTER TABLE `tb_exam` DISABLE KEYS */;
INSERT INTO `tb_exam` VALUES (1,'半期考试',1,120,100);
/*!40000 ALTER TABLE `tb_exam` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_exampaper
#

DROP TABLE IF EXISTS `tb_exampaper`;
CREATE TABLE `tb_exampaper` (
  `epId` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` varchar(255) DEFAULT NULL,
  `commitTime` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `examId` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`epId`),
  KEY `FK_kh45g8c9ntpp19ikej8kyw6io` (`examId`),
  KEY `FK_fp7hm1lwdlk9w3cxt0g3wkfxs` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_exampaper
#

LOCK TABLES `tb_exampaper` WRITE;
/*!40000 ALTER TABLE `tb_exampaper` DISABLE KEYS */;
INSERT INTO `tb_exampaper` VALUES (1,'2013-4-23 17:09:45','2013-4-23 17:09:50','已完成',0,1,1);
/*!40000 ALTER TABLE `tb_exampaper` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_module
#

DROP TABLE IF EXISTS `tb_module`;
CREATE TABLE `tb_module` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `moduleCode` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_module
#

LOCK TABLES `tb_module` WRITE;
/*!40000 ALTER TABLE `tb_module` DISABLE KEYS */;
INSERT INTO `tb_module` VALUES (1,'questionManage','题库管理');
INSERT INTO `tb_module` VALUES (2,'paperManage','试卷管理');
INSERT INTO `tb_module` VALUES (3,'examManage','考试管理');
INSERT INTO `tb_module` VALUES (4,'priManage','权限管理');
INSERT INTO `tb_module` VALUES (5,'userManage','用户管理');
/*!40000 ALTER TABLE `tb_module` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_option
#

DROP TABLE IF EXISTS `tb_option`;
CREATE TABLE `tb_option` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `yes` tinyint(1) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FK_rylg9x7sqcl5y6k2t3v79qkt9` (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_option
#

LOCK TABLES `tb_option` WRITE;
/*!40000 ALTER TABLE `tb_option` DISABLE KEYS */;
INSERT INTO `tb_option` VALUES (1,'1','A',0,1,0);
INSERT INTO `tb_option` VALUES (2,'2','B',0,1,1);
INSERT INTO `tb_option` VALUES (3,'3','C',1,1,2);
INSERT INTO `tb_option` VALUES (4,'4','D',0,1,3);
INSERT INTO `tb_option` VALUES (5,'11','A',0,2,0);
INSERT INTO `tb_option` VALUES (6,'22','B',1,2,1);
INSERT INTO `tb_option` VALUES (7,'33','C',0,2,2);
INSERT INTO `tb_option` VALUES (8,'44','D',0,2,3);
/*!40000 ALTER TABLE `tb_option` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_question
#

DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_question
#

LOCK TABLES `tb_question` WRITE;
/*!40000 ALTER TABLE `tb_question` DISABLE KEYS */;
INSERT INTO `tb_question` VALUES (1,'AA');
INSERT INTO `tb_question` VALUES (2,'BB');
/*!40000 ALTER TABLE `tb_question` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_role
#

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_role
#

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1,'学生');
INSERT INTO `tb_role` VALUES (2,'老师');
INSERT INTO `tb_role` VALUES (3,'主任');
INSERT INTO `tb_role` VALUES (4,'系统管理员');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_role_modules
#

DROP TABLE IF EXISTS `tb_role_modules`;
CREATE TABLE `tb_role_modules` (
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`rid`,`mid`),
  KEY `FK_n8a527uekt6nwkqwborahie24` (`mid`),
  KEY `FK_7jtvua2amsacxkwqjfideeoqu` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_role_modules
#

LOCK TABLES `tb_role_modules` WRITE;
/*!40000 ALTER TABLE `tb_role_modules` DISABLE KEYS */;
INSERT INTO `tb_role_modules` VALUES (1,1);
INSERT INTO `tb_role_modules` VALUES (1,2);
INSERT INTO `tb_role_modules` VALUES (1,3);
INSERT INTO `tb_role_modules` VALUES (1,4);
INSERT INTO `tb_role_modules` VALUES (1,5);
INSERT INTO `tb_role_modules` VALUES (2,2);
INSERT INTO `tb_role_modules` VALUES (2,3);
INSERT INTO `tb_role_modules` VALUES (2,4);
INSERT INTO `tb_role_modules` VALUES (2,5);
/*!40000 ALTER TABLE `tb_role_modules` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_student
#

DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `snumber` varchar(255) DEFAULT NULL,
  `spwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_student
#

LOCK TABLES `tb_student` WRITE;
/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
INSERT INTO `tb_student` VALUES (1,'zy','zy','1');
INSERT INTO `tb_student` VALUES (2,'admin','admin','admin');
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_student_roles
#

DROP TABLE IF EXISTS `tb_student_roles`;
CREATE TABLE `tb_student_roles` (
  `sid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`rid`),
  KEY `FK_n1ika6vtm1r6rkpyrjji94fv2` (`rid`),
  KEY `FK_kji6vou3ik9ehcvrv2x442984` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_student_roles
#

LOCK TABLES `tb_student_roles` WRITE;
/*!40000 ALTER TABLE `tb_student_roles` DISABLE KEYS */;
INSERT INTO `tb_student_roles` VALUES (1,2);
INSERT INTO `tb_student_roles` VALUES (2,1);
/*!40000 ALTER TABLE `tb_student_roles` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_studentquestionrecord
#

DROP TABLE IF EXISTS `tb_studentquestionrecord`;
CREATE TABLE `tb_studentquestionrecord` (
  `sqrId` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `epId` int(11) DEFAULT NULL,
  `epIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`sqrId`),
  KEY `FK_249ta7k9n0dtoj1o3dt58ueyn` (`qid`),
  KEY `FK_lmde643sw5soe9eb6no9t3m24` (`epId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_studentquestionrecord
#

LOCK TABLES `tb_studentquestionrecord` WRITE;
/*!40000 ALTER TABLE `tb_studentquestionrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_studentquestionrecord` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table tb_answer
#

ALTER TABLE `tb_answer`
ADD CONSTRAINT `FK_8jqlg43lufjvkp0t09ifqfqag` FOREIGN KEY (`sqrId`) REFERENCES `tb_studentquestionrecord` (`sqrId`);

#
#  Foreign keys for table tb_exampaper
#

ALTER TABLE `tb_exampaper`
ADD CONSTRAINT `FK_fp7hm1lwdlk9w3cxt0g3wkfxs` FOREIGN KEY (`sid`) REFERENCES `tb_student` (`sid`),
ADD CONSTRAINT `FK_kh45g8c9ntpp19ikej8kyw6io` FOREIGN KEY (`examId`) REFERENCES `tb_exam` (`examId`);

#
#  Foreign keys for table tb_option
#

ALTER TABLE `tb_option`
ADD CONSTRAINT `FK_rylg9x7sqcl5y6k2t3v79qkt9` FOREIGN KEY (`qid`) REFERENCES `tb_question` (`qid`);

#
#  Foreign keys for table tb_role_modules
#

ALTER TABLE `tb_role_modules`
ADD CONSTRAINT `FK_7jtvua2amsacxkwqjfideeoqu` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`rid`),
ADD CONSTRAINT `FK_n8a527uekt6nwkqwborahie24` FOREIGN KEY (`mid`) REFERENCES `tb_module` (`mid`);

#
#  Foreign keys for table tb_student_roles
#

ALTER TABLE `tb_student_roles`
ADD CONSTRAINT `FK_kji6vou3ik9ehcvrv2x442984` FOREIGN KEY (`sid`) REFERENCES `tb_student` (`sid`),
ADD CONSTRAINT `FK_n1ika6vtm1r6rkpyrjji94fv2` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`rid`);

#
#  Foreign keys for table tb_studentquestionrecord
#

ALTER TABLE `tb_studentquestionrecord`
ADD CONSTRAINT `FK_lmde643sw5soe9eb6no9t3m24` FOREIGN KEY (`epId`) REFERENCES `tb_exampaper` (`epId`),
ADD CONSTRAINT `FK_249ta7k9n0dtoj1o3dt58ueyn` FOREIGN KEY (`qid`) REFERENCES `tb_question` (`qid`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
