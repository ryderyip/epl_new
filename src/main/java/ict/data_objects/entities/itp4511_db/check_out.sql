create table check_out
(
    id      bigint auto_increment
        primary key,
    time    datetime(6) not null,
    remarks longtext    not null
);

