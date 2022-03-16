/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Especialidad {
    
    private int codigo;
    private String espDoctor;

    public Especialidad() {
    }

    public Especialidad(int codigo, String espDoctor) {
        this.codigo = codigo;
        this.espDoctor = espDoctor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEspDoctor() {
        return espDoctor;
    }

    public void setEspDoctor(String espDoctor) {
        this.espDoctor = espDoctor;
    }

    
}
