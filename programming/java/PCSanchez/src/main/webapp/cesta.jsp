<%@page import="dao.LineaCestaDAO"%>
<%@page import="dao.CestaDAO"%>
<%@page import="dto.LineaCesta"%>
<%@page import="dto.Cesta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Verificar si el usuario está logueado
    if (session.getAttribute("loggedIn") == null || !((boolean) session.getAttribute("loggedIn"))) {
        response.sendRedirect("index.jsp");
    } else {
        ArrayList<Cesta> cestas = (ArrayList<Cesta>) session.getAttribute("cestas");

        LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-cesta.css">
        <title>CESTA - PCSanchez</title>
        <script src="js/calcular-precio-total.js"></script>
        <script src="js/eliminar-articulo-cesta.js"></script>
        <script src="js/vaciar-cesta.js"></script>
    </head>
    <body>
        <header>
            <figure class="logo">
                <img src="./images/index/logo.png" alt="">
            </figure>
            <nav>
                <ul>
                    <li><a href="./index.jsp">Inicio</a></li>
                    <li><a href="#">Ordenadores</a></li>
                    <li><a href="#">Componentes</a></li>
                    <li><a href="./PrivacyViejo.html">Nosotros</a></li>
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
    <h2>CESTA</h2>
    <section class="cesta">
        <% if (cestas != null && !cestas.isEmpty()) {
            ArrayList<LineaCesta> lineas = lineaCestaDAO.getLineas(cestas.get(0).getCodigo());
            if (lineas != null && !lineas.isEmpty()) { %>
                <button class="eliminar" type="button" onclick="vaciarCesta(<%= cestas.get(0).getCodigo()%>)">Vaciar Cesta</button>
            <% } else { %>
                <center><p>No hay artículos en la cesta.</p></center>
            <% }
            for (LineaCesta linea : lineas) { %>
                <article class="producto">
                    <figure class="producto-img">
                        <img src="<%= linea.getArticulo().getPathFoto() %>" alt="Producto">
                    </figure>
                    <div class="producto-info">
                        <h3><%= linea.getArticulo().getNombre() %></h3>
                        <p>Precio: <%= linea.getArticulo().getPrecio() %>€</p>
                        <label for="cantidad">Cantidad:</label>
                        <input type="number" id="cantidad" name="cantidad" value="<%= linea.getCantidad() %>" min="1" onchange="calcularPrecioTotal()">
                    </div>
                    <% // Asignar los valores a variables JavaScript
                        int lineaId = linea.getId();
                        int codigoArticulo = linea.getArticulo().getCodigo();
                    %>
                    <button class="eliminar" type="button" onclick="eliminarProducto('<%= lineaId %>', '<%= codigoArticulo %>')">Eliminar</button>                   
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
    </body>
</html>
<%
    }
%>