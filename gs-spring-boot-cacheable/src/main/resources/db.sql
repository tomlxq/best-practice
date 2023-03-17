DELETE
FROM roles;
DELETE
FROM accounts;
DELETE
FROM department;

INSERT INTO accounts (id, birthday, email, name, password, sex)
VALUES (1, '2006-07-08', 'admin@gmail.com', 'admin', '123', 0),
       (2, '2006-07-08', 'tom@gmail.com', 'tom', '567', 0),
       (3, '2006-07-08', 'litao@gmail.com', 'litao', '789', 0),
       (4, '2006-07-08', 'HanMeiMei@gmail.com', 'HanMeiMei', '156', 1),
       (5, '2006-07-08', 'polly@gmail.com', 'polly', '156', 1);
INSERT INTO roles (role_id, role_name, user_id)
VALUES (1, 'ROLE_ADMIN', 1),
       (2, 'ROLE_USER', 2),
       (3, 'ROLE_USER', 3),
       (4, 'ROLE_USER', 4),
       (5, 'ROLE_USER', 5);
INSERT INTO department (id, name, user_id)
VALUES (1, '开发部', 1),
       (2, '市场部', 2),
       (3, '运营部', 3),
       (4, '财务部', 4);