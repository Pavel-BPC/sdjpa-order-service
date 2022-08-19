create table order_line
(
    id                 bigint not null auto_increment primary key,
    quantity_order int,
    order_header_id bigint,
    created_date       datetime(6),
    last_modified_date datetime(6),
    constraint order_header_pk FOREIGN KEY (order_header_id) references  order_header(id)
);