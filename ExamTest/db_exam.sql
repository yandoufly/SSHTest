# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: 127.0.0.1    Database: db_exam
# ------------------------------------------------------
# Server version 5.5.21

#
# Source for table t_exam
#

DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examDate` datetime DEFAULT NULL,
  `moreScore` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `singleScore` int(11) NOT NULL,
  `paperId` int(11) DEFAULT NULL,
  `studentId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l14kkd2w86mpy8v2snw37hskx` (`paperId`),
  KEY `FK_sl2v4qucyp0qe9yvnk6icka10` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_exam
#

LOCK TABLES `t_exam` WRITE;
/*!40000 ALTER TABLE `t_exam` DISABLE KEYS */;
INSERT INTO `t_exam` VALUES (1,NULL,0,20,0,1,'JS123');
INSERT INTO `t_exam` VALUES (2,NULL,0,120,0,1,'JS123');
INSERT INTO `t_exam` VALUES (3,'2014-06-25 17:59:54',0,0,0,1,'JS123');
INSERT INTO `t_exam` VALUES (5,'2014-06-25 18:10:58',30,50,20,1,'JS123');
INSERT INTO `t_exam` VALUES (6,'2014-06-25 18:16:21',30,50,20,1,'JS123');
INSERT INTO `t_exam` VALUES (7,'2014-06-25 18:18:56',0,20,20,1,'JS123');
INSERT INTO `t_exam` VALUES (8,'2014-06-25 18:20:18',0,20,20,1,'JS123');
INSERT INTO `t_exam` VALUES (9,'2014-06-25 18:20:32',0,20,20,1,'JS123');
INSERT INTO `t_exam` VALUES (10,'2014-06-25 18:21:30',0,20,20,1,'JS123');
INSERT INTO `t_exam` VALUES (11,'2014-06-25 18:21:40',0,20,20,1,'JS123');
INSERT INTO `t_exam` VALUES (13,'2014-07-10 19:58:28',0,60,60,1,'JS123');
INSERT INTO `t_exam` VALUES (14,'2014-07-18 10:29:58',60,100,40,1,'JS123');
INSERT INTO `t_exam` VALUES (15,'2014-07-19 07:27:45',30,70,40,1,'JS123');
INSERT INTO `t_exam` VALUES (16,'2014-08-06 08:26:22',0,0,0,1,'JS123');
INSERT INTO `t_exam` VALUES (17,'2014-08-06 08:27:23',0,0,0,1,'JS123');
INSERT INTO `t_exam` VALUES (18,'2014-08-07 08:18:24',0,40,40,1,'JS123');
INSERT INTO `t_exam` VALUES (19,'2014-08-07 08:21:09',30,70,40,1,'JS123');
INSERT INTO `t_exam` VALUES (20,'2014-08-07 08:25:37',30,70,40,1,'JS123');
INSERT INTO `t_exam` VALUES (21,'2014-08-07 08:28:27',30,70,40,1,'JS123');
INSERT INTO `t_exam` VALUES (22,'2014-08-07 08:29:17',30,70,40,1,'JS123');
INSERT INTO `t_exam` VALUES (23,'2014-08-27 09:05:04',0,0,0,1,'JS123');
INSERT INTO `t_exam` VALUES (24,'2017-01-06 22:14:09',0,20,20,1,'JS20140827083933');
INSERT INTO `t_exam` VALUES (25,'2017-01-07 18:58:23',0,0,0,1,'JS127');
/*!40000 ALTER TABLE `t_exam` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_manager
#

DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_manager
#

LOCK TABLES `t_manager` WRITE;
/*!40000 ALTER TABLE `t_manager` DISABLE KEYS */;
INSERT INTO `t_manager` VALUES (1,'管理员','admin','admin');
/*!40000 ALTER TABLE `t_manager` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_paper
#

DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `joinDate` datetime DEFAULT NULL,
  `paperName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_paper
#

