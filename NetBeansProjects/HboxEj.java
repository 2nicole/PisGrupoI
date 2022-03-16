/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclovidajavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author mariu
 */
public class HboxEj extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Button btn2 = new Button("Btn 2");
        Button btn3 = new Button("Btn 3");
        Button btn4 = new Button("Btn 4");
        Button btn5 = new Button("Btn 5");
        Button btn6 = new Button("Btn 6");
        
        btn.setText("Btn1 Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        
        HBox root = new HBox(10, btn2, btn3,btn4,btn5,btn6);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Uso de Hbox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
