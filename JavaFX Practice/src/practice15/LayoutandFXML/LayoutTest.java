package practice15.LayoutandFXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LayoutTest extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("TestFile.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Working on Radio");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(5));
		
		Rectangle r1 = new Rectangle(30,30);
		Rectangle r2 = new Rectangle(50,30);
		Rectangle r33 = new Rectangle(30,50);
		
		HBox.setMargin(r1, new Insets(2,2,2,2));
		hbox.getChildren().addAll(r1,r2,r33);
		
		Scene scene = new Scene(hbox,400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Working Linking");*/
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
