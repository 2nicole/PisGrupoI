
package Entidades;

import java.time.LocalDate;


public class Doctor {
    private int codigo;
    private String cedula;
    private String Nombre;
    private String Apellido;
    private LocalDate Fecha;
    private int Edad;
    private int codEsp;
    private String Especialidad;
    private String sexo;
    private String Estado;
    private String Telefono;
    private String Direccion;
    private String Email;

    public Doctor() {
    }

    public Doctor(int codigo, String cedula, String Nombre, String Apellido, LocalDate Fecha, int Edad, int codEsp, String Especialidad, String sexo, String Estado, String Telefono, String Direccion, String Email) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Fecha = Fecha;
        this.Edad = Edad;
        this.codEsp = codEsp;
        this.Especialidad = Especialidad;
        this.sexo = sexo;
        this.Estado = Estado;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getCodEsp() {
        return codEsp;
    }

    public void setCodEsp(int codEsp) {
        this.codEsp = codEsp;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
}
