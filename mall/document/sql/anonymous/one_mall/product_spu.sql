create table if not exists product_spu
(
    id          int auto_increment comment 'SPU编号'
        primary key,
    name        varchar(32)          not null comment 'SPU名字',
    sell_point  varchar(255)         null comment '卖点',
    description varchar(255)         null comment '描述',
    cid         int                  not null comment '分类编号',
    pic_urls    text                 null comment '商品主图地址，数组，以逗号分隔，建议尺寸：800*800像素，你可以拖拽图片调整顺序，最多上传15张',
    visible     tinyint(1) default 1 not null comment '是否上架商品（是否可见），true为已上架、false为已下架',
    sort        int                  not null comment '排序字段',
    price       int                  not null comment '价格：目前的计算方式是，以SKU最小价格为准',
    quantity    int                  null comment '库存数量，目前的计算方式是，以SKU库存累加为准',
    deleted     int        default 1 not null comment '是否被删除：0->已删除;1->未删除;',
    create_time datetime             not null comment '创建时间',
    update_time datetime             not null comment '更新时间',
    constraint product_spu_id_uindex
        unique (id)
)
    comment '商品SPU表' charset = utf8mb4;

_spu_id_uindex
        unique (id)
)
    comment '商品SPU表' charset = utf8mb4;

