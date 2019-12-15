package com.tom.master.zkclient;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/12
 */
@Setter
@Getter
@AllArgsConstructor
public class UserCenter implements Serializable {
    private static final long serialVersionUID = -3501462815715742297L;
    /**
     * 机器的ID
     */
    private int mcId;
    /**
     * 机器的名字
     */
    private String mcName;
}
