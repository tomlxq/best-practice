Create DATABASE `gs-jdbc`;
USE `gs-jdbc`;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
  id int(11) NOT NULL AUTO_INCREMENT,
  birthday datetime DEFAULT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) NOT NULL,
  sex int(1) NOT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY UK_avh1b2ec82audum2lyjx2p1ws (email)
);
CREATE TABLE department (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  user_id int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE roles (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) NOT NULL,
  user_id int(11) DEFAULT NULL,
  PRIMARY KEY (role_id),
  FOREIGN KEY (user_id) REFERENCES accounts (id)
);

