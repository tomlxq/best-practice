package com.tom.example2.mapper;

import static com.tom.example2.mapper.TStudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.tom.entity.TStudent;
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
public interface TStudentMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TStudent>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, branch, percentage, phone, email);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TStudentResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH", property="branch", jdbcType=JdbcType.VARCHAR),
        @Result(column="PERCENTAGE", property="percentage", jdbcType=JdbcType.INTEGER),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.INTEGER),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR)
    })
    List<TStudent> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TStudentResult")
    Optional<TStudent> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, TStudent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, TStudent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TStudent row) {
        return MyBatis3Utils.insert(this::insert, row, TStudent, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(branch).toProperty("branch")
            .map(percentage).toProperty("percentage")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TStudent> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, TStudent, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(branch).toProperty("branch")
            .map(percentage).toProperty("percentage")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TStudent row) {
        return MyBatis3Utils.insert(this::insert, row, TStudent, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(branch).toPropertyWhenPresent("branch", row::getBranch)
            .map(percentage).toPropertyWhenPresent("percentage", row::getPercentage)
            .map(phone).toPropertyWhenPresent("phone", row::getPhone)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TStudent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, TStudent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TStudent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, TStudent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TStudent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, TStudent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TStudent> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, TStudent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TStudent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(branch).equalTo(row::getBranch)
                .set(percentage).equalTo(row::getPercentage)
                .set(phone).equalTo(row::getPhone)
                .set(email).equalTo(row::getEmail);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TStudent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(branch).equalToWhenPresent(row::getBranch)
                .set(percentage).equalToWhenPresent(row::getPercentage)
                .set(phone).equalToWhenPresent(row::getPhone)
                .set(email).equalToWhenPresent(row::getEmail);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TStudent row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(branch).equalTo(row::getBranch)
            .set(percentage).equalTo(row::getPercentage)
            .set(phone).equalTo(row::getPhone)
            .set(email).equalTo(row::getEmail)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TStudent row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(branch).equalToWhenPresent(row::getBranch)
            .set(percentage).equalToWhenPresent(row::getPercentage)
            .set(phone).equalToWhenPresent(row::getPhone)
            .set(email).equalToWhenPresent(row::getEmail)
            .where(id, isEqualTo(row::getId))
        );
    }
}