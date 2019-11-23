create table customer
(
    id           int auto_increment
        primary key,
    firstname    varchar(30) not null,
    lastname     varchar(30) not null,
    companyname  varchar(50) null,
    registrycode varchar(50) not null,
    constraint Customer_registrycode_uindex
        unique (registrycode)
);
--just run the code
create table reservation
(
    id           int auto_increment
        primary key,
    room         int         not null comment 'referring to room table',
    customer     int         not null comment 'referring to customer table
',
    checkindate  date        not null,
    checkoutdate date        not null,
    payment      varchar(30) not null comment 'Possible values:
not paid, paid, partially paid',
    status       varchar(30) not null comment 'possible values:
active, cancelled
'
);

create table room
(
    id        int auto_increment
        primary key,
    type      varchar(10) not null comment 'Possible values:
standard, deluxe
',
    maxpeople int         not null,
    bedtype   varchar(10) null comment 'Possible values:
twin, full',
    price     double      not null comment 'price in euros
'
);

--uus tabel--
