/**
 * @author ChineduKnight Oguejiofor
 *19 Jul. 2017
 * 11:08:47 pm
 */
package practice02;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	
	@FXML
	private Label myLabel;
	
	
	public void generateRandom(ActionEvent e) {
		Random rand = new Random();
		System.out.println(rand.nextInt(500));
		myLabel.setText(String.valueOf(rand.nextInt(500)));
	}//end method
	
	
	
}//end class
