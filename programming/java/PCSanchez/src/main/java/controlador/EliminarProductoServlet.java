/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LineaCestaDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eliminar")
public class EliminarProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del producto a eliminar
        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);

        // Lógica para eliminar el producto de la base de datos
        LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
        lineaCestaDAO.eliminarLineaProducto(id);

        // Establecer el estado de la respuesta como "OK" (200)
        response.setStatus(HttpServletResponse.SC_OK);
    }
}