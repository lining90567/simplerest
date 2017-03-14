-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.7.17 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 simplerest 的数据库结构
CREATE DATABASE IF NOT EXISTS `simplerest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `simplerest`;


-- 导出  表 simplerest.sr_goods 结构
CREATE TABLE IF NOT EXISTS `sr_goods` (
  `goods_id` char(32) NOT NULL,
  `goods_name` varchar(32) NOT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  simplerest.sr_goods 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `sr_goods` DISABLE KEYS */;
INSERT INTO `sr_goods` (`goods_id`, `goods_name`) VALUES
	('223c9e36055811e7b74a00155d010e04', '宝马轿车'),
	('2261d9fb056011e7b21200155d010e04', 'CPU'),
	('751cff53055311e7b74a00155d010e04', '奔驰轿车'),
	('ba94638e054811e7b74a00155d010e04', '联想笔记本电脑'),
	('efaf1af0056211e7b21200155d010e04', '内存');
/*!40000 ALTER TABLE `sr_goods` ENABLE KEYS */;


-- 导出  表 simplerest.sr_order 结构
CREATE TABLE IF NOT EXISTS `sr_order` (
  `order_id` char(32) NOT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  simplerest.sr_order 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sr_order` DISABLE KEYS */;
INSERT INTO `sr_order` (`order_id`, `order_date`) VALUES
	('304d7e64056b11e7b21200155d010e04', '2017-03-10'),
	('d76e3e2f072f11e7b43d0021ccbc48ea', '2017-03-01'),
	('dbd412c0072d11e7b43d0021ccbc48ea', '2017-03-01'),
	('ef62775c05a011e7b2530021ccbc48ea', '2017-03-09');
/*!40000 ALTER TABLE `sr_order` ENABLE KEYS */;


-- 导出  表 simplerest.sr_order_item 结构
CREATE TABLE IF NOT EXISTS `sr_order_item` (
  `item_id` char(32) NOT NULL,
  `order_id` char(32) NOT NULL,
  `goods_id` char(32) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  simplerest.sr_order_item 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `sr_order_item` DISABLE KEYS */;
INSERT INTO `sr_order_item` (`item_id`, `order_id`, `goods_id`, `quantity`) VALUES
	('369095115e0a4d7fb4ff705708f0fac1', 'dbd412c0072d11e7b43d0021ccbc48ea', '751cff53055311e7b74a00155d010e04', 7),
	('3a62cb0e056b11e7b21200155d010e04', '304d7e64056b11e7b21200155d010e04', '2261d9fb056011e7b21200155d010e04', 1),
	('3a99a356af1b467396bfad5c02bce71b', 'd76e3e2f072f11e7b43d0021ccbc48ea', '751cff53055311e7b74a00155d010e04', 7),
	('3cebaeb5056b11e7b21200155d010e04', '304d7e64056b11e7b21200155d010e04', 'efaf1af0056211e7b21200155d010e04', 2),
	('58b7f7fc68dd42ec95e8366d2e05fdd9', 'd76e3e2f072f11e7b43d0021ccbc48ea', '223c9e36055811e7b74a00155d010e04', 6),
	('a9198907715640a2afe1706040f0e4fa', 'ef62775c05a011e7b2530021ccbc48ea', '751cff53055311e7b74a00155d010e04', 7),
	('c6fab125ca8845119c7ed5f6d6a7eeae', 'dbd412c0072d11e7b43d0021ccbc48ea', '223c9e36055811e7b74a00155d010e04', 6),
	('ddd93e7e3fdd4f949307c83ddac95cdb', 'ef62775c05a011e7b2530021ccbc48ea', '223c9e36055811e7b74a00155d010e04', 6);
/*!40000 ALTER TABLE `sr_order_item` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
