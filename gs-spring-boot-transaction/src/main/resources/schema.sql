drop table if exists `user`;
CREATE TABLE `user`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT,
    `nickname`    varchar(255) NOT NULL COMMENT'昵称',
    `real_name`   varchar(255) NOT NULL COMMENT'real_name',
    `sex`         tinyint(1)   NOT NULL COMMENT '性别，1男2女',
    `version`     varchar(20)  NOT NULL COMMENT'version',
    `create_time` datetime     NOT NULL COMMENT'创建时间',
    `is_delete`   tinyint(1)   NOT NULL DEFAULT'0' COMMENT'是否删除 1是，0否',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 50
  DEFAULT CHARSET = utf8mb4;