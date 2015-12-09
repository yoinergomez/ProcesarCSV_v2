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
public class GrupoProfesor {
    
    private String materia;
    private String departamento;
    private String facultad;
    private String cedula;
    private String nombre;

    public GrupoProfesor(Grupo grupo, String cedula, String nombre) {
        this.materia = grupo.getMateria();
        this.departamento = grupo.getDepartamento();
        this.facultad = grupo.getFacultad();
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
