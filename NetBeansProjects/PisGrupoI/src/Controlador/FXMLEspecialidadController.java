/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Doctor;
import Entidades.Especialidad;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLEspecialidadController implements Initializable {

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtCodEspecialidad;
    
    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnRegresar;
    
    private Especialidad especialidad;
    
     private boolean validarNumero(String nu){
        
        try{
            float num = Float.parseFloat(nu);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
     private boolean Validar(){
         
        String errores = new String();
        Alert alt = new Alert(Alert.AlertType.ERROR);
        
        if(this.txtCodEspecialidad.getText().length() == 0){
            errores += "\nNo ha ingresado el codigo de la especialidad.";
        }else if(!validarNumero(this.txtCodEspecialidad.getText())){
            errores += "\nSe ha ingresado de forma incorrecta el codigo de la especialidad.";
        }

        if(this.txtEspecialidad.getText().length() == 0){
            errores += "\nNo ha ingresado la especialidad.";
        }
        
        if(errores.length() != 0){
            alt.setContentText("Se han encontrado los siguientes problemas: "+errores);
            alt.show();
        }
        
        return true;
    }

    @FXML
    void Guardar(ActionEvent event) {
        if(Validar()){
             
            especialidad = new Especialidad();
            especialidad.setCodigo(Integer.parseInt(this.txtCodEspecialidad.getText()));
            especialidad.setEspDoctor(txtEspecialidad.getText());
            
            Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
            stage.close();
         }
    }

    @FXML
    void Regresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
   
    public TextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public TextField getTxtCodEspecialidad() {
        return txtCodEspecialidad;
    }

    
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
