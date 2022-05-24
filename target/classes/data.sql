/**
 * CREATE Script for init of DB
 */

 /*create table driver
 (
     id            int PRIMARY KEY,
     date_created  datetime,
     deleted       boolean,
     online_status varchar(255),
     password      varchar(255) not null ,
     username      varchar(255) not null

 );

alter table driver
add column coordinate varchar(max);
alter table driver
    add column date_coordinate_updated datetime;


drop table driver;*/

-- Create 3 OFFLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (1, now(), false, 'OFFLINE',
'driver01pw', 'driver01');

insert into driver (id, date_created, deleted, online_status, password, username) values (2, now(), false, 'OFFLINE',
'driver02pw', 'driver02');

insert into driver (id, date_created, deleted, online_status, password, username) values (3, now(), false, 'OFFLINE',
'driver03pw', 'driver03');


-- Create 3 ONLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (4, now(), false, 'ONLINE',
'driver04pw', 'driver04');

insert into driver (id, date_created, deleted, online_status, password, username) values (5, now(), false, 'ONLINE',
'driver05pw', 'driver05');

insert into driver (id, date_created, deleted, online_status, password, username) values (6, now(), false, 'ONLINE',
'driver06pw', 'driver06');

-- Create 1 OFFLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (7,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'OFFLINE',
'driver07pw', 'driver07');

-- Create 1 ONLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (8,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'ONLINE',
'driver08pw', 'driver08');


insert into manufacturer(id, name) values(1,'seat');
insert into manufacturer(id, name) values(2,'mercedes');
insert into manufacturer(id, name) values(3,'ford');
insert into manufacturer(id, name) values(4,'toyota');

insert into car(id, convertible, date_created, deleted, engine_type, license_plate, rating, seat_count, manufacturer_id)
values ( 1, false, now(), false, 'DIESEL', 'HHK7431', 4, 5, 1);

insert into car(id, convertible, date_created, deleted, engine_type, license_plate, rating, seat_count, manufacturer_id)
values ( 2, true, now(), false, 'ELECTRIC', 'HHKM777', 5, 5, 2);

insert into car(id, convertible, date_created, deleted, engine_type, license_plate, rating, seat_count, manufacturer_id)
values ( 3, false, now(), false, 'GAS', 'HHMM645', 3, 7, 3);

insert into car(id, convertible, date_created, deleted, engine_type, license_plate, rating, seat_count, manufacturer_id)
values ( 4, false, now(), false, 'DIESEL', 'HHL4732', 4, 11, 4);