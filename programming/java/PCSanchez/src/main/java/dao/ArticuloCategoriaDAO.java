/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.ArticuloCategoria;
import dto.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ArticuloCategoriaDAO extends TablaDAO<ArticuloCategoria> {

    @Override
    public int actualizar(ArticuloCategoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(ArticuloCategoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArticuloCategoria eliminar(ArticuloCategoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(ArticuloCategoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ArticuloCategoria> getAll() throws SQLException {
        ArrayList<ArticuloCategoria> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY nombre";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("codigo"));
            lista.add(new ArticuloCategoria(articulo, getCategorias()) {
            });
        }

        return lista;
    }

    @Override
    public ArticuloCategoria getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("codigo"));
            return new ArticuloCategoria(articulo, getCategoria(codigo)) {
            };
        }
        return null;
    }

    public Categoria getCategoria(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_articulo_categoria WHERE codigo_articulo_categoria=? LIMIT 1";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        Categoria categoria = null;
        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre_categoria");
            categoria = new Categoria(nombre);
        }
        return categoria;
    }

    public Categoria getCategorias() throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_articulo_categoria";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        Categoria categoria = null;
        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre_categoria");
            categoria = new Categoria(nombre);
        }
        return categoria;
    }

}