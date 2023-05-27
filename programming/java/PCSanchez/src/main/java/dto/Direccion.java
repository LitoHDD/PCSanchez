package dto;

import java.io.Serializable;

public class Direccion implements Serializable{

    private int numero;
    private String tipo, direccion, poblacion, provincia;

    public Direccion(int numero, String tipo, String direccion, String poblacion, String provincia) {
        this.numero = numero;
        this.tipo = tipo;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.numero;
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
        final Direccion other = (Direccion) obj;
        return this.numero == other.numero;
    }

    @Override
    public String toString() {
        return tipo + " " + direccion + ", " + poblacion + ", " + provincia;
    }

}
