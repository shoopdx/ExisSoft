package dao;

import beans.Departamento;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class DepartamentoDAO extends Conexion {
    
    public ArrayList <Departamento> getDepartamentos(){
        
        String sql = "SELECT * FROM departamento ORDER BY nombreDepa";
        ResultSet datos = this.query(sql);
        ArrayList <Departamento> departamentos = new ArrayList ();
        
        try {
            if (datos != null){
                while (datos.next()){
                    Departamento d = new Departamento();
                    
                    d.setNombreDepa(datos.getString("nombreDepa"));
                    
                    departamentos.add(d);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al cargar Departamentos");
        }
        return departamentos;
        
    }
    
    public boolean agregar (String nombre){
        nombre.trim();
        String sql = "INSERT INTO departamento VALUES ('"+nombre+"')";
        
        try {
            
            this.executeUpdate(sql);
            this.setMessage("Departamento agregado");
            return true;
            
            
            
        } catch (Exception e) {
            this.setMessage("Error al agregar departamento");
            return false;
        }
    }
    
}
