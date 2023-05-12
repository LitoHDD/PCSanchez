-- CREACION DE TABLAS --

CREATE TABLE ps_usuario(
    codigo NUMBER(8),
    email VARCHAR2(40) NOT NULL,
    pass VARCHAR2(20) NOT NULL,
    nombre_comp VARCHAR2(20) NOT NULL,
    foto VARCHAR2(250),
    telefono NUMBER(9),
    fecha_nacimiento DATE,
    tipoUsuario VARCHAR2(7) NOT NULL,
    PRIMARY KEY(codigo),
    UNIQUE(email),
    CONSTRAINT tipoUsuario CHECK (tipoUsuario IN ('CLIENTE', 'ADMIN'))
);

CREATE TABLE ps_tarjeta(
    cod_pago NUMBER(8),
    num_tarjeta NUMBER(18),
    cod_usuario NUMBER(8) NOT NULL,
    CONSTRAINT fk_cod_numero FOREIGN KEY (cod_usuario) REFERENCES ps_usuario(codigo),
    PRIMARY KEY(cod_pago)
);

CREATE TABLE ps_direccion(
    numero NUMBER(4),
    tipo VARCHAR2(10) NOT NULL,
    direccion VARCHAR2(40) NOT NULL,
    poblacion VARCHAR2(40) NOT NULL,
    provincia VARCHAR2(40) NOT NULL,
    codigo_usuario_direccion NUMBER(8) NOT NULL,
    PRIMARY KEY(numero, codigo_usuario_direccion),
    CONSTRAINT fk_cod_usuario_direccion FOREIGN KEY (codigo_usuario_direccion) REFERENCES ps_usuario(codigo)
);

CREATE TABLE ps_factura(
    cod_factura NUMBER(8),
    fecha DATE NOT NULL,
    numero_pedido NUMBER(8) NOT NULL,
    cod_usuario NUMBER(8) NOT NULL,
    cod_usuario_direccion NUMBER(8) NOT NULL,
    numero_direccion NUMBER(4) NOT NULL,
    PRIMARY KEY(cod_factura),
    CONSTRAINT fk_cod_usuario FOREIGN KEY (cod_usuario) REFERENCES ps_usuario(codigo),
    CONSTRAINT fk_cod_usuario_dire FOREIGN KEY (cod_usuario_direccion, numero_direccion) REFERENCES ps_direccion(codigo_usuario_direccion, numero)
);   

CREATE TABLE ps_cesta (
    codigo NUMBER(8),
    numero_usuario NUMBER(8),
    precio_cesta NUMBER (9, 2) NOT NULL,
    CONSTRAINT ps_cesta_pk PRIMARY KEY (codigo),
    CONSTRAINT ps_cesta_fk FOREIGN KEY (numero_usuario) REFERENCES ps_usuario
);

CREATE TABLE ps_pedido(
    numero NUMBER(8),
    facturado CHAR(1) NOT NULL,
    fecha_pedido DATE NOT NULL,
    numero_direccion NUMBER(4) NOT NULL,
    codigo_usuario NUMBER(8) NOT NULL,
    PRIMARY KEY(numero),
    CONSTRAINT pedido_fk_nombre FOREIGN KEY (numero) REFERENCES ps_cesta (codigo),
    CONSTRAINT pedido_fk_codigo_usuario FOREIGN KEY (codigo_usuario) REFERENCES ps_usuario(codigo),
    CONSTRAINT pedido_fk_direccion FOREIGN KEY (numero_direccion, codigo_usuario) REFERENCES ps_direccion (numero, codigo_usuario_direccion)
);

CREATE TABLE ps_articulo (
    codigo NUMBER(8) PRIMARY KEY,
    usuario_crea NUMBER(8) NOT NULL REFERENCES ps_usuario,
    usuario_modifica NUMBER(8) NOT NULL REFERENCES ps_usuario,
    nombre VARCHAR2(40) NOT NULL,
    iva NUMBER(2) NOT NULL, 
    descripcion VARCHAR2(500) NOT NULL,
    precio NUMBER(11,4) NOT NULL,
    path_foto VARCHAR2(500) NOT NULL,
    stock NUMBER(5) NOT NULL,
    fecha_creacion DATE NOT NULL,
    fecha_modificacion DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT check_iva CHECK (iva >= 0 AND precio >= 0 AND stock >= 0)
);

