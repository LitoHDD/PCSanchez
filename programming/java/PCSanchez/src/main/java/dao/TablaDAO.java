/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author Usuario
 */
public abstract class TablaDAO<T> implements IDAO<T> {

    private final DataSource datasource;
    protected String tabla;

    public TablaDAO() {
        this.datasource = Conexion.getConexion().getDatasource();
    }

    @Override
    public T eliminar(int codigo) throws SQLException {
        T aux = this.getByCodigo(codigo);
        String sentenciaSQL = "DELETE FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        prepared.executeUpdate();
        return aux;
    }
    
    public boolean existe(int codigo) throws SQLException {
        return this.getByCodigo(codigo) != null;
    }


    public PreparedStatement getPrepared(String sql) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try (Connection conn = datasource.getConnection()) {
                return conn.prepareStatement(sql);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TablaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int siguienteCodigo() throws SQLException {
        int ultimo = 0;
        String sentenciaSQL = "SELECT codigo FROM " + tabla;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try (Connection conn = datasource.getConnection()) {
                try (Statement statement = conn.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery(sentenciaSQL)) {
                        while (resultSet.next()) {
                            int codigo = resultSet.getInt("codigo");
                            if (codigo > ultimo) {
                                ultimo = codigo;
                            }

                        }

                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TablaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo + 1;
    }

    @Override
    public void vaciar() throws SQLException {
        String sentenciaSQL = "TRUNCATE TABLE " + tabla;
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.execute();

    }

}
