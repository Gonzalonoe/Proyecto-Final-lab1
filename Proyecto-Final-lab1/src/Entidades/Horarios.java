
package Entidades;

import java.time.LocalTime;

public class Horarios {
    
    private int idHorario;
    private int idRuta;
    private LocalTime horasalida;
    private LocalTime horallegada;
    private boolean estado;
    
    public Horarios(){
    }
    
    public Horarios(LocalTime horasalida, LocalTime horallegada, boolean estado){
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.estado = estado;
    }
    
   public Horarios(int idHorario, int idRuta, LocalTime horasalida, LocalTime horallegada, boolean estado){
        this.idHorario = idHorario;
        this.idRuta = idRuta;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.estado = estado;
    }
   
   public Horarios(int idRuta, LocalTime horasalida, LocalTime horallegada, boolean estado){
        this.idRuta = idRuta;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.estado = estado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public LocalTime getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(LocalTime horasalida) {
        this.horasalida = horasalida;
    }

    public LocalTime getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(LocalTime horallegada) {
        this.horallegada = horallegada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    
    @Override
    public String toString() {
        return horasalida+", "+horallegada+","; //To change body of generated methods, choose Tools | Templates.
    }
}
