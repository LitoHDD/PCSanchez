<%-- 
    Document   : index
    Created on : May 9, 2023, 12:02:39 AM
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style.css">
        <title>INICIO - PCSanchez</title>
    </head>
    <body>
        <header>
            <section class="headerSuperior">
                <div class="contenidoHeaderSuperior">
                    <section class="logo">
                        <figure>
                            <a href="./index.html"><img src="./images/index/logo.png" alt="logotipo"></a>
                        </figure>
                    </section>
                    <nav>
                        <ul class="menu">
                            <li><a href="./index.html">INICIO</a></li>
                            <li><a href="#">ORDENADORES</a></li>
                            <li><a href="#">COMPONENTES</a></li>
                            <li><a href="./privacy.html">SOBRE NOSOTROS</a></li>

                        </ul>
                    </nav>
                    <section>
                        <form>
                            <input class="buscar" type="search" name="search" placeholder="Buscar en tienda...">
                            <button type="submit"><img src="./images/index/lupa.png" alt="lupa"></button>
                        </form>
                    </section>                   
                    <% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {%>
                    <section class="usuario">
                        <section>
                            <form action="LogoutServlet" method="post">
                                <button id="logout" type="submit">Cerrar sesión</button>
                            </form>
                        </section>
                        <section>
                            <p>Bienvenido, <%= session.getAttribute("username") %>!</p>
                        </section>
                    </section>    
                    <% } else { %>
                    <section class="usuario">
                        <section>
                            <a href="./register.jsp" id="registrarse">REGISTRARSE</a>
                        </section>
                        <section>
                            <a href="./login.jsp" id="entrar">ENTRAR</a>
                        </section>
                    </section>
                    <% }%>
                    <figure class="carrito">
                        <img src="./images/index/carro.png" alt="carrito">
                    </figure>
                </div>
            </section>
        </header> 
        <div class="general">
            <section class="slider">
                <ul>
                    <li><video src="./content/slider/slider.mp4" autoplay loop></li>
                    <li><img src="./content/slider/slider2.png" alt="slider1"></li>
                </ul>
            </section>
            <section class="componentes">
                <h2>COMPONENTES</h2>
                <section>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Alimentación</h4>
                    </article>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Placa Base</h4>
                    </article>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Ram</h4>
                    </article>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Disco Duro</h4>
                    </article>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Procesador</h4>
                    </article>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Tarjeta Grafica</h4>
                    </article>
                    <article class="componente">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/components/procesador.png" alt="IMG"></a>
                        </figure>
                        <h4>Caja</h4>
                    </article>
                </section>
            </section>
            <section class="ordenadores">
                <h2>ORDENADORES</h2>
                <section>
                    <article class="ordenador">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/hardware/pcverde.png" alt="IMG"></a>
                        </figure>
                    </article>
                    <article class="ordenador">
                        <figure>
                            <a href="./producto.html"><img src="./images/index/hardware/laptopverde.png" alt="IMG"></a>
                        </figure>
                    </article>
                    <article class="ordenador">
                        <figure>
                            <a href=""><img src="./images/index/hardware/all-in-one.png" alt="IMG" id="all-in-one"></a>
                        </figure>
                    </article>
                </section>
            </section>
        </div>
        <footer>
            <section>
                <a id="img-footer" href="./index.html"><img id="logo-footer" src="./images/footer/logo-footer2.png"></a>
                <a href="./index.html" class="text-footer">INICIO</a>
                <a href="./mantenimiento.html" class="text-footer">ORDENADORES</a>
                <a href="./mantenimiento.html" class="text-footer">COMPONENTES</a>
                <a href="./mantenimiento.html" class="text-footer">SOBRE NOSOTROS</a>
                <a href="https://iespacomolla.es/"><img id="logo-footer" src="./images/footer/logo-footer.png"></a>
            </section>
        </footer>
    </body>
</html>
