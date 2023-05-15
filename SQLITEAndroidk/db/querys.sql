CREATE TABLE "clientes" (
	"id_cliente"	INTEGER NOT NULL UNIQUE,
	"nombre_cliente"	TEXT NOT NULL,
	"apellido_paterno"	TEXT NOT NULL,
	"apellido_materno"	TEXT NOT NULL,
	CONSTRAINT "pk_id_cliente" PRIMARY KEY("id_cliente" AUTOINCREMENT)
);

CREATE TABLE "numeros_de_telefono_clientes" (
	"id_numero"	INTEGER NOT NULL UNIQUE,
	"numero_telefono"	TEXT UNIQUE,
	"id_cliente"	INTEGER NOT NULL,
	FOREIGN KEY("id_cliente") REFERENCES "clientes"("id_cliente"),
	CONSTRAINT "pk_id_numero" PRIMARY KEY("id_numero" AUTOINCREMENT)
);

CREATE TABLE "correos_clientes" (
	"id_email"	INTEGER NOT NULL UNIQUE,
	"correo_cliente"	TEXT UNIQUE,
	"id_cliente"	INTEGER NOT NULL,
	CONSTRAINT "pk_id_email" PRIMARY KEY("id_email" AUTOINCREMENT),
	FOREIGN KEY("id_cliente") REFERENCES "clientes"("id_cliente")
);
CREATE TABLE "adeudos_de_clientes" (
	"id_edeudo"	INTEGER NOT NULL UNIQUE,
	"id_cliente"	INTEGER NOT NULL,
	"tipo_adeudo"	TEXT NOT NULL,
	"monto_adeudo"	REAL NOT NULL,
	"fecha_adeudo"	TEXT NOT NULL,
	"estado_adeudo"	TEXT NOT NULL,
	"descripcion"	TEXT,
	"update_at"	NUMERIC NOT NULL,
	FOREIGN KEY("id_cliente") REFERENCES "clientes"("id_cliente"),
	CONSTRAINT "pk_id_adeudo" PRIMARY KEY("id_edeudo" AUTOINCREMENT)
);

//operaciones de inserción
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno) 
VALUES 
('Francisco Javier','Méndez', 'Vázquez'),
('Javier','Martinez', 'Lopez'),
('Jose','Acevedo', 'Matinez');

INSERT INTO numeros_de_telefono_clientes (numero_telefono, id_cliente) 
VALUES 
('9532762953', 1),
('9512782953', 2),
('', 3);

INSERT INTO correos_clientes (correo_cliente, id_cliente) 
VALUES 
('fjmendez07@gmail.com', 1),
(' ', 2),
('micorreo@gmail.com', 3);

INSERT INTO adeudos_de_clientes (id_cliente, tipo_adeudo, monto_adeudo, 
fecha_adeudo, estado_adeudo, descripcion, update_at) 
VALUES 
(1, 'Comida', 70.0, '21-01-2023', 'Pendiente de pago', 'Pollo en salsa verde', datetime('now')),
(2, 'Comida', 140.0, '22-01-2023', 'Pendiente de pago', ' ', datetime('now')),
(3, 'Comida', 210.0, '22-01-2023', 'Pendiente de pago', 'Huevos a la mexicana con precio inflado', datetime('now'));

SELECT 
    nombre_cliente,
    apellido_paterno,
	apellido_materno,
	numero_telefono,
	correo_cliente,
	tipo_adeudo,
	monto_adeudo,
	fecha_adeudo,
	estado_adeudo,
	descripcion
FROM 
    clientes
INNER JOIN adeudos_de_clientes  ON adeudos_de_clientes.id_cliente = clientes.id_cliente
INNER JOIN numeros_de_telefono_clientes ON numeros_de_telefono_clientes.id_cliente = clientes.id_cliente
INNER JOIN correos_clientes  ON correos_clientes.id_cliente = clientes.id_cliente;

SELECT 
    nombre_cliente,
    apellido_paterno,
	apellido_materno,
	numero_telefono,
	correo_cliente,
	tipo_adeudo,
	monto_adeudo,
	fecha_adeudo,
	estado_adeudo,
	descripcion
FROM 
    clientes
INNER JOIN adeudos_de_clientes USING(id_cliente)
INNER JOIN numeros_de_telefono_clientes USING(id_cliente)
INNER JOIN correos_clientes  USING(id_cliente);

SELECT 
    c. nombre_cliente,
    c. apellido_paterno,
	c. apellido_materno,
	a. tipo_adeudo,
	a. monto_adeudo,
	a. fecha_adeudo,
	a. estado_adeudo,
	a. descripcion
FROM 
    clientes c
INNER JOIN adeudos_de_clientes a  ON a.id_cliente = c.id_cliente;

SELECT 
    c. nombre_cliente,
    c. apellido_paterno,
	c. apellido_materno,
	n. numero_telefono,
	e. correo_cliente,
	a. tipo_adeudo,
	a. monto_adeudo,
	a. fecha_adeudo,
	a. estado_adeudo,
	a. descripcion
FROM 
    clientes c
INNER JOIN adeudos_de_clientes a  ON a.id_cliente = c.id_cliente
INNER JOIN numeros_de_telefono_clientes n ON n.id_cliente = c.id_cliente
INNER JOIN correos_clientes e  ON e.id_cliente = c.id_cliente;


SELECT 
    c. nombre_cliente AS 'Nombre',
    c. apellido_paterno AS 'Apellido paterno',
	c. apellido_materno AS 'Apellido materno',
	n. numero_telefono AS 'Teléfono',
	e. correo_cliente AS 'Email',
	a. tipo_adeudo AS 'Tipo de adeudo',
	a. monto_adeudo AS 'Monto a pagar',
	a. fecha_adeudo AS 'Fecha de compra',
	a. estado_adeudo AS 'Estado de deuda',
	a. descripcion AS 'Descripción'
FROM 
    clientes c
INNER JOIN adeudos_de_clientes a  ON a.id_cliente = c.id_cliente
INNER JOIN numeros_de_telefono_clientes n ON n.id_cliente = c.id_cliente
INNER JOIN correos_clientes e  ON e.id_cliente = c.id_cliente;