create table heights (
    id serial primary key,
    name varchar(50),
	height integer
);

insert into heights(name, height) values ('Vasia',155);
insert into heights(name, height) values ('Kolia',170);
insert into heights(name, height) values ('Petia',190);

select * from heights;

select AVG(height) from heights;

update heights set height = 160 where name = 'Vasia';

update heights set height = 180 where name = 'Kolia';

-- ƒополнительный запрос по точкам сохранени€

delete from heights where id =3;