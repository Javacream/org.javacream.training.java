drop table books if exists;
create table BOOKS (isbn varchar(64), title varchar(256), price double, pages int, available boolean, primary key (isbn));
insert into books (isbn, title, price, pages, available) values('ISBN1', 'Java', 19.99, 200, 'true');
insert into books (isbn, title, price, pages, available) values('ISBN2', 'Eclipse', 29.99, 500, 'true');
insert into books (isbn, title, price, pages, available) values('ISBN3', '.NET', 39.99, 100, 'false');
insert into books (isbn, title, price, pages, available) values('ISBN4', 'Http', 69.99, 1500, 'true');
insert into books (isbn, title, price, pages, available) values('ISBN5', 'Linux', 9.99, 2500, 'true');
select * from books;
select title from books where price > 25;
select * from books where available = 'false';
select * from books where title like '%i%';

drop table ISBN if exists
create table ISBN (isbn int)
insert into ISBN values(100)