/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.Ingreso;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class IngresoDAO extends Conexion {
    
    public ArrayList <Ingreso> getIngreso(){
        String sql = "SELECT i.cantidad, i.estado, i.idFactura, i.codigoArt, i.categoria, i.precioUnitario FROM ingreso i JOIN factura USING (idFactura) Where factura.estado <> 'Nula'";
        ResultSet datos = this.query(sql);
        
        ArrayList <Ingreso> ingresos = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
                     Ingreso i = new Ingreso();
            i.setIdFactura(datos.getInt("idFactura"));
            i.setCodigoArt(datos.getInt("codigoArt"));
            i.setEstado(datos.getString("estado"));
            i.setCategoria(datos.getString("categoria"));
            i.setCantidad(datos.getInt("cantidad"));
            i.setPrecioUnitario(datos.getInt("precioUnitario"));
            ingresos.add(i);
                }
            }
           
        } catch (Exception e) {
            this.setMessage("Error ");
        }
        
        return ingresos;
    }

    public ArrayList <Ingreso> getIngresoxC(String cat){
        String sql = "SELECT i.cantidad, i.estado, i.idFactura, i.codigoArt, i.categoria, i.precioUnitario FROM ingreso i JOIN factura USING (idFactura) WHERE i.categoria = '"+cat+"' AND factura.estado <> 'Nula'";
        ResultSet datos = this.query(sql);
        
        ArrayList <Ingreso> ingresos = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
                     Ingreso i = new Ingreso();
            i.setIdFactura(datos.getInt("idFactura"));
            i.setCodigoArt(datos.getInt("codigoArt"));
            i.setEstado(datos.getString("estado"));
            i.setCategoria(datos.getString("categoria"));
            i.setCantidad(datos.getInt("cantidad"));
            i.setPrecioUnitario(datos.getInt("precioUnitario"));
            ingresos.add(i);
                }
            }
           
        } catch (Exception e) {
            this.setMessage("Error ");
        }
        
        return ingresos;
    }
    
    public boolean agregar (int idFactura, int codigoArt, int cantidad, int precio, String cat){
        
        String sql = "INSERT INTO ingreso (idFactura, codigoArt, cantidad, precioUnitario, categoria) VALUES ('"+idFactura+"', '"+codigoArt+"', '"+cantidad+"', '"+precio+"', '"+cat+"')";
        
        try {
            this.executeUpdate(sql);
            this.setMessage("Ingresado");
            return true;
        } catch (Exception e) {
            this.setMessage("Error al ingresar");
            return false;
        }
        
    }
    
    public boolean anular (int idFactura, int codigoArt, String cat){
        String sql = "UPDATE ingreso SET estado = 'Nulo' WHERE idFactura '"+idFactura+"' AND codigoArt = '"+codigoArt+"' AND categoria = '"+cat+"'";
        
        try {
            this.executeUpdate(sql);
            this.setMessage("Ingreso anulado");
            return true;
        } catch (Exception e) {
            this.setMessage("Error al anular ingreso");
            return false;
        }
        
    }
    
    public ArrayList <Ingreso> getStockAnterior(String fecha, int codigo, String cat){
        String sql = "SELECT ingreso.cantidad FROM ingreso JOIN factura USING (idFactura) WHERE factura.estado <> 'Nula' AND fechaIngreso < '"+fecha+"' AND ingreso.codigoArt = '"+codigo+"' AND ingreso.categoria = '"+cat+"'";
        ResultSet datos = this.query(sql);
        
        ArrayList <Ingreso> ingresos = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
            Ingreso i = new Ingreso();
            i.setCantidad(datos.getInt("cantidad"));
            ingresos.add(i);
                }
            }
           
        } catch (Exception e) {
            this.setMessage("Error ");
        }
        
        return ingresos;
    }
    
    public ArrayList <Ingreso> getIngresoDetalle(int id){
        String sql = "SELECT i.cantidad, i.codigoArt, i.precioUnitario, i.categoria FROM ingreso i JOIN factura USING (idFactura) WHERE factura.estado <> 'Nula' AND idFactura = '"+id+"'";
        ResultSet datos = this.query(sql);
        
        ArrayList <Ingreso> ingresos = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
                    Ingreso i = new Ingreso();
                    i.setCodigoArt(datos.getInt("codigoArt"));
                    i.setCantidad(datos.getInt("cantidad"));
                    i.setPrecioUnitario(datos.getInt("precioUnitario"));
                    i.setCategoria(datos.getString("categoria"));
                    ingresos.add(i);
                }
            }
           
        } catch (Exception e) {
            this.setMessage("Error ");
        }
        
        return ingresos;
    }
    
    
     public boolean Editar (int idFactura, int codigoArt, String cat, int cantidad, int precio){
        String sql = "UPDATE ingreso SET cantidad = '"+cantidad+"', precioUnitario = '"+precio+"' WHERE idFactura = '"+idFactura+"' AND codigoArt = '"+codigoArt+"' AND categoria = '"+cat+"'";
        
        try {
            this.executeUpdate(sql);
            this.setMessage("Factura Actualizada");
            return true;
        } catch (Exception e) {
            this.setMessage("Error al Actualizar Factura");
            return false;
        }
        
    }
    
    
//    public boolean Editar(){
//        String sql = "UPDATE ingreso SET estado = 'Nulo' WHERE idFactura '"+idFactura+"' AND codigoArt = '"+codigoArt+"' AND categoria = '"+cat+"'";
//        
//    return false;
//    }
}
