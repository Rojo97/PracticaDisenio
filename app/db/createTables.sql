DROP TABLE OPERACIONDEMANTENIMIENTO;
DROP TABLE FLORESENLOTE;
DROP TABLE LOTE;

DROP TABLE TIPODEOPERACIONDEMANTENIMIENTO;
DROP TABLE TIPODEESTADODELOTE;

DROP TABLE LINEADEVENTA;
DROP TABLE VENTA;

DROP TABLE FACTURA;
DROP TABLE TRANSFERENCIA;

DROP TABLE LINEADEPEDIDO;
DROP TABLE PEDIDOAPROVEEDOR;
DROP TABLE PROVEEDOR;
DROP TABLE PRODUCTO;

DROP TABLE DISPONIBILIDADEMPLEADO;
DROP TABLE VINCULACIONCONLAEMPRESA;
DROP TABLE ROLESENEMPRESA;
DROP TABLE EMPLEADO;

DROP TABLE TIPODEDISPONIBILIDAD;
DROP TABLE TIPODEVINCULACION;
DROP TABLE TIPODEROL;

-- Enum
create table TIPODEROL
(
	IdTipo SMALLINT not null,
	nombreTipo VARCHAR(20) not null,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPODEROL
VALUES  (1,'Supervisor'),
        (2,'Administrativo'),
        (3,'Operario'),
        (4,'Dependiente');

-- Enum
create table TIPODEVINCULACION
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)

);

INSERT INTO TIPODEVINCULACION
VALUES  (1,'Contratado'),
        (2,'Despedido'),
        (3,'EnERTE');

-- Enum
create table TIPODEDISPONIBILIDAD
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPODEDISPONIBILIDAD
VALUES  (1,'Vacaciones'),
        (2,'BajaTemporal'),
	(3, 'Trabajando');

-- Entity
create table EMPLEADO
(
	Nif VARCHAR(9) not null,
	Nombre VARCHAR(30) not null,
	Password VARCHAR(20) not null,
	FechaInicioEnEmpresa DATE not null,
		PRIMARY KEY(Nif)
);

-- Association
create table ROLESENEMPRESA
(
	ComienzoEnRol DATE not null,
	Empleado VARCHAR(9) not null,
	Rol SMALLINT not null,
            FOREIGN KEY(Empleado) REFERENCES EMPLEADO(Nif),
            FOREIGN KEY(Rol) REFERENCES TIPODEROL(IdTipo)
);

-- Association
create table VINCULACIONCONLAEMPRESA
(
	inicio DATE not null,
	Empleado VARCHAR(9) not null,
	Vinculo SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADO(Nif),
		FOREIGN KEY(Vinculo) REFERENCES TIPODEVINCULACION(IdTipo)
);

-- Association
create table DISPONIBILIDADEMPLEADO
(
	Comienzo DATE not null,
	FinalPrevisto DATE,
	Empleado VARCHAR(9) not null,
	Disponibilidad SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADO(Nif),
		FOREIGN KEY(Disponibilidad) REFERENCES TIPODEDISPONIBILIDAD(IdTipo)
);

-- Entity
create table PRODUCTO
(
	Codigo VARCHAR(20) not null,
	Nombre VARCHAR(50) not null,
	Descripcion VARCHAR(200) not null,
	Existencias SMALLINT not null,
	CantidadNecesaria SMALLINT not null, -- funde cantidadNecesaria con CantidadMinimaEnStock
	PrecioDeVenta FLOAT, -- not null para Vendibles => subtipo=="Planta" o "Flor"
	PrecioCompra FLOAT, -- not null para Comprables => subtipo=="Auxiliar" o "Planta"
	DiasParaEntregaDelProveedor SMALLINT, -- not null para Comprables => subtipo=="Auxiliar" o "Planta"
	TipoDeProductoAuxiliar VARCHAR(50), --not null para subtipo=="Auxiliar"
	Subtipo VARCHAR(50) not null, -- "Auxiliar", "Planta", "Flor"
	PlantaDeLaFlor VARCHAR(20), -- not null para subtipo "Flor"
		PRIMARY KEY(Codigo),
		FOREIGN KEY(PlantaDeLaFlor) REFERENCES PRODUCTO(Codigo)
);

-- Entity
create table PROVEEDOR
(
	Cif VARCHAR(9) not null,
	Nombre VARCHAR(50) not null,
	Telefono VARCHAR(15) not null,
	Email VARCHAR(50) not null,
		PRIMARY KEY(Cif)
);

