/**
 * @author Chinedu Oguejiofor
 *6 Sep. 2017
 * 3:54:16 pm
 */
package practice15.LayoutandFXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test2 extends Application {

	  public static void main(String[] args) {
	    launch(args);
	  }

	  public void start(final Stage primaryStage) {
	    Group rootGroup = new Group();

	    // create a label to show some text
	    Label label = new Label("Demo Text");
	    try { 
	      // load a custom font from a specific location (change path!)
	      // 12 is the size to use
	    	final Font f = Font.loadFont(new FileInputStream(new File("Pristina.ttf")), 19);
	    	
	    	label.setFont(f); // use this font with our label
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }

	    rootGroup.getChildren().add(label); 

	    // create scene, add root group and show stage
	    Scene scene = new Scene(rootGroup, 640, 480, Color.WHITE);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	}