package Entidades;

import java.time.LocalTime;

public class Rutas {

    private int idRutas;
    private String origen;
    private String destino;
    private LocalTime duracionestimada;
    private boolean estado;

    public Rutas() {
    }

    public Rutas(int id_Rutas, String origen, String destino, LocalTime duracionestimada, boolean estado) {
        this.idRutas = id_Rutas;
        this.origen = origen;
        this.destino = destino;
        this.duracionestimada = duracionestimada;
        this.estado = estado;
    }

    public Rutas(String origen, String destino, LocalTime duracionestimada, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracionestimada = duracionestimada;
        this.estado = estado;
    }

    public int getIdRutas() {
        return idRutas;
    }

    public void setIdRutas(int idRutas) {
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

    public LocalTime getDuracionestimada() {
        return duracionestimada;
    }

    public void setDuracionestimada(LocalTime duracionestimada) {
        this.duracionestimada = duracionestimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Rutas{" + "id_Rutas=" + idRutas + ", origen=" + origen + ", destino=" + destino + ", duracionestimada=" + duracionestimada + ", estado=" + estado + '}';
    }
}
