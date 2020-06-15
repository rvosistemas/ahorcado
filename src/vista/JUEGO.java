/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import miscelania.fondo2;
import tipografias.Fuentes;
import Clases.Clase;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author dark_
 */
public class JUEGO extends javax.swing.JInternalFrame {

    // VARIABLES //
    private final Fuentes tipoFuente; // para llamar el metodo de tipografias personalizadas
    ArrayList<String> vulgares      = new ArrayList();
    ArrayList<String> cientificos   = new ArrayList();
    ArrayList<String> familias      = new ArrayList();
    ArrayList<String> fotos         = new ArrayList();
    ArrayList<String> fotos2        = new ArrayList();
    ArrayList<String> fotos3        = new ArrayList();
    ArrayList<String> ganar         = new ArrayList();
    ArrayList<String> perder        = new ArrayList();
    ArrayList<String> avisos        = new ArrayList();
    
    UIManager UI;
    
    Frame fr = JOptionPane.getFrameForComponent(this);
    CARGA gifCarga = new CARGA(fr,true); 
    Clase c; 
    int nivel;
    int ganados;
    int errores;
    int aveAleatoria;
    int[] aves;
    boolean nuevoJuego;
    
    // ------- //
    
    public JUEGO() {
        
        initComponents();
        
        UI = new UIManager();
       
        gifCarga.setSize(200,200);
        gifCarga.setLocationRelativeTo(null);
        gifCarga.setVisible(true);
        
        // SE PERSONALIZA TODO EL TEXTO CON FUENTES DEL PAQUETE TIPOGRAFIA
        tipoFuente = new Fuentes(); // crea tipo de fuente para usar atributos y procedimientos
        ///----------------///----- ETIQUETAS -----///---------------///
        etiq_titulo_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,24));
        etiq_enunciado_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,14));
        etiq_letra_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,14));
        etiq_vidas_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,24));
        etiq_nivel_.setFont(tipoFuente.fuente(tipoFuente.GOD,0,24));
        ///----------------///----- AREA DE TEXTO -----///---------------///
        areaTexto_aviso_.setFont(tipoFuente.fuente(tipoFuente.CAFE,0,16));
        areaTexto_aviso_.setLineWrap(true);// para ajustar texto
        ///----------------///----- VARIABLE -----///---------------///
        c = new Clase();
        ganados = 0;
        nuevoJuego = true;
        String respuesta;
        respuesta = c.importar();
        System.out.println( "Respuesta importacion: "+respuesta );
         ///----------------///----- ARRAYLIST -----///---------------///
        aves        = c.getAves();
        vulgares    = c.getVulgares();
        cientificos = c.getCientificos();
        familias    = c.getFamilias();
        fotos       = c.getFotos();
        fotos2      = c.getFotos2();
        fotos3      = c.getFotos3();   
        ganar       = c.getGanar();   
        perder      = c.getPerder();   
        avisos      = c.getAvisos();   
        ///----------------///----- FUNCIONES -----///---------------///
        iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_letra_ = new javax.swing.JTextField();
        btn_enter_ = new javax.swing.JToggleButton();
        etiq_error1_ = new javax.swing.JLabel();
        etiq_error2_ = new javax.swing.JLabel();
        etiq_error3_ = new javax.swing.JLabel();
        etiq_error4_ = new javax.swing.JLabel();
        etiq_error5_ = new javax.swing.JLabel();
        etiq_imagenAve_ = new javax.swing.JLabel();
        etiq_imagenPerder_ = new javax.swing.JLabel();
        etiq_imagenGanar_ = new javax.swing.JLabel();
        etiq_titulo_ = new javax.swing.JLabel();
        etiq_palabra_ = new javax.swing.JLabel();
        etiq_enunciado_ = new javax.swing.JLabel();
        scroll_avisos_ = new javax.swing.JScrollPane();
        areaTexto_aviso_ = new javax.swing.JTextArea();
        etiq_vidas_ = new javax.swing.JLabel();
        etiq_imagenVIda1_ = new javax.swing.JLabel();
        etiq_imagenVIda2_ = new javax.swing.JLabel();
        etiq_imagenVIda3_ = new javax.swing.JLabel();
        etiq_imagenVIda4_ = new javax.swing.JLabel();
        etiq_imagenVIda5_ = new javax.swing.JLabel();
        etiq_nivel_ = new javax.swing.JLabel();
        etiq_numNivel_ = new javax.swing.JLabel();
        btn_opcion_ = new javax.swing.JButton();
        etiq_letra_ = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(550, 520));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txt_letra_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_letra_KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_letra_KeyTyped(evt);
            }
        });
        getContentPane().add(txt_letra_);
        txt_letra_.setBounds(180, 410, 70, 30);

        btn_enter_.setBackground(new java.awt.Color(51, 51, 255));
        btn_enter_.setForeground(new java.awt.Color(255, 255, 255));
        btn_enter_.setText("Enter");
        btn_enter_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enter_ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enter_);
        btn_enter_.setBounds(280, 410, 70, 30);

        etiq_error1_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.jpg"))); // NOI18N
        getContentPane().add(etiq_error1_);
        etiq_error1_.setBounds(10, 260, 360, 58);

        etiq_error2_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.jpg"))); // NOI18N
        getContentPane().add(etiq_error2_);
        etiq_error2_.setBounds(10, 200, 360, 58);

        etiq_error3_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.jpg"))); // NOI18N
        getContentPane().add(etiq_error3_);
        etiq_error3_.setBounds(10, 150, 360, 58);

        etiq_error4_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.jpg"))); // NOI18N
        getContentPane().add(etiq_error4_);
        etiq_error4_.setBounds(10, 90, 360, 58);

        etiq_error5_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.jpg"))); // NOI18N
        getContentPane().add(etiq_error5_);
        etiq_error5_.setBounds(10, 30, 360, 58);

        etiq_imagenAve_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(etiq_imagenAve_);
        etiq_imagenAve_.setBounds(10, 31, 360, 290);

        etiq_imagenPerder_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(etiq_imagenPerder_);
        etiq_imagenPerder_.setBounds(10, 31, 360, 290);

        etiq_imagenGanar_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(etiq_imagenGanar_);
        etiq_imagenGanar_.setBounds(10, 31, 360, 290);

        etiq_titulo_.setText("AHORCADO");
        getContentPane().add(etiq_titulo_);
        etiq_titulo_.setBounds(75, 5, 190, 20);

        etiq_palabra_.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        etiq_palabra_.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 0), new java.awt.Color(255, 153, 51)));
        etiq_palabra_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(etiq_palabra_);
        etiq_palabra_.setBounds(10, 370, 470, 31);

        etiq_enunciado_.setText("ENUNCIADO");
        getContentPane().add(etiq_enunciado_);
        etiq_enunciado_.setBounds(10, 330, 460, 30);

        areaTexto_aviso_.setEditable(false);
        areaTexto_aviso_.setColumns(20);
        areaTexto_aviso_.setRows(5);
        scroll_avisos_.setViewportView(areaTexto_aviso_);

        getContentPane().add(scroll_avisos_);
        scroll_avisos_.setBounds(380, 20, 130, 200);

        etiq_vidas_.setText("VIDAS");
        getContentPane().add(etiq_vidas_);
        etiq_vidas_.setBounds(398, 21, 100, 30);

        etiq_imagenVIda1_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vidaSmall.png"))); // NOI18N
        getContentPane().add(etiq_imagenVIda1_);
        etiq_imagenVIda1_.setBounds(390, 60, 40, 40);

        etiq_imagenVIda2_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vidaSmall.png"))); // NOI18N
        getContentPane().add(etiq_imagenVIda2_);
        etiq_imagenVIda2_.setBounds(440, 60, 40, 40);

        etiq_imagenVIda3_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vidaSmall.png"))); // NOI18N
        getContentPane().add(etiq_imagenVIda3_);
        etiq_imagenVIda3_.setBounds(390, 110, 40, 40);

        etiq_imagenVIda4_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vidaSmall.png"))); // NOI18N
        getContentPane().add(etiq_imagenVIda4_);
        etiq_imagenVIda4_.setBounds(440, 110, 40, 40);

        etiq_imagenVIda5_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vidaSmall.png"))); // NOI18N
        getContentPane().add(etiq_imagenVIda5_);
        etiq_imagenVIda5_.setBounds(420, 160, 40, 40);

        etiq_nivel_.setText("NIVEL");
        getContentPane().add(etiq_nivel_);
        etiq_nivel_.setBounds(400, 220, 100, 30);

        etiq_numNivel_.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        etiq_numNivel_.setText("1");
        getContentPane().add(etiq_numNivel_);
        etiq_numNivel_.setBounds(430, 260, 31, 60);

        btn_opcion_.setBackground(new java.awt.Color(255, 51, 0));
        btn_opcion_.setForeground(new java.awt.Color(255, 255, 255));
        btn_opcion_.setText("SIGUIENTE");
        btn_opcion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opcion_ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opcion_);
        btn_opcion_.setBounds(390, 410, 90, 30);

        etiq_letra_.setText("LETRA:");
        getContentPane().add(etiq_letra_);
        etiq_letra_.setBounds(10, 410, 150, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        cerrar();
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        fondo2 f = new fondo2("/imagenes/fondo2.jpg"); // crea instancia objeto fondo y envia direccion de la imagen a usar
        this.add(f,BorderLayout.CENTER); // cuando la ventana sea abierta lo pinta con la imagen
        f.repaint(); // ejecuta la accion de colocar fondo al jframe
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_enter_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enter_ActionPerformed
        accion();
    }//GEN-LAST:event_btn_enter_ActionPerformed
  
    private void txt_letra_KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_letra_KeyTyped
        char car = evt.getKeyChar();
        if(Character.isLetter(car)){ // Character.isDigit(car) con este se permite numeros

        }else{
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txt_letra_KeyTyped

    private void txt_letra_KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_letra_KeyPressed
        if( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            //System.out.println("Has pulsado Enter");
            accion();
        }
    }//GEN-LAST:event_txt_letra_KeyPressed

    private void btn_opcion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opcion_ActionPerformed
        
        switch (btn_opcion_.getText()) {
            case "Reiniciar":
                reiniciar();
                break;
            case "Siguiente":
                iniciar();
                break; 
            case "CERRAR":
                this.dispose();// cierra esta ventana
                break;
            default:
                System.out.println("Error el boton opcion");
                break;
        }    
    }//GEN-LAST:event_btn_opcion_ActionPerformed

    /////////// -- FUNCIONES O PROCEDIMIENTOS  -- ///////
    
    private void iniciar(){
        
        etiq_imagenVIda1_.setVisible(true);
        etiq_imagenVIda2_.setVisible(true);
        etiq_imagenVIda3_.setVisible(true);
        etiq_imagenVIda4_.setVisible(true);
        etiq_imagenVIda5_.setVisible(true);
        
        etiq_error1_.setVisible(false);
        etiq_error2_.setVisible(false);
        etiq_error3_.setVisible(false);
        etiq_error4_.setVisible(false);
        etiq_error5_.setVisible(false);
        etiq_imagenPerder_.setVisible(false);
        
        areaTexto_aviso_.setVisible(false);
        scroll_avisos_.setVisible(false);
        
        btn_opcion_.setVisible(false);
        btn_enter_.setEnabled(true);
        
        UI.put("OptionPane.background", new ColorUIResource(255,250,250));
        UI.getLookAndFeelDefaults().put("Panel.background", new ColorUIResource(255,250,250));
        
        errores = 0;
        
        ave_aleatoria();
        
        if( ganados < 4 ){ nivel = 1; etiq_numNivel_.setText("1"); }
        if( ganados >= 4 && ganados<8 ){ nivel = 2; etiq_numNivel_.setText("2"); }
        if( ganados >= 8 ){ nivel = 3; etiq_numNivel_.setText("3"); }
        
        switch(nivel){
            case 1:
                etiq_enunciado_.setText("NOMBRE VULGAR");
                etiq_palabra_.setText( c.guiones( vulgares.get(aveAleatoria) ) );
                etiq_imagenAve_.setIcon( new ImageIcon( fotos.get(aveAleatoria) ) );
                break;
            case 2:
                etiq_enunciado_.setText("NOMBRE CIENTIFICO");
                etiq_palabra_.setText( c.guiones( cientificos.get(aveAleatoria) ) );
                etiq_imagenAve_.setIcon( new ImageIcon( fotos2.get(aveAleatoria) ) );
                break;
            case 3:
                etiq_enunciado_.setText("FAMILIA A LA QUE PERTENECE");
                etiq_palabra_.setText( c.guiones( familias.get(aveAleatoria) ) );
                etiq_imagenAve_.setIcon( new ImageIcon( fotos3.get(aveAleatoria) ) );
                break;
            default:
                System.out.println("No se encontro el nivel "+nivel+" para agregar palabra a etiqueta");
                break;    
        }     
    }
    
    private void accion(){
        
        if( "".equals(txt_letra_.getText()) ){ // revisa que no este vacio
            
            JOptionPane.showMessageDialog(null, "No ha digitado la letra","ERROR",JOptionPane.INFORMATION_MESSAGE );     
        }else{
             
            String aux = txt_letra_.getText();

            if( aux.length() > 1 ){ // revisa que solo tenga una letra

                JOptionPane.showMessageDialog(null, "Solo Digitar una letra","ERROR",JOptionPane.INFORMATION_MESSAGE );
            }else{
                    
                char letra = txt_letra_.getText().charAt(0);
                letra = Character.toLowerCase(letra); // para que sea minuscula

                if( c.revisarLetra(letra,nivel,aveAleatoria) ){ // true si encuentra la letra en la palabra

                    String pal = c.letraXGuion(letra,nivel,aveAleatoria,etiq_palabra_.getText() );  //pal = palabra   
                    etiq_palabra_.setText(pal);

                    if( c.palabraCompleta( etiq_palabra_.getText() ) ){ // verifica si ya descubrio la palabra
                        ganar();
                    }                      
                }else{

                    errores++;
                    switch(errores){
                        case 1:
                            etiq_error1_.setVisible(true);
                            etiq_imagenVIda5_.setVisible(false);
                            break;
                        case 2:
                            etiq_error2_.setVisible(true);
                            etiq_imagenVIda4_.setVisible(false);
                            break; 
                        case 3:
                            etiq_error3_.setVisible(true);
                            etiq_imagenVIda3_.setVisible(false);
                            break;
                        case 4:
                            etiq_error4_.setVisible(true);
                            etiq_imagenVIda2_.setVisible(false);
                            break;
                        case 5:
                            etiq_error5_.setVisible(true);
                            etiq_imagenVIda1_.setVisible(false);
                            perder();
                            break;
                        default:
                            System.out.println("error al contar errores");
                            break;    
                    }
                }
            }                
        }
    }
     
    private int ave_aleatoria(){
        
        Random numAleatorio = new Random();
        /* Numero entero entre 25 y 75
        int n = numAleatorio.nextInt(75-25+1) + 25;*/
        //Numero entero entre 0 y 11
        if( nuevoJuego ){
            aveAleatoria = numAleatorio.nextInt(11+1);
            System.out.println( "aleatorio nuevo juego: "+aveAleatoria );
            for(int i=0; i<aves.length;i++){
                if( aves[i]==aveAleatoria ){
                    aves[i] = -1;
                }
            } 
            nuevoJuego = false;
        }else{
            
            boolean repetir = true;
            aveAleatoria = numAleatorio.nextInt(11+1);
            
            for(int i=0; i<aves.length;i++){
                if( aves[i] == aveAleatoria ){
                    System.out.println( "# ave aleatoria: "+aveAleatoria );
                    aves[i] = -1;
                    repetir = false;
                    break;
                }
            } 
            
            if (repetir) {
                ave_aleatoria();
            }
            
        }
        
        return aveAleatoria;
    }
    
    private void ganar(){
        
        btn_enter_.setEnabled(false);
        
        etiq_error1_.setVisible(false);
        etiq_error2_.setVisible(false);
        etiq_error3_.setVisible(false);
        etiq_error4_.setVisible(false);
        etiq_error5_.setVisible(false);
        
        ganados++;
        
        if( ganados == 11 ){
            JOptionPane.showMessageDialog(null, "HAS LIBERADO AL AVE FELICIDADES!\n DATOS DEL AVE \n Vulgar: "+vulgares.get(aveAleatoria)+",\n Cientifico: "+cientificos.get(aveAleatoria)+",\n Familia: "+familias.get(aveAleatoria));
            ganarJuego();
        }else{
            etiq_imagenAve_.setIcon( new ImageIcon( ganar.get( 0 ) ) );
            JOptionPane.showMessageDialog(null, "HAS LIBERADO AL AVE FELICIDADES!\n DATOS DEL AVE \n Vulgar: "+vulgares.get(aveAleatoria)+",\n Cientifico: "+cientificos.get(aveAleatoria)+",\n Familia: "+familias.get(aveAleatoria));
            btn_opcion_.setText("Siguiente");
            btn_opcion_.setVisible(true);
        }
    }
    
    private void perder(){
        
        Random numAleatorio = new Random();
        /* Numero entero entre 25 y 75
        int n = numAleatorio.nextInt(75-25+1) + 25;*/
        JOptionPane.showMessageDialog(null, "Has perdido debes reiniciar, ya que debes salvar a todas las aves");
        etiq_error1_.setVisible(false);
        etiq_error2_.setVisible(false);
        etiq_error3_.setVisible(false);
        etiq_error4_.setVisible(false);
        etiq_error5_.setVisible(false);
        //Numero entero entre 0 y 6
        int rand = numAleatorio.nextInt(6+1);
        etiq_imagenAve_.setIcon( new ImageIcon( perder.get( rand )  ) );
        areaTexto_aviso_.setText( avisos.get( rand ));
        areaTexto_aviso_.setVisible(true);
        scroll_avisos_.setVisible(true);
        btn_enter_.setEnabled(false);
        btn_opcion_.setText("Reiniciar");
        btn_opcion_.setVisible(true);
        
    }
    
    private void reiniciar(){
        
        errores = 0;
        
        etiq_palabra_.setText( c.guiones( vulgares.get(aveAleatoria) ) );
        etiq_imagenAve_.setIcon( new ImageIcon( fotos.get(aveAleatoria) ) );
        
        etiq_imagenVIda1_.setVisible(true);
        etiq_imagenVIda2_.setVisible(true);
        etiq_imagenVIda3_.setVisible(true);
        etiq_imagenVIda4_.setVisible(true);
        etiq_imagenVIda5_.setVisible(true);
        
        areaTexto_aviso_.setVisible(false);
        scroll_avisos_.setVisible(false);
        btn_opcion_.setVisible(false);
        
        btn_enter_.setEnabled(true);
        
    }
    
    private void ganarJuego(){
        
        btn_enter_.setEnabled(false);
        
        etiq_error1_.setVisible(false);
        etiq_error2_.setVisible(false);
        etiq_error3_.setVisible(false);
        etiq_error4_.setVisible(false);
        etiq_error5_.setVisible(false);
        
        etiq_imagenAve_.setIcon( new ImageIcon( ganar.get( 1 ) ) );
        areaTexto_aviso_.setText( "FELICITACIONES HAS LIBERADO A LAS AVES HAS GANADO EL JUEGO" );
        areaTexto_aviso_.setVisible(true);
        scroll_avisos_.setVisible(true);
        btn_opcion_.setText("CERRAR");
        btn_opcion_.setVisible(true);
    }
    
    private void cerrar(){ // para pedir confirmacion al cerrar una ventana
        
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"Se reiniciaran los niveles","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            this.dispose();// cierra esta ventana
        }else{
        }
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto_aviso_;
    private javax.swing.JToggleButton btn_enter_;
    private javax.swing.JButton btn_opcion_;
    private javax.swing.JLabel etiq_enunciado_;
    private javax.swing.JLabel etiq_error1_;
    private javax.swing.JLabel etiq_error2_;
    private javax.swing.JLabel etiq_error3_;
    private javax.swing.JLabel etiq_error4_;
    private javax.swing.JLabel etiq_error5_;
    private javax.swing.JLabel etiq_imagenAve_;
    private javax.swing.JLabel etiq_imagenGanar_;
    private javax.swing.JLabel etiq_imagenPerder_;
    private javax.swing.JLabel etiq_imagenVIda1_;
    private javax.swing.JLabel etiq_imagenVIda2_;
    private javax.swing.JLabel etiq_imagenVIda3_;
    private javax.swing.JLabel etiq_imagenVIda4_;
    private javax.swing.JLabel etiq_imagenVIda5_;
    private javax.swing.JLabel etiq_letra_;
    private javax.swing.JLabel etiq_nivel_;
    private javax.swing.JLabel etiq_numNivel_;
    private javax.swing.JLabel etiq_palabra_;
    private javax.swing.JLabel etiq_titulo_;
    private javax.swing.JLabel etiq_vidas_;
    private javax.swing.JScrollPane scroll_avisos_;
    private javax.swing.JTextField txt_letra_;
    // End of variables declaration//GEN-END:variables
}
