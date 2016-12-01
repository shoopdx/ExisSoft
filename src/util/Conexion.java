package util;

/**
 *
 * @author Marcos Pulgar
 */

import java.sql.*;

public class Conexion {

    private final String _db = "escuela";
    private final String _url = "jdbc:mysql://localhost:3306/" + _db;
    private final String _user = "root";
    private final String _pass = "";
    private String _msg;
    private Connection _con;
    private Statement _st;

    public Conexion() {
        _msg = null;
        _con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            _con = DriverManager.getConnection(_url, _user, _pass);
            _st = _con.createStatement();
            _msg = "Conexión Exitosa";

        } catch (Exception ex) {
            _msg = "Ha ocurrido un error : " + ex.getMessage();
        }
    }

    public String getMessage() {
        return _msg;
    }

    public void setMessage(String msg) {
        _msg += "\n";
        _msg += msg;
    }

    public boolean close() {
        try {
            _con.close();
            _msg = "Desconectado";
            return true;
        } catch (Exception ex) {
            _msg = "No se pudo cerrar la conexión";
            return false;
        }
    }

    public ResultSet query(String SQL) {
        ResultSet datos = null;
        try {
            _st = _con.createStatement();
            datos = _st.executeQuery(SQL);

        } catch (Exception ex) {
            _msg = "La consulta no pudo ser realizada\n"+ex.getMessage();
        }
        return (datos);
    }

    public boolean executeUpdate(String SQL) {
        try {
            _st.executeUpdate(SQL);
            _msg = "Ejecucion exitosa";

            return true;
        } catch (Exception ex) {
            _msg = "No se pudo realizar\n"+ ex.getMessage();
            return false;
        }

    }
    
    public boolean verificar (String sql){
        
        ResultSet resp ;
         try{
       _st = _con.createStatement();
            resp = _st.executeQuery(sql);
            return resp.next();
        }catch(Exception e){
            _msg = "estos datos ya existen";
         return false;
        }
    }
}
