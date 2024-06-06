-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 06 Cze 2024, 23:40
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `automobiles`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `automobiles`
--

CREATE TABLE `automobiles` (
  `id` int(11) NOT NULL,
  `category` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `manufacture_year` int(11) NOT NULL,
  `fuel_usage` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `automobiles`
--

INSERT INTO `automobiles` (`id`, `category`, `brand`, `manufacture_year`, `fuel_usage`) VALUES
(1, 'osobowy', 'Toyota', 2020, '7.50'),
(2, 'ciężarowy', 'Volvo', 2019, '15.30'),
(3, 'F1', 'Ferrari', 2021, '30.00'),
(4, 'dostawczy', 'Ford', 2018, '10.20'),
(5, 'osobowy', 'Honda', 2020, '6.80'),
(6, 'ciężarowy', 'MAN', 2017, '14.70'),
(7, 'F1', 'Mercedes', 2022, '28.50'),
(8, 'dostawczy', 'Renault', 2019, '9.90'),
(9, 'osobowy', 'BMW', 2021, '7.10'),
(10, 'ciężarowy', 'Scania', 2020, '16.00'),
(11, 'F1', 'Red Bull Racing', 2021, '29.80'),
(12, 'dostawczy', 'Peugeot', 2018, '11.00');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `automobiles`
--
ALTER TABLE `automobiles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `automobiles`
--
ALTER TABLE `automobiles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
