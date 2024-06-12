/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Ruta;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RutaData {
   
     private Connection con = null;


    public RutaData() {
        
        con = (Connection) Conexion.getConnection();
    }
    
    public void agregarRuta(Ruta ruta) {
        String sql = "INSERT INTO Rutas (Origen, Destino, Duracion_Estimada,Estado) VALUES (?, ?, ?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            
            Time hora = Time.valueOf(ruta.getDuracionEstimada());
            ps.setTime(3, hora);
            
            ps.setBoolean(4, true);
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            ruta.setIdRuta(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Ruta ingresada con éxito");
        }
        
        ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar la ruta: " + ex.getMessage());
        }
    }
    
    public void modificarRuta(Ruta ruta) {
    String sql = "UPDATE Rutas SET Origen = ?, Destino = ?, Duracion_Estimada = ? WHERE ID_Ruta = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ruta.getOrigen());
        ps.setString(2, ruta.getDestino());
        
        
       Time hora = Time.valueOf(ruta.getDuracionEstimada());
            ps.setTime(3, hora);
        ps.setInt(4, ruta.getIdRuta());

            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Colectivo modificado");
            }
        
        JOptionPane.showMessageDialog(null, "Ruta modificada correctamente");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar la ruta: " + ex.getMessage());
    }
}

public void eliminarRuta(int idRuta) {
    String sql = "UPDATE Rutas SET Estado = ? WHERE ID_Ruta = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBoolean(1, false); 
        ps.setInt(2, idRuta);
        
        ps.executeUpdate();
        ps.close();
        
        JOptionPane.showMessageDialog(null, "Ruta eliminada correctamente");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar la ruta: " + ex.getMessage());
    }
}
    
    public List<Ruta> buscarRutas(String origen , String destino) {
        String sql = "SELECT ID_Ruta, Origen, Destino, Duracion_Estimada FROM Rutas WHERE Origen LIKE ? OR Destino LIKE ?";
        List<Ruta> rutas = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2,  destino);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));
                ruta.setDuracionEstimada(rs.getTime("Duracion_Estimada").toLocalTime());
                
                rutas.add(ruta);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar las rutas: " + ex.getMessage());
        }
        
        return rutas;
    }
    
    public Ruta buscarRutaPorId(int idRuta) {
    String sql = "SELECT ID_Ruta, Origen, Destino, Duracion_Estimada FROM Rutas WHERE ID_Ruta = ?";
    Ruta ruta = null;
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idRuta);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            ruta = new Ruta();
            ruta.setIdRuta(rs.getInt("ID_Ruta"));
            ruta.setOrigen(rs.getString("Origen"));
            ruta.setDestino(rs.getString("Destino"));
            ruta.setDuracionEstimada(rs.getTime("Duracion_Estimada").toLocalTime());
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar la ruta: " + ex.getMessage());
    }
    
    return ruta;
}
   
    public List<Ruta> obtenerRutas() {
        String sql = "SELECT ID_Ruta, Origen, Destino, Duracion_Estimada FROM Rutas";
        ArrayList<Ruta> rutas = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));
                ruta.setDuracionEstimada(rs.getTime("Duracion_Estimada").toLocalTime());
                ruta.setEstado(true);
                rutas.add(ruta);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las rutas: " + ex.getMessage());
        }
        
        return rutas;
    }
}
