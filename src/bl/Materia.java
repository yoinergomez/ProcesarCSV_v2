/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 * 
 * @author Yoiner Gómez - yoiner.gomez22@gmail.com
 * @version 1.1
 */
public class Materia {
    
    private String materia;
    private String departamento;
    private String facultad;
    private String nombre;

    public Materia(String facultad, String departamento, String codigo, String nombre) {
        this.materia = codigo;
        this.departamento = departamento;
        this.facultad = facultad;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return materia;
    }

    public void setCodigo(String codigo) {
        this.materia = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCodMateria(){
        return facultad+departamento+materia;
    }
}

