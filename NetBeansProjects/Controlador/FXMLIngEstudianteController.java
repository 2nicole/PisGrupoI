/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kassa
 */
public class FXMLIngEstudianteController implements Initializable {
    
    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnSalir;
    private ObservableList lstEstudiante;
    private Estudiante estudiante;


    @FXML
    void guardar(ActionEvent event) {
        String nombres = this.txtNombres.getText();
        String apellidos = this.txtApellidos.getText();
        Integer edad = Integer.parseInt(this.txtEdad.getText());
        estudiante= new Estudiante(nombres,apellidos,edad);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Estudiante Ingresado");
        alert.showAndWait();
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void salir(ActionEvent event) {
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();

    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
