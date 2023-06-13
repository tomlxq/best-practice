package com.tom.example2.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TbUserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TbUser tbUser = new TbUser();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> userId = tbUser.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> age = tbUser.age;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> mobile = tbUser.mobile;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userName = tbUser.userName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TbUser extends AliasableSqlTable<TbUser> {
        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

        public final SqlColumn<String> mobile = column("mobile", JDBCType.VARCHAR);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public TbUser() {
            super("tb_user", TbUser::new);
        }
    }
}