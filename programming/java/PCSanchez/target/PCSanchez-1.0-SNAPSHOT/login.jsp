<%-- 
Document   : login
Created on : May 8, 2023, 7:38:42 PM
Author     : sergio
--%>

<%@page import="dto.Usuario"%>
<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-login.css">
        <title>LOG IN - PCSanchez</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <header>
            <figure class="logo">
                <a href="./index.jsp">
                    <img src="./images/index/logo.png" alt="">
                </a>
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
                        <li><a href="./ordenadores.jsp">Ordenadores</a></li>
                        <li><a href="./componentes.jsp">Componentes</a></li>
                        <li id="primary-li"><a href="./contacto.jsp">Contactanos</a></li>
                        <li id="secondary-li"><a href="./privacy.jsp">Privacidad</a></li>
                    </ul>
                </nav>
            </div>
            <article class="search">
                <form action="search" method="get" onsubmit="onSubmitForm()">
                    <label>
                        <input type="text" id="search-bar" placeholder="Buscar por nombre o categoría">
                        <button type="submit"></button>
                    </label>
                    <input type="hidden" id="categoria-input" name="categoria" value="">
                    <input type="hidden" id="query-input" name="query" value="">
                </form>
                <div id="suggestion-box" style="display: none;">
                    <ul id="suggestions">
                    </ul>
                </div>
            </article>
            <!-- SIN ESTAR LOGEADO -->
            <% if (session.getAttribute("loggedIn") == null || !(boolean) session.getAttribute("loggedIn")) { %>
            <section class="usuario">
                <button type="button" onclick="location.href = './register.jsp'">REGISTRARSE</button>
                <article>
                    <a href="./login.jsp">ENTRAR</a>
                </article>
            </section>
            <% } %>
            <!-- EStANDO LOGUEADO -->
            <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { %>
            <section class="usuario-logued">
                <figure class="foto-perfil">
                    <% if (session.getAttribute("usuario") != null) {%>
                    <a href="./usuario.jsp"><img src="<%= ((Usuario) session.getAttribute("usuario")).getFoto()%>" alt=""></a>
                        <% } %>
                    <form id="logoutForm" action="LogoutServlet" method="post">
                        <div class="logout-button" onclick="document.getElementById('logoutForm').submit()">Cerrar Sesión</div>
                    </form>
                </figure>
                <figure>
                    <a href="./cesta.jsp"><img src="./images/index/carro.png" alt=""></a>
                </figure>
            </section>
            <% } %>
            <a href="./index.jsp" class="titulo-query">
                <h2>PC SANCHEZ</h2>
            </a>
            <!-- SIN ESTAR LOGEADO -->
            <% if (session.getAttribute("loggedIn") == null || !(boolean) session.getAttribute("loggedIn")) { %>
            <a href="./login.jsp" class="user-query">
                <img src="./images/header/user-default.png" alt="">
            </a>
            <% } %>
            <!-- EStANDO LOGUEADO -->
            <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { %>
            <% if (session.getAttribute("usuario") != null) {%>
            <a href="./usuario.jsp" class="user-query">
                <img src="<%= ((Usuario) session.getAttribute("usuario")).getFoto()%>" alt="">
            </a>
            <% } %>
            <% } %>
        </header>
        <main>
            <% if (request.getParameter("success") != null) { %>
            <div class="alert alert-success">
                <center>El registro se ha completado correctamente.</center>
            </div>
            <% }%>
            <h2>LOG IN</h2>
            <section class="login">
                <form action="LoginServlet" method="post"> 
                    <label for="email">Correo electrónico:</label>
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
                    <button type="button" onclick="window.location.href = './register.jsp'">REGÍSTRATE</button>
                </form>
            </section>
        </main>
        <footer>
            <div class="footer-container">
                <figure>
                    <img src="./images/footer/logo-footer2.png" alt="">
                </figure>
                <div class="footer-logo">
                    <a href="https://iespacomolla.es/"><img src="./images/footer/logo-footer.png" alt="PC SANCHEZ Logo"></a>
                </div>
                <div class="github-link">
                    <figure>
                        <a href="https://github.com/LitoHDD/PCSanchez"><img src="./images/footer/github.png" alt=""></a>
                    </figure>
                </div>
            </div>
        </footer>
        <script src="js/autocompletar.js"></script>
        <script src="js/buscar-categorias.js"></script>
    </body>