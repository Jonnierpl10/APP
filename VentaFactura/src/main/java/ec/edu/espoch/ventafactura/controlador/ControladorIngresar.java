
package ec.edu.espoch.ventafactura.controlador;

import ec.edu.espoch.ventafactura.modelo.Persona;
import ec.edu.espoch.ventafactura.vista.Ingresar;

public class ControladorIngresar {
    
    private Ingresar ingresar;
    private Persona persona;
    
    public ControladorIngresar(Ingresar ingresar) {
        this.ingresar = ingresar;
        this.persona = new Persona();
    }
    
    public void procesoIngresar() {
        double precio;
        int cantidad;
        String nombre, cedula, direccion, nombreProducto;

        try {
            precio = Double.parseDouble(this.ingresar.getPrecio());
            if (precio < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            this.ingresar.mostrarMensajeError("El precio no es válido. Debe ser un valor no negativo.");
            return;
        }

        try {
            cantidad = Integer.parseInt(this.ingresar.getCantidad());
            if (cantidad < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            this.ingresar.mostrarMensajeError("La cantidad no es válida. Debe ser un valor no negativo.");
            return;
        }

        nombre = this.ingresar.getNombre();
        cedula = this.ingresar.getCedula();
        direccion = this.ingresar.getDireccion();
        nombreProducto = this.ingresar.getNombreProducto();

        this.persona.setNombre(nombre);
        this.persona.setCedula(cedula);
        this.persona.setDireccion(direccion);
        this.persona.setNombreProducto(nombreProducto);
        this.persona.setCantidad(cantidad);
        this.persona.setPrecio(precio);

        String msm = this.persona.ingresarDatos();
        this.ingresar.mostrarRespuesta(msm);
        this.ingresar.mostrarMensajeError("");
    }
}