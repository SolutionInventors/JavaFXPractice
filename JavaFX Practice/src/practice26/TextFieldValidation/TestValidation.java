package practice26.TextFieldValidation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestValidation extends Application {
	 Stage window;
	    Scene scene;
	    int a=0;
		
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	CustomTextField textField[] = new CustomTextField[5];
    	TextField textField2 = new TextField();
    	for (int i = 0; i < textField.length; i++) {
    		textField[i] = new CustomTextField();
    		textField[i].setNumericOnly(true);
		}
    
    
    	
    	window = primaryStage;
        window.setTitle("ComboBox Demo");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i < textField.length; i++) {
        	 layout.getChildren().add(textField[i]);
        }
       

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
