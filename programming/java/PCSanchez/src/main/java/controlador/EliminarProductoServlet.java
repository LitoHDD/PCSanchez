/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LineaCestaDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lineaIdParam = request.getParameter("lineaId");
        String codigoArticuloParam = request.getParameter("codigoArticulo");

        if (lineaIdParam != null && codigoArticuloParam != null) {
            int lineaId = Integer.parseInt(lineaIdParam);
            int codigoArticulo = Integer.parseInt(codigoArticuloParam);

            LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
            lineaCestaDAO.eliminarLineaProducto(lineaId, codigoArticulo);

            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
