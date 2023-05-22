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
VALUES (12345, 5463, 5463, 'SSD Kingston 480GB', 21, 'La unidad A400 de estado sólido de Kingston ofrece enormes mejoras en la velocidad de respuesta, sin actualizaciones adicionales del hardware. Brinda lapsos de arranque, carga y de transferencia de archivos increíblemente más breves en comparación con las unidades de disco duro mecánico.

Apoyada en su controlador de la más reciente generación, que ofrece velocidades de lectura y escritura de hasta 500 MB/s y 450 MB/s, respectivamente, esta unidad SSD es 10 veces más rápida que los discos duros tradicionales y provee un mejor rendimiento, velocidad de respuesta ultrarrápida en el procesamiento multitareas y una aceleración general del sistema. Además son más fiables y duraderas que las unidades de disco duro, y están disponibles en varias capacidades que van de 120 GB hasta 480 GB.', 25, 'https://i.imgur.com/S7ICFQP.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12346, 5463, 5463, 'SSD Crucial 240GB', 21, '¿Alguna vez se ha preguntado por qué su teléfono responde más rápidamente que su computadora? Es porque su teléfono funciona con una memoria flash. Agregue flash a su computadora portátil o de escritorio con la unidad de estado sólido Crucial® BX500, la manera más sencilla de obtener toda la velocidad de una computadora nueva sin el precio. Acelere todo.', 30, 'https://i.imgur.com/DGX9iwt.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12347, 5463, 5463, 'HDD Seagate 1TB', 21, 'Vea más. Almacene más. Optimizadas para sistemas de DVR y NVR, las unidades de vigilancia SkyHawk™ han sido perfeccionadas para cargas de trabajo ininterrumpidas en capacidades de hasta 10 TB. Equipada con firmware ImagePerfect™, SkyHawk ayuda a minimizar los fotogramas perdidos y el tiempo de reposo gracias a un índice de carga de trabajo tres veces mayor al de las unidades de sobremesa y, además, admite hasta 64 cámaras de alta definición.', 75, 'https://i.imgur.com/2vzLk92.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12348, 5463, 5463, 'Mars Gaming Corsario', 21, 'Una espectacular semitorre de diseño gaming con iluminación LED RGB dinámica de múltiples efectos, equipada con una ventana lateral total de cristal templado y ventilador trasero de 120mm con iluminación RGB de anillo dual. La MCX dispone de un moderno frontal de diseño futurista y una estructura ATX optimizada disponible en dos colores, blanco y negro.', 45, 'https://i.imgur.com/s7ZiiZ0.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12349, 5463, 5463, 'Corsair 4000D', 21, 'El Corsair 4000D es una carcasa para computadora con un diseño moderno y minimalista. Ofrece un amplio espacio interior para componentes de alto rendimiento y tiene un sistema de enfriamiento eficiente con ventiladores preinstalados. Facilita la instalación y el acceso a los componentes, y cuenta con filtros de polvo desmontables. Es una opción ideal para construir una computadora potente y bien refrigerada.', 95, 'https://i.imgur.com/miI3foD.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12350, 5463, 5463, 'Temperest Kilian', 21, 'Descubre la elegante y funcional caja de PC Temperest Kilian. Con su diseño contemporáneo y líneas limpias, esta caja ofrece un equilibrio perfecto entre estilo y rendimiento. Cuenta con amplio espacio interior para componentes de alta gama y ofrece una excelente capacidad de gestión de cables. Además, su sistema de refrigeración avanzado y paneles de vidrio templado te permitirán mostrar tus componentes con orgullo. La Temperest Kilian es la elección ideal para aquellos que buscan una caja de PC que combine estética y funcionalidad de forma excepcional.', 110, 'https://i.imgur.com/KMakuyA.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12351, 5463, 5463, 'Corsair Vegeance 16Gb', 21, 'Experimenta un rendimiento potente y un estilo vibrante con las Corsair Vengeance RGB. Estos módulos de memoria RAM están diseñados para ofrecer un rendimiento excepcional y están equipados con luces RGB personalizables para añadir un toque de estilo a tu sistema. Con capacidades y velocidades impresionantes, las Corsair Vengeance RGB te permiten disfrutar de una experiencia de juego y multitarea fluida y sin problemas, mientras iluminas tu configuración con efectos de iluminación dinámicos. Aprovecha la combinación perfecta de rendimiento y estética con Corsair Vengeance RGB.', 110, 'https://i.imgur.com/ipJLze6.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12352, 5463, 5463, 'Kingston Fury 16Gb', 21, 'Potencia tu sistema con Kingston Fury. Estos módulos de memoria RAM ofrecen un rendimiento excepcional y confiable para tus necesidades informáticas. Con velocidades rápidas y capacidades generosas, Kingston Fury está diseñado para mejorar el rendimiento de tu sistema, permitiéndote ejecutar aplicaciones exigentes y juegos intensivos sin problemas. Además, su diseño elegante y minimalista complementa cualquier configuración de PC. Aprovecha la velocidad y el rendimiento superiores de Kingston Fury para llevar tu experiencia informática al siguiente nivel.', 120, 'https://i.imgur.com/XkgCTDR.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12353, 5463, 5463, 'Adata 16Gb DDR4', 21, 'Disfruta de un rendimiento confiable con ADATA 2666MHz 16GB. Estos módulos de memoria RAM ofrecen una velocidad de 2666MHz, lo que garantiza una respuesta rápida y fluida para tus aplicaciones y juegos favoritos. Con una capacidad de 16GB, tienes espacio suficiente para manejar múltiples tareas y cargas de trabajo intensivas. Los módulos ADATA 2666MHz 16GB están diseñados para ser compatibles con una amplia gama de sistemas y ofrecen un excelente equilibrio entre rendimiento y precio. Mejora la velocidad y la eficiencia de tu sistema con ADATA 2666MHz 16GB.', 100, 'https://i.imgur.com/voEweeY.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12354, 5463, 5463, 'Asus z170', 21, 'La placa base Asus Z170 es una opción confiable y de alto rendimiento para construir tu sistema. Diseñada para soportar procesadores Intel de 6ª generación, esta placa base ofrece una gran capacidad de expansión y características avanzadas. Con soporte para memoria DDR4, tecnología USB 3.1 y ranuras PCIe 3.0, la Asus Z170 te brinda una conexión rápida y eficiente para tus periféricos y componentes. Además, cuenta con una construcción sólida y un diseño intuitivo que facilita la instalación y el manejo de cables. La Asus Z170 es una excelente elección para aquellos que buscan una placa base confiable y potente para sus necesidades informáticas.', 80, 'https://i.imgur.com/n0RXgSU.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12355, 5463, 5463, 'MSI z370', 21, 'La placa base MSI Z370 es una opción de alta calidad para construir un sistema potente. Diseñada para soportar procesadores Intel de 8ª y 9ª generación, esta placa base ofrece un excelente rendimiento y capacidades de overclocking. Con ranuras PCIe 3.0, tecnología USB 3.1 y soporte para memoria DDR4, la MSI Z370 te brinda una conectividad rápida y eficiente para tus periféricos y componentes. Además, cuenta con características de refrigeración avanzadas para mantener tu sistema en óptimas condiciones incluso en cargas de trabajo intensivas. Con su diseño robusto y componentes de alta calidad, la MSI Z370 es una elección confiable para aquellos que buscan maximizar el rendimiento de su PC.', 120, 'https://i.imgur.com/9vVqaj5.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12356, 5463, 5463, 'GigaByte z590', 21, 'La placa base Gigabyte Z590 es una opción de alta gama para construir un sistema de última generación. Diseñada para soportar procesadores Intel de 10ª y 11ª generación, esta placa base ofrece un rendimiento excepcional y características avanzadas. Con ranuras PCIe 4.0, tecnología USB 3.2 Gen 2x2 y soporte para memoria DDR4 de alta velocidad, la Gigabyte Z590 te proporciona una conectividad ultrarrápida y una capacidad de expansión versátil. Además, cuenta con un sistema de enfriamiento eficiente para mantener la temperatura de tus componentes bajo control incluso durante sesiones de juego intensivas. Con su diseño elegante y duradero, la Gigabyte Z590 es la elección ideal para aquellos que buscan construir un sistema de alto rendimiento y vanguardia.', 250, 'https://i.imgur.com/xiSdFNA.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12357, 5463, 5463, 'Asus ZeenBook', 21, 'El Asus ZeenBook es un portátil elegante y potente, diseñado para combinar rendimiento y estilo. Con su diseño delgado y pantalla de alta resolución, ofrece una experiencia visual inmersiva. Con un rendimiento rápido y una duración prolongada de la batería, es ideal para el trabajo diario y el entretenimiento. Además, su teclado retroiluminado y portabilidad lo hacen perfecto para usar en cualquier lugar.', 650, 'https://i.imgur.com/fhOht2a.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12358, 5463, 5463, 'MSI Stealth 15m', 21, 'El MSI Stealth 15M es un portátil de alta gama y delgado que ofrece un rendimiento potente en un diseño elegante. Con su procesador Intel de última generación y tarjeta gráfica dedicada, el Stealth 15M es capaz de manejar tareas exigentes y juegos intensivos con facilidad. Además, cuenta con una pantalla de alta calidad y una amplia gama de colores para una experiencia visual inmersiva. Su diseño ligero y portátil lo convierte en una opción ideal para aquellos que necesitan potencia y movilidad en un solo dispositivo.', 750, 'https://i.imgur.com/rzU0jyM.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12359, 5463, 5463, 'GigaByte TrueMaster', 21, 'Los portátiles Gigabyte ofrecen una combinación de rendimiento, durabilidad y versatilidad en un formato portátil. Con una amplia gama de modelos para adaptarse a diversas necesidades, los portátiles Gigabyte son conocidos por su potencia de procesamiento, gráficos impresionantes y diseños elegantes. Ya sea que necesites un portátil para juegos, trabajo o entretenimiento, Gigabyte ofrece opciones confiables y de alto rendimiento que satisfacen las demandas de los usuarios más exigentes. Con características como pantallas de alta resolución, teclados ergonómicos y una excelente duración de la batería, los portátiles Gigabyte están diseñados para brindar una experiencia informática excepcional en movimiento.', 850, 'https://i.imgur.com/wxLup98.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12360, 5463, 5463, 'i5-10400', 21, 'El procesador Intel Core i5-10400 es un potente procesador de la 10ª generación de Intel. Con 6 núcleos y 12 hilos de procesamiento, ofrece un rendimiento sólido y eficiente para una amplia variedad de tareas informáticas. Con una velocidad de reloj base de 2.9GHz y una velocidad máxima de hasta 4.3GHz con la tecnología Intel Turbo Boost, el i5-10400 ofrece un rendimiento rápido y capacidad de respuesta para tareas diarias, multitarea, edición de contenido y juegos. Además, cuenta con tecnologías avanzadas de Intel, como Intel Quick Sync Video, que aceleran la codificación y decodificación de video, y compatibilidad con memoria DDR4 para un rendimiento optimizado. En general, el i5-10400 es una excelente opción para aquellos que buscan un equilibrio entre rendimiento, eficiencia y precio en su sistema informático.', 250, 'https://i.imgur.com/xvO5Jui.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12361, 5463, 5463, 'i5-11400', 21, 'El procesador Intel Core i5-11400 es parte de la 11ª generación de procesadores Intel Core. Con 6 núcleos y 12 hilos de procesamiento, ofrece un rendimiento sólido y eficiente para una amplia gama de aplicaciones. Con una velocidad de reloj base de 2.6GHz y una velocidad máxima de hasta 4.4GHz con la tecnología Intel Turbo Boost, el i5-11400 brinda un rendimiento rápido y capacidad de respuesta para tareas diarias, multitarea, juegos y más. Además, cuenta con características mejoradas de la 11ª generación, como tecnología de proceso de 10 nm y compatibilidad con memoria DDR4 para un rendimiento optimizado. Con un equilibrio entre rendimiento y eficiencia energética, el i5-11400 es una excelente opción para aquellos que buscan un procesador confiable y potente para su sistema informático.', 350, 'https://i.imgur.com/lh47RZM.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12362, 5463, 5463, 'i7-11700K', 21, 'El procesador Intel Core i7-11700K es una potente opción de la 11ª generación de procesadores Intel Core. Con 8 núcleos y 16 hilos de procesamiento, ofrece un rendimiento excepcional para tareas intensivas y exigentes. Con una velocidad de reloj base de 3.6GHz y una velocidad máxima de hasta 5.0GHz con la tecnología Intel Turbo Boost, el i7-11700K brinda una respuesta rápida y un rendimiento fluido para aplicaciones exigentes, edición de contenido, juegos y más. Además, cuenta con características avanzadas, como tecnología de proceso de 10 nm, compatibilidad con memoria DDR4 y optimizaciones para overclocking, lo que permite a los entusiastas del rendimiento exprimir aún más su potencial. En resumen, el i7-11700K es una opción poderosa y versátil para aquellos que buscan el máximo rendimiento en su sistema informático.', 450, 'https://i.imgur.com/POz8b68.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12363, 5463, 5463, 'Corsair 450W', 21, 'La fuente de alimentación Corsair de 450W es una opción confiable y eficiente para satisfacer las necesidades de energía de tu sistema. Con una potencia de 450W, es capaz de proporcionar la energía necesaria para alimentar componentes como la placa base, tarjeta gráfica, discos duros y otros periféricos. Cuenta con una alta eficiencia energética, lo que significa que convierte la energía de la red eléctrica en energía utilizable de manera eficiente, reduciendo el desperdicio y el calentamiento innecesario. Además, las fuentes de alimentación Corsair suelen ofrecer una buena calidad de construcción y características de protección para mantener tu sistema seguro. En resumen, la fuente de alimentación Corsair de 450W es una opción confiable y eficiente para garantizar un suministro de energía estable y seguro para tu sistema.', 50, 'https://i.imgur.com/ltcLFVA.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12364, 5463, 5463, 'Corsair 650W', 21, 'La fuente de alimentación Corsair de 650W es una opción potente y confiable para alimentar tu sistema. Con una capacidad de 650W, ofrece una abundante energía para alimentar componentes exigentes, como procesadores de alto rendimiento y tarjetas gráficas potentes. Esta fuente de alimentación está diseñada con eficiencia energética para minimizar el desperdicio de energía y reducir el calor generado, lo que contribuye a un funcionamiento más eficiente y una mayor vida útil de los componentes. Además, las fuentes de alimentación Corsair suelen contar con cables modulares para una mejor administración del cableado y características de protección para mantener tu sistema a salvo de sobrecargas y cortocircuitos. En resumen, la fuente de alimentación Corsair de 650W es una opción confiable y robusta que proporciona suficiente potencia para sistemas de alto rendimiento.', 70, 'https://i.imgur.com/7dPh84X.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12365, 5463, 5463, 'Corsair 850W', 21, 'La fuente de alimentación Corsair de 850W es una opción de alta potencia y confiabilidad para alimentar sistemas exigentes. Con una capacidad de 850W, ofrece una gran cantidad de energía para alimentar componentes de alto rendimiento, como procesadores de gama alta y tarjetas gráficas de última generación. Esta fuente de alimentación está diseñada con una alta eficiencia energética para minimizar el consumo de energía y reducir la generación de calor, lo que ayuda a mantener la estabilidad del sistema y prolongar la vida útil de los componentes. Además, las fuentes de alimentación Corsair de 850W suelen contar con cables totalmente modulares para una fácil administración del cableado y cuentan con características de protección avanzadas para proteger tu sistema contra sobrecargas y cortocircuitos. En resumen, la fuente de alimentación Corsair de 850W es una opción potente y confiable para sistemas de alto rendimiento que requieren una alimentación estable y eficiente.', 110, 'https://i.imgur.com/5k08RnW.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12366, 5463, 5463, 'Corsair 120mm', 21, 'El Corsair 120mm es un sistema de refrigeración líquida compacto y eficiente para tu sistema de PC. Diseñado para adaptarse a un ventilador de 120mm, este sistema de refrigeración líquida utiliza una combinación de radiador, bomba y bloque de agua para disipar el calor de manera efectiva y mantener tus componentes frescos incluso en condiciones de alta carga. El tamaño compacto del sistema lo hace ideal para sistemas con espacio limitado, mientras que su rendimiento silencioso garantiza un funcionamiento tranquilo. Con una instalación sencilla y una compatibilidad versátil, el Corsair 120mm es una opción popular para aquellos que buscan una solución de refrigeración líquida eficiente y confiable para su sistema.', 50, 'https://i.imgur.com/7xVT0dL.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12367, 5463, 5463, 'Mars Gaming 240mm', 21, 'El Mars Gaming 240mm es un sistema de refrigeración líquida de alta gama diseñado para brindar un rendimiento excepcional en la refrigeración de tu PC. Con un radiador de 240mm y dos ventiladores de 120mm, este sistema de refrigeración líquida proporciona una disipación de calor eficiente y silenciosa. Diseñado para adaptarse a la mayoría de los sockets de CPU populares, su instalación es sencilla y cuenta con un diseño de tubos flexibles para una fácil manipulación. Además, el Mars Gaming 240mm ofrece un sistema de iluminación RGB personalizable para agregar un toque visual impresionante a tu sistema. Con su capacidad de enfriamiento superior y características atractivas, el Mars Gaming 240mm es una opción popular entre los entusiastas de los juegos y overclocking que buscan mantener sus sistemas frescos y estéticamente atractivos.', 70, 'https://i.imgur.com/d72bPyP.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12368, 5463, 5463, 'Corsair 360mm', 21, 'El Corsair 360mm es un sistema de refrigeración líquida de alto rendimiento diseñado para mantener tu CPU fresca incluso en condiciones de alta carga. Con un radiador de 360mm y tres ventiladores de 120mm, este sistema de refrigeración líquida proporciona una excelente capacidad de disipación de calor y un rendimiento de enfriamiento eficiente. Con su diseño de alta calidad y duradero, el Corsair 360mm garantiza una larga vida útil y un funcionamiento confiable. Además, su instalación es sencilla y cuenta con características avanzadas, como iluminación RGB personalizable y software de control intuitivo para ajustar la velocidad del ventilador y los perfiles de enfriamiento. Si buscas una solución de refrigeración líquida potente y eficiente para tu sistema, el Corsair 360mm es una excelente opción.', 110, 'https://i.imgur.com/Vk1zm5n.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12369, 5463, 5463, 'AlurinPC + Windows 10', 21, 'Excelente relación calidad/precio para este PC con componentes de primeras marcas, la máxima garantía y gran rendimiento, ideal para usuarios que buscan hacer "de todo un poco".', 500, 'Sin foto', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12370, 5463, 5463, 'Lenovo IdeaCentre + Windows 10', 21, 'El Lenovo IdeaCentre es un PC de sobremesa confiable y de alto rendimiento diseñado para satisfacer diversas necesidades informáticas. Con un diseño elegante y compacto, se integra fácilmente en cualquier entorno de trabajo o hogar. El IdeaCentre ofrece potentes procesadores, opciones de memoria ampliables y almacenamiento generoso para manejar tareas diarias, aplicaciones exigentes y juegos. Además, cuenta con una variedad de puertos y conectividad para facilitar la conexión de periféricos y dispositivos externos. Con una combinación de rendimiento confiable y funcionalidad versátil, el Lenovo IdeaCentre es una excelente opción para aquellos que buscan un PC de sobremesa potente y eficiente.', 700, 'https://i.imgur.com/xeoZnlq.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12371, 5463, 5463, 'Acer Nitro 50', 21, 'El Acer Nitro 50 es un PC de sobremesa diseñado para ofrecer un rendimiento gaming potente y fluido. Equipado con potentes componentes, como procesadores de última generación y tarjetas gráficas dedicadas, el Nitro 50 ofrece una experiencia de juego inmersiva y sin interrupciones. Con opciones de memoria y almacenamiento ampliables, así como una variedad de puertos y conectividad, este PC permite personalizarlo según tus necesidades. Además, su diseño moderno y elegante se adapta fácilmente a cualquier configuración de escritorio. El Acer Nitro 50 es una opción popular para los jugadores que buscan un rendimiento confiable y una experiencia de juego envolvente.', 110, 'https://i.imgur.com/qED7VO5.png', 1500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12372, 5463, 5463, 'RTX 3060', 21, 'La RTX 3060 es una tarjeta gráfica de gama media-alta de la serie RTX 3000 de NVIDIA. Equipada con la arquitectura Ampere y tecnología de trazado de rayos en tiempo real, la RTX 3060 ofrece un rendimiento impresionante en juegos y aplicaciones que requieren una representación gráfica avanzada. Con 12 GB de memoria GDDR6, brinda una excelente capacidad de manejo de texturas y una experiencia de juego fluida incluso en resoluciones altas. Además, la RTX 3060 cuenta con funciones adicionales, como DLSS (Deep Learning Super Sampling) y NVIDIA Reflex, que mejoran la calidad visual y la capacidad de respuesta en juegos. En resumen, la RTX 3060 es una tarjeta gráfica potente y versátil que brinda un rendimiento excepcional para jugadores y creadores de contenido.', 500, 'https://i.imgur.com/7pRP156.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12373, 5463, 5463, 'RTX 3070', 21, 'La RTX 3070 es una tarjeta gráfica de alta gama de la serie RTX 3000 de NVIDIA. Basada en la arquitectura Ampere y equipada con tecnología de trazado de rayos en tiempo real, la RTX 3070 ofrece un rendimiento extraordinario en juegos y aplicaciones que requieren una representación gráfica avanzada. Con 8 GB o 16 GB de memoria GDDR6, proporciona una capacidad impresionante para manejar texturas y renderizar imágenes detalladas en resoluciones altas. La RTX 3070 también cuenta con tecnologías adicionales, como DLSS (Deep Learning Super Sampling) y NVIDIA Reflex, que mejoran la calidad visual y la capacidad de respuesta en los juegos. En resumen, la RTX 3070 es una tarjeta gráfica de alto rendimiento que ofrece una experiencia de juego suave y envolvente, y es una excelente opción para jugadores y creadores de contenido exigentes.', 700, 'https://i.imgur.com/iEvHAZe.png', 500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

INSERT INTO ps_articulo (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion)
VALUES (12374, 5463, 5463, 'RTX 3080', 21, 'La RTX 3080 es una tarjeta gráfica de gama alta de la serie RTX 3000 de NVIDIA. Con la arquitectura Ampere y tecnología de trazado de rayos en tiempo real, la RTX 3080 ofrece un rendimiento excepcional en juegos y aplicaciones de alta demanda gráfica. Con 10 GB o 20 GB de memoria GDDR6X, ofrece un amplio espacio de almacenamiento para texturas y datos gráficos, lo que permite una experiencia de juego fluida y visualmente impresionante incluso en resoluciones 4K. La RTX 3080 también incluye características avanzadas como DLSS (Deep Learning Super Sampling) y NVIDIA Reflex, que mejoran la calidad visual y la capacidad de respuesta en los juegos. En resumen, la RTX 3080 es una tarjeta gráfica de élite que ofrece un rendimiento de última generación para jugadores y creadores de contenido que buscan la mejor calidad gráfica y un rendimiento excepcional.', 110, 'https://i.imgur.com/kSScpPb.png', 1500, to_date('15/02/2023', 'DD/MM/YYYY'), to_date('15/02/2023', 'DD/MM/YYYY'));

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
VALUES (12353, 16000, 2666, 'Mid', 'si');

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
VALUES (12358, 16, 'Rocket Lake', 1150, 15, 'Windows 10', 500);

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

INSERT INTO ps_cesta(codigo, numero_usuario, precio_cesta)
VALUES (4640, 5463, 50);

INSERT INTO ps_cesta(codigo, numero_usuario, precio_cesta)
VALUES (4641, 5464, 50);

INSERT INTO ps_cesta(codigo, numero_usuario, precio_cesta)
VALUES (4642, 5465, 50);

-- TABLA CESTA_ARTICULO --

INSERT INTO ps_cesta_articulo(id, articulo, cantidad, precio)
VALUES (4640, 12356, 1, 50);

INSERT INTO ps_cesta_articulo(id, articulo, cantidad, precio)
VALUES (4641, 12356, 1, 50);

INSERT INTO ps_cesta_articulo(id, articulo, cantidad, precio)
VALUES (4642, 12356, 1, 50);

-- TABLA PEDIDO --

INSERT INTO ps_pedido(numero, facturado, fecha_pedido, numero_direccion, codigo_usuario)
VALUES (4640, 'S', to_date('15/02/2023', 'DD/MM/YYYY'), 5, 5463);

INSERT INTO ps_pedido(numero, facturado, fecha_pedido, numero_direccion, codigo_usuario)
VALUES (4641, 'S', to_date('15/02/2023', 'DD/MM/YYYY'), 6, 5464);

INSERT INTO ps_pedido(numero, facturado, fecha_pedido, numero_direccion, codigo_usuario)
VALUES (4642, 'S', to_date('15/02/2023', 'DD/MM/YYYY'), 14, 5465);

-- TABLA PEDIDO_ARTICULO --

INSERT INTO ps_pedido_articulo(id, articulo, cantidad, precio)
VALUES (4640, 12356, 1, 50);

INSERT INTO ps_pedido_articulo(id, articulo, cantidad, precio)
VALUES (4641, 12356, 1, 50);

INSERT INTO ps_pedido_articulo(id, articulo, cantidad, precio)
VALUES (4642, 12356, 1, 50);

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
