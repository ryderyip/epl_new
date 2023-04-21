create table user_common_info
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) not null,
    gender   varchar(1)   not null,
    phone    varchar(50)  not null,
    email    varchar(254) not null,
    username varchar(255) null,
    password varchar(255) not null,
    constraint email
        unique (email),
    constraint username
        unique (username)
);

