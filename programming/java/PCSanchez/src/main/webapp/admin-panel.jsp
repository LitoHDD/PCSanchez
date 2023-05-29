<%-- 
    Document   : admin-panel
    Created on : May 27, 2023, 8:00:31 PM
    Author     : sergio
--%>

<%@page import="dto.TipoUsuario"%>
<%@page import="dao.FacturaDAO"%>
<%@page import="dto.Factura"%>
<%@page import="dto.Pedido"%>
<%@page import="dao.PedidoDAO"%>
<%@page import="dto.Articulo"%>
<%@page import="dao.ArticuloDAO"%>
<%@page import="dto.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dto.Psu"%>
<%@ page import="dao.PsuDAO"%>
<%@ page import="dto.TarjetaGrafica"%>
<%@ page import="dao.TarjetaGraficaDAO"%>
<%@ page import="dto.Procesador"%>
<%@ page import="dao.ProcesadorDAO"%>
<%@ page import="dto.Almacenamiento"%>
<%@ page import="dao.AlmacenamientoDAO"%>
<%@ page import="dto.Ram"%>
<%@ page import="dao.RamDAO"%>
<%@ page import="java.util.Collections"%>
<%@ page import="dto.PlacaBase"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.PlacaBaseDAO"%>
<%@ page import="dao.PortatilDAO" %>
<%@ page import="dto.Portatil" %>
<%@ page import="dao.SobremesaDAO" %>
<%@ page import="dto.Sobremesa" %>
<%
    TipoUsuario tipoUsuario = ((Usuario) session.getAttribute("usuario")).getTipoUsuario();
%>

<% if (tipoUsuario == TipoUsuario.CLIENTE || session.getAttribute("loggedIn") != null && !(boolean) session.getAttribute("loggedIn")) { %>
<%response.sendRedirect("index.jsp");%>
<% } else { %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-admin.css">
        <title>INICIO - PCSanchez</title>
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
            <%
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                ArrayList<Usuario> usuarios = usuarioDAO.getAll();
                int totalUsuarios = usuarios.size();
                ArticuloDAO articuloDAO = new ArticuloDAO();
                ArrayList<Articulo> articulos = articuloDAO.getAll();
                int totalArticulos = articulos.size();
                PedidoDAO pedidoDAO = new PedidoDAO();
                ArrayList<Pedido> pedidos = pedidoDAO.getAll();
                int totalPedidos = pedidos.size();
                FacturaDAO facturaDAO = new FacturaDAO();
                ArrayList<Factura> listaFacturas = facturaDAO.getAll();
                int totalFacturas = listaFacturas.size();
            %>
            <section class="statistics">
                <div class="statistic-card">
                    <p class="statistic-title">Total de Usuarios</p>
                    <p class="statistic-number"><%= totalUsuarios%></p>
                </div>
                <div class="statistic-card">
                    <p class="statistic-title">Total de Productos</p>
                    <p class="statistic-number"><%= totalArticulos%></p>
                </div>
                <div class="statistic-card">
                    <p class="statistic-title">Total de Pedidos</p>
                    <p class="statistic-number"><%= totalPedidos%></p>
                </div>
                <div class="statistic-card">
                    <p class="statistic-title">Total de Facturas</p>
                    <p class="statistic-number"><%= totalFacturas%></p>
                </div>
            </section>
            <section class="products">
                <h2>Productos</h2>
                <table>
                    <tr>
                        <th>Imagen</th>
                        <th>Nombre</th>
                        <th>ID</th>
                        <th>Stock</th>
                        <th>Precio</th>
                    </tr>
                    <% for (Articulo articulo : articulos) {%>
                    <tr>
                        <td style="text-align: center;"><img src="<%= articulo.getPathFoto()%>" alt="alt" class="small-image" /></td>
                        <td><%= articulo.getNombre()%></td>
                        <td><%= articulo.getCodigo()%></td>
                        <td><%= articulo.getStock()%></td>
                        <td><%= articulo.getPrecio()%> €</td>
                    </tr>
                    <% }%>
                </table>
            </section>


            <section class="orders">
                <h2>Pedidos</h2>
                <table>
                    <tr>
                        <th>ID Pedido</th>
                        <th>ID Usuario</th>
                        <th>Facturado</th>
                        <th>Fecha</th>
                        <th>Precio</th>
                        <th>Generar</th>
                    </tr>
                    <% for (Pedido pedido : pedidos) {%>
                    <tr>
                        <td><%= pedido.getNumero()%></td>
                        <td><%= pedido.getUsuario().getCodigo()%></td>
                        <td><%= pedido.getFacturado().equals("S") ? "Si" : "No" %></td>
                        <td><%= pedido.getFechapedido()%></td>
                        <td><%= pedido.getPrecioTotal()%> €</td>
                        <td>
                            <button type="button" class="pdf-button" data-numero-pedido="<%= pedido.getNumero()%>">Factura PDF</button>
                            <button type="button" class="xml-button" data-numero-pedido="<%= pedido.getNumero()%>">Factura XML</button>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </section>

            <section class="orders">
                <h2>Facturas</h2>
                <table>
                    <tr>
                        <th>ID Factura</th>
                        <th>Direccion</th>
                        <th>Fecha</th>
                        <th>Pedido</th>
                    </tr>
                    <% for (Factura factura : listaFacturas) {%>
                    <tr>
                        <td><%= factura.getCodFactura()%></td>
                        <td><%= factura.getPedido().getUsuario().getDirecciones().toString().replace("[", "").replace("]", "")%></td>
                        <td><%= factura.getFecha()%></td>
                        <td>
                            <% if (factura.getPedido() != null) {%>
                            <%= factura.getPedido().getNumero()%>
                            <% } else { %>
                            Sin pedido asociado
                            <% } %>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </section>
            <br>
            <section class="users">
                <h2>Usuarios</h2>
                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>ID</th>
                        <th>Tipo</th>
                    </tr>
                    <% for (Usuario usuario : usuarios) {%>
                    <tr>
                        <td><%= usuario.getNombreCompleto()%></td>
                        <td><%= usuario.getCodigo()%></td>
                        <td><%= usuario.getTipoUsuario()%></td>
                    </tr>
                    <% }%>
                </table>
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
        <script src="js/facturar.js"></script>
        <script src="js/autocompletar.js"></script>
        <script src="js/buscar-categorias.js"></script>
    </body>
</html>
<%
    }
%>