package dto;

import java.util.List;
import java.util.Objects;

public class Cesta {

    private String nombre, tipo;
    private double precio, cantidad;
    private List<LineaCesta> lineaCestas;

    public Cesta(String nombre, String tipo, double precio, double cantidad, List<LineaCesta> lineaCestas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.lineaCestas = lineaCestas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public List<LineaCesta> getLineaCestas() {
        return lineaCestas;
    }

    public void setLineaCestas(List<LineaCesta> lineaCestas) {
        this.lineaCestas = lineaCestas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cesta other = (Cesta) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Cesta{" + "nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", cantidad=" + cantidad + ", lineaCestas=" + lineaCestas + '}';
    }

    public void agregarLineaCesta(LineaCesta lineaCesta) {
        this.lineaCestas.add(lineaCesta);
    }

    public void removeLineaCesta(LineaCesta lineaCesta) {
        this.lineaCestas.remove(lineaCesta);
    }

}
