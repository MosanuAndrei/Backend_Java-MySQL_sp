create database platformdb;

use platformdb;

create table Platform(
	IDPlatform int primary key auto_increment,
    NamePlatform varchar(255),
    PricePerMonth double
);

create table Category(
	IDCategory int primary key auto_increment,
    NameCategory varchar(255)
);

create table Series(
	IDSeries int primary key auto_increment,
    NameSeries varchar(255),
    NumberOfSeasons int,
    IDCategory int,
    IDPlatform int,
    foreign key(IDCategory) references Category(IDCategory),
    foreign key(IDPlatform) references Platform(IDPlatform)
);

drop table Series;
drop table Platform;
drop table Category;

insert into Platform(NamePlatform,PricePerMonth) values("Netflix",9.99);
insert into Platform(NamePlatform,PricePerMonth) values("Amazon Prime Video",12.99);
insert into Platform(NamePlatform,PricePerMonth) values("Hulu",5.99);
insert into Platform(NamePlatform,PricePerMonth) values("HBO Max",14.99);
insert into Platform(NamePlatform,PricePerMonth) values("Disney+",7.99);

insert into Category(NameCategory) values("Action");
insert into Category(NameCategory) values("Drama");
insert into Category(NameCategory) values("Comedy");
insert into Category(NameCategory) values("History");
insert into Category(NameCategory) values("Family");

select * from platformdb.series;
select * from platformdb.category;
select * from platformdb.platform;
