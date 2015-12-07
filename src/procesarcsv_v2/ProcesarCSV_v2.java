/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarcsv_v2;

import bl.FilaCSV;
import bl.Grupo;
import bl.GrupoAula;
import bl.GrupoHorario;
import bl.GrupoProfesor;
import bl.Materia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author esteban
 */
public class ProcesarCSV_v2 {
    
    Map<String, Materia> materias = new HashMap<>();
    ArrayList<Grupo> grupos = new ArrayList<>();
    ArrayList<GrupoAula> aulas = new ArrayList<>();
    ArrayList<GrupoHorario> horarios = new ArrayList<>();
    ArrayList<GrupoProfesor> profesores = new ArrayList<>();
    private StringBuilder sql = new StringBuilder();
    
    public void procesarlinea(){
        
        String linea;
        FilaCSV primero;
        FilaCSV ultimo = null;
        Materia materia;
        Grupo grupo;
        GrupoAula aula;
        GrupoHorario horario;
        GrupoProfesor profesor;
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     AQUI ESTABAN TODOS LOS ATRIBUTOS DE LA CLASE
        
        try {
            FileReader f = new FileReader("/home/esteban/Descargas/casosCSV.csv");
            //FileReader f = new FileReader("/home/esteban/Descargas/PROGRAMACION.csv");
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
                    materias.put(materia.getCodMateria(), materia);
                    
                    grupo = new Grupo(materia,
                                      primero.getGr(), 
                                      primero.getCupo(), 
                                      primero.getMatri());
                    grupos.add(grupo);
                    
                    if (primero.existeAula()){
                        aula = new GrupoAula(grupo, primero.getBloqueAula());
                        aulas.add(aula);
                    }
                    
                    if (primero.existeHorario()){
                        horario = new GrupoHorario(grupo, primero.getHorario());
                        horarios.add(horario);
                    }
                    
                    if (primero.existeProfesor()){
                        profesor = new GrupoProfesor(grupo, 
                                                    primero.getCedula(), 
                                                    primero.getProfesor());
                        profesores.add(profesor);
                    }
                    
                    ultimo=primero;
                    
                } else {
                    materia = new Materia(ultimo.getFac(), 
                                          ultimo.getDep(), 
                                          ultimo.getMat(), 
                                          ultimo.getNombre());
                    
                    grupo = new Grupo(materia,
                                      ultimo.getGr(), 
                                      ultimo.getCupo(), 
                                      ultimo.getMatri());
                    
                    if (primero.existeAula()){
                        aula = new GrupoAula(grupo, primero.getBloqueAula());
                        aulas.add(aula);
                    }
                    
                    if (primero.existeHorario()){
                        horario = new GrupoHorario(grupo, primero.getHorario());
                        horarios.add(horario);
                    }
                    
                    if (primero.existeProfesor()){
                        profesor = new GrupoProfesor(grupo, 
                                                    primero.getCedula(), 
                                                    primero.getProfesor());
                        profesores.add(profesor);
                    }
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
        } catch (NullPointerException ex) {
            String mnj = "La primera línea no contiene un curso válido";
            JOptionPane.showMessageDialog(null, mnj+"\n"+ex , "Error",
            JOptionPane.WARNING_MESSAGE);
        } 
        
    }
   
    public void mostrarMaterias(){
        System.out.println(materias.size());
        sql.append("Materias "+materias.size()+"\n");
        Iterator it = materias.keySet().iterator();
        while(it.hasNext()){
            String key = (String) it.next();
            System.out.println(key + "\t" + materias.get(key).getNombre());
            sql.append(key).append("\t").append(materias.get(key).getNombre()+"\n");
        }
    }
    
    public void mostrarGrupos(){
        System.out.println(grupos.size());
        sql.append("Grupos "+grupos.size()+"\n");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println(grupos.get(i).getCodMateria()+
                    "\t"+grupos.get(i).getNumero()+
                    "\t"+grupos.get(i).getCupo()+
                    "\t"+grupos.get(i).getMatriculados());
            sql.append(grupos.get(i).getCodMateria()+
                    "\t"+grupos.get(i).getNumero()+
                    "\t"+grupos.get(i).getCupo()+
                    "\t"+grupos.get(i).getMatriculados()+"\n");
        }
    }
    
    public void mostrarGrupoAula(){
        System.out.println(aulas.size());
        sql.append("GruposAulas "+aulas.size()+"\n");
        for (int i = 0; i < aulas.size(); i++) {
            System.out.println(aulas.get(i).getCodMateria()+
                    "\t"+aulas.get(i).getAula());
            sql.append(aulas.get(i).getCodMateria()+
                    "\t"+aulas.get(i).getAula()+"\n");
        }
    }
    
    public void mostrarGrupoHorario(){
        System.out.println(horarios.size());
        sql.append("GruposHorarios "+horarios.size()+"\n");
        for (int i = 0; i < horarios.size(); i++) {
            System.out.println(horarios.get(i).getCodMateria()+
                    "\t"+horarios.get(i).getHorario());
            sql.append(horarios.get(i).getCodMateria()+
                    "\t"+horarios.get(i).getHorario()+"\n");
        }
    }
    
    public void mostrarGrupoProfesor(){
        System.out.println(profesores.size());
        sql.append("GruposProfesores "+profesores.size()+"\n");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println(profesores.get(i).getCodMateria()+
                    "\t"+profesores.get(i).getCedula()+
                    "\t"+profesores.get(i).getNombre());
            sql.append(profesores.get(i).getCodMateria()+
                    "\t"+profesores.get(i).getCedula()+
                    "\t"+profesores.get(i).getNombre()+"\n");
        }
    }
    
    public void generarSQL() {
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

        };

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProcesarCSV_v2 run = new ProcesarCSV_v2();
        run.procesarlinea();
        run.mostrarMaterias();
        run.mostrarGrupos();
        run.mostrarGrupoAula();
        run.mostrarGrupoHorario();
        run.mostrarGrupoProfesor();
        run.generarSQL();
    }
    
}
