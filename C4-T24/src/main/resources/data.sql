DROP table IF EXISTS trabajador;

create table trabajador(
	id int auto_increment,
	nombre varchar(250),
	trabajo enum('Programador','Dependienta','CEO', 'Arquitecto'),
	salario double
);

insert into trabajador (nombre, trabajo,salario) values ('Marta', 'Programador', 0);
insert into trabajador (nombre, trabajo,salario) values ('Eduardo', 'Dependienta', 0);
insert into trabajador (nombre, trabajo,salario) values ('Elena', 'CEO', 0);
insert into trabajador (nombre, trabajo,salario) values ('Facundo', 'Arquitecto', 0);
insert into trabajador (nombre, trabajo,salario) values ('Izaskun', 'Dependienta', 0);