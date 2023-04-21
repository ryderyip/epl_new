create table staff
(
    id      bigint auto_increment
        primary key,
    role    varchar(1) not null,
    info_id bigint     not null,
    constraint info_id
        unique (info_id),
    constraint user_staff_info_id_27ce7878_fk_user_user_common_info_id
        foreign key (info_id) references user_common_info (id)
);

