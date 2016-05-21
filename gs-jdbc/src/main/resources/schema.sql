DROP DATABASE `gs-jdbc`;
CREATE DATABASE `gs-jdbc`;
USE `gs-jdbc`;
DROP TABLE IF EXISTS USERS;
CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);