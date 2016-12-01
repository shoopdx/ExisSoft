package beans;

/**
 *
 * @author Marcos Pulgar
 */
public class Stock {
    
    private int stock; //default = 0 ( Stock + nuevoStock)
    private int codigoArt;
    private String categoria;

    public Stock() {
    }

    public Stock(int stock, int codigoArt, String categoria) {
        this.stock = stock;
        this.codigoArt = codigoArt;
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigoArt() {
        return codigoArt;
    }

    public void setCodigoArt(int codigoArt) {
        this.codigoArt = codigoArt;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
    
    
    
}
