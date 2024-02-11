
package ec.edu.espoch.ventafactura.controlador;

import ec.edu.espoch.ventafactura.modelo.Persona;
import ec.edu.espoch.ventafactura.vista.Listar;

public class ControladorListar {
    private Listar listar;
    private Persona persona;
    
    public ControladorListar(Listar lista) {
        this.listar = lista;
        this.persona = new Persona();
    }
    
    public void procesoAgregar() {
        persona.mostrarDatos();
        this.listar.setModelo();
        this.listar.setDatos(this.persona.mostrarDatos());
    }
    
    public void procesoEliminarTodoRegistro() {
        persona.eliminarTodoRegistro();
        listar.limpiarTabla();
    }
}
