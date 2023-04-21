create table venue
(
    id             bigint auto_increment
        primary key,
    name           varchar(255) not null,
    location       varchar(255) not null,
    available      tinyint(1)   not null,
    image          varchar(255) null,
    type           varchar(255) not null,
    capacity       int          not null,
    description    longtext     not null,
    booking_fee_id bigint       not null,
    constraint booking_fee_id
        unique (booking_fee_id),
    constraint user_venue_booking_fee_id_92b753c3_fk_user_booking_fee_id
        foreign key (booking_fee_id) references booking_fee (id)
);

