
package Controlador;

import Dao.EspecialidadDaoImpl;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLRegistroEspecialidadController implements Initializable {
    
    @FXML
    private TableView<Especialidad> tblEspecialidad;

    @FXML
    private TableColumn<Especialidad, Integer> colCodEsp;

    @FXML
    private TableColumn<Especialidad, String> colEspe;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegresar;

    public void consultar(){
        EspecialidadDaoImpl especialidadDao = new EspecialidadDaoImpl();
        this.tblEspecialidad.setItems(especialidadDao.readAll());
        this.tblEspecialidad.refresh();
    }
    
    @FXML
    void Agregar(ActionEvent event) {
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
            
            EspecialidadDaoImpl especialidadDao = new EspecialidadDaoImpl();
            Especialidad espec = controlador.getEspecialidad();
            if(espec != null){
                especialidadDao.create(espec);
                consultar();
            }
           
         } catch (IOException ex) {
             Logger.getLogger(FXMLEspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void Eliminar(ActionEvent event) {
         if(this.tblEspecialidad.getSelectionModel().getSelectedIndex() >= 0){
            int codigo = this.tblEspecialidad.getSelectionModel().getSelectedItem().getCodigo();
            EspecialidadDaoImpl especialidadDao = new EspecialidadDaoImpl();
            especialidadDao.delete(codigo);
            consultar();
        }
    }

    @FXML
    void Modificar(ActionEvent event) {
         if(this.tblEspecialidad.getSelectionModel().getSelectedIndex() >= 0){
            try {
                Especialidad especialidad = this.tblEspecialidad.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLEspecialidad.fxml"));
                Parent root = loader.load();
                
                FXMLEspecialidadController controlador = loader.getController();
                
                controlador.getTxtCodEspecialidad().setEditable(false);
                controlador.getTxtCodEspecialidad().setText(String.valueOf(especialidad.getCodigo()));
                controlador.getTxtEspecialidad().setText(especialidad.getEspDoctor());
                
                Scene scene = new Scene(root);
                scene.getStylesheets().clear();
                scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                EspecialidadDaoImpl especialidadDao = new EspecialidadDaoImpl();
                Especialidad espec = controlador.getEspecialidad();
                if(espec != null){
                    especialidadDao.update(espec);
                    consultar();
                }

            } catch (IOException ex) {
                Logger.getLogger(FXMLEspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    void Regresar(ActionEvent event) {
        Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colCodEsp.setCellValueFactory(new PropertyValueFactory<Especialidad, Integer>("codigo"));
        colEspe.setCellValueFactory(new PropertyValueFactory<Especialidad, String>("espDoctor"));
    }    
    
    public Especialidad getEspSeleccionada(){
        Especialidad especialidad = null;
        
        if(tblEspecialidad.getSelectionModel().getSelectedIndex() >= 0){
            especialidad = tblEspecialidad.getSelectionModel().getSelectedItem();
        }
        
        return especialidad;
    }
    
}
