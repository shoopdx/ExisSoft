/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 *
 * @author Marcos Pulgar
 */
public class Detalle2 {
    
    DecimalFormat formateador = new DecimalFormat("###,###.##");
    
    Date date = new Date();
    
    private String fecha;
    private String numeroFactura;
    private String od;
    private String entrada;
    private String pue;
    private String salida;
    private String pus;
    private String saldo;

    public Detalle2() {
    }

    public Detalle2(String fecha, String numeroFactura, String od, String entrada, String pue, String salida, String pus, String saldo) {
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.od = od;
        this.entrada = entrada;
        this.pue = pue;
        this.salida = salida;
        this.pus = pus;
        this.saldo = saldo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getPue() {
        return pue;
    }

    public void setPue(String pue) {
        String nuevoPue = "-";
        
        if(!pue.equals("-")){
            NumberFormat formatea = NumberFormat.getNumberInstance();            
            int valor = Integer.parseInt(pue);
            formatea.setMaximumFractionDigits(0);
            nuevoPue = formatea.format(valor);
        }
        this.pue = nuevoPue;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getPus() {               
        return pus;
    }

    public void setPus(String pus) {
        String nuevoPus = "-";
        
        if(!pus.equals("-")){
            NumberFormat formatea = NumberFormat.getNumberInstance();            
            int valor = Integer.parseInt(pus);
            formatea.setMaximumFractionDigits(0);
            nuevoPus = formatea.format(valor);
        }
        this.pus = nuevoPus;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
                
        this.saldo = saldo;
    }

    
}