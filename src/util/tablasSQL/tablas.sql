-- Base de datos: `db_buscaTuCurso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Materia`
--

CREATE TABLE IF NOT EXISTS `Materia` (
  `codigo` varchar(3) NOT NULL,
  `departamento` varchar(2) NOT NULL,
  `facultad` varchar(2) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Grupo`
--

CREATE TABLE IF NOT EXISTS `Grupo` (
  `codigo` varchar(3) NOT NULL,
  `departamento` varchar(2) NOT NULL,
  `facultad` varchar(2) NOT NULL,
  `numero` varchar(3) NOT NULL,
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
  `codigo` varchar(3) NOT NULL,
  `departamento` varchar(2) NOT NULL,
  `facultad` varchar(2) NOT NULL,
  `numero` varchar(3) NOT NULL,
  `cedula` int(11) NOT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`, `numero`, `cedula`),
  FOREIGN KEY (`codigo`,`departamento`, `facultad`, `numero`)
      REFERENCES Grupo(`codigo`,`departamento`, `facultad`, `numero`),
  FOREIGN KEY (`cedula`)
      REFERENCES Profesor(`cedula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Aula`
--

CREATE TABLE IF NOT EXISTS `Aula` (
  `aula` varchar(10) NOT NULL,
  PRIMARY KEY (`aula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GrupoAula`
--

CREATE TABLE IF NOT EXISTS `GrupoAula` (
  `codigo` varchar(3) NOT NULL,
  `departamento` varchar(2) NOT NULL,
  `facultad` varchar(2) NOT NULL,
  `numero` varchar(3) NOT NULL,
  `aula` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`, `numero`, `aula`),
  FOREIGN KEY (`codigo`,`departamento`, `facultad`, `numero`)
      REFERENCES Grupo(`codigo`,`departamento`, `facultad`, `numero`),
  FOREIGN KEY (`aula`)
      REFERENCES Aula(`aula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Horario`
--

CREATE TABLE IF NOT EXISTS `Horario` (
  `horario` varchar(20) NOT NULL,
  PRIMARY KEY (`horario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GrupoHorario`
--

CREATE TABLE IF NOT EXISTS `GrupoHorario` (
  `codigo` varchar(3) NOT NULL,
  `departamento` varchar(2) NOT NULL,
  `facultad` varchar(2) NOT NULL,
  `numero` varchar(3) NOT NULL,
  `horario` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`,`departamento`, `facultad`, `numero`, `horario`),
  FOREIGN KEY (`codigo`,`departamento`, `facultad`, `numero`)
      REFERENCES Grupo(`codigo`,`departamento`, `facultad`, `numero`),
  FOREIGN KEY (`horario`)
      REFERENCES Horario(`horario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
