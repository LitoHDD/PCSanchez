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

        long numeroTarjeta = Long.parseLong(request.getParameter("tarjeta"));

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");


        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setUsuario(usuario);


        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        try {
            tarjetaDAO.anyadir(tarjeta);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        response.sendRedirect("confirmacion-tarjeta.jsp");
    }

}
