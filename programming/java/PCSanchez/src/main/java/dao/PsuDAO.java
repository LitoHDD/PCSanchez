/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.ArticuloCategoria;
import dto.Categoria;
import dto.Psu;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Longino
 */
public class PsuDAO extends TablaDAO<Psu> {

    public PsuDAO() {
        this.tabla = "ps_psu";
    }

    @Override
    public int actualizar(Psu objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Psu objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodigo());
        prepared.setInt(2, objeto.getPotenciaW());
        prepared.setString(3, objeto.getCertificado());
        prepared.setString(4, objeto.getModular());
        return prepared.executeUpdate();
    }

    @Override
    public Psu eliminar(Psu objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodigo()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Psu objeto) throws SQLException {
        return existe(objeto.getCodigo());
    }

    @Override
    public ArrayList<Psu> getAll() throws SQLException {
        ArrayList<Psu> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM ps_psu JOIN ps_articulo ON ps_psu.codigo_articulo = ps_articulo.codigo ORDER BY ps_psu.codigo_articulo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulo = resultSet.getInt("codigo_articulo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int potenciaW = resultSet.getInt("potencia_w");
            String certificado = resultSet.getString("certificado");
            String modular = resultSet.getString("modular");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            lista.add(new Psu(potenciaW, certificado, modular, codigoArticulo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea));
        }

        return lista;
    }

    @Override
    public Psu getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " JOIN ps_articulo ON " + tabla + ".codigo_articulo = ps_articulo.codigo WHERE codigo_articulo=? ORDER BY " + tabla + ".codigo_articulo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulo = resultSet.getInt("codigo_articulo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int potenciaW = resultSet.getInt("potencia_w");
            String certificado = resultSet.getString("certificado");
            String modular = resultSet.getString("modular");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Psu(potenciaW, certificado, modular, codigoArticulo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea);
        }
        return null;
    }

    public ArrayList<ArticuloCategoria> getCategorias(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_categoria WHERE nombre=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<ArticuloCategoria> categoria = new ArrayList<>();
        while (resultSet.next()) {
            Articulo codigoArticulos = new ArticuloDAO().getByCodigo(resultSet.getInt("codigo_articulo_categoria"));
            Categoria nombreCategorias = new CategoriaDAO().getByCodigo(resultSet.getInt("nombre_categoria"));
            categoria.add(new ArticuloCategoria(codigoArticulos, nombreCategorias));
        }
        return categoria;
    }

}
