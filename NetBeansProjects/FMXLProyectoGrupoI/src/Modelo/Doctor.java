/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.net.URL;

/**
 *
 * @author nicole
 */
public class Doctor {

    
    private String codigo;
    private String Nombres;
     private String Apellidos;
      private String Fecha_de_nacimiento;
       private String Edad;
        private String Sexo;
         private String Estado_civil;
          private String Telefono;
          private String Direccion;
          private String Email;
    
    public Doctor() {
        
    }

    public Doctor(String codigo, String Nombres, String Apellidos, String Fecha_de_nacimiento, String Edad, String Sexo, String Estado_civil, String Telefono, String Direccion, String Email) {
        this.codigo = codigo;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Estado_civil = Estado_civil;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
  
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFecha_de_nacimiento() {
        return Fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(String Fecha_de_nacimiento) {
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEstado_civil() {
        return Estado_civil;
    }

    public void setEstado_civil(String Estado_civil) {
        this.Estado_civil = Estado_civil;
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
