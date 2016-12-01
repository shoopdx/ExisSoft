/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Entrega;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author Marcos Pulgar
 */
public class EntregaDAO extends Conexion {

    public ArrayList<Entrega> getEntregas() {

        String sql = " SELECT * FROM entrega ORDER BY fechaEntrega DESC";
        ResultSet datos = this.query(sql);

        ArrayList<Entrega> entregas = new ArrayList();

        try {
            if (datos != null) {
                while (datos.next()) {
                    Entrega e = new Entrega();
                    e.setCodigoArt(datos.getInt("codigoArt"));
                    e.setNombreDepa(datos.getString("nombreDepa"));
                    e.setFechaEntrega(datos.getString("fechaEntrega"));
                    e.setCantidadArt(datos.getInt("cantidadArt"));
                    e.setEstado(datos.getString("estado"));
                    e.setPrecioUnitario(datos.getInt("precioUnitario"));
                    e.setNumeroEntrega(datos.getInt("numeroEntrega"));
                    e.setCategoria(datos.getString("categoria"));
                    entregas.add(e);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al cargar entregas\n" + e.getMessage());
        }
        return entregas;
    }

    public boolean agregar(int codigoArt, String nombreDepa, String fechaEntrega, int cantidadArt, int precio, String cat) {
        nombreDepa.trim();
        fechaEntrega.trim();
        String sql = "INSERT INTO entrega (codigoArt, nombreDepa, fechaEntrega, cantidadArt, estado, precioUnitario, categoria) VALUES ('" + codigoArt + "','" + nombreDepa + "','" + fechaEntrega + "','" + cantidadArt + "', 'Autorizado', '" + precio + "', '" + cat + "')";

        try {
            this.setMessage("Entrega agregada");
            return this.executeUpdate(sql);
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            return false;
        }
    }

    public ArrayList<Entrega> entregasPorFecha(String fechaInicio, String fechaFin) {
        //fecha año-mes-dia
        String sql = "SELECT * FROM entrega WHERE fechaEntrega BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
        ResultSet datos = this.query(sql);
        ArrayList<Entrega> entregas = new ArrayList();

        try {
            if (datos != null) {
                while (datos.next()) {
                    Entrega e = new Entrega();

                    e.setCodigoArt(datos.getInt("codigoArt"));
                    e.setCantidadArt(datos.getInt("cantidadArt"));
                    e.setFechaEntrega(datos.getString("fechaEntrega"));
                    e.setNombreDepa(datos.getString("nombreDepa"));
                    e.setEstado(datos.getString("estado"));

                    entregas.add(e);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al buscar entregas por fecha \n" + e.getMessage());
        }

        return entregas;
    }

//     public boolean anular (int numeroEntrega){
//        String sql = "UPDATE articulo SET estado = 'Nula' WHERE fechaEntrega = '"+fecha+"' AND nombreDepa = '"+depa+"' AND codigoArt = '"+codArt+"'";
//        try {
//            this.executeUpdate(sql);
//            this.setMessage("Entrega anulada");
//            return true;
//        } catch (Exception e) {
//            this.setMessage("Error al anular Entrega");
//            return false;
//        }
//    }
    public ArrayList<Entrega> getStockEntregas(String fecha, int codigo, String cat) {

        String sql = "SELECT entrega.cantidadArt, entrega.codigoArt FROM entrega WHERE fechaEntrega < '" + fecha + "' AND entrega.codigoArt = '" + codigo + "' AND entrega.categoria = '" + cat + "'";
        ResultSet datos = this.query(sql);

        ArrayList<Entrega> entregas = new ArrayList();

        try {
            if (datos != null) {
                while (datos.next()) {
                    Entrega e = new Entrega();
                    e.setCantidadArt(datos.getInt("cantidadArt"));

                    entregas.add(e);
                }
            }
        } catch (Exception e) {
            this.setMessage("Error al cargar entregas\n" + e.getMessage());
        }
        return entregas;
    }

    public boolean ModificarEntrega(String fecha, String depa, String cat, int codArt, int cantidad) {
        String sql = "Update entrega SET cantidadArt = '" + cantidad + "' WHERE nombreDepa = '" + depa + "' and DATE_FORMAT(fechaEntrega, '%d/%m/%y') = '" + fecha + "' and codigoArt = '" + codArt + "' and categoria = '" + cat + "'";

        try {
            this.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            this.setMessage("Error" + e.getMessage());
            return false;
        }
    }

    public boolean ModificarPrecioEntrega(String fecha, String depa, String cat, int codArt, int precio) {
        String sql = "Update entrega SET precioUnitario = '" +precio+ "' WHERE nombreDepa = '" + depa + "' and DATE_FORMAT(fechaEntrega, '%d/%m/%Y') = '"+fecha+"' and codigoArt = '"+codArt+"' and categoria = '"+cat+"'";

        try {
            this.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            this.setMessage("Error" + e.getMessage());
            return false;
        }
    }
    
    public boolean BorrarEntrega(String fecha, String depa, String cat, int codArt) {
        String sql = "DELETE FROM entrega WHERE nombreDepa = '"+depa+"' AND fechaEntrega = '"+fecha+"' AND codigoArt = '"+codArt+"' AND categoria = '"+cat+"'";

        try {
            this.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            this.setMessage("Error" + e.getMessage());
            return false;
        }
    }
}
