CREATE DATABASE IF NOT EXISTS `sistema_evaluacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `sistema_evaluacion`;

-- Dumping structure for table sistema_evaluacion.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `categories` (`id`, `description`, `title`) VALUES
	(1, 'La Programación Orientada a Objetos es un paradigma de programación que parte del concepto de "objetos" como base, los cuales contienen información en forma de campos y código en forma de métodos.', 'Programacion Orientada a Objetos'),
	(2, 'Una base de datos es un conjunto de datos estructurados que pertenecen a un mismo contexto y, en cuanto a su función, se utiliza para administrar de forma electrónica grandes cantidades de información.', 'Bases de Datos');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.evaluations
CREATE TABLE IF NOT EXISTS `evaluations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `number_question` int(11) DEFAULT NULL,
  `point_max` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3vw9vpand764x0wa6r8d8xy9f` (`category_id`),
  CONSTRAINT `FK3vw9vpand764x0wa6r8d8xy9f` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sistema_evaluacion.evaluations: ~3 rows (approximately)
/*!40000 ALTER TABLE `evaluations` DISABLE KEYS */;
INSERT INTO `evaluations` (`id`, `description`, `enable`, `number_question`, `point_max`, `title`, `category_id`) VALUES
	(1, 'Esta evaluación busca conocer los conocimientos básicos de la programación orientada objetos ', b'1', 5, 100, 'Conceptos básicos de la POO', 1),
	(2, 'Esta evaluación busca conocer los conocimientos básicos acerca de las bases de datos', b'1', 4, 50, 'Conceptos básicos de bases de datos', 2),
	(3, 'Esta evaluación busca conocer los conocimientos acerca de la base de datos my sql', b'1', 3, 100, 'MySQL', 2);
/*!40000 ALTER TABLE `evaluations` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.questions
CREATE TABLE IF NOT EXISTS `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `response_correct` varchar(255) DEFAULT NULL,
  `evaluation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpalpkxa3k849n8ekpjg59rb1t` (`evaluation_id`),
  CONSTRAINT `FKpalpkxa3k849n8ekpjg59rb1t` FOREIGN KEY (`evaluation_id`) REFERENCES `evaluations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sistema_evaluacion.questions: ~12 rows (approximately)
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`id`, `content`, `option1`, `option2`, `option3`, `option4`, `response_correct`, `evaluation_id`) VALUES
	(1, '¿Cuáles son los principios cuatro principios básicos de la programación orientada a objetos?', 'Concurrencia, encapsulamiento, polimorfismo y abstracción', 'Encapsulamiento, polimorfismo, concurrencia, y recursividad', 'Inyección de dependencias, clase, polimorfismo y encapsulamiento', 'Abstracción, encapsulamiento, polimorfismo y herencia', 'Abstracción, encapsulamiento, polimorfismo y herencia', 1),
	(2, '¿Cuál es la descripción que crees que define mejor el concepto \'clase\' en la programación orientada a objetos?', 'Es un concepto similar al de \'array\'', 'Es un tipo particular de variable', 'Es un modelo o plantilla a partir de la cual creamos objetos', 'Es una categoria de datos ordenada secuencialmente', 'Es un modelo o plantilla a partir de la cual creamos objetos', 1),
	(3, '¿Qué elementos crees que definen a un objeto?', 'Sus cardinalidad y su tipo', 'La forma en que establece comunicación e intercambia mensajes', 'Sus atributos y sus métodos', 'Su interfaz y los eventos asociados', 'Sus atributos y sus métodos', 1),
	(4, ' ¿Qué código de los siguientes tiene que ver con la herencia?', 'public class Componente extends Producto', 'public class Componente inherit Producto', 'public class Componente implements Producto', 'public class Componente belong to Producto', 'public class Componente extends Producto', 1),
	(5, '¿Qué significa instanciar una clase?', 'Duplicar una clase', 'Eliminar una clase', 'Crear un objeto a partir de la clase', 'Conectar dos clases entre sí', 'Crear un objeto a partir de la clase', 1),
	(6, '¿Cuándo las bases de datos tienen diferentes tablas con campos comunes se les llama?', 'Bases de datos comunes', 'Bases de datos relacional', 'Bases de datos no relacional', 'Bases de datos enlazadas', 'Bases de datos relacional', 2),
	(7, 'Cuales son las tres acciones básicas que debe permitir un gestor de bases de datos', 'Transformar, agrupar y recuperar los datos', 'Recuperar, insertar y transformar la información', 'Insertar, recuperar y almacenar los datos', 'Transformar, agrupar y almacenar los datos', 'insertar, recuperar y almacenar los datos', 2),
	(8, '¿Qué  es un dato ?', ' Colección de archivos relacionados', 'Conjunto de datos ordenados', 'Conjunto de caracteres con algún significado', 'Es un tipo de información', 'Conjunto de caracteres con algún significado', 2),
	(9, '\nLa información esta compuesta de', 'Datos', 'Sistema', 'Información', 'Tablas', 'Datos', 2),
	(10, '¿MySQL es?', 'Un lenguaje de programación', 'Una técnica para escribir programas confiables', '  Un sistema de gestión de bases de datos relacionales', 'Una base de datos', '  Un sistema de gestión de bases de datos relacionales', 3),
	(11, '¿Qué enunciado SQL se utiliza para insertar nuevos datos en una base de datos?', '  INSERT INTO', 'UPDATE', 'ADD', '  INSERT NEW', '  INSERT INTO', 3),
	(12, '¿Cuál de los siguientes comandos se utiliza para eliminar toda la base de datos MySQL?', ' Mysql_drop_database', 'Mysql_drop_entiredb', 'Mysql_drop_table', 'Mysql_drop_tables', ' Mysql_drop_database', 3);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.rols
CREATE TABLE IF NOT EXISTS `rols` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sistema_evaluacion.rols: ~2 rows (approximately)
/*!40000 ALTER TABLE `rols` DISABLE KEYS */;
INSERT INTO `rols` (`id`, `name`) VALUES
	(1, 'administrador'),
	(2, 'normal');
/*!40000 ALTER TABLE `rols` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sistema_evaluacion.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `enable`, `lastname`, `name`, `password`, `profile`, `telephone`, `username`) VALUES
	(1, 'administrador@gmail.com', b'1', 'Administrador', 'Giorman', '$2a$10$xaWkKYR8f0cF.LgyMyobwuFMnOl94qch0GwyMtNkRQ98kyiuatuji', 'default.png', '0', 'admin'),
	(2, 'normal@gmail.com', b'1', 'Normal', 'Giorman', '$2a$10$dgeDSFv5S9tKxHYdlDCDO.DaFxkAC.Sl/8up/UvDKFQhndUdSakxm', 'default.png', '0', 'normal');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table sistema_evaluacion.users_rols
CREATE TABLE IF NOT EXISTS `users_rols` (
  `user_id` bigint(20) NOT NULL,
  `rol_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rol_id`,`user_id`),
  KEY `FKeck3xcnvcvc3wuyytw9lcribr` (`user_id`),
  CONSTRAINT `FKeck3xcnvcvc3wuyytw9lcribr` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKgr0k3ky7tj1046wywamix34sp` FOREIGN KEY (`rol_id`) REFERENCES `rols` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sistema_evaluacion.users_rols: ~2 rows (approximately)
/*!40000 ALTER TABLE `users_rols` DISABLE KEYS */;
INSERT INTO `users_rols` (`user_id`, `rol_id`) VALUES
	(1, 1),
	(2, 2);

