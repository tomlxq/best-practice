package com.example.threadpooltaskexecutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * @Description: Student
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 5:39
 * @Version: V1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("tb_student")
public class Student extends Model<Student> implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String studentName;
    private String addr;
    private int age;
    private String phone;
}