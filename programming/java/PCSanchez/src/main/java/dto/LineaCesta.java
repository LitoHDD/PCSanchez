package dto;

import java.util.Objects;

public class LineaCesta {

    int id;
    private Articulo articulo;
    private double cantidad;
    private double precio;

    public LineaCesta(int id, Articulo articulo, double cantidad, double precio) {
        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
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
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.articulo);
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
        final LineaCesta other = (LineaCesta) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.articulo, other.articulo);
    }

    @Override
    public String toString() {
        return "LineaCesta{" + "id=" + id + ", articulo=" + articulo + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
