package Entidades;

import java.time.LocalTime;

public class Horario {

    private int idHorario;
    private Rutas ruta;
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

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
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

    public Horario(int idHorario, Rutas ruta, LocalTime horasalida, LocalTime horallegada, boolean estado) {
        this.idHorario = idHorario;
        this.ruta = ruta;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return horasalida + ", " + horallegada + ","; //To change body of generated methods, choose Tools | Templates.
    }
}
