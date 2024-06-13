package AccesoADatos;

/**
 *
 * @author Gonzalo
 */
import AccesoADatos.Conexion;
import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class PasajeroData {

    private Connection conexion = null;

    public PasajeroData() {

        conexion = (Connection) Conexion.getConnection();
    }

    public void agregarPasajero(Pasajero pasajero) {

        String sql = "INSERT INTO Pasajeros (nombre, Apellido, DNI, Correo, Telefono, Estado) "
                + " VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setInt(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, true);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                pasajero.setIdPasajero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasajero ingresado con exito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar pasajero");
        }
    }

    public void modificarPasajero(Pasajero pasajero) {
        String sql = "UPDATE Pasajeros SET nombre=?, apellido=?, correo=?, telefono=?, Estado=? WHERE dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getCorreo());
            ps.setString(4, pasajero.getTelefono());
            ps.setBoolean(5, true);
            ps.setInt(6, pasajero.getDni());
            
            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero modificado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar pasajero" + ex.getMessage());
        }
    }

    public void eliminarPasajero(Pasajero pasajero) {
        String sql = "UPDATE Pasajeros SET Estado=? WHERE DNI=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, pasajero.getDni());
            ps.executeUpdate();
            
            int filaseliminadas = ps.executeUpdate();

            if (filaseliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Pasajero eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro pasajero con ese DNI");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo eliminar el pasajero");
        }
    }

    public Pasajero buscarPasajeroPorDNI(int dni) {
        String sql = "SELECT * FROM Pasajeros WHERE DNI = ? AND estado = 1";
        Pasajero pasajero = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setDni(dni);
                pasajero.setIdPasajero(rs.getInt("ID_pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getString("Telefono"));
                pasajero.setEstado(rs.getBoolean("Estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No hay pasajero con ese DNI");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda por DNI");
        }
        return pasajero;

    }
    
   

    public Pasajero buscarPasajeroPorID(int idPasajero) {
        String sql = "SELECT * FROM Pasajeros WHERE id_pasajero=? AND estado = ?";
        Pasajero pasajero = null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            ps.setBoolean(2, true);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setIdPasajero(rs.getInt("ID_pasajero"));
                pasajero.setDni(rs.getInt("DNI"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getString("Telefono"));
                pasajero.setEstado(rs.getBoolean("Estado"));

            } else {
                JOptionPane.showInternalMessageDialog(null, "No hay pasajero con ese ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda por nombre o apellido");
        }
        return pasajero;

    }

    public List<Pasajero> listarPasajeros() {
        String sql = "SELECT ID_Pasajero, nombre, apellido, DNI, correo, telefono FROM Pasajeros";
        ArrayList<Pasajero> pasajeros = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("ID_pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setDni(rs.getInt("DNI"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getString("Telefono"));

                pasajeros.add(pasajero);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los pasajeros" + ex.getMessage());
        }
        return pasajeros;

    }
    
    public void eliminarPasajeroID(int ID_Pasajero){
        
        String sql = "UPDATE Pasajeros SET estado = 0 WHERE ID_Pasajero = ? ";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, ID_Pasajero);
            
           int registro= ps.executeUpdate();
            
            if (registro==1) {
                JOptionPane.showMessageDialog(null, "Pasajero eliminado");
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
}
}

