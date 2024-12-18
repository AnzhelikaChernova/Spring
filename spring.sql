
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `courseid` bigint(20) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

INSERT INTO `course` (`courseid`, `coursename`) VALUES
(1, 'Programming Logic'),
(2, 'Programming'),
(3, 'Data Structure'),
(4, 'Database'),
(5, 'Software Engineering'),
(6, 'People Management');



DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

INSERT INTO `student` (`id`, `department`, `email`, `firstname`, `lastname`) VALUES
(1, 'TI', 'john@mayer.com', 'John', 'Mayer'),
(2, 'RH', 'mary@jane.com', 'Mary', 'Jane'),
(3, 'TI', 'stephany@alba.com', 'Stephany', 'Alba');



DROP TABLE IF EXISTS `student_course`;
CREATE TABLE IF NOT EXISTS `student_course` (
  `id` bigint(20) NOT NULL,
  `courseid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`courseid`),
  KEY `courseid` (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `student_course` (`id`, `courseid`) VALUES
(1, 1),
(2, 1),
(3, 1),
(1, 2),
(1, 3),
(2, 3),
(3, 6);

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;


INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER', 'user'),
(2, '$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2', 'ADMIN', 'admin');

ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

