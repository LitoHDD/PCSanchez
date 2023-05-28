<%-- 
    Document   : componentes
    Created on : May 24, 2023, 2:03:43 AM
    Author     : sergio
--%>

<%@page import="dao.ProcesadorDAO"%>
<%@page import="dto.Procesador"%>
<%@page import="dao.TarjetaGraficaDAO"%>
<%@page import="dto.TarjetaGrafica"%>
<%@page import="dao.AlmacenamientoDAO"%>
<%@page import="dto.Almacenamiento"%>
<%@page import="dto.Ram"%>
<%@page import="dao.RamDAO"%>
<%@page import="dto.PlacaBase"%>
<%@page import="dao.PlacaBaseDAO"%>
<%@page import="dto.Psu"%>
<%@page import="dao.PsuDAO"%>
<%@page import="dto.Caja"%>
<%@page import="dao.CajaDAO"%>
<%@page import="dao.RefrigeracionDAO"%>
<%@page import="dto.Refrigeracion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-ordenadores-componentes.css">
        <title>Componentes - PCSanchez</title>
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
            <!--         SIN ESTAR LOGEADO -->
            <% if (session.getAttribute("loggedIn") == null || !(boolean) session.getAttribute("loggedIn")) { %>
            <section class="usuario">
                <button type="button" onclick="location.href = './register.jsp'">REGISTRARSE</button>
                <article>
                    <a href="./login.jsp">ENTRAR</a>
                </article>
            </section>
            <% } %>
            <!--         EStANDO LOGUEADO -->
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
            <% }%>
            <a href="./index.html" class="titulo-query">
                <h2>PC SANCHEZ</h2>
            </a>
            <a href="./UsuarioViejo.html" class="user-query">
                <img src="./images/index/user.png" alt="">
            </a>

        </header>
        <div class="principal">
            <aside>
                <ul>
                    <li><a href="#refrigeracion">Refrigeración</a></li>
                    <li><a href="#caja">Caja</a></li>
                    <li><a href="#psu">Fuente de alimentación</a></li>
                    <li><a href="#motherboard">Placa base</a></li>
                    <li><a href="#ram">Memoria ram</a></li>
                    <li><a href="#almacenamiento">Almacenamiento</a></li>
                    <li><a href="#gpu">Tarjeta gráfica</a></li>
                    <li><a href="#cpu">Procesador</a></li>
                </ul>
            </aside>
            <main>
                <h1>Componentes</h1>
                <section class="categorias">
                    <div class="categoria" id="refrigeracion">
                        <h2>Refrigeración</h2>
                        <div class="productos">
                            <% RefrigeracionDAO refrigeracionDAO = new RefrigeracionDAO();
                                ArrayList<Refrigeracion> refrigeracion = refrigeracionDAO.getAll();
                                for (Refrigeracion componente : refrigeracion) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="caja">
                        <h2>Caja</h2>
                        <div class="productos">
                            <% CajaDAO cajaDAO = new CajaDAO();
                                ArrayList<Caja> caja = cajaDAO.getAll();
                                for (Caja componente : caja) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="psu">
                        <h2>Fuente de alimentación</h2>
                        <div class="productos">
                            <% PsuDAO psuDAO = new PsuDAO();
                                ArrayList<Psu> psu = psuDAO.getAll();
                                for (Psu componente : psu) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="motherboard">
                        <h2>Placa Base</h2>
                        <div class="productos">
                            <% PlacaBaseDAO placaBaseDAO = new PlacaBaseDAO();
                                ArrayList<PlacaBase> placaBase = placaBaseDAO.getAll();
                                for (PlacaBase componente : placaBase) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="ram">
                        <h2>Memoria Ram</h2>
                        <div class="productos">
                            <% RamDAO ramDAO = new RamDAO();
                                ArrayList<Ram> ram = ramDAO.getAll();
                                for (Ram componente : ram) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="almacenamiento">
                        <h2>Almacenamiento</h2>
                        <div class="productos">
                            <% AlmacenamientoDAO almacenamientoDAO = new AlmacenamientoDAO();
                                ArrayList<Almacenamiento> almacenamiento = almacenamientoDAO.getAll();
                                for (Almacenamiento componente : almacenamiento) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="gpu">
                        <h2>Tarjeta gráfica</h2>
                        <div class="productos">
                            <% TarjetaGraficaDAO tarjetaGraficaDAO = new TarjetaGraficaDAO();
                                ArrayList<TarjetaGrafica> tarjetaGrafica = tarjetaGraficaDAO.getAll();
                                for (TarjetaGrafica componente : tarjetaGrafica) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="cpu">
                        <h2>Procesador</h2>
                        <div class="productos">
                            <% ProcesadorDAO procesadorDAO = new ProcesadorDAO();
                                ArrayList<Procesador> procesador = procesadorDAO.getAll();
                                for (Procesador componente : procesador) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= componente.getCodigo()%>">
                                    <img src="<%= componente.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= componente.getNombre()%></h3>
                                <h2><%= componente.getPrecio()%>€</h2>
                            </article>
                            <% }%>
                        </div>
                    </div>
                </section>
            </main>
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
