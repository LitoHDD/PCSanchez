package dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Portatil extends Articulo implements Serializable{
    
    private int pulgadasPantalla, pesoGr, capacidadRamGB, almacenamientoGB;
    private String familiaProcesador, sistemaOperativo;

    public Portatil(int pulgadasPantalla, int pesoGr, int capacidadRamGB, int almacenamientoGB, String familiaProcesador, String sistemaOperativo, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.pulgadasPantalla = pulgadasPantalla;
        this.pesoGr = pesoGr;
        this.capacidadRamGB = capacidadRamGB;
        this.almacenamientoGB = almacenamientoGB;
        this.familiaProcesador = familiaProcesador;
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getPulgadasPantalla() {
        return pulgadasPantalla;
    }

    public void setPulgadasPantalla(int pulgadasPantalla) {
        this.pulgadasPantalla = pulgadasPantalla;
    }

    public int getPesoGr() {
        return pesoGr;
    }

    public void setPesoGr(int pesoGr) {
        this.pesoGr = pesoGr;
    }

    public int getCapacidadRamGB() {
        return capacidadRamGB;
    }

    public void setCapacidadRamGB(int capacidadRamGB) {
        this.capacidadRamGB = capacidadRamGB;
    }

    public int getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public void setAlmacenamientoGB(int almacenamientoGB) {
        this.almacenamientoGB = almacenamientoGB;
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
        return "Portatil{" + "pulgadasPantalla=" + pulgadasPantalla + ", pesoGr=" + pesoGr + ", capacidadRamGB=" + capacidadRamGB + ", almacenamientoGB=" + almacenamientoGB + ", familiaProcesador=" + familiaProcesador + ", sistemaOperativo=" + sistemaOperativo + '}';
    } 
    
}
