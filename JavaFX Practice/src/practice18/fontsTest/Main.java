package practice18.fontsTest;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			Font.loadFont(getClass().getResource("Pristina.ttf").toExternalForm(), 10);
			Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			  
			scene.getStylesheets().add(getClass().getResource("fonts.css").toExternalForm());
			primaryStage.show();
			primaryStage.setTitle("Working on fONTS");
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
