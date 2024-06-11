/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.ColectivoData;
import AccesoADatos.HorarioData;

import AccesoADatos.PasajeData;
import AccesoADatos.PasajeroData;
import AccesoADatos.RutaData;
import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import java.awt.Component;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentaDePasajesView extends javax.swing.JInternalFrame {

   private List<Ruta> listaRutas;
   private List<Horario> listaHorarios;
   private List<Colectivo> listaColectivos;
   private List<Pasajero> listaPasajeros;
   private List<Integer> asientos;
   
   private RutaData rutData;
   private HorarioData horData;
   private ColectivoData colData;
   private PasajeroData pasData;
   private PasajeData psjData;
   
   
   private DefaultTableModel modelo;
   
    public VentaDePasajesView() {
        initComponents();

        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                    return false;     
            }
        };

        rutData = new RutaData();
        listaRutas = rutData.obtenerRutas();
        horData= new HorarioData();
        listaHorarios = new ArrayList<Horario>();
        colData = new ColectivoData();
        listaColectivos = colData.listarColectivos();
        pasData=new PasajeroData();
        psjData = new PasajeData();
       
        
       // TextPrompt placeholder = new TextPrompt("Dni",jtDniPasajero) ;
        
        
        jdFechaViaje.setSelectableDateRange(Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
        
        cargarRutas();
        cargarColectivos();
        
        armarCabeceraTabla();
        activarIngreso(false);
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCRutas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHorarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanelIngreso = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jdFechaViaje = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jtDniPasajero = new javax.swing.JTextField();
        jbBuscarPasajero = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfMostrarNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfMostrarApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfMostrarID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jcAsientos = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcColectivos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(800, 300));

        jCRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCRutasActionPerformed(evt);
            }
        });

        jLabel6.setText("Seleccione Recorrido");

        jTHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTHorarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTHorariosFocusGained(evt);
            }
        });
        jTHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTHorariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTHorarios);

        jLabel1.setText("Seleccione un Horario");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8-bus-salida-48.png"))); // NOI18N
        jButton1.setText("Guardar Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8-salida-de-emergencia-48.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha :");

        jLabel3.setText("Precio $:");

        jtfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel10.setText("Seleccione pasajero");

        jtDniPasajero.setToolTipText("");

        jbBuscarPasajero.setText("Buscar");
        jbBuscarPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarPasajeroActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre");

        jtfMostrarNombre.setEditable(false);

        jLabel7.setText("Apellido");

        jtfMostrarApellido.setEditable(false);

        jLabel8.setText("Ingrese nro de DNI:");

        jLabel12.setText("ID:");

        jtfMostrarID.setEditable(false);

        jLabel11.setText("Seleccione Nro de Asiento");

        jcAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAsientosActionPerformed(evt);
            }
        });

        jLabel9.setText("Colectivo");

        jcColectivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcColectivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIngresoLayout = new javax.swing.GroupLayout(jPanelIngreso);
        jPanelIngreso.setLayout(jPanelIngresoLayout);
        jPanelIngresoLayout.setHorizontalGroup(
            jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresoLayout.createSequentialGroup()
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPrecio)
                    .addComponent(jdFechaViaje, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresoLayout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresoLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jcColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelIngresoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(13, 13, 13)
                        .addComponent(jcAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelIngresoLayout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelIngresoLayout.createSequentialGroup()
                            .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanelIngresoLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtDniPasajero))
                                .addGroup(jPanelIngresoLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfMostrarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelIngresoLayout.createSequentialGroup()
                                    .addComponent(jtfMostrarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfMostrarID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jbBuscarPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresoLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addGap(158, 158, 158)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelIngresoLayout.setVerticalGroup(
            jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdFechaViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelIngresoLayout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbBuscarPasajero)
                            .addComponent(jtDniPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMostrarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jtfMostrarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMostrarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5))
                    .addGap(94, 94, 94)))
        );

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setText("Venta de Pasajes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jCRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanelIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCRutasActionPerformed
        
    borrarFilas();
    cargarHorarios();
    jTHorarios.setEnabled(true);
    }//GEN-LAST:event_jCRutasActionPerformed

    private void jcColectivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcColectivosActionPerformed
        
        
        
