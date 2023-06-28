package com.tom.demo.id.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: UserKeyAuto
 * @Author: TomLuo
 * @CreateDate: 2023年06月19日 4:54
 * @Version: V1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "user_key_auto")
public class UserKeyAuto extends Model<UserKeyAuto> implements Serializable {
    private static final long serialVersionUID = 1L;
    //private Long id;
    private Long userId;
    private String username;
    private Integer sex;
    private String address;
    private String city;
    private String email;
    private Integer state;
}