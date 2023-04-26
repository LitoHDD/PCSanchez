package dao;

import dto.Direccion;
import dto.Factura;
import dto.Pedido;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String direccion = resultSet.getString("direccion");
            int codigo = resultSet.getInt("codigo");
            Pedido pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("pedido"));
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario_direccion"));
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            lista.add(new Factura(codigo, fecha, pedidoAsociado, direccion));
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
            String direccion = resultSet.getString("direccion");
            Pedido pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("pedido"));
            Direccion direccionObj = new DireccionDAO().getByCodigo(resultSet.getInt("coddir"));
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            return new Factura(codigo, fecha, pedidoAsociado, direccion);
        }

        return null;
    }

}
