/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Doctor;
import com.sun.istack.internal.logging.Logger;
import fmxlproyectogrupoi.FXMLProyectoGrupoI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author nicole
 */
public class FXMLDoctorController implements Initializable
{

    private static Class<?> getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML
    private TableView<Doctor> tblDoctor;

    @FXML
    private TableColumn<Doctor, String> colCodigo;

    @FXML
    private TableColumn<Doctor, String> colNombres;

    @FXML
    private TableColumn<Doctor, String> colApellidos;

    @FXML
    private TableColumn<Doctor, String> colFechaDeNacimiento;

    @FXML
    private TableColumn<Doctor, Integer> colEdad;

    @FXML
    private TableColumn<Doctor, String> colSexo;

    @FXML
    private TableColumn<Doctor, String> colEstadoCivil;

    @FXML
    private TableColumn<Doctor, String> colTelefono;

    @FXML
    private TableColumn<Doctor, String> colDireccion;

    @FXML
    private TableColumn<Doctor, String> colEmail;

    @FXML
    private TableColumn<Doctor, String> colEspecilidad;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnSalir;

    @FXML
    void Eliminar(ActionEvent event) {
      
    }

    @FXML
    void Registrar(ActionEvent event) {
         try{
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLIngresosDeDatos.fxml"));
     Parent root = loader.load();
     FXMLIngresosDeDatosController controlador = loader.getController();
     Scene scene = new Scene(root);
     Stage stage = new Stage();
     stage.initModality(Modality.WINDOW_MODAL);
     stage.setScene(scene);
     stage.showAndWait();
        } catch (IOException ex){
       Logger.getLogger(FXMLDoctorController.getName()).log(Level.SEVERE, null, ex);
}
    }

    @FXML
    void Salir(ActionEvent event) {

    }

   
}



  




