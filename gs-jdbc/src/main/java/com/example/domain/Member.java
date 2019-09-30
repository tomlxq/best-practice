package com.example.domain;

import com.alibaba.druid.support.monitor.annotation.MTable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/10
 */
@Data
@Table(name = "t_user")
@Entity
public class Member implements Serializable {
    @Id
    @Column(name = "id")
    Long id;
    String username;
    String password;
    Integer age;
    @Column(name = "created_date")
    LocalDateTime createdDate;
}
