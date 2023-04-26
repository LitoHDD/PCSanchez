-- TABLA PS_USUARIO --

INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipoUsuario)
VALUES (5463, 'sergiosanchez.alu@iespacomolla.es', '1234Pass', 'Sergio Sanchez', 'Sin foto', '688410654', to_date('27/01/1998', 'DD/MM/YYYY'), 'ADMIN');

INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipoUsuario)
VALUES (5464, 'longinoojeda.alu@iespacomolla.es', '1234Pass', 'Longino Ojeda', 'Sin foto', '688456765', to_date('15/04/2000', 'DD/MM/YYYY'), 'ADMIN');

INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipoUsuario)
VALUES (5465, 'silviaamoros.informatica@iespacomolla.es', '1234Pass', 'Silvia Amoros', 'Sin foto', '688456234', to_date('15/04/1984', 'DD/MM/YYYY'), 'ADMIN');

INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipoUsuario)
VALUES (5466, 'marcosramon.alu@iespacomolla.es', 'Pass1234', 'Marcos Ramon', 'Sin foto', '688340987', to_date('13/09/2004', 'DD/MM/YYYY'), 'CLIENTE');

INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipoUsuario)
VALUES (5467, 'adrianpareja.alu@iespacomolla.es', 'Pass1234', 'Adrian Pareja', 'Sin foto', '657483947', to_date('23/05/2004', 'DD/MM/YYYY'), 'CLIENTE');

INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipoUsuario)
VALUES (5468, 'carlosfresneda.alu@iespacomolla.es', 'Pass1234', 'Carlos Freneda', 'Sin foto', '657456765', to_date('04/08/2003', 'DD/MM/YYYY'), 'CLIENTE');


--TABLA PS_DIRECCION --

INSERT INTO ps_direccion (numero, tipo, direccion, poblacion, provincia, codigo_usuario_direccion)
VALUES (5, 'Avenida', 'Reina Sofia', 'Petrer', 'Alicante', '5463');

INSERT INTO ps_direccion (numero, tipo, direccion, poblacion, provincia, codigo_usuario_direccion)
VALUES (6, 'Calle', 'Rio Serpis', 'Elda', 'Alicante', '5464');

INSERT INTO ps_direccion (numero, tipo, direccion, poblacion, provincia, codigo_usuario_direccion)
VALUES (14, 'Calle', 'San Valentin', 'Elda', 'Alicante', '5465');

-- TABLA ARTICULO --

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12345, 5463, 5463, 'SSD Kingston 480GB', 21, 'SSD Kingston de alta capacidad y velocidad', 50, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12346, 5463, 5463, 'SSD Crucial 240GB', 21, 'SSD Crucial de alta capacidad y velocidad', 35, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12347, 5463, 5463, 'HDD Seagate 1TB', 21, 'HDD Seagate de alta capacidad y velocidad', 75, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12348, 5463, 5463, 'Mars Gaming Corsario', 21, 'Simple pero elegante', 45, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12349, 5463, 5463, 'Corsair 400D', 21, 'Rebosa Elegancia', 95, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12350, 5463, 5463, 'Temperest Kilian', 21, 'Asegura las temperaturas con esta belleza', 110, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12351, 5463, 5463, 'Corsair Vegeance', 21, 'Bonitas y potentes', 110, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12352, 5463, 5463, 'Kingston Perfomance', 21, 'Simplemente potentecia sin limites', 120, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12353, 5463, 5463, 'Adata', 21, 'Potencia asegurada', 100, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12354, 5463, 5463, 'Asus z170', 21, 'Bonitas y potentes', 80, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12355, 5463, 5463, 'MSI z370', 21, 'Simplemente potentecia sin limites', 120, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12356, 5463, 5463, 'GigaByte z590', 21, 'Potencia asegurada', 250, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12357, 5463, 5463, 'Asus ZeenBook', 21, 'Compacto pero potente', 650, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12358, 5463, 5463, 'MSI Thuntherbolt', 21, 'Bonito y potente', 750, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12359, 5463, 5463, 'GigaByte TrueMaster', 21, 'Potencia asegurada', 850, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12360, 5463, 5463, 'i5-10400', 21, 'Potencia asegurada', 250, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12361, 5463, 5463, 'i5-11400', 21, 'Potencia de nueva generacion', 350, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12362, 5463, 5463, 'i7-11700K', 21, 'Lo mejor de la nueva generacion', 450, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12363, 5463, 5463, 'Corsair 450W', 21, 'Potencia asegurada', 50, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12364, 5463, 5463, 'Corsair 650W', 21, 'Potencia de nueva generacion', 70, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12365, 5463, 5463, 'COrsair 850W', 21, 'Lo mejor de la nueva generacion', 110, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12366, 5463, 5463, 'Corsair 120mm', 21, 'Una refrigeracion simple', 50, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12367, 5463, 5463, 'Mars Gaming 240mm', 21, '¿Quieres dominar la gama media?', 70, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12368, 5463, 5463, 'Corsair 360mm', 21, 'Lo mejor en refrigeración', 110, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12369, 5463, 5463, 'GAME 501', 21, 'Podras jugar a lo basico', 500, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12370, 5463, 5463, 'GAME 502', 21, '¿Quieres dominar la gama media?', 700, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12371, 5463, 5463, 'GAME 507', 21, 'Lo mejor del mercado', 110, 'Sin foto', 1500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12372, 5463, 5463, 'RTX 3060', 21, 'Podras jugar a lo basico', 500, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12373, 5463, 5463, 'RTX 3070', 21, '¿Quieres dominar la gama media?', 700, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12374, 5463, 5463, 'RTX 3080', 21, 'Lo mejor del mercado', 110, 'Sin foto', 1500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

