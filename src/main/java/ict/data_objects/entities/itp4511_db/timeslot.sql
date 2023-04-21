create table timeslot
(
    id         bigint auto_increment
        primary key,
    begin_time datetime(6) not null,
    end_time   datetime(6) not null
);

