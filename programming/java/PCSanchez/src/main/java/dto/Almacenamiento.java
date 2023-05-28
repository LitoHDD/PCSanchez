/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author sergio
 */
public class Almacenamiento extends Articulo implements Serializable{
    
    String tipo;
    int capacidadGb;
    String conexion;

    public Almacenamiento(String tipo, int capacidadGb, String conexion, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.tipo = tipo;
        this.capacidadGb = capacidadGb;
        this.conexion = conexion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadGb() {
        return capacidadGb;
    }

    public void setCapacidadGb(int capacidadGb) {
        this.capacidadGb = capacidadGb;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    @Override
    public String toString() {
        return "Almacenamiento{" + "tipo=" + tipo + ", capacidadGb=" + capacidadGb + ", conexion=" + conexion + '}';
    }
    
}
