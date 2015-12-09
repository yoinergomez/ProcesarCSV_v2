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
  `codigo` smallint(3) unsigned NOT NULL,
  `departamento` smallint(2) unsigned NOT NULL,
  `facultad` smallint(2) unsigned NOT NULL,
  `numero` smallint(3) unsigned NOT NULL,
  `cupo` smallint(3) unsigned DEFAULT NULL,
  `matriculados` smallint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`, `numero`),
  FOREIGN KEY (`codigo`,`departamento`, `facultad`)
      REFERENCES Materia(`codigo`,`departamento`, `facultad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Profesor`
--

CREATE TABLE IF NOT EXISTS `Profesor` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GrupoProfesor`
--

CREATE TABLE IF NOT EXISTS `GrupoProfesor` (
  `codigo` smallint(3) unsigned NOT NULL,
  `departamento` smallint(2) unsigned NOT NULL,
  `facultad` smallint(2) unsigned NOT NULL,
  `numero` smallint(3) unsigned NOT NULL,
  `cedula` int(11) NOT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`, `numero`, `cedula`),
  FOREIGN KEY (`codigo`,`departamento`, `facultad`, `numero`)
      REFERENCES Grupo(`codigo`,`departamento`, `facultad`, `numero`),
  FOREIGN KEY (`cedula`)
      REFERENCES Profesor(`cedula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
