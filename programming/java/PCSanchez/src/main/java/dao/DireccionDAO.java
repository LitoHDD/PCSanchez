/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Direccion;
import dto.Usuario;

/**
 *
 * @author jmas
 */
public class DireccionDAO extends TablaDAO<Direccion> {

    public DireccionDAO() {
        this.tabla = "ps_direccion";
    }

    @Override
    public int actualizar(Direccion d) throws SQLException {
        // NO SE UTILIZA EN NUESTRO PROYECTO
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Direccion d) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, d.getNumero());
        prepared.setString(2, d.getTipo());
        prepared.setString(3, d.getDireccion());
        prepared.setString(4, d.getPoblacion());
        prepared.setString(5, d.getProvincia());
        return prepared.executeUpdate();
    }

    @Override
    public Direccion eliminar(Direccion d) throws SQLException {
        if (d == null) {
            return null;
        } else {
            return eliminar(d.getNumero()) != null ? d : null;
        }
    }

    @Override
    public boolean existe(Direccion d) throws SQLException {
        return existe(d.getNumero());
    }

    @Override
    public ArrayList<Direccion> getAll() throws SQLException {
        ArrayList<Direccion> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY tipo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("numero");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            String tipo = resultSet.getString("tipo");
            lista.add(new Direccion(codigo, tipo, direccion, poblacion, provincia));
        }
        return lista;
    }

    @Override
    public Direccion getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo_usuario_direccion=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoDos = resultSet.getInt("numero");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            String tipo = resultSet.getString("tipo");
            return new Direccion(codigoDos, tipo, direccion, poblacion, provincia);
        }
        return null;
    }

    public ArrayList<Direccion> getDireccionesDe(Usuario u) throws SQLException {
        ArrayList<Direccion> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE usuario=? ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, u.getCodigo());
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoTres = resultSet.getInt("numero");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            String tipo = resultSet.getString("tipo");
            lista.add(new Direccion(codigoTres, tipo, direccion, poblacion, provincia));
        }
        return lista;
    }

}