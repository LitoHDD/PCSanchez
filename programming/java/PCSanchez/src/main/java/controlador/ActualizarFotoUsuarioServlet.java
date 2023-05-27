package controlador;

import dao.UsuarioDAO;
import dto.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActualizarFotoUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entrando al servlet ActualizarFotoUsuarioServlet...");

        HttpSession session = request.getSession();
        String photoUrl = request.getParameter("photoUrl");

        System.out.println("URL de la foto recibida: " + photoUrl);

        if (session.getAttribute("usuario") != null) {
            Usuario user = (Usuario) session.getAttribute("usuario");
            UsuarioDAO usuarioDao = new UsuarioDAO();

            System.out.println("Usuario identificado, actualizando foto...");

            usuarioDao.actualizarFoto(photoUrl, user.getCodigo());
            user.setFoto(photoUrl);
            session.setAttribute("usuario", user);
        } else {
            System.out.println("Usuario no autenticado, redirigiendo a la página de inicio de sesión...");
            response.sendRedirect("login.jsp");
            return;
        }

        System.out.println("Foto actualizada correctamente, redirigiendo de vuelta a usuario.jsp...");
        response.sendRedirect("usuario.jsp");
    }
}
