
package Controlador;

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
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLLoginController implements Initializable {
    
    @FXML
    private Button btnIniciar;
        @FXML
    private ImageView imgLogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    @FXML
    void Iniciar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLMenuPrincipal.fxml"));
            Parent root = loader.load();
            FXMLMenuPrincipalController controlador = loader.getController();
            Scene scene = new Scene(root);
            
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   

    @FXML
    void Registrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/FXMLCrearUsuario.fxml"));
            Parent root = loader.load();
            FXMLCrearUsuarioController controlador = loader.getController();
            Scene scene = new Scene(root);
             scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/EstiloMenu.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLCrearUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
