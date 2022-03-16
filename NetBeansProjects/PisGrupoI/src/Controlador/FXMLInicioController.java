/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Conexion;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLInicioController implements Initializable {
    @FXML
    private Button btnPacienteRegistrado;

    @FXML
    private Button btnMedicoRegistrado;

    @FXML
    private Button btnCitasRegistrado;

    @FXML
    private Button btnEspacialidadRegistrados;
    
    @FXML
    private Button btnSalir;


    @FXML
    void CitaReg(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLRegistroCitas.fxml"));
            Parent root = loader.load();
            FXMLRegistroCitasController controlador = loader.getController();
            controlador.consultar();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

         } catch (IOException ex) {
             Logger.getLogger(FXMLRegistroCitasController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void EspecialidadesReg(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLRegistroEspecialidad.fxml"));
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

         } catch (IOException ex) {
             Logger.getLogger(FXMLRegistroEspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void MedicoReg(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLRegistroDoctor.fxml"));
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
            
         } catch (IOException ex) {
             Logger.getLogger(FXMLRegistroDoctorController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void PacienteReg(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLRegistroPaciente.fxml"));
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

         } catch (IOException ex) {
             Logger.getLogger(FXMLRegistroPacienteController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
       @FXML
    void Salir(ActionEvent event) {
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
