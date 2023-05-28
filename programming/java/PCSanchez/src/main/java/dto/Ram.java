package dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Ram extends Articulo implements Serializable{
    
    private int capacidadGB, frecuenciaMhz;
    private String tipo, perfilXmp;

    public Ram(int capacidadGB, int frecuenciaMhz, String tipo, String perfilXmp, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.capacidadGB = capacidadGB;
        this.frecuenciaMhz = frecuenciaMhz;
        this.tipo = tipo;
        this.perfilXmp = perfilXmp;
    }

    public int getCapacidadGB() {
        return capacidadGB;
    }

    public void setCapacidadGB(int capacidadGB) {
        this.capacidadGB = capacidadGB;
    }

    public int getFrecuenciaMhz() {
        return frecuenciaMhz;
    }

    public void setFrecuenciaMhz(int frecuenciaMhz) {
        this.frecuenciaMhz = frecuenciaMhz;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPerfilXmp() {
        return perfilXmp;
    }

    public void setPerfilXmp(String perfilXmp) {
        this.perfilXmp = perfilXmp;
    }

    @Override
    public String toString() {
        return "Ram{" + "capacidadGB=" + capacidadGB + ", frecuenciaMhz=" + frecuenciaMhz + ", tipo=" + tipo + ", perfilXmp=" + perfilXmp + '}';
    }
    
}
