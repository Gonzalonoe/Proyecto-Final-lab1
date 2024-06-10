package AccesoADatos;

import Entidades.Colectivo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class ColectivoData {

    private Connection con = null;

    public ColectivoData() {

        con = (Connection) Conexion.getConnection();
    }

    public void guardarColectivo(Colectivo colectivo) {

        String sql = "INSERT INTO colectivos(Matricula,Marca,Modelo,Capacidad, Estado)"
                + " VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setBoolean(5, true);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                colectivo.setIdColectivo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Colectivo ingresado con exito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivo");
        }

    }

    public void modificarColectivo(Colectivo colectivo) {
        String sql = "UPDATE colectivos SET Marca=?,Modelo=?,Capacidad=?,Estado=? WHERE Matricula=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, colectivo.getMarca());
            ps.setString(2, colectivo.getModelo());
            ps.setInt(3, colectivo.getCapacidad());
            ps.setBoolean(4, colectivo.isEstado());
            ps.setString(5, colectivo.getMatricula());

            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Colectivo modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivo");
        }
    }

    public void eliminarColectivo(Colectivo colectivo) {
        String sql = "UPDATE colectivos SET Estado=? WHERE Matricula=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2, colectivo.getMatricula());
            

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                JOptionPane.showInternalConfirmDialog(null, "Colectivo Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Colectivo con esa Matricula");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo eliminar el colectivo");
        }
    }

    public Colectivo buscarColectivoMatricula(String mat) {
        String sql = "SELECT * FROM colectivos WHERE Matricula =? AND Estado=1";
        Colectivo colectivo = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setMatricula(mat);
                colectivo.setIdColectivo(rs.getInt("ID_Colectivo"));
                colectivo.setMarca(rs.getString("Marca"));
                colectivo.setModelo(rs.getString("Modelo"));
                colectivo.setCapacidad(rs.getInt("Capacidad"));
                colectivo.setEstado(rs.getBoolean("Estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No hay colectivo con esta matricula");
            }
            ps.close();;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda por Matricula");
        }

        return colectivo;
    }

    public Colectivo buscarColectivoMarca(String mar) {
        String sql = "SELECT * FROM colectivos WHERE Marca =? AND Estado=1";
        Colectivo colectivo = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setMarca(mar);
                colectivo.setIdColectivo(rs.getInt("ID_Colectivo"));
                colectivo.setMatricula(rs.getString("Matricula"));
                colectivo.setModelo(rs.getString("Modelo"));
                colectivo.setCapacidad(rs.getInt("Capacidad"));
                colectivo.setEstado(rs.getBoolean("Estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No hay colectivo con esta matricula");
            }
            ps.close();;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda por Matricula");
        }

        return colectivo;
    }

    public List<Colectivo> listarColectivos() {
        String sql = "SELECT * FROM colectivos WHERE Estado=1";
        ArrayList<Colectivo> colectivos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Colectivo cole = new Colectivo();
                cole.setIdColectivo(rs.getInt("ID_Colectivo"));
                cole.setMatricula(rs.getString("Matricula"));
                cole.setMarca(rs.getString("Marca"));
                cole.setModelo(rs.getString("Modelo"));
                cole.setCapacidad(rs.getInt("Capacidad"));
                cole.setEstado(rs.getBoolean("Estado"));
                colectivos.add(cole);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivo");
        }
        return colectivos;
    }
    
    public Colectivo obtenerColectivoPorId(int idColectivo){
        
    String sql = "SELECT * FROM colectivos WHERE ID_Colectivo = ?";
    Colectivo colectivo = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idColectivo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            colectivo = new Colectivo();
            colectivo.setIdColectivo(rs.getInt("ID_Colectivo"));
            colectivo.setMatricula(rs.getString("Matricula"));
            colectivo.setMarca(rs.getString("Marca"));
            colectivo.setModelo(rs.getString("Modelo"));
            colectivo.setCapacidad(rs.getInt("Capacidad"));
        }

        rs.close();
        ps.close();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener el colectivo: " + ex.getMessage());
    }

    return colectivo;
    
    };
    
}
