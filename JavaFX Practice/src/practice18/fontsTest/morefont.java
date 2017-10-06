package practice18.fontsTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class morefont extends Application {
	public static void main(String[] args) {
	    launch(args);
	  }

	  public void start(final Stage primaryStage) throws FileNotFoundException, URISyntaxException {
	    Group rootGroup = new Group();

	    // create a label to show some text
	    Label label = new Label("Demo Text");
	    // load a custom font from a specific location (change path!)
	      // 12 is the size to use
	     // final Font f = Font.loadFont(new FileInputStream(new File("C:\\Users\\Chinedu\\git\\JavaFXPractice\\JavaFX Practice\\src\\practice18\\fontsTest\\Pristina.ttf")), 121);
		URL url = getClass().getResource("/resources/fonts/TRON.TTF"); 
		//final Font f = Font.loadFont(new FileInputStream(new File(url.toURI())), 19);
		final Font f = Font.loadFont(getClass().getResource("practice18/fontsTest/Pristina.ttf").toString(), 121);
	      
	      label.setFont(f); // use this font with our label

	    rootGroup.getChildren().add(label); 

	    // create scene, add root group and show stage
	    Scene scene = new Scene(rootGroup, 640, 480, Color.WHITE);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	}