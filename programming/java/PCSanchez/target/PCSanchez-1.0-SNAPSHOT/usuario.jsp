<%-- 
    Document   : usuario
    Created on : May 23, 2023, 9:43:17 PM
    Author     : sergio
--%>

<%@page import="dto.Tarjeta"%>
<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.TarjetaDAO" %>
<%if (session.getAttribute("loggedIn") == null || !((boolean) session.getAttribute("loggedIn"))) {%>
<%   response.sendRedirect("index.jsp");%>
<%} else {%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-user.css">
        <title>Usuario - PCSanchez</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                        <!-- Las sugerencias irán aquí -->
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
            <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {%>
            <section class="usuario-logued">
                <figure class="foto-perfil">
                    <a href="./usuario.jsp"><img src="<%= ((Usuario) session.getAttribute("usuario")).getFoto()%>" alt=""></a>
                    <form id="logoutForm" action="LogoutServlet" method="post">
                        <div class="logout-button" onclick="document.getElementById('logoutForm').submit()">Cerrar Sesión</div>
                    </form>
                </figure>
                <figure>
                    <a href="./cesta.jsp"><img src="./images/index/carro.png" alt=""></a>
                </figure>
            </section>
            <% }%>
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
            <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {%>
            <a href="./usuario.jsp" class="user-query">
                <img src="<%= ((Usuario) session.getAttribute("usuario")).getFoto()%>" alt="">
            </a>
            <% }%>
        </header>
        <main>
            <section class="perfil">
                <div class="foto-foto-usuario">
                    <figure class="foto-usuario">
                        <!-- Asegúrate de que la imagen se carga desde la URL correcta. -->
                        <!-- Si tienes la URL de la foto en la sesión, puedes cargarla desde allí. -->
                        <img src="<%= ((Usuario) session.getAttribute("usuario")).getFoto()%>" alt="Foto de perfil">
                    </figure>
                    <input type="checkbox" id="cambiar-foto-toggle" class="cambiar-foto-toggle">
                    <label for="cambiar-foto-toggle" class="cambiar-foto">Cambiar foto</label>
                    <div class="url-intro">
                        <!-- Aquí es donde actualizamos el formulario para enviar una solicitud POST a nuestro servlet. -->
                        <form action="ActualizarFotoUsuarioServlet" method="post">
                            <input type="text" name="photoUrl" placeholder="Introduce la URL de la imagen">
                            <button type="submit">Enviar</button>
                        </form>
                    </div>
                </div> 
                <div class="info">
                    <br>
                    <h3><%= ((Usuario) session.getAttribute("usuario")).getTipoUsuario()%></h3>
                    <br>
                    <h2><%= ((Usuario) session.getAttribute("usuario")).getNombreCompleto()%></h2>
                    <p><%= ((Usuario) session.getAttribute("usuario")).getEmail()%></p>
                    <p><%= ((Usuario) session.getAttribute("usuario")).getFechaNacimiento()%></p>
                    <%
                        TarjetaDAO tarjetaDAO = new TarjetaDAO();
                        int codigoUsuario = ((Usuario) session.getAttribute("usuario")).getCodigo();
                        Tarjeta tarjeta = tarjetaDAO.getByCodigoUsuario(codigoUsuario);
                    %>
                    <br>
                    <section class="tarjeta">
                        <% if (tarjeta != null) {%>
                        <h4>Tarjeta asociada:</h4>
                        <p>Número de tarjeta: <%= "**** **** **** " + String.valueOf(tarjeta.getNumeroTarjeta()).substring(String.valueOf(tarjeta.getNumeroTarjeta()).length() - 4)%></p>
                        <button type="button" onclick="location.href = './modificar-tarjeta.jsp'" class="agregar-metodo-pago">Modificar Método de Pago</button>
                        <!-- Agrega aquí más información de la tarjeta si es necesario -->
                        <% } else { %>
                        <p>No dispones de un método de pago. Introduce un método de pago válido para poder realizar compras en la web</p>
                        <button type="button" onclick="location.href = './agregar-tarjeta.jsp'" class="agregar-metodo-pago">Agregar Método de Pago</button>
                        <% } %>
                    </section>
                    <br>
                    <section>
                        <section class="pedido-cesta">
                            <button type="button" onclick="location.href = './pedidos.jsp'">Pedidos</button>
                            <button type="button" onclick="location.href = './cesta.jsp'">Cesta</button>
                        </section>
                        <button type="button" class="logout" onclick="document.getElementById('logoutForm').submit()">Cerrar sesion</button>
                    </section>
                </div>
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
        <script src="js/autocompletar.js"></script>
        <script src="js/buscar-categorias.js"></script>
    </body>
</html>
<%}%>