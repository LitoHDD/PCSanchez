/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Categoria;
import dto.Cesta;
import dto.LineaCesta;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public ArrayList<LineaCesta> getLineas(String nombreCesta) throws SQLException {
        ArrayList<LineaCesta> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT articulo, precio, cantidad FROM ps_cesta_articulo WHERE nombre_cesta = cesta";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreCesta);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("codigo_articulo"));
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineas.add(new LineaCesta(articulo, usuario, cantidad, precio));
        }
        return lineas;
    }

    // Necesitamos la clase DAO de articulo
    public LinkedHashSet<LineaCesta> getLineas(int codPedido) throws SQLException {
        ArticuloDAO productoDAO = new ArticuloDAO();
        LinkedHashSet<LineaCesta> lineas = new LinkedHashSet<>();
        String sentenciaSQL = "SELECT producto, precio, iva, cantidad FROM productospedido WHERE pedido = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codPedido);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("codigo_articulo"));
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineas.add(new LineaCesta(articulo, usuario, cantidad, precio));
        }
        return lineas;
    }

    public ArrayList<LineaCesta> getLineasCesta(int codigoArticulo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM ps_cesta_categoria WHERE codigo_articulo_categoria=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<LineaCesta> lineasCesta = new ArrayList<>();
        while (resultSet.next()) {
            Articulo articulo = new ArticuloDAO().getByCodigo(resultSet.getInt("codigo_articulo"));
            Usuario usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineasCesta.add(new LineaCesta(articulo, usuario, cantidad, precio));
        }
        return lineasCesta;
    }

}
