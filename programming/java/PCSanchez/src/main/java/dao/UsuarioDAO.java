/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Cesta;
import dto.Direccion;
import dto.TipoUsuario;
import dto.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergio
 */
public class UsuarioDAO extends TablaDAO<Usuario> {

    public UsuarioDAO() {
        this.tabla = "ps_usuario";
    }

    @Override
    public int actualizar(Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Usuario objeto) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, objeto.getCodigo());
        prepared.setString(2, objeto.getNombreCompleto());
        prepared.setString(3, objeto.getEmail());
        prepared.setString(4, objeto.getPassword());
        prepared.setDate(5, Date.valueOf(objeto.getFechaNacimiento()));
        prepared.setInt(6, objeto.getTelefono());
        prepared.setString(7, String.valueOf(objeto.getTipoUsuario()));
        return prepared.executeUpdate();
    }

    @Override
    public Usuario eliminar(Usuario objeto) throws SQLException {
        if (objeto == null) {
            return null;
        } else {
            return eliminar(objeto.getCodigo()) != null ? objeto : null;
        }
    }

    @Override
    public boolean existe(Usuario objeto) throws SQLException {
        return existe(objeto.getCodigo());
    }

    @Override
    public ArrayList<Usuario> getAll() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombreCompleto = resultSet.getString("nombre_comp");
            String contrasenya = resultSet.getString("pass");
            String email = resultSet.getString("email");
            String foto = resultSet.getString("foto");
            LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
            int telefono = resultSet.getInt("telefono");
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipousuario"));
            lista.add(new Usuario(codigo, telefono, email, contrasenya, nombreCompleto, foto, fechaNacimiento, getDirecciones(codigo), getCestas(codigo), tipoUsuario));
        }

        return lista;
    }

    @Override
    public Usuario getByCodigo(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombreCompleto = resultSet.getString("nombre_comp");
            String contrasenya = resultSet.getString("pass");
            String email = resultSet.getString("email");
            String foto = resultSet.getString("foto");
            LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
            int telefono = resultSet.getInt("telefono");
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipousuario"));
            return new Usuario(codigo, telefono, email, contrasenya, nombreCompleto, foto, fechaNacimiento, getDirecciones(codigo), getCestas(codigo), tipoUsuario);
        }

        return null;
    }

    public List<Direccion> getDirecciones(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_direccion WHERE codigo_usuario_direccion=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        while (resultSet.next()) {
            int numero = resultSet.getInt("numero");
            String tipo = resultSet.getString("tipo");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            direcciones.add(new Direccion(numero, tipo, direccion, poblacion, provincia));
        }
        return direcciones;
    }

    public List<Cesta> getCestas(int codigoUsuario) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_cesta WHERE numero_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<Cesta> cestas = new ArrayList<>();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            double precio = resultSet.getDouble("precio_cesta");
            cestas.add(new Cesta(codigo, precio, null));
        }
        return cestas;
    }

    public Usuario validar(String formEmail, String formPassword) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE email=? AND pass=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, formEmail);
        prepared.setString(2, formPassword);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombreCompleto = resultSet.getString("nombre_comp");
            String contrasenya = resultSet.getString("pass");
            String email = resultSet.getString("email");
            String foto = resultSet.getString("foto");
            LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
            int telefono = resultSet.getInt("telefono");
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipousuario"));
            return new Usuario(codigo, telefono, email, contrasenya, nombreCompleto, foto, fechaNacimiento, getDirecciones(codigo), getCestas(codigo), tipoUsuario);
        }

        return null;
    }

    public void actualizarFoto(String photoUrl, int codigoUsuario) {
        String sql = "UPDATE " + tabla + " SET foto = ? WHERE codigo = ?";

        try (Connection conn = Conexion.getConexion().getDatasource().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, photoUrl);
            pstmt.setInt(2, codigoUsuario);

            pstmt.executeUpdate();
        } catch (Exception e) {
            // Manejar la excepción, podría ser un log o rethrow dependiendo de tu diseño
            e.printStackTrace();
        }
    }

}
