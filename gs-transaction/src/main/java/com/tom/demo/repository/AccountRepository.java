package com.tom.demo.repository;

import com.tom.demo.dto.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
public interface AccountRepository {
    @Insert("INSERT INTO `account` VALUES (#{id}, #{name}, #{money})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(Account account);
}
