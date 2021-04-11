create table users(
    id serial primary key,
    name varchar(100) not null,
    email varchar(100) not null
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