-- Entity
create table PEDIDOAPROVEEDOR
(
	NumeroDePedido INTEGER not null,
	FechaDeRealizacion DATE not null,
	EstaPendiente VARCHAR(1) not null,
	Proveedor VARCHAR(9) not null,
		PRIMARY KEY(NumeroDePedido),
		FOREIGN KEY(Proveedor) REFERENCES PROVEEDOR(Cif)
);

-- Entity
create table LINEADEPEDIDO
(
	Cantidad SMALLINT not null,
	Pedido INTEGER not null,
	Producto VARCHAR(20) not null,
		FOREIGN KEY(Pedido) REFERENCES PEDIDOAPROVEEDOR(NumeroDePedido),
		FOREIGN KEY(Producto) REFERENCES PRODUCTO(Codigo)
);

-- Entity
create table TRANSFERENCIA
(
	Id INTEGER not null,
	Importe FLOAT not null,
	FechaDeRealizacion DATE not null,
	Comprobada VARCHAR(1) not null,
	Administrativo VARCHAR(9) not null,
		PRIMARY KEY(Id),
		FOREIGN KEY(Administrativo) REFERENCES EMPLEADO(Nif)
);

-- Entity
create table FACTURA
(
	Id INTEGER not null,
	FechaDeEmision DATE not null,
	Importe FLOAT not null,
	CuentaBancaria VARCHAR(34) not null,
	Pedido INTEGER not null,
	EnTransferencia INTEGER, --null si no se ha realizado transferencia
		PRIMARY KEY(Id),
		FOREIGN KEY(EnTransferencia) REFERENCES TRANSFERENCIA(Id)
);

-- Entity
create table VENTA
(
	IdDeVenta INTEGER not null,
	FechaDeVenta DATE not null,
	Dependiente VARCHAR(9) not null,
		PRIMARY KEY(IdDeVenta),
		FOREIGN KEY(Dependiente) REFERENCES EMPLEADO(Nif)

);

-- Entity
create table LINEADEVENTA
(
	Cantidad SMALLINT not null,
	Venta INTEGER not null,
	Producto VARCHAR(20) not null,
		FOREIGN KEY(Venta) REFERENCES VENTA(IdDeVenta),
		FOREIGN KEY(Producto) REFERENCES PRODUCTO(Codigo)
);

