package controlador;

import dao.ArticuloDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LineaCestaDAO;
import dto.Articulo;
import dto.LineaCesta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

public class AgregarAlCarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codigoArticuloParam = request.getParameter("codigoArticulo");
        String idCestaParam = request.getParameter("idCesta");
        String precioParam = request.getParameter("precio");
        String cantidadParam = request.getParameter("cantidad");
        
        System.out.println(codigoArticuloParam);
        System.out.println(idCestaParam);
        System.out.println(precioParam);
        System.out.println(cantidadParam);

        if (codigoArticuloParam == null || idCestaParam == null || precioParam == null || cantidadParam == null) {
            // Manejar el caso de parámetros faltantes
            response.sendRedirect("productos.jsp");
            return;
        }

        int codigoArticulo = Integer.parseInt(codigoArticuloParam);
        int idCesta = Integer.parseInt(idCestaParam);
        double precio = Double.parseDouble(precioParam);
        int cantidad = Integer.parseInt(cantidadParam);

        ArticuloDAO articuloDAO = new ArticuloDAO();
        Articulo articulo = null;
        try {
            articulo = articuloDAO.getByCodigo(codigoArticulo);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarAlCarritoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Crear una instancia de LineaCesta con los datos recibidos
        LineaCesta lineaCesta = new LineaCesta();
        lineaCesta.setArticulo(articulo);
        lineaCesta.setId(idCesta);
        lineaCesta.setPrecio(precio);
        lineaCesta.setCantidad(cantidad);

        // Agregar la línea de cesta utilizando el LineaCestaDAO
        LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
        try {
            lineaCestaDAO.anyadir(lineaCesta);
            System.out.println("Se ha agregado la línea de cesta con éxito");
        } catch (SQLException ex) {
            System.out.println("Error al agregar la línea de cesta: " + ex.getMessage());
        }

        // Redireccionar a la página de productos o al carrito de compras
        HttpSession session = request.getSession();
        System.out.println("Valor de loggedIn: " + session.getAttribute("loggedIn"));
        if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
            response.sendRedirect("cesta.jsp");
        } else {
            System.out.println("Valor de loggedIn: " + session.getAttribute("loggedIn"));
            response.sendRedirect("productos.jsp");
        }
    }
}
