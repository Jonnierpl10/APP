package ec.edu.espoch.ventafactura.modelo;

import java.util.ArrayList;

public class Persona {

    private String nombre;
    private String cedula;
    private String direccion;
    private String nombreProducto;
    private Integer cantidad;
    private Double precio;
    private Double vDia;
    private Double totalVentasDia;

    public Persona() {
        totalVentasDia = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getvDia() {
        return vDia;
    }

    public void setvDia(Double vDia) {
        this.vDia = vDia;
    }

    public Double getTotalVentasDia() {
        return totalVentasDia;
    }

    public void setTotalVentasDia(Double totalVentasDia) {
        this.totalVentasDia = totalVentasDia;
    }

    public String ingresarDatos() {
        this.vDia = cantidad * precio;
        this.totalVentasDia += this.vDia;
        return Archivo.anexarArchivo(this.nombre, this.cedula, this.direccion,
                this.nombreProducto, this.cantidad, this.precio, this.vDia);
    }

    public ArrayList<Persona> mostrarDatos() {
        return Archivo.leerArchivo();
    }

    public void eliminarTodoRegistro() {
        Archivo.eliminarTodoRegistro();
    }

    public void modificarDatos(String nuevoNombre, String nuevaCedula, String nuevaDireccion,
            String nuevoNombreProducto, int nuevaCantidad, double nuevoPrecio,
            double nuevoVentDia) {
        // Implementa la lógica de modificación según tus necesidades
        this.setNombre(nuevoNombre);
        this.setCedula(nuevaCedula);
        this.setDireccion(nuevaDireccion);
        this.setNombreProducto(nuevoNombreProducto);
        this.setCantidad(nuevaCantidad);
        this.setPrecio(nuevoPrecio);
        this.setvDia(nuevoVentDia);
    }
    
    public Persona(String nombre, String cedula, String direccion, String nombreProducto,
                   Integer cantidad, Double precio, Double vDia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.vDia = vDia;
    }
}
