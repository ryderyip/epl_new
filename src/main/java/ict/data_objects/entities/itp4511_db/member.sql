create table member
(
    id      bigint auto_increment
        primary key,
    info_id bigint not null,
    constraint info_id
        unique (info_id),
    constraint user_member_info_id_afff3d7b_fk_user_user_common_info_id
        foreign key (info_id) references user_common_info (id)
);

