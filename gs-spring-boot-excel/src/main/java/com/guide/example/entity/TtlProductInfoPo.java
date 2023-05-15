package com.guide.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * w
 *
 * @author TomLuo
 * @date 2023年05月16日 1:05
 */
@Data
@Accessors(chain = true)
@TableName("ttl_product_info")
public class TtlProductInfoPo {

    private Long id;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private Long branchId;
    private String branchName;
    private Long shopId;
    private String shopName;
    private Double price;
    private Integer stock;
    private Integer salesNum;
    private String createTime;
    private String updateTime;
    private Byte isDel;

}