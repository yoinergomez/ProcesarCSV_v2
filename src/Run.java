
import util.GenerarSQL;
import util.LeerCSV;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author esteban
 */
public class Run {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LeerCSV leer = new LeerCSV();
        GenerarSQL generar = new GenerarSQL();
        
        leer.fragmentarLinea();
        
        
        /*
        leer.generarMaterias(leer.getMaterias());
        leer.mostrarGrupos();
        leer.mostrarGrupoAula();
        leer.mostrarGrupoHorario();
        leer.mostrarGrupoProfesor();
        leer.CrearArchivoSQL();
        */
    }
}
