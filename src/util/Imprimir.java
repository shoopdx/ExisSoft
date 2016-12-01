/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gui.IfrmProductos;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.design.JRJavacCompiler;


/**
 *
 * @author shoop
 */
public class Imprimir {

    public void Impresion(String ruta, Map parametro, List list) {

        if (list != null) {
            JasperReport reporte = null;
            try {

                reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);

                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(list));

                JasperViewer.viewReport(jprint, false);

            } catch (JRException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Documento vacio");
        }

    }

}
