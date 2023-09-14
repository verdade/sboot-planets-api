-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db:3306
-- Generation Time: Sep 14, 2023 at 04:31 PM
-- Server version: 5.7.43
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `planets`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_planets`
--

CREATE TABLE `tb_planets` (
  `id` bigint(20) NOT NULL,
  `climate` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `films` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `terrain` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_planets`
--
ALTER TABLE `tb_planets`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_planets`
--
ALTER TABLE `tb_planets`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO tb_planets
(id, name, terrain, climate, films, created_at)
VALUES(1, 'Tatooine', 'arid', 'desert', 4, '2022-07-05 20:20:39');

INSERT INTO tb_planets
(id, name, terrain, climate, films, created_at)
VALUES(2, 'Alderaan', 'grasslands, mountains', 'temperate', 2, '2022-07-05 20:20:39');

INSERT INTO tb_planets
(id, name, terrain, climate, films, created_at)
VALUES(3, 'Yavin IV', 'jungle, rainforests', 'temperate, tropical', 1, '2022-07-05 20:20:39');

INSERT INTO tb_planets
(id, name, terrain, climate, films, created_at)
VALUES(4, 'Hoth', 'tundra, ice caves, mountain ranges', 'frozen', 1, '2022-07-05 20:20:39');

INSERT INTO tb_planets
(id, name, terrain, climate, films, created_at)
VALUES(5, 'Dagobah', 'swamp, jungles', 'murky', 3, '2022-07-05 20:20:39');

INSERT INTO tb_planets
(id, name, terrain, climate, films, created_at)
VALUES(6, 'Bespin', 'gas giant', 'temperate', 1, '2022-07-05 20:20:39');

--INSERT INTO tb_planets
--(id, name, terrain, climate, films, created_at)
--VALUES(7, 'Endor', 'forests, mountains, lakes', 'temperate', 1, '2022-07-05 20:20:39');
--
--INSERT INTO tb_planets
--(id, name, terrain, climate, films, created_at)
--VALUES(8, 'Naboo', 'grassy hills, swamps, forests, mountains', 'temperate', 4, '2022-07-05 20:20:39');
