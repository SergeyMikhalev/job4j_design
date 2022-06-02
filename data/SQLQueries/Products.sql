create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('КОЛБАСА');

insert into product (name, type_id, expired_date, price) values ('Брынза',1,'01.06.2022', 100.0);
insert into product (name, type_id, expired_date, price) values ('Тильзиттер',1,'10.06.2022', 150.0);
insert into product (name, type_id, expired_date, price) values ('Маасдам',1,'10.06.2022', 200.0);

insert into product (name, type_id, expired_date, price) values ('Веселый молочник',2,'10.06.2022', 70.0);
insert into product (name, type_id, expired_date, price) values ('Грустная молочница',2,'1.05.2022', 75.0);
insert into product (name, type_id, expired_date, price) values ('Молмороженое',2,'1.05.2022', 75.0);

insert into product (name, type_id, expired_date, price) values ('Колбаса 1',3,'11.06.2022', 170.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 2',3,'10.06.2022', 170.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 3',3,'12.06.2022', 170.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 4',3,'10.06.2022', 170.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 5',3,'10.06.2022', 170.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 6',3,'14.06.2022', 170.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 7',3,'14.06.2022', 270.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 8',3,'10.06.2022', 270.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 9',3,'10.03.2022', 270.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 10',3,'10.07.2022', 370.0);
insert into product (name, type_id, expired_date, price) values ('Колбаса 11',3,'10.07.2022', 370.0);

select
p.name as product_name,
p.expired_date as exp_date,
p.price as price
from product as p join type as t on p.type_id=t.id
where t.name='СЫР';

select * from product where name like '%мороженое%';

select * from product where expired_date < now();

select * from product where price = (select MAX(price) from product)

select
t.name as имя_типа,
count(p.id) as количество
from product as p join type as t on p.type_id=t.id
group by имя_типа;

select
p.name as product_name,
p.expired_date as exp_date,
p.price as price,
t.name as prod_type
from product as p join type as t on p.type_id=t.id
where t.name='СЫР' or t.name='МОЛОКО';

select
t.name as имя_типа
from product as p join type as t on p.type_id=t.id
group by имя_типа
having count(p.id)<10;

select
p.name as product_name,
p.expired_date as exp_date,
p.price as price,
t.name as prod_type
from product as p join type as t on p.type_id=t.id;