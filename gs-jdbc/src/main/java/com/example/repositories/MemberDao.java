package com.example.repositories;


import com.example.domain.Member;
import org.springframework.jdbc.BaseDaoSupport;
import org.springframework.jdbc.QueryRule;
import org.springframework.jdbc.QueryRuleSqlBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/11
 */
@Repository
public class MemberDao extends BaseDaoSupport<Member, Long> {
    @Override
    protected String getPKColumn() {
        return "id";
    }

    @Resource(name = "dataSource")
    protected void setDataSource(DataSource dataSource) {
        super.setDataSourceReadOnly(dataSource);
        super.setDataSourceWrite(dataSource);
    }

@Override
    public List<Member> find(QueryRule rule){
        return super.find(rule);
    }

    public List<Member> selectByName(String name) {
        QueryRule queryRule=QueryRule.getInstance();
        queryRule.andEqual("username",name);
        return super.find(queryRule);
    }
}
