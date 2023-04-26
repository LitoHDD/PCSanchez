/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class CategoriaDAO extends TablaDAO<Categoria> {

    public CategoriaDAO() {
        this.tabla = "PS_CATEGORIA";
    }

    @Override
    public int actualizar(Categoria objeto) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET nombre=? WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, objeto.getNombre());
        return prepared.executeUpdate();
    }

    @Override
    public int anyadir(Categoria objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(2, objeto.getNombre());
        return prepared.executeUpdate();
    }

    @Override
    public boolean existe(Categoria objeto) throws SQLException {
        return objeto.getNombre() != null;
    }

    @Override
    public ArrayList<Categoria> getAll() throws SQLException {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY NOMBRE";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            lista.add(new Categoria(nombre));
        }

        return lista;
    }

    public Categoria getByNombre(String nombre) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE nombre=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombre);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String nombres = resultSet.getString("nombre");
            return new Categoria(nombres);
        }

        return null;
    }

    @Override
    public Categoria getByCodigo(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria eliminar(Categoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}