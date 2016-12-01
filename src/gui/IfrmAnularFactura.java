/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import beans.Articulo;
import beans.Factura;
import beans.Ingreso;
import beans.Stock;
import beans.User;
import dao.ArticuloDAO;
import dao.FacturaDAO;
import dao.IngresoDAO;
import dao.StockDAO;
import dao.UserDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Pulgar
 */
public class IfrmAnularFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmAnularFactura
     */
    public IfrmAnularFactura() {
        initComponents();
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
        txtNroFactura = new javax.swing.JTextField();
        btnAnular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pswContraseña = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Anular Factura");

        jLabel1.setText("Nro Factura:");

        txtNroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroFacturaActionPerformed(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/document-delete-31021.png"))); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        jLabel2.setText("contraseña:");

        pswContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswContraseñaActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(pswContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnular)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pswContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAnular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroFacturaActionPerformed
        btnAnular.doClick();
    }//GEN-LAST:event_txtNroFacturaActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        int nroFactura = Integer.parseInt(txtNroFactura.getText().toString());
        
        FacturaDAO fd = new FacturaDAO ();
        ArrayList <Factura> facturas = fd.getFacturasPorNumero();
        
        UserDAO ud = new UserDAO();
        ArrayList <User> users = ud.getUsuarios();
        int a = 1;
        String contraseña = pswContraseña.getText();
        
        for (User user : users) {
            if(contraseña.equals(user.getContrasenia())){
                for (Factura factura : facturas) {
                     a++;
                    if(factura.getNumeroFactura() == nroFactura){                      
                        
                        ArticuloDAO ad = new ArticuloDAO();
                        StockDAO sd = new StockDAO();
                        ArrayList <Stock> stocks  = sd.getStock();
                        
                        ArrayList <Articulo> articulos = ad.getArticulos();
                        IngresoDAO id = new IngresoDAO();
                        ArrayList <Ingreso> ingresos = id.getIngreso();
                        
                        for (Ingreso ingreso : ingresos) {
                            
                            int idFacturaIn = ingreso.getIdFactura();
                            int idFacturaFa = factura.getIdFactura();
                            
                            if(idFacturaFa == idFacturaIn){
                                
                                for(Articulo articulo : articulos){
                                    
                                    if(ingreso.getCodigoArt() == articulo.getCodigoArt() && ingreso.getCategoria().equals(articulo.getCategoria()) ){
                                        
                                        for (Stock stock: stocks) {
                                            
                                            if(stock.getCategoria().equals(articulo.getCategoria())){
                                                
                                                int stock1 = Stock(articulo.getCodigoArt(), articulo.getCategoria()) - ingreso.getCantidad();
                                                sd.actualizar(stock1, articulo.getCodigoArt(), articulo.getCategoria());
                                                
                                                fd.anular(nroFactura, factura.getIdFactura());
                                                
                                                break;
                                            }                                            
                                        }                                        
                                    }
                                }
                            }
                            
                        }
                       
                        
                        JOptionPane.showMessageDialog(null, fd.getMessage(),"Informacion", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }else{
                        if(facturas.size() == a){
                            JOptionPane.showMessageDialog(null, "La factura no existe", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta \n no tiene permisos para anular facturas", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        
        
        
        
    }//GEN-LAST:event_btnAnularActionPerformed

    private void pswContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswContraseñaActionPerformed
        btnAnular.doClick();
    }//GEN-LAST:event_pswContraseñaActionPerformed
    
    private int Stock (int cod, String cat){
        StockDAO sd = new StockDAO();
        ArrayList <Stock> stocks = sd.getStock();
        int cantidad = 0;
        
        for (Stock stock : stocks) {
            if(stock.getCodigoArt() == cod && stock.getCategoria().equals(cat)){
                cantidad = stock.getStock();
                break;
            }
        }
       return cantidad;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pswContraseña;
    private javax.swing.JTextField txtNroFactura;
    // End of variables declaration//GEN-END:variables
}
