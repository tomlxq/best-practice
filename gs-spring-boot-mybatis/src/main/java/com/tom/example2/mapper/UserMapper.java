package com.tom.example2.mapper;

import com.tom.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * UserMapper
 *
 * @author TomLuo
 * @date 2023年03月18日 0:52
 */@Mapper
public interface UserMapper {
    /**
     * 1用来循环容器的标签forEach
     * foreach元素的属性主要有item，index，collection，open，separator，close。
     * <p>
     * item：集合中元素迭代时的别名，
     * index：集合中元素迭代时的索引
     * open：常用语where语句中，表示以什么开始，比如以'('开始
     * separator：表示在每次进行迭代时的分隔符，
     * close 常用语where语句中，表示以什么结束，
     * 在使用foreach的时候最关键的也是最容易出错的就是collection属性，该属性是必须指定的，但是在不同情况下，该属性的值是不一样的，主要有一下3种情况：
     * 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list .
     * 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array .
     * 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，当然单参数也可以封装成map，实际上如果你在传入参数的时候，在MyBatis里面也是会把它封装成一个Map的，map的key就是参数名，所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key.
     *
     * @param userids
     * @return
     */
    public List<User> queryById(List<String> userids);

    /**
     * 2concat模糊查询
     * @param name
     * @return
     */
    public List<User> queryById(String name);

    /**
     * 3choose (when, otherwise)标签
     * choose标签是按顺序判断其内部when标签中的test条件出否成立，如果有一个成立，则 choose 结束。
     * 当 choose 中所有 when 的条件都不满则时，则执行 otherwise 中的sql。
     * 类似于Java 的 switch 语句，c
     * hoose 为 switch，when 为 case，
     * otherwise 则为 default。
     *
     * @param username
     * @param sex
     * @param birthday
     * @return
     */
    public List<User> getUserList_choose(String username, Integer sex, Date birthday);
    /**
     * 4selectKey 标签
     */
}
