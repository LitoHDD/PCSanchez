<%-- 
    Document   : confirmacion-tarjeta
    Created on : May 26, 2023, 7:56:10 PM
    Author     : sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Confirmación de Tarjeta</title>
    </head>
    <body>
        <h2>Tarjeta Agregada</h2>
        <p>La tarjeta ha sido agregada exitosamente.</p>
        <script>
            // Esperar 2 segundos (ajusta el valor según tus necesidades)
            setTimeout(function () {
                window.location.href = "cesta.jsp";
            }, 2000);
        </script>
    </body>
</html>