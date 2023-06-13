package com.tom.example2.model;

import com.tom.example2.service.ErrorCodeEnum;

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