package dao;

import beans.Factura;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */

//La factura se editara entera a travez del ID poniendo todo en un txtfield
public class FacturaDAO extends Conexion {
    
    public ArrayList <Factura> getFacturas(){
        
        String sql = "SELECT idFactura, numeroFactura, DATE_FORMAT(fechaIngreso, '%d/%m/%y') fechaIngreso, idProv, estado FROM factura ORDER BY fechaIngreso DESC";
        ResultSet datos = this.query(sql);
        ArrayList <Factura> facturas = new ArrayList ();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Factura f = new Factura();
                    
                    f.setIdFactura(datos.getInt("idFactura"));
                    f.setNumeroFactura(datos.getInt("numeroFactura"));
                    f.setFechaIngreso(datos.getString("fechaIngreso"));
                    f.setIdProv(datos.getInt("idProv"));
                    f.setEstado(datos.getString("estado"));
                    
                    facturas.add(f);
                }
            }
        } catch (Exception e) {
            this.setMessage("No se pueden obtener las facturas\n"+e.getMessage());
        }
        return facturas;
        
    }
    
    public ArrayList <Factura> getFacturasPorNumero(){
        
        String sql = "SELECT idFactura, numeroFactura FROM factura WHERE estado <> 'Nula' ORDER BY fechaIngreso DESC";
        ResultSet datos = this.query(sql);
        ArrayList <Factura> facturas = new ArrayList ();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Factura f = new Factura();
                    
                    f.setIdFactura(datos.getInt("idFactura"));
                    f.setNumeroFactura(datos.getInt("numeroFactura"));
                   
                    facturas.add(f);
                }
            }
        } catch (Exception e) {
            this.setMessage("No se pueden obtener las facturas\n"+e.getMessage());
        }
        return facturas;
        
    }
    public boolean agregar (int numeroFactura, String fechaIngreso, int idProv){
        fechaIngreso.trim();
        
        String sql = "INSERT INTO factura (numeroFactura, fechaIngreso, idProv, estado) VALUES ('"+numeroFactura+"','"+fechaIngreso+"','"+idProv+"', 'Autorizado')";
        try{
        if (!this.verificar("SELECT * FROM factura WHERE numeroFactura = '"+numeroFactura+"'")) {
            this.setMessage("Factura agregada");
            return this.executeUpdate(sql);
        
        }
        }catch(Exception e){
            this.setMessage("Error \n"+e.getMessage());
            return false;
        }
        return this.executeUpdate(sql);
    }
    
    
        
    
    
    public ArrayList <Factura> buscaPorFecha (String fechaInicio, String fechaFin){
        //fecha año/mes/dia
        
        String sql = "SELECT idFactura, numeroFactura, DATE_FORMAT(fechaIngreso, '%d/%m/%y') fechaIngreso, idProv, estado FROM factura WHERE fechaIngreso BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'";
        
        ResultSet datos = this.query(sql);
        
        ArrayList <Factura> facturas = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
                    Factura f = new Factura();
                    
                    f.setIdFactura(datos.getInt("idFactura"));
                    f.setNumeroFactura(datos.getInt("numeroFactura"));
                    f.setFechaIngreso(datos.getString("fechaIngreso"));
                    f.setIdProv(datos.getInt("idProv"));
                    f.setEstado(datos.getString("estado"));
                    
                    facturas.add(f);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al buscar por fecha \n"+e.getMessage());
        }
        
        return facturas;
    }
    
    public ArrayList <Factura> facturaPorCodigo (String codigo){
        //fecha año/mes/dia
        
        String sql = "SELECT idFactura, numeroFactura, DATE_FORMAT(fechaIngreso, '%d/%m/%y') fechaIngreso, idProv, estado FROM factura WHERE numeroFactura = '"+codigo+"'";
        
        ResultSet datos = this.query(sql);
        
        ArrayList <Factura> facturas = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
                    Factura f = new Factura();
                    
                    f.setIdFactura(datos.getInt("idFactura"));
                    f.setNumeroFactura(datos.getInt("numeroFactura"));
                    f.setFechaIngreso(datos.getString("fechaIngreso"));
                    f.setIdProv(datos.getInt("idProv"));
                    f.setEstado(datos.getString("estado"));
                    
                    facturas.add(f);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al buscar por fecha \n"+e.getMessage());
        }
        
        return facturas;
    }
    
     public boolean anular (int nroFactura, int idFactura){
        String sql = "UPDATE factura SET estado = 'Nula' WHERE numeroFactura = '"+nroFactura+"' AND idFactura = '"+idFactura+"'" ;
        try {
            this.executeUpdate(sql);
            this.setMessage("Factura anulada");
            return true;
        } catch (Exception e) {
            this.setMessage("Error al anular factura");
            return false;
        }
    }
        
}
