/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.FilaCSV;
import model.Grupo;
import model.GrupoAula;
import model.GrupoHorario;
import model.GrupoProfesor;
import model.Materia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author esteban
 */
public class LeerCSV {
    
    private Map<String, Materia> materias = new HashMap<>();
    private Map<String, Grupo> grupos = new HashMap<>();
    private Map<String, GrupoAula> grupAulas = new HashMap<>();
    //private ArrayList<GrupoAula> grupAulas = new ArrayList<>();
    private ArrayList<GrupoHorario> horarios = new ArrayList<>();
    private ArrayList<GrupoProfesor> profesores = new ArrayList<>();
    private StringBuilder sql = new StringBuilder();
    
    public void fragmentarLinea(){
        
        String linea;
        FilaCSV primero;
        FilaCSV ultimo = null;
        Materia materia;
        Grupo grupo;
        GrupoAula aula;
        GrupoHorario horario;
        GrupoProfesor profesor;
        
        try {
            //FileReader f = new FileReader("/home/esteban/Descargas/casosCSV.csv");
            FileReader f = new FileReader("/home/esteban/Descargas/PROGRAMACIONTOTAL.csv");
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
                    grupos.put(grupo.getCodMateria()+grupo.getNumero(), grupo);
                    
                    if (primero.existeAula()){
                        aula = new GrupoAula(grupo, primero.getBloqueAula());
                        grupAulas.put(aula.getCodMateria()+
                                aula.getNumero()+aula.getAula(), aula);
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
                        grupAulas.put(aula.getCodMateria()+
                                aula.getNumero()+aula.getAula(), aula);
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
                        if(profesor.getCedula().contains("\"")){
                            System.out.println("Entre: "+"\t" +profesores.size());
                        }
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

    public Map<String, Materia> getMaterias() {
        return materias;
    }

    public Map<String, Grupo> getGrupos() {
        return grupos;
    }

    public Map<String, GrupoAula> getAulas() {
        return grupAulas;
    }

    public ArrayList<GrupoHorario> getHorarios() {
        return horarios;
    }

    public ArrayList<GrupoProfesor> getProfesores() {
        return profesores;
    }
}
