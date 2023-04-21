create table booking_request_response
(
    id         bigint auto_increment
        primary key,
    approved   tinyint(1) not null,
    details_id bigint     null,
    constraint details_id
        unique (details_id),
    constraint user_booking_request_details_id_fe8e8379_fk_user_book
        foreign key (details_id) references booking_approval_details (id)
);

