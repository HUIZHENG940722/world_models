create table if not exists logistics_order
(
    id             int auto_increment comment '编码'
        primary key,
    delivery_type  int         null comment '配送类型',
    express_id     int         null comment '物流公司编码',
    express_no     varchar(32) null comment '物流公司单号',
    trade_order_id int         null comment '交易订单编码',
    items          text        null comment '商品列表：采用JSON格式存储',
    constraint logistics_order_id_uindex
        unique (id)
)
    comment '订单的物流信息';

