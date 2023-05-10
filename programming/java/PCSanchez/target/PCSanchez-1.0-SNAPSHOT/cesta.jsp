<%@page import="dao.CestaDAO"%>
<%@page import="dto.LineaCesta"%>
<%@page import="dto.Cesta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%// Verificar si el usuario está logueado%>
<%if (session.getAttribute("loggedIn") == null || !((boolean) session.getAttribute("loggedIn"))) {%>
<%   response.sendRedirect("index.jsp");%>
<%} else {%>
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
    </head>
    <body>
        <header>
            <figure class="logo">
                <img src="./images/index/logo.png" alt="">
            </figure>
            <nav>
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">Ordenadores</a></li>
                    <li><a href="#">Componentes</a></li>
                    <li><a href="./privacy.html">Nosotros</a></li>
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
            <%
                CestaDAO prueba4 = new CestaDAO();

                ArrayList<Cesta> cestas = (ArrayList<Cesta>) session.getAttribute("cestas");

                for (Cesta cesta : cestas) {
                    ArrayList<LineaCesta> lineas = prueba4.getLineas(cesta.getNombre());

                    out.println("<h2>" + cesta.getNombre() + "</h2>");
            %>
            <section class="cesta">
                <% for (LineaCesta linea : lineas) {%>
                <article class="producto">
                    <figure class="producto-img">
                        <img src="<%=linea.getArticulo().getPathFoto()%>" alt="Producto">
                    </figure>
                    <div class="producto-info">
                        <h3><%=linea.getArticulo().getNombre()%></h3>
                        <p>Precio: <%=linea.getArticulo().getPrecio()%>€</p>
                        <label for="cantidad">Cantidad:</label>
                        <input type="number" id="cantidad" name="cantidad" value="<%=linea.getCantidad()%>" min="1" onchange="calcularPrecioTotal()">
                    </div>
                    <button class="eliminar" type="button">Eliminar</button>
                </article>
                <% } %>
            </section>
            <%}%>     
            <div class="resumen">
                <h3>Resumen de la compra</h3>
                <p id="precio-total">Total: 0,00€</p>
                <button type="button">Comprar</button>
            </div> 
        </main>
    </body>
</html>
<%}%>
