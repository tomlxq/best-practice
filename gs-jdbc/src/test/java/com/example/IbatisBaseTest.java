package com.example;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by tom on 2016/5/18.
 */
@ContextConfiguration(locations = { "classpath:/config/ibatis/spring-pool.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = false)
public class IbatisBaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    public static final Logger logger = LoggerFactory.getLogger(IbatisBaseTest.class);
    /**
     *要指明唯一的数据源，如果只有一个就不用指明了。
     */
    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}