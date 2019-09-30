package org.springframework.jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基本Dao
 *
 * @author TomLuo
 * @date 2019/9/11
 */
@Data
@Slf4j
public abstract class BaseDaoSupport<T extends Serializable, PK extends Serializable> {
    EntityOperation<T> op = null;
    JdbcTemplate jdbcTemplateRead;
    JdbcTemplate jdbcTemplateWrite;

    private DataSource dataSourceReadOnly;
    private DataSource dataSourceWrite;

    public void setDataSourceReadOnly(DataSource dataSourceReadOnly) {
        this.dataSourceReadOnly = dataSourceReadOnly;
        this.jdbcTemplateRead=new JdbcTemplate(this.dataSourceReadOnly);
    }

    public void setDataSourceWrite(DataSource dataSourceWrite) {
        this.dataSourceWrite = dataSourceWrite;
        this.jdbcTemplateWrite=new JdbcTemplate(this.dataSourceWrite);
    }

    protected BaseDaoSupport() {
        try {
            Class<T> entityClass = GenericsUtils.getSuperClassGenricType(getClass(), 0);
            op = new EntityOperation<T>(entityClass,this.getPKColumn());
        } catch (Exception e) {
            log.error("{}",e);
        }
    }
    /**
     * 获取主键列名称 建议子类重写
     * @return
     */
    protected abstract String getPKColumn();
    private String removeFirstAnd(String sql){
        if(StringUtils.isEmpty(sql)){return sql;}
        return sql.trim().toLowerCase().replaceAll("^\\s*and", "") + " ";
    }
    protected List<T> find(QueryRule queryRule) {
        QueryRuleSqlBuilder queryRuleSqlBuilder = new QueryRuleSqlBuilder(queryRule);
        String sql="select "+ op.getAllColumn()+" from "+op.getTableName()+ " where " +removeFirstAnd(queryRuleSqlBuilder.getWhereSql());
        return jdbcTemplateRead.query(sql,this.op.rowMapper, queryRuleSqlBuilder.getValues());
    }

    private String getWhereSql() {
        return null;
    }

    private String getOrderSql() {
        return null;
    }

    private Object[] getValuesSql() {
        return null;
    }

    private Map<String, T> getValuesMap() {
        return null;
    }
}
