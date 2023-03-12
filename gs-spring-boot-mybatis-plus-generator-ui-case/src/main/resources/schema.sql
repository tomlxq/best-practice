
DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
                          `id` bigint(11) NOT NULL AUTO_INCREMENT,
                          `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                          `age` int(3) DEFAULT NULL,
                          `password` varchar(20) DEFAULT NULL,
                          `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8