create table tb_ip_origin
(
    id          int auto_increment,
    url         varchar(128) not null comment 'ip代理池地址',
    name        varchar(128) not null comment '代理池网站名称',
    icon        varchar(512)          default null comment '代理池网站名称',
    status      tinyint(1)   not null default 1 comment '状态：1正常，0禁用',
    deleted     tinyint(1)   not null default 1 comment '删除：1正常，0删除',
    create_time datetime     not null default CURRENT_TIMESTAMP,
    modify_time datetime     not null default CURRENT_TIMESTAMP,
    create_user varchar(128) not null,
    modify_user varchar(128) not null,
    constraint tb_ip_origin_pk
        primary key (id)
);

alter table tb_ip_origin
    add method varchar(256) not null comment '调用方法' after name;



create table tb_proxy_host
(
    id          int auto_increment,
    ip          varchar(15)  not null comment 'ip',
    port        varchar(8)   not null comment '端口',
    type        varchar(16)           default null comment '类型：http, https',
    area        varchar(32)           default null comment '代理地区',
    verify_time datetime(32) not null default CURRENT_TIMESTAMP comment '验证时间',
    status      tinyint(1)   not null default 1 comment '状态：1正常，0禁用',
    deleted     tinyint(1)   not null default 1 comment '删除：1正常，0删除',
    create_time datetime     not null default CURRENT_TIMESTAMP,
    modify_time datetime     not null default CURRENT_TIMESTAMP,
    create_user varchar(128) not null,
    modify_user varchar(128) not null,
    constraint tb_proxy_host_pk
        primary key (id)
);

