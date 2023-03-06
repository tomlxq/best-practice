package com.tom.demo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * ww
 *
 * @author TomLuo
 * @date 2023年03月05日 18:02
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    /**
     * 字段添加填充内容
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 乐观锁Version的注解
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;
}