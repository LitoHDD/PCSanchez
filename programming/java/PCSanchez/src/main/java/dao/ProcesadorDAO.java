package dao;

import dto.Articulo;
import dto.ArticuloCategoria;
import dto.Categoria;
import dto.Procesador;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProcesadorDAO extends TablaDAO<Procesador> {

    public ProcesadorDAO() {
        this.tabla = "ps_procesador";
    }

    @Override
    public int actualizar(Procesador objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Procesador objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodigo());
        prepared.setString(2, objeto.getSocket());
        prepared.setString(3, objeto.getFamilia());
        prepared.setInt(4, objeto.getGeneracion());
        prepared.setDouble(5, objeto.getFrecuenciaGhz());
        prepared.setInt(6, objeto.getNucleos());
        prepared.setInt(7, objeto.getHilos());
        return prepared.executeUpdate();
    }

    @Override
    public Procesador eliminar(Procesador objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodigo()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Procesador objeto) throws SQLException {
        return existe(objeto.getCodigo());
    }

    @Override
    public ArrayList<Procesador> getAll() throws SQLException {
        ArrayList<Procesador> lista = new ArrayList<>();
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
            String socket = resultSet.getString("socket");
            String familia = resultSet.getString("familia");
            int generacion = resultSet.getInt("generacion");
            int frecuenciaGhz = resultSet.getInt("frecuencia_ghz");
            int nucleos = resultSet.getInt("nucleos");
            int hilos = resultSet.getInt("hilos");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            lista.add(new Procesador(socket, familia, frecuenciaGhz, generacion, nucleos, hilos, codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
            });
        }

        return lista;
    }

    @Override
    public Procesador getByCodigo(int codigoArticulo) throws SQLException {
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
            String socket = resultSet.getString("socket");
            String familia = resultSet.getString("familia");
            int generacion = resultSet.getInt("generacion");
            int frecuenciaGhz = resultSet.getInt("frecuencia_ghz");
            int nucleos = resultSet.getInt("nucleos");
            int hilos = resultSet.getInt("hilos");
            int stock = resultSet.getInt("stock");
            LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
            LocalDate fechaModificacion = resultSet.getDate("fecha_modificacion").toLocalDate();
            return new Procesador(socket, familia, frecuenciaGhz, generacion, nucleos, hilos, codigoArticulos, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, usuarioModifica, usuarioCrea) {
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
