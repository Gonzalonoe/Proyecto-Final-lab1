package Proyecto_Final;

import AccesoADatos.ColectivoData;
import AccesoADatos.HorarioData;
import AccesoADatos.PasajeroData;
import AccesoADatos.RutaData;
//import AccesoADatos.HorarioData_Nico;
import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasajero;
import Entidades.Ruta;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
//import Entidades.Horario;
//import Entidades.Ruta;
//import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

       // Ingreso Pasajeros
        PasajeroData pas = new PasajeroData();

//        Pasajero pas1 = new Pasajero("Gutavo", "Lagos", 43778990, "guslagos@gmail.com", 29931002, true);
//        Pasajero pas2 = new Pasajero("Jose", "Arias", 1238821, "josearias@gmail.com", 23523121, true);
//        Pasajero pas3 = new Pasajero("Gonzalo", "Gonzaloes", 2329891, "gonzalogonzales@gmail.com", 26642912, true);
//        Pasajero pas4 = new Pasajero("Pedro", "Martinez", 23778990, "pedrom@gmail.com", 11993100, true);
//        Pasajero pas5 = new Pasajero("Rodolfo", "Guzman", 13778990, "rguzman@gmail.com", 38781002, true);
//
//        pas.agregarPasajero(pas1);
//        pas.agregarPasajero(pas2);
//        pas.agregarPasajero(pas3);
//        pas.agregarPasajero(pas4);
//        pas.agregarPasajero(pas5);

        //Listamos Pasajeros
        System.out.println("Lista de pasajeros");
        for (Pasajero pasajero : pas.listarPasajeros()) {

            System.out.println(pasajero.toString());

        }

        //Modificamos Pasajeros
        Pasajero pas6 = new Pasajero(5,"Oscar", "Guzman", 8829300, "rguzman@gmail.com", 38781002, true);
        pas.modificarPasajero(pas6);

        //Eliminar Pasajero
        
        pas.eliminarPasajero(2329891);

        //Buscar Pasajero por DNI
        System.out.println("Pasajero buscado por Dni");
        Pasajero dnipasajero = pas.buscarPasajeroPorDNI(43778990);
        if (dnipasajero!=null) {
           System.out.println(dnipasajero.toString()); 
        }
 
        //Buscar pasajero por nombre o apellido
        System.out.println("Pasajero buscado por nombre");
        Pasajero nombreapellidopasajero = pas.buscarporNombreApellido("Jose", "");
        System.out.println(nombreapellidopasajero.toString());

        //Ingresar Colectivo Guillermo
//        ColectivoData cole = new ColectivoData();
//
//        Colectivo cole1 = new Colectivo("RB 111 AB", "Scania-SABB", "114", 40, true);
//        Colectivo cole2 = new Colectivo("RW 222 WX", "Mercedes-Benz", "1114", 45, true);
//        Colectivo cole3 = new Colectivo("RK 333 KJ", "Fiat", "560", 35, true);
//        Colectivo cole4 = new Colectivo("RD 444 SD", "Volvo", "580", 50, true);
//        Colectivo cole5 = new Colectivo("RB 555 AB", "Scania-SABB", "114", 40, true);
//        Colectivo cole6 = new Colectivo("RW 666 WX", "Mercedes-Benz", "1114", 45, true);
//        Colectivo cole7 = new Colectivo("RK 777 KJ", "Fiat", "560", 35, true);
//        Colectivo cole8 = new Colectivo("RD 888 SD", "Volvo", "580", 50, true);
//        cole.guardarColectivo(cole1);
//        cole.guardarColectivo(cole2);
//        cole.guardarColectivo(cole3);
//        cole.guardarColectivo(cole4);
//        cole.guardarColectivo(cole5);
//        cole.guardarColectivo(cole6);
//        cole.guardarColectivo(cole7);
//        cole.guardarColectivo(cole8);
//
//        System.out.println("Listamos los Colectivos ingresados");
//        System.out.println("-------------------------------------------------------------------------------");
//        //Listar Colectivos Guillermo
//        for (Colectivo colectivo : cole.listarColectivos()) {
//
//            System.out.println(colectivo.toString());
//
//        }
//        System.out.println("###############################################################################");
//        System.out.println("Modificamo el Colectivo RD 888 SD a Marca de Volvo a --> Iveco_Daily etc.");
//        System.out.println("-------------------------------------------------------------------------------");
//        //Modificar Colectivo Guillermo
//        Colectivo cole10 = new Colectivo("RD 888 SD", "Iveco_Daily", "740", 25, true);
//        cole.modificarColectivo(cole10);
//        System.out.println("##############################################################################");
//        System.out.println("Eliminamos el Colectivo RK 777 KJ a Estado --> 0 ");
//        System.out.println("-------------------------------------------------------------------------------");
////        Eliminar Colectivo Guillermo
//        Colectivo cole11 = new Colectivo("RK 777 KJ", "Iveco_Daily", "740", 25, true);
//        cole.eliminarColectivo(cole11);
//        System.out.println("###############################################################################");
//        System.out.println("Buscamos por matricula el Colectivo RB 555 AB ");
//        System.out.println("-------------------------------------------------------------------------------");
//        //Buscar Colectivo por Matricula Guillermo
//        Colectivo colectivoEncontrado = cole.buscarColectivoMatricula("RB 555 AB");
//        System.out.println(colectivoEncontrado.toString());
//        System.out.println("###############################################################################");
//        System.out.println("Buscamos por Marca el Colectivo Fiat ");
//        System.out.println("-------------------------------------------------------------------------------");
//        //Buscar Colectivo por Marca Guillermo        
//        Colectivo colectivoEncontradoM = cole.buscarColectivoMarca("Fiat");
//        System.out.println(colectivoEncontradoM.toString());
//        System.out.println("###############################################################################");
//        System.out.println("Listamos todos los colectivos ");
//        System.out.println("-------------------------------------------------------------------------------");
//        //Listar Colectivos Guillermo
//        for (Colectivo colectivo : cole.listarColectivos()) {
//            System.out.println(colectivo.toString());
//        }
//       
        
        RutaData rutData = new RutaData();
        
