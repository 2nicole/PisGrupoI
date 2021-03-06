/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kassa
 */
public class FXMLEstudianteController implements Initializable {
    @FXML
    private TableView<Estudiante> tblEstudiante;

    @FXML
    private TableColumn<Estudiante, String> colNombres;

    @FXML
    private TableColumn<Estudiante, String> colApellidos;

    @FXML
    private TableColumn<Estudiante, Integer> colEdad;

    @FXML
    private Button btnAgregar;
        

    @FXML
    private Button btnSalir;
    private ObservableList lstEstudiante;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstEstudiante = FXCollections.observableArrayList();
        this.tblEstudiante.setItems(lstEstudiante);
        this.colNombres.setCellValueFactory(new PropertyValueFactory("Nombres"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("Apellidos"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("Edad"));
    }    
    
    @FXML
    void agregar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLIngEstudiante.fxml"));
            Parent root =loader.load();
            FXMLIngEstudianteController controlador = loader.getController();
            Scene scene= new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EjemploE.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            this.lstEstudiante.add(controlador.getEstudiante());
            this.tblEstudiante.refresh();
        } catch (IOException ex) {
            Logger.getLogger(FXMLEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void salir(ActionEvent event) {

    }
}
