create table captcha_codes (id integer not null, code varchar(255), secret_code varchar(255), time datetime, primary key (id))
create table global_settings (id integer not null, code varchar(255), name varchar(255), value varchar(255), primary key (id))
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table post_comments (id integer not null, parent_id integer, post_id integer, text varchar(255), time datetime, user_id integer, primary key (id)) engine=MyISAM
create table post_votes (id integer not null, post_id integer, time datetime, user_id integer, value bit not null, primary key (id)) engine=MyISAM
create table posts (id integer not null, is_active bit not null, moderation_status varchar(255), moderator_id integer not null, text varchar(255), time datetime, title varchar(255), user_id integer not null, view_count integer not null, primary key (id)) engine=MyISAM
create table tag2post (id integer not null, post_id integer, tag_id integer, primary key (id)) engine=MyISAM
create table tags (id integer not null, name varchar(255), primary key (id)) engine=MyISAM
create table tags_to_post (tag_id integer not null, post_id integer not null) engine=MyISAM
create table users (id integer not null, code integer not null, email varchar(255), is_moderator bit, name varchar(255), password varchar(255), photo varchar(255), reg_time datetime, primary key (id)) engine=MyISAM
alter table post_comments add constraint FKaawaqxjs3br8dw5v90w7uu514 foreign key (post_id) references posts (id)
alter table post_comments add constraint FKsnxoecngu89u3fh4wdrgf0f2g foreign key (user_id) references users (id)
alter table post_comments add constraint FKc3b7s6wypcsvua2ycn4o1lv2c foreign key (parent_id) references post_comments (id)
alter table post_votes add constraint FK9jh5u17tmu1g7xnlxa77ilo3u foreign key (post_id) references posts (id)
alter table post_votes add constraint FK9q09ho9p8fmo6rcysnci8rocc foreign key (user_id) references users (id)
alter table posts add constraint FK5lidm6cqbc7u4xhqpxm898qme foreign key (user_id) references users (id)
alter table tag2post add constraint FKpjoedhh4h917xf25el3odq20i foreign key (post_id) references posts (id)
alter table tags_to_post add constraint FKbyxfhwums999ohf84ckwm8bir foreign key (post_id) references posts (id)
alter table tags_to_post add constraint FKmbwgxqdldsrn3dr1kcaphf8yj foreign key (tag_id) references tags (id)