//        Ruta ruta1 = new Ruta("San Luis", "La Punta", LocalTime.of(1, 00), true);
//        Ruta ruta2 = new Ruta("La Punta", "San Luis", LocalTime.of(1, 00), true);
//        Ruta ruta3 = new Ruta("Merlo", "San Luis", LocalTime.of(1, 20), true);
//        Ruta ruta4 = new Ruta("La Punta", "Merlo",LocalTime.of(1, 20), true);
//        
//        rutData.agregarRuta(ruta1);
//        rutData.agregarRuta(ruta2);
//        rutData.agregarRuta(ruta3);
//        rutData.agregarRuta(ruta4);
//        
//        Ruta ruta5 = new Ruta(1,"San Luis, Centro", "La Punta", LocalTime.of(1, 0), true);
//        Ruta ruta6 = new Ruta(2,"San Luis", "La Punta, ULP", LocalTime.of(1, 0), true);
//        
//        rutData.modificarRuta(ruta5);
//        rutData.modificarRuta(ruta6);
//        
//        rutData.eliminarRuta(4);
//        
//        
//        List<Ruta> rutasEncontradas = rutData.buscarRutas("San Luis", "");
//        System.out.println("Rutas con mismo Origen");
//        for (Ruta ruta : rutasEncontradas) {
//            System.out.println(ruta.toString());
//        }
//        System.out.println("Buscar ruta por id");
//        Ruta rutaEncontrada = rutData.buscarRutaPorId(2);
//        if (rutaEncontrada!=null) {
//            System.out.println(rutaEncontrada.toString());
//        }
//        
//
//        System.out.println("Mostrar lista de rutas activas");
//        List<Ruta> todasLasRutas = rutData.obtenerRutas();
//        for (Ruta ruta : todasLasRutas) {
//            System.out.println(ruta.toString());
//    }
       
        HorarioData horData= new HorarioData();
    
    
//    Horario horarioRecorrido1A = new Horario(rutData.buscarRutaPorId(1),LocalTime.of(10, 0), LocalTime.of(11, 0), true);
//    Horario horarioRecorrido1B = new Horario(rutData.buscarRutaPorId(1),LocalTime.of(13, 0), LocalTime.of(14, 0), true);
//    Horario horarioRecorrido1C = new Horario(rutData.buscarRutaPorId(1),LocalTime.of(16, 0), LocalTime.of(17, 0), true);
//    Horario horarioRecorrido1D = new Horario(rutData.buscarRutaPorId(1),LocalTime.of(19, 0), LocalTime.of(18, 0), true);
//    horData.agregarHorario(horarioRecorrido1A);
//    horData.agregarHorario(horarioRecorrido1B);
//    horData.agregarHorario(horarioRecorrido1C);
//    horData.agregarHorario(horarioRecorrido1D);
//    horData.modificarHorario(horarioRecorrido1A);
//    
//    
//    horData.eliminarHorario(1);
//    
//    
//    List<Horario> horariosActivos = horData.obtenerHorariosActivos(1);
//    System.out.println("Mostrar lista de rutas activas");
//        
//        for (Horario hora : horariosActivos) {
//            System.out.println(hora.toString());    
//        
//        
//    }
    }
    
    
}
