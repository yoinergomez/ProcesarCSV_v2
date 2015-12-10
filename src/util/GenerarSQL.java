/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Materia;

/**
 *
 * @author esteban
 */
public class GenerarSQL {
    
    private StringBuilder sql;
    
    public GenerarSQL() {
        sql = new StringBuilder();
        sql = crearTablas();
    }
     
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
    public StringBuilder crearTablas() {
        String linea;

        try {
        InputStream is = this.getClass()
                  .getClassLoader().getResourceAsStream("util/tablasSQL/tablas.sql") ;
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
        return sql;
    }
    

    
//    public void mostrarGrupos(){
//        System.out.println(grupos.size());
//        sql.append("Grupos "+grupos.size()+"\n");
//        for (int i = 0; i < grupos.size(); i++) {
//            System.out.println(grupos.get(i).getCodMateria()+
//                    "\t"+grupos.get(i).getNumero()+
//                    "\t"+grupos.get(i).getCupo()+
//                    "\t"+grupos.get(i).getMatriculados());
//            sql.append(grupos.get(i).getCodMateria()+
//                    "\t"+grupos.get(i).getNumero()+
//                    "\t"+grupos.get(i).getCupo()+
//                    "\t"+grupos.get(i).getMatriculados()+"\n");
//        }
//    }
//    
//    public void mostrarGrupoAula(){
//        System.out.println(aulas.size());
//        sql.append("GruposAulas "+aulas.size()+"\n");
//        for (int i = 0; i < aulas.size(); i++) {
//            System.out.println(aulas.get(i).getCodMateria()+
//                    "\t"+aulas.get(i).getAula());
//            sql.append(aulas.get(i).getCodMateria()+
//                    "\t"+aulas.get(i).getAula()+"\n");
//        }
//    }
//    
//    public void mostrarGrupoHorario(){
//        System.out.println(horarios.size());
//        sql.append("GruposHorarios "+horarios.size()+"\n");
//        for (int i = 0; i < horarios.size(); i++) {
//            System.out.println(horarios.get(i).getCodMateria()+
//                    "\t"+horarios.get(i).getHorario());
//            sql.append(horarios.get(i).getCodMateria()+
//                    "\t"+horarios.get(i).getHorario()+"\n");
//        }
//    }
//    
//    public void mostrarGrupoProfesor(){
//        System.out.println(profesores.size());
//        sql.append("GruposProfesores "+profesores.size()+"\n");
//        for (int i = 0; i < profesores.size(); i++) {
//            System.out.println(profesores.get(i).getCodMateria()+
//                    "\t"+profesores.get(i).getCedula()+
//                    "\t"+profesores.get(i).getNombre());
//            sql.append(profesores.get(i).getCodMateria()+
//                    "\t"+profesores.get(i).getCedula()+
//                    "\t"+profesores.get(i).getNombre()+"\n");
//        }
//    }
    
    public void CrearArchivoSQL() {
        String directorio = System.getProperty("user.dir") + "/PROGRAMACION.sql";
        File file = new File(directorio);
        try {
            FileWriter w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(sql.toString());//Escribir en el archivo
            wr.close();
            bw.close();
        } catch (IOException e) {
            String mnj = "Error al crear el archivo SQL";
            JOptionPane.showMessageDialog(null, mnj+"\n"+e , "Error",
            JOptionPane.WARNING_MESSAGE);
        }
    }
}
