CREATE TABLE bands (
id serial primary key,
band_name varchar(255)
);

CREATE TABLE musician (
id serial primary key,
musician_name varchar(255),
band_id Integer references bands(id)
);