-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2024 a las 18:39:07
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdtarea3dwes_cristimellado`
--
CREATE DATABASE IF NOT EXISTS `bdtarea3dwes_cristimellado` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdtarea3dwes_cristimellado`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `id` bigint(20) NOT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`id`, `usuario`, `password`) VALUES
(0, 'admin', 'admin'),
(2, 'cristi', 'cristi'),
(3, 'miguel', 'miguel'),
(4, 'maria', 'maria'),
(5, 'oscar', 'oscar'),
(6, 'selene', 'selene');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_planta` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`id`, `nombre`, `id_planta`) VALUES
(1, 'LAV_1', 1),
(2, 'LAV_2', 1),
(3, 'ROS_3', 2),
(4, 'ROS_4', 2),
(5, 'GIR_5', 3),
(6, 'GIR_6', 3),
(7, 'ALO_7', 4),
(8, 'ALO_8', 4),
(9, 'JAZ_9', 5),
(10, 'JAZ_10', 5),
(11, 'CAC_11', 6),
(12, 'CAC_12', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `id` bigint(20) NOT NULL,
  `fechahora` datetime(6) DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL,
  `id_ejemplar` bigint(20) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mensajes`
--

INSERT INTO `mensajes` (`id`, `fechahora`, `mensaje`, `id_ejemplar`, `id_persona`) VALUES
(1, '2024-12-10 18:23:06.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:06 CET 2024', 1, 2),
(2, '2024-12-10 18:23:15.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:15 CET 2024', 2, 2),
(3, '2024-12-10 18:23:21.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:21 CET 2024', 3, 3),
(4, '2024-12-10 18:23:23.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:23 CET 2024', 4, 3),
(5, '2024-12-10 18:23:26.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:26 CET 2024', 5, 4),
(6, '2024-12-10 18:23:29.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:29 CET 2024', 6, 4),
(7, '2024-12-10 18:23:37.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:37 CET 2024', 7, 5),
(8, '2024-12-10 18:23:41.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:41 CET 2024', 8, 5),
(9, '2024-12-10 18:23:44.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:44 CET 2024', 9, 6),
(10, '2024-12-10 18:23:46.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:46 CET 2024', 10, 6),
(11, '2024-12-10 18:23:49.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:49 CET 2024', 11, 2),
(12, '2024-12-10 18:23:51.000000', 'Mensaje inicial escrito por cristi a las Tue Dec 10 18:23:51 CET 2024', 12, 0),
(13, '2024-12-10 18:28:19.000000', 'la lavanda huele rico', 1, 2),
(14, '2024-12-10 18:31:02.000000', 'el girasol va en dirección con el sol', 5, 2),
(15, '2024-12-10 18:31:45.000000', 'el aloe vera se usa para quemaduras en la piel', 7, 3),
(16, '2024-12-10 18:32:16.000000', 'el cactus pincha', 11, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `email`, `nombre`) VALUES
(0, 'admin@hola.es', 'admin'),
(2, 'cristi@hola.es', 'cristi'),
(3, 'miguel@hola.es', 'miguel'),
(4, 'maria@hola.es', 'maria'),
(5, 'oscar@hola.es', 'oscar'),
(6, 'selene@hola.es', 'selene');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantas`
--

CREATE TABLE `plantas` (
  `id` bigint(20) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `nombre_cientifico` varchar(255) DEFAULT NULL,
  `nombre_comun` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plantas`
--

INSERT INTO `plantas` (`id`, `codigo`, `nombre_cientifico`, `nombre_comun`) VALUES
(1, 'LAV', 'lavandula angustifolia', 'lavanda'),
(2, 'ROS', 'rosa spp', 'rosa'),
(3, 'GIR', 'helianthus annuus', 'girasol'),
(4, 'ALO', 'aloe vera', 'aloe vera'),
(5, 'JAZ', 'jasminum officinale', 'jazmin'),
(6, 'CAC', 'schlumbergera truncata', 'cactus');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKgl50fmouks2ue8s9yclvv059j` (`usuario`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK44fnp4rtcs2j6ppkmkoqbtton` (`id_planta`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKidbx1mhngh3c3ry5bqisftxbv` (`id_ejemplar`),
  ADD KEY `FK2e6au5w562m7skcvx9jckiba6` (`id_persona`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKlrw7flsg11d8nhgyvueqtnp8e` (`email`);

--
-- Indices de la tabla `plantas`
--
ALTER TABLE `plantas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKbqo6lbeads0ifdh6dohhfhryp` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `plantas`
--
ALTER TABLE `plantas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `FK44fnp4rtcs2j6ppkmkoqbtton` FOREIGN KEY (`id_planta`) REFERENCES `plantas` (`id`);

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `FK2e6au5w562m7skcvx9jckiba6` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id`),
  ADD CONSTRAINT `FKidbx1mhngh3c3ry5bqisftxbv` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplares` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
