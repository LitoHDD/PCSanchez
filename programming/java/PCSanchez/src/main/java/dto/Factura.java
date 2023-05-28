package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Factura implements Serializable{

    private int codFactura, direccion;
    private LocalDateTime fecha;
    private Pedido pedido;

    public Factura(int codFactura, int direccion, LocalDateTime fecha, Pedido pedido) {
        this.codFactura = codFactura;
        this.direccion = direccion;
        this.fecha = fecha;
        this.pedido = pedido;
    }
    
    public Factura(){
        
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.codFactura;
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
        final Factura other = (Factura) obj;
        return this.codFactura == other.codFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "codFactura=" + codFactura + ", direccion=" + direccion + ", fecha=" + fecha + ", pedido=" + pedido + '}';
    }

}
