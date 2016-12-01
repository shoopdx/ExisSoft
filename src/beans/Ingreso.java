/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Marcos Pulgar
 */
public class Ingreso {
    
    private int cantidad;
    private String estado;
    private int idFactura;
    private int codigoArt;
    private int precioUnitario;
    private String categoria;

    public Ingreso() {
    }

    public Ingreso(int cantidad, String estado, int idFactura, int codigoArt, int precioUnitario, String categoria) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.idFactura = idFactura;
        this.codigoArt = codigoArt;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getCodigoArt() {
        return codigoArt;
    }

    public void setCodigoArt(int codigoArt) {
        this.codigoArt = codigoArt;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    

    
    
    
}
