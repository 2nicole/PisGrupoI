
package Entidades;

import java.time.LocalDate;

public class CitaMedica {
    private int codigo;
    private int paciente;
    private String nombrePaciente;
    private int doctor;
    private String nombreDoctor;
    private String espDoctor;
    private LocalDate fechaCita;
    private String hora;
    private String nota;
    private String estadoCita;
    private String estadoPago;
    private float costo;

    public CitaMedica() {
    }

    public CitaMedica(int codigo, int paciente, String nombrePaciente, int doctor, String nombreDoctor, String espDoctor, LocalDate fechaCita, String hora, String nota, String estadoCita, String estadoPago, float costo) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.nombrePaciente = nombrePaciente;
        this.doctor = doctor;
        this.nombreDoctor = nombreDoctor;
        this.espDoctor = espDoctor;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.nota = nota;
        this.estadoCita = estadoCita;
        this.estadoPago = estadoPago;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getEspDoctor() {
        return espDoctor;
    }

    public void setEspDoctor(String espDoctor) {
        this.espDoctor = espDoctor;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    
    
    
}
