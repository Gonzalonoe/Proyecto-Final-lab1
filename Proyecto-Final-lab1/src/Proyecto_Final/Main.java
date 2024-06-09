package Proyecto_Final;

import AccesoADatos.HorarioData_Nico;
import Entidades.Horario;
import Entidades.Ruta;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Ruta ruta1 = new Ruta(1, "San Luis", "La Punta", LocalTime.of(1, 0), true);
        HorarioData_Nico horariodt = new HorarioData_Nico();
        Horario horario1 = new Horario(1, ruta1, LocalTime.of(10, 30), LocalTime.of(11, 30), true);
        horariodt.agregarHorario(horario1);
        horariodt.obtenerHorarios(1);

        
        
        
        
        
        
    }

}
