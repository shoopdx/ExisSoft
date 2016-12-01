package dao;

import beans.Stock;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar 
 */
public class StockDAO extends Conexion {
    
    public ArrayList <Stock> getStock(){
        
        String sql = "SELECT * FROM stock";
        ResultSet datos = this.query(sql);
        
        ArrayList <Stock> stocks = new ArrayList();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Stock s = new Stock();
                    
                    s.setStock(datos.getInt("stock"));
                    s.setCodigoArt(datos.getInt("codigoArt"));
                    s.setCategoria(datos.getString("categoria"));
                    
                    stocks.add(s);
                }
            }
            
        } catch (Exception e) {
            this.setMessage("Error al cargar el stock"+e.getMessage());
        }
        return stocks;
    }
    
    public ArrayList <Stock> getStock2(String cat){
        
        String sql = "SELECT * FROM stock WHERE categoria = '"+cat+"'";
        ResultSet datos = this.query(sql);
        
        ArrayList <Stock> stocks = new ArrayList();
        
        try {
            if(datos != null){
                while(datos.next()){
                    Stock s = new Stock();
                    
                    s.setStock(datos.getInt("stock"));
                    s.setCodigoArt(datos.getInt("codigoArt"));
                    s.setCategoria(datos.getString("categoria"));
                    
                    stocks.add(s);
                }
            }
            
        } catch (Exception e) {
            this.setMessage("Error al cargar el stock"+e.getMessage());
        }
        return stocks;
    }
    
    public Stock getStockUnico(String cat, int codArt){
        
        String sql = "SELECT * FROM stock WHERE categoria = '"+cat+"' and codigoArt = '"+codArt+"'";
        ResultSet datos = this.query(sql);
        
        Stock s = new Stock();
        
        try {
            if(datos != null){
                while(datos.next()){
                    
                    s.setStock(datos.getInt("stock"));
                    s.setCodigoArt(datos.getInt("codigoArt"));
                    s.setCategoria(datos.getString("categoria"));
                    
                    
                }
            }
            
        } catch (Exception e) {
            this.setMessage("Error al cargar el stock"+e.getMessage());
        }
        return s;
    }
    
    
    public boolean agregar (int stock, int codigoArt, String cat){
        String sql = "INSERT INTO stock (stock, codigoArt, categoria) VALUES ('"+stock+"', '"+codigoArt+"', '"+cat+"')";
        
        try {
            this.executeUpdate(sql);
            this.setMessage("Stock agregado");
            return true;
        } catch (Exception e) {
            this.setMessage("Error al agregar"+e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar (int stock, int codigoArt, String cat ){
        String sql = "UPDATE stock SET stock = '"+stock+"' WHERE codigoArt = '"+codigoArt+"' AND categoria = '"+cat+"'";
        
        
        
        try {
            this.executeUpdate(sql);
            this.setMessage("Stock actualizado");
            return true;
        } catch (Exception e) {
            this.setMessage("Error al actualizar \n"+e.getMessage());
            return false;
        }
    }

}
