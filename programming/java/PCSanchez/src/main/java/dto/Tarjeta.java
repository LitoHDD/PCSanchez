package dto;

public class Tarjeta {
    
    private int codPago;
    private long numeroTarjeta;
    private Usuario usuario;

    public Tarjeta(int codPago, long numeroTarjeta, Usuario usuario) {
        this.codPago = codPago;
        this.numeroTarjeta = numeroTarjeta;
        this.usuario = usuario;
    }

    public int getCodPago() {
        return codPago;
    }

    public void setCodPago(int codPago) {
        this.codPago = codPago;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.codPago;
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
        final Tarjeta other = (Tarjeta) obj;
        return this.codPago == other.codPago;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "codPago=" + codPago + ", numeroTarjeta=" + numeroTarjeta + ", usuario=" + usuario + '}';
    }
    
}
