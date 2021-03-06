package practice24.Animation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewsTest extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("finalTest.fxml").openStream());
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			primaryStage.show();
			primaryStage.setTitle("Test News");
			scene.getStylesheets()
            .add(getClass()
            .getResource("news-ticker-photo-viewer.css")
            .toExternalForm());
			finalTestController ic = (finalTestController) loader.getController();
			ic.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
