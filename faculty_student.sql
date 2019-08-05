-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 05, 2019 at 12:49 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `faculty_student`
--

-- --------------------------------------------------------

--
-- Table structure for table `level_of_study`
--

CREATE TABLE `level_of_study` (
  `id` int(11) NOT NULL,
  `level` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level_of_study`
--

INSERT INTO `level_of_study` (`id`, `level`) VALUES
(1, 'Undergraduate studies'),
(2, 'Master studies'),
(3, 'PhD studies');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `index_number` int(11) NOT NULL,
  `level_of_study_id` int(11) NOT NULL,
  `year_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `first_name`, `last_name`, `index_number`, `level_of_study_id`, `year_id`) VALUES
(102, 'Nancy', 'Davolio', 3242, 1, 2),
(103, 'Andrew', 'Fuller', 32432, 1, 1),
(104, 'Janet', 'Leverling', 324, 1, 4),
(105, 'Margaret', 'Peacock', 432, 2, 1),
(106, 'Steven', 'Buchanan', 4532, 3, 1),
(107, 'Michael', 'Suyama', 23, 3, 3),
(108, 'Robert', 'King', 2343, 1, 1),
(109, 'Laura', 'Callahan', 34, 1, 2),
(110, 'Anne', 'Dodsworth', 343, 1, 4),
(111, 'Andrew', 'Fuller', 32432, 1, 1),
(112, 'Alan', 'Mark', 213, 3, 2),
(113, 'Pina', 'Bollen', 23232, 3, 1),
(114, 'John', 'Goud', 1218, 2, 1),
(115, 'Phoebe', 'Park', 23456, 1, 2),
(116, 'Piper', 'Stone', 543, 3, 2),
(117, 'Don', 'Smith', 34326, 3, 3),
(118, 'Mia', 'Lowet', 2199, 3, 3),
(119, 'Andrew', 'Stanway', 656, 1, 4),
(120, 'John', 'Swith', 5654, 1, 1),
(121, 'Philipe', 'Tish', 8988, 1, 3),
(122, 'James', 'Kolling', 34390, 3, 3),
(123, 'Col', 'Turner', 87987, 3, 2),
(124, 'Set', 'Gruden', 9893, 3, 2),
(125, 'Din', 'Koler', 324, 2, 1),
(126, 'Pol', 'Yang', 324321, 2, 1),
(127, 'Bree', 'Watson', 933, 3, 2),
(128, 'Eva', 'Stone', 6546, 2, 1),
(129, 'Mario', 'Kolstner', 32564, 2, 1),
(130, 'Bree', 'Sores', 12314, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `adress` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `confirm_password` varchar(30) NOT NULL,
  `user_privileges_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `surname`, `email`, `adress`, `number`, `user_name`, `password`, `confirm_password`, `user_privileges_id`) VALUES
(1, 'admin', 'admin', 'admin@gmail.com', 'admin', '1111', 'admin', 'admin', 'admin', 1),
(5, 'Milan', 'Mihajlovic', 'milan@gmail.com', '', '12345', 'milan', 'milan', 'milan', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_privileges`
--

CREATE TABLE `user_privileges` (
  `id` int(11) NOT NULL,
  `type_of_user` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_privileges`
--

INSERT INTO `user_privileges` (`id`, `type_of_user`) VALUES
(1, 'Admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `year_of_study`
--

CREATE TABLE `year_of_study` (
  `id` int(11) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `year_of_study`
--

INSERT INTO `year_of_study` (`id`, `year`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `level_of_study`
--
ALTER TABLE `level_of_study`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `level_of_study_id` (`level_of_study_id`,`year_id`),
  ADD KEY `year_id` (`year_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`,`user_name`),
  ADD KEY `user_privileges_id` (`user_privileges_id`);

--
-- Indexes for table `user_privileges`
--
ALTER TABLE `user_privileges`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `year_of_study`
--
ALTER TABLE `year_of_study`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `level_of_study`
--
ALTER TABLE `level_of_study`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_privileges`
--
ALTER TABLE `user_privileges`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `year_of_study`
--
ALTER TABLE `year_of_study`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`level_of_study_id`) REFERENCES `level_of_study` (`id`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`year_id`) REFERENCES `year_of_study` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_privileges_id`) REFERENCES `user_privileges` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
