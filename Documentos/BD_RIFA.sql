--
-- Base de datos: `rifa`
--
CREATE DATABASE IF NOT EXISTS `rifa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `rifa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numero_rifa`
--

CREATE TABLE IF NOT EXISTS `numero_rifa` (
  `RIFA_NUMERO` int(11) NOT NULL,
  `RIFA_NOMBRE` varchar(50) NULL DEFAULT NULL,
  `RIFA_FECHA` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`RIFA_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;