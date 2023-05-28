/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.ArticuloCategoria;
import dto.Categoria;
import dto.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergio
 */
public class ArticuloDAO extends TablaDAO<Articulo> {

    public ArticuloDAO() {
        this.tabla = "ps_articulo";
    }

    @Override
    public int actualizar(Articulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Articulo objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla
                + " (codigo, usuario_crea, usuario_modifica, nombre, iva, descripcion, precio, path_foto, stock, fecha_creacion, fecha_modificacion) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodigo());
        prepared.setInt(2, objeto.getCreacion().getCodigo()); // Asumiendo que Usuario tiene un método getId()
        prepared.setInt(3, objeto.getModificacion().getCodigo()); // Asumiendo que Usuario tiene un método getId()
        prepared.setString(4, objeto.getNombre());
        prepared.setDouble(5, objeto.getIva());
        prepared.setString(6, objeto.getDescripcion());
        prepared.setDouble(7, objeto.getPrecio());
        prepared.setString(8, objeto.getPathFoto());
        prepared.setDouble(9, objeto.getStock());
        prepared.setDate(10, Date.valueOf(objeto.getFechaCreacion()));
        prepared.setDate(11, Date.valueOf(objeto.getFechaModificacion()));
        return prepared.executeUpdate();
    }

    @Override
    public Articulo eliminar(Articulo objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodigo()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Articulo objeto) throws SQLException {
        return existe(objeto.getCodigo());
    }

    @Override
    public ArrayList<Articulo> getAll() throws SQLException {
        ArrayList<Articulo> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulo = resultSet.getInt("codigo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int precio = resultSet.getInt("precio");
            int iva = resultSet.getInt("iva");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            lista.add(new Articulo(codigoArticulo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            });
        }

        return lista;
    }

    @Override
    public Articulo getByCodigo(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulos = resultSet.getInt("codigo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Articulo(codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            };
        }
        return null;
    }

    public List<Articulo> getByCategoria(String nombreCategoria) throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        String sentenciaSQL = "SELECT ps_articulo.codigo, ps_articulo.nombre, ps_articulo.descripcion, ps_articulo.path_foto, ps_articulo.iva, ps_articulo.precio, ps_articulo.stock, ps_articulo.fecha_creacion, ps_articulo.fecha_modificacion, ps_articulo.usuario_modifica, ps_articulo.usuario_crea "
                + "FROM ps_articulo "
                + "JOIN ps_articulo_categoria ON ps_articulo.codigo = ps_articulo_categoria.codigo_articulo_categoria "
                + "JOIN ps_categoria ON ps_articulo_categoria.nombre_categoria = ps_categoria.nombre "
                + "WHERE ps_categoria.nombre LIKE ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, "%" + nombreCategoria + "%");
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulo = resultSet.getInt("codigo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            Articulo articulo = new Articulo(codigoArticulo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            };
            articulos.add(articulo);
        }
        return articulos;
    }

    public Articulo getByNombre(String nombreArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE nombre=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreArticulo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulos = resultSet.getInt("codigo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Articulo(codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            };
        }
        return null;
    }

    public List<Articulo> getByNombreParcial(String nombreParcial) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE LOWER(nombre) LIKE LOWER(?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, "%" + nombreParcial + "%");
        ResultSet resultSet = prepared.executeQuery();

        List<Articulo> articulos = new ArrayList<>();
        while (resultSet.next()) {
            int codigoArticulos = resultSet.getInt("codigo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();

            articulos.add(new Articulo(codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            });
        }
        return articulos;
    }

    public ArrayList<ArticuloCategoria> getCategorias(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_articulo_categoria WHERE codigo_articulo_categoria=?";
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
