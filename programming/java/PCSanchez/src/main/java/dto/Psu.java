package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Psu extends Articulo{
    
    private int potenciaW;
    private String certificado;
    private boolean modular;

    public Psu(int potenciaW, String certificado, boolean modular, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.potenciaW = potenciaW;
        this.certificado = certificado;
        this.modular = modular;
    }

    public int getPotenciaW() {
        return potenciaW;
    }

    public void setPotenciaW(int potenciaW) {
        this.potenciaW = potenciaW;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public boolean isModular() {
        return modular;
    }

    public void setModular(boolean modular) {
        this.modular = modular;
    }

    @Override
    public String toString() {
        return super.toString() + "potenciaW=" + potenciaW + ", certificado=" + certificado + ", modular=" + modular;
    }
    
}