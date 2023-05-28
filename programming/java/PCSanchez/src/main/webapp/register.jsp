<%-- 
Document   : register
Created on : May 9, 2023, 1:51:35 AM
Author     : sergio
--%>

<%@page import="dto.Usuario"%>
<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Importamos la librería JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Código HTML de la página --%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-register.css">
        <title>LOG IN - PCSanchez</title>
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
            <%-- Verificar si el usuario ha iniciado sesión --%>
            <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { %>
            <%-- Redirigir a la página principal si el usuario ha iniciado sesión --%>
            <% response.sendRedirect("index.jsp"); %>
            <% } else { %>
            <% if (request.getParameter("error") != null) { %>
            <div class="alert alert-danger">
                <% if ("invalidData".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Los datos proporcionados son inválidos.</center>
                </div>
                <% } else if ("passwordsDoNotMatch".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Las contraseñas no coinciden.</center>
                </div>
                <% } else if ("invalidDate".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>La fecha de nacimiento es inválida.</center>
                </div>
                <% } else if ("userAlreadyExists".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Ya existe un usuario con este correo electrónico.</center>
                </div>
                <% } else if ("databaseError".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Ha ocurrido un error al conectar con la base de datos.</center>
                </div>
                <% } else if ("policy".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Acepta la política de privacidad antes de completar el registro.</center>
                </div>
                <% } else if ("phone".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Introduce un número de teléfono correcto.</center>
                </div>
                <% } else if ("address".equals(request.getParameter("error"))) { %>
                <div class="fondo-rojo">
                    <center>Introduce una dirección correcta.</center>
                </div>
                <% } %>
            </div>
            <% }%>
            <h2>REGISTRO</h2>
            <section class="registro">
                <form method="post" action="RegisterServlet">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" autocomplete="on" placeholder="Introduzca su nombre">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" autocomplete="on" placeholder="Introduzca su correo electrónico">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" autocomplete="off" placeholder="Introduzca su contraseña">
                    <label for="password-confirm">Confirmar contraseña:</label>
                    <input type="password" id="password-confirm" name="password-confirm" autocomplete="off" placeholder="Confirme su contraseña">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono" autocomplete="on" placeholder="Introduzca su teléfono">
                    <label for="fecha-nacimiento">Fecha de nacimiento:</label>
                    <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" autocomplete="on" placeholder="Seleccione su fecha de nacimiento">
                    <label for="tipo-via">Tipo de vía:</label>
                    <select id="tipo-via" name="tipo-via">
                        <option value="">--Por favor elija--</option>
                        <option value="Calle">Calle</option>
                        <option value="Avenida">Avenida</option>
                        <option value="Plaza">Plaza</option>
                        <option value="Carretera">Carretera</option>
                    </select>
                    <label for="direccion">Dirección:</label>
                    <input type="text" id="direccion" name="direccion" autocomplete="on" placeholder="Linea de direccion única">
                    <label for="provincia">Provincia:</label>
                    <select id="provincia" name="provincia">
                        <option value="">--Por favor elija--</option>
                        <option value="A-coruna">A Coruña</option>
                        <option value="Alava">Álava</option>
                        <option value="Albacete">Albacete</option>
                        <option value="Alicante">Alicante</option>
                        <option value="Almeria">Almería</option>
                        <option value="Asturias">Asturias</option>
                        <option value="Avila">Ávila</option>
                        <option value="Badajoz">Badajoz</option>
                        <option value="Baleares">Baleares</option>
                        <option value="Barcelona">Barcelona</option>
                        <option value="Burgos">Burgos</option>
                        <option value="Caceres">Cáceres</option>
                        <option value="Cadiz">Cádiz</option>
                        <option value="Cantabria">Cantabria</option>
                        <option value="Castellon">Castellón</option>
                        <option value="Ciudad-real">Ciudad Real</option>
                        <option value="Cordoba">Córdoba</option>
                        <option value="Cuenca">Cuenca</option>
                        <option value="Girona">Girona</option>
                        <option value="Granada">Granada</option>
                        <option value="Guadalajara">Guadalajara</option>
                        <option value="Gipuzkoa">Gipuzkoa</option>
                        <option value="Huelva">Huelva</option>
                        <option value="Huesca">Huesca</option>
                        <option value="Jaen">Jaén</option>
                        <option value="La-rioja">La Rioja</option>
                        <option value="Las-palmas">Las Palmas</option>
                        <option value="Leon">León</option>
                        <option value="Lerida">Lérida</option>
                        <option value="Lugo">Lugo</option>
                        <option value="Madrid">Madrid</option>
                        <option value="Malaga">Málaga</option>
                        <option value="Murcia">Murcia</option>
                        <option value="Navarra">Navarra</option>
                        <option value="Ourense">Ourense</option>
                        <option value="Palencia">Palencia</option>
                        <option value="Pontevedra">Pontevedra</option>
                        <option value="Salamanca">Salamanca</option>
                        <option value="Segovia">Segovia</option>
                        <option value="Sevilla">Sevilla</option>
                        <option value="Soria">Soria</option>
                        <option value="Tarragona">Tarragona</option>
                        <option value="Santa-cruz-de-tenerife">Santa Cruz de Tenerife</option>
                        <option value="Teruel">Teruel</option>
                        <option value="Toledo">Toledo</option>
                        <option value="Valencia">Valencia</option>
                        <option value="Valladolid">Valladolid</option>
                        <option value="Vizcaya">Vizcaya</option>
                        <option value="Zamora">Zamora</option>
                        <option value="Zaragoza">Zaragoza</option>
                    </select>
                    <label for="ciudad">Ciudad:</label>
                    <input type="text" id="ciudad" name="ciudad" autocomplete="on" placeholder="Introduce tu ciudad">
                    <section class="privacy">
                        <input type="checkbox" id="privacy-policy" name="privacy-policy">
                        <label for="privacy-policy">He leído y acepto la <a href="./PrivacyViejo.html">política de privacidad</a>.</label>
                    </section>
                    <button type="submit">REGISTRARSE</button>
                </form>
            </section>
            <% }%>
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
    <script src="js/autocompletar.js"></script>
    <script src="js/buscar-categorias.js"></script>
</html>