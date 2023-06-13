package com.tom.example2.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TStudentDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TStudent TStudent = new TStudent();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = TStudent.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = TStudent.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> branch = TStudent.branch;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> percentage = TStudent.percentage;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> phone = TStudent.phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> email = TStudent.email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TStudent extends AliasableSqlTable<TStudent> {
        public final SqlColumn<Integer> id = column("ID", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> branch = column("BRANCH", JDBCType.VARCHAR);

        public final SqlColumn<Integer> percentage = column("PERCENTAGE", JDBCType.INTEGER);

        public final SqlColumn<Integer> phone = column("PHONE", JDBCType.INTEGER);

        public final SqlColumn<String> email = column("EMAIL", JDBCType.VARCHAR);

        public TStudent() {
            super("t_student", TStudent::new);
        }
    }
}