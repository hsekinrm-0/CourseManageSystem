-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2022 at 11:41 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comasy`
--

-- --------------------------------------------------------

--
-- Table structure for table `addmarks`
--

CREATE TABLE `addmarks` (
  `id` int(150) NOT NULL,
  `studentName` varchar(150) NOT NULL,
  `sub1` varchar(150) NOT NULL,
  `mark1` int(150) NOT NULL,
  `sub2` varchar(150) NOT NULL,
  `mark2` int(150) NOT NULL,
  `sub3` varchar(150) NOT NULL,
  `mark3` int(150) NOT NULL,
  `sub4` varchar(150) NOT NULL,
  `mark4` int(150) NOT NULL,
  `sub5` varchar(150) NOT NULL,
  `mark5` int(150) NOT NULL,
  `sub6` varchar(150) NOT NULL,
  `mark6` int(150) NOT NULL,
  `level` varchar(150) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `sem` varchar(255) DEFAULT NULL,
  `result` varchar(250) DEFAULT 'not updated'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addmarks`
--

INSERT INTO `addmarks` (`id`, `studentName`, `sub1`, `mark1`, `sub2`, `mark2`, `sub3`, `mark3`, `sub4`, `mark4`, `sub5`, `mark5`, `sub6`, `mark6`, `level`, `course`, `sem`, `result`) VALUES
(1, 'Ankit Maharjan', '4CI018 - Academic Skills and Team-based Learning', 83, '4CS001 - Introductory Programming and Problem Solving', 82, '4CS015 - Fundamentals of Computing', 85, '4CS016 - Embedded System Programming', 86, '4CS017 - Internet Software Architecture', 88, '4MM013 - Computational Mathematics', 82, '4', 'BIT', NULL, 'not updated'),
(2, 'upyikya rai', '5CS037 - Concepts and Technologies of AI', 76, '4MM013 - Computational Mathematics', 89, '5CS022 - Distributed and Cloud System Programming', 89, '4CS017 - Internet Software Architecture', 56, '4CS016 - Embedded System Programming', 78, '5CS019 - Object-Oriented Design and Programming', 54, '5', 'MIT', NULL, 'not updated'),
(3, 'Nikesh Shrestha ', '5CS022 - Distributed and Cloud System Programming', 65, '4CS017 - Internet Software Architecture', 69, '4CS001 - Introductory Programming and Problem Solving', 79, '4MM013 - Computational Mathematics', 85, '5CS037 - Concepts and Technologies of AI', 82, '5CS019 - Object-Oriented Design and Programming', 78, '5', 'BIT', NULL, 'not updated'),
(4, 'Gipweon Harshow', '4MM013 - Computational Mathematics', 48, '4CS016 - Embedded System Programming', 54, '4CS001 - Introductory Programming and Problem Solving', 31, '4CI018 - Academic Skills and Team-based Learning', 89, '4CS017 - Internet Software Architecture', 89, '6CS005 - High Performance Computing', 56, '6', 'BIT', '2', 'not updated');

-- --------------------------------------------------------

--
-- Table structure for table `addmodule`
--

