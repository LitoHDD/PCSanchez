
     
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
 
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
 * 
 * NO FUNCIONA 
 * 
 */
public class PsuDAO extends TablaDAO<Psu> {
 
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
        prepared.setBoolean(4, objeto.isModular());
        return prepared.executeUpdate();
    }
 
    @Override
    public ArrayList<Psu> getAll() throws SQLException {
        ArrayList<Psu> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
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
            int potenciaW = resultSet.getInt("potencia_w");
            String certificado = resultSet.getString("certificado");
            boolean modular = resultSet.getBoolean("modular");
 
            //Posible error en getBoolean MODULAR
            //Probar esto en caso de error:
            //-------------------------------------------------------
            //String modularString = resultSet.getString("modular");
            //boolean modular = modularString.equalsIgnoreCase("si");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            lista.add(new Psu(potenciaW, certificado, modular, precio, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioCrea, usuarioCrea));
        }
 
        return lista;
    }
 
    @Override
    public Psu getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
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
            String conexion = resultSet.getString("conexion");
 
            int potenciaW = resultSet.getInt("potencia_w");
            String certificado = resultSet.getString("certificado");
            boolean modular = resultSet.getBoolean("modular");
 
            //Posible error en getBoolean MODULAR
            //Probar esto en caso de error:
            //-------------------------------------------------------
            //String modularString = resultSet.getString("modular");
            //boolean modular = modularString.equalsIgnoreCase("si");
            
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Psu(potenciaW, certificado, modular, codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioCrea, usuarioCrea);
        }
        return null;
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
 
 
    public ArrayList<Categoria> getCategorias(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_categoria WHERE codigo_articulo_categoria=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<Categoria> categoria = new ArrayList<>();
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            categoria.add(new Categoria(nombre));
        }
        return categoria;
    }
 
}