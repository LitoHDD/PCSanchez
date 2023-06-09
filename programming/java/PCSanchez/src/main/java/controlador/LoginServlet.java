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
import org.mindrot.jbcrypt.BCrypt;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            String salt = "$2a$10$ABCDEFGHIJKLMNOPQRSTUV";
            String hashedPassword = BCrypt.hashpw(password, salt);
    
            Usuario usuario = new UsuarioDAO().validar(email, hashedPassword);

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("username", usuario.getNombreCompleto());
                session.setAttribute("cestas", usuario.getCestas());
                session.setAttribute("loggedIn", true);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", true);
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR SQL");
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
