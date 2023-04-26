package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Refrigeracion extends Articulo{
    
    private String tipo, socket;
    private int tamaño;

    public Refrigeracion(String tipo, String socket, int tamaño, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.tipo = tipo;
        this.socket = socket;
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return super.toString() + "tipo=" + tipo + ", socket=" + socket + ", tama\u00f1o=" + tamaño;
    }
    
}
