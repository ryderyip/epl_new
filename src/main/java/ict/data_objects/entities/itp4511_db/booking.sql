create table booking
(
    id                          bigint auto_increment
        primary key,
    requested_on                datetime(6) default current_timestamp(6) not null,
    booker_id                   bigint                                   not null,
    booking_request_response_id bigint                                   null,
    timeslot_id                 bigint                                   not null,
    venue_id                    bigint                                   not null,
    constraint booking_request_response_id
        unique (booking_request_response_id),
    constraint timeslot_id
        unique (timeslot_id),
    constraint booking_booking_request_resp_c9d70587_fk_booking_r
        foreign key (booking_request_response_id) references booking_request_response (id),
    constraint user_booking_booker_id_6d3982e2_fk_user_member_id
        foreign key (booker_id) references member (id),
    constraint user_booking_timeslot_id_5e3ff03c_fk_user_timeslot_id
        foreign key (timeslot_id) references timeslot (id),
    constraint user_booking_venue_id_9a0e6eb7_fk_user_venue_id
        foreign key (venue_id) references venue (id)
);

