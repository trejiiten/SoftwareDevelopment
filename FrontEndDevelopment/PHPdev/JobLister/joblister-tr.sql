-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 25, 2018 at 04:15 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joblister`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Business'),
(2, 'Construction'),
(3, 'Education'),
(4, 'Health Care'),
(5, 'Retail'),
(6, 'Technology');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `company` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `job_title` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `salary` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `location` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `contact_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `contact_email` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `post_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `category_id`, `company`, `job_title`, `description`, `salary`, `location`, `contact_user`, `contact_email`, `post_date`) VALUES
(1, 1, '\0J\0S\0 \0I\0n\0c\0.', 'Senior Accounts Manager', 'Everybody needs a friend. Be careful. You can always add more - but you can\'t take it away. I sincerely wish for you every possible joy life could bring. I thought today we would make a happy little stream that\'s just running through the woods here. Just ', '110K', 'Westfax', 'Todd Rings', 'Todd@test.com', '2018-07-21 12:10:27'),
(3, 3, 'Yonsei University', 'Associate Professor', 'Everybody needs a friend. Be careful. You can always add more - but you can\'t take it away. I sincerely wish for you every possible joy life could bring. I thought today we would make a happy little stream that\'s just running through the woods here. Just ', '55K', 'Wonju', 'Todd Rings', 'Todd@test.com', '2018-07-21 12:10:27'),
(4, 4, 'EPIC Systems', 'Product Tester', 'Everybody needs a friend. Be careful. You can always add more - but you can\'t take it away. I sincerely wish for you every possible joy life could bring. I thought today we would make a happy little stream that\'s just running through the woods here. Just ', '70K', 'Madison', 'Todd Rings', 'Todd@test.com', '2018-07-21 12:10:27'),
(6, 6, '\0CyberCoders', 'Front End Developer', 'Everybody needs a friend. Be careful. You can always add more - but you can\'t take it away. I sincerely wish for you every possible joy life could bring. I thought today we would make a happy little stream that\'s just running through the woods here. Just ', 'Seattle', '90K', 'Todd Rings', 'Todd@test.com', '2018-07-21 12:10:27'),
(9, 6, 'IT Love, Inc.', 'Jr Developer', 'I think there\'s an artist hidden in the bottom of every single one of us. And I will hypnotize that just a little bit. Let\'s put some happy little bushes on the other side now. But they\'re very easily killed. Clouds are delicate.', '85k', 'New York', 'Todd Rings', 'Todd@test.com', '2018-07-25 01:51:46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
