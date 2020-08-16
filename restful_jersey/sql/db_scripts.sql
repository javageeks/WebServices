CREATE DATABASE restful_webservices;
USE restful_webservices;

create table hotel (
	id  int(3) NOT NULL,
	name varchar(120) NOT NULL,
	PRIMARY KEY (id)
);


INSERT INTO hotel (id, name)
VALUES (101, 'Taj');