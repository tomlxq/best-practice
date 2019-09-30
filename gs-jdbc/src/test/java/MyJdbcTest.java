import com.alibaba.fastjson.JSON;
import com.example.domain.Member;
import org.junit.Test;
import org.springframework.jdbc.EntityOperation;
import org.springframework.jdbc.QueryRule;
import org.springframework.jdbc.QueryRuleSqlBuilder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/11
 */
public class MyJdbcTest {
    @Test
    public void testMyJdbc(){
        QueryRule queryRule =  QueryRule.getInstance();
        queryRule.andEqual("name","tom");
        queryRule.andBetween("age",18,60);
        queryRule.andLike("firstName","test");
        queryRule.addAscOrder("id");
        queryRule.andIn("class","a","b","c");
        queryRule.orIn("level","high","mid");
        QueryRuleSqlBuilder queryRuleSqlBuilder = new QueryRuleSqlBuilder(queryRule);
        System.out.println(        queryRuleSqlBuilder.getWhereSql());
        System.out.println(        queryRuleSqlBuilder.getOrderSql());
        System.out.println(        queryRuleSqlBuilder.getProperties());
        System.out.println(        queryRuleSqlBuilder.getValues());

        try {
            EntityOperation<Member> op=new EntityOperation<Member>(Member.class,"id");
            System.out.println(JSON.toJSONString(op,true));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
