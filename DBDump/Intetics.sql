-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.21 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Дамп данных таблицы intetics.car: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (`id`, `make`, `model`, `year`, `VIN`, `client_Id`) VALUES
	(2, 'BMW', 'z3', '2015', '4USBT53544LT26841', 2),
	(3, 'Mazda', 'm3', '2015', 'JMZGG128241207606', 2),
	(5, 'BMW', 'M3', '2008', '3USRT56544LT23841', 3),
	(12, 'Volvo', 'xc90', '2000', '3USRT56544LT23841', 6),
	(14, 'Fiat', 'Punto', '1980', '3USRT56544LT23841', 7);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

-- Дамп данных таблицы intetics.client: ~14 rows (приблизительно)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `name`, `surname`, `birthday`, `address`, `phone`, `mail`) VALUES
	(2, 'Alex', 'Ben', '1983-06-09', 'Minsk', '+375 (29) 145-87-11', 'night_wolf_alex@tut.by'),
	(3, 'All', 'Bee', '1990-09-17', 'Minsk', '+375 (29) 127-00-01', 'All@gmail.com'),
	(6, '1', '1', '2015-09-18', 'Minsk', '+375 (29) 753-21-54', '1@1'),
	(7, '2', '2', '2015-09-17', 'MInsk', '+375 (29) 852-64-87', '2@2'),
	(8, 'Alex', 'Bee', '2015-09-02', 'Minsk', '+375 (29) 111-11-11', '3@3'),
	(9, 'Jak', 'Smit', '2015-09-09', 'Minsk', '+375 (29) 654-32-16', 'jak@gmail.com'),
	(10, 'Bill', 'Farel', '2015-09-01', 'Minsk', '+375 (29) 453-68-73', 'bill@gmail.com'),
	(11, 'Jon', 'Tiler', '2015-08-31', 'Minsk', '+375 (29) 587-64-65', 'jon@gmail.com'),
	(12, 'Eddy', 'Wong', '2015-07-16', 'Minsk', '+375 (29) 465-46-54', 'eddy@gmail.com'),
	(13, 'Adam', 'Sendler', '2015-05-07', 'Minsk', '+375 (29) 624-44-42', 'adam@gmail.com'),
	(14, 'Jon', 'Grey', '2015-06-11', 'Minsk', '+375 (29) 487-87-99', 'jon1@gmail.com'),
	(15, 'Abraham', 'Linkoln', '2015-01-07', 'Minsk', '+375 (29) 654-67-78', 'abraham@gmail.com'),
	(16, 'David', 'Blain', '2015-09-20', 'Minsk', '+375 (29) 654-56-46', 'david@gmail.com'),
	(17, 'Klint', 'Estwood', '2015-09-09', 'Minsk', '+375 (44) 654-61-68', 'klint@gmail.com'),
	(18, 'Arnold', 'Shwarzneger', '2015-09-10', 'Minsk', '+375 (29) 654-54-65', 'arnold@gmail.com'),
	(19, 'Bob', 'Sab', '2015-02-12', 'Minsk', '+375 (33) 657-78-41', 'bob@gmail.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Дамп данных таблицы intetics.order: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id`, `date`, `price`, `status`, `car_id`) VALUES
	(3, '2015-09-17', 1, 'Completed', 2),
	(6, '2015-09-17', 5.029, 'In Progress', 2),
	(7, '2015-09-19', 5000, 'Canceled', 3),
	(9, '2015-09-17', 9.999, 'Completed', 12),
	(14, '2015-09-09', 10, 'In Progress', 2);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
