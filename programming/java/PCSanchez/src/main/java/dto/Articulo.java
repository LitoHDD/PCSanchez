package dto;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Articulo implements Serializable{

    private int codigo;
    private String nombre, descripcion, pathFoto;
    private double iva, precio, stock;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
    private Usuario modificacion;
    private Usuario creacion;

    public Articulo(int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pathFoto = pathFoto;
        this.iva = iva;
        this.precio = precio;
        this.stock = stock;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.modificacion = modificacion;
        this.creacion = creacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getModificacion() {
        return modificacion;
    }

    public void setModificacion(Usuario modificacion) {
        this.modificacion = modificacion;
    }

    public Usuario getCreacion() {
        return creacion;
    }

    public void setCreacion(Usuario creacion) {
        this.creacion = creacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigo;
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
        final Articulo other = (Articulo) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", pathFoto=" + pathFoto + ", iva=" + iva + ", precio=" + precio + ", stock=" + stock + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", modificacion=" + modificacion + ", creacion=" + creacion + '}';
    }

}
