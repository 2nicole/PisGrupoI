/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mariu
 */
@Named(value = "docentesBean")
@RequestScoped
public class DocentesBean {

    /**
     * Creates a new instance of DocentesBean
     */
    private DocenteBean docente = new DocenteBean();
    private static ArrayList<DocenteBean> lstdocente = new ArrayList();
    
    public DocentesBean() {
    }

    public DocenteBean getDocente() {
        return docente;
    }

    public void setDocente(DocenteBean docente) {
        this.docente = docente;
    }

    public  ArrayList<DocenteBean> getLstdocente() {
        return lstdocente;
    }

    public static void setLstdocente(ArrayList<DocenteBean> lstdocente) {
        DocentesBean.lstdocente = lstdocente;
    }
    
    public void agregarDocente() {
        DocentesBean.lstdocente.add(this.docente);
    }
    
    public void eliminarDocente(DocenteBean doc) {
        DocentesBean.lstdocente.remove(doc);
    }
            
}
