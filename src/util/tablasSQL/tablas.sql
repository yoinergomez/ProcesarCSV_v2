-- Base de datos: `db_buscaTuCurso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CURSOS`
--

CREATE TABLE IF NOT EXISTS `CURSOS` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `FACULTAD` varchar(2) NOT NULL,
  `DEPARTAMENTO` varchar(2) NOT NULL,
  `MATERIA` varchar(3) NOT NULL,
  `GRUPO` int(2) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `AULA` varchar(10) NOT NULL,
  `HORARIO` varchar(15) NOT NULL,
  `PROFESOR` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `NOMBRE` (`NOMBRE`),
  FULLTEXT KEY `NOMBRE_2` (`NOMBRE`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4200 ;
