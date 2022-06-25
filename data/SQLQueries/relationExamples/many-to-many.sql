CREATE TABLE persons (
id serial primary key,
person_name varchar(255)
);

CREATE TABLE citizenships (
id serial primary key,
country_name varchar(255)
);

CREATE TABLE person_citizenship (
id serial primary key,
person_id Integer references persons(id),
citizenship_id Integer references citizenship(id)
);