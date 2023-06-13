package com.example.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * SystemConfig
 *
 * @author TomLuo
 * @date 2023年06月04日 15:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SystemConfig extends Model<SystemConfig> implements Serializable {
    private static final long serialVersionUID = 1L;
}