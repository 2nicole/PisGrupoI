
package Controlador;


import Entidades.Paciente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class FXMLPacienteController implements Initializable {
    
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private DatePicker dtpFecha;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private RadioButton rdbMasculino;

    @FXML
    private RadioButton rdbFemenino;

    @FXML
    private RadioButton rdbSoltero;

    @FXML
    private RadioButton rdbCasado;
    
    @FXML
    private ToggleGroup tglSexo;
    
    @FXML
    private ToggleGroup tglEstado;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnRegresar;
    
    private Paciente paciente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    @FXML
            
    private boolean Validar() {
        
        String errores = "";
        Alert alt = new Alert(Alert.AlertType.ERROR);
        
        if(txtCedula.getText().length() == 0){
            errores += "\nNo ha ingresado una cedula.";
        }else if(!validarNumero(txtCedula.getText())){
            errores += "\nSe ha ingresado la celula del paciente de forma incorrecta.";
        }
        
        if(txtNombres.getText().length() == 0){
            errores += "\nNo ha ingresado los nombres del paciente.";
        }
        
        if(txtApellidos.getText().length() == 0){
            errores += "\nNo ha ingresado los apellidos del paciente.";
        }
        
        if(dtpFecha.getValue() == null){
            errores += "\nNo ha ingresado la fecha de nacimiento del paciente.";
        }
        
        if(txtEdad.getText().length() == 0){
            errores += "\nNo ha ingresado la edad del paciente.";
        }else if(!validarNumero(txtEdad.getText())){
            errores += "\nSe ha ingresado la edad del paciente de forma incorrecta.";
        }
        
        if(!(rdbMasculino.isSelected() || rdbFemenino.isSelected())){
            errores += "\nNo ha seleccionado el sexo del paciente.";
        }
        
        if(!(rdbSoltero.isSelected() || rdbCasado.isSelected())){
            errores += "\nNo ha seleccionado el estado civil del paciente.";
        }
        
        if(txtTelefono.getText().length() == 0){
            errores += "\nNo ha ingresado un numero de telefono.";
        }else if(!validarNumero(txtTelefono.getText())){
            errores += "\nSe ha ingresado el numero de telefono de forma incorrecta.";
        }
        
        if(txtDireccion.getText().length() == 0){
            errores += "\nNo ha ingresado una dirección.";
        }
        
        if(txtEmail.getText().length() == 0){
            errores += "\nNo ha ingresado el email del paciente.";
        }
        
        if(errores.length() != 0){
            alt.setContentText("Se han encontrado los siguientes errores: "+errores);
            alt.show();
            return false;
        }
        
        return true;
    }
    
    private boolean validarNumero(String nu){
        
        try{
            int num = Integer.parseInt(nu);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    @FXML
    void Guardar(ActionEvent event) {
        
        if(Validar()){
           String sexo = new String();
           String estado = new String();
           
           if(rdbMasculino.isSelected()){
               sexo = rdbMasculino.getText();
           }else{
               sexo = rdbFemenino.getText();
           }
           
           if(rdbSoltero.isSelected()){
               estado = rdbSoltero.getText();
           }else{
               estado = rdbCasado.getText();
           }
           
           paciente = new Paciente();
           paciente.setCodigo(Integer.parseInt(txtCodigo.getText()));
           paciente.setCedula(txtCedula.getText());
           paciente.setNombre(txtNombres.getText());
           paciente.setApellido(txtApellidos.getText());
           paciente.setFecha(dtpFecha.getValue());
           paciente.setEdad(Integer.parseInt(txtEdad.getText()));
           paciente.setSexo(sexo.toUpperCase());
           paciente.setEstado(estado.toUpperCase());
           paciente.setTelefono(txtTelefono.getText());
           paciente.setDireccion(txtDireccion.getText());
           paciente.setEmail(txtEmail.getText());
           
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText(null);
           alert.setContentText("Paciente ingresado correctamente");
           alert.showAndWait();
           Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
           stage.close();
           
        }
        
    }
    @FXML
    void Regresar(ActionEvent event) {
           Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
           stage.close();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public TextField getTxtCodigo() {
        return txtCodigo;
    }

    public TextField getTxtCedula() {
        return txtCedula;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public TextField getTxtApellidos() {
        return txtApellidos;
    }

    public DatePicker getDtpFecha() {
        return dtpFecha;
    }

    public TextField getTxtEdad() {
        return txtEdad;
    }

    public TextField getTxtTelefono() {
        return txtTelefono;
    }

    public TextField getTxtDireccion() {
        return txtDireccion;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public RadioButton getRdbMasculino() {
        return rdbMasculino;
    }

    public RadioButton getRdbFemenino() {
        return rdbFemenino;
    }

    public RadioButton getRdbSoltero() {
        return rdbSoltero;
    }

    public RadioButton getRdbCasado() {
        return rdbCasado;
    }

    public ToggleGroup getTglSexo() {
        return tglSexo;
    }

    public ToggleGroup getTglEstado() {
        return tglEstado;
    }

    
    
}

    