-- TABLA PS_ALMACENAMIENTO --

INSERT INTO ps_almacenamiento (codigo_articulo, tipo, capacidad_gb, conexion)
VALUES (12345, 'SSD', 480, 'SATA');

INSERT INTO ps_almacenamiento (codigo_articulo, tipo, capacidad_gb, conexion)
VALUES (12346, 'SSD', 240, 'SATA');

INSERT INTO ps_almacenamiento (codigo_articulo, tipo, capacidad_gb, conexion)
VALUES (12347, 'HDD', 1000, 'SATA');

-- TABLA CAJA --

INSERT INTO ps_caja (codigo_articulo, size_case, color, conexion)
VALUES (12348, 'ATX', 'Negra', '2 USB Frontales');

INSERT INTO ps_caja (codigo_articulo, size_case, color, conexion)
VALUES (12349, 'ATX', 'Negra', '5 USB Frontales');

INSERT INTO ps_caja (codigo_articulo, size_case, color, conexion)
VALUES (12350, 'ATX', 'Negra', '8 USB Frontales');

-- TABLA MEMORIA RAM --

INSERT INTO ps_memoria_ram (codigo_articulo, capacidad_mb, frecuencia_mhz, tipo, perfil_xmp)
VALUES (12351, 16000, 3200, 'Mid', 'si');

INSERT INTO ps_memoria_ram (codigo_articulo, capacidad_mb, frecuencia_mhz, tipo, perfil_xmp)
VALUES (12352, 16000, 3200, 'Mid', 'si');

INSERT INTO ps_memoria_ram (codigo_articulo, capacidad_mb, frecuencia_mhz, tipo, perfil_xmp)
VALUES (12353, 16000, 3200, 'Mid', 'si');

-- TABLA PLACA_BASE --

INSERT INTO ps_placa_base (codigo_articulo, type_mb, socket, chipset)
VALUES (12354, 'ATX', 'LGA1200', 'z170');

INSERT INTO ps_placa_base (codigo_articulo, type_mb, socket, chipset)
VALUES (12355, 'ATX', 'LGA1200', 'z370');

INSERT INTO ps_placa_base (codigo_articulo, type_mb, socket, chipset)
VALUES (12356, 'ATX', 'LGA1200', 'z590');

-- TABLA PORTATIL --

INSERT INTO ps_portatil (codigo_articulo, pulgadas, familia_procesador, peso_gr, capazidad_ram_gb, sistema_operativo, almacenamiento_gb)
VALUES (12357, 15, 'Comet Lake', 1250, 16, 'Windows 10', 500);

