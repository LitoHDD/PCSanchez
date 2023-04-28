/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Direccion;
import dto.Factura;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Pedido;
import dto.Usuario;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
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
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, pedido.getNumero());
        prepared.setBoolean(2, pedido.isFacturado());
        prepared.setTimestamp(3, Timestamp.valueOf(pedido.getFechapedido()));
        Direccion direccion = pedido.getDireccion();
        if (direccion == null) {
            prepared.setNull(4, java.sql.Types.INTEGER);
        } else {
            prepared.setInt(4, direccion.getNumero());
        }
        Usuario usuario = pedido.getUsuario();
        if (usuario == null) {
            prepared.setNull(5, java.sql.Types.INTEGER);
        } else {
            prepared.setInt(5, usuario.getCodigo());
        }
        prepared.setString(6, pedido.getCesta());
        return prepared.executeUpdate();
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
            boolean facturado = estaFacturado(numero);
            LocalDateTime fechapedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario"));
            Direccion direccion = new DireccionDAO().getByCodigo(resultSet.getInt("numero"));
            String cesta = resultSet.getString("nombre_cesta");
            List<Factura> facturas = getFacturas(numero);
            lista.add(new Pedido(numero, facturado, fechapedido, direccion, cesta, usuario, facturas));
        }

        return lista;
    }

    @Override
    public Pedido getByCodigo(int numero) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE numero=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numero);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int numeros = resultSet.getInt("numero");
            boolean facturado = estaFacturado(numero);
            LocalDateTime fechapedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario"));
            Direccion direccion = new DireccionDAO().getByCodigo(resultSet.getInt("numero"));
            String cesta = resultSet.getString("nombre_cesta");
            List<Factura> facturas = getFacturas(numero);
            return new Pedido(numeros, facturado, fechapedido, direccion, cesta, usuario, facturas);
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

    public boolean estaFacturado(int numeroPedido) throws SQLException {
        String sentenciaSQL = "SELECT facturado FROM " + tabla + " WHERE numero=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, numeroPedido);

        return prepared.executeUpdate() != 0;
    }

}
