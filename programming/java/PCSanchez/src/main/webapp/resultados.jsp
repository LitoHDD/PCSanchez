<%-- 
    Document   : resultados
    Created on : May 25, 2023, 1:45:57 AM
    Author     : sergio
--%>

<%-- 
    Document   : resultados
    Created on : May 25, 2023, 1:45:57 AM
    Author     : sergio
--%>

<%@page import="java.util.List"%>
<%@page import="dto.Articulo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultados de búsqueda</title>
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-producto.css">
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
                        <li><a href="./ordenadores.jsp">Ordenadores</a></li>
                        <li><a href="./componentes.jsp">Componentes</a></li>
                        <li><a href="./privacy.jsp">Privacidad</a></li>
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
            <% if (session.getAttribute("loggedIn") == null || !(boolean) session.getAttribute("loggedIn")) { %>
            <section class="usuario">
                <button type="button" onclick="location.href = './register.jsp'">REGISTRARSE</button>
                <article>
                    <a href="./login.jsp">ENTRAR</a>
                </article>
            </section>
            <% } %>
            <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { %>
            <section class="usuario-logued">
                <figure class="foto-perfil">
                    <a href="./usuario.jsp"><img src="./images/header/user-default.png" alt=""></a>
                    <form id="logoutForm" action="LogoutServlet" method="post">
                        <div class="logout-button" onclick="document.getElementById('logoutForm').submit()">Cerrar Sesión</div>
                    </form>
                </figure>
                <figure>
                    <a href="./cesta.html"><img src="./images/index/carro.png" alt=""></a>
                </figure>
            </section>
            <% } %>
            <a href="./index.html" class="titulo-query">
                <h2>PC SANCHEZ</h2>
            </a>
            <a href="./UsuarioViejo.html" class="user-query">
                <img src="./images/index/user.png" alt="">
            </a>
        </header>
        <div class="general">
            <section class="producto">
                <h1>Resultados de búsqueda</h1>
                <% List<Articulo> results = (List<Articulo>) request.getAttribute("results"); %>
                <% for (Articulo articulo : results) {%>
                <a href="producto.jsp?codigo=<%= articulo.getCodigo()%>">
                    <figure class="foto">
                        <img src="<%= articulo.getPathFoto()%>" alt="Foto del producto">
                    </figure>
                </a>
                <section class="comprar">
                    <h2><%= articulo.getNombre()%></h2>
                    <h3><%= articulo.getPrecio()%> €</h3>
                    <section class="pedido">
                        <ul class="negrita">
                            <li><strong>MARCA:</strong></li>
                            <li><strong>ENVÍO:</strong></li>
                            <li><strong>DEVOLUCIÓN:</strong></li>
                            <li><strong>CANTIDAD:</strong></li>
                        </ul>
                        <ul class="datos">
                            <li><%= articulo.getNombre()%></li>
                            <li>Gratis-24h</li>
                            <li>Gratis</li>
                            <li><input id="number" type="number" value="1" /></li>
                        </ul>
                    </section>
                    <section class="buy">
                        <section class="buy-comprar"> 
                            <a href="#" id="buy">AÑADIR AL CARRITO</a>
                        </section>
                    </section> 
                </section>
                <% }%>
            </section>
        </div>
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