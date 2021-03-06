/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import beans.Factura;
import beans.Provedor;
import dao.FacturaDAO;
import dao.ProvedorDAO;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Pulgar
 */
public class IfrmFacturaXFecha extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmFacturaXFecha
     */
    public IfrmFacturaXFecha() {
        initComponents();
        cargaTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabFacturas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        dteFechaInicio = new com.toedter.calendar.JDateChooser();
        dteFechaFin = new com.toedter.calendar.JDateChooser();
        btnVerDetalle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturas");

        tabFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Factura", "Nro Factura", "Proveedor", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabFacturas);

        jLabel1.setText("Ver entre:");

        jLabel4.setText("Y");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVerDetalle.setText("Ver Factura");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        jLabel2.setText("o");

        jLabel3.setText("Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61)
                        .addComponent(dteFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(dteFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVerDetalle)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(btnBuscar)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dteFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dteFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerDetalle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
                
        FacturaDAO fd = new FacturaDAO();
        
        ArrayList <Factura> facturas;
        
        if (txtCodigo.getText().equals(null)) {
            
            String diaI = String.valueOf(dteFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mesI = String.valueOf(dteFechaInicio.getCalendar().get(Calendar.MONTH)+1);
            String anioI = String.valueOf(dteFechaInicio.getCalendar().get(Calendar.YEAR));
            String fechaInicio = anioI + "-" + mesI + "-" + diaI;
        
            String diaF = String.valueOf(dteFechaFin.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mesF = String.valueOf(dteFechaFin.getCalendar().get(Calendar.MONTH)+1);
            String anioF = String.valueOf(dteFechaFin.getCalendar().get(Calendar.YEAR));
            String fechaFin = anioF + "-" + mesF + "-" + diaF;
            
            facturas = fd.buscaPorFecha(fechaInicio, fechaFin);
        }else{
            facturas = fd.facturaPorCodigo(txtCodigo.getText());
        }
        
        
        DefaultTableModel model = (DefaultTableModel) tabFacturas.getModel();
        
        int totalFilas = model.getRowCount();
        
        for (int i = 0; i < totalFilas; i++) {
            model.removeRow(0);
        }
        
        Object filas [] = new Object [5];
        
        for (Factura factura : facturas) {
            
            filas [0] = factura.getIdFactura();
            filas [1] = factura.getNumeroFactura();
            filas [2] = proveedor(factura.getIdProv());
            filas [3] = factura.getFechaIngreso();
            filas [4] = factura.getEstado();
            model.addRow(filas);
            
        }
        tabFacturas.setModel(model);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        
        int idFactura = idFactura();
        int nroFactura = Integer.parseInt(String.valueOf(NroFactura()));
        String fecha = String.valueOf(fecha());
        
        
        FrmFactura ff = new FrmFactura();
        ff.cargaTabla(idFactura, nroFactura, fecha);
        ff.setVisible(true);
        ff.pack();
        
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void tabFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFacturasMouseClicked
        btnVerDetalle.doClick();
    }//GEN-LAST:event_tabFacturasMouseClicked
    
    public String proveedor (int id){
        ProvedorDAO pd = new ProvedorDAO();
        ArrayList <Provedor> provedores = pd.getProvedores();
        String nombre="";
        for (Provedor provedor : provedores) {
            if(provedor.getIdProv() == id){
                nombre = provedor.getNombreProv();
            }
        }
        return nombre;
    }
    
    public void cargaTabla (){
        FacturaDAO fd = new FacturaDAO ();
        ArrayList <Factura> facturas = fd.getFacturas();
        
        DefaultTableModel model = (DefaultTableModel) tabFacturas.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(0);            
        }
        
        Object filas [] = new Object [5];
        
        for (Factura factura : facturas) {
            
            filas [0] = factura.getIdFactura();
            filas [1] = factura.getNumeroFactura();
            filas [2] = proveedor(factura.getIdProv());
            filas [3] = factura.getFechaIngreso();
            filas [4] = factura.getEstado();
            model.addRow(filas);
            
        }
        tabFacturas.setModel(model);
    }
    
    public int idFactura (){
        int row = tabFacturas.getSelectedRow();
        int id = Integer.parseInt(tabFacturas.getValueAt(row, 0).toString());
        return id;
    }
    
    public int NroFactura (){
        int row = tabFacturas.getSelectedRow();
        int id = Integer.parseInt(tabFacturas.getValueAt(row, 1).toString());
        return id;
    }
    
    public String fecha(){
        int row = tabFacturas.getSelectedRow();
        String fecha = tabFacturas.getValueAt(row, 3).toString();
        return fecha;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVerDetalle;
    private com.toedter.calendar.JDateChooser dteFechaFin;
    private com.toedter.calendar.JDateChooser dteFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabFacturas;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
