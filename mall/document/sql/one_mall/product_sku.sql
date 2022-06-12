create table product_sku
(
    id          int auto_increment comment 'SKU编号'
        primary key,
    spuId       int           not null comment '商品编号',
    status      int default 1 not null comment '状态：0->关闭;1->开启;',
    picUrl      varchar(255)  null comment '图片地址',
    attrs       varchar(255)  null comment '规格值，数组以逗号隔开',
    price       int           null comment '价格，单位：分',
    quantity    int           null comment '库存数量',
    deleted     int default 1 not null comment '是否被删除：0->已删除;1->未删除;',
    create_time datetime      not null comment '创建时间',
    update_time datetime      not null comment '更新时间',
    constraint product_sku_id_uindex
        unique (id)
)
    comment '商品SKU表';

