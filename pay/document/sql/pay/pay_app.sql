create table pay_app
(
    id                int auto_increment comment '应用编码'
        primary key,
    name              varchar(32)   not null comment '应用名称',
    pay_notify_url    varchar(255)  null comment '异步通知地址',
    refund_notify_url varchar(255)  null comment '退款异步通知地址',
    status            int default 1 not null comment '状态：0->关闭;1->开启;',
    deleted           int default 1 not null comment '是否删除：0->已删除;1->未删除;',
    create_time       datetime      not null comment '创建时间',
    update_time       datetime      not null comment '更新时间',
    constraint pay_app_id_uindex
        unique (id),
    constraint pay_app_name_uindex
        unique (name)
)
    comment '支付应用：每个接入的业务都是应用，进行个性化配置';

