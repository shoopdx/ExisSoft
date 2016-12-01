/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.text.NumberFormat;

/**
 *
 * @author Marcos Pulgar
 */
public class ReporteProductos {
    
    private String folio ;
    private String nombre; 
    private String stock;
    private String precio;
    private String saldo;
    

    public ReporteProductos() {
    }

    public ReporteProductos(String folio, String nombre, String stock, String precio, String saldo) {
        this.folio = folio;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.saldo = saldo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        String nuevoPrecio = "-";
        
        if(!precio.equals("-")){
            NumberFormat formatea = NumberFormat.getNumberInstance();            
            int valor = Integer.parseInt(precio);
            formatea.setMaximumFractionDigits(0);
            nuevoPrecio = formatea.format(valor);
        }
        this.precio = nuevoPrecio;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        String nuevoSaldo = "-";
        
        if(!saldo.equals("-")){
            NumberFormat formatea = NumberFormat.getNumberInstance();            
            int valor = Integer.parseInt(saldo);
            formatea.setMaximumFractionDigits(0);
            nuevoSaldo = formatea.format(valor);
        }
        this.saldo = nuevoSaldo;
    
    }   

        
}
 