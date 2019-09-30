package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tom on 2016/5/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private Integer id;
    private String name;
    private String email;
}
