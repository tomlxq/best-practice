import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.tom.demo.dto.Account;
import com.tom.demo.jdbc.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@ContextConfiguration(locations = {"classpath*:spring-dbc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceXmlTest {
    @Autowired
    DruidDataSource dataSource;

    @Autowired
    private AccountService accountService;

    @Test
    public void testQuery() throws SQLException {
        List<Account> accounts = accountService.listAccounts();
        System.out.println(JSON.toJSONString(accounts, true));
        System.out.println(JSON.toJSONString(accountService.getAccount(1), true));
    }

    @Test
    public void testAdd() throws SQLException {
        accountService.add("tom");
    }

    @Test
    public void login() throws SQLException {
        accountService.login("jack");
    }

    @Test
    public void dirtyRead() throws SQLException {
        Connection conn = dataSource.getConnection();
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            PreparedStatement ps = conn.prepareStatement("update account set name=? where id=?");
            ps.setString(1, "ttt");
            ps.setInt(2, 1);
            boolean execute = ps.execute();
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM account where id=1");
            while (result.next()) {
                System.out.print(result.getString("name") + " ");
            }
            //throw new SQLException("haha");
            conn.commit();
        } finally {
            conn.close();
        }

    }

    @Test
    public void testDruid() throws SQLException {
        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("insert into account values(?,?,?)");
        ps.setInt(1, 1);
        ps.setString(2, "林涛");
        ps.setBigDecimal(3, new BigDecimal(1.2f));
        boolean execute = ps.execute();
        conn.commit();
        conn.close();
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.238.150:3306/demo?characterEncoding=utf-8&serverTimezone=UTC", "root", "root");
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("insert into account values(?,?,?)");
            ps.setInt(1, 4);
            ps.setString(2, "林涛");
            ps.setBigDecimal(3, new BigDecimal(1.2f));
            boolean execute = ps.execute();
            System.out.println(execute);
            int i = 0;
            if (i == 0) {
                System.out.println("模拟操作失败");
                throw new SQLException("不能再插入了");
            }
            System.out.println("提交事务开始");
            conn.commit();
            System.out.println("提交事务完成");
        } catch (SQLException e) {
            System.out.println("事务操作异常：" + e.getMessage());
            conn.rollback();
            System.out.println("事务操作回滚");
        }
        conn.close();
    }
}
