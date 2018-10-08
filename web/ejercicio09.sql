CREATE DATABASE IF NOT EXISTS `ejercicio-jsp-09` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ejercicio-jsp-09`;


# Dumping structure for table ejercicios.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '',
  `apellido` varchar(100) NOT NULL DEFAULT '',
  `identificacion` int(20) NOT NULL DEFAULT '0',
  `departamento` varchar(100) NOT NULL DEFAULT '',
  `sueldo` double NOT NULL DEFAULT '0',
  `transporte` double NOT NULL DEFAULT '0',
  `fdn` date NOT NULL DEFAULT '2010-01-01',
  `foto` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table ejercicios.empleado: 4 rows
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `identificacion`, `departamento`, `sueldo`, `transporte`, `fdn`, `foto`) VALUES (1, 'Mauro Cesar', 'Gomez Mejia', 1045465123, '1', 850000, 50000, '1986-07-12', '1273120244484avartaryahoo.bmp');


INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `identificacion`, `departamento`, `sueldo`, `transporte`, `fdn`, `foto`) VALUES (2, 'Sandra Patricia', 'Pinedo Florez', 1562153142, '2', 850000, 50000, '1983-03-02', '1273120579281Dibujo.bmp');


INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `identificacion`, `departamento`, `sueldo`, `transporte`, `fdn`, `foto`) VALUES (3, 'Cesar Augusto', 'Anaya Boorguez', 1225456345, '4', 850000, 50000, '1975-08-21', '1273121305343images.jpg');


INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `identificacion`, `departamento`, `sueldo`, `transporte`, `fdn`, `foto`) VALUES (4, 'Javier Andres', 'Ibarra Lopez', 1045124563, '1', 950000, 50000, '1979-09-17', '1273206286625F200811201452292577871692.jpg');