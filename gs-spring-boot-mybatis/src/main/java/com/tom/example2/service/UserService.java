package com.tom.example2.service;

/**
 * UserService
 *
 * @author TomLuo
 * @date 2023年03月18日 1:11
 */
public interface UserService {
    void createUser();

    void select_test_2_1();

    void test7_2_foreach();

    void insertModelBatch();

    void insertModelBatch2();

    /**
     * Of course don't combine ALL of them, if the amount is HUGE.
     * Say you have 1000 rows you need to insert, then don't do it one at a time.
     * You shouldn't equally try to have all 1000 rows in a single query. Instead break it into smaller sizes.
     * Insert inside Mybatis foreach is not batch, this is a single (could become giant) SQL statement and that brings drawbacks:
     *
     * some database such as Oracle here does not support.
     * in relevant cases:
     * there will be a large number of records to insert and the database configured limit (by default around 2000 parameters per statement) will be hit,
     * and eventually possibly DB stack error if the statement itself become too large.
     *
     * Iteration over the collection must not be done in the mybatis XML.
     * Just execute a simple Insertstatement in a Java Foreach loop.
     * The most important thing is the session Executor type.
     *
     * INSERT INTO `table1` (`field1`, `field2`) VALUES ("data1", "data2");
     * INSERT INTO `table1` (`field1`, `field2`) VALUES ("data1", "data2");
     * INSERT INTO `table1` (`field1`, `field2`) VALUES ("data1", "data2");
     * INSERT INTO `table1` (`field1`, `field2`) VALUES ("data1", "data2");
     * INSERT INTO `table1` (`field1`, `field2`) VALUES ("data1", "data2");
     *
     * INSERT INTO `table1` (`field1`, `field2`) VALUES ("data1", "data2"),
     * ("data1", "data2"),
     * ("data1", "data2"),
     * ("data1", "data2"),
     * ("data1", "data2");
     */


}
