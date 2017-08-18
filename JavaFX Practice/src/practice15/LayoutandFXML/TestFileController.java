package practice15.LayoutandFXML;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class TestFileController {
	@FXML
	private HBox hbox;
	
	public void initialize() {
	hbox.setPadding(new Insets(5));
	
	Rectangle r1 = new Rectangle(30,30);
	Rectangle r2 = new Rectangle(50,30);
	Rectangle r33 = new Rectangle(30,50);
	
	Button btn = new Button("Click me");
	Button btn2 = new Button("Click me");
	Button btn1 = new Button("Click me");
	
	HBox.setMargin(r1, new Insets(2,2,2,2));
	hbox.getChildren().addAll(r1,r2,r33,btn1,btn,btn2);
	}
}
