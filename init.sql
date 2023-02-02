create table tb_api
(
    id               int auto_increment,
    name             varchar(128) not null comment 'api名称',
    icon             varchar(512) not null comment 'icon',
    order_no         int          not null comment '排序',
    method_type      varchar(10)  not null comment '调用方式',
    url              varchar(128) not null comment '请求地址',
    request_type     varchar(128) not null comment '请求类型',
    params_type      varchar(128) not null comment '参数类型',
    params           varchar(128) not null comment '请求参数',
    response_type    varchar(128) not null comment '返回值类型',
    response_success varchar(512) not null comment '成功返回实例',
    response_error   varchar(512) not null comment '失败返回实例',
    min_frequency    int          not null default -1 comment '单个ip每分钟调用次数，-1不限制',
    day_frequency    int          not null default -1 comment '单个ip每天调用次数   -1不限制',
    free             tinyint(1) not null default 1 comment '是否免费 1免费，0收费',
    login            tinyint(1) not null default 1 comment '是否需要登录 1不需要，0需要',
    status           tinyint(1) not null default 1 comment '状态：1正常，0禁用',
    deleted          tinyint(1) not null default 1 comment '删除：1正常，0删除',
    create_time      datetime     not null default CURRENT_TIMESTAMP,
    modify_time      datetime     not null default CURRENT_TIMESTAMP,
    create_user      varchar(128) not null,
    modify_user      varchar(128) not null,
    constraint tb_api_pk
        primary key (id)
);

-- Api访问总次数  直接存redis
-- Api每日访问量统计表，存redis8小时同步数据库一次
-- 需要支持主动同步，通过日期+id
create table tb_api_data
(
    id          int auto_increment,
    api_id      int          not null comment 'api主键id',
    api_name    varchar(128) not null comment 'api名称',
    num         int          not null default 0 comment '次数',
    data_date   date         not null comment '数据日期',
    status      tinyint(1) not null default 1 comment '状态：1正常，0禁用',
    deleted     tinyint(1) not null default 1 comment '删除：1正常，0删除',
    create_time datetime     not null default CURRENT_TIMESTAMP,
    modify_time datetime     not null default CURRENT_TIMESTAMP,
    create_user varchar(128) not null,
    modify_user varchar(128) not null,
    constraint tb_api_pk
        primary key (id)
);


create table tb_api_log
(
    id          int auto_increment,
    api_id      int          not null comment 'api主键id',
    api_name    varchar(128) not null comment 'api名称',
    ip          varchar(15)  not null comment 'ip',
    resp_code   varchar(15)  not null comment '返回code',
    resp_msg    varchar(128) not null comment '返回信息',
    success     tinyint(1) not null default 1 comment '状态：1成功，0失败',
    status      tinyint(1) not null default 1 comment '状态：1正常，0禁用',
    deleted     tinyint(1) not null default 1 comment '删除：1正常，0删除',
    create_time datetime     not null default CURRENT_TIMESTAMP,
    modify_time datetime     not null default CURRENT_TIMESTAMP,
    create_user varchar(128) not null,
    modify_user varchar(128) not null,
    constraint tb_api_pk
        primary key (id)
);

create table tb_district
(
    id          int auto_increment,
    data        json                                 not null comment '高德查询的数据',
    date_node   date                                 not null comment '获取数据的时间',
    status      tinyint(1) default 1                 not null comment '状态：1正常，0禁用',
    deleted     tinyint(1) default 1                 not null comment '删除：1正常，0删除',
    create_time datetime   default CURRENT_TIMESTAMP not null,
    modify_time datetime   default CURRENT_TIMESTAMP not null,
    create_user varchar(128)                         not null,
    modify_user varchar(128)                         not null,
    constraint tb_district_pk
        primary key (id)
);

