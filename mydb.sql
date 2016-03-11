-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2016 at 05:06 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `admin_ID` int(10) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`admin_ID`),
  UNIQUE KEY `user_ID_UNIQUE` (`admin_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_ID`, `full_name`, `password`) VALUES
(1, 'admin1', '123'),
(2, 'admin2', '123');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
  `id_bill` int(10) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `cashier_cashier_ID` int(10) NOT NULL,
  PRIMARY KEY (`id_bill`),
  KEY `fk_bill_cashier1_idx` (`cashier_cashier_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id_bill`, `date`, `cashier_cashier_ID`) VALUES
(1, '2016-03-10 00:00:00', 1),
(2, '2016-03-10 00:00:00', 2),
(3, '2016-03-10 00:00:00', 3),
(4, '2016-03-11 00:00:00', 4),
(5, '2016-03-11 00:00:00', 1),
(6, '2016-03-11 00:00:00', 2),
(7, '2016-03-12 00:00:00', 3),
(8, '2016-03-12 00:00:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE IF NOT EXISTS `bill_detail` (
  `id_bill_detail` int(10) NOT NULL AUTO_INCREMENT,
  `id_bill` int(10) NOT NULL,
  `product_code` varchar(30) NOT NULL,
  `amount` int(10) NOT NULL,
  PRIMARY KEY (`id_bill_detail`),
  KEY `id_bill` (`id_bill`),
  KEY `product_code` (`product_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`id_bill_detail`, `id_bill`, `product_code`, `amount`) VALUES
(1, 1, '000001', 2),
(2, 1, '000002', 2),
(3, 1, '000002', 1),
(4, 3, '000003', 2),
(5, 3, '000003', 1),
(6, 6, '000004', 1),
(7, 5, '000003', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE IF NOT EXISTS `cashier` (
  `cashier_ID` int(10) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `admin_admin_ID` int(10) NOT NULL,
  PRIMARY KEY (`cashier_ID`),
  UNIQUE KEY `user_ID_UNIQUE` (`cashier_ID`),
  KEY `fk_cashier_admin1_idx` (`admin_admin_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`cashier_ID`, `full_name`, `password`, `admin_admin_ID`) VALUES
(1, 'cashier1', '123', 1),
(2, 'cashier2', '1234', 2),
(3, 'cashier3', '123', 2),
(4, 'cashier4', '123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `productor` varchar(30) NOT NULL,
  `amount_stock` int(10) NOT NULL,
  `date_export` datetime NOT NULL,
  `price` float NOT NULL,
  `type_code` int(10) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_product_type1_idx` (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`code`, `name`, `productor`, `amount_stock`, `date_export`, `price`, `type_code`) VALUES
('000001', 'milk', 'ere', 6, '2016-03-09 00:00:00', 23.6, 1),
('000002', 'meat', 'opo', 7, '2016-03-06 00:00:00', 15, 2),
('000003', 'beef', 'ewqe', 4, '2016-03-08 00:00:00', 34, 3),
('000004', 'chicken', 'yty', 6, '2016-03-01 00:00:00', 10, 4);

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `code` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`code`, `name`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D'),
(5, 'E');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_bill_cashier1` FOREIGN KEY (`cashier_cashier_ID`) REFERENCES `cashier` (`cashier_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `Bill_Bill_detail` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id_bill`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Product_Bill_detail` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cashier`
--
ALTER TABLE `cashier`
  ADD CONSTRAINT `fk_cashier_admin1` FOREIGN KEY (`admin_admin_ID`) REFERENCES `admin` (`admin_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_type1` FOREIGN KEY (`type_code`) REFERENCES `type` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
