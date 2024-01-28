-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2023 at 11:28 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pemrograman_desktop`
--

-- --------------------------------------------------------

--
-- Table structure for table `ms_barang`
--

CREATE TABLE `ms_barang` (
  `kode` char(20) NOT NULL,
  `nama` char(200) NOT NULL,
  `satuan` char(100) NOT NULL,
  `harga_satuan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_barang`
--

INSERT INTO `ms_barang` (`kode`, `nama`, `satuan`, `harga_satuan`) VALUES
('001', 'DADI', '1010', 10101000),
('0012', 'BabaY', '21', 210000),
('0017', 'dada', '9', 100000),
('002', 'Lampu', '2', 10000),
('004', 'Kucing', '1', 10000),
('1', 'YUDI', '12', 100000),
('10', 'DADANG', '10', 11000),
('101', 'YUDIS', '13', 10000),
('1011', 'COBAEDIT', '1', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `ms_pelanggan`
--

CREATE TABLE `ms_pelanggan` (
  `kode` char(20) NOT NULL,
  `nama` char(200) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_pelanggan`
--

INSERT INTO `ms_pelanggan` (`kode`, `nama`, `alamat`, `telepon`) VALUES
('001', 'KOCET', 'TULIS	', '00888000'),
('001111', 'kaka', 'Bambang	', '00110011'),
('011', 'DIMAS', 'BABABAB', 'AWNJDNAW'),
('A001', 'Hermawan', 'Bandar', '08220980988'),
('A011', 'BABABABABA', 'SASASA', '080923');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ms_barang`
--
ALTER TABLE `ms_barang`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `ms_pelanggan`
--
ALTER TABLE `ms_pelanggan`
  ADD PRIMARY KEY (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
