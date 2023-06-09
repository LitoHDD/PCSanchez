/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.LineaCesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author sergio
 */
public class LineaCestaDAO extends TablaDAO<LineaCesta> {

    @Override
    public int actualizar(LineaCesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(LineaCesta objeto) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        int filasAfectadas = 0;
        DataSource datasource = Conexion.getConexion().getDatasource();

        try {
            con = datasource.getConnection();
            String query = "INSERT INTO ps_cesta_articulo (id, articulo, cantidad, precio) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, objeto.getId());
            pstmt.setInt(2, objeto.getArticulo().getCodigo());
            pstmt.setDouble(3, objeto.getCantidad());
            pstmt.setDouble(4, objeto.getPrecio());
            filasAfectadas = pstmt.executeUpdate();
            System.out.println("Se ha insertado la línea de cesta con éxito. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error SQL al insertar la línea de cesta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error SQL al cerrar conexiones: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return filasAfectadas;
    }

    @Override
    public LineaCesta eliminar(LineaCesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(LineaCesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<LineaCesta> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LineaCesta getByCodigo(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<LineaCesta> getLineas(int idLinea) throws SQLException {
        ArrayList<LineaCesta> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM ps_cesta_articulo WHERE id=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, idLinea);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("articulo"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineas.add(new LineaCesta(id, articulo, cantidad, precio));
        }
        return lineas;
    }
    
    public boolean vaciarCesta(int productoId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean eliminado = false;
        DataSource datasource = Conexion.getConexion().getDatasource();

        try {
            con = datasource.getConnection();
            String query = "DELETE FROM ps_cesta_articulo WHERE id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, productoId);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage()); // Imprimir el mensaje de error SQL en consola
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error SQL al cerrar conexiones: " + e.getMessage()); // Imprimir el mensaje de error SQL en consola
                e.printStackTrace();
            }
        }

        return eliminado;
    }

    public boolean eliminarLineaProducto(int lineaId, int codigoArticulo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean eliminado = false;
        DataSource datasource = Conexion.getConexion().getDatasource();

        try {
            con = datasource.getConnection();
            String query = "DELETE FROM ps_cesta_articulo WHERE id = ? AND articulo = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, lineaId);
            pstmt.setInt(2, codigoArticulo);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage()); // Imprimir el mensaje de error SQL en consola
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error SQL al cerrar conexiones: " + e.getMessage()); // Imprimir el mensaje de error SQL en consola
                e.printStackTrace();
            }
        }

        return eliminado;
    }

}
