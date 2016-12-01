package beans;

/**
 *
 * @author Marcos Pulgar
 */
public class Factura {
    
    private int idFactura; //auto incrementable y de manejo interno 
                           //para elimiar se recorrera con un fore obteniendo la id y pasandola a facturaDAO
    private int numeroFactura;
    private String fechaIngreso; //año-mes-dia
    private int idProv;
    private String estado;

    public Factura() {
    }

    public Factura(int idFactura, int numeroFactura, String fechaIngreso, int idProv, String estado) {
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.fechaIngreso = fechaIngreso;
        this.idProv = idProv;
        this.estado = estado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
   
         
}
