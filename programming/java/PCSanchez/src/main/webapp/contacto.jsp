<%-- 
    Document   : contacto
    Created on : May 27, 2023, 3:04:28 AM
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
        <link rel="stylesheet" href="./css/style-contacto.css">
        <title>INICIO - PCSanchez</title>
    </head>
    <body>
        <header>
            <figure class="logo">
                <img src="./images/index/logo.png" alt="">
            </figure>
            <input type="checkbox" id="hamburger-toggle" class="hamburger-toggle">
            <label for="hamburger-toggle" class="burger-label">
                <figure class="burger">
                    <img src="./images/index/burger.png" alt="">
                </figure>
            </label>
            <div class="menu">
                <nav>
                    <ul>
                        <li><a href="./index.html">Inicio</a></li>
                        <li><a href="./ordenadores.html">Ordenadores</a></li>
                        <li><a href="./componentes.html">Componentes</a></li>
                        <li><a href="./privacy.html">Privacidad</a></li>
                    </ul>
                </nav>
            </div>
            <article class="search">
                <form>
                    <label>
                        <input type="text" placeholder="Buscar">
                        <button type="submit"></button>
                    </label>
                </form>
            </article>

            <!--         SIN ESTAR LOGEADO -->

            <section class="usuario">
                <button type="button" onclick="location.href = './register.html'">REGISTRARSE</button>
                <article>
                    <a href="./login.html">ENTRAR</a>
                </article>
            </section>

            <!--         EStANDO LOGUEADO -->

            <section class="usuario-logued">
                <figure class="foto-perfil">
                    <a href="./usuario.html"><img src="./images/header/user-default.png" alt=""></a>
                    <div class="logout-button">Cerrar Sesión</div>
                </figure>
                <figure>
                    <a href="./cesta.html"><img src="./images/index/carro.png" alt=""></a>
                </figure>
            </section>

            <a href="./index.html" class="titulo-query">
                <h2>PC SANCHEZ</h2>
            </a>
            <a href="./usuario.html" class="user-query">
                <img src="./images/index/user.png" alt="">
            </a>

        </header>
        <main>
            <h2>CONTÁCTANOS</h2>
            <form class="contacto-form" action="ContactoServlet" method="post" accept-charset="UTF-8">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="mensaje">Mensaje:</label>
                <textarea id="mensaje" name="mensaje" required></textarea>

                <button type="submit">Enviar</button>

                <% if (request.getAttribute("resultado") != null) {%>
                <div class="resultado">
                    <p><%= request.getAttribute("resultado")%></p>
                </div>
                <% }%>
            </form>
        </main>
        <footer>
            <div class="footer-container">
                <figure>
                    <img src="./images/footer/logo-footer2.png" alt="">
                </figure>
                <div class="footer-logo">
                    <img src="./images/footer/logo-footer.png" alt="PC SANCHEZ Logo">
                </div>
                <div class="github-link">
                    <figure>
                        <a href=""><img src="./images/footer/github.png" alt=""></a>
                    </figure>
                </div>
            </div>
        </footer>
    </body>
</html>