<%-- 
    Document   : agregar-tarjeta
    Created on : May 26, 2023, 7:53:01 PM
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Tarjeta</title>
</head>
<body>
    <h2>Agregar Tarjeta</h2>
    <form method="POST" action="AgregarTarjetaServlet">
        <label for="numero">Número de Tarjeta:</label>
        <input type="text" id="numero" name="numero" required><br>
        <!-- Otros campos del formulario -->
        <button type="submit">Agregar Tarjeta</button>
    </form>
</body>
</html>
