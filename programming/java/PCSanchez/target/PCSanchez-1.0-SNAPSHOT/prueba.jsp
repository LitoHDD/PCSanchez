<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                    <li><a href="./index.html">Inicio</a></li>
                    <li><a href="./ordenadores.html">Ordenadores</a></li>
                    <li><a href="./componentes.html">Componentes</a></li>
                    <li><a href="./privacy.html">Privacidad</a></li>
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

        <section class="usuario">
            <button type="button" onclick="location.href='./register.html'">REGISTRARSE</button>
            <article>
                <a href="./login.html">ENTRAR</a>
            </article>
        </section>

<!--         EStANDO LOGUEADO -->

        <section class="usuario-logued">
            <figure class="foto-perfil">
                <a href="./usuario.html"><img src="./images/header/user-default.png" alt=""></a>
                <div class="logout-button">Cerrar Sesión</div>
            </figure>
            <figure>
                <a href="./cesta.html"><img src="./images/index/carro.png" alt=""></a>
            </figure>
        </section>

        <a href="./index.html" class="titulo-query">
            <h2>PC SANCHEZ</h2>
        </a>
        <a href="./usuario.html" class="user-query">
            <img src="./images/index/user.png" alt="">
        </a>
        
    </header>
    <main>
        <section class="slider">
            <ul>
                <li><video src="./content/slider/slider.mp4" autoplay loop></li>
                <li><img src="./content/slider/slider2.png" alt="slider1"></li>
            </ul>
        </section>
        <section class="componentes">
            <h2>COMPONENTES MÁS VENDIDOS</h2>
            <section>
                <article class="componente">
                    <figure>
                        <a href="./componentes.html#psu"><img src="https://www.xtrafondos.com/wallpapers/resized/estrellas-de-la-via-lactea-4047.jpg?s=large" alt="IMG"></a>
                    </figure>
                    <div>
                        <p>Alimentación</p>
                        <h4>65€</h4>
                    </div>
                </article>
            </section>
            <a href="./componentes.html">Ver mas</a>
        </section>

        <div class="marquee">
            <p class="marquee__content">Este es un texto que se desplaza de derecha a izquierda de manera infinita.</p>
        </div>            

        <section class="ordenadores">
            <h2>ORDENADORES DESTACADOS</h2>
            <section>
                <article class="ordenador">
                    <figure>
                        <a href="./ordenadores.html"><img src="https://www.xtrafondos.com/wallpapers/resized/estrellas-de-la-via-lactea-4047.jpg?s=large" alt="IMG"></a>
                    </figure>
                    <p>Portatil Lenovo OSD23</p>
                    <p class="price">893€</p>
                </article>
            </section>
            <a href="./componentes.html">Ver mas</a>
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
</body>
</html>