-- Enum
create table TIPODEESTADODELOTE
(
	IdTipo SMALLINT not null,
	nombreTipo VARCHAR(20) not null,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPODEESTADODELOTE
VALUES  (1,'PendienteDePlantar'),
        (2,'Plantado'),
        (3,'EnProduccion'),
        (4,'FinDeVidaUtil'),
        (5,'Eliminado');

-- Enum
create table TIPODEOPERACIONDEMANTENIMIENTO
(
	IdTipo SMALLINT not null,
	nombreTipo VARCHAR(20) not null,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPODEOPERACIONDEMANTENIMIENTO
VALUES  (1,'Plantacion'),
        (2,'Poda'),
        (3,'Abonado'),
        (4,'Riego');

-- Entity
create table LOTE
(
	Id INTEGER not null,
	Cantidad SMALLINT not null,
	FechaDeCreacion DATE not null,
	Estado SMALLINT not null,
	Planta VARCHAR(20) not null,
		PRIMARY KEY(Id),
		FOREIGN KEY(Estado) REFERENCES TIPODEESTADODELOTE(IdTipo),
		FOREIGN KEY(Planta) REFERENCES PRODUCTO(Codigo)
);

-- Association
create table FLORESENLOTE
(
	Cantidad SMALLINT not null,
	Flor VARCHAR(20) not null,
	Lote INTEGER not null,
		FOREIGN KEY(Flor) REFERENCES PRODUCTO(Codigo),
		FOREIGN KEY(Lote) REFERENCES LOTE(Id)

);

-- Entity
create table OPERACIONDEMANTENIMIENTO
(
	FechaDeRealizacion DATE not null,
	Tipo SMALLINT not null,
	Operario VARCHAR(9) not null,
		PRIMARY KEY(FechaDeRealizacion,Tipo),
		FOREIGN KEY(Tipo) REFERENCES TIPODEOPERACIONDEMANTENIMIENTO(IdTipo),
		FOREIGN KEY(Operario) REFERENCES EMPLEADO(Nif),
		FOREIGN KEY(Lote) REFERENCES LOTE(Id)
);

# Escenarios:

/*
CU 1 Identificarse:
*/
--Supervisor
INSERT INTO EMPLEADO VALUES ('00000000A', 'supervisor', 'supervisor', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000A', 1);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES ('2010-01-01', '00000000A', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2010-01-01', '2045-01-01', '00000000A', 3);
--Administrativo
INSERT INTO EMPLEADO VALUES ('00000000B', 'administrativo', 'administrativo', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000B', 2);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES('2010-01-01', '00000000B', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2010-01-01', '2045-01-01', '00000000B', 3);
--Operario
INSERT INTO EMPLEADO VALUES ('00000000C', 'operario', 'operario', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000C', 3);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES('2010-01-01', '00000000C', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2010-01-01', '2045-01-01', '00000000C', 3);
--Dependiente
INSERT INTO EMPLEADO VALUES ('00000000D', 'dependiente', 'dependiente', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000D', 4);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES('2010-01-01', '00000000D', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2010-01-01', '2045-01-01', '00000000D', 3);
--De vacaciones
INSERT INTO EMPLEADO VALUES ('00000000E', 'supervacas', 'supervacas', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000E', 1);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES ('2010-01-01', '00000000E', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2018-08-01', '2019-06-01', '00000000E', 1);
--De baja
INSERT INTO EMPLEADO VALUES ('00000000F', 'adminbaja', 'adminbaja', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000F', 2);
INSERT INTO VINCULACIONCONLAEMPRESA  VALUES('2010-01-01', '00000000F', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2010-01-01', '2045-01-01', '00000000F', 2);
--Despedido
INSERT INTO EMPLEADO VALUES ('00000000G', 'operido', 'operido', '2010-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2010-01-02', '00000000G', 3);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES('2010-01-01', '00000000G', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2010-01-01', '2017-01-01', '00000000G', 3);
--EnERTE
INSERT INTO EMPLEADO VALUES ('00000000H', 'depenerte', 'depenerte', '2008-01-01');
INSERT INTO ROLESENEMPRESA VALUES ('2008-01-02', '00000000H', 4);
INSERT INTO VINCULACIONCONLAEMPRESA VALUES('2008-01-01', '00000000H', 1);
INSERT INTO DISPONIBILIDADEMPLEADO VALUES ('2018-01-01', '2019-01-01', '00000000H', 3);

/*
CU 2 Consultar facturas pendientes de pago:
*/
--Productos
INSERT INTO PRODUCTO VALUES('PLAN0002','Ficus','Planta para interior',10,1,null,0.5,2,null,'Planta',null);
INSERT INTO PRODUCTO VALUES('FLOR0002','Amapola','Amapolas rojas',5,1,null,0.5,1,null,'Flor','Amapola');
--Proveedores
INSERT INTO PROVEEDOR VALUES('A00000000', 'Mercadona', '983010101', 'mercadona@gmail.com') ;
INSERT INTO PEDIDOAPROVEEDOR VALUES(1, '2018-05-26', 'N', 'A00000000');
INSERT INTO FACTURA VALUES(1, '2018-05-26', 1203.45, '123123123', 1, null);
INSERT INTO PEDIDOAPROVEEDOR VALUES(2, '2018-05-26', 'N', 'A00000000');
INSERT INTO LINEADEPEDIDO  VALUES(1, 1, 'FLOR0002');
INSERT INTO LINEADEPEDIDO  VALUES(1, 2, 'PLAN0002');

INSERT INTO PROVEEDOR VALUES('B00000000', 'Carrefour', '983020202', 'carrefour@gmail.com') ;
INSERT INTO PEDIDOAPROVEEDOR VALUES(3, '2017-05-27', 'N', 'B00000000');
INSERT INTO FACTURA VALUES(2, '2017-05-27', 132.45, '456456456', 2, null);
INSERT INTO TRANSFERENCIA VALUES (1,132.45, '2017-05-27',1,'00000000B');
INSERT INTO LINEADEPEDIDO  VALUES(1, 3, 'FLOR0002');
INSERT INTO LINEADEPEDIDO  VALUES(1, 4, 'PLAN0002');

INSERT INTO PROVEEDOR VALUES('C00000000', 'Planticolor', '983232323', 'planticolorr@gmail.com') ;
INSERT INTO PEDIDOAPROVEEDOR VALUES(4, '2017-05-27', 'N', 'C00000000');
INSERT INTO FACTURA VALUES(3, '2016-05-27', 1203.45, '456456456', 3, null);
INSERT INTO PEDIDOAPROVEEDOR VALUES(5, '2017-05-27', 'N', 'C00000000');
INSERT INTO FACTURA VALUES(4, '2016-05-27', 1203.45, '456456456', 3, null);
INSERT INTO LINEADEPEDIDO VALUES(1, 5, 'FLOR0002');
INSERT INTO LINEADEPEDIDO VALUES(1, 4, 'PLAN0002');

--Productos
INSERT INTO PRODUCTO VALUES('AUXI0000','Maceta','Aqui va la tierra',2,3,null,0.5,null,TipoDeProductoAuxiliar,'Auxiliar',null);
INSERT INTO PRODUCTO VALUES('AUXI0001','Pala','Para coger la tierra',3,6,null,0.5,null,TipoDeProductoAuxiliar,'Auxiliar',null);
INSERT INTO PRODUCTO VALUES('AUXI0002','Rastrillo','Para arar la tierra',4,5,null,0.5,null,TipoDeProductoAuxiliar,'Auxiliar',null);
INSERT INTO PRODUCTO VALUES('PLAN0000','Stevia','Planta endulzante',10,CantidadNecesaria,null,0.5,diasEntragaProveedor,null,'Planta',null);
INSERT INTO PRODUCTO VALUES('PLAN0001','Aloe Vera','Planta ideal para la piel',10,CantidadNecesaria,null,0.5,diasEntragaProveedor,null,'Planta',null);
INSERT INTO PRODUCTO VALUES('PLAN0002','Ficus','Planta para interior',10,1,null,0.5,2,null,'Planta',null);
INSERT INTO PRODUCTO VALUES('FLOR0000','Geranio','Geranios azules',3,5,CantidadNecesaria,null,0.5,1,null,'Flor','Geranio');
INSERT INTO PRODUCTO VALUES('FLOR0001','Rosa','Rosas blancas',3,5,CantidadNecesaria,null,0.5,2,null,'Flor','Rosa');
INSERT INTO PRODUCTO VALUES('FLOR0002','Amapola','Amapolas rojas',CantidadNecesaria,null,0.5,1,null,'Flor','Amapola');

/*
CU 3 Modifcar estado de lote:
*/
--Lotes
INSERT INTO PRODUCTO VALUES('FLOR0001','Rosa','Rosas blancas',3,5,2.5,null,null,null,'Flor','Rosa');
INSERT INTO LOTE VALUES(0,5,'2018-02-01',1,'FLOR0001');
INSERT INTO LOTE VALUES(1,10,'2018-02-01',2,'FLOR0001');
INSERT INTO LOTE VALUES(2,5,'2018-02-01',3,'FLOR0001');
INSERT INTO LOTE VALUES(3,10,'2018-02-01',4,'FLOR0001');
INSERT INTO LOTE VALUES(4,5,'2018-02-01',5,'FLOR0001');
INSERT INTO FLORESENLOTE VALUES (12,0,'FLOR0001');
INSERT INTO FLORESENLOTE VALUES (10,1,'FLOR0001');
INSERT INTO FLORESENLOTE VALUES (8,2,'FLOR0001');
INSERT INTO FLORESENLOTE VALUES (12,3,'FLOR0001');
INSERT INTO FLORESENLOTE VALUES (12,4,'FLOR0001');

/*
CU 4 Registrar venta directa
*/
INSERT INTO VENTA VALUES(0,'2018-01-01','00000000D');
INSERT INTO LINEADEVENTA VALUES(1,0,'AUXI0000');
INSERT INTO PRODUCTO VALUES('AUXI0000','Maceta','Aqui va la tierra',5,2,5.5,null,null,'Util','Auxiliar',null);
INSERT INTO VENTA VALUES(1,'2018-01-01','00000000D');
INSERT INTO LINEADEVENTA VALUES(1,0,'PLAN0000');
INSERT INTO PRODUCTO VALUES('PLAN0000','Stevia','Planta endulzante',5,1,1.5,null,null,null,'Planta',null);
INSERT INTO VENTA VALUES(2,'2018-01-01','00000000D');
INSERT INTO LINEADEVENTA VALUES(1,0,'FLOR0000');
INSERT INTO PRODUCTO VALUES('FLOR0000','Geranio','Geranios azules',3,5,2.5,null,null,null,'Flor','FLOR0000');
INSERT INTO VENTA VALUES(3,'2018-01-01','00000000D');
INSERT INTO LINEADEVENTA VALUES(1,0,'AUXI0001');
INSERT INTO PRODUCTO VALUES('AUXI0001','Pala','Para coger la tierra',0,1,3.5,null,null,'Herramienta','Auxiliar',null);
INSERT INTO VENTA VALUES(4,'2018-01-01','00000000D');
INSERT INTO LINEADEVENTA VALUES(1,0,'PLAN0001');
INSERT INTO PRODUCTO VALUES('PLAN0001','Aloe Vera','Planta ideal para la piel',5,4,1.5,null,null,null,'Planta',null);