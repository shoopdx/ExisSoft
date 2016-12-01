/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.GuiaEntrega;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class GuiaEntregaDAO extends Conexion{
   
    public ArrayList <GuiaEntrega> getGuias(String fechaInicio, String fechaFin, String depa, String cat){
        
        String sql = "SELECT DATE_FORMAT(fechaEntrega, '%d/%m/%y') fecha, articulo.nombreArt AS articulo,  entrega.cantidadArt AS cantidad, entrega.nombreDepa AS departamento FROM entrega JOIN articulo USING (codigoArt, categoria) WHERE fechaEntrega BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'  AND categoria = '"+cat+"' AND nombreDepa = '"+depa+"' AND entrega.estado <> 'Nula' ORDER BY fechaEntrega";
        
        ResultSet datos = this.query(sql);
        ArrayList <GuiaEntrega> guias = new ArrayList ();
        
        try {
            if(datos != null){
                while(datos.next()){
                    GuiaEntrega ge = new GuiaEntrega();
                    ge.setFecha(datos.getString("fecha"));
                    ge.setArtiuclo(datos.getString("articulo"));
                    ge.setCantidad(datos.getString("cantidad"));                    
                    ge.setNombreDepa(datos.getString("departamento"));
                    
                    guias.add(ge);
                    
                }
            }   
        } catch (Exception e) {
        
            this.setMessage("Error /n"+e.getMessage());
            
        }
    
        return guias;
    }
    
    
}
