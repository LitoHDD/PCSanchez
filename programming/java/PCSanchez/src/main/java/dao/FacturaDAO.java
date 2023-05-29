package dao;

import dto.Direccion;
import dto.Factura;
import dto.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public int anyadir(Factura factura) throws SQLException {
        String query = "INSERT INTO " + tabla + " (cod_factura, fecha, numero_pedido, cod_usuario, cod_usuario_direccion, numero_direccion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion().getDatasource().getConnection(); PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, factura.getCodFactura() + 50000);
            stmt.setTimestamp(2, Timestamp.valueOf(factura.getFecha()));
            stmt.setInt(3, factura.getCodFactura());
            stmt.setInt(4, factura.getPedido().getUsuario().getCodigo());
            stmt.setInt(5, factura.getPedido().getUsuario().getCodigo());
            // Obtener la dirección del usuario
            int numeroDireccion = obtenerNumeroDireccionUsuario(factura.getPedido().getUsuario().getCodigo());
            stmt.setInt(6, numeroDireccion);
            System.out.println("Valores insertados: " + factura.getCodFactura() + ", " + factura.getFecha().toLocalDate() + ", " + factura.getCodFactura() + ", " + factura.getPedido().getUsuario().getCodigo() + ", " + factura.getPedido().getUsuario().getCodigo() + ", " + numeroDireccion);

            stmt.executeUpdate();

        }
        return -1;
    }

    public boolean existeFactura(int numeroPedido) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + tabla + " WHERE numero_pedido = ?";
        try (Connection con = Conexion.getConexion().getDatasource().getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, numeroPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        }
        return false;
    }

// Obtener el número de dirección del usuario
    private int obtenerNumeroDireccionUsuario(int codigoUsuario) throws SQLException {
        String query = "SELECT numero FROM ps_direccion WHERE codigo_usuario_direccion = ?";
        try (Connection con = Conexion.getConexion().getDatasource().getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, codigoUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("numero");
            }
        }
        return -1; // Valor predeterminado o manejo de error según tus necesidades
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
    public Factura getByCodigo(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE cod_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int direccion = resultSet.getInt("numero_direccion");
            int codigos = resultSet.getInt("cod_factura");
            Pedido pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("numero_pedido"));
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