CREATE TABLE ps_cesta_articulo (
    id NUMBER(8),
    articulo NUMBER(8) NOT NULL,
    cantidad NUMBER(5) NOT NULL,
    precio NUMBER(8, 2) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT cesta_articulo_cesta_fk FOREIGN KEY (id) REFERENCES ps_cesta (codigo),
    CONSTRAINT cesta_articulo_fk FOREIGN KEY (articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_categoria (
    nombre VARCHAR2(20) PRIMARY KEY
);

CREATE TABLE ps_articulo_categoria (
    codigo_articulo_categoria NUMBER(8) REFERENCES ps_articulo,
    nombre_categoria VARCHAR2(20) REFERENCES ps_categoria,
    PRIMARY KEY(codigo_articulo_categoria, nombre_categoria)
);

CREATE TABLE ps_refrigeracion (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    tipo VARCHAR2(20) NOT NULL,
    socket VARCHAR2(15) NOT NULL, 
    size_mm NUMBER(3) NOT NULL, 
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_caja (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    size_case VARCHAR2(10) NOT NULL, 
    color VARCHAR2(15) NOT NULL,
    conexion VARCHAR2(40) NOT NULL,
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo,
    CONSTRAINT caja_size CHECK (size_case IN ('mini-ITX', 'M-ATX', 'ATX', 'E-ATX'))
);

CREATE TABLE ps_psu (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    potencia_w NUMBER(3) NOT NULL,
    certificado VARCHAR2(15), 
    modular VARCHAR2(2) NOT NULL,
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo,
    CONSTRAINT modular CHECK (modular IN ('si', 'no'))
);

CREATE TABLE ps_placa_base (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    type_mb VARCHAR2(8) NOT NULL,
    socket VARCHAR2(15) NOT NULL, 
    chipset VARCHAR2(10) NOT NULL,
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo,
    CONSTRAINT placa_size CHECK (type_mb IN ('mini-ITX', 'M-ATX', 'ATX', 'E-ATX'))
);

CREATE TABLE ps_memoria_ram (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    capacidad_mb NUMBER(5) NOT NULL,
    frecuencia_mhz NUMBER(4) NOT NULL,
    tipo VARCHAR2(4) NOT NULL,
    perfil_xmp VARCHAR2(2) NOT NULL,
    CONSTRAINT ram_xmp CHECK (perfil_xmp IN ('si', 'no')),
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_almacenamiento (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    tipo VARCHAR2(5) NOT NULL,
    capacidad_gb NUMBER(5) NOT NULL,
    conexion VARCHAR2(4) NOT NULL,
    CONSTRAINT tipo_almacenamiento CHECK (tipo IN ('NVME', 'HDD', 'SSD', 'M2')),
    CONSTRAINT conexion_almacenamiento CHECK (conexion IN ('SATA', 'PCIE', 'USB')),
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_tarjeta_grafica (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    arquitectura VARCHAR2(15) NOT NULL,
    v_ram_gb NUMBER(2) NOT NULL,
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_procesador (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    socket VARCHAR2(15) NOT NULL, 
    familia VARCHAR2(15) NOT NULL, 
    generacion NUMBER(5) NOT NULL,
    frecuencia_GHZ NUMBER(3, 2) NOT NULL, 
    nucleos NUMBER(2) NOT NULL,
    hilos NUMBER(2) NOT NULL, 
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_portatil (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    pulgadas NUMBER(2) NOT NULL,
    familia_procesador VARCHAR2(15) NOT NULL, 
    peso_gr NUMBER(5, 1) NOT NULL,
    capazidad_ram_gb NUMBER(2) NOT NULL,
    sistema_operativo VARCHAR2(10) NOT NULL, 
    almacenamiento_gb VARCHAR2(4) NOT NULL, 
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

CREATE TABLE ps_sobremesa (
    codigo_articulo NUMBER(8) PRIMARY KEY,
    size_pc VARCHAR2(8) NOT NULL,
    familia_procesador VARCHAR2(15) NOT NULL, 
    type_pc VARCHAR2(6) NOT NULL,
    capazidad_ram_gb NUMBER(3) NOT NULL,
    sistema_operativo VARCHAR2(10) NOT NULL, 
    almacenamiento_gb NUMBER(5) NOT NULL, 
    CONSTRAINT torre_size CHECK (size_pc IN ('mini-ITX', 'M-ATX', 'ATX', 'E-ATX')),
    CONSTRAINT tipo_pc CHECK (type_pc IN ('office', 'gamer', 'pro')),
    FOREIGN KEY (codigo_articulo) REFERENCES ps_articulo
);

-- BORRADO DE TABLAS --

DROP TABLE ps_sobremesa;
DROP TABLE ps_portatil;
DROP TABLE ps_procesador;
DROP TABLE ps_tarjeta_grafica;
DROP TABLE ps_almacenamiento;
DROP TABLE ps_memoria_ram;
DROP TABLE ps_placa_base;
DROP TABLE ps_psu;
DROP TABLE ps_caja;
DROP TABLE ps_refrigeracion;
DROP TABLE ps_articulo_categoria;
DROP TABLE ps_categoria;
DROP TABLE ps_cesta_articulo;
DROP TABLE ps_articulo;
DROP TABLE ps_pedido;
DROP TABLE ps_cesta;
DROP TABLE ps_factura;
DROP TABLE ps_direccion;
DROP TABLE ps_tarjeta;
DROP TABLE ps_usuario;
