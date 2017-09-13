package practice14.Tabscollation;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TemplateControlforFixtures {
	@FXML
	private ScrollPane scrollPane;
	private int row;
	private int col;

	public void initialize() {
		// GridPane settings
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25));
		grid.setHgap(5);
		grid.setVgap(5);
		// ColumnSettings for all five columns
		ColumnConstraints column1 = new ColumnConstraints(70); // fixed for labels
		ColumnConstraints column2 = new ColumnConstraints(130); // min,pref,max
		ColumnConstraints column3 = new ColumnConstraints(100);
		ColumnConstraints column4 = new ColumnConstraints(130);
		ColumnConstraints column5 = new ColumnConstraints(100);

		grid.getColumnConstraints().addAll(column1, column2, column3, column4, column5);
		// Variable Delarations

		Image image = new Image("file:nologo.jpg");
		ImageView logo[] = new ImageView[20];
		Label playerName[] = new Label[20];
		Label VS[] = new Label[10];

		// initialize testing
		for (int i = 0; i < logo.length; i++) {
			logo[i] = new ImageView(image);
			//logo[i].setImage(image);
			logo[i].setFitWidth(108);
			logo[i].setFitHeight(65);
			logo[i].setPreserveRatio(true);
			playerName[i] = new Label();
			playerName[i].setText("Player " + i);
			if (i < 9)
				VS[i]= new Label("VS");
				//VS[i].setText();
		}

		int c = 0;
		for (int i = 0; i < 9; i++) {
			grid.add(logo[c], 0, i);
			grid.add(playerName[c], 1, i);
			grid.add(VS[i], 2, i);
			grid.add(playerName[c + 1], 3, i);
			grid.add(logo[c + 1], 4, i);
			c += 2;
		}
		scrollPane.setContent(grid);
	}

}
