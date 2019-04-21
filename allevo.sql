-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2019 at 10:31 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `allevo`
--

-- --------------------------------------------------------

--
-- Table structure for table `action`
--

CREATE TABLE `action` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `action`
--

INSERT INTO `action` (`id`, `name`) VALUES
(1, 'Authorize'),
(2, 'Single Authorize'),
(3, 'Auto Authorize'),
(4, 'Batch'),
(5, 'Rapid Batch'),
(6, 'Auto Batch'),
(7, 'Reject'),
(8, 'Single Reject'),
(9, 'Reject [Client]'),
(10, 'Suspend'),
(11, 'Single Suspend');

-- --------------------------------------------------------

--
-- Table structure for table `allevo`
--

CREATE TABLE `allevo` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `exit_point` int(11) NOT NULL,
  `exit_point_bool` bit(1) NOT NULL,
  `hold_status` bit(1) NOT NULL,
  `queue_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `allevo_action`
--

CREATE TABLE `allevo_action` (
  `id` int(11) NOT NULL,
  `allevo_id` int(11) NOT NULL,
  `action_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `allevo_type`
--

CREATE TABLE `allevo_type` (
  `id` int(11) NOT NULL,
  `allevo_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `name`) VALUES
(1, 'Reconciliation'),
(2, 'GSRS'),
(3, '950'),
(4, 'STMT'),
(5, 'Investigation'),
(6, 'Debit instruments'),
(7, 'Debit instruments by Date'),
(8, 'Debit instruments Refusals'),
(9, 'Ordinary Debit instruments'),
(10, 'Sepa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `action`
--
ALTER TABLE `action`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `allevo`
--
ALTER TABLE `allevo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `allevo_action`
--
ALTER TABLE `allevo_action`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `allevo_type`
--
ALTER TABLE `allevo_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `action`
--
ALTER TABLE `action`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `allevo`
--
ALTER TABLE `allevo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `allevo_action`
--
ALTER TABLE `allevo_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `allevo_type`
--
ALTER TABLE `allevo_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
