package dto;

import java.time.LocalDate;

public class Caja extends Articulo{
    
    String conexion, color, sizeLitros;

    public Caja(String conexion, String color, String sizeLitros, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.conexion = conexion;
        this.color = color;
        this.sizeLitros = sizeLitros;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizeLitros() {
        return sizeLitros;
    }

    public void setSizeLitros(String sizeLitros) {
        this.sizeLitros = sizeLitros;
    }

    @Override
    public String toString() {
        return "Caja{" + "conexion=" + conexion + ", color=" + color + ", sizeLitros=" + sizeLitros + '}';
    }
    
}
