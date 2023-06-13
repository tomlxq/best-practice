--
--create user scott identified by scott;//在管理员帐户下，创建用户zhangsan
-- alter user scott identified by scott;//修改密码
--grant all privilege to scott with admin option;
begin
insert into t_user(id, name, email) values('1','tom','tom@gmail.com');
insert into t_user(id, name, email) values('2','lili','lili@gmail.com');
insert into t_user(id, name, email) values('3','jack','jack@gmail.com');
commit;
end;
/