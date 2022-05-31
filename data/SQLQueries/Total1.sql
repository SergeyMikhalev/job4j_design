create table students (
id serial primary key,
name varchar(255),
age int,
sex boolean
)

insert into students(name,age,sex) values ('Viktor' , 30, true)

update students set age=32

delete from students