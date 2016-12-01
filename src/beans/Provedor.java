package beans;

/**
 *
 * @author Marcos Pulgar
 */
public class Provedor {
    
    private int idProv; //auto incrementable
    private String rutProv;
    private String nombreProv;
    private int telefono;
    private String direccion;
    

    public Provedor() {
    }

    public Provedor(int idProv, String rutProv, String nombreProv, int telefono, String direccion) {
        this.idProv = idProv;
        this.rutProv = rutProv;
        this.nombreProv = nombreProv;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getRutProv() {
        return rutProv;
    }

    public void setRutProv(String rutProv) {
        this.rutProv = rutProv;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
    
}
