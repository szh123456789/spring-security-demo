create table users(
                      id bigint primary key auto_increment,
                      username varchar(20) unique not null,
                      password varchar(100)
);
-- 密码zs
insert into users values(1,'张三','$2a$10$dwi9Xv9cFDC1r8zQDp9wzupxoULvlzjtAMoes1zExZuDdLqtxT.rG');
-- 密码ls
insert into users values(2,'李四','$2a$10$Tomc5i8yHA.dUROgqX0eVO.Aa9qOAnvbNkUJhZ1znemqhRWdGGSle');

create table role(
                     id bigint primary key auto_increment,
                     name varchar(20)
);

insert into role values(1,'管理员');
insert into role values(2,'普通用户');

create table role_user(
                          uid bigint,
                          rid bigint
);

insert into role_user values(1,1);
insert into role_user values(2,2);


create table menu(
                     id bigint primary key auto_increment,
                     name varchar(20),
                     url varchar(100),
                     parentid bigint,
                     permission varchar(20)

);

insert into menu values(1,'系统管理','',0,'menu:sys');
insert into menu values(2,'用户管理','',0,'menu:user');


create table role_menu(
                          mid bigint,
                          rid bigint
);

insert into role_menu values(1,1);
insert into role_menu values(2,1);
insert into role_menu values(2,2);