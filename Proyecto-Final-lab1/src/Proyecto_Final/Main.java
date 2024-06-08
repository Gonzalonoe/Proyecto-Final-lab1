package Proyecto_Final;

import AccesoADatos.HorarioData;
import Entidades.Horario;
import Entidades.Rutas;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Rutas ruta1 = new Rutas(1, "San Luis", "La Punta", LocalTime.of(1, 0), true);
        HorarioData horariodt = new HorarioData();
        Horario horario1 = new Horario(1, ruta1, LocalTime.of(10, 30), LocalTime.of(11, 30), true);
        horariodt.agregarHorario(horario1);
        horariodt.obtenerHorarios(1);

    }

}
