package practice26.TextFieldValidation;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestValidation extends Application {
	 Stage window;
	    Scene scene;
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	TextField textField = new TextField();
    	TextField textField2 = new TextField();
    	// force the field to be numeric only
        
    	textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
      	// force the field to be word entry  only
    	textField2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[a-z]")) {
                    textField2.setText(newValue.replaceAll("[\\d]", ""));
                }
            }
        });
    	
    	
    	window = primaryStage;
        window.setTitle("ComboBox Demo");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(textField,textField2);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
