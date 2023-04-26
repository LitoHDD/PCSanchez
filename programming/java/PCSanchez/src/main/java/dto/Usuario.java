package dto;

import java.time.LocalDate;
import java.util.List;

public class Usuario {

    /* Nuestra base de datos esta hecha para que solo tenga un telefono. Vamos a cambiar el modelo E/R */
    /* codigo es un aatributo unico por usuario y foto es opcional, lo de la ultima conexión lo hemos eliminado de nuestro entidad relacion */
    
    private int codigo, telefono;
    private String email, password, nombreCompleto, foto;
    private LocalDate fechaNacimiento;
    private List<Direccion> direcciones;
    private List<Cesta> cestas;
    private TipoUsuario tipoUsuario;

    public Usuario(int codigo, int telefono, String email, String password, String nombreCompleto, String foto, LocalDate fechaNacimiento, List<Direccion> direcciones, List<Cesta> cestas, TipoUsuario tipoUsuario) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.foto = foto;
        this.fechaNacimiento = fechaNacimiento;
        this.direcciones = direcciones;
        this.cestas = cestas;
        this.tipoUsuario = tipoUsuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Cesta> getCestas() {
        return cestas;
    }

    public void setCestas(List<Cesta> cestas) {
        this.cestas = cestas;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
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
        final Usuario other = (Usuario) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", telefono=" + telefono + ", email=" + email + ", password=" + password + ", nombreCompleto=" + nombreCompleto + ", foto=" + foto + ", fechaNacimiento=" + fechaNacimiento + ", direcciones=" + direcciones + ", cestas=" + cestas + ", tipoUsuario=" + tipoUsuario + '}';
    }

    public void agregarDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public void eliminarDireccion(Direccion direccion) {
        this.direcciones.remove(direccion);
    }

    public void agregarCesta(Cesta cesta) {
        this.cestas.add(cesta);
    }

    public void eliminarDireccion(Cesta cesta) {
        this.cestas.remove(cesta);
    }

}
