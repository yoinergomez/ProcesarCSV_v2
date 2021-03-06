/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author esteban
 */
public class FilaCSV {

    private String fac;
    private String dep;
    private String ide;
    private String mat;
    private String gr;
    private String nombre;
    private String cupo;
    private String matri;
    private String bloqueAula;
    private String horario;
    private String cedula;
    private String profesor;
    
    /**
     * Constructor de la clase. <br/>
     * Apartir del String csv se fragmenta la linea 
     * con los atributos de esta clase
     * @param csv
     * String que contiene una línea CSV 
     */
    public FilaCSV(String csv){
        
        String[] frag = csv.split(";",12);
        fac = eliminarASCII(frag[0]);
        dep = eliminarASCII(frag[1]);
        ide = eliminarASCII(frag[2]);
        mat = eliminarASCII(frag[3]);
        gr = eliminarASCII(frag[4]);
        nombre = eliminarASCII(frag[5]);
        cupo = eliminarASCII(frag[6]);
        matri = eliminarASCII(frag[7]);
        bloqueAula = eliminarASCII(frag[8]);   
        horario = eliminarASCII(frag[9]);
        cedula = eliminarASCII(frag[10]);
        profesor = eliminarASCII(frag[11]);
    }
    
    public boolean existeMateria(){
        return (!fac.isEmpty() && !dep.isEmpty() && 
                !mat.isEmpty() && !gr.isEmpty());
    }
    
    public boolean existeAula(){
        return !bloqueAula.isEmpty();
    }
    
    public boolean existeHorario(){
        return !horario.isEmpty();
    }
    
    public boolean existeProfesor(){
        return !cedula.isEmpty();
    }
    
    public FilaCSV ajustarCodigoMateria(FilaCSV fila){
        
        while(fila.getFac().length()<2 && !fila.getFac().isEmpty()){
            fila.setFac("0"+fila.getFac());
        }
        while(fila.getDep().length()<2 && !fila.getDep().isEmpty()){
            fila.setDep("0"+fila.getDep());
        }
        while(fila.getMat().length()<3 && !fila.getMat().isEmpty()){
            fila.setMat("0"+fila.getMat());
        }
        
        return fila;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public int getGr() {
        try{
            return Integer.parseInt(gr);
        }catch(NumberFormatException e){
            return 0;
        }
    }

    public void setGr(String gr) {
        this.gr = gr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        try{
            return Integer.parseInt(cupo);
        } catch (NumberFormatException e){
            return 0;
        }
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public int getMatri() {
        try{
            return Integer.parseInt(matri);
        } catch (NumberFormatException e){
            return 0;
        }
    }

    public void setMatri(String matri) {
        this.matri = matri;
    }

    public String getBloqueAula() {
        return bloqueAula;
    }

    public void setBloqueAula(String bloqueAula) {
        this.bloqueAula = bloqueAula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String eliminarASCII(String sub){
        sub = sub.replaceAll("[^\\u0000-\\uFFFF]", "");
        sub = sub.replaceAll("[^\\x20-\\x7e]", "");
        return sub;
    }
}