//        Colectivo coleSeleccionado = (Colectivo) jcColectivos.getSelectedItem();
//        
//        int capacidad = coleSeleccionado.getCapacidad();
//        
//        jtfPasajesDisponibles.setText(""+capacidad);
        
    }//GEN-LAST:event_jcColectivosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        

        int filaSelecionada = jTHorarios.getSelectedRow();
       
        if (filaSelecionada!=-1){
            
        Colectivo coleSeleccionado = (Colectivo) jcColectivos.getSelectedItem();
        int index = jcColectivos.getSelectedIndex();

        Ruta rutaSeleccionada = (Ruta) jCRutas.getSelectedItem();

        Object valorCelda = jTHorarios.getValueAt(filaSelecionada, 0);
        String horaSeleccionada = valorCelda.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(horaSeleccionada, formatter);
        
        String dni = jtDniPasajero.getText();
        Pasajero pasajeroSeleccionado = pasData.buscarPasajeroPorDNI(Integer.parseInt(dni));
        
        int nroAsiento = (int) jcAsientos.getSelectedItem();
        
        java.util.Date sFecha = jdFechaViaje.getDate();
        LocalDate fecha = sFecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        Double precio = Double.parseDouble(jtfPrecio.getText());
        
        
      Pasaje pasajeNuevo = new Pasaje(pasajeroSeleccionado, coleSeleccionado, rutaSeleccionada, fecha, hora, nroAsiento, precio);
        
      psjData.registrarVenta(pasajeNuevo);
      
      cargarAsientos(coleSeleccionado.getCapacidad());
            
            if (asientos.size()==coleSeleccionado.getCapacidad()-1) {
                
                colData.eliminarColectivo(coleSeleccionado);
                cargarColectivos();
            }
        
        
         
        
        
        }
       
            
            
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrecioActionPerformed

    private void jcAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAsientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcAsientosActionPerformed

    private void jTHorariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTHorariosFocusGained
        
              
    }//GEN-LAST:event_jTHorariosFocusGained

    private void jTHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTHorariosMouseClicked
      
        int filaSelecionada = jTHorarios.getSelectedRow();
        if (filaSelecionada!=-1) {
        activarIngreso(true);
        jButton1.setEnabled(true);
            
        Colectivo coleSeleccionado = (Colectivo) jcColectivos.getSelectedItem();
        Ruta rutaSeleccionada = (Ruta) jCRutas.getSelectedItem();
       
        Object valorCelda = jTHorarios.getValueAt(filaSelecionada, 0);
        String horaSeleccionada = valorCelda.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(horaSeleccionada, formatter);
        
        asientos = psjData.asientosOcupados(coleSeleccionado.getIdColectivo(), rutaSeleccionada.getIdRuta(),hora);
        
        
        
        cargarAsientos(coleSeleccionado.getCapacidad());  
        
        
        }
        
    }//GEN-LAST:event_jTHorariosMouseClicked

    private void jbBuscarPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarPasajeroActionPerformed
      
        Pasajero pasajero = pasData.buscarPasajeroPorDNI(Integer.parseInt(jtDniPasajero.getText()));
        
        jtfMostrarNombre.setText(pasajero.getNombre());
        jtfMostrarApellido.setText(pasajero.getApellido());
        jtfMostrarID.setText(pasajero.getIdPasajero()+"");
    }//GEN-LAST:event_jbBuscarPasajeroActionPerformed
    
    private void cargarAsientos(int capacidad) {
        jcAsientos.removeAllItems();
        
        for (int i = 1; i <= capacidad; i++) {
            if (!asientos.contains(i)) {
                jcAsientos.addItem(i);
            }

        }

    }

    private void cargarRutas() {

        for (Ruta item : listaRutas) {
            jCRutas.addItem(item);
        }

    }

    private void cargarHorarios() {

        Ruta rtaSelec = (Ruta) jCRutas.getSelectedItem();

        listaHorarios = horData.obtenerHorariosActivos(rtaSelec.getIdRuta());

        for (Horario hora : listaHorarios) {
            modelo.addRow(new Object[]{hora.getHoraSalida(), hora.getHoraLlegada()});
        }

    }

    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Horario_Salida");
        filaCabecera.add("Horario_Llegada");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTHorarios.setModel(modelo);
    }

    private void borrarFilas() {
        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    private void cargarColectivos() {
        
        jcColectivos.removeAllItems();
        
        for (Colectivo item : listaColectivos) {
            if (item.isEstado() == true) {
                jcColectivos.addItem(item);
            }

        }
    }

    
     
    private void activarIngreso(boolean sino){
        
        for (Component component : jPanelIngreso.getComponents()) {
            component.setEnabled(sino); 
            
        jButton1.setEnabled(sino);
        jTHorarios.setEnabled(sino);
        
}
        
    }
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<Ruta> jCRutas;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelIngreso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTHorarios;
    private javax.swing.JButton jbBuscarPasajero;
    private javax.swing.JComboBox<Integer> jcAsientos;
    private javax.swing.JComboBox<Colectivo> jcColectivos;
    private com.toedter.calendar.JDateChooser jdFechaViaje;
    private javax.swing.JTextField jtDniPasajero;
    private javax.swing.JTextField jtfMostrarApellido;
    private javax.swing.JTextField jtfMostrarID;
    private javax.swing.JTextField jtfMostrarNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}
