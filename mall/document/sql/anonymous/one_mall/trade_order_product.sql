create table if not exists trade_order_product
(
    id                  int auto_increment comment '编码'
        primary key,
    order_id            int          null comment '订单编码',
    status              int          null comment '订单状态',
    spu_id              int          null comment '商品SPU编码',
    sku_id              int          null comment '商品SKU编码',
    sku_name            varchar(32)  null comment '商品名称',
    sku_image           varchar(255) null comment '商品图片',
    quantity            int          null comment '购买数量',
    origin_price        int          null comment '原始单价，单位：分',
    buy_price           int          null comment '购买单价，单位：分',
    present_price       int          null comment '最终单价，单位：分',
    buy_total           int          null comment '购买总金额，单位：分',
    discount_total      int          null comment '优惠总金额，单位：分',
    present_total       int          null comment '最终总金额，单位：分',
    refund_total        int          null comment '退款总金额，单位：分',
    logistics_id        int          null comment '订单物流编码',
    after_sale_status   int          null comment '售后状态：',
    after_sale_order_id int          null comment '售后订单编码',
    deleted             int          not null comment '是否删除：0->已删除;1->未删除;',
    create_time         datetime     not null comment '创建时间',
    update_time         datetime     null comment '更新时间',
    constraint trade_order_product_id_uindex
        unique (id)
)
    comment '交易订单商品信息表';

