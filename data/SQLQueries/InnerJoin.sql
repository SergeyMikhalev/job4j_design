create table viliant(
    id serial primary key,
    viliant_name varchar(255),
    power int
);

create table hero(
    id serial primary key,
    hero_name varchar(255),
    power int,
    antogonist_id int references viliant(id) unique
);

select
h.hero_name as Имя, v.viliant_name as Враг
from
hero as h
join
viliant as v
on h.antogonist_id=v.id

select
h.hero_name as Герой, v.viliant_name as Зодей, h.power-v.power as Баланс
from
hero as h
join
viliant as v
on h.antogonist_id=v.id

select
h.hero_name||' слабее '||v.viliant_name as Вывод
from
hero as h
join
viliant as v
on h.antogonist_id=v.id
where h.power<v.power
