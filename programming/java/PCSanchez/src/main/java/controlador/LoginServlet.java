/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.CestaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UsuarioDAO;
import dto.Cesta;
import dto.Usuario;

/**
 *
 * @author jrmd
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            // Hacemos uso de logica de negocio del bean (dto) como el método "validar()"
            Usuario usuario = new UsuarioDAO().validar(email, password);

            if (usuario != null) {
                // Si el login es OK guardamos el objeto de tipo "Usuario" en la sesión para poder recuperarlo más tarde.
                // Y tras esto redirigimos a "index.html"
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("username", usuario.getNombreCompleto()); // nombre es el atributo que contiene el nombre de usuario en tu objeto Usuario
                session.setAttribute("cestas", usuario.getCestas());
                session.setAttribute("loggedIn", true);
                response.sendRedirect("index.jsp");

            } else {
                // Si el login no es correcto, enviamos un atributo "error" a true a "login.jsp" para que muestre el error.
                request.setAttribute("error", true);
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR SQL");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
