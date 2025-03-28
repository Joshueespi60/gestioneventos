/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capainterfaz;

import capaentidad.Evento;
import capadatos.EventoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class PantallaVisualizacionEventos extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel;
    private EventoDAO eventoDAO;
    /**
     * Creates new form PantallaVisualizacionEventos
     */
    public PantallaVisualizacionEventos() {
        initComponents();
        eventoDAO = new EventoDAO();
        tableModel = new DefaultTableModel();
        tableEventos.setModel(tableModel);
        
        // Configurar las columnas de la tabla
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Lugar");
        tableModel.addColumn("Descripción");
        tableModel.addColumn("Capacidad");
        tableModel.addColumn("Precio");

        // Cargar los eventos al inicio
        cargarEventos();
       
        // Configurar acción del botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEventos();
            }
        });

        // Configurar acción del botón Ver Detalles
        btnVerDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verDetallesEvento();
            }
        });

        // Configurar acción del botón Reservar
        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservarEntrada();
            }
        });
    }
    
    // Método para cargar los eventos desde la base de datos
    private void cargarEventos() {
        List<Evento> eventos = eventoDAO.obtenerEventos();
        tableModel.setRowCount(0); // Limpiar la tabla

        // Añadir los eventos a la tabla
        for (Evento evento : eventos) {
            Object[] row = new Object[6];
            row[0] = evento.getNombre();
            row[1] = evento.getFecha().toString();
            row[2] = evento.getLugar();
            row[3] = evento.getDescripcion();
            row[4] = evento.getCapacidad();
            row[5] = evento.getPrecio();
            tableModel.addRow(row);
        }
    }
     // Método para buscar eventos
    private void buscarEventos() {
        String nombre = txtBuscarNombre.getText();
        String lugar = txtBuscarLugar.getText();

        // Realizar la búsqueda en la base de datos
        List<Evento> eventos = eventoDAO.buscarEventos(nombre, lugar);
        tableModel.setRowCount(0); // Limpiar la tabla

        // Añadir los eventos encontrados a la tabla
        for (Evento evento : eventos) {
            Object[] row = new Object[6];
            row[0] = evento.getNombre();
            row[1] = evento.getFecha().toString();
            row[2] = evento.getLugar();
            row[3] = evento.getDescripcion();
            row[4] = evento.getCapacidad();
            row[5] = evento.getPrecio();
            tableModel.addRow(row);
        }
    }

    // Método para ver detalles del evento seleccionado
    private void verDetallesEvento() {
        int selectedRow = tableEventos.getSelectedRow();

        if (selectedRow != -1) {
            String nombreEvento = (String) tableModel.getValueAt(selectedRow, 0);
            Evento evento = eventoDAO.obtenerEventoPorNombre(nombreEvento);

            if (evento != null) {
                // Mostrar los detalles del evento
                JOptionPane.showMessageDialog(this, 
                        "Nombre: " + evento.getNombre() + "\n" +
                        "Fecha: " + evento.getFecha() + "\n" +
                        "Lugar: " + evento.getLugar() + "\n" +
                        "Descripción: " + evento.getDescripcion() + "\n" +
                        "Capacidad: " + evento.getCapacidad() + "\n" +
                        "Precio: " + evento.getPrecio(), 
                        "Detalles del Evento", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un evento de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para reservar entradas para un evento
    private void reservarEntrada() {
        int selectedRow = tableEventos.getSelectedRow();

        if (selectedRow != -1) {
            String nombreEvento = (String) tableModel.getValueAt(selectedRow, 0);
            Evento evento = eventoDAO.obtenerEventoPorNombre(nombreEvento);

            if (evento != null) {
                // Realizar la acción de reserva (esto es solo un ejemplo)
                int capacidadRestante = evento.getCapacidad();
                if (capacidadRestante > 0) {
                    // Reservar la entrada (reducir la capacidad)
                    evento.setCapacidad(capacidadRestante - 1);
                    JOptionPane.showMessageDialog(this, "¡Entrada reservada con éxito!");
                    cargarEventos(); // Actualizar la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "No hay entradas disponibles para este evento.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un evento de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEventos = new javax.swing.JTable();
        txtBuscarNombre = new javax.swing.JTextField();
        txtBuscarLugar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnVerDetalles = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableEventos);

        jLabel1.setText("BUSCAR NOMBRE:");

        jLabel2.setText("BUSCAR LUGAR:");

        btnBuscar.setText("BUSCAR");

        btnVerDetalles.setText("VER DETALLES");

        btnReservar.setText("RESERVAR");

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(txtBuscarLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnVerDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(48, 48, 48)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addComponent(txtBuscarLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
         this.dispose(); // Cierra la ventana actual
        MenuPrincipal menu = new MenuPrincipal(); // Crea una nueva instancia del menú
        menu.setVisible(true); // Muestra la ventana del menú
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEventos;
    private javax.swing.JTextField txtBuscarLugar;
    private javax.swing.JTextField txtBuscarNombre;
    // End of variables declaration//GEN-END:variables
}
