drop table DISPONIBILIDADEMPLEADO;
drop table VINCULACIONCONLAEMPRESA;
drop table ROLESENLAEMPRESA;
drop table EMPLEADO;

drop table ESTADODEDISPONIBILIDAD;
drop table ESTADODELVINCULO;
drop table ROLEMPLEADO;

-- Enum
create table ROLEMPLEADO
(
	IdRol SMALLINT not null,
	NombreRol VARCHAR(20) not null,
		PRIMARY KEY(IdRol)
);

INSERT INTO ROLEMPLEADO
VALUES  (1,'Administrativo'),
        (2,'Dependiente'),
        (3,'Operario'),
        (4, 'Supervisor');

-- Enum
create table ESTADODELVINCULO
(
	IdEstado SMALLINT not null,
	NombreEstado VARCHAR(20) not null unique,
		PRIMARY KEY(IdEstado)

);

INSERT INTO ESTADODELVINCULO
VALUES  (1,'Contratado'),
        (2,'Despedido'),
        (3,'EnERTE');

-- Enum
create table ESTADODEDISPONIBILIDAD
(
	IdEstado SMALLINT not null,
	NombreEstado VARCHAR(20) not null unique,
		PRIMARY KEY(IdEstado)
);

INSERT INTO ESTADODEDISPONIBILIDAD
VALUES  (1,'Vacaciones'),
        (2,'BajaTemporal'),
	(3, 'Trabajando');

-- Entity
create table EMPLEADO
(
	NifCif VARCHAR(9) not null,
	Nombre VARCHAR(30) not null,
	FechaInicioEnEmpresa DATE not null,
	DireccionPostal VARCHAR(100),
	DireccionElectronica VARCHAR(30),
	Telefono VARCHAR(9),
	Password VARCHAR(20) not null,
		PRIMARY KEY(NifCif)
);

-- Relation
create table ROLESENLAEMPRESA
(
	NifCif VARCHAR(9) not null,
	Rol SMALLINT not null,
	ComienzoEnRol DATE not null,
            FOREIGN KEY(NifCif) REFERENCES EMPLEADO(NifCif),
            FOREIGN KEY(Rol) REFERENCES ROLEMPLEADO(IdRol)
);

-- Relation
create table VINCULACIONCONLAEMPRESA
(
	Fecha DATE not null,
	Empleado VARCHAR(9) not null,
	Estado SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADO(NifCif),
		FOREIGN KEY(Estado) REFERENCES ESTADODELVINCULO(IdEstado) 
);

-- Relation
create table DISPONIBILIDADEMPLEADO
(
	Comienzo DATE not null,
	FinalPrevisto DATE,
	Empleado VARCHAR(9) not null,
	Estado SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADO(NifCif),
		FOREIGN KEY(Estado) REFERENCES ESTADODEDISPONIBILIDAD(IdEstado)
);
