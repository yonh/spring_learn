create table film (
    id integer primary key auto_increment,
    name varchar(20) not null,
    director varchar(32) not null,
    price double precision not null,
    pubdate char(20) not null,
    company varchar(32) not null
);

insert into film values(null,'填埋传奇','赵本山',20,'2012-12-12','本山传媒');
insert into film values(null,'填埋传奇2','赵本山',30,'2012-12-13','本山传媒');
insert into film values(null,'填埋传奇3','赵本山',40,'2012-12-14','本山传媒');