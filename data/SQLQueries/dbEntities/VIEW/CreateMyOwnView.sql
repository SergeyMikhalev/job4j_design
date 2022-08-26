create view most_popular_author as
select  a.name as author from authors as a
join books as b on b.author_id=a.id
join orders as o on o.book_id = b.id
group by author
HAVING count(o.id) = (
Select max(y.num) from ( select   count(o.id) as num
 from books as b
join orders as o on o.book_id = b.id
group by b.author_id
) y );

