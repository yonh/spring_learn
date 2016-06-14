create database spring;
use spring;
create table User(
	id int primary key auto_increment,
	name varchar(20)
);

create table Logs(
	id int primary key auto_increment,
	msg varchar(200)
);