create table fundaciones (
	identificacion varchar(25),
	razonSocial varchar(75) NOT NULL,
	telefonoFijo varchar(15) NULL,
	telefonoMovil varchar(15) NULL,
	email varchar(50) NOT NULL,
	direccion varchar (75) NOT NULL,
	usuario varchar (25) NOT NULL,
	tipoEntidad varchar(50) NOT NULL,
	
	constraint PK_IDENTIFICACION_FUNDACIONES primary key (identificacion)

);
