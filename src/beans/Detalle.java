/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Marcos Pulgar
 */
public class Detalle {
    
    Date date = new Date();
    
    private Date fecha;
    private int numeroFactura;
    private String od;
    private int entrada;
    private int pue;
    private int salida;
    private int pus;
    private int saldo;

    public Detalle() {
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFecha()  {
        
        
        
        return fecha;
    }

//    public void setFecha(String fecha) throws ParseException {
//        SimpleDateFormat formatear = new SimpleDateFormat("dd/MM/yyyy");
//        this.fecha = formatear.parse(fecha);
//    }

    public void setFecha(Date fecha)  {
//        DateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            Date nuevaFecha = formatear.parse(fecha);
            this.fecha = fecha;
//        } catch (ParseException ex) {
//            Logger.getLogger(Detalle.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getPue() {
        return pue;
    }

    public void setPue(int pue) {
        this.pue = pue;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getPus() {
        return pus;
    }

    public void setPus(int pus) {
        this.pus = pus;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    

}