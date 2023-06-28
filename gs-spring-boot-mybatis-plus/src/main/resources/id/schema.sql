DROP TABLE IF EXISTS user_key_auto;
create table user_key_auto
(

    id        int UNSIGNED not null auto_increment,
    user_id   BIGINT(64)   not NULL DEFAULT 0,
    username VARCHAR(64)  not NULL DEFAULT '',
    sex       int(2)       not NULL,
    address   VARCHAR(255) not null DEFAULT '',
    city      VARCHAR(64)  not NULL DEFAULT '',
    email     VARCHAR(64)  not null DEFAULT '',
    state     int(6)       not NULL DEFAULT 0,
    PRIMARY KEY (id),
    key user_name_key (username)
) ENGINE = INNODB;
DROP TABLE IF EXISTS user_uuid;
create table user_uuid
(

    id        VARCHAR(64)  not null,

    user_id   BIGINT(64)   not NULL DEFAULT 0,
    username VARCHAR(64)  not NULL DEFAULT '',
    sex       int(2)       not NULL,

    address   VARCHAR(255) not null DEFAULT '',
    city      VARCHAR(64)  not NULL DEFAULT '',
    email     VARCHAR(64)  not null DEFAULT '',
    state     int(6)       not NULL DEFAULT 0,
    PRIMARY KEY (id),

    key user_name_key (username)
) ENGINE = INNODB;
DROP TABLE IF EXISTS user_random_key;
create table user_random_key
(
    id        BIGINT(64)   not null DEFAULT 0,
    user_id   BIGINT(64)   not NULL DEFAULT 0,
    username VARCHAR(64)  not NULL DEFAULT '',
    sex       int(2)       not NULL,
    address   VARCHAR(255) not null DEFAULT '',
    city      VARCHAR(64)  not NULL DEFAULT '',
    email     VARCHAR(64)  not null DEFAULT '',
    state     int(6)       not NULL DEFAULT 0,
    PRIMARY KEY (id),

    key user_name_key (username)
) ENGINE = INNODB;


