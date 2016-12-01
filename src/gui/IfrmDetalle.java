/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Articulo;
import beans.Detalle;
import beans.Detalle2;
import beans.Entrega;
import beans.Factura;
import beans.Ingreso;
import beans.Provedor;
import beans.ReporteProductos;
import beans.Stock;
import dao.ArticuloDAO;
import dao.DetalleDAO;
import dao.EntregaDAO;
import dao.FacturaDAO;
import dao.IngresoDAO;
import dao.ProvedorDAO;
import dao.StockDAO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import util.Imprimir;

/**
 *
 * @author Marcos Pulgar
 */
public class IfrmDetalle extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    int codigo;
    DateFormat formatear = new SimpleDateFormat("dd/MM/yyyy");
    int precioAntiguo;
    String fecha;
    String depa;
    

    /**
     * Creates new form IfrmDetalle
     */
    public IfrmDetalle() {
        initComponents();

        model = (DefaultTableModel) tabDetalle.getModel();

        TableColumn fecha = tabDetalle.getColumn("Fecha");
        TableColumn nro = tabDetalle.getColumn("N° Dcto");
        TableColumn od = tabDetalle.getColumn("Origen/Destino");
        TableColumn e = tabDetalle.getColumn("Entrada");
        TableColumn pu1 = tabDetalle.getColumn("P. Unit. Ent");
        TableColumn s = tabDetalle.getColumn("Salida");
        TableColumn pu2 = tabDetalle.getColumn("P. Unit. Sal");
        TableColumn saldo = tabDetalle.getColumn("Saldo");
        fecha.setPreferredWidth(40);
        nro.setPreferredWidth(20);
        od.setPreferredWidth(180);
        e.setPreferredWidth(20);
        pu1.setPreferredWidth(30);
        s.setPreferredWidth(20);
        pu2.setPreferredWidth(30);
        saldo.setPreferredWidth(30);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboArticulos = new javax.swing.JComboBox();
        btnDetalle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDetalle = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        dteInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dteFin = new com.toedter.calendar.JDateChooser();
        lblTotal = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboCat = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Libro");

        jLabel1.setText("Articulo:");

        btnDetalle.setText("Ver detalle");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        tabDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "N° Dcto", "Origen/Destino", "Entrada", "P. Unit. Ent", "Salida", "P. Unit. Sal", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabDetalle.setToolTipText("Fecha, N° documento, Origen/Destino, Entrada, Precio Unitario, Salida, Precio Unitario, Saldo");
        tabDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabDetalle);

        jLabel3.setText("Entre: ");

        jLabel4.setText("y");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria:");

        cboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "2204001", "2204007", "2204009" }));
        cboCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCatActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/gtk-refresh.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualizar datos");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dteInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dteFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btnDetalle)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cboArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetalle)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dteInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dteFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addGap(376, 376, 376)
                        .addComponent(btnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed

        DetalleDAO dd = new DetalleDAO();

        //crea las fechas y codigo 
        String diaI = String.valueOf(dteInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mesI = String.valueOf(dteInicio.getCalendar().get(Calendar.MONTH) + 1);
        String anioI = String.valueOf(dteInicio.getCalendar().get(Calendar.YEAR));
        String fechaInicio = anioI + "-" + mesI + "-" + diaI;

        String diaF = String.valueOf(dteFin.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mesF = String.valueOf(dteFin.getCalendar().get(Calendar.MONTH) + 1);
        String anioF = String.valueOf(dteFin.getCalendar().get(Calendar.YEAR));
        String fechaFin = anioF + "-" + mesF + "-" + diaF;

        String cat = cboCat.getSelectedItem().toString();

        ArticuloDAO ad = new ArticuloDAO();
        ArrayList<Articulo> articulos = ad.getAxC(cat);

        for (Articulo articulo : articulos) {
            if (articulo.getNombreArt().equals(cboArticulos.getSelectedItem())) {
                codigo = articulo.getCodigoArt();
                break;
            }
        }

        //fin
        //trae los arrayList y los suma 
        ArrayList<Detalle> detallesIngresos = dd.getDetalleIngreso(fechaInicio, fechaFin, codigo, cat);
        ArrayList<Detalle> detallesSalidas = dd.getDetalleSalidas(fechaInicio, fechaFin, codigo, cat);
        ArrayList<Detalle> detalles = new ArrayList();

        for (Detalle detalle : detallesSalidas) {
            Detalle d = new Detalle();

            d.setOd(detalle.getOd());
            d.setSalida(detalle.getSalida());

            d.setFecha(detalle.getFecha());
//                d.setFecha(detalle.getFecha().toString());

            d.setPus(detalle.getPus());

            detalles.add(d);
        }

        for (Detalle detalle : detallesIngresos) {
            Detalle d = new Detalle();

//                d.setFecha(detalle.getFecha().toString());
            d.setFecha(detalle.getFecha());
            d.setEntrada(detalle.getEntrada());
            d.setOd(detalle.getOd());
            d.setPue(detalle.getPue());
            d.setNumeroFactura(detalle.getNumeroFactura());

            detalles.add(d);
        }

        //Fin
        //Ordena el arrayList final
        Collections.sort(detalles, new Comparator() {

            @Override
            public int compare(Object t, Object t1) {
                Detalle detalles = (Detalle) t;
                Detalle detalles2 = (Detalle) t1;

                    // original => return detalles.getFecha().compareTo(detalles2.getFecha());
                return detalles.getFecha().compareTo(detalles2.getFecha());

            }
        });

        //fin
        //crea variables y borra las filas de la tabla 
        int stockA = 0;
        String numero = "", entrada = "", pue = "", salida = "", pus = "";

        int fil = tabDetalle.getRowCount();
        for (int i = 0; i < fil; i++) {
            model.removeRow(0);
        }
        //Fin

        //comienza llenado de jtable
        for (Detalle detalle : detalles) {

            stockA = stockAnterior(fechaInicio, codigo, cat);

            if (detalle.getNumeroFactura() == 0) {
                numero = "-";
            } else {
                numero = String.valueOf(detalle.getNumeroFactura());
            }
            if (detalle.getEntrada() == 0) {
                entrada = "-";
            } else {
                entrada = String.valueOf(detalle.getEntrada());
            }
            if (detalle.getPue() == 0) {
                pue = "-";
            } else {
                pue = String.valueOf(detalle.getPue());
            }
            if (detalle.getSalida() == 0) {
                salida = "-";
            } else {
                salida = String.valueOf(detalle.getSalida());
            }
            if (detalle.getPus() == 0) {
                pus = "-";
            } else {
                pus = String.valueOf(detalle.getPus());
            }

            int saldo = 0;

            Object filas[] = new Object[8];
            if (tabDetalle.getRowCount() == 0) {

                if (salida == "-") {
                    saldo = stockA + Integer.parseInt(entrada);
                } else {
                    saldo = stockA - Integer.parseInt(salida);
                }

                filas[0] = formatear.format(detalle.getFecha());

                filas[1] = numero;
                filas[2] = detalle.getOd();
                filas[3] = entrada;
                filas[4] = pue;
                filas[5] = salida;
                filas[6] = pus;
                filas[7] = saldo;

                model.addRow(filas);
            } else {

                filas[0] = formatear.format(detalle.getFecha());

                filas[1] = numero;
                filas[2] = detalle.getOd();
                filas[3] = entrada;
                filas[4] = pue;
                filas[5] = salida;
                filas[6] = pus;

                if (salida.equals("-")) {
                    int ent = Integer.parseInt(entrada);
                    filas[7] = cantidadActual(ent);
                } else {
                    int sal = Integer.parseInt(salida) * -1;
                    filas[7] = cantidadActual(sal);
                }

                model.addRow(filas);

            }
        }

        tabDetalle.setModel(model);

        //fin


    }//GEN-LAST:event_btnDetalleActionPerformed


    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        String ruta = System.getProperty("user.dir") + "\\reportes\\ReporteLibro.jasper";
        String ruta2 = System.getProperty("user.dir") + "\\reportes\\ReporteLibro.jrxml";

        List list = new ArrayList();
        int totalArt = tabDetalle.getRowCount();

        for (int i = 0; i < totalArt; i++) {
            Detalle2 lista = new Detalle2();
            lista.setFecha(tabDetalle.getValueAt(i, 0).toString());
            lista.setNumeroFactura(tabDetalle.getValueAt(i, 1).toString());
            lista.setOd(tabDetalle.getValueAt(i, 2).toString());
            lista.setEntrada(tabDetalle.getValueAt(i, 3).toString());
            lista.setPue(tabDetalle.getValueAt(i, 4).toString());
            lista.setSalida(tabDetalle.getValueAt(i, 5).toString());
            lista.setPus(tabDetalle.getValueAt(i, 6).toString());
            lista.setSaldo(tabDetalle.getValueAt(i, 7).toString());

            list.add(lista);
        }

        Map parametro = new HashMap();
        int cod = 0;
        String nombre = "";

        cod = codigo;
        nombre = buscaNombre(codigo);

        parametro.put("articulo", nombre);
        parametro.put("folio", cod);

        Imprimir imp = new Imprimir();
        imp.Impresion(ruta, parametro, list);

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCatActionPerformed
        cboArticulos.removeAllItems();
        if (cboCat.getSelectedIndex() != 0) {
            cargaCbo();
        }
    }//GEN-LAST:event_cboCatActionPerformed

    private void tabDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDetalleMouseClicked
        int row = tabDetalle.getSelectedRow();
        precioAntiguo = Integer.parseInt(model.getValueAt(row, 6).toString());
        fecha = model.getValueAt(row, 0).toString();
        this.depa = model.getValueAt(row, 2).toString();
        
    }//GEN-LAST:event_tabDetalleMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int row = tabDetalle.getSelectedRow();
        int precio = Integer.parseInt(model.getValueAt(row, 6).toString());
        int codigoArt = this.buscaCodigo(cboArticulos.getSelectedItem().toString());
        String cate = cboCat.getSelectedItem().toString();
        
        EntregaDAO ed = new EntregaDAO();
        
        int resp = JOptionPane.showConfirmDialog(null, "Desea cambiar el precio " + precioAntiguo + "(antiguo) por " +precio+"(nuevo)", "Confirmacion", JOptionPane.YES_NO_OPTION);

        if (resp == 0) {
            if (ed.ModificarPrecioEntrega(fecha, depa, cate, codigoArt, precio)) {
                JOptionPane.showMessageDialog(null, "Precio Actualizado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Precio No Actualizado", "Informacion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private String buscaNombre(int cod) {
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList<Articulo> articulos = ad.getAxC(cboCat.getSelectedItem().toString());

        String nombre = "";

        for (Articulo articulo : articulos) {
            if (articulo.getCodigoArt() == cod) {
                nombre = articulo.getNombreArt();
                break;
            }
        }
        return nombre;
    }

    private int cantidadActual(int stock) {
        int i = tabDetalle.getRowCount() - 1;

        int cantidad = Integer.parseInt(tabDetalle.getValueAt(i, 7).toString());

        int total = cantidad + stock;

        return total;

    }

    private int stockAnterior(String fecha, int cod, String cat) {
        IngresoDAO id = new IngresoDAO();
        ArrayList<Ingreso> ingresos = id.getStockAnterior(fecha, cod, cat);
        int ingreso = 0;
        for (Ingreso ingreso1 : ingresos) {
            ingreso = ingreso + ingreso1.getCantidad();
        }

        EntregaDAO ed = new EntregaDAO();
        ArrayList<Entrega> entregas = ed.getStockEntregas(fecha, cod, cat);
        int entre = 0;
        for (Entrega entrega : entregas) {
            entre = entre + entrega.getCantidadArt();
        }

        int stockAnterior = ingreso - entre;

        return stockAnterior;
    }

    private void cargaCbo() {
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList<Articulo> articulos = ad.getAparaCombo(cboCat.getSelectedItem().toString());

        for (Articulo articulo : articulos) {
            cboArticulos.addItem(articulo.getNombreArt());
        }
    }

    
    
    
    private int buscaCodigo(String nombre) {
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList<Articulo> articulos = ad.getArticulos();

        int cod = 0;

        for (Articulo articulo : articulos) {
            if (articulo.getNombreArt().equals(nombre)) {
                cod = articulo.getCodigoArt();
                break;
            }
        }
        return cod;
    }
    
    private String buscaCate(String nombre) {
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList<Articulo> articulos = ad.getArticulos();

        String cate = "";

        for (Articulo articulo : articulos) {
            if (articulo.getNombreArt().equals(nombre)) {
                cate= articulo.getCategoria();
                break;
            }
        }
        return cate;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cboArticulos;
    private javax.swing.JComboBox cboCat;
    private com.toedter.calendar.JDateChooser dteFin;
    private com.toedter.calendar.JDateChooser dteInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabDetalle;
    // End of variables declaration//GEN-END:variables
}
