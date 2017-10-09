/**
 * 
 */
package practice25.TextViewlisten;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author ChineduKnight
 *
 */
public class Test extends Application {

    Stage window;
    Scene scene;
    Button button;
    Label test;
    int i;
    int iii;
    ArrayList<ComboBox<String>> comboGuesses = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        ObservableList<String> abc = FXCollections.observableArrayList("W","D","L");
        window.setTitle("ComboBox Demo");
        button = new Button("Submit");
       for (int i = 0; i < 6; i++) {
    	   comboGuesses.add(i, new ComboBox<String>());
           comboGuesses.get(i).maxHeight(Region.USE_COMPUTED_SIZE);
           comboGuesses.get(i).getItems().addAll(abc);
	}
       i=0;
        for (i = 0; i < 2; i+=2) {
        	System.out.println("cureent value of i" + i);
        	 comboGuesses.get(i).setOnAction(e->{
        		 iii=i;
        		 iii++;
        		 System.out.println(iii);
        		 
             	comboGuesses.get(iii).setValue("L");
             });
		}
      
        /*comboGuesses.add(1, new ComboBox<String>());
        comboGuesses.get(1).getItems().addAll("W","L","D");
        test = new Label("NOthing here");
        test.setText("NOthing here");
        test.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        test.textProperty().bind(comboGuesses.get(0).valueProperty());*/
       
        //comboGuesses.get(0).textp
		
        button.setOnAction(e -> printMovie());
        
        //ComboBoxes also generate actions if you need to get value instantly
        

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button,comboGuesses.get(0),comboGuesses.get(1));

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printMovie(){
        System.out.println(comboGuesses.get(0).getValue());
    }


}