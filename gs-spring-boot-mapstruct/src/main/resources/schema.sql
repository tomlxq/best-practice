--Create DATABASE `gs-mybatis`;
--USE `gs-mybatis`;
--DROP TABLE IF EXISTS USERS;
DECLARE
BEGIN
  --删除表
  EXECUTE IMMEDIATE 'DROP TABLE t_user';
EXCEPTION
  WHEN OTHERS THEN
    NULL;
 --创建表
 --EXECUTE IMMEDIATE 'CREATE TABLE t_user(usename VARCHAR2(20),age NUMBER,birthday DATE DEFAULT SYSDATE,created_date TIMESTAMP DEFAULT Systimestamp)';
END;
/
CREATE TABLE t_user (
  id varchar2(100) NOT NULL,
  name varchar2(100) NOT NULL,
  email varchar2(100) DEFAULT NULL,
  age number DEFAULT NULL,
  birthday TIMESTAMP DEFAULT sysdate,
  PRIMARY KEY (id)
);