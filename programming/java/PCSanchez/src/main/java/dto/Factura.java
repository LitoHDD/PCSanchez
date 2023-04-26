package dto;

import java.time.LocalDateTime;

public class Factura {

    private int codFactura;
    private LocalDateTime fecha;
    private Pedido pedido;
    private String direccion;

    public Factura(int codFactura, LocalDateTime fecha, Pedido pedido, String direccion) {
        this.codFactura = codFactura;
        this.fecha = fecha;
        this.pedido = pedido;
        this.direccion = direccion;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        return "Factura{" + "codFactura=" + codFactura + ", fecha=" + fecha + ", pedido=" + pedido + ", direccion=" + direccion + '}';
    }

}
