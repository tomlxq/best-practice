package com.tom.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TTestDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TTest TTest = new TTest();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = TTest.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> stub = TTest.stub;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TTest extends AliasableSqlTable<TTest> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> stub = column("stub", JDBCType.CHAR);

        public TTest() {
            super("t_test", TTest::new);
        }
    }
}