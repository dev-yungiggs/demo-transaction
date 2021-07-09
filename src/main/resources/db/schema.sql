DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `order_goods`;
DROP TABLE IF EXISTS `goods`;

create table `orders`
(
    order_id int auto_increment primary key,
    order_name varchar(200) null,
    total_price int null,
    order_user varchar(200) null,
    created_at int null,
    updated_at int null
);

create table order_goods
(
    order_goods_id int auto_increment primary key,
    order_id int null,
    goods_id int not null,
    order_goods_price int null,
    created_at datetime null,
    updated_at datetime null
);

create table goods
(
    goods_id int auto_increment primary key,
    goods_code varchar(200) null,
    goods_name varchar(200) null,
    goods_price int null,
    created_at datetime null,
    updated_at datetime null
);
