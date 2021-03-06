/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import beans.Articulo;
import beans.Factura;
import beans.Provedor;
import beans.Stock;
import dao.ArticuloDAO;
import dao.FacturaDAO;
import dao.IngresoDAO;
import dao.ProvedorDAO;
import dao.StockDAO;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.util;

/**
 *
 * @author Marcos Pulgar
 */
public class IfrmNuevaFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmNuevaFactura
     */
    
    double bruto ; 
    double neto = 0;
    double iva = 0;
    double total = 0;
    
    public IfrmNuevaFactura() {
        initComponents();
        cboDia();
    }
    
    public void cboDia (){
                
        ProvedorDAO pd = new ProvedorDAO();
        ArrayList <Provedor> provedores = pd.getProvedores();
        
        for (Provedor provedor : provedores) {
            cboProveedor.addItem(provedor.getNombreProv());
        }
        
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList <Articulo> articulos = ad.getArticulos();
        
        
        

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
        jLabel3 = new javax.swing.JLabel();
        txtNroFactura = new javax.swing.JTextField();
        cboProveedor = new javax.swing.JComboBox();
        dteFechaI = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboArticulo = new javax.swing.JComboBox();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarArt = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        chkIva = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cboCat = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabArticulos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNeto = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingresar Factura");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Factura"));

        jLabel1.setText("Nro Factura: ");

        jLabel3.setText("Nombre Proveedor:");

        dteFechaI.setDateFormatString("yyyy-MMM-dd");

        jLabel10.setText("Fecha: ");

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtNroFactura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cboProveedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dteFechaI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dteFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dteFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Articulos"));

        jLabel6.setText("Articulo: ");

        jLabel7.setText("Cantidad");

        btnAgregarArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/agregar-nuevo-documento-de-archivo-mas-icono-6249-48.png"))); // NOI18N
        btnAgregarArt.setText("Agregar");
        btnAgregarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArtActionPerformed(evt);
            }
        });

        jLabel9.setText("Precio:");

        chkIva.setText("incluir iva.");

        jLabel2.setText("Categoria:");

        cboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "2204001", "2204007", "2204009" }));
        cboCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCatActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cboArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnAgregarArt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(chkIva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cboCat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkIva)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarArt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cboArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnAgregarArt)
                .addContainerGap())
        );

        tabArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Factura", "Cod Articulo", "Articulo", "Categoria", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabArticulos);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar Seleccion");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/agregar-nuevo-documento-de-archivo-mas-icono-6249-48.png"))); // NOI18N
        btnAgregar.setText("Agregar Factura");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel4.setText("Neto:");

        jLabel5.setText("I.V.A.:");

        jLabel8.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregar)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(lblNeto)
                    .addComponent(lblIVA)
                    .addComponent(lblTotal))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArtActionPerformed
       
        ArticuloDAO ad = new ArticuloDAO(); //traer articulos recorrerlos e igualarlo con el codigo 
            ArrayList <Articulo> articulos = ad.getArticulos();
            
            DefaultTableModel model = (DefaultTableModel) tabArticulos.getModel();                                    
            Object filas [] = new Object [6];
            double precio = Double.parseDouble(txtPrecio.getText());
            
            double auxiva; 
            double auxNeto;
            
            if(chkIva.isSelected()){
                neto += precio;
                auxNeto = precio;
                
                precio = precio + ((precio *19)/100);
                
                auxiva = (auxNeto * 19)/100;
                
                iva += auxiva;
                total += auxiva + auxNeto;
        
            }else{
                auxNeto = precio / 1.19;
                auxiva = (auxNeto * 19) / 100;
                
                neto += auxNeto;
                iva += auxiva;
                total += auxNeto + auxiva;
            }
            
            
            
                filas[0] = txtNroFactura.getText();
            filas[1] = buscaCodigo(cboArticulo.getSelectedItem().toString());
            filas[2] = cboArticulo.getSelectedItem().toString();
            filas[3] = cboCat.getSelectedItem();
            filas[4] = txtCantidad.getText();
            filas[5] = Math.round(precio);
            
            model.addRow(filas);
                    tabArticulos.setModel(model);
            
                                 
                    
             
        
        util u = new util();
        
        lblNeto.setText("$ " + u.formatearNumero(String.valueOf(Math.round(neto))));
        lblIVA.setText("$ " + u.formatearNumero(String.valueOf(Math.round(iva))));
        lblTotal.setText("$ " + u.formatearNumero(String.valueOf(Math.round(total))));
        
        txtCantidad.setText("");
        txtPrecio.setText("");
        
    }//GEN-LAST:event_btnAgregarArtActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabArticulos.getModel();
        int a = tabArticulos.getSelectedRow();
        
        
        double auxIva;
        double auxNeto;
        double auxPrecio;
        double precio;
        
        precio = Double.parseDouble(tabArticulos.getValueAt(a, 5).toString());
        
        auxNeto = precio/1.19;
        auxIva = (auxNeto * 19) / 100;
        
        iva -= auxIva;
        neto -= auxNeto;
        total -= precio;
        
        model.removeRow(a);
       
        util u = new util();
        
        lblNeto.setText("$ " + u.formatearNumero(String.valueOf(Math.round(neto))));
        lblIVA.setText("$ " + u.formatearNumero(String.valueOf(Math.round(iva))));
        lblTotal.setText("$ " + u.formatearNumero(String.valueOf(Math.round(total))));
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       //Agrega Factura
        boolean factura = agregaFactura();
