drop table if exists order_approval;
create table order_approval
(
    id                 bigint not null auto_increment primary key,
    created_date       datetime(6),
    last_modified_date datetime(6),
    approval_by        varchar(50)
) engine = InnoDB;

alter table order_header
    add column order_approval_id bigint;

alter table order_header
    add constraint order_approval_pk
        foreign key (order_approval_id) references order_approval (id);
