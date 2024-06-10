/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Horario;
import Entidades.Ruta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.time.LocalTime;

/**
 *
 * @author emanu
 */
public class HorarioData {
    
    private Connection con;
    
    public HorarioData() {
        con = (Connection) Conexion.getConnection();
    }
    
   
    public void agregarHorario(Horario horario) {
        String sql = "INSERT INTO Horarios (ID_Ruta, Hora_Salida, Hora_Llegada, Estado) VALUES (?, ?, ?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, horario.getRuta().getIdRuta());
            
            LocalTime horaATime = LocalTime.of(horario.getHoraSalida().getHour(),horario.getHoraSalida().getMinute());
            Time horaSalidaTime = Time.valueOf(horaATime);
            
            ps.setTime(2, horaSalidaTime);
            
            horaATime = LocalTime.of(horario.getHoraLlegada().getHour(),horario.getHoraLlegada().getMinute());
            Time horaLlegadaTime = Time.valueOf(horaATime);
            
            ps.setTime(3, horaLlegadaTime);
            ps.setBoolean(4, true);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                horario.setIdHorario(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Horario agregado correctamente");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el horario: " + ex.getMessage());
        }
    }
    
    public void modificarHorario(Horario horario) {
    String sql = "UPDATE Horarios SET Hora_Salida = ?, Hora_Llegada = ? WHERE ID_Horario = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        
        LocalTime horaATime = LocalTime.of(horario.getHoraSalida().getHour(), horario.getHoraSalida().getMinute());
        Time horaSalidaTime = Time.valueOf(horaATime);
        ps.setTime(1, horaSalidaTime);
        
        horaATime = LocalTime.of(horario.getHoraLlegada().getHour(), horario.getHoraLlegada().getMinute());
        Time horaLlegadaTime = Time.valueOf(horaATime);
        ps.setTime(2, horaLlegadaTime);
        
        ps.setInt(3, horario.getIdHorario());
        
        ps.executeUpdate();
        ps.close();
        
        JOptionPane.showMessageDialog(null, "Horario modificado correctamente");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar el horario: " + ex.getMessage());
    }
}

    
    public void eliminarHorario(int idHorario) {
    String sql = "UPDATE Horarios SET Estado = ? WHERE ID_Horario = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBoolean(1, false);
        ps.setInt(2, idHorario);
        
        ps.executeUpdate();
        ps.close();
        
        JOptionPane.showMessageDialog(null, "Horario eliminado correctamente");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el horario: " + ex.getMessage());
    }
}
 
    public List<Horario> obtenerHorariosActivos(int idRuta) {
        String sql = "SELECT ID_Horario, Hora_Salida, Hora_Llegada FROM Horarios WHERE ID_Ruta = ? AND estado=1";
        ArrayList<Horario> horarios = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRuta);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("ID_Horario"));
                
                RutaData rutData = new RutaData();
                Ruta rut = rutData.buscarRutaPorId(idRuta);
                
                horario.setRuta(rut);
                
                horario.setHoraSalida(rs.getTime("Hora_Salida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("Hora_Llegada").toLocalTime());
                horario.setEstado(true);
                
                horarios.add(horario);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los horarios: " + ex.getMessage());
        }
        
        return horarios;
    }
    
}
