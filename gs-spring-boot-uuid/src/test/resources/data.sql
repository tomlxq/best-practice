# show variables like '%increment%'
BEGIN;

REPLACE INTO unique_id (biz)
values ('o');
SELECT LAST_INSERT_ID();

COMMIT;