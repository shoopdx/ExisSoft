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
public class GuiaEntrega {
    
    private String fecha;
    private String artiuclo;
    private String cantidad; 
    private String nombreDepa;

    public GuiaEntrega() {
    }

    public GuiaEntrega(String fecha, String artiuclo, String cantidad, String nombreDepa) {
        this.fecha = fecha;
        this.artiuclo = artiuclo;
        this.cantidad = cantidad;
        this.nombreDepa = nombreDepa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArtiuclo() {
        return artiuclo;
    }

    public void setArtiuclo(String artiuclo) {
        this.artiuclo = artiuclo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreDepa() {
        return nombreDepa;
    }

    public void setNombreDepa(String nombreDepa) {
        this.nombreDepa = nombreDepa;
    }

    
    
    
}
