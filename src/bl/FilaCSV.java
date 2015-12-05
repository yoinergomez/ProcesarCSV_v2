/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

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
        
        String[] frag = csv.split(",",12);
        fac = frag[0];
        dep = frag[1];
        ide = frag[2];
        mat = frag[3];
        gr = frag[4];
        nombre = frag[5];
        cupo = frag[6];
        matri = frag[7];
        horario = frag[9];
        bloqueAula = frag[10];
        profesor = frag[11];
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

    public String getGr() {
        return gr;
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

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public String getMatri() {
        return matri;
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

    
}
