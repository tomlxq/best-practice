package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Article
 *
 * @author TomLuo
 * @date 2023年04月19日 22:07
 */
@Data
public class Article {
    /**
     * @JsonFormat注解用于属性或方法上，将Date类型转换为我们需要的类型显示
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 在需要进行日期格式转换的Date属性上添加注解@DateTimeFormat(pattern = "需要转换的格式")
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}