-- Триггер №1
create or replace function collect_tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger collect_tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure collect_tax();


-- Триггер №2
create or replace function collect_tax_row()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price * 1.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger collect_tax_row_trigger
    before insert on products
    for each row
    execute procedure collect_tax_row();

-- Триггер №3 Создание таблицы
create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

-- Триггер №3
create or replace function write_price_history()
    returns trigger as
$$
    BEGIN
        insert into history_of_price(name, price, date)
        values(new.product_name, new.price, current_timestamp);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger price_history_trigger
    after insert on products
    for each row
    execute procedure write_price_history();


-- Запрос для тестирования триггеров при добавлении продукта
insert into products (product_name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);