CREATE TABLE `addmodule` (
  `id` int(255) NOT NULL,
  `module_code` varchar(250) NOT NULL,
  `module_name` varchar(255) NOT NULL,
  `level` varchar(100) NOT NULL,
  `sem` varchar(100) NOT NULL,
  `course` varchar(250) NOT NULL,
  `subject` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addmodule`
--

INSERT INTO `addmodule` (`id`, `module_code`, `module_name`, `level`, `sem`, `course`, `subject`) VALUES
(14, '4CI018', 'Academic Skills and Team-based Learning', '4', '1', 'BIT', '4CI018 - Academic Skills and Team-based Learning'),
(15, '4CS001', 'Introductory Programming and Problem Solving', '4', '1', 'BIT', '4CS001 - Introductory Programming and Problem Solving'),
(16, '4CS015', 'Fundamentals of Computing', '4', '1', 'BIT', '4CS015 - Fundamentals of Computing'),
(17, '4CS016', 'Embedded System Programming', '4', '2', 'BIT', '4CS016 - Embedded System Programming'),
(18, '4CS017', 'Internet Software Architecture', '4', '2', 'BIT', '4CS017 - Internet Software Architecture'),
(19, '4MM013', 'Computational Mathematics', '4', '2', 'BIT', '4MM013 - Computational Mathematics'),
(20, '5CS037', 'Concepts and Technologies of AI', '5', '1', 'BIT', '5CS037 - Concepts and Technologies of AI'),
(21, '5CS019', 'Object-Oriented Design and Programming', '5', '1', 'BIT', '5CS019 - Object-Oriented Design and Programming'),
(22, '5CS021', 'Numerical Methods and Concurrency', '5', '1', 'BIT', '5CS021 - Numerical Methods and Concurrency'),
(23, '5CS022', 'Distributed and Cloud System Programming', '5', '2', 'BIT', '5CS022 - Distributed and Cloud System Programming'),
(24, '5CS024', 'Collaborative Development', '5', '2', 'BIT', '5CS024 - Collaborative Development'),
(25, '5CS020', 'Human Computer Interaction', '5', '2', 'BIT', '5CS020 - Human Computer Interaction'),
(26, '6CS014', 'Complex System', '6', '1', 'BIT', '6CS014 - Complex System'),
(27, '6CS005', 'High Performance Computing', '6', '1', 'BIT', '6CS005 - High Performance Computing'),
(28, '6CS007', 'Project and Professionalism', '6', '1', 'BIT', '6CS007 - Project and Professionalism'),
(29, '6CS012', 'Artificial Intelligence and Machine Learning', '6', '1', 'BIT', '6CS012 - Artificial Intelligence and Machine Learning'),
(30, '6CS030 ', 'Big Data ', '6', '1', 'BIT', '6CS030  - Big Data '),
(40, 'R4Y4', 'RERE', '5', '', 'BIT', 'R4Y4 - RERE');

-- --------------------------------------------------------

--
-- Table structure for table `adminlog`
--

CREATE TABLE `adminlog` (
  `id` int(160) NOT NULL,
  `username` varchar(140) NOT NULL,
  `password` varchar(140) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlog`
--

INSERT INTO `adminlog` (`id`, `username`, `password`) VALUES
(1, 'admin', 'apass');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(160) NOT NULL,
  `courseID` varchar(140) NOT NULL,
  `coursename` varchar(140) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `courseID`, `coursename`) VALUES
(11, '1', 'BIT'),
(12, '2', 'BIBM'),
(13, '3', 'MIT'),
(14, '4', 'BBA');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` int(150) NOT NULL,
  `module_code` varchar(50) NOT NULL,
  `category_slug` varchar(255) NOT NULL,
  `mname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `module_code`, `category_slug`, `mname`) VALUES
(1, 'ttrto', 'ytyy', 'update'),
(2, 'ttrto', 'ytyy', 'update'),
(3, 'drhfdrfh', 'erffr', 'trfe'),
(4, 'update', 'boom', 'hijo');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gpa` varchar(255) NOT NULL,
  `father_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `firstName`, `lastName`, `sex`, `course`, `email`, `Address`, `password`, `gpa`, `father_name`) VALUES
(1, 'Nikesh', 'Shrestha', 'Male', 'BIT', 'nike123@gmail.com', 'Lalitpur', 'pass', '3.96', 'Anil Shrestha'),
(2, 'Ankita', 'Shrestha', 'Female', 'MIT', 'aki22@gmail.com', 'sundhara', 'apass', '4.0', 'Anak Shrestha');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(255) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `level` varchar(255) NOT NULL,
  `sem` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `teacher_name`, `course`, `level`, `sem`, `subject`) VALUES
(4, 'Deepson Shrrestha ', 'BIT', '4', '2', '4CS017 - Internet Software Architecture'),
(6, 'Kritika Tuladar', 'BIT', '4', '1', '4CI018 - Academic Skills and Team-based Learning'),
(7, 'Bishal Khadka', 'BIT', '4', '1', '4CS001 - Introductory Programming and Problem Solving'),
(8, 'Subash Sir', 'BIT', '4', '2', '4CS015 - Fundamentals of Computing'),
(9, 'Sachin Kafle', 'BIT', '5', '2', '4MM013 - Computational Mathematics'),
(10, 'Anmol Adhakari', 'BIT', '5', '1', '5CS021 - Numerical Methods and Concurrency');

-- --------------------------------------------------------

--
-- Table structure for table `teacherlog`
--

CREATE TABLE `teacherlog` (
  `id` int(160) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacherlog`
--

INSERT INTO `teacherlog` (`id`, `username`, `password`) VALUES
(1, 'teacher', 'tpass');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addmarks`
--
ALTER TABLE `addmarks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `addmodule`
--
ALTER TABLE `addmodule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adminlog`
--
ALTER TABLE `adminlog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacherlog`
--
ALTER TABLE `teacherlog`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addmarks`
--
ALTER TABLE `addmarks`
  MODIFY `id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `addmodule`
--
ALTER TABLE `addmodule`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `adminlog`
--
ALTER TABLE `adminlog`
  MODIFY `id` int(160) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(160) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `teacherlog`
--
ALTER TABLE `teacherlog`
  MODIFY `id` int(160) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
