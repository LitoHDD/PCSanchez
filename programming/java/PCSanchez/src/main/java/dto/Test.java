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
import dao.LineaCestaDAO;
import dao.PedidoDAO;
import dao.PlacaBaseDAO;
import dao.PortatilDAO;
import dao.ProcesadorDAO;
import dao.PsuDAO;
import dao.RamDAO;
import dao.RefrigeracionDAO;
import dao.SobremesaDAO;
import dao.TarjetaDAO;
import dao.TarjetaGraficaDAO;
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
        System.out.println("\n");

        ArticuloDAO prueba1 = new ArticuloDAO();
        ArrayList<Articulo> articulos = prueba1.getAll();
        System.out.println(articulos);
        System.out.println(prueba1.getByCodigo(12345));
        System.out.println("\n");

        CajaDAO prueba2 = new CajaDAO();
        ArrayList<Caja> cajas = prueba2.getAll();
        System.out.println(cajas);
        System.out.println(prueba2.getByCodigo(12349));
        System.out.println("\n");

        CategoriaDAO prueba3 = new CategoriaDAO();
        ArrayList<Categoria> categorias = prueba3.getAll();
        System.out.println(categorias);
        System.out.println(prueba3.getByNombre("Almacenamiento"));
        System.out.println("\n");

        CestaDAO prueba4 = new CestaDAO();
        ArrayList<Cesta> cestas = prueba4.getAll();
        System.out.println(cestas);
        System.out.println(prueba4.getByNombreCesta("Navidades"));
        System.out.println("\n");

        DireccionDAO prueba5 = new DireccionDAO();
        ArrayList<Direccion> direcciones = prueba5.getAll();
        System.out.println(direcciones);
        System.out.println(prueba5.getByCodigo(5463));
        System.out.println("\n");

        FacturaDAO prueba6 = new FacturaDAO();
        ArrayList<Factura> facturas = prueba6.getAll();
        System.out.println(facturas);
        System.out.println(prueba6.getByCodigo(5463));
        System.out.println("\n");

        LineaCestaDAO prueba7 = new LineaCestaDAO();
        ArrayList<LineaCesta> lineasCestas = prueba7.getLineas(6440);
        System.out.println(lineasCestas);
        System.out.println("\n");

        PedidoDAO prueba8 = new PedidoDAO();
        ArrayList<Pedido> pedidos = prueba8.getAll();
        System.out.println(pedidos);
        System.out.println(prueba8.getByCodigo(5463));
        System.out.println("\n");

        PlacaBaseDAO prueba9 = new PlacaBaseDAO();
        ArrayList<PlacaBase> placasBase = prueba9.getAll();
        System.out.println(placasBase);
        System.out.println(prueba9.getByCodigo(12354));
        System.out.println("\n");

        PortatilDAO prueba10 = new PortatilDAO();
        ArrayList<Portatil> portatiles = prueba10.getAll();
        System.out.println(portatiles);
        System.out.println(prueba10.getByCodigo(12357));
        System.out.println("\n");

        ProcesadorDAO prueba11 = new ProcesadorDAO();
        ArrayList<Procesador> procesador = prueba11.getAll();
        System.out.println(procesador);
        System.out.println(prueba11.getByCodigo(12360));
        System.out.println("\n");

        PsuDAO prueba12 = new PsuDAO();
        ArrayList<Psu> psus = prueba12.getAll();
        System.out.println(psus);
        System.out.println(prueba12.getByCodigo(12363));
        System.out.println("\n");

        RamDAO prueba13 = new RamDAO();
        ArrayList<Ram> rams = prueba13.getAll();
        System.out.println(rams);
        System.out.println(prueba13.getByCodigo(12351));
        System.out.println("\n");

        RefrigeracionDAO prueba14 = new RefrigeracionDAO();
        ArrayList<Refrigeracion> refrigeraciones = prueba14.getAll();
        System.out.println(refrigeraciones);
        System.out.println(prueba14.getByCodigo(12366));
        System.out.println("\n");

        SobremesaDAO prueba15 = new SobremesaDAO();
        ArrayList<Sobremesa> sobremesas = prueba15.getAll();
        System.out.println(sobremesas);
        System.out.println(prueba15.getByCodigo(12369));
        System.out.println("\n");

        TarjetaDAO prueba16 = new TarjetaDAO();
        ArrayList<Tarjeta> tarjetas = prueba16.getAll();
        System.out.println(tarjetas);
        System.out.println(prueba16.getByCodigo(5463));
        System.out.println("\n");

        TarjetaGraficaDAO prueba17 = new TarjetaGraficaDAO();
        ArrayList<TarjetaGrafica> tarjetasGraficas = prueba17.getAll();
        System.out.println(tarjetasGraficas);
        System.out.println(prueba17.getByCodigo(12372));
        System.out.println("\n");

        UsuarioDAO prueba18 = new UsuarioDAO();
        ArrayList<Usuario> usuarios = prueba18.getAll();
        System.out.println(usuarios);
        System.out.println(prueba18.getByCodigo(5463));
        System.out.println("\n");
    }
}
