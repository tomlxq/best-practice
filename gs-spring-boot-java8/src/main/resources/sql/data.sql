drop table if exists t_test;
CREATE TABLE t_test
(

    id   BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    stub CHAR(1)             NOT NULL DEFAULT '',
    UNIQUE KEY stub (stub)
);

REPLACE into t_test(stub)
values ('b');
select LAST_INSERT_ID();

DROP TABLE IF EXISTS WORKER_NODE;
CREATE TABLE WORKER_NODE
(
    ID          BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
    HOST_NAME   VARCHAR(64) NOT NULL COMMENT 'host name',
    PORT        VARCHAR(64) NOT NULL COMMENT 'port',
    TYPE        INT         NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
    LAUNCH_DATE DATE        NOT NULL COMMENT 'launch date',
    MODIFIED    TIMESTAMP   NOT NULL COMMENT 'modified time',
    CREATED     TIMESTAMP   NOT NULL COMMENT 'created time',
    PRIMARY KEY (ID)
)
    COMMENT ='DB WorkerID Assigner for UID Generator', ENGINE = INNODB;