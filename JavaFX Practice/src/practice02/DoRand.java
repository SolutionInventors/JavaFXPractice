/**
 * @author ChineduKnight Oguejiofor
 *19 Jul. 2017
 * 11:07:15 pm
 */
package practice02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoRand extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("display.css").toExternalForm());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
