package ec.edu.espoch.ventafactura.vista;

import ec.edu.espoch.ventafactura.controlador.ControladorListar;
import ec.edu.espoch.ventafactura.modelo.Archivo;
import ec.edu.espoch.ventafactura.modelo.Persona;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Listar extends javax.swing.JFrame {

    private ControladorListar controlador;
    DefaultTableModel model = new DefaultTableModel();

    public Listar() {
        initComponents();
        controlador = new ControladorListar(this);
        controlador.procesoAgregar();
    }

    public void setModelo() {
        String[] cabecera = {"Nombre", "Cedula", "Direccion", "Nombre Producto", "Cantidad", "Precio", "Total"};
        model.setColumnIdentifiers(cabecera);
        tabla.setModel(model);
    }

    public void setDatos(ArrayList<Persona> personas) {
        Object[] datos = new Object[model.getColumnCount()];
        int i = 0;
        double totalVentas = 0.0;

        for (Persona persona : personas) {
            datos[0] = persona.getNombre();
            datos[1] = persona.getCedula();
            datos[2] = persona.getDireccion();
            datos[3] = persona.getNombreProducto();
            datos[4] = persona.getCantidad();
            datos[5] = persona.getPrecio();
            datos[6] = persona.getvDia();

            totalVentas += persona.getvDia();
            model.addRow(datos);
        }

        ventasTotalDelDia.setText("$ " + String.valueOf(totalVentas) + " USD");
        tabla.setModel(model);
    }

    public void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        ventasTotalDelDia.setText("");
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) tabla.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ventasTotalDelDia = new javax.swing.JTextField();
        eliminarTodoElRegisto = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro de Ventas");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel2.setText("Total de ventas:");

        ventasTotalDelDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasTotalDelDiaActionPerformed(evt);
            }
        });

        eliminarTodoElRegisto.setText("Eliminar Registro");
        eliminarTodoElRegisto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTodoElRegistoActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ventasTotalDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eliminarTodoElRegisto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(187, 187, 187))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ventasTotalDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarTodoElRegisto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificar)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    private void ventasTotalDelDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasTotalDelDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ventasTotalDelDiaActionPerformed

    private void eliminarTodoElRegistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTodoElRegistoActionPerformed
        controlador.procesoEliminarTodoRegistro();
        limpiarTabla();
    }//GEN-LAST:event_eliminarTodoElRegistoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int selectedRowIndex = tabla.getSelectedRow();

        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Obtener la cédula de la fila seleccionada
            String cedula = model.getValueAt(selectedRowIndex, 1).toString();

            // Llamar al método de tu clase Archivo para eliminar el registro con la cédula específica
            boolean eliminacionExitosa = Archivo.eliminarRegistroPorCedula(cedula);

            if (eliminacionExitosa) {
                // Si la eliminación es exitosa, entonces procede a eliminar la fila de la tabla
                model.removeRow(selectedRowIndex);

                // You may want to update your data structure (ArrayList<Persona>) accordingly here.
                // Clear the selection
                tabla.clearSelection();

                // Optionally, you may want to update the total sales after removing the row
                actualizarTotalVentas();
            } else {
                // Muestra un mensaje de error si la eliminación no fue exitosa
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mostrar un mensaje indicando que no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener datos de la fila seleccionada
            String nombre = tabla.getValueAt(filaSeleccionada, 0).toString();
            String cedula = tabla.getValueAt(filaSeleccionada, 1).toString();
            String direccion = tabla.getValueAt(filaSeleccionada, 2).toString();
            String nombreProducto = tabla.getValueAt(filaSeleccionada, 3).toString();
            int cantidad = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 4).toString());
            double precio = Double.parseDouble(tabla.getValueAt(filaSeleccionada, 5).toString());
            double vDia = Double.parseDouble(tabla.getValueAt(filaSeleccionada, 6).toString());

            // Crear una instancia de la interfaz de Ingresar y pasar datos
            Ingresar ingreso = new Ingresar(nombre, cedula, direccion, nombreProducto, cantidad, precio, vDia, Listar.this, filaSeleccionada);
            ingreso.setVisible(true);

            // Esperar hasta que se complete la modificación en la interfaz Ingresar
            // ...
            // Una vez que se completa la modificación, obtener los nuevos datos
            String nuevoNombre = ingreso.getNombre();
            String nuevaCedula = ingreso.getCedula();
            String nuevaDireccion = ingreso.getDireccion();
            String nuevoNombreProducto = ingreso.getNombreProducto();
            int nuevaCantidad = Integer.parseInt(ingreso.getCantidad());
            double nuevoPrecio = Double.parseDouble(ingreso.getPrecio());

            // Modificar los datos en la tabla directamente
            modificarDatosEnTabla(filaSeleccionada, nuevoNombre, nuevaCedula, nuevaDireccion,
                    nuevoNombreProducto, nuevaCantidad, nuevoPrecio);

            // Opcionalmente, puedes actualizar los datos en la lista de personas
            // ...
        } else {
            // Mostrar un mensaje indicando que no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void actualizarTotalVentas() {
        double totalVentas = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalVentas += Double.parseDouble(model.getValueAt(i, 6).toString());
        }
        ventasTotalDelDia.setText("$ " + String.valueOf(totalVentas) + " USD");
    }

    public void modificarDatosEnTabla(int filaSeleccionada, String nuevoNombre, String nuevaCedula, String nuevaDireccion,
            String nuevoNombreProducto, int nuevaCantidad, double nuevoPrecio) {
        double nuevoVentDia = nuevaCantidad * nuevoPrecio;

        model.setValueAt(nuevoNombre, filaSeleccionada, 0);
        model.setValueAt(nuevaCedula, filaSeleccionada, 1);
        model.setValueAt(nuevaDireccion, filaSeleccionada, 2);
        model.setValueAt(nuevoNombreProducto, filaSeleccionada, 3);
        model.setValueAt(nuevaCantidad, filaSeleccionada, 4);
        model.setValueAt(nuevoPrecio, filaSeleccionada, 5);
        model.setValueAt(nuevoVentDia, filaSeleccionada, 6);

        // Actualiza el total de ventas
        actualizarTotalVentas();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminarTodoElRegisto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ventasTotalDelDia;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
