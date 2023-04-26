package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Procesador extends Articulo{
    
    private String socket, familia, generacion;
    private double frecuenciaGhz;

    public Procesador(String socket, String familia, String generacion, double frecuenciaGhz, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.socket = socket;
        this.familia = familia;
        this.generacion = generacion;
        this.frecuenciaGhz = frecuenciaGhz;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public double getFrecuenciaGhz() {
        return frecuenciaGhz;
    }

    public void setFrecuenciaGhz(double frecuenciaGhz) {
        this.frecuenciaGhz = frecuenciaGhz;
    }

    @Override
    public String toString() {
        return super.toString() + "socket=" + socket + ", familia=" + familia + ", generacion=" + generacion + ", frecuenciaGhz=" + frecuenciaGhz;
    }
    
    
    
}
