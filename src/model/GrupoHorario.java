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
public class GrupoHorario {
    private String materia;
    private String departamento;
    private String facultad;
    private int numero;
    private String horario;

    public GrupoHorario(Grupo grupo, String horario) {
        this.materia = grupo.getMateria();
        this.departamento = grupo.getDepartamento();
        this.facultad = grupo.getFacultad();
        this.numero = grupo.getNumero();
        this.horario = horario;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public String getCodMateria(){
        return facultad+departamento+materia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
   
}
