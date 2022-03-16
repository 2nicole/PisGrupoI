
package Controlador;

import Dao.Conexion;
import Dao.PacientesDaoImpl;
import Entidades.Paciente;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLRegistroPacienteController implements Initializable {
    
    @FXML
    private TableView<Paciente> tlbPaciente;

    @FXML
    private TableColumn<Paciente, Integer> colCodigo;

    @FXML
    private TableColumn<Paciente, String> colCedula;

    @FXML
    private TableColumn<Paciente, String> colNombres;

    @FXML
    private TableColumn<Paciente, String> colApellidos;
    
    @FXML
    private TableColumn<Paciente, LocalDate> colFecha;

    @FXML
    private TableColumn<Paciente, Integer> colEdad;

    @FXML
    private TableColumn<Paciente, String> colSexo;

    @FXML
    private TableColumn<Paciente, String> colEstado;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableColumn<Paciente, String> colDireccion;

    @FXML
    private TableColumn<Paciente, String> colEmail;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnModificar;
    
    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegresar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.colCodigo.setCellValueFactory(new PropertyValueFactory<Paciente, Integer>("codigo"));
        this.colCedula.setCellValueFactory(new PropertyValueFactory<Paciente, String>("cedula"));
        this.colNombres.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Apellido"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<Paciente, LocalDate>("Fecha"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory<Paciente, Integer>("Edad"));
        this.colSexo.setCellValueFactory(new PropertyValueFactory<Paciente, String>("sexo"));
        this.colEstado.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Estado"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Telefono"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Direccion"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Email"));
        
    }
    
    public void consultar(){
        PacientesDaoImpl pacientesDao = new PacientesDaoImpl();
        this.tlbPaciente.setItems(pacientesDao.readAll());
        this.tlbPaciente.refresh();
    }

    @FXML
    void Agregar(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLPaciente.fxml"));
            Parent root = loader.load();
            FXMLPacienteController controlador = loader.getController();
            controlador.getTxtCodigo().setEditable(true);
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloPis.css").toExternalForm());
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            PacientesDaoImpl pacientesDao = new PacientesDaoImpl();
            Paciente paciente = controlador.getPaciente();
            if(paciente != null){
                pacientesDao.create(paciente);
                consultar();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error de Registro");
                alert.setContentText("No se ha registrado ningun paciente.");
                alert.showAndWait();
            }
            
         } catch (IOException ex) {
             Logger.getLogger(FXMLPacienteController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @FXML
    void Modificar(ActionEvent event){
        if(this.tlbPaciente.getSelectionModel().getSelectedIndex() >= 0){
            Paciente paciente = this.tlbPaciente.getSelectionModel().getSelectedItem();
            
            try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLPaciente.fxml"));
            Parent root = loader.load();
            FXMLPacienteController controlador = loader.getController();
            
            controlador.getTxtCodigo().setEditable(false);
            controlador.getTxtCodigo().setText(String.valueOf(paciente.getCodigo()));
            controlador.getTxtCedula().setText(paciente.getCedula());
            controlador.getTxtNombres().setText(paciente.getNombre());
            controlador.getTxtApellidos().setText(paciente.getApellido());
            controlador.getDtpFecha().setValue(paciente.getFecha());
            controlador.getTxtEdad().setText(String.valueOf(paciente.getEdad()));
            if(paciente.getSexo().toUpperCase().equals(controlador.getRdbFemenino().getText().toUpperCase())){
                controlador.getRdbFemenino().setSelected(true);
                controlador.getRdbMasculino().setSelected(false);
            }else{
                controlador.getRdbFemenino().setSelected(false);
                controlador.getRdbMasculino().setSelected(true);
            }

            if(paciente.getEstado().toUpperCase().equals(controlador.getRdbCasado().getText().toUpperCase())){
                controlador.getRdbCasado().setSelected(true);
                controlador.getRdbSoltero().setSelected(false);
            }else{
                controlador.getRdbCasado().setSelected(false);
                controlador.getRdbSoltero().setSelected(true);
            }
            
            controlador.getTxtTelefono().setText(paciente.getTelefono());
            controlador.getTxtDireccion().setText(paciente.getDireccion());
            controlador.getTxtEmail().setText(paciente.getEmail());
            
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloPis.css").toExternalForm());
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            PacientesDaoImpl pacientesDao = new PacientesDaoImpl();
            if(controlador.getPaciente() != null){
                paciente = controlador.getPaciente();
                pacientesDao.update(paciente);
                consultar();
            }
            
            } catch (IOException ex) {
                Logger.getLogger(FXMLPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }

    @FXML
    void Eliminar(ActionEvent event) {
        if(this.tlbPaciente.getSelectionModel().getSelectedIndex() >= 0){
            int codigo = this.tlbPaciente.getSelectionModel().getSelectedItem().getCodigo();
            PacientesDaoImpl pacientesDao = new PacientesDaoImpl();
            pacientesDao.delete(codigo);
            consultar();
        }
    }

    @FXML
    void Regresar(ActionEvent event) {
        
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }

    public Paciente getPacienteSeleccionado() {
        Paciente paciente = null;
        
        if(this.tlbPaciente.getSelectionModel().getSelectedIndex() >= 0){
            paciente = this.tlbPaciente.getSelectionModel().getSelectedItem();
        }
        
        return paciente;
    }
    
}
