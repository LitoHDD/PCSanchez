package dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Psu extends Articulo implements Serializable{
    
    private int potenciaW;
    private String certificado, modular;

    public Psu(int potenciaW, String certificado, String modular, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
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

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }

    @Override
    public String toString() {
        return "Psu{" + "potenciaW=" + potenciaW + ", certificado=" + certificado + ", modular=" + modular + '}';
    }
    
}