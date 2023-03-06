package com.tom.web.controller;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EncryptHandler
 *
 * @author TomLuo
 * @date 2023年03月01日 19:40
 */
public class EncryptHandler extends BaseTypeHandler<String> {
    public static final String KEY = "key";


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, AES.encrypt(parameter, KEY));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return AES.decrypt(rs.getString(columnName), KEY);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return AES.decrypt(rs.getString(columnIndex), KEY);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return
                AES.decrypt(cs.getString(columnIndex), KEY);
    }
}
