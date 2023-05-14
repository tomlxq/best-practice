package com.tom.entities;

/**
 * User
 *
 * @author TomLuo
 * @date 2023年05月14日 8:24
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tom.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName(value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 真实姓名
     */
    private String realName;



    /**
     * 性别
     */
    @TableField(value = "sex")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SexEnum sex;

    /**
     * 版本
     */
    @TableField(value = "version", update = "%s+1")
    private Integer version;

    /**
     * 时间字段，自动添加
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;



    @TableLogic
    private Integer isDelete;
}