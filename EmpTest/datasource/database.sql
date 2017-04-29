create database emp;
use emp;
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` varchar(40) NOT NULL DEFAULT '',
  `username` varchar(25) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `emp` VALUES ('1','aa',1222,'3015-05-20');
INSERT INTO `emp` VALUES ('2','BB',12344,'2016-05-20');
INSERT INTO `emp` VALUES ('3','CC',342112,'2016-06-10');