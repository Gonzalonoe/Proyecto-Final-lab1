package AccesoADatos;

import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        String sql = "INSERT INTO Pasajero (nombre, Apellido, DNI, Correo, Telefono)"
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setInt(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setInt(5, pasajero.getTelefono());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Pasajero ingresado correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar pasajero");
        }
    }

    public void modificarPasajero(Pasajero pasajero) {
        String sql = "UPDATE Pasajeros SET nombre=?, Apellido=? Correo=?, Telefono= WHERE DNI=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getCorreo());
            ps.setInt(4, pasajero.getTelefono());
            ps.setInt(5, pasajero.getDni());

            int filamodificada = ps.executeUpdate();

            if (filamodificada > 0) {
                JOptionPane.showMessageDialog(null, "Se modifico el pasajero");
            } else {
                JOptionPane.showMessageDialog(null, "No hay pasajero Ingresado con ese DNI");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar pasajero" + ex.getMessage());
        }
    }

    public void eliminarPasajero(int dni) {
        String sql = "DELETE FROM Pasajeros WHERE DNI=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);

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
        String sql = "SELECT idPasajero, nommbre, apellido, correo, telefono FROM Pasajero WHERE DNI = ?";
        Pasajero pasajero = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setDni(dni);
                pasajero.setIdPasajero(rs.getInt("ID pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getInt("Telefono"));

            } else {
                JOptionPane.showInternalMessageDialog(null, "No hay pasajero con ese DNI");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda por DNI");
        }
        return pasajero;

    }

    public Pasajero buscarporNombreApellido(String nombre, String apellido) {
        String sql = "SELECT idPasajero, nommbre, apellido, dni, correo, telefono FROM Pasajero WHERE nombre LIKE ? OR apellido LIKE ?";
        Pasajero pasajero = null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            ps.setString(2, "%" + apellido + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("ID pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setDni(rs.getInt("DNI"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getInt("Telefono"));

            } else {
                JOptionPane.showInternalMessageDialog(null, "No hay pasajero con ese nombre o apellido");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda por nombre o apellido");
        }
        return pasajero;

    }

    public List<Pasajero> listarPasajeros() {
        String sql = "SELECT idPasajero, nommbre, apellido, DNI, correo, telefono FROM Pasajero";
        ArrayList<Pasajero> pasajeros = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("ID pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setDni(rs.getInt("DNI"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getInt("Telefono"));

                pasajeros.add(pasajero);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los pasajeros" + ex.getMessage());
        }
        return pasajeros;

    }

}
