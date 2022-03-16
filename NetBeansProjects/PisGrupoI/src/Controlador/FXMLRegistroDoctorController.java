
package Controlador;

import Dao.DoctorDaoImpl;
import Entidades.Doctor;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLRegistroDoctorController implements Initializable {
    
    @FXML
    private TableView<Doctor> tblDoctor;

    @FXML
    private TableColumn<Doctor, Integer> colCodigo;

    @FXML
    private TableColumn<Doctor, String> colCedula;

    @FXML
    private TableColumn<Doctor, String> colNombres;

    @FXML
    private TableColumn<Doctor, String> colApellidos;

    @FXML
    private TableColumn<Doctor, LocalDate> colFecha;

    @FXML
    private TableColumn<Doctor, Integer> colEdad;

    @FXML
    private TableColumn<Doctor, String> colSexo;

    @FXML
    private TableColumn<Doctor, String> colEspecialidad;

    @FXML
    private TableColumn<Doctor, String> ColTelefono;
    
    @FXML
    private TableColumn<Doctor, String> colEstado;

    @FXML
    private TableColumn<Doctor, String> colDireccion;

    @FXML
    private TableColumn<Doctor, String> colEmail;

    @FXML
    private Button btnAgregar;
    
    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegresar;
    
    public void consultar(){
        DoctorDaoImpl doctoresDao = new DoctorDaoImpl();
        this.tblDoctor.setItems(doctoresDao.readAll());
        this.tblDoctor.refresh();
    }

    @FXML
    void Agregar(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLDoctor.fxml"));
            Parent root = loader.load();
            FXMLDoctorController controlador = loader.getController();
            controlador.getTxtCodigo().setEditable(true);
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloPis.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            DoctorDaoImpl doctoresDao = new DoctorDaoImpl();
            Doctor doctor = controlador.getDoctor();
            if(doctor != null){
                doctoresDao.create(doctor);
                consultar();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error de Registro");
                alert.setContentText("No se ha registrado ningun doctor.");
                alert.showAndWait();
            }
            
         } catch (IOException ex) {
             Logger.getLogger(FXMLDoctorController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @FXML
    void Modificar(ActionEvent event) {
        if(this.tblDoctor.getSelectionModel().getSelectedIndex() >= 0){
            try {
                Doctor doctor = this.tblDoctor.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLDoctor.fxml"));
                Parent root = loader.load();
                
                FXMLDoctorController controlador = loader.getController();
                controlador.getTxtCodigo().setEditable(false);
                controlador.getTxtCodigo().setText(String.valueOf(doctor.getCodigo()));
                controlador.getTxtCedula().setText(doctor.getCedula());
                controlador.getTxtNombres().setText(doctor.getNombre());
                controlador.getTxtApellidos().setText(doctor.getApellido());
                controlador.getDtpFecha().setValue(doctor.getFecha());
                controlador.getTxtEdad().setText(String.valueOf(doctor.getEdad()));
                
                if(doctor.getSexo().toUpperCase().equals(controlador.getRbdFemenino().getText().toUpperCase())){
                    controlador.getRbdFemenino().setSelected(true);
                    controlador.getRbdMasculino().setSelected(false);
                }else{
                    controlador.getRbdFemenino().setSelected(false);
                    controlador.getRbdMasculino().setSelected(true);
                }
                
                if(doctor.getEstado().toUpperCase().equals(controlador.getRbdCasado().getText().toUpperCase())){
                    controlador.getRbdCasado().setSelected(true);
                    controlador.getRbdSoltero().setSelected(false);
                }else{
                    controlador.getRbdCasado().setSelected(false);
                    controlador.getRbdSoltero().setSelected(true);
                }
                
                controlador.getTxtCodEsp().setText(String.valueOf(doctor.getCodEsp()));
                controlador.getTxtEspecialidad().setText(doctor.getEspecialidad());
                controlador.getTxtTelefono().setText(doctor.getTelefono());
                controlador.getTxtDireccion().setText(doctor.getDireccion());
                controlador.getTxtEmail().setText(doctor.getEmail());
                
                Scene scene = new Scene(root);
                scene.getStylesheets().clear();
                scene.getStylesheets().add(getClass().getResource("/css/EstiloPis.css").toExternalForm());
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                DoctorDaoImpl doctoresDao = new DoctorDaoImpl();
                doctor = controlador.getDoctor();
                
                if(doctor != null){
                    doctoresDao.update(doctor);
                    consultar();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error de Registro");
                    alert.setContentText("No se ha registrado ningun doctor.");
                    alert.showAndWait();
                }

             } catch (IOException ex) {
                 Logger.getLogger(FXMLDoctorController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }

    @FXML
    void Eliminar(ActionEvent event) {
        if(this.tblDoctor.getSelectionModel().getSelectedIndex() >= 0){
            int codigo = this.tblDoctor.getSelectionModel().getSelectedItem().getCodigo();
            DoctorDaoImpl doctoresDao = new DoctorDaoImpl();
            doctoresDao.delete(codigo);
            consultar();
        }
    }

    @FXML
    void Regresar(ActionEvent event) {
        Stage stage = (Stage) this.btnAgregar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colCodigo.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("codigo"));
        colCedula.setCellValueFactory(new PropertyValueFactory<Doctor, String>("cedula"));
        colNombres.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Apellido"));
        colFecha.setCellValueFactory(new PropertyValueFactory<Doctor, LocalDate>("Fecha"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("Edad"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Especialidad"));
        colSexo.setCellValueFactory(new PropertyValueFactory<Doctor, String>("sexo"));
        colEstado.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Estado"));
        ColTelefono.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Direccion"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Email"));
    }    
    
    public Doctor getDoctorSeleccionado(){
        Doctor doctor = null;
        
        if(this.tblDoctor.getSelectionModel().getSelectedIndex() >= 0){
            doctor = this.tblDoctor.getSelectionModel().getSelectedItem();
        }
        
        return doctor;
    }
    
}
