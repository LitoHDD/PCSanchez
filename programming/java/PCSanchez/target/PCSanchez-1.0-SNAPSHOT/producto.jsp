<%-- 
    Document   : producto
    Created on : May 24, 2023, 12:40:34 AM
    Author     : sergio
--%>

<%@page import="dto.Almacenamiento"%>
<%@page import="dao.AlmacenamientoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.PortatilDAO" %>
<%@ page import="dao.SobremesaDAO" %>
<%@ page import="dao.CajaDAO" %>
<%@ page import="dao.PlacaBaseDAO" %>
<%@ page import="dao.ProcesadorDAO" %>
<%@ page import="dao.PsuDAO" %>
<%@ page import="dao.RamDAO" %>
<%@ page import="dao.RefrigeracionDAO" %>
<%@ page import="dao.TarjetaGraficaDAO" %>
<%@ page import="dto.Portatil" %>
<%@ page import="dto.Sobremesa" %>
<%@ page import="dto.Caja" %>
<%@ page import="dto.PlacaBase" %>
<%@ page import="dto.Procesador" %>
<%@ page import="dto.Psu" %>
<%@ page import="dto.Ram" %>
<%@ page import="dto.Refrigeracion" %>
<%@ page import="dto.TarjetaGrafica" %>
<%
    int codigoArticulo = Integer.parseInt(request.getParameter("codigo"));

    SobremesaDAO sobremesaDAO = new SobremesaDAO();
    Sobremesa sobremesa = sobremesaDAO.getByCodigo(codigoArticulo);

    PortatilDAO portatilDAO = new PortatilDAO();
    Portatil portatil = portatilDAO.getByCodigo(codigoArticulo);

    CajaDAO cajaDAO = new CajaDAO();
    Caja caja = cajaDAO.getByCodigo(codigoArticulo);

    PlacaBaseDAO placaBaseDAO = new PlacaBaseDAO();
    PlacaBase placaBase = placaBaseDAO.getByCodigo(codigoArticulo);

    ProcesadorDAO procesadorDAO = new ProcesadorDAO();
    Procesador procesador = procesadorDAO.getByCodigo(codigoArticulo);

    PsuDAO psuDAO = new PsuDAO();
    Psu psu = psuDAO.getByCodigo(codigoArticulo);

    RamDAO ramDAO = new RamDAO();
    Ram ram = ramDAO.getByCodigo(codigoArticulo);

    RefrigeracionDAO refrigeracionDAO = new RefrigeracionDAO();
    Refrigeracion refrigeracion = refrigeracionDAO.getByCodigo(codigoArticulo);

    TarjetaGraficaDAO tarjetaGraficaDAO = new TarjetaGraficaDAO();
    TarjetaGrafica tarjetaGrafica = tarjetaGraficaDAO.getByCodigo(codigoArticulo);

    AlmacenamientoDAO almacenamientoDAO = new AlmacenamientoDAO();
    Almacenamiento almacenamiento = almacenamientoDAO.getByCodigo(codigoArticulo);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/style-producto.css">
        <title>Producto</title>
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
        </header>
        <div class="general">
            <section class="producto">
                <figure class="foto">
                    <img src="<%= (portatil != null) ? portatil.getPathFoto() : (sobremesa != null) ? sobremesa.getPathFoto() : (caja != null) ? caja.getPathFoto() : (placaBase != null) ? placaBase.getPathFoto() : (procesador != null) ? procesador.getPathFoto() : (psu != null) ? psu.getPathFoto() : (ram != null) ? ram.getPathFoto() : (refrigeracion != null) ? refrigeracion.getPathFoto() : (tarjetaGrafica != null) ? tarjetaGrafica.getPathFoto() : almacenamiento.getPathFoto()%>" alt="Foto del producto">
                </figure>
                <section class="comprar">
                    <h2><%= (portatil != null) ? portatil.getNombre() : (sobremesa != null) ? sobremesa.getNombre() : (caja != null) ? caja.getNombre() : (placaBase != null) ? placaBase.getNombre() : (procesador != null) ? procesador.getNombre() : (psu != null) ? psu.getNombre() : (ram != null) ? ram.getNombre() : (refrigeracion != null) ? refrigeracion.getNombre() : (tarjetaGrafica != null) ? tarjetaGrafica.getNombre() : almacenamiento.getNombre()%></h2>
                    <h3><%= (portatil != null) ? portatil.getPrecio() : (sobremesa != null) ? sobremesa.getPrecio() : (caja != null) ? caja.getPrecio() : (placaBase != null) ? placaBase.getPrecio() : (procesador != null) ? procesador.getPrecio() : (psu != null) ? psu.getPrecio() : (ram != null) ? ram.getPrecio() : (refrigeracion != null) ? refrigeracion.getPrecio() : (tarjetaGrafica != null) ? tarjetaGrafica.getPrecio() : almacenamiento.getPrecio()%></h3>
                    <section class="pedido">
                        <ul class="negrita">
                            <li><strong>MARCA:</strong></li>
                            <li><strong>ENVÍO:</strong></li>
                            <li><strong>DEVOLUCIÓN:</strong></li>
                            <li><strong>CANTIDAD:</strong></li>
                        </ul>
                        <ul class="datos">
                            <li><%= (portatil != null) ? portatil.getNombre() : (sobremesa != null) ? sobremesa.getNombre() : (caja != null) ? caja.getNombre() : (placaBase != null) ? placaBase.getNombre() : (procesador != null) ? procesador.getNombre() : (psu != null) ? psu.getNombre() : (ram != null) ? ram.getNombre() : (refrigeracion != null) ? refrigeracion.getNombre() : (tarjetaGrafica != null) ? tarjetaGrafica.getNombre() : almacenamiento.getNombre()%></li>
                            <li>Gratis-24h</li>
                            <li>Gratis</li>
                            <li><input id="number" type="number" value="1" /></li>
                        </ul>
                    </section>
                    <section class="buy">
                        <section class="buy-comprar"> 
                            <a href="#" id="buy">AÑADIR AL CARRITO</a>
                        </section>
                    </section> 
                </section>
            </section>
            <section class="descripcion">
                <h3>DESCRIPCION</h3>
                <% if (portatil != null) {%>
                <p><%= portatil.getDescripcion()%></p>
                <% } else if (sobremesa != null) {%>
                <p><%= sobremesa.getDescripcion()%></p>
                <% } else if (caja != null) {%>
                <p><%= caja.getDescripcion()%></p>
                <% } else if (placaBase != null) {%>
                <p><%= placaBase.getDescripcion()%></p>
                <% } else if (procesador != null) {%>
                <p><%= procesador.getDescripcion()%></p>
                <% } else if (psu != null) {%>
                <p><%= psu.getDescripcion()%></p>
                <% } else if (ram != null) {%>
                <p><%= ram.getDescripcion()%></p>
                <% } else if (refrigeracion != null) {%>
                <p><%= refrigeracion.getDescripcion()%></p>
                <% } else if (tarjetaGrafica != null) {%>
                <p><%= tarjetaGrafica.getDescripcion()%></p>
                <% } else if (almacenamiento != null) {%>
                <p><%= almacenamiento.getDescripcion()%></p>
                <% } %>
            </section>
            <section class="especificaciones">
                <h3>ESPECIFICACIONES</h3>
                <table>
                    <% if (portatil != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Capacidad de la memoria RAM</strong></td>
                        <td><%= portatil.getCapacidadRamGB()%> GB</td>
                    </tr>
                    <% } else if (sobremesa != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Tipo</strong></td>
                        <td><%= sobremesa.getTipo()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Capacidad de la memoria RAM</strong></td>
                        <td><%= sobremesa.getCapacidadRamGb()%> GB</td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Almacenamiento</strong></td>
                        <td><%= sobremesa.getAlmacenamientoGb()%> GB</td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Sistema operativo</strong></td>
                        <td><%= sobremesa.getSistemaOperativo()%></td>
                    </tr>
                    <% } else if (caja != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Conexión</strong></td>
                        <td><%= caja.getConexion()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Color</strong></td>
                        <td><%= caja.getColor()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Tamaño en litros</strong></td>
                        <td><%= caja.getSizeLitros()%> L</td>
                    </tr>
                    <% } else if (placaBase != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Tipo</strong></td>
                        <td><%= placaBase.getType()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Socket</strong></td>
                        <td><%= placaBase.getSocket()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Chipset</strong></td>
                        <td><%= placaBase.getChipset()%></td>
                    </tr>
                    <% } else if (procesador != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Socket</strong></td>
                        <td><%= procesador.getSocket()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Familia</strong></td>
                        <td><%= procesador.getFamilia()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Frecuencia (GHz)</strong></td>
                        <td><%= procesador.getFrecuenciaGhz()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Generación</strong></td>
                        <td><%= procesador.getGeneracion()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Núcleos</strong></td>
                        <td><%= procesador.getNucleos()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Hilos</strong></td>
                        <td><%= procesador.getHilos()%></td>
                    </tr>
                    <% } else if (psu != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Potencia (W)</strong></td>
                        <td><%= psu.getPotenciaW()%> W</td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Certificado</strong></td>
                        <td><%= psu.getCertificado()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Modular</strong></td>
                        <td><%= psu.getModular()%></td>
                    </tr>
                    <% } else if (ram != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Capacidad (GB)</strong></td>
                        <td><%= ram.getCapacidadGB()%> GB</td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Frecuencia (MHz)</strong></td>
                        <td><%= ram.getFrecuenciaMhz()%> MHz</td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Tipo</strong></td>
                        <td><%= ram.getTipo()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Perfil XMP</strong></td>
                        <td><%= ram.getPerfilXmp()%></td>
                    </tr>
                    <% } else if (refrigeracion != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Tipo</strong></td>
                        <td><%= refrigeracion.getTipo()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Socket</strong></td>
                        <td><%= refrigeracion.getSocket()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Tamaño</strong></td>
                        <td><%= refrigeracion.getTamaño()%> cm</td>
                    </tr>
                    <% } else if (tarjetaGrafica != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Arquitectura</strong></td>
                        <td><%= tarjetaGrafica.getArquitectura()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>VRAM (GB)</strong></td>
                        <td><%= tarjetaGrafica.getvRamGb()%> GB</td>
                    </tr>
                    <% } else if (almacenamiento != null) {%>
                    <tr>
                        <td class="especificacion"><strong>Tipo</strong></td>
                        <td><%= almacenamiento.getTipo()%></td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Capacidad</strong></td>
                        <td><%= almacenamiento.getCapacidadGb()%> GB</td>
                    </tr>
                    <tr>
                        <td class="especificacion"><strong>Conexión</strong></td>
                        <td><%= almacenamiento.getConexion()%></td>
                    </tr>
                    <% }%>
                </table>
            </section>
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