INSERT INTO ps_portatil (codigo_articulo, pulgadas, familia_procesador, peso_gr, capazidad_ram_gb, sistema_operativo, almacenamiento_gb)
VALUES (12358, 16, 'Rocket Lake', 1150, 16, 'Windows 10', 500);

INSERT INTO ps_portatil (codigo_articulo, pulgadas, familia_procesador, peso_gr, capazidad_ram_gb, sistema_operativo, almacenamiento_gb)
VALUES (12359, 17, 'Alder Lake', 1000, 32, 'Windows 10', 1000);

-- TABLA PROCESADOR --

INSERT INTO ps_procesador (codigo_articulo, socket, familia, generacion, frecuencia_ghz, nucleos, hilos)
VALUES (12360, 'LGA1151', 'Comet Lake', 10, 3.2, 6, 12);

INSERT INTO ps_procesador (codigo_articulo, socket, familia, generacion, frecuencia_ghz, nucleos, hilos)
VALUES (12361, 'LGA1200', 'Rocket Lake', 11, 3.6, 6, 12);

INSERT INTO ps_procesador (codigo_articulo, socket, familia, generacion, frecuencia_ghz, nucleos, hilos)
VALUES (12362, 'LGA1200', 'Rocket Lake', 11, 3.6, 8, 16);

-- TABLA PSU --

INSERT INTO ps_psu (codigo_articulo, potencia_w, certificado, modular)
VALUES (12363, 450, '80 Plus Bronze', 'si');

INSERT INTO ps_psu (codigo_articulo, potencia_w, certificado, modular)
VALUES (12364, 650, '80 Plus Silver', 'si');

INSERT INTO ps_psu (codigo_articulo, potencia_w, certificado, modular)
VALUES (12365, 850, '80 Plus Gold', 'si');

-- TABLA REFRIGERACION --

INSERT INTO ps_refrigeracion (codigo_articulo, tipo, socket, size_mm)
VALUES (12366, 'Liquida', 'LGA1151', 120);

INSERT INTO ps_refrigeracion (codigo_articulo, tipo, socket, size_mm)
VALUES (12367, 'Liquida', 'LGA1151', 240);

INSERT INTO ps_refrigeracion (codigo_articulo, tipo, socket, size_mm)
VALUES (12368, 'Liquida', 'LGA1151', 360);

-- TABLA SOBREMESA --

INSERT INTO ps_sobremesa (codigo_articulo, size_pc, familia_procesador, type_pc, capazidad_ram_gb, sistema_operativo, almacenamiento_gb)
VALUES (12369, 'ATX', 'Comet Lake', 'gamer', 8, 'Windows 10', 500);

INSERT INTO ps_sobremesa (codigo_articulo, size_pc, familia_procesador, type_pc, capazidad_ram_gb, sistema_operativo, almacenamiento_gb)
VALUES (12370, 'ATX', 'Comet Lake', 'gamer', 16, 'Windows 10', 500);

INSERT INTO ps_sobremesa (codigo_articulo, size_pc, familia_procesador, type_pc, capazidad_ram_gb, sistema_operativo, almacenamiento_gb)
VALUES (12371, 'ATX', 'Rocket Lake', 'gamer', 32, 'Windows 10', 1000);

-- TABLA CATEGORIA --

INSERT INTO ps_categoria (nombre)
VALUES ('Almacenamiento');

INSERT INTO ps_categoria (nombre)
VALUES ('Procesadores');

INSERT INTO ps_categoria (nombre)
VALUES ('Tarjetas Gráficas');

-- TABLA ARTICULO CATEGORIA --

INSERT INTO ps_articulo_categoria (codigo_articulo_categoria, nombre_categoria)
VALUES (12345, 'Almacenamiento');

INSERT INTO ps_articulo_categoria (codigo_articulo_categoria, nombre_categoria)
VALUES (12346, 'Almacenamiento');

INSERT INTO ps_articulo_categoria (codigo_articulo_categoria, nombre_categoria)
VALUES (12347, 'Almacenamiento');

-- TABLA CESTA --

INSERT INTO ps_cesta(nombre, numero_usuario, precio, cantidad, tipo)
VALUES ('Navidades', 5463, 50, 1, 'PRVT');

