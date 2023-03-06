package com.example.demo.entity;

/**
 * wwww
 *
 * @author TomLuo
 * @date 2023年03月01日 20:44
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.apache.ibatis.type.TypeHandler;

import java.io.Serializable;

/**
 * (sys_user)实体类
 *
 * @author xrp
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@TableName(value = "sys_user",autoResultMap = true)
public class SysUser extends Model<SysUser> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;
    /**
     * 姓名
     */
    @TableField(typeHandler = TypeHandler.class)
    private String name;
    /**
     * 身份证
     */
    @TableField(typeHandler = TypeHandler.class)
    private String identity;
    /**
     * 银行卡号
     */
    @TableField(typeHandler = TypeHandler.class)
    private String bank;



}
