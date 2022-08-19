create table product (
                         id bigint not null auto_increment,
                         created_date datetime(6),
                         last_modified_date datetime(6),
                         product_status varchar(255),
                         description varchar(100),
                         primary key (id)
) engine=InnoDB;