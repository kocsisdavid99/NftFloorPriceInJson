-- --------------------------------------------------------
-- Host:                         mysql.nethely.hu
-- Szerver verzió:               5.7.34-log - MySQL Community Server (GPL)
-- Szerver OS:                   Linux
-- HeidiSQL Verzió:              11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Adatbázis struktúra mentése a nft.
CREATE DATABASE IF NOT EXISTS `nft` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nft`;

-- Struktúra mentése tábla nft. floor_price
CREATE TABLE IF NOT EXISTS `floor_price` (
  `name` varchar(50) DEFAULT NULL,
  `price` char(34) DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Tábla adatainak mentése nft.floor_price: ~7 rows (hozzávetőleg)
/*!40000 ALTER TABLE `floor_price` DISABLE KEYS */;
INSERT INTO `floor_price` (`name`, `price`, `date`) VALUES
	('metabaes', '0,0', '2021-11-07 11:59:13'),
	('eternal_beings', '0,0', '2021-11-07 11:59:24'),
	('churro', '0,0', '2021-11-07 11:59:32'),
	('cakeston_easter_21', '0,0', '2021-11-07 11:59:43'),
	('syrup_soak', '0,0', '2021-11-07 11:59:51'),
	('lottie', '0,0', '2021-11-07 12:00:02'),
	('landpass_#1', '0,0', '2021-11-07 12:00:19');
/*!40000 ALTER TABLE `floor_price` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
