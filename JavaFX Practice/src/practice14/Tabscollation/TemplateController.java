package practice14.Tabscollation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class TemplateController {
	@FXML
	private ScrollPane scrollPane;
	
	public void initialize() {
		VBox box = new VBox(5);
		Button btn = new Button("Chinedu");
		box.getChildren().add(btn);
		//scrollPane.add
	}

}
