create table product (
    id serial primary key,
    name varchar(255) not null,
    price decimal(10, 2) not null,
    description varchar(255) not null
);

create table notification(
    id serial primary key,
    product_name varchar(255) not null,
    date timestamp not null,
    format varchar(255) not null
);