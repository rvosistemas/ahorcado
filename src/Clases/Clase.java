/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import tipografias.Fuentes;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author dark_
 */
public class Clase {
    
    private String rutaDatos;
    private String rutaArchivo;
    private String rutaFotos;
    private String directorioActual;
    private JTable tablaD;
    private DefaultTableModel modeloT;
    private Workbook wb; // para trabajar importar y/o exportar archivos en xls
    private File archivo;
    private int[ ]   aves = new  int[12];// la cantidad de aves para buscar
    
    ArrayList<String> vulgares      = new ArrayList();
    ArrayList<String> cientificos   = new ArrayList();
    ArrayList<String> familias      = new ArrayList();
    ArrayList<String> fotos         = new ArrayList();
    ArrayList<String> fotos2        = new ArrayList();
    ArrayList<String> fotos3        = new ArrayList();
    ArrayList<String> perder        = new ArrayList();
    ArrayList<String> ganar         = new ArrayList();
    ArrayList<String> avisos        = new ArrayList();
    
    public String guiones( String palabra ){
        System.out.println("palabra: "+palabra);
        String aux = "";
        char arrayPalabra[] = palabra.toCharArray();
        
        for (int i = 0; i < palabra.length(); i++) {
            
            if( arrayPalabra[i] == ' ' ){
                
                aux = aux+"  "; // 2 espacios
                
            }else{
                
                aux = aux+"_";
                
                if(i < palabra.length()-1){
                    
                    aux = aux+" ";
                    
                }
            }
        }
        return aux;
    }
    
    public String letraXGuion( char letra, int nivel, int aveAleatoria, String Guion ){
        System.out.println("letra: "+letra+", nivel: "+nivel+", ave vulgar/cientifico/familia: "+aveAleatoria);
        
        ArrayList<Integer> posLetra = new ArrayList();
       // nivel = nivel -1;
       String palabra = "";
        
        switch(nivel){
            case 1:
                palabra = vulgares.get( aveAleatoria );
                System.out.println("vulgar normal: "+palabra);
                break;
            case 2:
                palabra = cientificos.get( aveAleatoria );
                System.out.println("vulgar normal: "+palabra);
                break;
            case 3:
                palabra = familias.get( aveAleatoria );
                System.out.println("vulgar normal: "+palabra);
                
                break;
            default:
                System.out.println("no existe este nivel "+nivel);
                break;    
        }
        System.out.println("guion: "+Guion);    
        
        //////  ----------- PALABRA -----------  //////
        for (int i = 0; i < palabra.length(); i++) {
            if ( palabra.charAt(i) == letra ) {
                posLetra.add(i);
            }
        }
        
        if( !posLetra.isEmpty() ){
            
            StringBuilder auxPal = new StringBuilder(Guion);
            int posPal = 0;
            int cantPosLetra = posLetra.size();
            
            for (int i = 0; i < cantPosLetra; i++) {
                System.out.println( "pos "+i+" pos letras: "+posLetra.get(i) ); 
            }
            //System.out.println( "cantidad guion: "+Guion.length() );
            for (int i = 0; i < Guion.length(); i++) {
                
                if( Guion.charAt(i) == '_' ){
                    
                    //System.out.println( "iteracion: "+i );
                    if( posLetra.get(posPal) == i/2 ){
                        System.out.println("posPal: "+posPal+" guion cont: "+i/2);
                        System.out.println( "Posiciones letra: "+posLetra.get(posPal) );
                        auxPal.setCharAt(i, letra);
                        System.out.println( "palabra con letra: "+auxPal );
                        posPal++;
                        
                        if(posPal == cantPosLetra){
                            break;
                        }

                    }
                    
                }
            }          
            
            Guion = auxPal.toString();
            
        }else{
            System.out.println("No hay letra: "+letra);
        }
        
        return Guion;
    }
    
    public boolean revisarLetra( char letra, int nivel, int aveAleatoria ){
        
        boolean encontro = false;
        String palabra = "";
        
        switch(nivel){
            case 1:
                palabra = vulgares.get( aveAleatoria );
                System.out.println("vulgar normal: "+palabra);
                break;
            case 2:
                palabra = cientificos.get( aveAleatoria );
                System.out.println("vulgar normal: "+palabra);
                break;
            case 3:
                palabra = familias.get( aveAleatoria );
                System.out.println("vulgar normal: "+palabra);
                
                break;
            default:
                System.out.println("no existe este nivel "+nivel);
                break;    
        }
        
        for (int i = 0; i < palabra.length(); i++) {
            if( palabra.charAt(i) == letra ){
                encontro = true;
                break;
            }
        } 
        
        return encontro;
    }
    
    public boolean palabraCompleta( String palabra ){
        
        char arrayPalabra[] = palabra.toCharArray();
        
        for(int i = 0; i < palabra.length(); i++){
            if( arrayPalabra[i] == '_' ){
                return false; // encontro un guion y regresa que falta por descubrir
            }
        }
        
        return true; // no encontro guiones, ha ganado
    }
    
    public void getRuta(){
        
        directorioActual = System.getProperty("user.dir"); //ubica dinamicamente donde esta el proyecto
        rutaArchivo = "\\src\\datos\\aves.xlsx";
        rutaDatos = directorioActual+rutaArchivo;
        System.out.println("Direccion actual: "+rutaDatos);
        archivo = new File(rutaDatos);
        
    }
    
