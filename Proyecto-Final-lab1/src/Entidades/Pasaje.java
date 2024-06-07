package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje {

    private int idPasaje;
    private Pasajero pasajero;
    private Colectivo colectivo;
    private Rutas ruta;
    private LocalDate fechaviaje;
    private LocalTime horaviaje;
    private int asiento;
    private double precio;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, Pasajero pasajero, Colectivo colectivo, Rutas ruta, LocalDate fechaviaje, LocalTime horaviaje, int asiento, double precio) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
        this.fechaviaje = fechaviaje;
        this.horaviaje = horaviaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasaje(Pasajero pasajero, Colectivo colectivo, Rutas ruta, LocalDate fechaviaje, LocalTime horaviaje, int asiento, double precio) {
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
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

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(LocalDate fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public LocalTime getHoraviaje() {
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

}
