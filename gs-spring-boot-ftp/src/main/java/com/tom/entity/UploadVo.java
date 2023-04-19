package com.tom.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UploadVo
 *
 * @author TomLuo
 * @date 2023年04月19日 23:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "文件VO")
public class UploadVo {

    @ApiModelProperty(value = "原始文件名称")
    private String oldName;

    @ApiModelProperty(value = "新文件名称")
    private String newName;

    @ApiModelProperty(value = "访问路径")
    private String path;

}