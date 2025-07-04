-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jun 2025 pada 18.25
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_kendaraan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobil`
--

CREATE TABLE `mobil` (
  `plat` varchar(8) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `hargaSewa` int(11) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mobil`
--

INSERT INTO `mobil` (`plat`, `tipe`, `merk`, `hargaSewa`, `status`) VALUES
('AB 111', 'Innova', 'Toyota', 200000, 1),
('AB 222', 'Fortuner', 'Toyota', 300000, 0),
('AB 333', 'Brio', 'Honda', 150000, 0),
('AB 555', 'Jazz', 'Honda', 80000, 0),
('AB 999', 'Hilux', 'Toyota', 100000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `motor`
--

CREATE TABLE `motor` (
  `plat` varchar(8) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `hargaSewa` int(11) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `motor`
--

INSERT INTO `motor` (`plat`, `tipe`, `merk`, `hargaSewa`, `status`) VALUES
('AD 111', 'Aerox', 'Yamaha', 50000, 1),
('AD 222', 'N MAX', 'Yamaha', 70000, 0),
('AD 333', 'Scoopy', 'Honda', 40000, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `platKendaraan` varchar(8) NOT NULL,
  `namaPenyewa` varchar(20) NOT NULL,
  `TanggalPenyewaan` date NOT NULL,
  `TanggalPengembalian` date NOT NULL,
  `totalBayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `platKendaraan`, `namaPenyewa`, `TanggalPenyewaan`, `TanggalPengembalian`, `totalBayar`) VALUES
(1, 'AB 222', 'GaryFaldi', '2025-06-03', '2025-06-06', 900000),
(2, 'AB 222', 'GaryFaldi2', '2025-06-03', '2025-06-06', 900000),
(3, 'AD 222', 'gary', '2025-06-03', '2025-06-08', 350000),
(4, 'AB 333', 'Gary', '2025-06-03', '2025-06-05', 300000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(1, 'garyfaldi', '1234', 'user'),
(3, 'admin', '1234', 'admin'),
(4, 'akmal', '123', 'admin'),
(5, 'akmal4', '321', 'admin'),
(6, 'akmall', '234', 'admin'),
(7, 'danendra', '123', 'user'),
(8, 'maulana', '123', 'user'),
(9, 'G', '123', 'user');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`plat`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
