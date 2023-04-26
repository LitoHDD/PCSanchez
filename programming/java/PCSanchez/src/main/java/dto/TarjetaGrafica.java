package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class TarjetaGrafica extends Articulo {

    String arquitectura;
    int vRamGb;

    public TarjetaGrafica(String arquitectura, int vRamGb, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.arquitectura = arquitectura;
        this.vRamGb = vRamGb;
    }

    public String getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(String arquitectura) {
        this.arquitectura = arquitectura;
    }

    public int getvRamGb() {
        return vRamGb;
    }

    public void setvRamGb(int vRamGb) {
        this.vRamGb = vRamGb;
    }

    @Override
    public String toString() {
        return super.toString() + "arquitectura=" + arquitectura + ", vRamGb=" + vRamGb;
    }

}
