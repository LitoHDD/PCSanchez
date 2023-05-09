package controlador;

import dao.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fecha-nacimiento");
        boolean aceptaPolitica = request.getParameter("privacy-policy") != null;
        String rutaFoto = "Sin foto";
        String tipoUsuario = "CLIENTE";

        // Validación de datos
        if (nombre == null || nombre.isEmpty() || email == null || email.isEmpty() || password == null
                || password.isEmpty() || passwordConfirm == null || passwordConfirm.isEmpty()
                || fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            response.sendRedirect("register.jsp?error=invalidData");
            return;
        }

        if (telefono.length() != 9) {
            response.sendRedirect("register.jsp?error=phone");
            return;
        }

        if (!aceptaPolitica) {
            response.sendRedirect("register.jsp?error=policy");
            return;
        }

        if (!password.equals(passwordConfirm)) {
            response.sendRedirect("register.jsp?error=passwordsDoNotMatch");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoDate;
        try {
            fechaNacimientoDate = sdf.parse(fechaNacimiento);
        } catch (ParseException e) {
            response.sendRedirect("register.jsp?error=invalidDate");
            return;
        }

        // Conexión a la base de datos
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion().getDatasource().getConnection();

            // Verificar si el usuario ya está registrado
            String query = "SELECT email FROM ps_usuario WHERE email = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                response.sendRedirect("register.jsp?error=userAlreadyExists");
                return;
            }

            // Obtener el último código de usuario
            ps = conn.prepareStatement("SELECT codigo FROM ps_usuario WHERE codigo = (SELECT MAX(codigo) FROM ps_usuario)");
            rs = ps.executeQuery();

            if (rs.next()) {
                int ultimoCodigo = rs.getInt("codigo");
                int nuevoCodigo = ultimoCodigo + 1;

                // Inserción del usuario en la base de datos
                ps = conn.prepareStatement("INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipousuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, nuevoCodigo);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, nombre);
                ps.setString(5, rutaFoto);
                ps.setString(6, telefono);
                ps.setDate(7, new java.sql.Date(fechaNacimientoDate.getTime()));
                ps.setString(8, tipoUsuario);

                ps.executeUpdate();
                ps.close();

                // Redirección a la página de inicio de sesión
                response.sendRedirect("login.jsp?success=true");
            } else {
                // La tabla está vacía, así que el primer código será 5001
                int nuevoCodigo = 5001;

                // Inserción del usuario en la base de datos
                ps = conn.prepareStatement(
                        "INSERT INTO ps_usuario (codigo, email, pass, nombre_comp, foto, telefono, fecha_nacimiento, tipousuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, nuevoCodigo);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, nombre);
                ps.setString(5, rutaFoto);
                ps.setString(6, telefono);
                ps.setDate(7, new java.sql.Date(fechaNacimientoDate.getTime()));
                ps.setString(8, tipoUsuario);

                ps.executeUpdate();
                ps.close();

                // Redirección a la página de inicio de sesión
                response.sendRedirect("login.jsp?success=true");
            }
        } catch (SQLException e) {
            // Si hay un error en la base de datos, redirigimos a la página de registro con un mensaje de error
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=databaseError");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
