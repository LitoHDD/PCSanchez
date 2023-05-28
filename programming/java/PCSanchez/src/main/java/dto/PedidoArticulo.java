/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author sergio
 */
public class PedidoArticulo implements Serializable{

    int id;
    private Articulo articulo;
    private double cantidad;
    private double precio;

    public PedidoArticulo(int id, Articulo articulo, double cantidad, double precio) {
        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public PedidoArticulo(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.articulo);
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
        final PedidoArticulo other = (PedidoArticulo) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.articulo, other.articulo);
    }

    @Override
    public String toString() {
        return "PedidoArticulo{" + "id=" + id + ", articulo=" + articulo + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
