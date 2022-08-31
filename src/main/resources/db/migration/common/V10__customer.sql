drop table if exists customer;
create table customer
(
    id                 bigint not null auto_increment primary key,
    created_date       datetime(6),
    last_modified_date datetime(6),
    address            varchar(30),
    city               varchar(30),
    state              varchar(30),
    zip_code           varchar(30),
    customer_name      varchar(255),
    email              varchar(255),
    phone              varchar(255)
) engine = InnoDB;

alter table order_header
    add column customer_id bigint;

alter table order_header
    add constraint order_header_customer_pk foreign key (customer_id) references customer (id);

alter table order_header
    drop column customer_name;

insert into customer (customer_name, address, city, state, zip_code, phone, email)
values ('Customer 1', '123 Duval', 'Key West', 'FL', '33040', '305.292.1435',
        'cheeseburger@margaritville.com' );

update order_header set order_header.customer_id = (select id from customer limit 1);