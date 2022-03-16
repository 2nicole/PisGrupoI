/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.Date;

/**
 *
 * @author STDIEGO
 */
public class LoginBean {
    private String nombre;
    private String password;
    private Date fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String acceder(){
        if (this.nombre.equals("Admin")) {
        
        return "Ingreso admitido";}
        
        else {
                return "Ingreso denegado";}
    }
    
                
    
}
