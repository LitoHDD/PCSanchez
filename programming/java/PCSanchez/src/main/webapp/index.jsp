<%@page import="dto.Usuario"%>
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
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style.css">
        <title>INICIO - PCSanchez</title>
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
            <section class="slider">
                <ul>
                    <li><video src="./content/slider/slider.mp4" autoplay loop></li>
                    <li><img src="./content/slider/slider2.png" alt="slider1"></li>
                </ul>
            </section>
            <section class="componentes">
                <h2>COMPONENTES DESTACADOS</h2>
                <section>
                    <% ArrayList<String> componentes = new ArrayList<String>();
                        componentes.add("Alimentación");
                        componentes.add("Placa Base");
                        componentes.add("Ram");
                        componentes.add("Almacenamiento");
                        componentes.add("Procesador");
                        componentes.add("Tarjeta Gráfica");
                        Collections.shuffle(componentes);
                    %>
                    <% for (String componente : componentes) { %>
                    <% if (componente.equals("Alimentación")) { %>
                    <% PsuDAO alimentacionDAO = new PsuDAO();
                        ArrayList<Psu> alimentacion = alimentacionDAO.getAll();
                        Collections.shuffle(alimentacion);
                    %>
                    <% for (Psu producto : alimentacion) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="componente">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <h4><%= producto.getNombre()%></h4>
                            <h5 class="precio"><%= producto.getPrecio()%>€</h5>
                        </article></a>
                        <% } %>
                        <% } else if (componente.equals("Placa Base")) { %>
                        <% PlacaBaseDAO placaBaseDAO = new PlacaBaseDAO();
                            ArrayList<PlacaBase> placaBase = placaBaseDAO.getAll();
                            Collections.shuffle(placaBase);
                        %>
                        <% for (PlacaBase producto : placaBase) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="componente">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <h4><%= producto.getNombre()%></h4>
                            <h5 class="precio"><%= producto.getPrecio()%>€</h5>
                        </article></a>
                        <% } %>
                        <% } else if (componente.equals("Ram")) { %>
                        <% RamDAO ramDAO = new RamDAO();
                            ArrayList<Ram> ram = ramDAO.getAll();
                            Collections.shuffle(ram);
                        %>
                        <% for (Ram producto : ram) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="componente">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <h4><%= producto.getNombre()%></h4>
                            <h5 class="precio"><%= producto.getPrecio()%>€</h5>
                        </article></a>
                        <% } %>
                        <% } else if (componente.equals("Almacenamiento")) { %>
                        <% AlmacenamientoDAO almacenamientoDAO = new AlmacenamientoDAO();
                            ArrayList<Almacenamiento> almacenamiento = almacenamientoDAO.getAll();
                            Collections.shuffle(almacenamiento);
                        %>
                        <% for (Almacenamiento producto : almacenamiento) {%>
                    <article class="componente">
                        <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <h4><%= producto.getNombre()%></h4>
                            <h5 class="precio"><%= producto.getPrecio()%>€</h5>
                    </article></a>
                    <% } %>
                    <% } else if (componente.equals("Procesador")) { %>
                    <% ProcesadorDAO procesadorDAO = new ProcesadorDAO();
                        ArrayList<Procesador> procesador = procesadorDAO.getAll();
                        Collections.shuffle(procesador);
                    %>
                    <% for (Procesador producto : procesador) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="componente">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <h4><%= producto.getNombre()%></h4>
                            <h5 class="precio"><%= producto.getPrecio()%>€</h5>
                        </article></a>
                        <% } %>
                        <% } else if (componente.equals("Tarjeta Gráfica")) { %>
                        <% TarjetaGraficaDAO tarjetaGraficaDAO = new TarjetaGraficaDAO();
                            ArrayList<TarjetaGrafica> tarjetaGrafica = tarjetaGraficaDAO.getAll();
                            Collections.shuffle(tarjetaGrafica);
                        %>
                        <% for (TarjetaGrafica producto : tarjetaGrafica) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="componente">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <h4><%= producto.getNombre()%></h4>
                            <h5 class="precio"><%= producto.getPrecio()%>€</h5>
                        </article></a>
                        <% } %>
                        <% } %>
                        <% }%>
                </section>
                <a href="./componentes.jsp">Ver mas</a>
            </section>
            <div class="marquee">
                <p class="marquee__content">Todos nuestros productos a la mitad de precio. Echale un vistazo a nuestras super ofertas.</p>
            </div>
            <section class="ordenadores">
                <h2>ORDENADORES DESTACADOS</h2>
                <section>
                    <% PortatilDAO portatilDAO = new PortatilDAO();
                        ArrayList<Portatil> portatiles = portatilDAO.getAll();
                        Collections.shuffle(portatiles);
                    %>
                    <% SobremesaDAO sobremesaDAO = new SobremesaDAO();
                        ArrayList<Sobremesa> sobremesas = sobremesaDAO.getAll();
                        Collections.shuffle(sobremesas);
                    %>
                    <% for (Sobremesa producto : sobremesas) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="ordenador">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <p class="name-pc"><%= producto.getNombre()%></p>
                            <p class="precio"><%= producto.getPrecio()%>€</p>
                        </article></a>
                        <% }%>
                        <% for (Portatil producto : portatiles) {%>
                    <a href="./producto.jsp?codigo=<%= producto.getCodigo()%>"><article class="ordenador">
                            <figure>
                                <img src="<%= producto.getPathFoto()%>" alt="IMG">
                            </figure>
                            <p class="name-pc"><%= producto.getNombre()%></p>
                            <p class="precio"><%= producto.getPrecio()%>€</p>
                        </article></a>
                        <% }%>
                </section>
                <a href="./componentes.jsp">Ver mas</a>
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
</html>