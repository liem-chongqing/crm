/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/7 14:47:18                            */
/*==============================================================*/


drop table if exists customer_care;

drop table if exists customer_info;

drop table if exists customer_linkman;

drop table if exists customer_linkreord;

drop table if exists dic_item;

drop table if exists dic_type;

drop table if exists email_info;

drop table if exists houser_info;

drop table if exists notice_info;

drop table if exists user_info;

/*==============================================================*/
/* Table: customer_care                                         */
/*==============================================================*/
create table customer_care
(
   id                   int not null,
   customer_id          int,
   theme                varchar(50),
   way                  varchar(50),
   time                 timestamp,
   remark               varchar(1000),
   next_time            timestamp,
   people               varchar(50),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: customer_info                                         */
/*==============================================================*/
create table customer_info
(
   id                   bigint not null,
   condition_id         int,
   source_id            int,
   user_id              int,
   type_id              int,
   name                 varchar(50),
   sex                  varchar(10),
   mobile               varchar(20),
   qq                   varchar(20),
   address              varchar(500),
   email                varchar(100),
   remark               varchar(1000),
   job                  varchar(100),
   blog                 varchar(100),
   tel                  varchar(20),
   wechat               varchar(50),
   birth_day            date,
   create_time          timestamp,
   create_man           varchar(50),
   update_time          timestamp,
   update_man           varchar(20),
   company              varchar(50),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: customer_linkman                                      */
/*==============================================================*/
create table customer_linkman
(
   id                   bigint not null,
   customer_id          bigint,
   name                 varchar(50),
   sex                  varchar(20),
   job                  varchar(100),
   mobile               varchar(20),
   age                  int,
   relation             varchar(50),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: customer_linkreord                                    */
/*==============================================================*/
create table customer_linkreord
(
   id                   bigint not null,
   customer_id          bigint,
   time                 timestamp,
   who_link             varchar(50),
   type                 varchar(50),
   theme                varchar(200),
   next_time            timestamp,
   remark               varchar(1000),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: dic_item                                              */
/*==============================================================*/
create table dic_item
(
   id                   bigint not null,
   name                 varchar(20),
   remark               varchar(100),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: dic_type                                              */
/*==============================================================*/
create table dic_type
(
   id                   bigint not null,
   name                 varchar(20),
   `key`                  varchar(50),
   remark               varchar(50),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: email_info                                            */
/*==============================================================*/
create table email_info
(
   id                   bigint not null,
   customer_id          bigint,
   user_id              bigint,
   theme                varchar(200),
   content              varchar(2000),
   time                 timestamp,
   state                int(2),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: houser_info                                           */
/*==============================================================*/
create table houser_info
(
   id                   bigint not null,
   type_id              int(2),
   user_id              int(2),
   address              varchar(500),
   price                int(12) comment '房屋价格，单位M元/平米',
   ambient              varchar(1000),
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: notice_info                                           */
/*==============================================================*/
create table notice_info
(
   id                   bigint not null,
   user_id              int,
   item                 varchar(100),
   content              varchar(2000),
   time                 timestamp,
   end_time             timestamp,
   used                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   id                   bigint not null,
   department_name      varchar(50) not null,
   role_name            varchar(50),
   role_power           int(10),
   name                 varchar(50),
   sex                  int(2),
   mobile               varchar(20),
   age                  int(3),
   address              varchar(50),
   num                  varchar(100),
   pwd                  varchar(50),
   tel                  varchar(20),
   idnum                varchar(20),
   email                varchar(100),
   create_time          timestamp,
   create_man           varchar(50),
   update_time          timestamp,
   update_man          varchar(50),
   hobby                varchar(300),
   diploma              varchar(20),
   bank_card            varchar(20),
   nation               varchar(20),
   married              int(2),
   used                 int(2),
   primary key (id)
);

