create table booking_fee
(
    id          bigint auto_increment
        primary key,
    hourly_rate decimal(6, 2) not null,
    year        int           not null
);

