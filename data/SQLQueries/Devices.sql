create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name,price) values ('laptop',100.0);
insert into devices (name,price) values ('PC',200.0);
insert into devices (name,price) values ('playstation',300.0);
insert into devices (name,price) values ('xbox',250.0);
insert into devices (name,price) values ('n0tebook',20000.0);


insert into people (name) values ('Антон');
insert into people (name) values ('Игорь');
insert into people (name) values ('Олег');

insert into devices_people (device_id, people_id) values (1,1);
insert into devices_people (device_id, people_id) values (2,1);
insert into devices_people (device_id, people_id) values (3,1);
insert into devices_people (device_id, people_id) values (2,2);
insert into devices_people (device_id, people_id) values (3,2);
insert into devices_people (device_id, people_id) values (4,2);
insert into devices_people (device_id, people_id) values (1,3);
insert into devices_people (device_id, people_id) values (4,3);
insert into devices_people (device_id, people_id) values (5,3);

select AVG(price) as Average_price from devices;

select p.name as people_name, AVG(d.price) as avg_price
from people as p
join devices_people as d_p on p.id=d_p.people_id
join devices as d on d.id=d_p.device_id
group by people_name;

select p.name as people_name, AVG(d.price) as avg_price
from people as p
join devices_people as d_p on p.id=d_p.people_id
join devices as d on d.id=d_p.device_id
group by people_name
having AVG(d.price)>5000;