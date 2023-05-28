package dto;

import java.io.Serializable;
import java.util.Objects;

public class ArticuloCategoria implements Serializable{
    
    private Articulo articulo;
    private Categoria categoria;

    public ArticuloCategoria(Articulo articulo, Categoria categoria) {
        this.articulo = articulo;
        this.categoria = categoria;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.articulo);
        hash = 31 * hash + Objects.hashCode(this.categoria);
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
        final ArticuloCategoria other = (ArticuloCategoria) obj;
        if (!Objects.equals(this.articulo, other.articulo)) {
            return false;
        }
        return Objects.equals(this.categoria, other.categoria);
    }

    @Override
    public String toString() {
        return "ArticuloCategoria{" + "articulo=" + articulo + ", categoria=" + categoria + '}';
    }
    
    
}
