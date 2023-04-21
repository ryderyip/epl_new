create table staff_venues_in_charge
(
    id       bigint auto_increment
        primary key,
    staff_id bigint not null,
    venue_id bigint not null,
    constraint staff_venues_in_charge_staff_id_venue_id_c6747aeb_uniq
        unique (staff_id, venue_id),
    constraint staff_venues_in_charge_staff_id_dd28c52c_fk_staff_id
        foreign key (staff_id) references staff (id),
    constraint staff_venues_in_charge_venue_id_20222731_fk_venue_id
        foreign key (venue_id) references venue (id)
);

