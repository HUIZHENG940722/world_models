create table if not exists pay_notify_task
(
    id                int auto_increment comment '编码'
        primary key,
    appId             varchar(32)   not null comment '应用编码',
    type              int           null comment '通知类型',
    status            int           not null comment '状态',
    active            tinyint(1)    not null comment '是否激活',
    next_notify_time  datetime      not null comment '下一次通知时间',
    last_execute_time datetime      not null comment '最后一次执行时间',
    notify_times      int           not null comment '当前通知次数',
    max_notify_times  int           not null comment '最大可通知次数',
    notify_url        varchar(255)  not null comment '通知地址',
    transaction       text          null comment '支付数据',
    refund            text          null comment '退款数据',
    deleted           int default 1 not null comment '是否删除：0->未删除;1->已删除;',
    create_time       datetime      not null comment '创建时间',
    update_time       datetime      not null comment '更新时间',
    constraint pay_notify_task_id_uindex
        unique (id)
)
    comment '支付通知App的任务：目前包括支付通知、退款通知';

