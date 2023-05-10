package com.example;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月10日 6:14
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class TestJackson implements Serializable {
    private static final long serialVersionUID = 337361630075002456L;

    private String id;

    private String name;

    private String gender;

    @JsonIgnore
    private String phone;

}