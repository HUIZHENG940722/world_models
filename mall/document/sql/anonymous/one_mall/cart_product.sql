create table if not exists cart_product
(
    id          int auto_increment comment '编码'
        primary key,
    selected    tinyint(1)    not null comment '是否选中',
    user_id     int           null comment '用户编码',
    spu_id      int           not null comment '商品SPU编码',
    sku_id      int           not null comment '商品SPU编码',
    quantity    int           not null comment '商品购买数量',
    deleted     int default 1 not null comment '是否删除：0-已删除;1-未删除;',
    create_time datetime      not null comment '创建时间',
    update_time datetime      null comment '更新时间',
    constraint cart_product_id_uindex
        unique (id)
)
    comment '购物车商品信息表';

