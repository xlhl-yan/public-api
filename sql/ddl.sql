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
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('苏文轩', 'www.lala-barrows.com', 'GET', 'jCmS', 8761804479, 0, 'lwc');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('曾越彬', 'www.mario-deckow.info', 'GET', 'ZJPj', 952, 0, 'Rwe');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('贺懿轩', 'www.hal-hayes.co', 'GET', 'tK', 9628236309, 0, 'nP8NI');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('余烨霖', 'www.brenton-towne.com', 'GET', 'PC2YP', 700602577, 0, 'k5x');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('江鑫磊', 'www.lauren-okeefe.co', 'GET', 'Kf', 848664, 0, 'jaM3s');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('黎凯瑞', 'www.andreas-kuhlman.io', 'GET', 'KIAk2', 57582, 0, 'bcW');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('许嘉懿', 'www.kallie-lang.biz', 'GET', 'h60', 242296, 0, 'ca');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('孟熠彤', 'www.elton-bogan.org', 'GET', 'gaNLz', 409134, 0, 'CKJ');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('曾志泽', 'www.rey-sawayn.biz', 'GET', '2N', 4798, 0, 'AhUvv');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('姜子涵', 'www.bernita-larson.org', 'GET', '7hZ', 6911, 0, 'iIf');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('陈致远', 'www.pamala-goyette.info', 'GET', 'Qz4', 4371, 0, 'Dl');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('陆立果', 'www.sharlene-cassin.info', 'GET', 'OD', 7592633, 0, 'ia7ou');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('胡思聪', 'www.jon-rippin.co', 'GET', 'El3sA', 52, 0, 'vYs');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('覃荣轩', 'www.joan-swaniawski.org', 'GET', '9D', 1347772, 0, 'qAMu');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('武浩宇', 'www.basilia-greenfelder.biz', 'GET', 'XR', 246236, 0, '3B');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('陈思淼', 'www.krystina-white.io', 'GET', 'ZinqH', 251763, 0, 'ju98W');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('于弘文', 'www.duncan-gaylord.biz', 'GET', 'da21', 6, 0, 'A8Du');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('蔡泽洋', 'www.kevin-franecki.co', 'GET', 'rppB', 98660522, 0, 'rSk');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('杜果', 'www.todd-crooks.co', 'GET', '1t', 740857, 0, 'JN');
insert into `interface_info` (`name`, `url`, `method`, `description`, `userId`, `status`, `responseHeader`) values ('唐远航', 'www.andreas-gutkowski.name', 'GET', 'JEB', 3, 0, 'Us');