-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 13, 2019 at 10:20 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `TicTacToe`
--

-- --------------------------------------------------------

--
-- Table structure for table `Player`
--

CREATE TABLE `Player` (
  `Player_Id` int(11) NOT NULL,
  `Player_Name` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Player`
--

INSERT INTO `Player` (`Player_Id`, `Player_Name`, `Password`) VALUES
(1, 'mohamed', '123456789'),
(2, 'mohamedd', '123456789'),
(3, 'mohamedgg', '123456789'),
(4, 'hazem', '123456789'),
(5, 'fahmy', '123456789'),
(6, 'wehba', '123456789'),
(7, 'mego', '123456789'),
(8, 'sherif', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `XOGame`
--

CREATE TABLE `XOGame` (
  `XOGame_ID` int(11) NOT NULL,
  `Player1` int(11) NOT NULL,
  `Player2` int(11) DEFAULT NULL,
  `Winner` enum('player1','player2','no_one') NOT NULL DEFAULT 'no_one',
  `states` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Player`
--
ALTER TABLE `Player`
  ADD PRIMARY KEY (`Player_Id`),
  ADD UNIQUE KEY `Player_Name` (`Player_Name`),
  ADD KEY `Player_Id` (`Player_Id`);

--
-- Indexes for table `XOGame`
--
ALTER TABLE `XOGame`
  ADD PRIMARY KEY (`XOGame_ID`),
  ADD KEY `Player1` (`Player1`,`Player2`),
  ADD KEY `Player2` (`Player2`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Player`
--
ALTER TABLE `Player`
  MODIFY `Player_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `XOGame`
--
ALTER TABLE `XOGame`
  MODIFY `XOGame_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `XOGame`
--
ALTER TABLE `XOGame`
  ADD CONSTRAINT `XOGame_ibfk_1` FOREIGN KEY (`Player1`) REFERENCES `Player` (`Player_Id`),
  ADD CONSTRAINT `XOGame_ibfk_2` FOREIGN KEY (`Player2`) REFERENCES `Player` (`Player_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
