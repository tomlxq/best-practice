drop table if exists `user`;
CREATE TABLE IF NOT EXISTS `user`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `nick_name`    varchar(50) DEFAULT NULL,
    `phone_number` varchar(11) DEFAULT NULL,
    `sex`          varchar(20) DEFAULT NULL,
    `age`          int(11)     DEFAULT NULL,
    `birthday`     datetime    DEFAULT NULL,
    `status`       varchar(10) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

drop table if exists `account`;
CREATE TABLE account
(
    id    INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME  VARCHAR(20) NOT NULL,
    money DOUBLE(10, 2)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;