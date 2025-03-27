-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2024 at 05:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankbuddy`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatecurrnetacc` (IN `namein` VARCHAR(100), IN `typein` VARCHAR(100), IN `turnoverin` DOUBLE, IN `gstin` VARCHAR(100), IN `addharin` VARCHAR(100))   BEGIN
update currentaccount set businessName = namein , businessType = typein, annualTurnover = turnoverin WHERE gstNumber = gstin and addharNumber = addharin;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatesavingaccount` (IN `Namein` VARCHAR(100), IN `DOBin` VARCHAR(100), IN `mobileNoin` VARCHAR(100), IN `emailin` VARCHAR(100), IN `addressin` VARCHAR(100), IN `accountNoin` BIGINT, IN `pinin` INT)   BEGIN
update savingaccount set fullName = Namein  , DOB = DOBin , mobileNumber = mobileNoin , email = emailin, address = addressin where accountNumber = accountNoin and pin = pinin;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `businessloan`
--

CREATE TABLE `businessloan` (
  `loan_id` int(11) NOT NULL,
  `accountNumber` bigint(20) NOT NULL,
  `gstNumber` varchar(50) NOT NULL,
  `addharCard` varchar(50) NOT NULL,
  `loanAmount` double NOT NULL,
  `loanDuration` double NOT NULL,
  `interestRate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `businessloan`
--

INSERT INTO `businessloan` (`loan_id`, `accountNumber`, `gstNumber`, `addharCard`, `loanAmount`, `loanDuration`, `interestRate`) VALUES
(1, 350211595899, '23ABCDE1234Q1Z1', '963852741014', 150000, 2, 7.85);

-- --------------------------------------------------------

--
-- Table structure for table `currentaccount`
--

CREATE TABLE `currentaccount` (
  `id` int(11) NOT NULL,
  `businessName` varchar(50) NOT NULL,
  `businessType` varchar(50) NOT NULL,
  `gstNumber` varchar(50) NOT NULL,
  `businessAddress` varchar(50) NOT NULL,
  `annualTurnover` double NOT NULL,
  `ownerName` varchar(50) NOT NULL,
  `addharNumber` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `currentaccount`
--

INSERT INTO `currentaccount` (`id`, `businessName`, `businessType`, `gstNumber`, `businessAddress`, `annualTurnover`, `ownerName`, `addharNumber`) VALUES
(1, 'abcde', 'game', '23ABCDE1234F1Z1', 'onrofn', 99999999999999, 'plpgsql', '963852741012'),
(2, 'HVV', 'YGI', '23ABCDE1234Q1Z1', 'EWZREXC', 99999999, 'NNJNIN', '963852741014');

-- --------------------------------------------------------

--
-- Table structure for table `educationloan`
--

CREATE TABLE `educationloan` (
  `loan_id` int(11) NOT NULL,
  `accountNumber` bigint(20) NOT NULL,
  `coueseType` varchar(50) NOT NULL,
  `addharCard` varchar(50) NOT NULL,
  `panCard` varchar(50) NOT NULL,
  `loanAmount` double NOT NULL,
  `coursDuration` double NOT NULL,
  `interestRate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `educationloan`
--

INSERT INTO `educationloan` (`loan_id`, `accountNumber`, `coueseType`, `addharCard`, `panCard`, `loanAmount`, `coursDuration`, `interestRate`) VALUES
(1, 248246820924, 'jmfr', '787896541230', 'ABCDE1234Q', 99999, 1, 10.24),
(2, 248246820924, 'jmfr', '787896541230', 'ABCDE1234Q', 99999, 1, 10.24);

-- --------------------------------------------------------

--
-- Table structure for table `personalloan`
--

CREATE TABLE `personalloan` (
  `loan_id` int(11) NOT NULL,
  `accountNumber` bigint(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `addharCard` varchar(50) NOT NULL,
  `panCard` varchar(50) NOT NULL,
  `loanAmount` double NOT NULL,
  `loanDuration` double NOT NULL,
  `interestRate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `personalloan`
--

INSERT INTO `personalloan` (`loan_id`, `accountNumber`, `address`, `addharCard`, `panCard`, `loanAmount`, `loanDuration`, `interestRate`) VALUES
(1, 886729622386, '204 hieste biuj', '963852741712', 'ABCDE1234Q', 150000, 1.5, 12.1),
(2, 886729622386, 'dstr', '963852741712', 'ABCDE1234Q', 1500000, 3, 12.1),
(3, 886729622386, 'dstr', '963852741712', 'ABCDE1234Q', 1500000, 5, 12.1),
(4, 886729622386, 'dstr', '963852741712', 'ABCDE1234Q', 1500000, 5, 12.1),
(5, 886729622386, 'wrgyrgd', '123456789012', 'QQQQQ1212Q', 200000, 6, 12.1),
(6, 886729622386, 'bhh', '741852963036', 'VVBBV1234S', 95000, 10, 12.1);

-- --------------------------------------------------------

--
-- Table structure for table `savingaccount`
--

CREATE TABLE `savingaccount` (
  `id` int(11) NOT NULL,
  `accountNumber` bigint(20) NOT NULL,
  `pin` int(11) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `DOB` varchar(50) NOT NULL,
  `mobileNumber` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `addharNumbeer` varchar(50) NOT NULL,
  `panNumber` varchar(50) NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `savingaccount`
--

INSERT INTO `savingaccount` (`id`, `accountNumber`, `pin`, `fullName`, `DOB`, `mobileNumber`, `email`, `address`, `addharNumbeer`, `panNumber`, `balance`) VALUES
(5, 886729622386, 6288, 'PrjapatiNareshHansaram', '21-05-2006', '8153800329', 'naresh@124.com', '204 horin jfpen', '123456789012', 'ABCDE1234A', 49260),
(6, 248246820924, 1414, 'SolankiSachinRmabhai', '06-06-2006', '886688662886', 'sachin@1234.com', '1349i taltej gam', '987654321012', 'ZZZZZ1234A', 50000),
(7, 350211595899, 8785, 'NNJNIN', '21-05-2006', '748596102030', 'HGVYUF@FTFY.VM', 'UBUB', '963852741014', 'MKOLP1234J', 80000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `businessloan`
--
ALTER TABLE `businessloan`
  ADD PRIMARY KEY (`loan_id`);

--
-- Indexes for table `currentaccount`
--
ALTER TABLE `currentaccount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `educationloan`
--
ALTER TABLE `educationloan`
  ADD PRIMARY KEY (`loan_id`);

--
-- Indexes for table `personalloan`
--
ALTER TABLE `personalloan`
  ADD PRIMARY KEY (`loan_id`);

--
-- Indexes for table `savingaccount`
--
ALTER TABLE `savingaccount`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `businessloan`
--
ALTER TABLE `businessloan`
  MODIFY `loan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `currentaccount`
--
ALTER TABLE `currentaccount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `educationloan`
--
ALTER TABLE `educationloan`
  MODIFY `loan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `personalloan`
--
ALTER TABLE `personalloan`
  MODIFY `loan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `savingaccount`
--
ALTER TABLE `savingaccount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
