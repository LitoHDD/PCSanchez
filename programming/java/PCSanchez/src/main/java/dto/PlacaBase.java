package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlacaBase extends Articulo {

    private String type, socket, chipset;

    public PlacaBase(String type, String socket, String chipset, int codigo, String nombre, String descripcion, String pathFoto, double iva, double precio, double stock, LocalDate fechaCreacion, LocalDate fechaModificacion, Usuario modificacion, Usuario creacion) {
        super(codigo, nombre, descripcion, pathFoto, iva, precio, stock, fechaCreacion, fechaModificacion, modificacion, creacion);
        this.type = type;
        this.socket = socket;
        this.chipset = chipset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return super.toString() + "type=" + type + ", socket=" + socket + ", chipset=" + chipset;
    }

}
