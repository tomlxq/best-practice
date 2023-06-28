DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id    BIGINT(20)  NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

create table if not exists sys_person_phone_encrypt
(
    id        bigint auto_increment comment '主键' primary key,
    person_id int          not null comment '关联人员信息表主键',
    phone_key varchar(500) not null comment '手机号码分词密文'
)
    comment '人员的手机号码分词密文映射表';