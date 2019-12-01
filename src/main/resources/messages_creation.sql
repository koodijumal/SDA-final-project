create table messages
(
    id int auto_increment,
    name VARCHAR(50) not null,
    email VARCHAR(50) not null,
    content VARCHAR(1000) not null,
    constraint messages_pk
primary key (id)
);
