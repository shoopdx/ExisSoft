/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.NumberFormat;

/**
 *
 * @author shoop
 */
public class util {
    
    
    public String formatearNumero(String saldo) {
        String nuevoPus = "-";
        
        if(!saldo.equals("-")){
            NumberFormat formatea = NumberFormat.getNumberInstance();            
            int valor = Integer.parseInt(saldo);
            formatea.setMaximumFractionDigits(0);
            nuevoPus = formatea.format(valor);
        }
        return nuevoPus;
        
    }    
}
