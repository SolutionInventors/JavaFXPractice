package practice19.fadingScene;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class testingController {
	@FXML
	private Label lbl;
	@FXML
	private TextField txt;
	// Event Listener on TextField.onKeyPressed
	@FXML
	public void updatelabael(KeyEvent event) {
		lbl.setText(txt.getText());
	}
}
