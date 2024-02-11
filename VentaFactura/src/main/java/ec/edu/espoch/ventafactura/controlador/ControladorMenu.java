
package ec.edu.espoch.ventafactura.controlador;

import ec.edu.espoch.ventafactura.modelo.Archivo;
import ec.edu.espoch.ventafactura.vista.Ingresar;
import ec.edu.espoch.ventafactura.vista.Listar;
import ec.edu.espoch.ventafactura.vista.MenuPrincipal;

public class ControladorMenu {
    private MenuPrincipal menuPrincipal;
    private Ingresar ingresar;
    private Listar listar;
    
    public ControladorMenu(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        this.ingresar = new Ingresar();
        this.listar = new Listar();
    }
    
    public void procesoDireccion(String accion) {

         Archivo.crearArchivo();
        switch (accion) {
            case "INGRESAR" -> ingresar.setVisible(true);
            case "LISTAR" -> listar.setVisible(true);
            default -> throw new AssertionError();
        }
     }
}
