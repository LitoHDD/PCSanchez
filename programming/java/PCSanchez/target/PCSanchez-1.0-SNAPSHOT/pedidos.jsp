<%-- 
    Document   : pedidos
    Created on : May 26, 2023, 2:20:13 AM
    Author     : sergio
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="dto.Pedido"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dao.PedidoArticuloDAO"%>
<%@page import="dto.PedidoArticulo"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="./css/style-pedidos.css">
        <title>PEDIDOS - PCSanchez</title>
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
            <h2>MIS PEDIDOS</h2>
            <section class="pedidos">
                <%
                    // Verificar si el usuario está logueado
                    if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
                        // Obtener el usuario logueado
                        Usuario usuario = (Usuario) session.getAttribute("usuario");
                        int codigoUsuario = usuario.getCodigo(); // Código del usuario logueado

                        // Crear una instancia del DAO de PedidoArticulo
                        PedidoArticuloDAO pedidoArticuloDAO = new PedidoArticuloDAO();

                        try {
                            // Obtener los pedidos del usuario
                            ArrayList<PedidoArticulo> lineas = pedidoArticuloDAO.getLineasPorUsuario(codigoUsuario);

                            // Verificar si hay pedidos
                            if (lineas.isEmpty()) {
                %>
                <p>No tienes pedidos.</p>
                <%
                } else {
                    // Crear un conjunto para almacenar los números de pedido únicos
                    Set<Integer> numerosPedidos = new HashSet<>();

                    // Agregar los números de pedido al conjunto
                    for (PedidoArticulo linea : lineas) {
                        numerosPedidos.add(linea.getId());
                    }

                    // Iterar sobre los números de pedido y mostrar los pedidos correspondientes
                    for (int numeroPedido : numerosPedidos) {
                        Date fechaPedido = pedidoArticuloDAO.getFechaPedido(numeroPedido);

                %>
                <h3>Número de Pedido: <%= numeroPedido%></h3>
                <p>Fecha Pedido: <%= fechaPedido%></p>
                <p>Dirección de envío: <%= usuario.getDirecciones().toString().replace("[", "").replace("]", "")%></p>
                <div class="factura-buttons">
                    <button type="button" class="pdf-button" data-numero-pedido="<%= numeroPedido%>">Factura PDF</button>
                    <button type="button" class="xml-button" data-numero-pedido="<%= numeroPedido%>">Factura XML</button>
                </div>
                <%
                    for (PedidoArticulo linea : lineas) {
                        if (linea.getId() == numeroPedido) {
                %>
                <article class="pedido">
                    <figure class="producto-img">
                        <img src="<%= linea.getArticulo().getPathFoto()%>" alt="Producto">
                    </figure>
                    <div class="producto-info">
                        <h3><%= linea.getArticulo().getNombre()%></h3>
                        <p>Unidades compradas: <%= linea.getCantidad()%></p>
                    </div>
                </article>
                <%
                        }
                    }
                %>
                <%
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                %>
                <p>Debes iniciar sesión para ver tus pedidos.</p>
                <%
                    }
                %>
            </section>
        </main>
    </body>
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
    <script src="js/facturar.js"></script>
    <script src="js/autocompletar.js"></script>
    <script src="js/buscar-categorias.js"></script>
</html>