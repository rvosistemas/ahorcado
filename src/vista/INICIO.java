/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import java.awt.BorderLayout; 
import miscelania.fondo;
import tipografias.Fuentes;

/**
 *
 * @author dark_
 */
public class INICIO extends javax.swing.JFrame {

    private final Fuentes tipoFuente;
    
    public INICIO() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        //-- inicializa las fuentes con el tipo de letra personalizado llama el metodo desde paquete tipografias clase fuentes
        tipoFuente = new Fuentes();
        etiq_titulo_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,24));
        etiq_colegio_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,24));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiq_titulo_ = new javax.swing.JLabel();
        etiq_colegio_ = new javax.swing.JLabel();
        btn_iniciar_ = new javax.swing.JButton();
        etiq_tema_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        etiq_titulo_.setFont(new java.awt.Font("GodOfWar", 1, 18)); // NOI18N
        etiq_titulo_.setForeground(new java.awt.Color(255, 255, 255));
        etiq_titulo_.setText("juego del ahorcado");

        etiq_colegio_.setFont(new java.awt.Font("GodOfWar", 1, 18)); // NOI18N
        etiq_colegio_.setForeground(new java.awt.Color(255, 255, 255));
        etiq_colegio_.setText("nombre colegio");

        btn_iniciar_.setBackground(new java.awt.Color(0, 102, 204));
        btn_iniciar_.setFont(new java.awt.Font("GodOfWar", 0, 14)); // NOI18N
        btn_iniciar_.setForeground(new java.awt.Color(255, 255, 255));
        btn_iniciar_.setText("INICIAR");
        btn_iniciar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_ActionPerformed(evt);
            }
        });

        etiq_tema_.setFont(new java.awt.Font("GodOfWar", 1, 14)); // NOI18N
        etiq_tema_.setForeground(new java.awt.Color(255, 255, 255));
        etiq_tema_.setText("aves de putumayo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiq_titulo_)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiq_tema_)
                                    .addComponent(etiq_colegio_))))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_iniciar_)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(etiq_titulo_)
                .addGap(43, 43, 43)
                .addComponent(etiq_tema_)
                .addGap(34, 34, 34)
                .addComponent(etiq_colegio_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(btn_iniciar_)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrar(){ // para pedir confirmacion al cerrar una ventana
        
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            System.exit(0);// cierra totalmente la aplicacion
        }else{
        }
        
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        cerrar(); // al cerrar la ventana invoca este procedimiento
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        fondo f = new fondo("/imagenes/inicio.jpg"); // crea instancia objeto fondo y envia direccion de la imagen a usar
        this.add(f,BorderLayout.CENTER); // cuando la ventana sea abierta lo pinta con la imagen
        f.repaint(); // ejecuta la accion de colocar fondo al jframe
        
    }//GEN-LAST:event_formWindowOpened

    private void btn_iniciar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_ActionPerformed
        
        HOME h = new HOME(); // crea un objeto para el siguiente formulario
        h.setVisible(true);//hace visible el siguiente formulario
        this.dispose(); // oculta este formulario
        
    }//GEN-LAST:event_btn_iniciar_ActionPerformed

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
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new INICIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar_;
    private javax.swing.JLabel etiq_colegio_;
    private javax.swing.JLabel etiq_tema_;
    private javax.swing.JLabel etiq_titulo_;
    // End of variables declaration//GEN-END:variables
}
