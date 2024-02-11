package ec.edu.espoch.ventafactura.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {

    public static void crearArchivo() {
        String direccion = "C:/FacturaVentas";
        File carpeta = new File(direccion);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        File archivo = new File(carpeta, "archivoFacturaVentas.txt");
        try {
            if (!archivo.exists()) {
                PrintWriter salida = new PrintWriter(archivo);
                salida.close();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static ArrayList<Persona> leerArchivo() {
        ArrayList<Persona> personas = new ArrayList<>();

        String direccion = "C:/FacturaVentas";
        File carpeta = new File(direccion);
        File archivo = new File(carpeta, "archivoFacturaVentas.txt");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                String[] datos = lectura.split(";");
                Persona objPersona = new Persona();
                objPersona.setNombre(datos[0]);
                objPersona.setCedula(String.valueOf(datos[1]));
                objPersona.setDireccion(datos[2]);
                objPersona.setNombreProducto(datos[3]);
                objPersona.setCantidad(Integer.valueOf(datos[4]));
                objPersona.setPrecio(Double.valueOf(datos[5]));
                objPersona.setvDia(Double.valueOf(datos[6]));
                personas.add(objPersona);

                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return personas;
    }

    public static String anexarArchivo(String nombre, String cedula, String direccion, String nombreProducto, int cantidad, double precio, double ventDia) {
        File carpeta = new File("C:/FacturaVentas");
        File archivo = new File(carpeta, "archivoFacturaVentas.txt");
        String verificar = "";
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String contenido = "" + nombre + ";" + cedula + ";" + direccion + ";" + nombreProducto + ";" + cantidad + ";" + precio + ";" + ventDia;
            salida.println(contenido);
            salida.close();
            verificar = "Registro correcto";
        } catch (FileNotFoundException ex) {
            verificar = "Error, al acceder al archivo";
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            verificar = "Error, escribir en el archivo";
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificar;
    }

    public static void eliminarTodoRegistro() {
        String direccion = "C:/FacturaVentas";
        File carpeta = new File(direccion);
        File archivo = new File(carpeta, "archivoFacturaVentas.txt");

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, false));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static boolean eliminarRegistroPorCedula(String cedula) {
        ArrayList<Persona> personas = leerArchivo();
        boolean eliminacionExitosa = false;

        // Buscar la persona con la cédula proporcionada y eliminarla de la lista
        for (Persona persona : personas) {
            if (persona.getCedula().equals(cedula)) {
                personas.remove(persona);
                eliminacionExitosa = true;
                break;  // Salir del bucle una vez que se ha encontrado y eliminado la persona
            }
        }

        // Actualizar el archivo con la nueva lista de personas (sin la persona eliminada)
        if (eliminacionExitosa) {
            actualizarArchivo(personas);
        }

        return eliminacionExitosa;
    }

    private static void actualizarArchivo(ArrayList<Persona> personas) {
        String direccion = "C:/FacturaVentas";
        File carpeta = new File(direccion);
        File archivo = new File(carpeta, "archivoFacturaVentas.txt");

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, false));

            for (Persona persona : personas) {
                String contenido = persona.getNombre() + ";" + persona.getCedula() + ";" + persona.getDireccion() + ";"
                        + persona.getNombreProducto() + ";" + persona.getCantidad() + ";" + persona.getPrecio() + ";"
                        + persona.getvDia();
                salida.println(contenido);
            }

            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
