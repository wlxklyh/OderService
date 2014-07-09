-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: food_order
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `phone` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `orderNum` int(11) DEFAULT '0',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('13570233448','lyh',0,'123456');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canteen`
--

DROP TABLE IF EXISTS `canteen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canteen` (
  `phone` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `passwd` varchar(20) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canteen`
--

LOCK TABLES `canteen` WRITE;
/*!40000 ALTER TABLE `canteen` DISABLE KEYS */;
INSERT INTO `canteen` VALUES ('123547888445','手工水饺',23.06290054321289,113.39800262451172,'123456'),('13546899774','73街',23.062000274658203,113.39800262451172,'123456'),('15784955887','食物方',23.0669002532959,113.39900207519531,'123456');
/*!40000 ALTER TABLE `canteen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `canteenPhone` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `introduce` text NOT NULL,
  `starNum` int(11) NOT NULL,
  `monthSale` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'13546899774','红烧肉','红烧肉是热菜菜谱之一。以五花肉为制作主料，红烧肉的烹饪技巧以砂锅为主，肥瘦相间，香甜松软，入口即化。红烧肉在我国各地流传甚广，是一道著名的 大众菜肴。',5,156,15),(2,'13546899774','麒麟鲈鱼','著名广州菜，此菜装盘十分讲究，几种配料切皮片乳猪「特点」制作艺术精细，色泽大红油亮，皮松软肉嫩滑，风味独特优美，驰名中外佳肴。 ',4,123,18.5),(3,'13546899774','东江盐焗鸡','制法独特，味香浓郁，皮爽肉滑，色泽微黄，皮脆肉嫩，骨肉鲜香，风味诱人花雕鸡「特点」制法独特，色如琥珀，鲜美可口，闻名遐迩。 ',5,54,18.5),(4,'13546899774','炸子鸡','炸子鸡可说是广东菜的招牌鸡，皮脆肉嫩，寿筵喜宴不可缺少。 ',2,10,3.5),(5,'15784955887','什锦冬瓜帽','造型美观，色泽艳丽，味道清爽，营养丰富。 ',5,465,12.5);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderID` varchar(20) NOT NULL,
  `accountPhone` varchar(20) NOT NULL,
  `canteentPhone` varchar(20) NOT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderfood`
--

DROP TABLE IF EXISTS `orderfood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderfood` (
  `foodID` varchar(20) NOT NULL,
  `orderID` varchar(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`foodID`,`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderfood`
--

LOCK TABLES `orderfood` WRITE;
/*!40000 ALTER TABLE `orderfood` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderfood` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-09 15:58:06
