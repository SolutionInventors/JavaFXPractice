package practice12.RadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class RadioButtonController {
	@FXML private RadioButton rb1;
	@FXML private RadioButton rb2;
	@FXML private Label lbl;
	
	public void radioSelected (ActionEvent e) {
		String message = "";
		if (rb1.isSelected()) 
			message = "chinedu";
		if(rb2.isSelected())
			message += rb2.getText();
		lbl.setText(message);
		
		
	}
}
