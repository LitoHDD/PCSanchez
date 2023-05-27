package dto;

import java.io.Serializable;
import java.util.List;

public class Cesta implements Serializable{

    private int codigo;
    private double precioCesta;
    private List<LineaCesta> lineaCestas;

    public Cesta(int codigo, double precioCesta, List<LineaCesta> lineaCestas) {
        this.codigo = codigo;
        this.precioCesta = precioCesta;
        this.lineaCestas = lineaCestas;
    }
    
    public Cesta() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioCesta() {
        return precioCesta;
    }

    public void setPrecioCesta(double precioCesta) {
        this.precioCesta = precioCesta;
    }

    public List<LineaCesta> getLineaCestas() {
        return lineaCestas;
    }

    public void setLineaCestas(List<LineaCesta> lineaCestas) {
        this.lineaCestas = lineaCestas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
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
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Cesta{" + "codigo=" + codigo + ", precioCesta=" + precioCesta + ", lineaCestas=" + lineaCestas + '}';
    }

    public void agregarLineaCesta(LineaCesta lineaCesta) {
        this.lineaCestas.add(lineaCesta);
    }

    public void removeLineaCesta(LineaCesta lineaCesta) {
        this.lineaCestas.remove(lineaCesta);
    }

}
