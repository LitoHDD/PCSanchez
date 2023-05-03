package dto;

import java.time.LocalDate;

public class Procesador extends Articulo{
    
    private String socket, familia;
    private double frecuenciaGhz;
    private int generacion, nucleos, hilos;

    public Procesador(String socket, String familia, double frecuenciaGhz, int generacion, int nucleos, int hilos, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.socket = socket;
        this.familia = familia;
        this.frecuenciaGhz = frecuenciaGhz;
        this.generacion = generacion;
        this.nucleos = nucleos;
        this.hilos = hilos;
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

    public double getFrecuenciaGhz() {
        return frecuenciaGhz;
    }

    public void setFrecuenciaGhz(double frecuenciaGhz) {
        this.frecuenciaGhz = frecuenciaGhz;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public int getHilos() {
        return hilos;
    }

    public void setHilos(int hilos) {
        this.hilos = hilos;
    }

    @Override
    public String toString() {
        return "Procesador{" + "socket=" + socket + ", familia=" + familia + ", frecuenciaGhz=" + frecuenciaGhz + ", generacion=" + generacion + ", nucleos=" + nucleos + ", hilos=" + hilos + '}';
    }
    
}
