-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2014 年 07 月 09 日 15:43
-- 服务器版本: 5.5.27
-- PHP 版本: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `food_order`
--

-- --------------------------------------------------------

--
-- 表的结构 `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `phone` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `orderNum` int(11) DEFAULT '0',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `account`
--

INSERT INTO `account` (`phone`, `name`, `orderNum`, `password`) VALUES
('13570233448', 'lyh', 0, '123456');

-- --------------------------------------------------------

--
-- 表的结构 `canteen`
--

CREATE TABLE IF NOT EXISTS `canteen` (
  `phone` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `passwd` varchar(20) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `canteen`
--

INSERT INTO `canteen` (`phone`, `name`, `x`, `y`, `passwd`) VALUES
('123547888445', '手工水饺', 23.06290054321289, 113.39800262451172, '123456'),
('13546899774', '73街', 23.062000274658203, 113.39800262451172, '123456'),
('15784955887', '食物方', 23.0669002532959, 113.39900207519531, '123456');

-- --------------------------------------------------------

--
-- 表的结构 `food`
--

CREATE TABLE IF NOT EXISTS `food` (
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `canteenPhone` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `introduce` text NOT NULL,
  `starNum` int(11) NOT NULL,
  `monthSale` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `food`
--

INSERT INTO `food` (`foodid`, `canteenPhone`, `name`, `introduce`, `starNum`, `monthSale`, `price`) VALUES
(1, '13546899774', '红烧肉', '红烧肉是热菜菜谱之一。以五花肉为制作主料，红烧肉的烹饪技巧以砂锅为主，肥瘦相间，香甜松软，入口即化。红烧肉在我国各地流传甚广，是一道著名的 大众菜肴。', 5, 156, 15),
(2, '13546899774', '麒麟鲈鱼', '著名广州菜，此菜装盘十分讲究，几种配料切皮片乳猪「特点」制作艺术精细，色泽大红油亮，皮松软肉嫩滑，风味独特优美，驰名中外佳肴。 ', 4, 123, 18.5),
(3, '13546899774', '东江盐焗鸡', '制法独特，味香浓郁，皮爽肉滑，色泽微黄，皮脆肉嫩，骨肉鲜香，风味诱人花雕鸡「特点」制法独特，色如琥珀，鲜美可口，闻名遐迩。 ', 5, 54, 18.5),
(4, '13546899774', '炸子鸡', '炸子鸡可说是广东菜的招牌鸡，皮脆肉嫩，寿筵喜宴不可缺少。 ', 2, 10, 3.5),
(5, '15784955887', '什锦冬瓜帽', '造型美观，色泽艳丽，味道清爽，营养丰富。 ', 5, 465, 12.5);

-- --------------------------------------------------------

--
-- 表的结构 `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `orderID` varchar(20) NOT NULL,
  `accountPhone` varchar(20) NOT NULL,
  `canteentPhone` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT '未确认',
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `orderfood`
--

CREATE TABLE IF NOT EXISTS `orderfood` (
  `foodID` varchar(20) NOT NULL,
  `orderID` varchar(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`foodID`,`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