//        JOptionPane.showMessageDialog(null, fd.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
        //Fin
        
        //Agregar articulos
        boolean articulos = false;
        if(factura == true){
            articulos = agregaArticulos();
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error", JOptionPane.ERROR_MESSAGE);
            
        }
        //fin
        
        DefaultTableModel model = (DefaultTableModel) tabArticulos.getModel();
        
        int rows = model.getRowCount();//numero total de filas de la tabla
        
        
             
        if(articulos == true){
        
        StockDAO sd = new StockDAO(); 
        
                
        for (int i = 0; i < rows; i++) {
            ArrayList <Stock> stocks = sd.getStock2(model.getValueAt(i, 3).toString());
            int cantidad = Integer.parseInt(model.getValueAt(i, 4).toString());
            int codigoArt = Integer.parseInt(model.getValueAt(i, 1).toString());
            int newCantidad = 0;
            String cat = model.getValueAt(i, 3).toString();
            for (Stock stock : stocks) {
                int b = stock.getCodigoArt();
                if (b == codigoArt && stock.getCategoria().equals(cat)) {
                    int a = stock.getStock();
                    newCantidad = a + cantidad;
                }
            }

            sd.actualizar(newCantidad, codigoArt, cat);
        }
        }
        
        JOptionPane.showMessageDialog(null, "Tarea Realizada" , "Informacion", JOptionPane.INFORMATION_MESSAGE);
        
        cboProveedor.setSelectedIndex(0);
        
        txtCantidad.setText("");
        txtNroFactura.setText("");
        txtPrecio.setText("");
        
        neto = 0;
         iva = 0;
         total = 0;
         
        lblIVA.setText("0");
        lblNeto.setText("0");
        lblTotal.setText("0");
        
        int rowsTotal = tabArticulos.getRowCount();
        
            for (int i = 0; i < rowsTotal; i++) {
            model.removeRow(0);
        }
            
         
         
         
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCatActionPerformed
        cboArticulo.removeAllItems();
        
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList <Articulo> articulos = ad.getAparaCombo(cboCat.getSelectedItem().toString());
        
        for (Articulo articulo : articulos) {
            cboArticulo.addItem(articulo.getNombreArt());
        }
    }//GEN-LAST:event_cboCatActionPerformed
    
     public boolean agregaFactura (){
        FacturaDAO fd = new FacturaDAO ();
        int nroFactura = Integer.parseInt(txtNroFactura.getText());
        String dia = String.valueOf(dteFechaI.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(dteFechaI.getCalendar().get(Calendar.MONTH)+1);
        String anio = String.valueOf(dteFechaI.getCalendar().get(Calendar.YEAR));
        String fecha = anio + "-" + mes + "-" + dia;
        int idProv = buscaProv(cboProveedor.getSelectedItem().toString());        
        return fd.agregar(nroFactura, fecha, idProv);
        
    }
     
     public boolean agregaArticulos (){
         int nroFactura = Integer.parseInt(txtNroFactura.getText());
        IngresoDAO id = new IngresoDAO();
        
        DefaultTableModel model = (DefaultTableModel) tabArticulos.getModel();
        
        int rows = model.getRowCount();//numero total de filas de la tabla
        int idFactura = buscaFactura(nroFactura);
        
                
        for (int i = 0; i < rows; i++) { //recorre la fila hasta que i sea igual a rows
            int codigoArt = Integer.parseInt(String.valueOf(tabArticulos.getValueAt(i , 1)));
            int cantidad = Integer.parseInt(tabArticulos.getValueAt(i, 4).toString());
            int precio = Integer.parseInt(tabArticulos.getValueAt(i, 5).toString());
            String cat = tabArticulos.getValueAt(i, 3).toString();
            
            try {
                id.agregar(idFactura, codigoArt, cantidad, precio, cat); 
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
                       
        }
        return true;
     }
    
    public int buscaFactura (int nroFactura){
        FacturaDAO fd = new FacturaDAO();
        ArrayList <Factura> facturas = fd.getFacturas();
        int id = 0;
        
        for (Factura factura : facturas) {
            if(factura.getNumeroFactura() == nroFactura){
                id = factura.getIdFactura();
            }
        }
        return id;
    }
    
    public int buscaProv (String nombre){
        ProvedorDAO pd = new ProvedorDAO();
        ArrayList <Provedor> provedores = pd.getProvedores();
        int idProv = 0;
        for (Provedor provedor : provedores) {
            if(provedor.getNombreProv().equals(nombre)){
                idProv = provedor.getIdProv();
            }
        }
        return idProv;
    }
    
     public int buscaCodigo (String nombre){
        
        ArticuloDAO ad = new ArticuloDAO();
        ArrayList <Articulo> articulos = ad.getAxC(cboCat.getSelectedItem().toString());
        int codigo = 0;
        for (Articulo articulo : articulos) {
            if(nombre.equals(articulo.getNombreArt())){
                codigo = articulo.getCodigoArt();
            }
        }
        return codigo;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarArt;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboArticulo;
    private javax.swing.JComboBox cboCat;
    private javax.swing.JComboBox cboProveedor;
    private javax.swing.JCheckBox chkIva;
    private com.toedter.calendar.JDateChooser dteFechaI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblNeto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabArticulos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNroFactura;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
