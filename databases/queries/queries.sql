/* 3 Consultas de la sintaxis select básica */

-- Selecciona todos los usuarios que sean de tipo "CLIENTE" --

SELECT * FROM ps_usuario WHERE tipoUsuario = 'CLIENTE';

-- Selecciona el nombre, precio y stock de todos los artículos cuyo precio sea mayor que 50 euros --

SELECT nombre, precio, stock FROM ps_articulo WHERE precio > 50;

-- Selecciona el nombre y tipo de las cestas que sean de tipo "PRVT" y que pertenezcan al usuario con código 5463 --

SELECT nombre, tipo FROM ps_cesta WHERE tipo = 'PRVT' AND numero_usuario = 5463;

/* 3 Consultas usando funciones SQL */

-- Muestra la cantidad de usuarios registrados por tipo de usuario --

SELECT tipoUsuario, COUNT(*) as cantidad
FROM ps_usuario
GROUP BY tipoUsuario;

-- Muestra la cantidad total de cestas de tipo "PRVT" creadas por cada usuario --

SELECT numero_usuario, COUNT(*) as num_cestas
FROM ps_cesta
WHERE tipo = 'PRVT'
GROUP BY numero_usuario;

-- Esta consulta devuelve la fecha de creación del artículo más antiguo en la base de datos --

SELECT *
FROM ps_articulo
WHERE fecha_creacion = (
  SELECT MIN(fecha_creacion)
  FROM ps_articulo
);

/* 3 Consultas usando Agrupaciones, combinaciones u operaciones de conjuntos */

-- Obtiene el número de pedidos facturados y no facturados para cada usuario --

SELECT ps_usuario.nombre_comp, ps_pedido.facturado, COUNT(*) as num_pedidos
FROM ps_pedido
JOIN ps_usuario ON ps_pedido.codigo_usuario = ps_usuario.codigo
GROUP BY ps_usuario.nombre_comp, ps_pedido.facturado;

-- Obtiene los usuarios que han realizado pedidos y que tienen tarjetas de pago registradas --

SELECT u.nombre_comp
FROM ps_usuario u
INNER JOIN ps_tarjeta t ON u.codigo = t.cod_usuario
INNER JOIN ps_pedido p ON u.codigo = p.codigo_usuario;

-- Obtiene el número de artículos en cada categoría y la cantidad total de artículos que tienen un precio mayor a 50 euros, utilizando una agrupación y una combinación --

SELECT c.nombre, COUNT(ac.codigo_articulo_categoria) AS num_articulos, SUM(CASE WHEN a.precio > 50 THEN 1 ELSE 0 END) AS num_articulos_precio_alto
FROM ps_categoria c
LEFT JOIN ps_articulo_categoria ac ON c.nombre = ac.nombre_categoria
LEFT JOIN ps_articulo a ON ac.codigo_articulo_categoria = a.codigo
GROUP BY c.nombre;

/* 1 vista, un insert y un borrado o actualización desde select, en total, serán tres sentencias. */

-- Crear y mostrar una vista que muestre el código, nombre y precio de todos los artículos de la tabla ps_articulo --

CREATE VIEW vista_articulos AS
SELECT codigo, nombre, precio
FROM ps_articulo;
SELECT * FROM vista_articulos;

-- Inserta un nuevo usuario en la tabla ps_usuario --

INSERT INTO ps_usuario(codigo, email, pass, nombre_comp, tipoUsuario)
VALUES (5469, 'joseramonmas.informatica@iespacomolla.es', 'JoseRamon7654', 'José Ramon Mas Davó', 'ADMIN');

-- Actualiza el stock de todos los artículos que tienen menos o igual de 500 unidades en la tabla ps_articulo --

UPDATE ps_articulo
SET stock = stock + 50
WHERE codigo IN (
    SELECT codigo
    FROM ps_articulo
    WHERE stock <= 500
);