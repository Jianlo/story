/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/4/13 17:08:47                           */
/*==============================================================*/


drop table if exists comment;

drop table if exists friend;

drop table if exists letter;

drop table if exists love;

drop table if exists reading;

drop table if exists story;

drop table if exists tag;

drop table if exists user;

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   id                   varchar(255) not null,
   sid                  varchar(255) not null,
   commenter            varchar(255) not null,
   commentContent       text not null,
   commentTime          varchar(255) not null,
   commentFloor         int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: friend                                                */
/*==============================================================*/
create table friend
(
   id                   varchar(255) not null,
   owner                varchar(255) not null,
   member               varchar(255) not null,
   time                 varchar(255) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: letter                                                */
/*==============================================================*/
create table letter
(
   id                   varchar(255) not null,
   sender               varchar(255) not null,
   receiver             varchar(255) not null,
   sendTime             varchar(255) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: love                                                  */
/*==============================================================*/
create table love
(
   id                   varchar(255) not null,
   sid                  varchar(255) not null,
   fans                 varchar(255) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: reading                                               */
/*==============================================================*/
create table reading
(
   id                   varchar(255) not null,
   sid                  varchar(255) not null,
   reader               varchar(255) not null,
   readTime             varchar(255) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: story                                                 */
/*==============================================================*/
create table story
(
   id                   varchar(255) not null,
   sid                  varchar(255) not null,
   title                varchar(255) not null,
   content              text not null,
   createTime           varchar(255) not null,
   updateTime           varchar(255) not null,
   storyTag             varchar(255) not null,
   readNum              int not null,
   commentNum           int not null,
   likeNum              int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag
(
   id                   varchar(255) not null,
   tid                  varchar(255) not null,
   tagName              varchar(255) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(255) not null,
   uid                  varchar(255) not null,
   username             varchar(255) not null,
   password             varchar(255) not null,
   photoUrl             varchar(255) not null,
   email                varchar(255) not null,
   primary key (id)
);

