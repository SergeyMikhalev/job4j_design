create table roles (
id serial primary key,
role_name varchar(255) not null
);

create table users (
id serial primary key,
user_name varchar(255) not null,
user_role_id integer references roles(id) not null
);

create table rules (
id serial primary key,
rule_name varchar(255) not null
);

create table rules_for_roles (
id serial primary key,
role_id integer references roles(id) not null,
rule_id integer references rules(id) not null
);

create table categories (
id serial primary key,
category_name varchar(255) not null
);

create table states (
id serial primary key,
state_name varchar(255) not null
);

create table items (
id serial primary key,
item_name varchar(255) not null,
item_user_id integer references users(id) not null,
item_category_id integer references categories(id) not null,
item_state_id integer references states(id) not null
);

create table comments (
id serial primary key,
comment_text text not null,
item_id integer references items(id) not null
);

create table attachs (
id serial primary key,
file_path varchar(255) not null,
item_id integer references items(id) not null
);

