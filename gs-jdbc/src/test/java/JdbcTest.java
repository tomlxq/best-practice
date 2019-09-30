import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.example.SpringBootJdbcDemoApplication;
import com.example.domain.Member;
import com.example.repositories.MemberDao;
import dto.CustomerRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.EntityOperation;
import org.springframework.jdbc.GenericsUtils;
import org.springframework.jdbc.QueryRule;
import org.springframework.jdbc.QueryRuleSqlBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/10
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.example")
@EnableAutoConfiguration
public class JdbcTest {
    /**
     * 1.加载驱动类
     * 2.获取连接
     * 3.准备语句集
     * 4.执行语集
     * 5.获取结果集
     */
    @Test
    public void jdbcTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.238.150:3306/demo", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user");
            ResultSet resultSet = preparedStatement.executeQuery();
            int len = resultSet.getMetaData().getColumnCount();
            List<Member> list = new ArrayList<Member>();
            Class<Member> clazz = Member.class;
            while (resultSet.next()) {
                Member member = clazz.newInstance();
                for (int i = 1; i <= len; i++) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    if (type == String.class) {
                        field.set(member, resultSet.getString(columnName));
                    } else if (type == Integer.class) {
                        field.set(member, resultSet.getInt(columnName));
                    } else if (type == Long.class) {
                        field.set(member, resultSet.getLong(columnName));
                    }
                }
                list.add(member);
            }
            log.info("{}", JSON.toJSONString(list, true));
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }




    @Test
    public void testTemplate() throws Exception {
        JdbcTemplate jdbcTemplateRead = getJdbcTemplate();
        String sql = "select password,id,created_date,age,username from t_user where  username = ? ";


        EntityOperation x=   new EntityOperation<Member>(Member.class,"id");
        List<Member> customers = jdbcTemplateRead.query(
                sql,
                x.rowMapper,new String[]{"tom"});
        System.out.println(customers);
    }

    private JdbcTemplate getJdbcTemplate() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.238.150:3306/demo");
        dataSource.setUsername("root");//用户名
        dataSource.setPassword("root");//密码
        return new JdbcTemplate(dataSource);
    }

    @Autowired
    MemberDao memberDao;

    @Test
    public void testFind() throws Exception {
        List<Member> r = memberDao.selectByName("tom");
        QueryRule queryRule=QueryRule.getInstance();
        queryRule.andEqual("username","tom");
        QueryRuleSqlBuilder queryRuleSqlBuilder = new QueryRuleSqlBuilder(queryRule);
        JdbcTemplate jdbcTemplateRead = getJdbcTemplate();
      //  Class<T> entityClass = GenericsUtils.getSuperClassGenricType(getClass(), 0);
        EntityOperation   op = new EntityOperation<Member>(Member.class,"id");
        String sql="select "+ op.getAllColumn()+" from "+op.getTableName()+ " where username =?" ;
        log.info("{}",jdbcTemplateRead.query(sql,op.rowMapper, new Object[]{"tom"}));
        log.info("{}",r);
    }

}
