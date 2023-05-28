package dao;

import dto.Tarjeta;
import dto.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarjetaDAO extends TablaDAO<Tarjeta> {

    public TarjetaDAO() {
        this.tabla = "PS_TARJETA";
    }

    @Override
    public int actualizar(Tarjeta objeto) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET num_tarjeta=? WHERE cod_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setLong(1, objeto.getNumeroTarjeta());
        prepared.setLong(2, objeto.getUsuario().getCodigo()); // Utiliza setLong para el código de usuario

        try {
            return prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Vuelve a lanzar la excepción para que se pueda manejar en el servlet
        }
    }
    
    @Override
    public int anyadir(Tarjeta objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES((SELECT NVL(MAX(cod_pago), 0) + 1 FROM " + tabla + "), ?, ?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setLong(1, objeto.getNumeroTarjeta());
        prepared.setInt(2, objeto.getUsuario().getCodigo());
        return prepared.executeUpdate();
    }

    @Override
    public Tarjeta eliminar(Tarjeta objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodPago()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Tarjeta objeto) throws SQLException {
        return existe(objeto.getCodPago());
    }

    @Override
    public ArrayList<Tarjeta> getAll() throws SQLException {
        ArrayList<Tarjeta> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY cod_pago";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codPago = resultSet.getInt("cod_pago");
            long numTarjeta = resultSet.getLong("num_tarjeta");
            int codUsuario = resultSet.getInt("cod_usuario");
            Usuario usuario = new UsuarioDAO().getByCodigo(codUsuario);

            lista.add(new Tarjeta(codPago, numTarjeta, usuario));
        }
        return lista;
    }

    @Override
    public Tarjeta getByCodigo(int codigoPago) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE cod_pago=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoPago);
        ResultSet resultSet = prepared.executeQuery();
        if (resultSet.next()) {
            int codPago = resultSet.getInt("cod_pago");
            long numTarjeta = resultSet.getLong("num_tarjeta");
            int codUsuario = resultSet.getInt("cod_usuario");
            Usuario usuario = new UsuarioDAO().getByCodigo(codUsuario);
            return new Tarjeta(codPago, numTarjeta, usuario);
        }
        return null;
    }

    public Tarjeta getByCodigoUsuario(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE cod_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        if (resultSet.next()) {
            int codPago = resultSet.getInt("cod_pago");
            long numTarjeta = resultSet.getLong("num_tarjeta");
            int codUsuario = resultSet.getInt("cod_usuario");
            Usuario usuario = new UsuarioDAO().getByCodigo(codUsuario);
            return new Tarjeta(codPago, numTarjeta, usuario);
        }
        return null;
    }

}
