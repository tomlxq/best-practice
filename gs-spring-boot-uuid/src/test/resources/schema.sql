CREATE TABLE `unique_id`
(
    `id`  bigint  NOT NULL AUTO_INCREMENT,
    `biz` char(1) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `biz` (`biz`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE id_generator
(
    id       int(10)    NOT NULL,
    max_id   bigint(20) NOT NULL COMMENT '当前最大id',
    step     int(20)    NOT NULL COMMENT '号段的长度',
    biz_type int(20)    NOT NULL COMMENT '业务类型',
    version  int(20)    NOT NULL COMMENT '版本号,是一个乐观锁，每次都更新version，保证并发时数据的正确性',
    PRIMARY KEY (`id`)
) ;


