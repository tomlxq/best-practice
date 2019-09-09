package com.tom.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String nickName;

    private String phoneNumber;

    private Sex sex;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birthday;

    private Status status;

}
