package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sobremesa extends Articulo{
    
    private int pulgadas, pesoGr, capacidadRamGb, almacenamientoGb;
    private String familiaProcesador, sistemaOperativo;

    public Sobremesa(int pulgadas, int pesoGr, int capacidadRamGb, int almacenamientoGb, String familiaProcesador, String sistemaOperativo, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.pulgadas = pulgadas;
        this.pesoGr = pesoGr;
        this.capacidadRamGb = capacidadRamGb;
        this.almacenamientoGb = almacenamientoGb;
        this.familiaProcesador = familiaProcesador;
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getPesoGr() {
        return pesoGr;
    }

    public void setPesoGr(int pesoGr) {
        this.pesoGr = pesoGr;
    }

    public int getCapacidadRamGb() {
        return capacidadRamGb;
    }

    public void setCapacidadRamGb(int capacidadRamGb) {
        this.capacidadRamGb = capacidadRamGb;
    }

    public int getAlmacenamientoGb() {
        return almacenamientoGb;
    }

    public void setAlmacenamientoGb(int almacenamientoGb) {
        this.almacenamientoGb = almacenamientoGb;
    }

    public String getFamiliaProcesador() {
        return familiaProcesador;
    }

    public void setFamiliaProcesador(String familiaProcesador) {
        this.familiaProcesador = familiaProcesador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return super.toString() + "pulgadas=" + pulgadas + ", pesoGr=" + pesoGr + ", capacidadRamGb=" + capacidadRamGb + ", almacenamientoGb=" + almacenamientoGb + ", familiaProcesador=" + familiaProcesador + ", sistemaOperativo=" + sistemaOperativo;
    }
    
}
