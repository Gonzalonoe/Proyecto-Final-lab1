package AccesoADatos;

import Entidades.Horario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalTime;

public class HorarioData {

    private Connection con;

    public HorarioData() {
        con = Conexion.getConnection();
    }

    public void agregarHorario(Horario horario) {
        String sql = "INSERT INTO `horarios`(`ID_Horario`, `ID_Ruta`, `Hora_Salida`, `Hora_Llegada`, `Estado`)"
                + " VALUES ('?','?','?','?','?')";

        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, horario.getRuta().getIdRutas());

            LocalTime horaTime = LocalTime.of(horario.getHorasalida().getHour(), horario.getHorasalida().getMinute());
            Time horaSalidaTime = Time.valueOf(horaTime);

            ps.setTime(2, horaSalidaTime);

            horaTime = LocalTime.of(horario.getHorallegada().getHour(), horario.getHorallegada().getMinute());
            Time horaLlegadaTime = Time.valueOf(horaTime);

            ps.setTime(3, horaLlegadaTime);
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Horario agregado correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el Horario " + ex.getMessage());
        }

    }

    public List<Horario> obtenerHorarios(int idRuta) {
        String sql = "SELECT `ID_Horario`, `ID_Ruta`, `Hora_Salida`, `Hora_Llegada`, `Estado` FROM `horarios` "
                + "WHERE ID_Ruta = ?";

        ArrayList<Horario> horarios = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRuta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("ID_Horario"));
                horario.getRuta().setIdRutas(rs.getInt("ID_Rutas"));
                horario.setHorasalida(rs.getTime("Hora_Salida").toLocalTime());
                horario.setHorallegada(rs.getTime("Hora_Llegada").toLocalTime());
                horario.setEstado(rs.getBoolean("Estado"));
                horarios.add(horario);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Horarios " + ex.getMessage());
        }
        return horarios;
    }

}
