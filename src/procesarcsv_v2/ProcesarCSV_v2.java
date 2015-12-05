/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarcsv_v2;

import bl.FilaCSV;
import bl.Grupo;
import bl.Materia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author esteban
 */
public class ProcesarCSV_v2 {
    
    
    public void procesarlinea(){
        
        String linea;
        FilaCSV primero;
        FilaCSV ultimo;
        Materia materia;
        Grupo grupo;
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();
        
        try {
            //FileReader f = new FileReader("/home/esteban/Descargas/casosCSV.csv");
            FileReader f = new FileReader("/home/esteban/Descargas/PROGRAMACION.csv");
            BufferedReader b = new BufferedReader(f);
            
            b.readLine();
            
            while ((linea = b.readLine()) != null) {
                
                primero = new FilaCSV(linea);
                primero = primero.ajustarCodigoMateria(primero);
                
                if(primero.existeMateria()){
                    materia = new Materia(primero.getFac(), 
                                          primero.getDep(), 
                                          primero.getMat(), 
                                          primero.getNombre());
                    
                    grupo = new Grupo(materia,
                                        primero.getGr(), 
                                        primero.getCupo(), 
                                        primero.getMatri());
                    grupos.add(grupo);
                    materias.add(materia);
                    ultimo=primero;
                } else {
                    
                }
            }
            
            b.close();
            
        } catch (FileNotFoundException e) {
            String mnj = "No se encontró el archivo seleccionado\n"
                    + "Recuerde que el archivo debe ser de extensión xls o xlsx";
            JOptionPane.showMessageDialog(null, mnj+"\n"+e , "Error",
            JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            String mnj = "Error al leer el archivo ";
            JOptionPane.showMessageDialog(null, mnj+"\n"+ex , "Error",
            JOptionPane.WARNING_MESSAGE);
        } 
        
    }
   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
