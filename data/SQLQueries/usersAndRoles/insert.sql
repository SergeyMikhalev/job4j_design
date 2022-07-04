insert into roles (role_name) values ('Заявитель');
insert into roles (role_name) values ('Исполнитель');

insert into users (user_name, user_role_id) values ('Виталик',1);
insert into users (user_name, user_role_id) values ('Василий',2);

insert into rules (rule_name) values ('Правило 1');
insert into rules (rule_name) values ('Правило 2');

insert into rules_for_roles (role_id, rule_id) values (1,1);
insert into rules_for_roles (role_id, rule_id) values (1,2);
insert into rules_for_roles (role_id, rule_id) values (2,1);
insert into rules_for_roles (role_id, rule_id) values (2,2);

insert into categories (category_name) values ('Категория 1');
insert into categories (category_name) values ('Категория 2');

insert into states (state_name) values ('Cостояние 1');
insert into states (state_name) values ('Cостояние 2');

insert into items (item_name, item_user_id, item_category_id, item_state_id)
values ('Заявка 1', 1, 1, 1);

insert into comments (comment_text, item_id) values ('Комментарий 1',1);

insert into attachs (file_path, item_id) values ('Какой-то файл' ,1);