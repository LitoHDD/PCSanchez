package dao;

import dto.Direccion;
import dto.Factura;
import dto.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO extends TablaDAO<Factura> {

    public FacturaDAO() {
        this.tabla = "ps_factura";
    }

    @Override
    public int actualizar(Factura objeto) throws SQLException {
        // TODO: Implementar la actualización de una factura en la base de datos
        throw new UnsupportedOperationException("Actualizar factura no implementado todavía.");
    }

    @Override
    public int anyadir(Factura objeto) throws SQLException {
        // TODO: Implementar la inserción de una factura en la base de datos
        throw new UnsupportedOperationException("Añadir factura no implementado todavía.");
    }

    @Override
    public Factura eliminar(Factura objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodFactura()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Factura objeto) throws SQLException {
        return existe(objeto.getCodFactura());
    }

    @Override
    public ArrayList<Factura> getAll() throws SQLException {
        ArrayList<Factura> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY cod_factura";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int direccion = resultSet.getInt("numero_direccion");
            int codigo = resultSet.getInt("cod_factura");
            Pedido pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("numero_pedido"));
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            lista.add(new Factura(codigo, direccion, fecha, pedidoAsociado));
        }

        return lista;
    }

    @Override
    public Factura getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int direccion = resultSet.getInt("direccion");
            int codigos = resultSet.getInt("cod_factura");
            Pedido pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("pedido"));
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            return new Factura(codigos, direccion, fecha, pedidoAsociado);
        }

        return null;
    }

    public List<Direccion> getDirecciones(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_direccion WHERE codigo_usuario=?";
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
}
