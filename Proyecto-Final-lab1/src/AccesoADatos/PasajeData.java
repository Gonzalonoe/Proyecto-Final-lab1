/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;


import Entidades.Colectivo;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author emanu
 */
public class PasajeData {
    
    
    
    private Connection con;
    
    public PasajeData() {
        con = (Connection) Conexion.getConnection();
    }

    public void registrarVenta(Pasaje pasaje) {
        String sql = "INSERT INTO Pasajes (ID_Pasajero, ID_Colectivo, ID_Ruta, Fecha_Viaje, Hora_Viaje, Asiento, Precio) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getColectivo().getIdColectivo());
            ps.setInt(3, pasaje.getRuta().getIdRuta());
            
            LocalDate localDate = pasaje.getFechaViaje();
            Date fecha = java.sql.Date.valueOf(localDate);
            ps.setDate(4, fecha);
            
            LocalTime localTime =pasaje.getHoraViaje();
            Time hora = Time.valueOf(localTime);
            ps.setTime(5,hora);
            
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            
          ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            pasaje.setIdPasaje(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Venta de pasaje registrada correctamente");
        }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar la venta de pasaje: " + ex.getMessage());
        }
        
     
    }
    
    public void modificarPasaje(Pasaje pasaje) {
    String sql = "UPDATE Pasajes SET ID_Pasajero = ?, ID_Colectivo = ?, ID_Ruta = ?, Fecha_Viaje = ?, Hora_Viaje = ?, Asiento = ?, Precio = ? WHERE ID_Pasaje = ?";
        
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, pasaje.getPasajero().getIdPasajero());
        ps.setInt(2, pasaje.getColectivo().getIdColectivo());
        ps.setInt(3, pasaje.getRuta().getIdRuta());
        
        LocalDate localDate = pasaje.getFechaViaje();
        Date fecha = java.sql.Date.valueOf(localDate);
        ps.setDate(4, fecha);
        
        LocalTime localTime = pasaje.getHoraViaje();
        Time hora = Time.valueOf(localTime);
        ps.setTime(5, hora);
        
        ps.setInt(6, pasaje.getAsiento());
        ps.setDouble(7, pasaje.getPrecio());
        
        ps.setInt(8, pasaje.getIdPasaje());
        
        ps.executeUpdate();
        ps.close();
        
        JOptionPane.showMessageDialog(null, "Pasaje modificado correctamente");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar el pasaje: " + ex.getMessage());
    }
}
    public void eliminarPasaje (Pasaje pasaje){
      
        String sql = "DELETE FROM Pasajeros WHERE ID_Pasaje=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pasaje.getIdPasaje());
            
            int filasEliminadas = ps.executeUpdate();
            
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Pasajero eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún pasajero con el DNI especificado");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pasajero: " + ex.getMessage());
        }
        
    }
    
    public List<Pasaje> mostrarPasajesVendidos() {
        
    List<Pasaje> pasajes = new ArrayList<>();
    String sql = "SELECT * FROM Pasajes";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int idPasaje = rs.getInt("ID_Pasaje");
            
            ColectivoData colData =new ColectivoData();
            Colectivo cole = colData.obtenerColectivoPorId(rs.getInt("ID_Colectivo"));
            RutaData rutData = new RutaData();
            Ruta rut = rutData.buscarRutaPorId(rs.getInt("ID_Ruta"));
            PasajeroData pasData = new PasajeroData();
            Pasajero pas = pasData.buscarPasajeroPorDNI(rs.getInt("Dni"));
            
            LocalDate fechaViaje = rs.getDate("Fecha_Viaje").toLocalDate();
            LocalTime horaViaje = rs.getTime("Hora_Viaje").toLocalTime();
            int asiento = rs.getInt("Asiento");
            double precio = rs.getDouble("Precio");

            Pasaje pasaje = new Pasaje(idPasaje, pas, cole, rut, fechaViaje, horaViaje, asiento, precio);
            pasajes.add(pasaje);
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar los pasajes vendidos: " + ex.getMessage());
    }
    
    return pasajes;
}
    
    
    public List<Integer> asientosOcupados(int idColectivo, int idRuta, LocalTime horario){

        String sql = "SELECT asiento FROM Pasajes WHERE ID_Colectivo=? AND ID_Ruta=? AND Hora_Viaje=?";
        
        ArrayList<Integer> listaOcupados = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idColectivo);
            ps.setInt(2, idRuta);
        
            Time hora = Time.valueOf(horario);
            ps.setTime(3, hora);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setAsiento(rs.getInt("Asiento"));
                
                listaOcupados.add(pasaje.getAsiento());
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar asientos ocupados: " + ex.getMessage());
        }
        
        
        return listaOcupados; 
    }
    
}
