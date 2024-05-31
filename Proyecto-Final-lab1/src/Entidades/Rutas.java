package Entidades;

import java.time.LocalTime;

public class Rutas {

    private int id_Rutas;
    private String origen;
    private String destino;
    private LocalTime duracion_estimada;
    private boolean estado;

    public Rutas() {
    }

    public Rutas(int id_Rutas, String origen, String destino, LocalTime duracion_estimada, boolean estado) {
        this.id_Rutas = id_Rutas;
        this.origen = origen;
        this.destino = destino;
        this.duracion_estimada = duracion_estimada;
        this.estado = estado;
    }

    public Rutas(String origen, String destino, LocalTime duracion_estimada, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracion_estimada = duracion_estimada;
        this.estado = estado;
    }

    public int getId_Rutas() {
        return id_Rutas;
    }

    public void setId_Rutas(int id_Rutas) {
        this.id_Rutas = id_Rutas;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getDuracion_estimada() {
        return duracion_estimada;
    }

    public void setDuracion_estimada(LocalTime duracion_estimada) {
        this.duracion_estimada = duracion_estimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Rutas{" + "id_Rutas=" + id_Rutas + ", origen=" + origen + ", destino=" + destino + ", duracion_estimada=" + duracion_estimada + ", estado=" + estado + '}';
    }
}
