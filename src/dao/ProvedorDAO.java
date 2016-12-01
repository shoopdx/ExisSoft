package dao;

import beans.Provedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;


/**
 *
 * @author Marcos Pulgar
 */
public class ProvedorDAO extends Conexion {
    
    public ArrayList <Provedor> getProvedores(){
        String sql = "SELECT * FROM provedor ORDER BY nombreprov";
        ResultSet datos = this.query(sql);
        ArrayList <Provedor> provedores = new ArrayList ();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Provedor pv = new Provedor ();
                    pv.setIdProv(datos.getInt("idProv"));
                    pv.setRutProv(datos.getString("rutProv"));
                    pv.setNombreProv(datos.getString("nombreProv"));
                    pv.setDireccion(datos.getString("direccion"));
                    pv.setTelefono(datos.getInt("telefono"));
                    
                    provedores.add(pv);
                }
            }
        } catch (Exception e) {
            this.setMessage("No se pueden obtener los datos \n"+e.getMessage());
        }
        return provedores;
    }
    
    public boolean agregar (String rut, String nombre,int telefono, String direccion){
        rut.trim();
        nombre.trim();
        direccion.trim();
        String sql = "INSERT INTO provedor (rutProv, nombreProv,telefono, direccion) VALUES ('"+rut+"','"+nombre+"','"+telefono+"','"+direccion+"')";
        
        if(!this.verificar("SELECT * FROM provedor WHERE rut ='"+rut+"'")){            
            this.setMessage("Provedor ingresado");
            return this.executeUpdate(sql);
        }else{
            this.setMessage("No se ha podido agregar provedor");
            return false;
        }
    }
    
    public boolean actualizar (int idProv, String rut, String nombre, int telefono, String direccion){
        
        rut.trim();
        nombre.trim();
        direccion.trim();
        
        String sql = "UPDATE provedor SET rut = '"+rut+"', nombre = '"+nombre+"', telefono = '"+telefono+"', direccion = '"+direccion+"' WHERE idProv = '"+idProv+"'" ;
        
        try {
            this.executeUpdate(sql);
            this.setMessage("Provedor actualizado");
            return true;
            
                
        } catch (Exception e) {
            this.setMessage("Error al actualizar \n"+e.getMessage());
            return false;
        }
        
    }
        
    
    
}
