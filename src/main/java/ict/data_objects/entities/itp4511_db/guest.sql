create table guest
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) not null,
    email      varchar(254) not null,
    booking_id bigint       not null,
    constraint user_guest_booking_id_9f853276_fk_user_booking_id
        foreign key (booking_id) references booking (id)
);

