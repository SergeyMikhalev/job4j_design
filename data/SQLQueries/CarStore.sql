create table bodywork(
    id serial primary key,
    body_name varchar(255)
);

create table engine(
    id serial primary key,
    engine_name varchar(255)
);

create table transmission(
    id serial primary key,
    transmission_name varchar(255)
);

create table car(
    id serial primary key,
    car_name varchar(255),
    body_id int references bodywork(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);



insert into bodywork (body_name) values ('Кузов 1');
insert into bodywork (body_name) values ('Кузов 2');
insert into bodywork (body_name) values ('Кузов 3');

insert into engine (engine_name) values ('Двигатель 1');
insert into engine (engine_name) values ('Двигатель 2');
insert into engine (engine_name) values ('Двигатель 3');

insert into transmission (transmission_name) values ('Коробка 1');
insert into transmission (transmission_name) values ('Коробка 2');

insert into car (car_name,body_id,engine_id,transmission_id) values ('Москваич',1,2,2);
insert into car (car_name,body_id,engine_id,transmission_id) values ('Запорожец',2,1,2);
insert into car (car_name,body_id,engine_id,transmission_id) values ('Жигули',2,2,2);
insert into car (car_name,body_id,engine_id) values ('Камаз',2,2);
insert into car (car_name,engine_id,transmission_id) values ('Белаз',2,2);

select c.car_name as Машина, b.body_name as Кузов, e.engine_name as Двигатель, t.transmission_name as Коробка
from car as c left join bodywork as b on c.body_id=b.id
left join engine as e on c.engine_id=e.id
left join transmission as t on c.transmission_id=t.id;

select  b.body_name as Кузов
from car as c right join bodywork as b on c.body_id=b.id
where c.car_name is null;

select e.engine_name as Двигатель
from car as c right join engine as e on c.engine_id=e.id
where c.car_name is null;

select  t.transmission_name as Коробка
from car as c right join transmission as t on c.transmission_id=t.id
where c.car_name is null;
