/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarcsv_v2;

import util.LeerCSV;

/**
 *
 * @author esteban
 */
public class GenerarSQL {
     
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LeerCSV run = new LeerCSV();
        run.fragmentarLinea();
        run.mostrarMaterias();
        run.mostrarGrupos();
        run.mostrarGrupoAula();
        run.mostrarGrupoHorario();
        run.mostrarGrupoProfesor();
        run.generarSQL();
    }
}
