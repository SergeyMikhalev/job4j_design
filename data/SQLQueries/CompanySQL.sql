insert into company (id, name) values (1, 'Microsoft');
insert into company (id, name) values (2, 'Nvidia');
insert into company (id, name) values (3, 'AMD');
insert into company (id, name) values (5, 'Кока-Кола');
insert into company (id, name) values (6, 'Vault');

insert into person (id, name, company_id) values (1, 'Пётр Петров', 1);
insert into person (id, name, company_id) values (2, 'Иван Иванов', 1);
insert into person (id, name, company_id) values (3, 'Сергей Сергеев', 2);
insert into person (id, name, company_id) values (4, 'Николай Неколаев', 2);
insert into person (id, name, company_id) values (5, 'Андрей Андреев', 2);
insert into person (id, name, company_id) values (6, 'Евгений Евгеньев', 3);
insert into person (id, name, company_id) values (7, 'Игорь Игорев', 3);
insert into person (id, name, company_id) values (8, 'Жук Жуков', 3);
insert into person(id, name, company_id) values (9, 'Конан Варвар', 5);

select p.name as Работник, c.name as Компания
from person as p inner join company as c
on p.company_id=c.id
where c.id!=5;

select c.name as Компания, Count(p.name) as Количество_сотрудников
from company as c left join person as p
on c.id=p.company_id
group by c.name
having Count(p.name) =
( Select Max (y.cnt) from (
	select Count(p.name) as cnt
	from  person as p
	group by p.company_id
) y );
