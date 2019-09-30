DROP DATABASE `gs-jdbc`;
CREATE DATABASE `gs-jdbc`;
USE `gs-jdbc`;
DROP TABLE IF EXISTS USERS;
CREATE TABLE `t_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                          `age` int(3) DEFAULT NULL,
                          `password` varchar(20) DEFAULT NULL,
                          `created_date` datetime DEFAULT CURRENT_TIMESTAMP(),
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;