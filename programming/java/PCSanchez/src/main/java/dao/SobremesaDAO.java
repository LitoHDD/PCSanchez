/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.ArticuloCategoria;
import dto.Caja;
import dto.Categoria;
import dto.Sobremesa;
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
public class SobremesaDAO extends TablaDAO<Sobremesa> {

    public SobremesaDAO() {
        this.tabla = "ps_sobremesa";
    }

    @Override
    public int actualizar(Sobremesa objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Sobremesa objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodigo());
        prepared.setString(2, objeto.getTamaño());
        prepared.setString(3, objeto.getFamiliaProcesador());
        prepared.setString(4, objeto.getTipo());
        prepared.setInt(5, objeto.getCapacidadRamGb());
        prepared.setString(6, objeto.getSistemaOperativo());
        prepared.setInt(7, objeto.getAlmacenamientoGb());
        return prepared.executeUpdate();
    }

    @Override
    public Sobremesa eliminar(Sobremesa objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodigo()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Sobremesa objeto) throws SQLException {
        return existe(objeto.getCodigo());
    }

    @Override
    public ArrayList<Sobremesa> getAll() throws SQLException {
        ArrayList<Sobremesa> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " JOIN ps_articulo ON " + tabla + ".codigo_articulo = ps_articulo.codigo ORDER BY " + tabla + ".codigo_articulo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulos = resultSet.getInt("codigo_articulo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int almacenamientoGb = resultSet.getInt("almacenamiento_gb");
            int capacidadRamGb = resultSet.getInt("capazidad_ram_gb");
            String tamaño = resultSet.getString("size_pc");
            String tipo = resultSet.getString("type_pc");
            String familiaProcesador = resultSet.getString("familia_procesador");
            String sistemaOperativo = resultSet.getString("sistema_operativo");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            lista.add(new Sobremesa(capacidadRamGb, almacenamientoGb, tamaño, tipo, familiaProcesador, sistemaOperativo, codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            });
        }

        return lista;
    }

    @Override
    public Sobremesa getByCodigo(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " JOIN ps_articulo ON " + tabla + ".codigo_articulo = ps_articulo.codigo WHERE codigo_articulo=? ORDER BY " + tabla + ".codigo_articulo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigoArticulos = resultSet.getInt("codigo_articulo");
            Usuario usuarioCrea = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_crea"));
            Usuario usuarioModifica = new UsuarioDAO().getByCodigo(resultSet.getInt("usuario_modifica"));
            String nombre = resultSet.getString("nombre");
            int iva = resultSet.getInt("iva");
            int precio = resultSet.getInt("precio");
            String descripcion = resultSet.getString("descripcion");
            String pathFoto = resultSet.getString("path_foto");
            int almacenamientoGb = resultSet.getInt("almacenamiento_gb");
            int capacidadRamGb = resultSet.getInt("capazidad_ram_gb");
            String tamaño = resultSet.getString("size_pc");
            String tipo = resultSet.getString("type_pc");
            String familiaProcesador = resultSet.getString("familia_procesador");
            String sistemaOperativo = resultSet.getString("sistema_operativo");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Sobremesa(capacidadRamGb, almacenamientoGb, tamaño, tipo, familiaProcesador, sistemaOperativo, codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            };
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
