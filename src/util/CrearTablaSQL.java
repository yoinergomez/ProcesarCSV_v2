/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author esteban
 */
public class CrearTablaSQL {
    
    private StringBuilder sql;
    
    /**
     * Lee un archivo SQL que contiene las sentencias necesarias
     * para la creación de las tablas de la base de datos.
     * 
     * @throws NullPointerException  
     * Verificar que el archivo tablas.sql se encuentre en el directorio
     * util/tablasSQL/tablas.sql de lo contrario cambiar el path
     * donde se encentre alojado
     * 
     * @throws BufferedReader
     * Cerrar el canal de comunicaciones que se crea
     * para proceder con la lectura del archivo
     * 
     */
    public String crearTablas() {
        String linea;

        try {
        InputStream is = getClass().getResourceAsStream("util/tablasSQL/tablas.sql") ;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        //Lectura por líneas
        while ((linea = br.readLine()) != null) {
            sql.append(linea).append("\n");
        }
        
        //Cerrando la comunicación
        br.close();
        isr.close();
        is.close();
        }catch(Exception e){
            String mnj = "Error al crear las tablas del archivo tablas.sql";
            JOptionPane.showMessageDialog(null, mnj+"\n"+e , "Error",
            JOptionPane.WARNING_MESSAGE);
        }
        return sql.toString();
    }
}
