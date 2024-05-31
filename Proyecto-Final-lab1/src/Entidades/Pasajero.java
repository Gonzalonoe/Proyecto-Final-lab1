
package Entidades;

public class Pasajero {
    
    private int idPasajero;
    private String nombre;
    private String apellido;
    private int dni;
    private String correo;
    private int telefono;
    private boolean estado;
    
    public Pasajero(){
    }
    
    public Pasajero(String nombre, String apellido, int dni, String correo, int telefono, boolean estado){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }
    
   public Pasajero(int idPasajero, String nombre, String apellido, int dni, String correo, int telefono, boolean estado){
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdPassajero() {
        return idPasajero;
    }

    public void setIdPassajero(int idPassajero) {
        this.idPasajero = idPassajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre+", "+apellido+","+dni+", "+correo+", "+telefono+", "; //To change body of generated methods, choose Tools | Templates.
    }
}
