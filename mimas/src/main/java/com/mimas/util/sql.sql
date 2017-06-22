create table fundaciones (
	identificacion varchar(25),
	razonSocial varchar(75) NOT NULL,
	telefonoFijo varchar(15) NOT NULL,
	telefonoMovil varchar(15) NOT NULL,
	email varchar(50) NOT NULL,
	direccion varchar (75) NOT NULL,
	usuario varchar (25) NOT NULL,
	tipoEntidad varchar(50) NOT NULL

)
add constraint PK_IDENTIFICACION_FUNDACIONES primary key (identificacion);