INSERT INTO ps_cesta(nombre, numero_usuario, precio, cantidad, tipo)
VALUES ('Regalos Reyes', 5464, 50, 1, 'PRVT');

INSERT INTO ps_cesta(nombre, numero_usuario, precio, cantidad, tipo)
VALUES ('San Valentin', 5465, 50, 1, 'PRVT');

-- TABLA CESTA_ARTICULO --

INSERT INTO ps_cesta_articulo(articulo, numero_usuario, cesta, cantidad, precio)
VALUES (12345, 5463, 'Navidades', 1, 50);

INSERT INTO ps_cesta_articulo(articulo, numero_usuario, cesta, cantidad, precio)
VALUES (12345, 5464, 'Regalos Reyes', 1, 50);

INSERT INTO ps_cesta_articulo(articulo, numero_usuario, cesta, cantidad, precio)
VALUES (12345, 5465, 'San Valentin', 1, 50);

-- TABLA PEDIDO --

INSERT INTO ps_pedido(numero, facturado, fecha_pedido, numero_direccion, nombre_cesta, codigo_usuario)
VALUES (12345678, 'S', to_date('15/02/2023', 'DD/MM/YYYY'), 5, 'Navidades', 5463);

INSERT INTO ps_pedido(numero, facturado, fecha_pedido, numero_direccion, nombre_cesta, codigo_usuario)
VALUES (12345679, 'S', to_date('15/02/2023', 'DD/MM/YYYY'), 6, 'Regalos Reyes', 5464);

INSERT INTO ps_pedido(numero, facturado, fecha_pedido, numero_direccion, nombre_cesta, codigo_usuario)
VALUES (12345680, 'S', to_date('15/02/2023', 'DD/MM/YYYY'), 14, 'San Valentin', 5465);

-- TABLA FACTURA --

INSERT INTO ps_factura(cod_factura, fecha, numero_pedido, cod_usuario, cod_usuario_direccion, numero_direccion)
VALUES (12345678, to_date('15/02/2023', 'DD/MM/YYYY'), 12345678, 5463, 5463, 5);

INSERT INTO ps_factura(cod_factura, fecha, numero_pedido, cod_usuario, cod_usuario_direccion, numero_direccion)
VALUES (12345679, to_date('15/02/2023', 'DD/MM/YYYY'), 12345679, 5464, 5464, 6);

INSERT INTO ps_factura(cod_factura, fecha, numero_pedido, cod_usuario, cod_usuario_direccion, numero_direccion)
VALUES (12345680, to_date('15/02/2023', 'DD/MM/YYYY'), 12345680, 5465, 5465, 14);

-- TABLA TARJETA -- 

INSERT INTO ps_tarjeta(cod_pago, num_tarjeta, cod_usuario)
VALUES (1151, 32165498745632152, 5463);

INSERT INTO ps_tarjeta(cod_pago, num_tarjeta, cod_usuario)
VALUES (1152, 32165498745632152, 5464);

INSERT INTO ps_tarjeta(cod_pago, num_tarjeta, cod_usuario)
VALUES (1153, 32165498745632152, 5465);

-- TABLA TARJETA_GRAFICA --

INSERT INTO ps_tarjeta_grafica (codigo_articulo, arquitectura, v_ram_gb)
VALUES (12372, 'Ampere', 12);

INSERT INTO ps_tarjeta_grafica (codigo_articulo, arquitectura, v_ram_gb)
VALUES (12373, 'Ampere', 10);

INSERT INTO ps_tarjeta_grafica (codigo_articulo, arquitectura, v_ram_gb)
VALUES (12374, 'Ampere', 10);

-- ACTUALIZACIONES --

UPDATE ps_articulo SET nombre='GAME 400' WHERE codigo=12369;

UPDATE ps_articulo SET nombre='Adata Series 400' WHERE codigo=12353;

UPDATE ps_articulo SET nombre='Mars Gaming Solar' WHERE codigo=12348;

-- BORRADOS --

DELETE FROM ps_refrigeracion WHERE codigo_articulo = 12367;

DELETE FROM ps_refrigeracion WHERE codigo_articulo = 12366 and tipo = 'Liquida';