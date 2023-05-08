<%-- 
    Document   : login
    Created on : May 8, 2023, 7:38:42 PM
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-login2.css">
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
            <h2>LOG IN</h2>
            <section class="login">
                <form action="LoginServlet" method="post">  
                    <label for="usuario">Correo Electronico:</label>
                    <input type="email" id="usuario" name="email" autocomplete="on" placeholder="Introduzca su correo electronico">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" autocomplete="on" placeholder="Introduzca su contraseña">
                    <button type="submit">ENTRAR</button>
                    <%
                        if (request.getAttribute("error") != null && (boolean) request.getAttribute("error")) {
                            out.println("<p>(*) Nombre de correo o contraseña inválidos. Vuelve a intentarlo</p>");
                        }
                    %>
                    <article class="registro"></article>
                    <article class="separacion">
                        <hr><p>O eres nuevo cliente</p><hr>
                    </article>
                    <button type="button">REGÍSTRATE</button>
                </form>
            </section>
        </main>

    </body>
</html>
