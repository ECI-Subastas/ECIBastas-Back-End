create table users(
    user_id int primary key,
    nickname varchar(100) not null,
    full_name varchar(100) not null,
    email varchar(100) not null,
    phone char(10) not null,
    user_role varchar(13) not null
);

create table sale(
    id serial primary key,
    seller integer not null,
    purchaser integer,
    saleDate date not null,
    saleTime integer not null,
    price integer not null,
    offeredCoins integer,
    constraint fk1 foreign key (seller) references users(id),
    constraint fk1 foreign key (purchaser) references users(id)
);