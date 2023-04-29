/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import dao.ArticuloCategoriaDAO;
import dao.ArticuloDAO;
import dao.CajaDAO;
import dao.CategoriaDAO;
import dao.CestaDAO;
import dao.DireccionDAO;
import dao.FacturaDAO;
import dao.PsuDAO;
import dao.TarjetaDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Test {

    public static void main(String[] args) throws SQLException {

        ArticuloCategoriaDAO prueba = new ArticuloCategoriaDAO();
        ArrayList<ArticuloCategoria> articulosCategoria = prueba.getAll();
        System.out.println(articulosCategoria);
        System.out.println(prueba.getByCodigo(12345));
        System.out.println("");
        System.out.println("");

        ArticuloDAO prueba1 = new ArticuloDAO();
        ArrayList<Articulo> articulos = prueba1.getAll();
        System.out.println(articulos);
        System.out.println(prueba1.getByCodigo(12345));
        System.out.println("");
        System.out.println("");

        CajaDAO prueba2 = new CajaDAO();
        ArrayList<Caja> cajas = prueba2.getAll();
        System.out.println(cajas);
        System.out.println(prueba2.getByCodigo(12349));
        System.out.println("");
        System.out.println("");

        CategoriaDAO prueba3 = new CategoriaDAO();
        ArrayList<Categoria> categorias = prueba3.getAll();
        System.out.println(categorias);
        System.out.println(prueba3.getByNombre("Almacenamiento"));
        System.out.println("");
        System.out.println("");        

        CestaDAO prueba4 = new CestaDAO();
        ArrayList<Cesta> cestas = prueba4.getAll();
        System.out.println(cestas);
        System.out.println(prueba4.getByNombreCesta("Navidades"));
        System.out.println("");
        System.out.println("");
        
        DireccionDAO prueba5 = new DireccionDAO();
        ArrayList<Direccion> direcciones = prueba5.getAll();
        System.out.println(direcciones);
        System.out.println(prueba5.getByCodigo(5463));
        System.out.println("");
        System.out.println("");
        //No funciona
        
        /*FacturaDAO prueba6 = new FacturaDAO();
        ArrayList<Factura> facturas = prueba6.getAll();
        System.out.println(facturas);
        System.out.println(prueba6.getByCodigo(5463));*/

        TarjetaDAO prueba7 = new TarjetaDAO();
        ArrayList<Tarjeta> tarjetas = prueba7.getAll();
        System.out.println(tarjetas);
        System.out.println(prueba7.getByCodigo(5463));
        System.out.println("");
        System.out.println("");
        
        UsuarioDAO prueba8 = new UsuarioDAO();
        ArrayList<Usuario> usuarios = prueba8.getAll();
        System.out.println(usuarios);
        System.out.println(prueba8.getByCodigo(5463));
        System.out.println("");
        System.out.println("");
        
        PsuDAO prueba9 = new PsuDAO();
        ArrayList<Psu> psus = prueba9.getAll();
        System.out.println(psus);
        System.out.println(prueba9.getByCodigo(12363));
        System.out.println("");
        System.out.println("");        
    }
}
