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
			Parent root = loader.load(getClass().getResource("News.fxml").openStream());
			NewsController ic = (NewsController) loader.getController();
			ic.set(primaryStage);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			primaryStage.show();
			primaryStage.setTitle("Test News");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
