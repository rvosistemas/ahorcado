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
    
    ArrayList<String> vulgares      = new ArrayList();
    ArrayList<String> cientificos   = new ArrayList();
    ArrayList<String> fotos         = new ArrayList();
    
    public void getRuta(){
        
        directorioActual = System.getProperty("user.dir");
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
                            rutaFotos = directorioActual+"\\src\\imagenes\\aves_mocoa\\";
                            aux = String.valueOf( modeloT.getValueAt(j, i));
                            fotos.add( rutaFotos+aux );
                            break;
                        default:
                            break;    
                    }
                }
            }
            
            for (int i = 0; i < vulgares.size(); i++) {
                System.out.println("vulgar: "+vulgares.get(i) );
            }
            for (int i = 0; i < cientificos.size(); i++) {
                System.out.println("cientifico: "+cientificos.get(i) );
            }
            for (int i = 0; i < fotos.size(); i++) {
                System.out.println("fotos: "+fotos.get(i) );
            }
    }
    
    public String importar(){
        
        getRuta();
        tablaD = new JTable();
        
        vulgares = new ArrayList();
        cientificos = new ArrayList();
        fotos = new ArrayList();
        
        String respuesta = "No se realizo con exito la importacion";
        modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        try{  
            
            wb = WorkbookFactory.create( new FileInputStream(archivo),"1234" );
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila=-1;
            
            while( filaIterator.hasNext() ){
                       
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[5];
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
            
            System.out.println("Error: "+e);
            JOptionPane.showMessageDialog(null, "Error al importar datos desde archivo excel: -> "+e);
            
        }
        
        return respuesta;  
    }
    
    public ArrayList getVulgares(){
        return vulgares;
    }
    
    public ArrayList getCientificos(){
        return cientificos;
    }
    
    public ArrayList getFotos(){
        return fotos;
    }
  
}
