
create table if not exists mvccaracc(
	id int auto_increment primary key,
    name varchar(50) not null,
    address varchar(50) not null,
    phone varchar(15) not null,
    username varchar(30) unique not null,
    password varchar(30) not null,
    carsrented int not null default 0);
    
create table if not exists caradmin(
	id int auto_increment primary key,
    name varchar(50) not null,
    address varchar(50) not null,
    phone varchar(15) not null,
    username varchar(30) unique not null,
    password varchar(30) not null);
    
create table if not exists car(
	carid int auto_increment primary key,
    model varchar(30),
    price int not null,
    lentstatus boolean default false);
    
create table if not exists carlents(
	carid int,
    foreign key (carid) references car(carid),
    uid int,
    foreign key (uid) references mvccaracc(id));
