
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class FXMLCrearUsuarioController implements Initializable {

    @FXML
    private ComboBox cboPais;
   
     private ObservableList<String> addPais(){
        ObservableList<String> datos = FXCollections.observableArrayList("Ecuador","Colombia","Venezuela","Brazil");
        
        return datos;
    }
      @Override
    public void initialize(URL url, ResourceBundle rb) {
         cboPais.setItems(addPais());
    }    
    
}