LOCK TABLES `t_paper` WRITE;
/*!40000 ALTER TABLE `t_paper` DISABLE KEYS */;
INSERT INTO `t_paper` VALUES (1,'2014-01-01','Java试卷一');
INSERT INTO `t_paper` VALUES (2,'2014-02-01','语文试卷二');
INSERT INTO `t_paper` VALUES (3,'2014-01-01','数学试卷一');
INSERT INTO `t_paper` VALUES (5,'2014-09-05 09:48:06','C++试卷一');
/*!40000 ALTER TABLE `t_paper` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_question
#

DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `joinTime` datetime DEFAULT NULL,
  `optionA` varchar(255) DEFAULT NULL,
  `optionB` varchar(255) DEFAULT NULL,
  `optionC` varchar(255) DEFAULT NULL,
  `optionD` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `paperId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ebouwob97chiilpjmc6gtgwkw` (`paperId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_question
#

LOCK TABLES `t_question` WRITE;
/*!40000 ALTER TABLE `t_question` DISABLE KEYS */;
INSERT INTO `t_question` VALUES (1,'D','2014-01-01','A. a1','B. $1','C. _1','D .11','下列不可作为java语言修饰符的是？','1',1);
INSERT INTO `t_question` VALUES (2,'A','2014-01-01','A. a1.java','B. a.class','C. a1','D. 都可以','有一段java应用程序，它的主类名是a1，那么保存 它的源文件名可以是？','1',1);
INSERT INTO `t_question` VALUES (3,'A,B','2014-01-01','A. String []a','B. String a[]','C. char a[][]','D. String a[10]','下面正确声明一个一维数组的是？','2',1);
INSERT INTO `t_question` VALUES (4,'A,D','2014-01-01','A. 在java中只允许单继承。','B. 在java中一个类只能实现一个接口。','C. 在java中一个类不能同时继承一个类和实现一个接口。','D. java的单一继承使代码更可靠。','下面关于继承的叙述哪些是正确的？','2',1);
INSERT INTO `t_question` VALUES (5,'C','2014-01-01','A. 一个子类可以有多个父类，一个父类也可以有多个子类','B. 一个子类可以有多个父类，但一个父类只可以有一个子类','C. 一个子类可以有一个父类，但一个父类可以有多个子类','D. 上述说法都不对','在Java中？','1',1);
INSERT INTO `t_question` VALUES (6,'A,D','2014-01-01','A. 包的声明必须是源文件的第一句代码。','B. 包的声明必须紧跟在import语句的后面。','C. 只有公共类才能放在包中。','D. 可以将多个源文件中的类放在同一个包中。','可以将多个源文件中的类放在同一个包中？','2',1);
INSERT INTO `t_question` VALUES (7,'C','2014-01-01','A. Java是跨平台的编程语言','B. Java支持分布式计算','C. Java是面向过程的编程语言','D. Java是面向对象的编程语言','下列关于Java语言的特点，描述错误的是？','1',1);
INSERT INTO `t_question` VALUES (8,'A','2014-07-16','1','2','3','4','21321','1',NULL);
INSERT INTO `t_question` VALUES (14,'A','2014-07-23','1','21','3','4','q','1',2);
INSERT INTO `t_question` VALUES (16,'A,B','2014-07-09','1122','2223','3322','4422','测试题目2','2',2);
INSERT INTO `t_question` VALUES (17,'A,D','2014-07-17','2321','321','321','321','测试题目','2',1);
INSERT INTO `t_question` VALUES (18,'A','2014-09-12','11141','22241','33341','44441','测试题目22334','1',1);
INSERT INTO `t_question` VALUES (19,'A,D','2014-09-11','22','32','42','52','12','2',2);
INSERT INTO `t_question` VALUES (20,'A,D','2014-09-12','测试选项一2','测试选项二2','测试选项三2','测试选项四2','测试题目2','2',1);
/*!40000 ALTER TABLE `t_question` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_student
#

DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` varchar(40) NOT NULL,
  `cardNo` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `prefession` varchar(40) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table t_student
#

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` VALUES ('JS123','213213213','张三3','12323','计算机3','男');
INSERT INTO `t_student` VALUES ('JS127','15SSDD','NANNA','123','333','男');
INSERT INTO `t_student` VALUES ('JS20140701094708','22','11','344','33','男');
INSERT INTO `t_student` VALUES ('JS20140701094728','223','113','34433','3333','女');
INSERT INTO `t_student` VALUES ('JS20140704052827','fa','fda2','fda','fda','男');
INSERT INTO `t_student` VALUES ('JS20140710074259','12321321321','张三','123456','计算机','男');
INSERT INTO `t_student` VALUES ('JS20140826043947','2','1','123','好的','男');
INSERT INTO `t_student` VALUES ('JS20140827083933','123','小二','123456','电气化','男');
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table t_exam
#

ALTER TABLE `t_exam`
ADD CONSTRAINT `FK_l14kkd2w86mpy8v2snw37hskx` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`),
ADD CONSTRAINT `FK_sl2v4qucyp0qe9yvnk6icka10` FOREIGN KEY (`studentId`) REFERENCES `t_student` (`id`);

#
#  Foreign keys for table t_question
#

ALTER TABLE `t_question`
ADD CONSTRAINT `FK_ebouwob97chiilpjmc6gtgwkw` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
