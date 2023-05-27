<%-- 
    Document   : admin-panel
    Created on : May 27, 2023, 8:00:31 PM
    Author     : sergio
--%>

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
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
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
                        <li><a href="./privacy.jsp">Privacidad</a></li>
                    </ul>
                </nav>
            </div>
            <article class="search">
                <form action="search" method="get">
                    <label>
                        <input type="text" id="search-bar" placeholder="Buscar" name="query">
                        <button type="submit"></button>
                    </label>
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
                    <a href="./usuario.jsp"><img src="./images/header/user-default.png" alt=""></a>
                    <form id="logoutForm" action="LogoutServlet" method="post">
                        <div class="logout-button" onclick="document.getElementById('logoutForm').submit()">
                            Cerrar Sesión</div>
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
            <a href="./usuario.jsp" class="user-query">
                <img src="./images/index/user.png" alt="">
            </a>
        </header>
        <main>

            <section class="statistics">
                <div class="statistic-card">
                    <p class="statistic-title">Total de Usuarios</p>
                    <p class="statistic-number">123</p>
                </div>
                <div class="statistic-card">
                    <p class="statistic-title">Total de Productos</p>
                    <p class="statistic-number">456</p>
                </div>
                <div class="statistic-card">
                    <p class="statistic-title">Total de Pedidos</p>
                    <p class="statistic-number">789</p>
                </div>
            </section>

            <section class="product-management">
                <h2>Gestión de productos</h2>
                <div class="add-product">
                    <h3>Añadir producto</h3>
                    <form id="add-product-form">
                        <!-- El menú desplegable para seleccionar el tipo de producto -->
                        <select id="product-type-selector" onchange="changeForm()">
                            <option value="">Selecciona un tipo de producto</option>
                            <option value="ps_refrigeracion">Refrigeración</option>
                            <option value="ps_caja">Caja</option>
                            <!-- Añade aquí las otras opciones... -->
                        </select>

                        <div>
                            <input type="text" id="nombre" placeholder="Nombre" required>
                            <input type="text" id="descripcion" placeholder="Descripción" required>
                            <input type="number" id="precio" placeholder="Precio" required>
                            <input type="text" id="path_foto" placeholder="Ruta de la foto" required>
                            <input type="number" id="stock" placeholder="Stock" required>
                        </div>
                        <!-- Los campos del formulario irían aquí. Por defecto, están ocultos -->
                        <div id="ps_refrigeracion-fields" class="product-fields" style="display: none;">
                            <!-- Los campos para el tipo 'ps_refrigeracion' -->
                            <input type="number" id="codigo" placeholder="Código" required>
                            <input type="text" id="tipo" placeholder="Tipo" required>
                            <input type="text" id="socket" placeholder="Socket" required>
                            <input type="number" id="size_mm" placeholder="Tamaño en mm" required>
                            <input type="number" id="sizee_mm" placeholder="Tamaño en mm" required>
                        </div>
                        <div id="ps_caja-fields" class="product-fields" style="display: none;">
                            <!-- Los campos para el tipo 'ps_caja' -->
                            <input type="number" id="codigo" placeholder="Código" required>
                            <input type="text" id="size_case" placeholder="Tamaño de la caja" required>
                            <input type="text" id="color" placeholder="Color" required>
                            <input type="text" id="conexion" placeholder="Conexión" required>
                        </div>
                        <!-- Añade aquí los otros divs para los otros tipos de productos... -->

                        <button type="submit">Añadir</button>
                    </form>
                </div>
            </section>

            <section class="products">
                <h2>Productos</h2>
                <table>
                    <!-- Cabeza de la tabla -->
                    <tr>
                        <th>Nombre</th>
                        <th>ID</th>
                        <th>Categoría</th>
                        <th>Stock</th>
                        <th></th>
                    </tr>

                    <!-- Filas de ejemplo -->
                    <tr>
                        <td>Producto 1</td>
                        <td>1</td>
                        <td>Categoría 1</td>
                        <td>100</td>
                        <td><button class="edit-button">Editar</button></td>
                    </tr>
                </table>
            </section>

            <section class="orders">
                <h2>Pedidos</h2>
                <table>
                    <!-- Cabeza de la tabla -->
                    <tr>
                        <th>ID Pedido</th>
                        <th>ID Usuario</th>
                        <th>Precio</th>
                        <th>Fecha</th>
                        <th></th>
                    </tr>

                    <!-- Filas de ejemplo -->
                    <tr>
                        <td>1</td>
                        <td>1</td>
                        <td>$99.99</td>
                        <td>2023-01-01</td>
                        <td><button class="edit-button">Editar</button></td>
                    </tr>
                </table>
            </section>

            <section class="users">
                <h2>Usuarios</h2>
                <table>
                    <!-- Cabeza de la tabla -->
                    <tr>
                        <th>Nombre</th>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th></th>
                    </tr>

                    <!-- Filas de ejemplo -->
                    <tr>
                        <td>Usuario 1</td>
                        <td>1</td>
                        <td>Cliente</td>
                        <td><button class="edit-button">Editar</button></td>
                    </tr>
                </table>
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
        <script src="js/admin-manage.js"></script>
    </body>
</html>