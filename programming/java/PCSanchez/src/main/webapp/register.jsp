<%-- 
    Document   : register
    Created on : May 9, 2023, 1:51:35 AM
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Importamos la librería JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Código HTML de la página --%>
<% if (request.getParameter("error") != null) { %>
<div class="alert alert-danger">
    <% if ("invalidData".equals(request.getParameter("error"))) { %>
    <style>
        .fondo-rojo {
            background-color: orange; /* Código de color para el rojo ferrari */
            color: white; /* Texto en color blanco para resaltar */
            padding: 10px; /* Espacio alrededor del contenido */
            border-radius: 5px; /* Borde redondeado para un aspecto más atractivo */
        }
    </style>

    <div class="fondo-rojo">
        <center>Los datos proporcionados son inválidos.</center>
    </div>
    <% } else if ("passwordsDoNotMatch".equals(request.getParameter("error"))) { %>
    <center>Las contraseñas no coinciden.</center>
        <% } else if ("invalidDate".equals(request.getParameter("error"))) { %>
    <center>La fecha de nacimiento es inválida.</center>
        <% } else if ("userAlreadyExists".equals(request.getParameter("error"))) { %>
    <center>Ya existe un usuario con este correo electrónico.</center>
        <% } else if ("databaseError".equals(request.getParameter("error"))) { %>
    <center>Ha ocurrido un error al conectar con la base de datos.</center>
        <% } else if ("policy".equals(request.getParameter("error"))) { %>
    <center>Acepta la política de privacidad antes de completar el registro.</center>
        <% } else if ("phone".equals(request.getParameter("error"))) { %>
    <center>Introduce un número de teléfono correcto.</center>
        <% } %>
</div>
<% }%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-register.css">
        <title>LOG IN - PCSanchez</title>
    </head>
    <body>
        <header>
            <figure class="logo">
                <img src="./images/index/logo.png" alt="">
            </figure>
            <nav>
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">Ordenadores</a></li>
                    <li><a href="#">Componentes</a></li>
                    <li><a href="./privacy.html">Nosotros</a></li>
                </ul>
            </nav>
            <article class="search">
                <form>
                    <label>
                        <input type="text" placeholder="Buscar">
                        <button type="submit"></button>
                    </label>
                </form>
            </article>
            <section class="usuario">
                <article >
                    <p>REGISTRASE</p>
                </article>
                <article>
                    <p>ENTRAR</p>
                </article>
            </section>
            <section class="titulo-query">
                <h2>PC SANCHEZ</h2>
            </section>
            <figure class="burger">
                <img src="./images/index/burger.png" alt="">
            </figure>
            <figure class="user-query">
                <img src="./images/index/user.png" alt="">
            </figure>
        </header>
        <main>
            <h2>REGISTRO</h2>
            <section class="registro">
                <form method="post" action="RegisterServlet">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" autocomplete="on" placeholder="Introduzca su nombre">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" autocomplete="on" placeholder="Introduzca su correo electrónico">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" autocomplete="off" placeholder="Introduzca su contraseña">
                    <label for="password-confirm">Confirmar contraseña:</label>
                    <input type="password" id="password-confirm" name="password-confirm" autocomplete="off" placeholder="Confirme su contraseña">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono" autocomplete="on" placeholder="Introduzca su teléfono">
                    <label for="fecha-nacimiento">Fecha de nacimiento:</label>
                    <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" autocomplete="on" placeholder="Seleccione su fecha de nacimiento">
                    <section class="privacy">
                        <input type="checkbox" id="privacy-policy" name="privacy-policy">
                        <label for="privacy-policy">He leído y acepto la <a href="./privacy.html">política de privacidad</a>.</label>
                    </section>
                    <button type="submit">REGISTRARSE</button>
                </form>
            </section>
        </main>
    </body>
</html>



