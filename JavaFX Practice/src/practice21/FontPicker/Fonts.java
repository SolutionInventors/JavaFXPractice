/**
 * 
 */
package practice21.FontPicker;

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

/**
 * @author ChineduKnight
 *
 */

/**
 * @author Chinedu Oguejiofor
 *6 Sep. 2017
 * 3:54:16 pm*/

public class Fonts extends Application {

	


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
		    	URL url = getClass().getResource("/resources/fonts/TRON.TTF");
		    	final Font f = Font.loadFont(new FileInputStream(new File(url.toURI())), 19);
		    	
		    	label.setFont(f); // use this font with our label
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    rootGroup.getChildren().add(label); 

		    // create scene, add root group and show stage
		    Scene scene = new Scene(rootGroup, 640, 480, Color.WHITE);
		    primaryStage.setScene(scene);
		    primaryStage.show();
		  }
		}