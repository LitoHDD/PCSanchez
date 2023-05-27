/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Direccion;
import dto.Factura;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Pedido;
import dto.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Longino
 */
public class PedidoDAO extends TablaDAO<Pedido> {

    public PedidoDAO() {
        this.tabla = "ps_pedido";
    }

    @Override
    public int actualizar(Pedido objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Pedido pedido) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla
                + "(numero, facturado, fecha_pedido, numero_direccion, codigo_usuario) "
                + "VALUES((SELECT NVL(MAX(numero), 0) + 1 FROM ps_pedido),?,?,?,?)";

        try (Connection connection = Conexion.getConexion().getDatasource().getConnection(); PreparedStatement prepared = connection.prepareStatement(sentenciaSQL, new String[]{"numero"})) {

            prepared.setString(1, pedido.getFacturado());
            prepared.setTimestamp(2, Timestamp.valueOf(pedido.getFechapedido()));

            Usuario usuario = pedido.getUsuario();
            if (usuario == null) {
                prepared.setNull(3, java.sql.Types.INTEGER);
            } else {
                DireccionDAO direccionDAO = new DireccionDAO();
                List<Direccion> direcciones = direccionDAO.getDireccionesDe(usuario);
                if (!direcciones.isEmpty()) {
                    int numeroDireccion = direcciones.get(0).getNumero();
                    prepared.setInt(3, numeroDireccion);
                } else {
                    prepared.setNull(3, java.sql.Types.INTEGER);
                }
            }

            prepared.setInt(4, (usuario != null) ? usuario.getCodigo() : 0);
            prepared.executeUpdate();

            try (ResultSet generatedKeys = prepared.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }

    private int obtenerCodigoCesta(Pedido pedido) throws SQLException {
        String sentenciaSQL = "SELECT codigo FROM ps_cesta WHERE numero_usuario = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, pedido.getUsuario().getCodigo()); // Reemplaza "getAlgunAtributoPedido()" con el método adecuado para obtener el atributo necesario

        ResultSet resultSet = prepared.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("codigo");
        }

        return 0; // Retorna un valor predeterminado si no se encuentra el código de la cesta
    }

    @Override
    public Pedido eliminar(Pedido objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getNumero()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Pedido objeto) throws SQLException {
        return existe(objeto.getNumero());
    }

    @Override
    public ArrayList<Pedido> getAll() throws SQLException {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY numero";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int numero = resultSet.getInt("numero");
            String facturado = resultSet.getString("facturado");
            LocalDateTime fechapedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario"));
            lista.add(new Pedido(numero, facturado, fechapedido, getDireccion(), usuario));
        }

        return lista;
    }

    @Override
    public Pedido getByCodigo(int numeroUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE numero=?";
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

    public List<Factura> getFacturas(int numeroPedido) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_factura WHERE numero_pedido=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numeroPedido);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<Factura> facturas = new ArrayList<>();
        while (resultSet.next()) {
            int codFactura = resultSet.getInt("cod_factura");
            Timestamp fechaTimestamp = resultSet.getTimestamp("fecha");
            LocalDateTime fecha = fechaTimestamp.toLocalDateTime();
            Pedido pedido = new PedidoDAO().getByCodigo(resultSet.getInt("numero_pedido"));
            int direccion = resultSet.getInt("direccion");
            facturas.add(new Factura(codFactura, direccion, fecha, pedido));
        }
        return facturas;
    }

    public List<Direccion> getDireccion() throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_direccion";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
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

    public Pedido getPedido(int numeroPedido) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_pedido WHERE numero = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numeroPedido);

        ResultSet resultSet = prepared.executeQuery();
        if (resultSet.next()) {
            int numero = resultSet.getInt("numero");
            String facturado = resultSet.getString("facturado");
            LocalDateTime fechaPedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();

            // Obtén las direcciones del pedido
            int numeroDireccion = resultSet.getInt("numero_direccion");
            DireccionDAO direccionDAO = new DireccionDAO();
            Direccion direccion = direccionDAO.getByCodigo(numeroDireccion);
            List<Direccion> direcciones = new ArrayList<>();
            direcciones.add(direccion);

            // Obtén el usuario del pedido
            int codigoUsuario = resultSet.getInt("codigo_usuario");
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.getByCodigo(codigoUsuario);

            Pedido pedido = new Pedido(numero, facturado, fechaPedido, direcciones, usuario);
            return pedido;
        }

        return null; // Retorna null si no se encuentra el pedido
    }
}