    public void llenarListas(){
        
        for( int i = 0; i < modeloT.getColumnCount(); i++ ){
                for( int j = 0; j < modeloT.getRowCount(); j++ ){
                    String aux = "";
                    switch( i ){
                        case 0:
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            vulgares.add( aux );
                            break;
                        case 1:
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            cientificos.add( aux );
                            break;
                        case 2:
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            familias.add( aux );
                            break;
                        case 3:
                            rutaFotos = directorioActual+"\\src\\imagenes\\aves_mocoa\\";
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            fotos.add( rutaFotos+aux );
                            break;
                        case 4:
                            rutaFotos = directorioActual+"\\src\\imagenes\\aves_mocoa\\";
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            fotos2.add( rutaFotos+aux );
                            break;
                        case 5:
                            rutaFotos = directorioActual+"\\src\\imagenes\\aves_mocoa\\";
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            fotos3.add( rutaFotos+aux );
                            break;
                        case 6:
                            rutaFotos = directorioActual+"\\src\\imagenes\\aves_mocoa\\";
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            perder.add( rutaFotos+aux );
                            break;
                        case 7:
                            rutaFotos = directorioActual+"\\src\\imagenes\\aves_mocoa\\";
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            ganar.add( rutaFotos+aux );
                            break;
                        case 8:
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            avisos.add( aux );
                            break;
                        default:
                            System.out.println("error al llenar listar");
                            break;    
                    }
                }
            }
            /*
            System.out.println("--------------------------" );
            for (int i = 0; i < vulgares.size(); i++) {
                System.out.println("vulgar: "+vulgares.get(i) );
            }
            System.out.println("--------------------------" );
            for (int i = 0; i < cientificos.size(); i++) {
                System.out.println("cientifico: "+cientificos.get(i) );
            }
            System.out.println("--------------------------" );
            for (int i = 0; i < familias.size(); i++) {
                System.out.println("familia: "+familias.get(i) );
            }
            System.out.println("--------------------------" );
            for (int i = 0; i < fotos.size(); i++) {
                System.out.println("fotos: "+fotos.get(i) );
            }
            System.out.println("--------------------------" );
            for (int i = 0; i < fotos2.size(); i++) {
                System.out.println("fotos2: "+fotos2.get(i) );
            }
            System.out.println("--------------------------" );
            for (int i = 0; i < fotos3.size(); i++) {
                System.out.println("fotos3: "+fotos3.get(i) );
            }
            System.out.println("--------------------------" );
        for (int i = 0; i < perder.size(); i++) {
                System.out.println("perder: "+perder.get(i) );
            }
            System.out.println("--------------------------" );
        for (int i = 0; i < ganar.size(); i++) {
                System.out.println("ganar: "+ganar.get(i) );
            }
            System.out.println("--------------------------" );
        for (int i = 0; i < avisos.size(); i++) {
                System.out.println("avisos: "+avisos.get(i) );
            }
            System.out.println("--------------------------" );
            */
    }
    
    public String importar(){
        
        getRuta();
        tablaD      = new JTable();
        
        vulgares    = new ArrayList();
        cientificos = new ArrayList();
        fotos       = new ArrayList();
        
        String respuesta = "No se realizo con exito la importacion";
        modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        try{  
            
            wb = WorkbookFactory.create( new FileInputStream(archivo),"1234" );
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            Iterator filaIterator2 = hoja.rowIterator();
            int indiceFila=-1;
            int cantidad = -1;
            
            while( filaIterator.hasNext() ){
                Row fila = (Row) filaIterator.next();
                cantidad++;
            }
            
            System.out.println("cantidad de ave es: "+cantidad);
            
            while( filaIterator2.hasNext() ){
                       
                indiceFila++;
                Row fila = (Row) filaIterator2.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[cantidad]; // cantidad de aves a descubrir
                int indiceColumna=-1;
                
                while( columnaIterator.hasNext() ){
                    
                    indiceColumna++;  
                    Cell celda = (Cell) columnaIterator.next();
                    
                    if (indiceFila==0) {
                        modeloT.addColumn(celda.getStringCellValue());
                        
                    } else {
                        
                        if( celda!=null ){
                            
                            switch( celda.getCellType() ){
                                case NUMERIC:
                                    listaColumna[indiceColumna] = (int) Math.round( celda.getNumericCellValue() );
                                    break;
                                case STRING:
                                    listaColumna[indiceColumna] = celda.getStringCellValue();
                                    break;
                                case BOOLEAN:
                                    listaColumna[indiceColumna] = celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna[indiceColumna] = celda.getDateCellValue();
                                    break;
                            }
                        }
                    }
                }
                if( indiceFila!=0 ){ modeloT.addRow(listaColumna); }
            } 
            
            llenarListas();
            
            respuesta = "Importacion exitosa";
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al importar datos desde archivo excel: -> "+e);
            System.out.println("Error: "+e);
        }
        
        return respuesta;  
    }
    
    public int[] getAves(){
        for(int i=0; i<aves.length;i++){
            aves[i] = i;
        }
        return aves;
    }
    
    public ArrayList getVulgares(){
        return vulgares;
    }
    
    public ArrayList getCientificos(){
        return cientificos;
    }
    
    public ArrayList getFamilias(){
        return familias;
    }
    
    public ArrayList getFotos(){
        return fotos;
    }
    
    public ArrayList getFotos2(){
        return fotos2;
    }
    
    public ArrayList getFotos3(){
        return fotos3;
    }
    
    public ArrayList getPerder() {
        return perder;
    }

    public ArrayList getGanar() {
        return ganar;
    }

    public ArrayList getAvisos() {
        return avisos;
    }
  
    public void setAves(int[] avesJuego){
        aves = avesJuego;
        for(int i=0; i<aves.length;i++){
            System.out.println("aves "+aves[i]+", posicion: "+i);
        }
    }
    
}
