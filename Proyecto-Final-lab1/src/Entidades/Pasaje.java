package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje {

    private int idPasaje;
    private int idPasajero;
    private int idColectivo;
    private int idRuta;
    private LocalDate fechaviaje;
    private LocalTime horaviaje;
    private int asiento;
    private double precio;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, int idPasajero, int idColectivo, int idRuta, LocalDate fechaviaje, LocalTime horaviaje, int asiento, double precio) {
        this.idPasaje = idPasaje;
        this.idPasajero = idPasajero;
        this.idColectivo = idColectivo;
        this.idRuta = idRuta;
        this.fechaviaje = fechaviaje;
        this.horaviaje = horaviaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasaje(int idPasajero, int idColectivo, int idRuta, LocalDate fechaviaje, LocalTime horaviaje, int asiento, double precio) {
        this.idPasajero = idPasajero;
        this.idColectivo = idColectivo;
        this.idRuta = idRuta;
        this.fechaviaje = fechaviaje;
        this.horaviaje = horaviaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdColectivo() {
        return idColectivo;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public LocalDate getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(LocalDate fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public LocalTime getHoraViaje() {
        return horaviaje;
    }

    public void setHoraviaje(LocalTime horaviaje) {
        this.horaviaje = horaviaje;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", idPasajero=" + idPasajero + ", idColectivo=" + idColectivo + ", idRuta=" + idRuta + ", fechaviaje=" + fechaviaje + ", horaviaje=" + horaviaje + ", asiento=" + asiento + ", precio=" + precio + '}';
    }
    
    
}
