package beans;

/**
 *
 * @author Marcos Pulgar
 */
public class Articulo {
    
    private int codigoArt;
    private String nombreArt;
    private String categoria;

    public Articulo() {
    }

    public Articulo(int codigoArt, String nombreArt, String categoria) {
        this.codigoArt = codigoArt;
        this.nombreArt = nombreArt;
        this.categoria = categoria;
    }

    public int getCodigoArt() {
        return codigoArt;
    }

    public void setCodigoArt(int codigoArt) {
        this.codigoArt = codigoArt;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
}