package com.tom.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tom.demo.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserMapperTest
 *
 * @author TomLuo
 * @date 2023年03月05日 18:04
 */
public class UserMapperTest extends TestCase {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试插入
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("派大星学Java");
        user.setAge(16);
        user.setEmail("none-j@qq.com");

        int insert = userMapper.insert(user);//帮我们自动生成id
        System.out.println(insert);//受影响的行数
        System.out.println(user);//发现，id会自动回填
    }

    /**
     * 更新操作
     */
    @Test
    public void updateTest() {
        User user = new User();
        user.setId(5L);
        user.setName("我想创建公众号");
        user.setAge(16);

        int i = userMapper.updateById(user);
        System.out.println(i);

    }


    /**
     * 查询操作
     */
    @Test
    public void testSelect() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 批量查询
     */
    @Test
    public void testBatchList() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 按条件查询 map操作
     */
    @Test
    public void testSelectMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "派大星");
        map.put("age", 16);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    /**
     * 分页查询
     */
    @Test
    public void PageTest(){
        //参数一：当前页
        //参数二：页的大小
        //使用了分页插件之后，所有的分页操作也变得简单！
        Page<User> page = new Page<>(1,5);

        IPage<User> pages = userMapper.selectPage(page, null);
        pages.getRecords().forEach(System.out::println);
    }


    /**
     * 删除操作
     */
    @Test
    public void deletTest(){
        userMapper.deleteById(1398260764485095426L);
    }

    /**
     * 批量删除
     */
    @Test
    public void deletBatchTest(){
        userMapper.deleteBatchIds(Arrays.asList(1398201429172178946L,5));
    }
    @Test
    public void deletByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","我想创建公众号");
        userMapper.deleteByMap(map);
    }

    /**
     * 逻辑删操作
     */
    @Test
    public void deleteLogic(){
        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 条件构造器
     */
    @Test
    public void wapperTest(){
        //查询name不为空的用户，并且邮箱不为空的用户，年龄大于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);

    }

    @Test
    void test2(){
        //查询名字为五毛
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","派大星");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }
    @Test
    void test3(){
        //查询年龄在16-30岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.between("age",16,30);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }
    //模糊查询
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //左和右  是指通配符在左边还是右边 t%
        wrapper.notLike("name","l")
                .likeRight("email","t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id","select id from user where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);

    }
    //排序
    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("id");

        //通过id进行排序
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
}