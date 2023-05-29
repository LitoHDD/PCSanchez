/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticuloDAO;
import dto.Articulo;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/search")
public class BuscarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String query = request.getParameter("query");
    String categoria = request.getParameter("categoria");
    ArticuloDAO articuloDAO = new ArticuloDAO();
    List<Articulo> results = new ArrayList<>();

    try {
        if (categoria != null && !categoria.isEmpty()) {
            results = articuloDAO.getByCategoria(categoria);
        } else if (query != null && !query.isEmpty()) {
            results = articuloDAO.getByNombreParcial(query);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    request.setAttribute("results", results);
    request.getRequestDispatcher("resultados.jsp").forward(request, response);
}

}
