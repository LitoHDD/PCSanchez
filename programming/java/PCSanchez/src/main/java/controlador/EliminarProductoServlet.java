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
        // Obtener el ID de la línea y el código de artículo a eliminar
        String lineaIdParam = request.getParameter("lineaId");
        String codigoArticuloParam = request.getParameter("codigoArticulo");
        // Verificar si los parámetros son válidos
        if (lineaIdParam != null && codigoArticuloParam != null) {
            int lineaId = Integer.parseInt(lineaIdParam);
            int codigoArticulo = Integer.parseInt(codigoArticuloParam);

            // Lógica para eliminar el producto utilizando el ID de línea y código de artículo
            LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
            lineaCestaDAO.eliminarLineaProducto(lineaId, codigoArticulo);

            // Establecer el estado de la respuesta como "OK" (200)
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
