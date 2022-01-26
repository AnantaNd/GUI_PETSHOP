-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Jan 2022 pada 04.46
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `petshop`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin_login`
--

CREATE TABLE `admin_login` (
  `user` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin_login`
--

INSERT INTO `admin_login` (`user`, `pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `aksesoris`
--

CREATE TABLE `aksesoris` (
  `aksesoris_id` int(11) NOT NULL,
  `aksesoris` varchar(20) NOT NULL,
  `ket` mediumtext NOT NULL,
  `qnty` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `aksesoris`
--

INSERT INTO `aksesoris` (`aksesoris_id`, `aksesoris`, `ket`, `qnty`, `harga`) VALUES
(2, 'Chew', 'Mainan kunyah untuk peliharaan', 10, 2000),
(3, 'Brush', 'Sisir untuk peliharaan', 15, 5000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `anjing`
--

CREATE TABLE `anjing` (
  `id_anjing` int(11) NOT NULL,
  `jenis_anjing` varchar(50) NOT NULL,
  `nama_anjing` varchar(50) NOT NULL,
  `umur_anjing` int(30) NOT NULL,
  `gender` char(10) NOT NULL,
  `harga_anjing` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anjing`
--

INSERT INTO `anjing` (`id_anjing`, `jenis_anjing`, `nama_anjing`, `umur_anjing`, `gender`, `harga_anjing`) VALUES
(3, 'Shiba Inu', 'Jiro', 1, 'Jantan', 40000),
(4, 'Siberian Husky', 'Daisy', 3, 'Betina', 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `cart`
--

CREATE TABLE `cart` (
  `id` int(10) NOT NULL,
  `nama_cust` varchar(250) NOT NULL,
  `nama_produk` varchar(100) NOT NULL,
  `harga` int(100) NOT NULL,
  `no_hp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `cart`
--

INSERT INTO `cart` (`id`, `nama_cust`, `nama_produk`, `harga`, `no_hp`) VALUES
(9, 'Dede', 'Bony', 10000, '08123456789'),
(19, 'abang', 'berus', 100000, '08912345'),
(27, 'abang', 'Bony', 10000, '08912345'),
(28, 'abang', 'Leash', 1000, '08912345'),
(29, 'abang', 'Inoe', 40000, '08912345');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kucing`
--

CREATE TABLE `kucing` (
  `id_kucing` int(11) NOT NULL,
  `jenis_kucing` varchar(50) NOT NULL,
  `nama_kucing` varchar(50) NOT NULL,
  `umur_kucing` int(30) NOT NULL,
  `gender` char(10) NOT NULL,
  `harga_kucing` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kucing`
--

INSERT INTO `kucing` (`id_kucing`, `jenis_kucing`, `nama_kucing`, `umur_kucing`, `gender`, `harga_kucing`) VALUES
(2, 'Kampung ', 'Oji', 4, 'Jantan', 5000),
(3, 'Persian', 'Cleo', 1, 'Jantan', 30000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_customer` int(11) NOT NULL,
  `nama_customer` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_hp` varchar(13) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_customer`, `nama_customer`, `alamat`, `no_hp`, `user`, `pass`) VALUES
(1, 'Dede', 'Rumah Dede', '08123456789', 'dede_kyut', 'passwordDede'),
(2, 'Yuni', 'Rumah Yuni', '083689546792', 'yuni123', 'passwordYuni'),
(4, 'abang', 'dirumah abang', '08912345', 'abang', 'abang123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `aksesoris`
--
ALTER TABLE `aksesoris`
  ADD PRIMARY KEY (`aksesoris_id`);

--
-- Indeks untuk tabel `anjing`
--
ALTER TABLE `anjing`
  ADD PRIMARY KEY (`id_anjing`);

--
-- Indeks untuk tabel `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `kucing`
--
ALTER TABLE `kucing`
  ADD PRIMARY KEY (`id_kucing`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_customer`),
  ADD UNIQUE KEY `user` (`user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `aksesoris`
--
ALTER TABLE `aksesoris`
  MODIFY `aksesoris_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `anjing`
--
ALTER TABLE `anjing`
  MODIFY `id_anjing` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT untuk tabel `kucing`
--
ALTER TABLE `kucing`
  MODIFY `id_kucing` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
