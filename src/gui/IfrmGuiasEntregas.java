/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Articulo;
import beans.Departamento;
import beans.GuiaEntrega;
import beans.ReporteProductos;
import beans.Stock;
import dao.ArticuloDAO;
import dao.DepartamentoDAO;
import dao.EntregaDAO;
import dao.GuiaEntregaDAO;
import dao.StockDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.Imprimir;

/**
 *
 * @author Marcos Pulgar
 */
public class IfrmGuiasEntregas extends javax.swing.JInternalFrame {

    DefaultTableModel model;

    int cantidadAntigua;

    /**
     * Creates new form IfrmGuiasEntregas
     */
    public IfrmGuiasEntregas() {
        initComponents();
        cargaCbo();
        model = (DefaultTableModel) tabGuias.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        cboDepa = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        dteInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dteFin = new com.toedter.calendar.JDateChooser();
        btnVer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabGuias = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboCat = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Guia de Entrega");

        jLayeredPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Seccion:");

        jLabel2.setText("Entre");

        jLabel3.setText("y");

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        tabGuias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabGuias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabGuiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabGuias);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Categoria:");

        cboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona...", "2204001", "2204007", "2204009" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/gtk-refresh.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboDepa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dteInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(dteFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnVer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cboDepa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(btnVer)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dteInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(dteFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cboDepa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dteInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dteFin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnVer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cboCat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        String diaI = String.valueOf(dteInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mesI = String.valueOf(dteInicio.getCalendar().get(Calendar.MONTH) + 1);
        String anioI = String.valueOf(dteInicio.getCalendar().get(Calendar.YEAR));
        String fechaInicio = anioI + "-" + mesI + "-" + diaI;

        String diaF = String.valueOf(dteFin.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mesF = String.valueOf(dteFin.getCalendar().get(Calendar.MONTH) + 1);
        String anioF = String.valueOf(dteFin.getCalendar().get(Calendar.YEAR));
        String fechaFin = anioF + "-" + mesF + "-" + diaF;

        String depa = cboDepa.getSelectedItem().toString();

        if (cboCat.getSelectedIndex() != 0) {
            GuiaEntregaDAO gd = new GuiaEntregaDAO();
            ArrayList<GuiaEntrega> guias = gd.getGuias(fechaInicio, fechaFin, depa, cboCat.getSelectedItem().toString());

            int fil = tabGuias.getRowCount();
            for (int i = 0; i < fil; i++) {
                model.removeRow(0);
            }

            for (GuiaEntrega guiaEntrega : guias) {
                Object[] filas = new Object[4];

                filas[0] = guiaEntrega.getFecha();
                filas[1] = guiaEntrega.getArtiuclo();
                filas[2] = guiaEntrega.getCantidad();
                filas[3] = guiaEntrega.getNombreDepa();

                model.addRow(filas);
            }

            tabGuias.setModel(model);

            if (guias.size() == 0) {
                JOptionPane.showMessageDialog(null, "No hay guias \n entre estas fechas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado categoria", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnVerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List productos = new ArrayList();
        int totalGuias = tabGuias.getRowCount();

        for (int i = 0; i < totalGuias; i++) {
            GuiaEntrega lista = new GuiaEntrega();
            lista.setFecha(tabGuias.getValueAt(i, 0).toString());
            lista.setArtiuclo(tabGuias.getValueAt(i, 1).toString());
            lista.setCantidad(tabGuias.getValueAt(i, 2).toString());
            lista.setNombreDepa(tabGuias.getValueAt(i, 3).toString());

            productos.add(lista);
        }
        String ruta = System.getProperty("user.dir") + "\\reportes\\ReporteGuias.jasper";

        Map parametro = new HashMap();

        if (cboCat.getSelectedItem().toString().equals("2204001")) {
            parametro.put("titulo", "Materiales de Oficina");
        }
        if (cboCat.getSelectedItem().toString().equals("2204007")) {
            parametro.put("titulo", "Materiales y Utiles de Aseo");
        }
        if (cboCat.getSelectedItem().toString().equals("2204009")) {
            parametro.put("titulo", "Insumos Computacionales");
        }

        Imprimir imp = new Imprimir();
        imp.Impresion(ruta, parametro, productos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabGuias.getModel();

        int rows = tabGuias.getSelectedRow();
        String fecha = model.getValueAt(rows, 0).toString(); //necesito
        int codArt = codigoArt(model.getValueAt(rows, 1).toString()); //necesito
        int cantidad = Integer.parseInt(model.getValueAt(rows, 2).toString());
        String depa = model.getValueAt(rows, 3).toString(); //necesito
        String cat = cboCat.getSelectedItem().toString(); //necesito

        EntregaDAO ed = new EntregaDAO();

        int resp = JOptionPane.showConfirmDialog(null, "Desea cambiar la cantidad " + cantidadAntigua + "(antigua) por " + cantidad+"(nueva)", "Confirmacion", JOptionPane.YES_NO_OPTION);

        if (resp == 0) {
            if (ed.ModificarEntrega(fecha, depa, cat, codArt, cantidad)) {

                StockDAO sd = new StockDAO();
                ArrayList<Stock> stocks = sd.getStock2(cat);
                int newCantidad = 0;

                if (cantidad > cantidadAntigua) {
                    cantidad = cantidad - cantidadAntigua;
                    for (Stock stock : stocks) {
                        int b = stock.getCodigoArt();
                        if (b == codArt) {
                            int a = stock.getStock();
                            newCantidad = a - cantidad;
                        }
                    }

                    sd.actualizar(newCantidad, codArt, cat);

                } else {
                    cantidad = cantidadAntigua - cantidad;
                    for (Stock stock : stocks) {
                        
                        int b = stock.getCodigoArt();
                        if (b == codArt) {
                            int a = stock.getStock();
                            newCantidad = a + cantidad;
                        }
                    }
                    sd.actualizar(newCantidad, codArt, cat);
                }

                JOptionPane.showMessageDialog(null, ed.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar", "Informacion", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabGuiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabGuiasMouseClicked
        int rows = tabGuias.getSelectedRow();
        cantidadAntigua = Integer.parseInt(model.getValueAt(rows, 2).toString());
    }//GEN-LAST:event_tabGuiasMouseClicked

    public void cargaCbo() {
        DepartamentoDAO dd = new DepartamentoDAO();
        ArrayList<Departamento> depas = dd.getDepartamentos();

        for (Departamento departamento : depas) {
            cboDepa.addItem(departamento.getNombreDepa());
        }

    }

    public int codigoArt(String nombre) {
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList<Articulo> articulos = ad.getArticulos();
        int cod = 0;
        for (Articulo articulo : articulos) {
            if (articulo.getNombreArt().equals(nombre)) {
                cod = articulo.getCodigoArt();
            }
        }
        return cod;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox cboCat;
    private javax.swing.JComboBox cboDepa;
    private com.toedter.calendar.JDateChooser dteFin;
    private com.toedter.calendar.JDateChooser dteInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabGuias;
    // End of variables declaration//GEN-END:variables
}
