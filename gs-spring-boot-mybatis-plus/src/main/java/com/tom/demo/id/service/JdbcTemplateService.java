/*
package com.tom.demo.id.service;

import com.tom.demo.id.entity.UserKeyAuto;
import com.tom.demo.id.entity.UserKeyRandom;
import com.tom.demo.id.entity.UserKeyUUID;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

*/
/**
 * @Description: JdbcTemplateService
 * @Author: TomLuo
 * @CreateDate: 2023年06月19日 4:55
 * @Version: V1.0
 *//*

@Service
@RequiredArgsConstructor
public class JdbcTemplateService {
    final JdbcTemplate jdbcTemplate;

    public <T> boolean insert(String insertSql, List<T> insertData, boolean b) {
        return jdbcTemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int idx) throws SQLException {
                final T t = insertData.get(idx);
                if (t instanceof UserKeyAuto) {
                    //id,user_id,user_name,sex,address,city,email,state
                    UserKeyAuto userKeyAuto = (UserKeyAuto) t;
                    ps.setLong(1, userKeyAuto.getId());
                    ps.setLong(2, userKeyAuto.getUserId());
                    ps.setString(3, userKeyAuto.getUsername());
                    ps.setInt(4, userKeyAuto.getSex());
                    ps.setString(5, userKeyAuto.getAddress());
                    ps.setString(6, userKeyAuto.getCity());
                    ps.setString(7, userKeyAuto.getEmail());
                    ps.setInt(8, userKeyAuto.getState());
                }
                if (t instanceof UserKeyRandom) {
                    //id,user_id,user_name,sex,address,city,email,state
                    UserKeyRandom userKeyAuto = (UserKeyRandom) t;
                    ps.setLong(1, userKeyAuto.getId());
                    ps.setLong(2, userKeyAuto.getUserId());
                    ps.setString(3, userKeyAuto.getUsername());
                    ps.setInt(4, userKeyAuto.getSex());
                    ps.setString(5, userKeyAuto.getAddress());
                    ps.setString(6, userKeyAuto.getCity());
                    ps.setString(7, userKeyAuto.getEmail());
                    ps.setInt(8, userKeyAuto.getState());
                }
                if (t instanceof UserKeyUUID) {
                    //id,user_id,user_name,sex,address,city,email,state
                    UserKeyUUID userKeyAuto = (UserKeyUUID) t;
                    ps.setLong(1, userKeyAuto.getId());
                    ps.setLong(2, userKeyAuto.getUserId());
                    ps.setString(3, userKeyAuto.getUsername());
                    ps.setInt(4, userKeyAuto.getSex());
                    ps.setString(5, userKeyAuto.getAddress());
                    ps.setString(6, userKeyAuto.getCity());
                    ps.setString(7, userKeyAuto.getEmail());
                    ps.setInt(8, userKeyAuto.getState());
                }

            }

            @Override
            public int getBatchSize() {
                return insertData.size();
            }
        }).length > 0;
    }
}*/
