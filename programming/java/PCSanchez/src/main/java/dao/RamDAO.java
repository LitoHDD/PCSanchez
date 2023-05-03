package dao;

import dto.Articulo;
import dto.ArticuloCategoria;
import dto.Caja;
import dto.Categoria;
import dto.Ram;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RamDAO extends TablaDAO<Ram> {

    public RamDAO() {
        this.tabla = "ps_memoria_ram";
    }

    @Override
    public int actualizar(Ram objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Ram objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodigo());
        prepared.setInt(2, objeto.getCapacidadGB());
        prepared.setInt(3, objeto.getFrecuenciaMhz());
        prepared.setString(4, objeto.getTipo());
        prepared.setString(5, objeto.getPerfilXmp());
        return prepared.executeUpdate();
    }

    @Override
    public Ram eliminar(Ram objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodigo()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Ram objeto) throws SQLException {
        return existe(objeto.getCodigo());
    }

    @Override
    public ArrayList<Ram> getAll() throws SQLException {
        ArrayList<Ram> lista = new ArrayList<>();
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
            String tipo = resultSet.getString("tipo");
            String perfilXmp = resultSet.getString("perfil_xmp");
            int capacidadGb = resultSet.getInt("capacidad_mb");
            int frecuenciaMhz = resultSet.getInt("frecuencia_mhz");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            lista.add(new Ram(capacidadGb, frecuenciaMhz, tipo, perfilXmp, codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            });
        }

        return lista;
    }

    @Override
    public Ram getByCodigo(int codigoArticulo) throws SQLException {
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
            String tipo = resultSet.getString("tipo");
            String perfilXmp = resultSet.getString("perfil_xmp");
            int capacidadGb = resultSet.getInt("capacidad_mb");
            int frecuenciaMhz = resultSet.getInt("frecuencia_mhz");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Ram(capacidadGb, frecuenciaMhz, tipo, perfilXmp, codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
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
