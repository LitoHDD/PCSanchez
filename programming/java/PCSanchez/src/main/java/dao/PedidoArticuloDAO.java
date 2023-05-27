/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Direccion;
import dto.LineaCesta;
import dto.Pedido;
import dto.PedidoArticulo;
import dto.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author sergio
 */
public class PedidoArticuloDAO extends TablaDAO<PedidoArticulo> {

    public PedidoArticuloDAO() {
        this.tabla = "ps_pedido_articulo";
    }

    @Override
    public int actualizar(PedidoArticulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PedidoArticulo eliminar(PedidoArticulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(PedidoArticulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PedidoArticulo> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PedidoArticulo getByCodigo(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getFechaPedido(int numeroPedido) throws SQLException {
        String sentenciaSQL = "SELECT fecha_pedido FROM ps_pedido WHERE numero = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numeroPedido);
        ResultSet resultSet = prepared.executeQuery();

        if (resultSet.next()) {
            return resultSet.getDate("fecha_pedido");
        } else {
            throw new SQLException("No se encontró la fecha del pedido para el número de pedido: " + numeroPedido);
        }
    }

    public int getNumeroPedido(int idLinea) throws SQLException {
        String sentenciaSQL = "SELECT numero_pedido FROM ps_pedido_articulo WHERE id = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, idLinea);
        ResultSet resultSet = prepared.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("numero_pedido");
        } else {
            throw new SQLException("No se encontró el número de pedido para la línea con id: " + idLinea);
        }
    }

    public ArrayList<PedidoArticulo> getLineasPorUsuario(int numeroUsuario) throws SQLException {
        ArrayList<PedidoArticulo> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM ps_pedido_articulo WHERE id IN (SELECT pa.id FROM ps_pedido_articulo pa INNER JOIN ps_pedido p ON pa.id = p.numero WHERE p.codigo_usuario = ?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numeroUsuario);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int articuloId = resultSet.getInt("articulo");
            Articulo articulo = new ArticuloDAO().getByCodigo(articuloId);
            int cantidad = resultSet.getInt("cantidad");
            double precio = resultSet.getDouble("precio");
            lineas.add(new PedidoArticulo(id, articulo, cantidad, precio));
        }

        return lineas;
    }

    public Pedido getLineasPedido(int numeroUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_pedido WHERE numero=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numeroUsuario);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int numeros = resultSet.getInt("numero");
            String facturado = resultSet.getString("facturado");
            LocalDateTime fechapedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario"));
            return new Pedido(numeros, facturado, fechapedido, getDirecciones(numeroUsuario), usuario);
        }

        return null;
    }

    public List<Direccion> getDirecciones(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_direccion WHERE codigo_usuario_direccion=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        while (resultSet.next()) {
            int numero = resultSet.getInt("numero");
            String tipo = resultSet.getString("tipo");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            direcciones.add(new Direccion(numero, tipo, direccion, poblacion, provincia));
        }
        return direcciones;
    }

    public ArrayList<PedidoArticulo> getLineas(int idLinea) throws SQLException {
        ArrayList<PedidoArticulo> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM ps_pedido_articulo WHERE id=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, idLinea);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("articulo"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineas.add(new PedidoArticulo(id, articulo, cantidad, precio));
        }
        return lineas;
    }

    public boolean eliminarLineaProducto(int productoId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean eliminado = false;
        DataSource datasource = Conexion.getConexion().getDatasource();

        try {
            con = datasource.getConnection();
            String query = "DELETE FROM ps_pedido_articulo WHERE id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, productoId);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage()); // Imprimir el mensaje de error SQL en consola
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error SQL al cerrar conexiones: " + e.getMessage()); // Imprimir el mensaje de error SQL en consola
                e.printStackTrace();
            }
        }

        return eliminado;
    }

    @Override
    public int anyadir(PedidoArticulo pedidoArticulo) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?)";
        PreparedStatement prepared = Conexion.getConexion().getDatasource().getConnection().prepareStatement(sentenciaSQL);

        int numeroPedido = obtenerNumeroPedido(pedidoArticulo); // Obtener el número de pedido

        prepared.setInt(1, numeroPedido);
        prepared.setInt(2, pedidoArticulo.getArticulo().getCodigo());
        prepared.setDouble(3, pedidoArticulo.getCantidad());
        prepared.setDouble(4, pedidoArticulo.getPrecio());

        // Imprimir el valor de numeroPedido antes de ejecutar la sentencia SQL
        System.out.println("Insertando el número de pedido: " + numeroPedido);

        return prepared.executeUpdate();
    }

    public int obtenerNumeroPedido(PedidoArticulo pedidoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT numero FROM ps_pedido WHERE numero = ?";
        PreparedStatement prepared = Conexion.getConexion().getDatasource().getConnection().prepareStatement(sentenciaSQL);
        prepared.setInt(1, pedidoArticulo.getId());

        ResultSet resultSet = prepared.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("numero");
        } else {
            throw new SQLException("No se encontró el número de pedido para la línea con ID: " + pedidoArticulo.getId());
        }
    }

    public int obtenerCodigoCesta(PedidoArticulo pedidoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT numero FROM ps_pedido WHERE numero = ?";
        PreparedStatement prepared = Conexion.getConexion().getDatasource().getConnection().prepareStatement(sentenciaSQL);
        prepared.setInt(1, pedidoArticulo.getId());

        ResultSet rs = prepared.executeQuery();

        if (rs.next()) {
            return rs.getInt("numero");
        } else {
            throw new SQLException("No se encontró el pedido con el id " + pedidoArticulo.getId());
        }
    }
}
