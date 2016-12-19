package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

/**
 * Created by tom on 2016/12/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdbc {
    Logger logger = LoggerFactory.getLogger(TestJdbc.class);
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "scott";
    String password = "scott";
    Connection conn = null;

    @Test
    public void contextLoads() {
        try {
            //1. 加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2. 建立连接
            conn = DriverManager.getConnection(url, username, password);
            Statement st=conn.createStatement();
            //3. 发送命令 4. 处理返回结果
            logger.debug("#############更新操作#############");
            st.executeUpdate("update student set age=25");
            ResultSet rs=st.executeQuery("select * from student");
            logger.debug("#############普通查询#############");
            while(rs.next()){
                logger.debug("{} {} {}",rs.getString("STUDENT_ID"),rs.getString("STUDENT_NAME"),  rs.getString("AGE"));
            }
            //5. 关闭连接
            rs.close();
            st.close();
            logger.debug("#############有参查询#############");
            PreparedStatement ps=conn.prepareStatement("select * from student s where s.student_id=? and s.student_name=? ");
            ps.setInt(1,1);
            ps.setString(2,"林涛");
             rs=ps.executeQuery();
            while(rs.next()){
                logger.debug("{} {} {}",rs.getString("STUDENT_ID"),rs.getString("STUDENT_NAME"),  rs.getString("AGE"));
            }
            //5. 关闭连接
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }


}
