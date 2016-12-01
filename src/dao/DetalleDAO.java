/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.Detalle;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class DetalleDAO extends Conexion{
    
    public ArrayList <Detalle> getDetalleIngreso (String fechaInicio, String fechaFin, int codigo, String cat){
    
        String sql = "SELECT fechaIngreso AS fecha,  numeroFactura,  nombreprov as od, cantidad as entrada, ingreso.precioUnitario as pue From provedor join factura using (idProv) join ingreso using (idFactura) join articulo using (codigoArt, categoria) Where codigoArt = '"+codigo+"' and categoria = '"+cat+"' AND fechaIngreso BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' AND factura.estado <> 'Nula' order by fecha";
        
        ResultSet datos = this.query(sql) ;
        ArrayList <Detalle> detalles = new ArrayList();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Detalle d = new Detalle();
                    
                    d.setFecha(datos.getDate("fecha"));
                    d.setNumeroFactura(datos.getInt("numeroFactura"));
                    d.setOd(datos.getString("od"));
                    d.setEntrada(datos.getInt("entrada"));
                    d.setPue(datos.getInt("pue"));
                    
                    detalles.add(d);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error\n"+ e.getMessage());
        }
        return detalles;
    }
    
    public ArrayList <Detalle> getDetalleSalidas (String fechaInicio, String fechaFin, int codigo, String cat){
        
        String sql = "SELECT fechaEntrega AS fecha, nombredepa AS od, cantidadArt AS salida, entrega.precioUnitario AS pus From departamento join entrega using (nombredepa) join articulo using (codigoArt, categoria)  Where codigoArt = '"+codigo+"' AND categoria = '"+cat+"' AND fechaEntrega BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' AND entrega.estado <> 'Nula' order by fecha";
        
        ResultSet datos = this.query(sql);
        ArrayList <Detalle> detalles = new ArrayList();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Detalle d = new Detalle();
                    
                    d.setFecha(datos.getDate("fecha"));
                    d.setOd(datos.getString("od"));
                    d.setSalida(datos.getInt("salida"));
                    d.setPus(datos.getInt("pus"));
                    
                    detalles.add(d);
                }
            }
        } catch (Exception e) {}
        
        return detalles;
        
    }
}
