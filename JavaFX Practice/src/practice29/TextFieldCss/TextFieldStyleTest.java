package practice29.TextFieldCss;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextFieldStyleTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);
        for (int row = 0 ; row < 4; row++) {
            for (int col = 0 ; col < 2; col++) {
                root.add(new TextField(), col, row);
            }
        }
        root.setPadding(new Insets(5));
        Scene scene = new Scene(root);
      scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
       // scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}