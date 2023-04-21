create table booking_approval_details
(
    id                bigint auto_increment
        primary key,
    booking_fee       decimal(8, 2) not null,
    payment_receipt   varchar(255)  null,
    payment_confirmed tinyint(1)    not null
);

