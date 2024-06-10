package Entidades;

import java.time.LocalTime;

public class Horario {

    private int idHorario;
    private Ruta ruta;
    private LocalTime horasalida;
    private LocalTime horallegada;
    private boolean estado;

    public Horario() {
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalTime getHoraSalida() {
        return horasalida;
    }

    public void setHoraSalida(LocalTime horasalida) {
        this.horasalida = horasalida;
    }

    public LocalTime getHoraLlegada() {
        return horallegada;
    }

    public void setHoraLlegada(LocalTime horallegada) {
        this.horallegada = horallegada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Horario(int idHorario, Ruta ruta, LocalTime horasalida, LocalTime horallegada, boolean estado) {
        this.idHorario = idHorario;
        this.ruta = ruta;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.estado = estado;
    }

    public Horario(Ruta ruta ,LocalTime horasalida, LocalTime horallegada, boolean estado) {
       this.ruta=ruta;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "idHorario=" + idHorario + ", ruta=" + ruta.getIdRuta() + ", horasalida=" + horasalida + ", horallegada=" + horallegada + ", estado=" + estado ;
    }

    
}
