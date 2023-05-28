<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.PortatilDAO" %>
<%@ page import="dto.Portatil" %>
<%@ page import="dao.SobremesaDAO" %>
<%@ page import="dto.Sobremesa" %>
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
        <title>Ordenadores - PCSanchez</title>
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
                    <li><a href="#portatil">Portátil</a></li>
                    <li><a href="#sobremesa">Sobremesa</a></li>
                </ul>
            </aside>
            <main>
                <h1>Ordenadores</h1>
                <section class="categorias">
                    <div class="categoria" id="portatil">
                        <h2>Portátiles</h2>
                        <div class="productos">
                            <% PortatilDAO portatilDAO = new PortatilDAO();
                                ArrayList<Portatil> portatiles = portatilDAO.getAll();
                                for (Portatil portatil : portatiles) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= portatil.getCodigo()%>">
                                    <img src="<%= portatil.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= portatil.getNombre()%></h3>
                                <h2><%= portatil.getPrecio()%>€</h2>
                            </article>
                            <% } %>
                        </div>
                    </div>
                    <div class="categoria" id="sobremesa">
                        <h2>Sobremesa</h2>
                        <div class="productos">
                            <% SobremesaDAO sobremesaDAO = new SobremesaDAO();
                                ArrayList<Sobremesa> sobremesas = sobremesaDAO.getAll();
                                for (Sobremesa sobremesa : sobremesas) {%>
                            <article class="producto">
                                <a href="./producto.jsp?codigo=<%= sobremesa.getCodigo()%>">
                                    <img src="<%= sobremesa.getPathFoto()%>" alt="Foto del producto">
                                </a>
                                <h3><%= sobremesa.getNombre()%></h3>
                                <h2><%= sobremesa.getPrecio()%>€</h2>
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