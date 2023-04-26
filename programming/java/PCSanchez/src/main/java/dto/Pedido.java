package dto;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    /* Vamos a cambiar el entidad relacion para que solo se acepte un metodo de pago, es como tenemos nuestras tablas hechas */
    private int numero;
    private boolean facturado;
    private LocalDateTime fechapedido;
    private Direccion direccion;
    private String cesta;
    private final Usuario usuario;
    private List<Factura> facturas;

    public Pedido(int numero, boolean facturado, LocalDateTime fechapedido, Direccion direccion, String cesta, Usuario usuario, List<Factura> facturas) {
        this.numero = numero;
        this.facturado = facturado;
        this.fechapedido = fechapedido;
        this.direccion = direccion;
        this.cesta = cesta;
        this.usuario = usuario;
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", facturado=" + facturado + ", fechapedido=" + fechapedido + ", direccion=" + direccion + ", cesta=" + cesta + ", usuario=" + usuario + ", facturas=" + facturas + '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isFacturado() {
        return facturado;
    }

    public void setFacturado(boolean facturado) {
        this.facturado = facturado;
    }

    public LocalDateTime getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(LocalDateTime fechapedido) {
        this.fechapedido = fechapedido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getCesta() {
        return cesta;
    }

    public void setCesta(String cesta) {
        this.cesta = cesta;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return this.numero == other.numero;
    }

}