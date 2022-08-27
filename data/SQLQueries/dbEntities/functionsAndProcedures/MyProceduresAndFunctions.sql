DROP FUNCTION f_delete_data(integer);

create or replace function f_delete_data(i_id integer)
returns void
language 'plpgsql'
as
$$
	begin
        delete from products where id = i_id;
    end;
$$;

DROP PROCEDURE delete_data();

create or replace procedure delete_data()
language 'plpgsql'
as $$
    BEGIN
    delete from products where count<1;
    END
$$;
