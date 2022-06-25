CREATE TABLE fsb_curator (
id serial primary key,
name varchar(255)
);

CREATE TABLE civilian (
id serial primary key,
name varchar(255),
age Integer,
curator_id Integer references fsb_curator(id) unique
);
