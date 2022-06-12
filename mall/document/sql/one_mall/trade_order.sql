create table trade_order
(
    id                      int auto_increment comment '编码'
        primary key,
    user_id                 int           null comment '用户编码',
    order_no                varchar(32)   null comment '订单编号',
    order_status            int           not null comment '订单状态：10：等待付款;20:等待发货;30:已发货;40:已完成;50:已关闭;',
    remark                  varchar(64)   null comment '备注',
    end_time                datetime      null comment '交易结束时间：交易完成或交易关闭的时间',
    buy_price               int           null comment '购买商品总金额，单位：分',
    discount_price          int           null comment '优惠总金额，单位：分',
    logistics_price         int           null comment '物流金额，单位：分',
    present_price           int           null comment '最终金额，单位：分',
    pay_price               int           null comment '实际已支付金额，单位：分',
    refund_price            int           null comment '退款金额，单位：分',
    pay_time                datetime      null comment '付款时间',
    pay_transaction_id      int           null comment '支付订单编号',
    pay_channel             int           null comment '支付成功的支付渠道',
    delivery_type           int           null comment '配送类型：',
    delivery_time           datetime      null comment '发货时间',
    receive_time            datetime      null comment '收货时间',
    receiver_name           varchar(32)   null comment '收件人名称',
    receiver_mobile         varchar(32)   null comment '收件人手机号',
    receiver_area_code      int           null comment '收件人地区编码',
    receiver_detail_address varchar(64)   null comment '收件人详细地址',
    after_sale_status       int           null comment '售后状态：',
    coupon_card_id          int           null comment '优惠卷编码',
    deleted                 int default 1 not null comment '是否删除：0-已删除;1-未删除;',
    create_time             datetime      not null comment '创建时间',
    update_time             datetime      null comment '更新时间',
    constraint trade_order_id_uindex
        unique (id)
)
    comment '交易订单表';

