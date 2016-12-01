/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class UserDAO extends Conexion {
    
    public ArrayList <User> getUsuarios(){
        String sql = "SELECT * FROM user";
        ResultSet datos = this.query(sql);
        
        ArrayList <User> usuarios = new ArrayList ();
        
        try {
            if(datos != null){
                while (datos.next()){
                    User u = new User();
                    
                    u.setId(datos.getInt("id"));
                    u.setUsuario(datos.getString("usuario"));
                    u.setContrasenia(datos.getString("contrasenia"));
                    
                    usuarios.add(u);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al obtener usuarios");
        }
        
        return usuarios;
    }
    
    public boolean cambiarClave (int id, String contraseña){
        String sql = "Update user SET contrasenia = '"+contraseña+"' WHERE id = '"+id+"'";
        
        try {
            this.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            this.setMessage("Error"+ e.getMessage());
            return false;
        }
    }
    
}
