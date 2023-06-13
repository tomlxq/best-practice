package com.tom.example2.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * UserPO
 *
 * @author TomLuo
 * @date 2023年04月22日 16:54
 */
@Data
@Builder
public class UserPO extends Model<UserPO> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String password;
    private String id;
    private String username;



}