/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import dao.ArticuloDAO;
import dao.CategoriaDAO;
import dao.CestaDAO;
import dao.DireccionDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Test {

    public static void main(String[] args) throws SQLException {

        /*CategoriaDAO prueba = new CategoriaDAO();
        ArrayList<Categoria> categorias = prueba.getAll();
        System.out.println(categorias);
        System.out.println(prueba.getByNombre("Almacenamiento"));*/

        /*DireccionDAO prueba2 = new DireccionDAO();
        ArrayList<Direccion> direcciones = prueba2.getAll();
        System.out.println(direcciones);
        System.out.println(prueba2.getByCodigo(5463));*/

        /*CestaDAO prueba3 = new CestaDAO();
        ArrayList<Cesta> cestas = prueba3.getAll();
        System.out.println(cestas);
        System.out.println(prueba3.getByNombreCesta("Navidades"));*/

        //No funciona
        ArticuloDAO prueba3 = new ArticuloDAO();
        ArrayList<Articulo> articulos = prueba3.getAll();
        System.out.println(articulos);
        System.out.println(prueba3.getByCodigo(12345));
    }
}
