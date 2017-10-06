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
    ArrayList<ComboBox<String>> comboGuesses = new ArrayList<ComboBox<String>>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        ObservableList<String> abc = FXCollections.observableArrayList("W","D","L");
        window.setTitle("ComboBox Demo");
        button = new Button("Submit");
        comboGuesses.add(0, new ComboBox<String>());
        comboGuesses.get(0).maxHeight(Region.USE_COMPUTED_SIZE);
        comboGuesses.get(0).getItems().addAll(abc);
        comboGuesses.add(1, new ComboBox<String>());
        comboGuesses.get(1).getItems().addAll("A","B","R");
		
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