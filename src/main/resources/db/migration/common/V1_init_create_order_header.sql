drop table if exists order_header;
create table order_header (
                              id        bigint not null auto_increment primary key,
                              customer_name varchar(255)
) engine=InnoDB;