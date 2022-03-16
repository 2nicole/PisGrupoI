/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author nicole
 */
public class FXMLIngresosDeDatosController implements Initializable {
    @FXML
    private VBox txtEspecialidad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombres;

    @FXML
    private DatePicker datePikerFechaDeNacimiento;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtSexo;

    @FXML
    private TextField txtEstadoCivil;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnSalir;

    @FXML
    void Guardar(ActionEvent event) {

    }

    @FXML
    void Salir(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
