create table venue_usage
(
    id              bigint auto_increment
        primary key,
    check_in        datetime(6) not null,
    check_out_id    bigint      not null,
    member_comments longtext    not null,
    booking_id      bigint      not null,
    constraint booking_id
        unique (booking_id),
    constraint venue_usage_check_out_id_0afba366_uniq
        unique (check_out_id),
    constraint venue_usage_booking_id_b290bf52_fk_booking_id
        foreign key (booking_id) references booking (id),
    constraint venue_usage_check_out_id_0afba366_fk_check_out_id
        foreign key (check_out_id) references check_out (id)
);

