package practice11.FromJFXBook;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class erre extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("GridPaneForm ");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 380, 150, Color.WHITE);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		ColumnConstraints column1 = new ColumnConstraints(100);
		ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
		column2.setHgrow(Priority.ALWAYS);
		gridpane.getColumnConstraints().addAll(column1, column2);
		Label fNameLbl = new Label("First Name");
		TextField fNameFld = new TextField();
		Label lNameLbl = new Label("Last Name");
		TextField lNameFld = new TextField();
		Button saveButton = new Button("Save");
		// First name label
		GridPane.setHalignment(fNameLbl, HPos.RIGHT);
		gridpane.add(fNameLbl, 0, 0);
		// Last name label
		GridPane.setHalignment(lNameLbl, HPos.RIGHT);
		gridpane.add(lNameLbl, 0, 1);
		// First name field
		GridPane.setHalignment(fNameFld, HPos.LEFT);
		gridpane.add(fNameFld, 1, 0);
		// Last name field
		GridPane.setHalignment(lNameFld, HPos.LEFT);
		gridpane.add(lNameFld, 1, 1);
		// Save button
		GridPane.setHalignment(saveButton, HPos.RIGHT);
		gridpane.add(saveButton, 1, 2);
		FlowPane topBanner = new FlowPane();
		topBanner.setPrefHeight(40);
		String backgroundStyle = "-fx-background-color: lightblue;" + "-fx-background-radius: 30%;"
				+ "-fx-background-inset: 5px;";
		topBanner.setStyle(backgroundStyle);
		SVGPath svgIcon = new SVGPath();
		// icon from http://raphaeljs.com/icons/#people
		svgIcon.setContent("I put this here");
		svgIcon.setStroke(Color.LIGHTGRAY);
		svgIcon.setFill(Color.WHITE);
		Text contactText = new Text("Contacts");
		contactText.setFill(Color.WHITE);
		Font serif = Font.font("Dialog", 30);
		contactText.setFont(serif);
		topBanner.getChildren().addAll(svgIcon, contactText);
		root.setTop(topBanner);
		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
