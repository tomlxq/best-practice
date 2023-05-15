CREATE TABLE `ttl_product_info`
(
    `id`            int(11)             NOT NULL AUTO_INCREMENT COMMENT '记录唯一标识',
    `product_name`  varchar(50)         NOT NULL COMMENT '商品名称',
    `category_id`   bigint(20)          NOT NULL DEFAULT '0' COMMENT '类型ID',
    `category_name` varchar(50)         NOT NULL COMMENT '冗余分类名称-避免跨表join',
    `branch_id`     bigint(20)          NOT NULL COMMENT '品牌ID',
    `branch_name`   varchar(50)         NOT NULL COMMENT '冗余品牌名称-避免跨表join',
    `shop_id`       bigint(20)          NOT NULL COMMENT '商品ID',
    `shop_name`     varchar(50)         NOT NULL COMMENT '冗余商店名称-避免跨表join',
    `price`         decimal(10, 2)      NOT NULL COMMENT '商品当前价格-属于热点数据，而且价格变化需要记录，需要价格详情表',
    `stock`         int(11)             NOT NULL COMMENT '库存-热点数据',
    `sales_num`     int(11)             NOT NULL COMMENT '销量',
    `create_time`   timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `update_time`   timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_del`        tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '记录是否已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_shop_category_salesnum` (`shop_id`, `category_id`, `sales_num`),
    KEY `idx_category_branch_price` (`category_id`, `branch_id`, `price`),
    KEY `idx_productname` (`product_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15000001
  DEFAULT CHARSET = utf8 COMMENT ='商品信息表';