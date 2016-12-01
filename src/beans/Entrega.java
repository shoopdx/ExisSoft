package beans;

/**
 *
 * @author Marcos Pulgar
 */
public class Entrega {
    
    private int codigoArt;
    private String nombreDepa;
    private String fechaEntrega; //año/mes/dia
    private int cantidadArt; //se resta al stock
    private String estado;
    private int precioUnitario;
    private int numeroEntrega;
    private String categoria;

    public Entrega() {
    }

    public Entrega(int codigoArt, String nombreDepa, String fechaEntrega, int cantidadArt, String estado, int precioUnitario, int numeroEntrega, String categoria) {
        this.codigoArt = codigoArt;
        this.nombreDepa = nombreDepa;
        this.fechaEntrega = fechaEntrega;
        this.cantidadArt = cantidadArt;
        this.estado = estado;
        this.precioUnitario = precioUnitario;
        this.numeroEntrega = numeroEntrega;
        this.categoria = categoria;
    }

    

    public int getCodigoArt() {
        return codigoArt;
    }

    public void setCodigoArt(int codigoArt) {
        this.codigoArt = codigoArt;
    }

    public String getNombreDepa() {
        return nombreDepa;
    }

    public void setNombreDepa(String nombreDepa) {
        this.nombreDepa = nombreDepa;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCantidadArt() {
        return cantidadArt;
    }

    public void setCantidadArt(int cantidadArt) {
        this.cantidadArt = cantidadArt;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(int numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    

    
}
