/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CitaMedicaDaoImpl;
import Entidades.CitaMedica;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLRegistroCitasController implements Initializable {
    
    @FXML
    private TableView<CitaMedica> tblCitasMedica;
    
    @FXML
    private TableColumn<CitaMedica, Integer> colCodCita;

    @FXML
    private TableColumn<CitaMedica, Integer> colCodPaciente;
    
    @FXML
    private TableColumn<CitaMedica, String> colNomPaciente;

    @FXML
    private TableColumn<CitaMedica, Integer> colCodDoctor;
    
    @FXML
    private TableColumn<CitaMedica, String> colNomDoctor;

    @FXML
    private TableColumn<CitaMedica, String> colEspDoctor;

    @FXML
    private TableColumn<CitaMedica, LocalDate> colFecha;

    @FXML
    private TableColumn<CitaMedica, String> colHora;

    @FXML
    private TableColumn<CitaMedica, String> colNota;

    @FXML
    private TableColumn<CitaMedica, String> colEstadoCita;

    @FXML
    private TableColumn<CitaMedica, String> colEstadoPago;

    @FXML
    private TableColumn<CitaMedica, Float> colCosto;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegresar;

    public void consultar(){
        CitaMedicaDaoImpl citasDao = new CitaMedicaDaoImpl();
        this.tblCitasMedica.setItems(citasDao.readAll());
        this.tblCitasMedica.refresh();
    }
    
    @FXML
    void Agregar(ActionEvent event) {
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
                consultar();
            }
           
         } catch (IOException ex) {
             Logger.getLogger(FXMLCitasController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void Modificar(ActionEvent event) {
        if(this.tblCitasMedica.getSelectionModel().getSelectedIndex() >= 0){
            try {
                CitaMedica cita = this.tblCitasMedica.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLCitas.fxml"));
                Parent root = loader.load();
                FXMLCitasController controlador = loader.getController();
                
                controlador.getTxfCodCita().setEditable(false);
                controlador.getTxfCodCita().setText(String.valueOf(cita.getCodigo()));
                controlador.getTxfCodPaciente().setText(String.valueOf(cita.getPaciente()));
                controlador.getTxfNomPaciente().setText(cita.getNombrePaciente());
                controlador.getTxfCodDoctor().setText(String.valueOf(cita.getDoctor()));
                controlador.getTxfNomDoctor().setText(cita.getNombreDoctor());
                controlador.getTxfEspDoctor().setText(cita.getEspDoctor());
                controlador.getDtpFechaCita().setValue(cita.getFechaCita());
                controlador.getTxfHora().setText(cita.getHora());
                controlador.getTxaNota().setText(cita.getNota());
                controlador.getCboEstado().getSelectionModel().select(cita.getEstadoCita());
                controlador.getCboEstadoPago().getSelectionModel().select(cita.getEstadoPago());
                controlador.getTxfCosto().setText(String.valueOf(cita.getCosto()));
                
                Scene scene = new Scene(root);
                scene.getStylesheets().clear();
                scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                CitaMedicaDaoImpl citasDao = new CitaMedicaDaoImpl();
                cita = controlador.getCitaMedica();
                
                if(cita != null){
                    citasDao.update(cita);
                    consultar();
                }

            } catch (IOException ex) {
                Logger.getLogger(FXMLRegistroCitasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    void Eliminar(ActionEvent event) {
        if(this.tblCitasMedica.getSelectionModel().getSelectedIndex() >= 0){
            int codigo = this.tblCitasMedica.getSelectionModel().getSelectedItem().getCodigo();
            CitaMedicaDaoImpl citasDao = new CitaMedicaDaoImpl();
            citasDao.delete(codigo);
            consultar();
        }
    }

    @FXML
    void Regresar(ActionEvent event) {
          Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
          stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colCodCita.setCellValueFactory(new PropertyValueFactory<CitaMedica, Integer>("codigo"));
        colCodPaciente.setCellValueFactory(new PropertyValueFactory<CitaMedica, Integer>("paciente"));
        colNomPaciente.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("nombrePaciente"));
        colCodDoctor.setCellValueFactory(new PropertyValueFactory<CitaMedica, Integer>("doctor"));
        colNomDoctor.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("nombreDoctor"));
        colEspDoctor.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("espDoctor"));
        colFecha.setCellValueFactory(new PropertyValueFactory<CitaMedica, LocalDate>("fechaCita"));
        colHora.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("hora"));
        colNota.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("nota"));
        colEstadoCita.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("estadoCita"));
        colEstadoPago.setCellValueFactory(new PropertyValueFactory<CitaMedica, String>("estadoPago"));
        colCosto.setCellValueFactory(new PropertyValueFactory<CitaMedica, Float>("costo"));
        
    }    
    
}
