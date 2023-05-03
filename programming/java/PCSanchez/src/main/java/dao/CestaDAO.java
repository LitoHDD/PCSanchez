package dao;

import dto.Articulo;
import dto.Cesta;
import dto.LineaCesta;
import dto.Usuario;
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
        prepared.setString(1, cesta.getNombre());

        if (cesta.getTipo() == null) {
            prepared.setNull(2, java.sql.Types.VARCHAR);
        } else {
            prepared.setString(3, cesta.getTipo());
        }

        int a = prepared.executeUpdate();
        anyadirLineaPedido(cesta);
        return a;

    }

    @Override
    public Cesta eliminar(Cesta cesta) throws SQLException {
        if (cesta == null) {
            return null;
        } else {
            String sentenciaSQL = "Delete from " + tabla + " where nombre=?";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setString(1, cesta.getNombre());
            prepared.executeUpdate();
            return cesta;
        }
    }

    public void anyadirLineaPedido(Cesta cesta) throws SQLException {
        for (LineaCesta linea : cesta.getLineaCestas()) {
            String sentenciaSQL = "INSERT INTO ps_cestas_articulo(articulo, cesta, cantidad, precio) VALUES(?,?,?,?)";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setInt(1, linea.getArticulo().getCodigo());
            prepared.setString(2, cesta.getNombre());
            prepared.setDouble(3, linea.getCantidad());
            prepared.setDouble(4, linea.getPrecio());
            prepared.executeUpdate();
        }
    }

    private void eliminarLineas(Cesta cesta) throws SQLException {
        String sentenciaSQL = "DELETE FROM ps_cestas_articulo WHERE cesta=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, cesta.getNombre());
        prepared.executeUpdate();
    }

    public boolean existePorNombreCesta(Cesta c) throws SQLException {
        return c.getNombre() != null;
    }

    public boolean existePorNombreCesta(String a) throws SQLException {
        return getByNombreCesta(a) != null;
    }

    @Override
    public ArrayList<Cesta> getAll() throws SQLException {
        ArrayList<Cesta> lista = new ArrayList<>();

        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY nombre";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String tipo = resultSet.getString("tipo");
            double cantidad = resultSet.getDouble("cantidad");
            ArrayList<LineaCesta> lineasPedido = getLineas("nombre");
            double precio = resultSet.getDouble("precio");
            lista.add(new Cesta(nombre, tipo, precio, cantidad, lineasPedido));
        }
        return lista;
    }

    public Cesta getByNombreCesta(String nombreCesta) throws SQLException {

        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE nombre=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreCesta);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {

            String nombre = resultSet.getString("nombre");
            String tipo = resultSet.getString("tipo");
            double precio = resultSet.getDouble("precio");
            double cantidad = resultSet.getDouble("cantidad");
            ArrayList<LineaCesta> lineasPedido = getLineas(nombre);

            return new Cesta(nombre, tipo, precio, cantidad, lineasPedido);

        }

        return null;
    }

    @Override
    public Cesta getByCodigo(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<LineaCesta> getLineas(String nombreCesta) throws SQLException {
        ArrayList<LineaCesta> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM ps_cesta_articulo WHERE cesta=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreCesta);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("articulo"));
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("numero_usuario"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineas.add(new LineaCesta(articulo, usuario, cantidad, precio));
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
}
