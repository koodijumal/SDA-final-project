
--for creating login we need user and role tables
create table user
(
    id        int auto_increment
        primary key,
    user_name varchar(30) not null,
    password  varchar(10) not null,
    role      int         not null,
    constraint user_user_name_uindex
        unique (user_name)
);

create table role
(
    id        int auto_increment
        primary key,
    role_name varchar(15) not null,
    constraint role_role_name_uindex
        unique (role_name)
);

