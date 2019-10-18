import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.RollbackException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
@Slf4j
public class TxTest {
static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}  private static Connection getConn() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.238.150:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        System.out.println("Connection established......");
        return  connection;
    }
    public static void main(String[] args) throws  SQLException {
       // testTx1();
        Connection con = getConn();
        //Creating a Statement object
        Statement stmt = con.createStatement();

        //Statements to insert records
        String insert1 = "INSERT INTO t_user( username , password , "
                + "age) VALUES "
                + "('KeyBoard', 'Amith',  1000)";

        String insert2 = "INSERT INTO t_user( username , password , "
                + "age ) VALUES "
                + "('Earphones', 'SUMITH', 500)";

        String insert3 = "INSERT INTO t_user( username , password , "
                + "age ) VALUES "
                + "('Mouse', 'Sudha', 200)";
        //Adding the statements to the batch
        stmt.addBatch(insert1);
        stmt.addBatch(insert2);
        stmt.addBatch(insert3);
        //Executing the batch
        stmt.executeBatch();
        //Saving the changes
        con.commit();
        System.out.println("Records inserted......");
    }

    private static void testTx1() throws  SQLException {
        Connection connection = getConn();
        try {
            PreparedStatement ps1 = connection.prepareStatement("update t_user set username='jack1' where id=1");
            int count = ps1.executeUpdate();
            if (count != 1) {
                throw new MySQLTransactionRollbackException("ps1更新条目不对");
            }
            if (1 / 0 == 0) {
                throw new MySQLTransactionRollbackException("故意回滚事务");
            }
            PreparedStatement ps2 = connection.prepareStatement("update t_user set username='jack1' where id=2");
            count = ps2.executeUpdate();
            if (count != 1) {
                throw new MySQLTransactionRollbackException("ps1更新条目不对");
            }
        }catch (RollbackException e){
           connection.rollback();
            log.error("回滚事务 {}",e);
        }
        connection.commit();
        connection.setAutoCommit(true);
    }


}
