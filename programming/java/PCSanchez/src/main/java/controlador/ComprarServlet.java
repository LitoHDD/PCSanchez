package controlador;

import dao.CestaDAO;
import dao.PedidoArticuloDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import dao.TarjetaDAO;
import dao.FacturaDAO;
import dto.Cesta;
import dto.LineaCesta;
import dto.PedidoArticulo;
import dto.Pedido;
import dto.Usuario;
import dto.Direccion;
import dto.Tarjeta;
import dto.Factura;
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
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        PedidoArticuloDAO pedidoArticuloDAO = new PedidoArticuloDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        CestaDAO cestaDAO = new CestaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        FacturaDAO facturaDAO = new FacturaDAO();

        try {
            Cesta cesta = null;
            try {
                cesta = cestaDAO.getCestaPorUsuario(usuario.getCodigo());
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("./error.jsp");
                return;
            }

            boolean tieneTarjeta = false;
            try {
                Tarjeta tarjeta = tarjetaDAO.getByCodigoUsuario(usuario.getCodigo());
                if (tarjeta != null) {
                    tieneTarjeta = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("./error.jsp");
                return;
            }

            if (!tieneTarjeta) {
                response.sendRedirect("agregar-tarjeta.jsp");
                return;
            }

            Pedido pedido = new Pedido();
            pedido.setFacturado("N");
            pedido.setFechapedido(LocalDateTime.now());
            List<Direccion> direcciones = usuarioDAO.getDirecciones(usuario.getCodigo());
            pedido.setDirecciones(direcciones);
            pedido.setUsuario(usuario);

            int numeroPedido = pedidoDAO.anyadir(pedido);
            System.out.println(numeroPedido);

            List<LineaCesta> lineasCesta = null;
            try {
                lineasCesta = cestaDAO.getLineas(cesta.getCodigo());
            } catch (SQLException e) {

                e.printStackTrace();
                response.sendRedirect("./error.jsp");
                return;
            }

            // Calcular el precio total del pedido
            double precioTotal = 0.0;
            for (LineaCesta lineaCesta : lineasCesta) {
                precioTotal += lineaCesta.getArticulo().getPrecio() * lineaCesta.getCantidad();
            }

            pedido.setPrecioTotal(precioTotal);

            // Actualizar el precio total del pedido en la base de datos
            try {
                pedidoDAO.actualizarPrecioTotal(numeroPedido, precioTotal);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("./error.jsp");
                return;
            }

            for (LineaCesta lineaCesta : lineasCesta) {
                PedidoArticulo pedidoArticulo = new PedidoArticulo();
                pedidoArticulo.setId(numeroPedido); 
                pedidoArticulo.setArticulo(lineaCesta.getArticulo());
                pedidoArticulo.setCantidad(lineaCesta.getCantidad());
                pedidoArticulo.setPrecio(lineaCesta.getArticulo().getPrecio() * lineaCesta.getCantidad()); 

                int numRetries = 5;
                boolean pedidoArticuloAdded = false;
                do {
                    try {
                        pedidoArticuloDAO.anyadir(pedidoArticulo);
                        pedidoArticuloAdded = true;
                    } catch (SQLException e) {
                        numRetries--;
                        if (numRetries == 0) {
                            e.printStackTrace();
                            response.sendRedirect("./error.jsp");
                            return;
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                    }
                } while (!pedidoArticuloAdded);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("./error.jsp");
            return;
        }

        try {
            Cesta cesta = cestaDAO.getCestaPorUsuario(usuario.getCodigo());
            cestaDAO.eliminarLineas(cesta);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("./error.jsp");
            return;
        }

        response.sendRedirect("pedidos.jsp");
    }
}
