package dao;

import dto.Articulo;
import dto.Cesta;
import dto.LineaCesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class CestaDAO extends TablaDAO<Cesta> {

    public CestaDAO() {
        this.tabla = "PS_CESTA";
    }

    @Override
    public int anyadir(Cesta cesta) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, cesta.getCodigo());
        int a = prepared.executeUpdate();
        anyadirLineaPedido(cesta);
        return a;

    }

    @Override
    public Cesta eliminar(Cesta cesta) throws SQLException {
        if (cesta == null) {
            return null;
        } else {
            String sentenciaSQL = "Delete from " + tabla + " where codigo=?";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setInt(1, cesta.getCodigo());
            prepared.executeUpdate();
            return cesta;
        }
    }

    public void anyadirLineaPedido(Cesta cesta) throws SQLException {
        for (LineaCesta linea : cesta.getLineaCestas()) {
            String sentenciaSQL = "INSERT INTO ps_cestas_articulo(articulo, cesta, cantidad, precio) VALUES(?,?,?,?)";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setInt(1, linea.getArticulo().getCodigo());
            prepared.setInt(2, cesta.getCodigo());
            prepared.setDouble(3, linea.getCantidad());
            prepared.setDouble(4, linea.getPrecio());
            prepared.executeUpdate();
        }
    }

    public void eliminarLineas(Cesta cesta) throws SQLException {
        String sentenciaSQL = "DELETE FROM ps_cesta_articulo WHERE id=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, cesta.getCodigo());
        prepared.executeUpdate();
    }

    public boolean existePorCodigoCesta(Cesta c) throws SQLException {
        return c.getCodigo() != 0;
    }

    @Override
    public ArrayList<Cesta> getAll() throws SQLException {
        ArrayList<Cesta> lista = new ArrayList<>();

        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            double precio = resultSet.getDouble("precio_cesta");
            // Crear una instancia de LineaCestaDAO
            LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
            // Utilizar el método getLineasPorIdCesta para obtener las líneas de la cesta
            ArrayList<LineaCesta> lineasPedido = lineaCestaDAO.getLineas(codigo);
            lista.add(new Cesta(codigo, precio, lineasPedido));
        }
        return lista;
    }

    @Override
    public Cesta getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet rs = prepared.executeQuery();

        while (rs.next()) {
            int codigos = rs.getInt("codigo");
            double precios = rs.getDouble("precio");
            // Crear una instancia de LineaCestaDAO
            LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
            // Utilizar el método getLineasPorIdCesta para obtener las líneas de la cesta
            ArrayList<LineaCesta> lineasPedido = lineaCestaDAO.getLineas(codigo);

            return new Cesta(codigos, precios, lineasPedido);
        }

        return null;
    }

    public ArrayList<LineaCesta> getLineas(int idLineas) throws SQLException {
        ArrayList<LineaCesta> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM ps_cesta_articulo WHERE id=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, idLineas);
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

    @Override
    public boolean existe(Cesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizar(Cesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cesta crearNuevaCesta(int codigoUsuario) {
        Cesta nuevaCesta = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion().getDatasource().getConnection();

            // Obtener el último código de cesta
            ps = conn.prepareStatement("SELECT codigo FROM ps_cesta WHERE codigo = (SELECT MAX(codigo) FROM ps_cesta)");
            rs = ps.executeQuery();

            int nuevoCodigo;
            if (rs.next()) {
                int ultimoCodigo = rs.getInt("codigo");
                nuevoCodigo = ultimoCodigo + 1;
            } else {
                // La tabla está vacía, así que el primer código será 1001
                nuevoCodigo = 1001;
            }

            System.out.println("Nuevo código de cesta: " + nuevoCodigo); // Mensaje de depuración
            System.out.println("Insertando nueva cesta en la base de datos con código: " + nuevoCodigo);

            // Insertar la nueva cesta en la base de datos
            ps = conn.prepareStatement("INSERT INTO ps_cesta (codigo, numero_usuario, precio_cesta) VALUES (?, ?, ?)");
            ps.setInt(1, nuevoCodigo);
            ps.setInt(2, codigoUsuario); // Agrega el código de usuario aquí          
            ps.setDouble(3, 0.0);

            int filasAfectadas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas); // Mensaje de depuración

            // Crear el objeto Cesta y establecer sus atributos
            nuevaCesta = new Cesta();
            nuevaCesta.setCodigo(nuevoCodigo);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return nuevaCesta;
    }

    public Cesta getCestaPorUsuario(int codigoUsuario) throws SQLException {
        Cesta cesta = null;

        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE numero_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoUsuario);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            double precio = resultSet.getDouble("precio_cesta");
            // Crear una instancia de LineaCestaDAO
            LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
            // Utilizar el método getLineasPorIdCesta para obtener las líneas de la cesta
            ArrayList<LineaCesta> lineasPedido = lineaCestaDAO.getLineas(codigo);

            cesta = new Cesta(codigo, precio, lineasPedido);
        }

        return cesta;
    }
}
