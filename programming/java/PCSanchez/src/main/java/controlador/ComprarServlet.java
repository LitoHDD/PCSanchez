package controlador;

import dao.CestaDAO;
import dao.PedidoArticuloDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import dto.Cesta;
import dto.LineaCesta;
import dto.PedidoArticulo;
import dto.Pedido;
import dto.Usuario;
import dto.Direccion;
import dao.TarjetaDAO; // Agrega la importación del TarjetaDAO
import dto.Tarjeta;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComprarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Asume que el usuario está guardado en la sesión.
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Crear un nuevo PedidoArticulo por cada LineaCesta en la cesta.
        PedidoArticuloDAO pedidoArticuloDAO = new PedidoArticuloDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        CestaDAO cestaDAO = new CestaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        TarjetaDAO tarjetaDAO = new TarjetaDAO(); // Agrega la instancia del TarjetaDAO

        try {
            // Aquí asumimos que tienes un método en CestaDAO que obtiene la cesta de un usuario específico
            Cesta cesta = null;
            try {
                cesta = cestaDAO.getCestaPorUsuario(usuario.getCodigo());
            } catch (SQLException e) {
                // Gestionar la excepción, tal vez redirigiendo a una página de error.
                e.printStackTrace();
                response.sendRedirect("error.jsp");
                return;
            }

            // Verificar si el usuario tiene una tarjeta asignada
            boolean tieneTarjeta = false;
            try {
                Tarjeta tarjeta = tarjetaDAO.getByCodigoUsuario(usuario.getCodigo());
                if (tarjeta != null) {
                    tieneTarjeta = true;
                }
            } catch (SQLException e) {
                // Gestionar la excepción, tal vez redirigiendo a una página de error.
                e.printStackTrace();
                response.sendRedirect("error.jsp");
                return;
            }

            if (!tieneTarjeta) {
                // Redirigir al usuario a la página para agregar una tarjeta
                response.sendRedirect("agregar-tarjeta.jsp");
                return;
            }
            
            // Crear un nuevo Pedido y guardarlo en la base de datos
            Pedido pedido = new Pedido();
            // Añade aquí todos los detalles necesarios para el pedido
            pedido.setFacturado("N");
            pedido.setFechapedido(LocalDateTime.now());
            List<Direccion> direcciones = usuarioDAO.getDirecciones(usuario.getCodigo());
            pedido.setDirecciones(direcciones); // Establecer la lista de direcciones en el pedido
            pedido.setUsuario(usuario);
            // Agregar el pedido a la base de datos
            int numeroPedido = pedidoDAO.anyadir(pedido);
            System.out.println(numeroPedido);

            // Obtener las líneas de la cesta
            List<LineaCesta> lineasCesta = null;
            try {
                lineasCesta = cestaDAO.getLineas(cesta.getCodigo());
            } catch (SQLException e) {
                // Gestionar la excepción, tal vez redirigiendo a una página de error.
                e.printStackTrace();
                response.sendRedirect("error.jsp");
                return;
            }

            for (LineaCesta lineaCesta : lineasCesta) {
                PedidoArticulo pedidoArticulo = new PedidoArticulo();
                pedidoArticulo.setId(numeroPedido); // Establecer el número de pedido como el id del pedido
                pedidoArticulo.setArticulo(lineaCesta.getArticulo());
                pedidoArticulo.setCantidad(lineaCesta.getCantidad());
                pedidoArticulo.setPrecio(lineaCesta.getArticulo().getPrecio() * lineaCesta.getCantidad()); // Asumiendo que el precio está en el objeto Articulo

                int numRetries = 5;
                boolean pedidoArticuloAdded = false;
                do {
                    try {
                        pedidoArticuloDAO.anyadir(pedidoArticulo);
                        pedidoArticuloAdded = true;
                    } catch (SQLException e) {
                        numRetries--;
                        if (numRetries == 0) {
                            // Si ha agotado los reintento, redirige a una página de error.
                            e.printStackTrace();
                            response.sendRedirect("error2.jsp");
                            return;
                        }
                        // Espera un poco antes de intentarlo de nuevo
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            // Ignorar la excepción
                        }
                    }
                } while (!pedidoArticuloAdded);
            }
        } catch (SQLException e) {
            // Gestionar la excepción, tal vez redirigiendo a una página de error.
            e.printStackTrace();
            response.sendRedirect("error2.jsp");
            return;
        }

        // Después de crear el pedido, deberías limpiar la cesta.
        try {
            Cesta cesta = cestaDAO.getCestaPorUsuario(usuario.getCodigo());
            cestaDAO.eliminarLineas(cesta);
        } catch (SQLException e) {
            // Gestionar la excepción, tal vez redirigiendo a una página de error.
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        // Redirigir al usuario a una página de confirmación.
        response.sendRedirect("confirmacion.jsp");
    }
}
