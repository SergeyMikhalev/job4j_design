-- 1. Создать таблицы и заполнить их начальными данными

create table departments (
    id serial primary key,
    name varchar(255)
);

create table employees (
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments (name) values ('отдел Разработки');
insert into departments (name) values ('отдел Продаж');
insert into departments (name) values ('Бухгалтерия');
insert into departments (name) values ('отдел Координации отделов');

insert  into employees (name, department_id) values ('Иван Иванов', 1);
insert  into employees (name, department_id) values ('Петр Петров', 1);
insert  into employees (name, department_id) values ('Сергей Сергеев', 1);
insert  into employees (name, department_id) values ('Инна Снегова', 2);
insert  into employees (name, department_id) values ('Виктор Кривых', 1);
insert  into employees (name, department_id) values ('Людмила Сивкова', 3);
insert  into employees (name) values ('Виктор Кашин');
insert  into employees (name) values ('Роман Малахов');

-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select e.name as Сотрудник, d.name as Отдел
from employees as e left join departments as d on e.department_id=d.id;

select d.name as Отдел , e.name as Сотрудник
from employees as e right join departments as d on e.department_id=d.id
order by d.id;

select e.name as Сотрудник, d.name as Отдел
from employees as e cross join departments as d;

-- 3. Используя left join найти департаменты, у которых нет работников
select d.name as Отдел , e.name as Сотрудник
from employees as e right join departments as d on e.department_id=d.id
where e.name is null
order by d.id;

-- 4. Используя left и right join написать запросы, которые давали
-- бы одинаковый результат (порядок вывода колонок в эти запросах также должен быть идентичный).
select d.name as Отдел , e.name as Сотрудник
from employees as e right join departments as d on e.department_id=d.id
where e.name is not null;

select d.name as Отдел , e.name as Сотрудник
from departments as d left join employees as e  on e.department_id=d.id
where e.name is not null;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары
create table teens (
    id serial primary key,
    name varchar(255),
    gender varchar(255)
)

insert into teens(name,gender) values ('Tim','male');
insert into teens(name,gender) values ('John','male');
insert into teens(name,gender) values ('Kim','female');
insert into teens(name,gender) values ('Jane','female');

select t1.name as Имя_1, t1.gender as Гендер_1, t2.name as Имя_2,
t2.gender as Гендер_2 from teens as t1 cross join teens as t2 where t1.name!=t2.name
and t1.gender!=t2.gender
-- стоит ли убирать повторяющиеся пары??
and t1.gender='male'