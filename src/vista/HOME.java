
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tipografias.Fuentes;

/**
 *
 * @author dark_
 */
public class HOME extends javax.swing.JFrame {
    // --- VARIABLES ------------crea variables para el modelo de la tabla y el tipo de fuente del formulario
    private DefaultTableModel modelo; // se crea modelo para tabla
    private final Fuentes tipoFuente; // para llamar el metodo de tipografias personalizadas
    
    public HOME() {//constructor
        initComponents();

        // SE PERSONALIZA TODO EL TEXTO CON FUENTES DEL PAQUETE TIPOGRAFIA
        tipoFuente = new Fuentes(); // crea tipo de fuente para usar atributos y procedimientos
        ///----------------///----- PESTAÑAS MENU -----///---------------///
        menu_archivo_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,16));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        PanelEscritorio_ = new javax.swing.JDesktopPane();
        etiq_fondo_ = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo_ = new javax.swing.JMenu();
        itemMenu_Nuevo_ = new javax.swing.JMenuItem();
        itemMenu_Cerrar_ = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelEscritorio_.setBackground(new java.awt.Color(153, 153, 153));

        etiq_fondo_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.png"))); // NOI18N
        PanelEscritorio_.add(etiq_fondo_);
        etiq_fondo_.setBounds(0, 0, 550, 510);

        getContentPane().add(PanelEscritorio_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 500));

        menu_archivo_.setText("Archivo");

        itemMenu_Nuevo_.setText("Nuevo juego");
        itemMenu_Nuevo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_Nuevo_ActionPerformed(evt);
            }
        });
        menu_archivo_.add(itemMenu_Nuevo_);

        itemMenu_Cerrar_.setText("Cerrar juego");
        itemMenu_Cerrar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_Cerrar_ActionPerformed(evt);
            }
        });
        menu_archivo_.add(itemMenu_Cerrar_);

        jMenuBar1.add(menu_archivo_);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ----------- FUNCIONES Y PROCEDIMIENTOS -------------------------------------------/////////////////////////////////
    private void cerrar(){ // para pedir confirmacion al cerrar la ventana
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        { 
            DESPEDIDA D = new DESPEDIDA(); // crea un objeto para el siguiente formulario
            D.setVisible(true);//hace visible el siguiente formulario 
            this.dispose(); // oculta este formulario
        }else{
        }
    }    
            
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void itemMenu_Nuevo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_Nuevo_ActionPerformed
        JUEGO j = new JUEGO();
        PanelEscritorio_.add(j);
        j.show();
    }//GEN-LAST:event_itemMenu_Nuevo_ActionPerformed

    private void itemMenu_Cerrar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_Cerrar_ActionPerformed
        cerrar();
    }//GEN-LAST:event_itemMenu_Cerrar_ActionPerformed
     
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HOME().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane PanelEscritorio_;
    private javax.swing.JLabel etiq_fondo_;
    private javax.swing.JMenuItem itemMenu_Cerrar_;
    private javax.swing.JMenuItem itemMenu_Nuevo_;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menu_archivo_;
    // End of variables declaration//GEN-END:variables
}
