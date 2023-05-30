<%@page import="dao.ArticuloDAO"%>
<%@page import="dto.Articulo"%>
<%@page import="dto.Usuario"%>
<%@page import="dto.Usuario"%>
<%@page import="dao.LineaCestaDAO"%>
<%@page import="dao.CestaDAO"%>
<%@page import="dto.LineaCesta"%>
<%@page import="dto.Cesta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("loggedIn") == null || !((boolean) session.getAttribute("loggedIn"))) {
        response.sendRedirect("index.jsp");
    } else {
        ArrayList<Cesta> cestas = (ArrayList<Cesta>) session.getAttribute("cestas");

        LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-cesta.css">
        <title>CESTA - PCSanchez</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/calcular-precio-total.js"></script>
        <script src="js/eliminar-articulo-cesta.js"></script>
        <script src="js/vaciar-cesta.js"></script>
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
            <h2>CESTA</h2>
            <section class="cesta">
                <% if (cestas != null && !cestas.isEmpty()) {
                        ArrayList<LineaCesta> lineas = lineaCestaDAO.getLineas(cestas.get(0).getCodigo());
                        if (lineas != null && !lineas.isEmpty()) {%>
                <button class="eliminar" type="button" onclick="vaciarCesta(<%= cestas.get(0).getCodigo()%>)">Vaciar Cesta</button>
                <% } else { %>
                <center><p>No hay artículos en la cesta.</p></center>
                    <% }
                        for (LineaCesta linea : lineas) {%>
                <article class="producto">
                    <figure class="producto-img">
                        <img src="<%= linea.getArticulo().getPathFoto()%>" alt="Producto">
                    </figure>
                    <div class="producto-info">
                        <h3><%= linea.getArticulo().getNombre()%></h3>
                        <p>Precio: <%= linea.getArticulo().getPrecio()%>€</p>
                        <label for="cantidad">Cantidad:</label>
                        <input type="number" id="cantidad" name="cantidad" value="<%= linea.getCantidad()%>" min="1" onchange="calcularPrecioTotal()">
                    </div>
                    <%
                        int lineaId = linea.getId();
                        int codigoArticulo = linea.getArticulo().getCodigo();
                        Articulo articulo = articuloDAO.getByCodigo(codigoArticulo); // Obtener el artículo correspondiente
                    %>
                    <button class="eliminar" type="button" onclick="eliminarProducto('<%= lineaId%>', '<%= codigoArticulo%>')">Eliminar</button>
                    <%
                        // Actualizar el stock del artículo
                        articulo.setStock(articulo.getStock() - linea.getCantidad());
                        articuloDAO.actualizar(articulo);
                    %>
                </article>
                <% }
                } else { %>
                <p>No hay artículos en la cesta.</p>
                <% } %>
            </section>
            <div class="resumen">
                <h3>Resumen de la compra</h3>
                <p id="precio-total">Total: 0,00€</p>
                <form method="POST" action="ComprarServlet">
                    <button type="submit">Comprar</button>
                </form>
            </div>
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
</html>
<%
    }
%>