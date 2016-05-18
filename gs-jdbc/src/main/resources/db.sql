DROP TABLE IF EXISTS account;


CREATE TABLE account (
  id int(11) NOT NULL AUTO_INCREMENT,
  birthday datetime DEFAULT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) NOT NULL,
  sex int(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_avh1b2ec82audum2lyjx2p1ws (email)
);

INSERT INTO account (id,birthday,email,name,password,sex) VALUES
 (1,'2006-07-08','admin@gmail.com','admin','123',1),
 (2,'2006-07-08','tom@gmail.com','tom','567',2);