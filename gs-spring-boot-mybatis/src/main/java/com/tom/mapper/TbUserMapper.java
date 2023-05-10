package com.tom.mapper;

import static com.tom.mapper.TbUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.tom.entity.TbUser;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TbUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TbUser>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, age, mobile, userName);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbUserResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    List<TbUser> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbUserResult")
    Optional<TbUser> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TbUser row) {
        return MyBatis3Utils.insert(this::insert, row, tbUser, c ->
            c.map(userId).toProperty("userId")
            .map(age).toProperty("age")
            .map(mobile).toProperty("mobile")
            .map(userName).toProperty("userName")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TbUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbUser, c ->
            c.map(userId).toProperty("userId")
            .map(age).toProperty("age")
            .map(mobile).toProperty("mobile")
            .map(userName).toProperty("userName")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TbUser row) {
        return MyBatis3Utils.insert(this::insert, row, tbUser, c ->
            c.map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(age).toPropertyWhenPresent("age", row::getAge)
            .map(mobile).toPropertyWhenPresent("mobile", row::getMobile)
            .map(userName).toPropertyWhenPresent("userName", row::getUserName)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TbUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TbUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TbUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TbUser> selectByPrimaryKey(Integer userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TbUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(row::getUserId)
                .set(age).equalTo(row::getAge)
                .set(mobile).equalTo(row::getMobile)
                .set(userName).equalTo(row::getUserName);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(row::getUserId)
                .set(age).equalToWhenPresent(row::getAge)
                .set(mobile).equalToWhenPresent(row::getMobile)
                .set(userName).equalToWhenPresent(row::getUserName);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TbUser row) {
        return update(c ->
            c.set(age).equalTo(row::getAge)
            .set(mobile).equalTo(row::getMobile)
            .set(userName).equalTo(row::getUserName)
            .where(userId, isEqualTo(row::getUserId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TbUser row) {
        return update(c ->
            c.set(age).equalToWhenPresent(row::getAge)
            .set(mobile).equalToWhenPresent(row::getMobile)
            .set(userName).equalToWhenPresent(row::getUserName)
            .where(userId, isEqualTo(row::getUserId))
        );
    }
}