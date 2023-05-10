package com.tom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserTokenDTO
 *
 * @author TomLuo
 * @date 2023年04月22日 16:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenDTO {
    private String id;
    private long gmtCreate;
    private String username;
}