create table Customer
(
  id           int auto_increment
    primary key,
  first_name    varchar(30) not null,
  last_name     varchar(30) not null,
  company_name  varchar(50) null,
  registry_code varchar(50) not null,
  constraint Customer_registrycode_uindex
    unique (registry_code)
);

create table Reservation
(
  id           int auto_increment
    primary key,
  room         int         not null comment 'referring to room table',
  customer     int         not null comment 'referring to customer table
',
  checkin_date  date        not null,
  checkout_date date        not null,
  payment      varchar(30) not null comment 'Possible values:
not paid, paid, partially paid',
  status       varchar(30) not null comment 'possible values:
active, cancelled
'
);

create table Room
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
