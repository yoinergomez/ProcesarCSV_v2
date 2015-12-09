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
public class Grupo {
    
    private String materia;
    private String departamento;
    private String facultad;
    private int numero;
    private int cupo;
    private int matriculados;

    public Grupo(Materia materia, int numero, int cupo, int matriculados) {
        this.numero = numero;
        this.cupo = cupo;
        this.matriculados = matriculados;
        
        this.facultad = materia.getFacultad();
        this.departamento = materia.getDepartamento();
        this.materia = materia.getCodigo();
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(int matriculados) {
        this.matriculados = matriculados;
    }
    
    public String getCodMateria(){
        return facultad+departamento+materia;
    }
}
