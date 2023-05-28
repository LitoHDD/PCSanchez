/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.TarjetaDAO;
import dto.Tarjeta;
import dto.Usuario;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AgregarTarjetaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        long numeroTarjeta = Long.parseLong(request.getParameter("tarjeta"));
        // Obtener el usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Crear un objeto Tarjeta
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setUsuario(usuario);

        // Guardar la tarjeta en la base de datos
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        try {
            tarjetaDAO.anyadir(tarjeta);
        } catch (SQLException e) {
            // Gestionar la excepción, tal vez redirigiendo a una página de error.
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        // Redirigir al usuario a la página de confirmación
        response.sendRedirect("confirmacion-tarjeta.jsp");
    }

}
