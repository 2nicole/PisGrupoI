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
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLDoctorController implements Initializable {
    
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private RadioButton rbdMasculino;

    @FXML
    private RadioButton rbdFemenino;
    
    @FXML
    private RadioButton rbdSoltero;

    @FXML
    private RadioButton rbdCasado;

    @FXML
    private TextField txtTelefono;
    
    @FXML
    private TextField txtCodEsp;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private DatePicker dtpFecha;
    
    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnRegresar;
    
    @FXML
    private Button btnBuscarEspecialidad;
    
    private Doctor doctor;
    
    private boolean validarNumero(String nu){
        
        try{
            int num = Integer.parseInt(nu);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    private boolean Validar(){
        String errores = new String();
        
        if(txtCodigo.getText().length() == 0){
            errores += "\nNo ha ingresado el codigo del doctor.";
        }else if(!validarNumero(txtCodigo.getText())){
            errores += "\nSe ha ingresado el codigo del doctor de forma incorrecta.";
        }
        
        if(txtCedula.getText().length() == 0){
            errores += "\nNo ha ingresado una celula.";
        }else if(!validarNumero(txtCedula.getText())){
            errores += "\nSe ha ingresado la celula del doctor de forma incorrecta.";
        }
        
        if(txtNombres.getText().length() == 0){
            errores += "\nNo ha ingresado el nombre del doctor.";
        }
        
        if(txtApellidos.getText().length() == 0){
            errores += "\nNo ha ingresado el apellido del doctor.";
        }
        
        if(dtpFecha.getValue() == null){
            errores += "\nNo ha ingresado la fecha de nacimiento del doctor.";
        }
        
        if(txtEdad.getText().length() == 0){
            errores += "\nNo ha ingresado la edad del doctor.";
        }else if(!validarNumero(txtEdad.getText())){
            errores += "\nSe ha ingresado la edad del doctor de forma incorrecta.";
        }
        
        if(!(rbdFemenino.isSelected() || rbdMasculino.isSelected())){
            errores += "\nNo ha seleccionado el sexo del doctor.";
        }
        
        if(!(rbdSoltero.isSelected() || rbdCasado.isSelected())){
            errores += "\nNo ha seleccionado el estado civil del doctor.";
        }
        
        if(this.txtCodEsp.getText().length() == 0){
            errores += "\nNo ha seleccionado el codigo de la especialidad";
        }
        
        if(txtEspecialidad.getText().length() == 0){
            errores += "\nNo ha ingresado la especialidad del doctor.";
        }
        
        if(txtTelefono.getText().length() == 0){
            errores += "\nNo ha ingresado un numero de telefono.";
        }else if(!validarNumero(txtTelefono.getText())){
            errores += "\nSe ha ingresado el numero de telefono del doctor de forma incorrecta.";
        }
        
        if(txtDireccion.getText().length() == 0){
            errores += "\nNo ha ingresado una dirección para el doctor.";
        }
        
        if(txtEmail.getText().length() == 0){
            errores += "\nNo ha ingresado el email del doctor.";
        }
        
        if(errores.length() != 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Se han encontrado los siguientes errores: "+errores);
            alert.show();
            return false;
        }
        
        return true;
    }
    
    @FXML
    void Guardar(ActionEvent event) {
        if(Validar()){
            
            doctor = new Doctor();
            String sexo = new String();
            String estado = new String();

            if(this.rbdFemenino.isSelected()){
                sexo = rbdFemenino.getText();
            }else{
                sexo = rbdMasculino.getText();
            }

            if(this.rbdCasado.isSelected()){
                estado = this.rbdCasado.getText();
            }else{
                estado = this.rbdSoltero.getText();
            }

            doctor.setCodigo(Integer.parseInt(txtCodigo.getText()));
            doctor.setCedula(txtCedula.getText());
            doctor.setNombre(txtNombres.getText());
            doctor.setApellido(txtApellidos.getText());
            doctor.setFecha(dtpFecha.getValue());
            doctor.setEdad(Integer.parseInt(txtEdad.getText()));
            doctor.setSexo(sexo.toUpperCase());
            doctor.setEstado(estado.toUpperCase());
            doctor.setTelefono(txtTelefono.getText());
            doctor.setDireccion(txtDireccion.getText());
            doctor.setEmail(txtEmail.getText());
            doctor.setCodEsp(Integer.parseInt(txtCodEsp.getText()));
            doctor.setEspecialidad(txtEspecialidad.getText().toUpperCase());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Doctor ingresado correctamente");
            alert.showAndWait();
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
            
        }
    }

    @FXML
    void buscarEspecialidad(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLRegistroEspecialidad.fxml"));
            Parent root = loader.load();
            FXMLRegistroEspecialidadController controlador = loader.getController();
            controlador.consultar();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Especialidad esp = controlador.getEspSeleccionada();
            if(esp != null){
                this.txtCodEsp.setText(String.valueOf(esp.getCodigo()));
                this.txtEspecialidad.setText(esp.getEspDoctor());
            }else{
                Alert alt = new Alert(Alert.AlertType.INFORMATION);
                alt.setContentText("No selecciono ninguna especialidad.");
                alt.show();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistroEspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void Regresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public Doctor getDoctor() {
        return doctor;
    }

    public TextField getTxtCodigo() {
        return txtCodigo;
    }

    public TextField getTxtCedula() {
        return txtCedula;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public TextField getTxtApellidos() {
        return txtApellidos;
    }

    public TextField getTxtEdad() {
        return txtEdad;
    }

    public RadioButton getRbdMasculino() {
        return rbdMasculino;
    }

    public RadioButton getRbdFemenino() {
        return rbdFemenino;
    }

    public RadioButton getRbdSoltero() {
        return rbdSoltero;
    }

    public RadioButton getRbdCasado() {
        return rbdCasado;
    }

    public TextField getTxtTelefono() {
        return txtTelefono;
    }

    public TextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public TextField getTxtDireccion() {
        return txtDireccion;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public DatePicker getDtpFecha() {
        return dtpFecha;
    }

    public TextField getTxtCodEsp() {
        return txtCodEsp;
    }    
    
}
