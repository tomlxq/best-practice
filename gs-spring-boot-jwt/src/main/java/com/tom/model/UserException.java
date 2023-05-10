package com.tom.model;

import com.tom.service.ErrorCodeEnum;

/**
 * UserException
 *
 * @author TomLuo
 * @date 2023年04月22日 16:57
 */
public class UserException extends RuntimeException{
    public UserException(ErrorCodeEnum errorCode) {
    }
}