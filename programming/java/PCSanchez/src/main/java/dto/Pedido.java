package dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido implements Serializable{

    private int numero;
    private double precioTotal;
    private String facturado;
    private LocalDateTime fechapedido;
    private List<Direccion> direcciones;
    private Usuario usuario;

    public Pedido(int numero, double precioTotal, String facturado, LocalDateTime fechapedido, List<Direccion> direcciones, Usuario usuario) {
        this.numero = numero;
        this.precioTotal = precioTotal;
        this.facturado = facturado;
        this.fechapedido = fechapedido;
        this.direcciones = direcciones;
        this.usuario = usuario;
    }
    
    public Pedido(){
    
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getFacturado() {
        return facturado;
    }

    public void setFacturado(String facturado) {
        this.facturado = facturado;
    }

    public LocalDateTime getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(LocalDateTime fechapedido) {
        this.fechapedido = fechapedido;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", precioTotal=" + precioTotal + ", facturado=" + facturado + ", fechapedido=" + fechapedido + ", direcciones=" + direcciones + ", usuario=" + usuario + '}';
    }

}