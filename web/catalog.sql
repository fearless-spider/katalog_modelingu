-- phpMyAdmin SQL Dump
-- version 3.2.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2010 at 11:52 PM
-- Server version: 5.1.42
-- PHP Version: 5.2.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `catalog`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`id`, `authority`, `created`, `modified`) VALUES
(1, 'ROLE_ADMIN', '2010-01-12 15:26:04', '2010-01-12 15:26:04'),
(2, 'ROLE_USER', '2010-01-20 18:28:42', '2010-01-20 18:28:42');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `authority_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `authority_id` (`authority_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `name`, `created`, `modified`, `authority_id`) VALUES
(1, 'Administrator', '2010-01-20 19:42:46', '2010-01-20 19:42:46', 1),
(2, 'Fotograf', '2010-01-20 20:44:05', '2010-01-20 20:44:05', 2),
(3, 'Wizaż', '2010-01-20 22:57:25', '2010-01-20 22:57:25', 2),
(4, 'Stylista', '2010-01-20 22:57:39', '2010-01-20 22:57:39', 2);

-- --------------------------------------------------------

--
-- Table structure for table `rangies`
--

CREATE TABLE IF NOT EXISTS `rangies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `rangies`
--

INSERT INTO `rangies` (`id`, `name`, `created`, `modified`) VALUES
(1, 'Portret', '2010-01-20 03:04:12', '2010-01-20 03:04:12'),
(2, 'Fashion', '2010-01-20 22:55:18', '2010-01-20 22:55:18'),
(3, 'Bielizna', '2010-01-20 22:55:49', '2010-01-20 22:55:49');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `enabled` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `confirmpassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `groupfk` (`group_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `firstname`, `lastname`, `password`, `email`, `created`, `modified`, `enabled`, `group_id`, `confirmpassword`) VALUES
(22, 'admin', '', '', '05a671c66aefea124cc08b76ea6d30bb', 'bespider@gmail.com', '2010-01-20 19:45:47', '2010-01-20 19:45:47', 1, 1, '1'),
(23, 'jasiok', 'ffff', 'ść', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'bespider@gmail.com', '2010-01-20 20:46:00', '2010-01-20 20:46:00', 1, 2, '1'),
(24, 'jasioka', 'lolll', '', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'bespider@gmail.com', '2010-01-20 21:25:09', '2010-01-20 21:25:09', 1, 2, '1');

-- --------------------------------------------------------

--
-- Table structure for table `usersrangies`
--

CREATE TABLE IF NOT EXISTS `usersrangies` (
  `user_id` int(11) NOT NULL,
  `range_id` int(11) NOT NULL,
  KEY `range_id` (`range_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usersrangies`
--

INSERT INTO `usersrangies` (`user_id`, `range_id`) VALUES
(24, 3),
(24, 1),
(23, 1),
(23, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `authority_id` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `groupfk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `usersrangies`
--
ALTER TABLE `usersrangies`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `range_id` FOREIGN KEY (`range_id`) REFERENCES `rangies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
