<%-- 
Document   : login
Created on : May 8, 2023, 7:38:42 PM
Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if (request.getParameter("success") != null) { %>
<div class="alert alert-success">
    <center>El registro se ha completado correctamente.</center>
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
        <link rel="stylesheet" href="./css/style-login.css">
        <title>LOG IN - PCSanchez</title>
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
                        <li><a href="./index.jsp">Inicio</a></li>
                        <li><a href="./OrdenadoresViejo.html">Ordenadores</a></li>
                        <li><a href="./ComponentesViejo.html">Componentes</a></li>
                        <li><a href="./PrivacyViejo.html">Privacidad</a></li>
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
                <button type="button" onclick="location.href = './register.jsp'">REGISTRARSE</button>
                <article>
                    <a href="./login.html">ENTRAR</a>
                </article>
            </section>

            <!--         EStANDO LOGUEADO -->

            <section class="usuario-logued">
                <figure class="foto-perfil">
                    <a href="./UsuarioViejo.html"><img src="./images/header/user-default.png" alt=""></a>
                    <div class="logout-button">Cerrar Sesión</div>
                </figure>
                <figure>
                    <a href="./cesta.html"><img src="./images/index/carro.png" alt=""></a>
                </figure>
            </section>

            <a href="./index.jsp" class="titulo-query">
                <h2>PC SANCHEZ</h2>
            </a>
            <a href="./usuario.jsp" class="user-query">
                <img src="./images/index/user.png" alt="">
            </a>

        </header>
        <main>
            <h2>LOG IN</h2>
            <section class="login">
                <form action="LoginServlet" method="post"> 
                    <label for="email">Nombre de usuario:</label>
                    <input type="email" id="usuario" name="email" autocomplete="on" placeholder="Introduzca su correo electrónico">
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
                    <button type="button" onclick="window.location.href='./register.jsp'">REGÍSTRATE</button>
                </form>
            </section>
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