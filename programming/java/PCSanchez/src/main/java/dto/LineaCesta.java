package dto;

import java.util.Objects;

public class LineaCesta {

    private Articulo articulo;
    private Usuario usuario;
    private double cantidad;
    private double precio;

    public LineaCesta(Articulo articulo, Usuario usuario, double cantidad, double precio) {
        this.articulo = articulo;
        this.usuario = usuario;
        this.cantidad = cantidad;
        this.precio = precio;
    }



    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        int hash = 7;
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
        final LineaCesta other = (LineaCesta) obj;
        return Objects.equals(this.articulo, other.articulo);
    }

    @Override
    public String toString() {
        return "LineaCesta{" + "articulo=" + articulo + ", usuario=" + usuario + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
