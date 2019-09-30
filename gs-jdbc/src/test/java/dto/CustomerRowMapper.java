package dto;

import com.example.domain.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/21
 */
public class CustomerRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

        Member customer = new Member();
        customer.setId(rs.getLong("ID"));
        customer.setUsername(rs.getString("username"));
        customer.setAge(rs.getInt("AGE"));
        customer.setPassword(rs.getString("password"));
        customer.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        return customer;

    }
}
