create table if not exists product_attr_key
(
    id          int auto_increment comment '规格编号'
        primary key,
    name        varchar(32)   not null comment '规格名称',
    status      int default 1 not null comment '状态：0->关闭;1->开启;',
    deleted     int default 1 not null comment '是否被删除：0->已删除;1->未删除;',
    create_time datetime      not null comment '创建时间',
    update_time datetime      null comment '更新时间',
    constraint product_attr_key_id_uindex
        unique (id)
)
    comment '商品规格表' charset = utf8mb4;

4;

      unique (id)
)
    comment '商品规格表' charset = utf8mb4;

