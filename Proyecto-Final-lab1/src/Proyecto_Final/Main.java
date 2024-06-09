package Proyecto_Final;

import AccesoADatos.ColectivoData;
//import AccesoADatos.HorarioData_Nico;
import Entidades.Colectivo;
//import Entidades.Horario;
//import Entidades.Ruta;
//import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
//        Ruta ruta1 = new Ruta(1, "San Luis", "La Punta", LocalTime.of(1, 0), true);
//        HorarioData_Nico horariodt = new HorarioData_Nico();
//        Horario horario1 = new Horario(1, ruta1, LocalTime.of(10, 30), LocalTime.of(11, 30), true);
//        horariodt.agregarHorario(horario1);
//        horariodt.obtenerHorarios(1);

        //Ingresar Colectivo Guillermo
        ColectivoData cole = new ColectivoData();

        Colectivo cole1 = new Colectivo("RB 111 AB", "Scania-SABB", "114", 40, true);
        Colectivo cole2 = new Colectivo("RW 222 WX", "Mercedes-Benz", "1114", 45, true);
        Colectivo cole3 = new Colectivo("RK 333 KJ", "Fiat", "560", 35, true);
        Colectivo cole4 = new Colectivo("RD 444 SD", "Volvo", "580", 50, true);
        Colectivo cole5 = new Colectivo("RB 555 AB", "Scania-SABB", "114", 40, true);
        Colectivo cole6 = new Colectivo("RW 666 WX", "Mercedes-Benz", "1114", 45, true);
        Colectivo cole7 = new Colectivo("RK 777 KJ", "Fiat", "560", 35, true);
        Colectivo cole8 = new Colectivo("RD 888 SD", "Volvo", "580", 50, true);
        cole.guardarColectivo(cole1);
        cole.guardarColectivo(cole2);
        cole.guardarColectivo(cole3);
        cole.guardarColectivo(cole4);
        cole.guardarColectivo(cole5);
        cole.guardarColectivo(cole6);
        cole.guardarColectivo(cole7);
        cole.guardarColectivo(cole8);

        System.out.println("Listamos los Colectivos ingresados");
        System.out.println("-------------------------------------------------------------------------------");
        //Listar Colectivos Guillermo
        for (Colectivo colectivo : cole.listarColectivos()) {

            System.out.println(colectivo.toString());

        }
        System.out.println("###############################################################################");
        System.out.println("Modificamo el Colectivo RD 888 SD a Marca de Volvo a --> Iveco_Daily etc.");
        System.out.println("-------------------------------------------------------------------------------");
        //Modificar Colectivo Guillermo
        Colectivo cole10 = new Colectivo("RD 888 SD", "Iveco_Daily", "740", 25, true);
        cole.modificarColectivo(cole10);

        System.out.println("##############################################################################");

        System.out.println("Eliminamos el Colectivo RK 777 KJ a Estado --> 0 ");
        System.out.println("-------------------------------------------------------------------------------");
//        Eliminar Colectivo Guillermo
        Colectivo cole11 = new Colectivo("RK 777 KJ", "Iveco_Daily", "740", 25, true);
        cole.eliminarColectivo(cole11);
        System.out.println("###############################################################################");
        System.out.println("Buscamos por matricula el Colectivo RB 555 AB ");
        System.out.println("-------------------------------------------------------------------------------");
        //Buscar Colectivo por Matricula Guillermo
        Colectivo colectivoEncontrado = cole.buscarColectivoMatricula("RB 555 AB");
        System.out.println(colectivoEncontrado.toString());
        System.out.println("###############################################################################");
        System.out.println("Buscamos por Marca el Colectivo Fiat ");
        System.out.println("-------------------------------------------------------------------------------");
        //Buscar Colectivo por Marca Guillermo        
        Colectivo colectivoEncontradoM = cole.buscarColectivoMarca("Fiat");
        System.out.println(colectivoEncontradoM.toString());
        System.out.println("###############################################################################");
        System.out.println("Listamos todos los colectivos ");
        System.out.println("-------------------------------------------------------------------------------");
        //Listar Colectivos Guillermo
        for (Colectivo colectivo : cole.listarColectivos()) {

            System.out.println(colectivo.toString());

        }

    }

}
