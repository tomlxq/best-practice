package com.tom.demo.repository;

import com.tom.demo.dto.Sex;
import com.tom.demo.dto.Status;
import com.tom.demo.dto.User;
import com.tom.demo.dto.UserQueryDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/9
 */

public interface UserRepository {

    /**
     * 添加用户
     * @Options返回在数据库中主键，自动赋值到user的id字段中
     * keyProperty = "id"的默认值为id,可以省略
     */
    @Insert("INSERT INTO `user` VALUES (#{id}, #{nickName}, #{phoneNumber}, #{sex}, #{age}, #{birthday}, #{status})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int saveUser(User user);

    /**
     * 批量保存用户
     * @param users
     */
    @Insert("<script>" +
            "INSERT INTO `user` VALUES " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','>" +
            "(#{item.id}, #{item.nickName}, #{item.phoneNumber}, #{item.sex}, #{item.age}, #{item.birthday}, #{item.status})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true)
    int saveUserList(List<User> users);

    //使用set标签进行动态set，要注意条件判断：没被删除的用户才可以更新数据
    @Update("<script>"
            + "UPDATE `user` "
            + "<set>"
            + "<if test='nickName != null'>nick_name = #{nickName}, </if>"
            + "<if test='age != null'>age = #{age}, </if>"
            + "<if test='phoneNumber != null'>phone_number = #{phoneNumber}, </if>"
            + "<if test='birthday != null'>birthday = #{birthday}, </if>"
            + "<if test='status != null'>status = #{status}, </if>"
            + "<if test='sex != null'>sex = #{sex}, </if>"
            + "</set>"
            + "WHERE id = #{id} AND status != 'DELETE';"
            + "</script>")
    int updateUser(User user);


    //删除用户，软删除
    @Update("UPDATE `user` SET status = #{status} WHERE id = #{id}")
    void remove(@Param(value = "id") Long id, @Param(value = "status") Status status);

    //删除用户，硬删除
    @Delete("DELETE FROM `user` WHERE id = #{id}")
    void delete(@Param(value = "id") Long id);

    /**
     * 查询用户
     * 单个参数时，@Param注解可以省略
     * 在配置中指定了驼峰映射，所以@Results的结果映射可以省略，不是驼峰类型的仍然需要写结果映射。
     */
    @Select("SELECT * FROM `user` WHERE id = #{id}")
    @Results({
            @Result(column = "nick_name", property = "nickName"),
            @Result(column = "phone_number", property = "phoneNumber")
    })
    User get(Long id);

    //分页查询用户
    @Select("SELECT * FROM `user`")
    List<User> listUser();

    /**
     * 通过id集合查询用户
     * @param ids
     * @return
     */
    @Select("<script>"
            + "SELECT * FROM `user` WHERE id in "
            + "<foreach item='item' collection='list' open='(' close=')' separator=','>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<User> listUserByIds(List<Long> ids);

    /**
     * 根据条件查询用户
     * 注意其中nickName模糊查询的处理方法
     * 注意其中关于生日的区间判断
     * @param userQueryDTO
     * @return
     */
    @Select("<script>"
            + "SELECT * FROM `user`"
            + "<where>"
            + "<bind name='nickName' value=\"'%' + nickName + '%'\" />"
            + "<if test='nickName != null'>AND nick_name like #{nickName}</if>"
            + "<if test='phoneNumber !=null'>AND phone_number = #{phoneNumber}</if>"
            + "<if test='sex !=null'>AND sex = #{sex}</if>"
            + "<if test='age !=null'>AND age = #{age}</if>"
            + "<if test='fromBirthday !=null'>AND birthday &gt; #{fromBirthday}</if>"
            + "<if test='toBirthday !=null'>AND birthday &lt; #{toBirthday}</if>"
            + "<if test='status !=null'>AND status = #{status}</if>"
            + "</where>"
            + "</script>")
    List<User> queryByCondition(UserQueryDTO userQueryDTO);


    /**
     * 如果age有值，通过age查询
     * 如果age没有值，则通过sex查询
     * 如果age和sex都没值，则查询所有status为UNLOCK的用户
     * @param age
     * @param sex
     * @return
     */
    @Select("<script>"
            + "SELECT * FROM `user`"
            + "<where>"
            + "<choose>"
            + "<when test='age != null'>AND age = #{age}</when>"
            + "<when test='sex != null'>AND sex = #{sex}</when>"
            + "<otherwise>AND status = 'UNLOCK'</otherwise>"
            + "</choose>"
            + "</where>"
            + "</script>")
    List<User> getByOrderCondition(@Param("age") Integer age, @Param("sex") Sex sex);
}
