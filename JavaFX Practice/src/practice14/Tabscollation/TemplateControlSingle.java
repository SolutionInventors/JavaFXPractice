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

public class TemplateControlSingle {
	@FXML
	private ScrollPane scrollPane;
	
	public void initialize() {
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25));
		grid.setHgap(5);
		grid.setVgap(5);
		
		ColumnConstraints column1 = new ColumnConstraints(50); // fixed for labels
		ColumnConstraints column2 = new ColumnConstraints(130); // min,pref,max
		ColumnConstraints column3 = new ColumnConstraints(100);
		ColumnConstraints column4 = new ColumnConstraints(130);
		ColumnConstraints column5 = new ColumnConstraints(100);
		
		grid.getColumnConstraints().addAll(column1, column2,column3,column4,column5);
		
		Image image = new Image("file:nologo.jpg");
		ImageView img1 = new ImageView(image);
		img1.setFitWidth(108);
		img1.setFitHeight(65);
		img1.setPreserveRatio(true);
		
		Image image2 = new Image("file:nologo.jpg");
		ImageView img6 = new ImageView(image2);
		img6.setFitWidth(308);
		img6.setFitHeight(365);
		img6.setPreserveRatio(true);
	
		Label label1 = new Label("Name");
		Label label2 = new Label("VS");
		Label label3 = new Label("Name");
		ImageView img2 = new ImageView(image);
		img2.setFitWidth(108);
		img2.setFitHeight(65);
		img2.setPreserveRatio(true);
		/*
		Label group = new Label("Group1");
		group.setFont(Font.font("Arial", 20));
		grid.add(group, 0, 0);
		GridPane.setColumnSpan(group, 4);
		GridPane.setHalignment(group, HPos.CENTER);
		group.styleProperty();
		String backgroundStyle =
				"-fx-background-color: lightblue;";
				
		group.setStyle(backgroundStyle);*/
		grid.add(img1, 0, 1);
		grid.add(label1, 1, 1);
		GridPane.setHalignment(label1, HPos.CENTER);
		grid.add(label2, 2, 1);
		grid.add(label3, 3, 1);
		grid.add(img2, 4, 1);
		
		grid.add(new Label("Name"), 0, 2);
		/*grid.add(label1, 1, 1);
		//GridPane.setHalignment(label1, HPos.CENTER);
		grid.add(label2, 2, 1);
		grid.add(label3, 3, 1);
		grid.add(img2, 4, 1);*/
		
		
		/*HBox box = new HBox(5);
		
		
		Button btn = new Button("Click Me");
		btn.setOnAction(e->{
			FileChooser fc = new FileChooser();
			fc.setInitialDirectory(new File("C:\\Users\\Chinedu\\Pictures"));
			File file3 = fc.showOpenDialog(null);
			// for the image
			if (file3 != null) {
				String localUrl = null;
				try {
					localUrl = file3.toURI().toURL().toString();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Image localImage = new Image(localUrl, false);
				img2.setImage(localImage);
			}
		});
		
		String localUrl = file4.toURI().toURL().toString();
		Image localImage = new Image(localUrl, false);
		imgArray.get(3).setImage(localImage);
		
		box.getChildren().addAll(img1,label1,label2,label3,img2,btn);*/
		scrollPane.setContent(grid);
	}
	
}
