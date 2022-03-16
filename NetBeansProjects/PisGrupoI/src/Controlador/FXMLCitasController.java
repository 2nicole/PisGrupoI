/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.CitaMedica;
import Entidades.Paciente;
import Entidades.Doctor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class FXMLCitasController implements Initializable {
    @FXML
    private TextField txfCodCita;
    @FXML
    private DatePicker dtpFechaCita;
    @FXML
    private TextField txfNomPaciente;
    @FXML
    private TextField txfNomDoctor;
    @FXML
    private TextField txfEspDoctor;
    @FXML
    private TextArea txaNota;
    @FXML
    private TextField txfHora;
    @FXML
    private TextField txfCosto;
    @FXML
    private TextField txfCodPaciente;
    @FXML
    private TextField txfCodDoctor;
    @FXML
    private Button btnBusDoctor;
    @FXML
    private Button btnBusPaciente;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnRegresar;
    @FXML
    private ComboBox cboEstado;
    @FXML
    private ComboBox cboEstadoPago;
    
    private CitaMedica citaMedica;
    
    private ObservableList<String> addEstadoPago(){
        ObservableList<String> datos = FXCollections.observableArrayList("PENDIENTE","CANCELADO");
        
        return datos;
    }
    private ObservableList<String> addEstado(){
        ObservableList<String> datos = FXCollections.observableArrayList("PENDIENTE","APLICADA");
        
        return datos;
    }
    
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
        
        if(this.txfCodCita.getText().length() == 0){
            errores += "\nNo ha ingresado el codigo de la cita.";
        }else if(!validarNumero(this.txfCodCita.getText())){
            errores += "\nSe ha ingresado de forma incorrecta el codigo de la cita.";
        }
        
        if(this.txfCodPaciente.getText().length() == 0){
            errores += "\nNo ha seleccionado un paciente.";
        }
        
        if(this.txfCodDoctor.getText().length() == 0){
            errores += "\nNo ha seleccionado un doctor.";
        }
        
        if(this.dtpFechaCita.getValue() == null){
            errores += "\nNo ha ingresado la fecha de la cita.";
        }
        
        if(this.txfHora.getText() == null){
            errores += "\nNo ha ingresado la hora de la cita.";
        }
        
        if(this.cboEstado.getSelectionModel().getSelectedIndex() == -1){
            errores += "\nNo ha ingresado el estado de la cita.";
        }
        
        if(this.cboEstadoPago.getSelectionModel().getSelectedIndex() == -1){
            errores += "\nNo ha ingresado el estado de pago.";
        }
        
        if(this.txfCosto.getText().length() == 0){
            errores += "\nNo ha ingresado el costo de la cita.";
        }else if(!validarNumero(this.txfCosto.getText())){
            errores += "\nSe ha ingresado el costo de la cita de forma incorrecta.";
        }
        
        if(errores.length() != 0){
            alt.setContentText("Se han encontrado los siguientes errores: "+errores);
            alt.show();
            return false;
        }
        
        return true;
    }
    
    @FXML
    void Guardar(ActionEvent event) {
        if(Validar()){
            citaMedica = new CitaMedica();
            citaMedica.setCodigo(Integer.parseInt(this.txfCodCita.getText()));
            citaMedica.setPaciente(Integer.parseInt(txfCodPaciente.getText()));
            citaMedica.setNombrePaciente(txfNomPaciente.getText());
            citaMedica.setDoctor(Integer.parseInt(txfCodDoctor.getText()));
            citaMedica.setNombreDoctor(txfNomDoctor.getText());
            citaMedica.setEspDoctor(txfEspDoctor.getText());
            citaMedica.setFechaCita(dtpFechaCita.getValue());
            citaMedica.setHora(txfHora.getText());
            citaMedica.setNota(txaNota.getText());
            citaMedica.setEstadoCita(cboEstado.getSelectionModel().getSelectedItem().toString().toUpperCase());
            citaMedica.setEstadoPago(cboEstadoPago.getSelectionModel().getSelectedItem().toString().toUpperCase());
            citaMedica.setCosto(Float.parseFloat(txfCosto.getText()));
            
            Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void Regresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void buscarPaciente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLRegistroPaciente.fxml"));
            Parent root = loader.load();
            FXMLRegistroPacienteController controlador = loader.getController();
            controlador.consultar();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Paciente paciente = controlador.getPacienteSeleccionado();
            if(paciente != null){
                
                this.txfCodPaciente.setText(String.valueOf(paciente.getCodigo()));
                this.txfNomPaciente.setText(paciente.getNombre()+" "+paciente.getApellido());
            }else{
                System.out.println("Paciente no encontrado");
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLCitasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void buscarDoctor(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLRegistroDoctor.fxml"));
            Parent root = loader.load();
            FXMLRegistroDoctorController controlador = loader.getController();
            controlador.consultar();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Doctor doctor = controlador.getDoctorSeleccionado();
            if(controlador.getDoctorSeleccionado() != null){                
                
                this.txfCodDoctor.setText(String.valueOf(doctor.getCodigo()));
                this.txfNomDoctor.setText(doctor.getNombre()+" "+doctor.getApellido());
                this.txfEspDoctor.setText(doctor.getEspecialidad());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLCitasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          cboEstado.setItems(addEstado());
          cboEstadoPago.setItems(addEstadoPago());
    }    

    public TextField getTxfCodCita() {
        return txfCodCita;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public DatePicker getDtpFechaCita() {
        return dtpFechaCita;
    }

    public TextField getTxfNomPaciente() {
        return txfNomPaciente;
    }

    public TextField getTxfNomDoctor() {
        return txfNomDoctor;
    }

    public TextField getTxfEspDoctor() {
        return txfEspDoctor;
    }

    public TextArea getTxaNota() {
        return txaNota;
    }

    public TextField getTxfHora() {
        return txfHora;
    }

    public TextField getTxfCosto() {
        return txfCosto;
    }

    public TextField getTxfCodPaciente() {
        return txfCodPaciente;
    }

    public TextField getTxfCodDoctor() {
        return txfCodDoctor;
    }

    public ComboBox getCboEstado() {
        return cboEstado;
    }

    public ComboBox getCboEstadoPago() {
        return cboEstadoPago;
    }
    
    
    
}
