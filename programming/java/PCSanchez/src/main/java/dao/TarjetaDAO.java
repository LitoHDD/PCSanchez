/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Tarjeta;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class TarjetaDAO extends TablaDAO<Tarjeta> {

    public TarjetaDAO() {
        this.tabla = "PS_TARJETA";
    }

    @Override
    public int actualizar(Tarjeta objeto) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET nombre=? WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodPago());
        return prepared.executeUpdate();
    }

    @Override
    public int anyadir(Tarjeta objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(2, objeto.getCodPago());
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
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY cod_usuario";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codPago = resultSet.getInt("cod_pago");
            long numTarjeta = resultSet.getLong("num_tarjeta");
            Usuario codUsuario = new UsuarioDAO().getByCodigo(resultSet.getInt("cod_usuario"));

            lista.add(new Tarjeta(codPago, numTarjeta, codUsuario));
        }
        return lista;
    }

    @Override
    public Tarjeta getByCodigo(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE cod_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codPago = resultSet.getInt("cod_pago");
            long numTarjeta = resultSet.getLong("num_tarjeta");
            Usuario codUsuario = new UsuarioDAO().getByCodigo(resultSet.getInt("cod_usuario"));
            return new Tarjeta(codPago, numTarjeta, codUsuario) {
            };
        }
        return null;
    }

}
