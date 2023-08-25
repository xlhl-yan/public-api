-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 帖子表
create table if not exists post
(
    id            bigint auto_increment comment 'id' primary key,
    age           int comment '年龄',
    gender        tinyint  default 0                 not null comment '性别（0-男, 1-女）',
    education     varchar(512)                       null comment '学历',
    place         varchar(512)                       null comment '地点',
    job           varchar(512)                       null comment '职业',
    contact       varchar(512)                       null comment '联系方式',
    loveExp       varchar(512)                       null comment '感情经历',
    content       text                               null comment '内容（个人介绍）',
    photo         varchar(1024)                      null comment '照片地址',
    reviewStatus  int      default 0                 not null comment '状态（0-待审核, 1-通过, 2-拒绝）',
    reviewMessage varchar(512)                       null comment '审核信息',
    viewNum       int                                not null default 0 comment '浏览数',
    thumbNum      int                                not null default 0 comment '点赞数',
    userId        bigint                             not null comment '创建用户 id',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除'
) comment '帖子';

-- auto-generated definition
create table if not exists interface_info
(
    id             bigint auto_increment comment '主键'
        primary key,
    name           varchar(512)                       not null comment '接口名称',
    url            varchar(512)                       not null comment '接口地址',
    method         varchar(512)                       not null comment '接口路径',
    requestHeader  text                               null comment '请求头',
    description    text                               null comment '接口描述',
    userId         bigint                             not null comment '接口上传人',
    status         int      default 0                 not null comment '接口状态 0-关闭 1-开启',
    responseHeader text                               null comment '响应头',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
)
    comment '接口信息表';

-- 模拟数据
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('苏文轩', 'www.lala-barrows.com', 'GET', 'jCmS', 8761804479, 0, 'lwc');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('曾越彬', 'www.mario-deckow.info', 'GET', 'ZJPj', 952, 0, 'Rwe');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('贺懿轩', 'www.hal-hayes.co', 'GET', 'tK', 9628236309, 0, 'nP8NI');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('余烨霖', 'www.brenton-towne.com', 'GET', 'PC2YP', 700602577, 0, 'k5x');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('江鑫磊', 'www.lauren-okeefe.co', 'GET', 'Kf', 848664, 0, 'jaM3s');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('黎凯瑞', 'www.andreas-kuhlman.io', 'GET', 'KIAk2', 57582, 0, 'bcW');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('许嘉懿', 'www.kallie-lang.biz', 'GET', 'h60', 242296, 0, 'ca');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('孟熠彤', 'www.elton-bogan.org', 'GET', 'gaNLz', 409134, 0, 'CKJ');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('曾志泽', 'www.rey-sawayn.biz', 'GET', '2N', 4798, 0, 'AhUvv');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('姜子涵', 'www.bernita-larson.org', 'GET', '7hZ', 6911, 0, 'iIf');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('陈致远', 'www.pamala-goyette.info', 'GET', 'Qz4', 4371, 0, 'Dl');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('陆立果', 'www.sharlene-cassin.info', 'GET', 'OD', 7592633, 0, 'ia7ou');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('胡思聪', 'www.jon-rippin.co', 'GET', 'El3sA', 52, 0, 'vYs');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('覃荣轩', 'www.joan-swaniawski.org', 'GET', '9D', 1347772, 0, 'qAMu');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('武浩宇', 'www.basilia-greenfelder.biz', 'GET', 'XR', 246236, 0, '3B');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('陈思淼', 'www.krystina-white.io', 'GET', 'ZinqH', 251763, 0, 'ju98W');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('于弘文', 'www.duncan-gaylord.biz', 'GET', 'da21', 6, 0, 'A8Du');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('蔡泽洋', 'www.kevin-franecki.co', 'GET', 'rppB', 98660522, 0, 'rSk');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('杜果', 'www.todd-crooks.co', 'GET', '1t', 740857, 0, 'JN');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`)
values ('唐远航', 'www.andreas-gutkowski.name', 'GET', 'JEB', 3, 0, 'Us');

-- 用户调用接口次数表
create table if not exists user_interface_info
(
    id              bigint auto_increment comment '主键' primary key,
    userId          bigint                             not null comment '调用人',
    interfaceInfoId bigint                             not null comment '接口id',
    totalNum        int                                not null default 0 comment '总调用次数',
    leftNum         int                                not null default 0 comment '剩余调用次数',
    status          int      default 0                 not null comment '0：正常 1：禁用',
    createTime      datetime default CURRENT_TIMESTAMP not null comment '调用时间',
    updateTime      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete        tinyint  default 0                 not null comment '是否删除'
) comment '用户调用接口';

-- 模拟数据
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (1, 1, '1', 66, 10, 0, '2023-08-22 17:31:44', '2023-08-24 20:30:41', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (4, 2, '1', 15, 21, 0, '2023-08-24 20:28:04', '2023-08-24 20:28:01', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (5, 1, '2', 14, 20, 0, '2023-08-24 20:28:34', '2023-08-24 20:28:37', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (6, 1, '3', 12, 23, 0, '2023-08-24 20:29:16', '2023-08-24 20:28:52', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (7, 1, '4', 12, 23, 0, '2023-08-24 20:29:16', '2023-08-24 20:28:53', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (8, 1, '5', 13, 23, 0, '2023-08-24 20:29:17', '2023-08-24 20:28:55', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (9, 1, '6', 12, 23, 0, '2023-08-24 20:29:18', '2023-08-24 20:28:56', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (10, 1, '6', 24, 23, 0, '2023-08-24 20:29:19', '2023-08-24 20:28:57', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (11, 1, '3', 24, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:28:58', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (12, 1, '3', 12, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:08', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (13, 1, '1', 25, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:10', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (14, 1, '1', 21, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:10', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (15, 1, '1', 25, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:11', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (16, 1, '1', 13, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:13', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (17, 1, '1', 11, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:13', 0);
INSERT INTO public_api.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (18, 1, '1', 12, 23, 0, '2023-08-24 20:29:22', '2023-08-24 20:29:15', 0);