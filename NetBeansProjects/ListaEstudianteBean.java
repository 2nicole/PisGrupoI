/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mariu
 */
@Named(value = "listaEstudianteBean")
@RequestScoped
public class ListaEstudianteBean {

    
    private EstudianteBean estudiante = new EstudianteBean();
    private static ArrayList<EstudianteBean> lstEstudiante = new ArrayList();

    public ListaEstudianteBean() {
        
    }

    public EstudianteBean getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteBean estudiante) {
        this.estudiante = estudiante;
    }

    public  ArrayList<EstudianteBean> getLstEstudiante() {
        return lstEstudiante;
    }

    public static void setLstEstudiante(ArrayList<EstudianteBean> lstEstudiante) {
        ListaEstudianteBean.lstEstudiante = lstEstudiante;
    }

    public void agregarEstudiante() {
        ListaEstudianteBean.lstEstudiante.add(this.estudiante);
    }
    public void eliminarEstudiante(EstudianteBean est) {
        ListaEstudianteBean.lstEstudiante.remove(est);
        
    }
    
}
