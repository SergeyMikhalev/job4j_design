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

INSERT INTO public.viliant(viliant_name, power) VALUES ('Joker', 2000);
INSERT INTO public.viliant(viliant_name, power) VALUES ('General Zod', 20000);

INSERT INTO public.hero(hero_name, power, antogonist_id) VALUES ('Batman', 7000, 1);
INSERT INTO public.hero(hero_name, power, antogonist_id) VALUES ('Superman', 10000, 2);
INSERT INTO public.hero(hero_name, power) VALUES ('Spiderman', 5000);
INSERT INTO public.hero(hero_name, power) VALUES ('Ironman', 8000);
INSERT INTO public.hero(hero_name, power) VALUES ('Anotherman', 1);


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
