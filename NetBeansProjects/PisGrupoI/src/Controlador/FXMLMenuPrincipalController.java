
package Controlador;

import Dao.CitaMedicaDaoImpl;
import Dao.DoctorDaoImpl;
import Dao.EspecialidadDaoImpl;
import Dao.PacientesDaoImpl;
import Entidades.CitaMedica;
import Entidades.Doctor;
import Entidades.Especialidad;
import Entidades.Paciente;
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

public class FXMLMenuPrincipalController implements Initializable {

   @FXML
    private Button btnInicio;

    @FXML
    private Button btnCiita;

    @FXML
    private Button btnPaciente;

    @FXML
    private Button btnMedico;

    @FXML
    private Button btnEspecialidad;

    @FXML
    void Cita(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLCitas.fxml"));
            Parent root = loader.load();
            FXMLCitasController controlador = loader.getController();
            controlador.getTxfCodCita().setEditable(true);
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            CitaMedicaDaoImpl citasDao = new CitaMedicaDaoImpl();
            CitaMedica cita = controlador.getCitaMedica();
            if(cita != null){
                citasDao.create(cita);
            }

         } catch (IOException ex) {
             Logger.getLogger(FXMLCitasController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void Especialidad(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLEspecialidad.fxml"));
            Parent root = loader.load();
            FXMLEspecialidadController controlador = loader.getController();
            controlador.getTxtCodEspecialidad().setEditable(true);
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            EspecialidadDaoImpl espDao = new EspecialidadDaoImpl();
            Especialidad esp = controlador.getEspecialidad();
            if(esp != null){
                espDao.create(esp);
            }

         } catch (IOException ex) {
             Logger.getLogger(FXMLEspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void Inicio(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLInicio.fxml"));
            Parent root = loader.load();
            FXMLInicioController controlador = loader.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

         } catch (IOException ex) {
             Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void Medico(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLDoctor.fxml"));
            Parent root = loader.load();
            FXMLDoctorController controlador = loader.getController();
            controlador.getTxtCodigo().setEditable(true);
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            DoctorDaoImpl doctoresDao = new DoctorDaoImpl();
            Doctor doc = controlador.getDoctor();
            if(doc !=  null){
                doctoresDao.create(doc);
            }
            
         } catch (IOException ex) {
             Logger.getLogger(FXMLDoctorController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void Paciente(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLPaciente.fxml"));
            Parent root = loader.load();
            FXMLPacienteController controlador = loader.getController();
            controlador.getTxtCodigo().setEditable(true);
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            PacientesDaoImpl pacientesDao = new PacientesDaoImpl();
            Paciente paciente = controlador.getPaciente();
            if(paciente != null){
                pacientesDao.create(paciente);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ReporteCita(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLRegistroCitas.fxml"));
            Parent root = loader.load();
            FXMLRegistroCitasController controlador = loader.getController();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
   
  
    
}
