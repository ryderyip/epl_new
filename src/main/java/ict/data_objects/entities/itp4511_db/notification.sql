create table notification
(
    id           bigint auto_increment
        primary key,
    message      longtext   not null,
    seen         tinyint(1) not null,
    user_info_id bigint     not null,
    constraint user_info_id
        unique (user_info_id),
    constraint user_notification_user_info_id_9a6a9ceb_fk_user_user
        foreign key (user_info_id) references user_common_info (id)
);

