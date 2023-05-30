/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException; // Importar la excepción SQLException
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FacturaDAO;
import dao.PedidoDAO;
import dto.Factura;
import dto.Pedido;
import java.time.LocalDateTime;

public class GenerarFacturaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido"));
            
            PedidoDAO pedidoDAO = new PedidoDAO();
            Pedido pedido = pedidoDAO.getByCodigo(numeroPedido);
            
            FacturaDAO facturaDAO = new FacturaDAO();
            
            // Verificar si ya existe una factura para el pedido
            boolean facturaExiste = facturaDAO.existeFactura(numeroPedido);
            if (facturaExiste) {
                System.out.println("Ya se generó una factura para el pedido con número: " + numeroPedido);
            } else {
                Factura factura = new Factura();
                int numeroDireccion = pedido.getNumero();
                factura.setCodFactura(numeroPedido);
                factura.setDireccion(numeroDireccion);
                factura.setFecha(LocalDateTime.now());
                factura.setPedido(pedido);
                
                int numeroFactura = facturaDAO.anyadir(factura);
                System.out.println("Factura generada");
                
                // Actualizar el estado del pedido a "facturado"
                pedido.setFacturado("facturado");
                pedidoDAO.actualizarEstado(pedido, "S");
                System.out.println("Estado del pedido actualizado: facturado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de error aquí
        }
    }
}