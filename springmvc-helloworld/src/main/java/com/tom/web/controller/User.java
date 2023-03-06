package com.tom.web.controller;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User
 *
 * @author TomLuo
 * @date 2023年03月01日 20:53
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "tb_user",autoResultMap = true)
public class User extends Model<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer age;
    @TableField(typeHandler = EncryptHandler.class)
    private String mobile;
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String userName;
}