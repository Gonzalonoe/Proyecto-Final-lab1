package Entidades;

import java.time.LocalTime;

public class Ruta {

    private int idRutas;
    private String origen;
    private String destino;
    private LocalTime duracionEstimada;
    private boolean estado;

    public Ruta() {
    }

    public Ruta(int id_Rutas, String origen, String destino, LocalTime duracionestimada, boolean estado) {
        this.idRutas = id_Rutas;
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionestimada;
        this.estado = estado;
    }

    public Ruta(String origen, String destino, LocalTime duracionestimada, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionestimada;
        this.estado = estado;
    }

    public int getIdRuta() {
        return idRutas;
    }

    public void setIdRuta(int idRutas) {
        this.idRutas = idRutas;
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

    public LocalTime getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(LocalTime duracionestimada) {
        this.duracionEstimada = duracionestimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  origen + " / " + destino + " Duracion Estimada: "+ duracionEstimada;
    }
}
