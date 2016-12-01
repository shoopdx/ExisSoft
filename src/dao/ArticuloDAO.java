package dao;

import beans.Articulo;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class ArticuloDAO extends Conexion {
    
    public ArrayList <Articulo> getArticulos (){
        String sql = "SELECT * FROM articulo ORDER BY codigoArt";
        ResultSet datos = this.query(sql);
        
        ArrayList <Articulo> articulos = new ArrayList ();
        
        try {
            if(datos != null){
            while(datos.next()){
                Articulo a = new Articulo();
                
                a.setCodigoArt(datos.getInt("codigoArt"));
                a.setNombreArt(datos.getString("nombreArt"));
                a.setCategoria(datos.getString("categoria"));
                                
                articulos.add(a);
                
            }
        }
        } catch (Exception e) {
            this.setMessage("Error al cargar articulos\n"+e.getMessage());
        
        }
        return articulos;        
    }
    
    public ArrayList <Articulo> getArticulos2 (){
        String sql = "SELECT * FROM articulo ORDER BY codigoArt";
        ResultSet datos = this.query(sql);
        
        ArrayList <Articulo> articulos = new ArrayList ();
        
        try {
            if(datos != null){
            while(datos.next()){
                Articulo a = new Articulo();
                
                a.setCodigoArt(datos.getInt("codigoArt"));
                a.setNombreArt(datos.getString("nombreArt"));
                a.setCategoria(datos.getString("categoria"));
                                
                articulos.add(a);
                
            }
        }
        } catch (Exception e) {
            this.setMessage("Error al cargar articulos\n"+e.getMessage());
        
        }
        return articulos;        
    }
    
    public ArrayList <Articulo> getAxC (String cat){
        String sql = "SELECT * FROM articulo WHERE categoria = '"+cat+"' ORDER BY codigoArt";
        ResultSet datos = this.query(sql);
        
        ArrayList <Articulo> articulos = new ArrayList ();
        
        try {
            if(datos != null){
            while(datos.next()){
                Articulo a = new Articulo();
                
                a.setCodigoArt(datos.getInt("codigoArt"));
                a.setNombreArt(datos.getString("nombreArt"));
                
                                
                articulos.add(a);
                
            }
        }
        } catch (Exception e) {
            this.setMessage("Error al cargar articulos\n"+e.getMessage());
        
        }
        return articulos;        
    }
    
    public ArrayList <Articulo> getAparaCombo (String cat){
        String sql = "SELECT * FROM articulo WHERE categoria = '"+cat+"' ORDER BY nombreArt";
        ResultSet datos = this.query(sql);
        
        ArrayList <Articulo> articulos = new ArrayList ();
        
        try {
            if(datos != null){
            while(datos.next()){
                Articulo a = new Articulo();
                
                a.setCodigoArt(datos.getInt("codigoArt"));
                a.setNombreArt(datos.getString("nombreArt"));
                
                                
                articulos.add(a);
                
            }
        }
        } catch (Exception e) {
            this.setMessage("Error al cargar articulos\n"+e.getMessage());
        
        }
        return articulos;        
    }
    
    public boolean agregar (int codigoArt, String nombreArt, String cat){
        nombreArt.trim();
        String sql = "INSERT INTO articulo (codigoArt, nombreArt, categoria) VALUES ('"+codigoArt+"','"+nombreArt+"', '"+cat+"')";
        
        if(!this.verificar("SELECT * FROM articulo WHERE nombreArt = '"+nombreArt+"'")){
            this.setMessage("Articulo agregado");
            return this.executeUpdate(sql);
        }else{
            this.setMessage("Error al agregar articulo");
            return false;
        }        
        
    }
   
//    public boolean ArticuloACero (){
//        String sql = "UPDATE ingreso SET precioUnitario = 0"
//    }
    
        
}
