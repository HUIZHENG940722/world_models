create table pay_notify_log
(
    id          int auto_increment comment '日志编码'
        primary key,
    notifyId    int           not null comment '通知编码',
    request     varchar(255)  null comment '请求参数',
    response    varchar(255)  not null comment '响应参数',
    status      int default 1 not null comment '状态：0->关闭;1->开启;',
    deleted     int default 1 not null comment '是否删除：0->已删除;1->未删除;',
    create_time datetime      not null comment '创建时间',
    update_time datetime      not null comment '更新时间',
    constraint pay_notify_log_id_uindex
        unique (id)
)
    comment '支付通知APP的日志：记录通知APP时产生的日志';

