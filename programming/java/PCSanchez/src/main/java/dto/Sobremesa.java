package dto;

import java.time.LocalDate;

public class Sobremesa extends Articulo{
    
    private int capacidadRamGb, almacenamientoGb;
    private String tamaño, tipo, familiaProcesador, sistemaOperativo;

    public Sobremesa(int capacidadRamGb, int almacenamientoGb, String tamaño, String tipo, String familiaProcesador, String sistemaOperativo, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.capacidadRamGb = capacidadRamGb;
        this.almacenamientoGb = almacenamientoGb;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.familiaProcesador = familiaProcesador;
        this.sistemaOperativo = sistemaOperativo;
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

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "Sobremesa{" + "capacidadRamGb=" + capacidadRamGb + ", almacenamientoGb=" + almacenamientoGb + ", tama\u00f1o=" + tamaño + ", tipo=" + tipo + ", familiaProcesador=" + familiaProcesador + ", sistemaOperativo=" + sistemaOperativo + '}';
    }
    
}
