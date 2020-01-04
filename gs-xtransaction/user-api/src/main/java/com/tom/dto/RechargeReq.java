package com.tom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/4
 */
@Data
@NoArgsConstructor
public class RechargeReq extends LoginRequest implements Serializable {

    private static final long serialVersionUID = 6136275589530532330L;
}
