-- Base de datos: `db_buscaTuCurso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Materia`
--

CREATE TABLE IF NOT EXISTS `Materia` (
  `codigo` smallint(3) unsigned NOT NULL,
  `departamento` smallint(2) unsigned NOT NULL,
  `facultad` smallint(2) unsigned NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Grupo`
--

CREATE TABLE IF NOT EXISTS `Grupo` (
  `numero` tinyint(4) NOT NULL,
  `materia` smallint(3) NOT NULL,
  `cupo` tinyint(3) unsigned DEFAULT NULL,
  `matriculados` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`numero`,`materia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
