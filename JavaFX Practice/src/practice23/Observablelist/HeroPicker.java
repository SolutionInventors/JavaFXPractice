package practice23.Observablelist;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Hero Picker application demonstrates observable lists and list views.
 * 
 * @author cdea
 */
public class HeroPicker extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hero Picker: Chapter 4 Creating and Working with ObservableLists");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 250, Color.WHITE);

		// create a grid pane
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		ColumnConstraints column2 = new ColumnConstraints(50);
		ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		column1.setHgrow(Priority.ALWAYS);
		column3.setHgrow(Priority.ALWAYS);
		gridpane.getColumnConstraints().addAll(column1, column2, column3);

		// Candidates label
		Label candidatesLbl = new Label("Candidates");
		GridPane.setHalignment(candidatesLbl, HPos.CENTER);
		gridpane.add(candidatesLbl, 0, 0);

		// Heroes label
		Label heroesLbl = new Label("Heroes");
		gridpane.add(heroesLbl, 2, 0);
		GridPane.setHalignment(heroesLbl, HPos.CENTER);

		// Candidates
		final ObservableList<String> candidates = FXCollections.observableArrayList("Superman", "Spiderman",
				"Wolverine", "Police", "Fire Rescue", "Soldiers", "Dad & Mom", "Doctor", "Politician", "Pastor",
				"Teacher");
		final ListView<String> candidatesListView = new ListView<>(candidates);
		gridpane.add(candidatesListView, 0, 1);

		// heros
		final ObservableList<String> heroes = FXCollections.observableArrayList();
		final ListView<String> heroListView = new ListView<>(heroes);
		gridpane.add(heroListView, 2, 1);
		// select heroes
	    Button sendRightButton = new Button(" > ");
	    sendRightButton.setOnAction((ActionEvent event) -> {
	        String potential = candidatesListView.getSelectionModel().getSelectedItem();
	        if (potential != null) {
	            candidatesListView.getSelectionModel().clearSelection();
	            candidates.remove(potential);
	            heroes.add(potential);
	        }
	    });

		// deselect heroes
		Button sendLeftButton = new Button(" < ");
		sendLeftButton.setOnAction((ActionEvent event) -> {
			String notHero = heroListView.getSelectionModel().getSelectedItem();
			if (notHero != null) {
				heroListView.getSelectionModel().clearSelection();
				heroes.remove(notHero);
				candidates.add(notHero);
			}
		});

		Button sendUp = new Button(" ^ ");
		sendUp.setOnAction((ActionEvent event) -> {
			String selected = heroListView.getSelectionModel().getSelectedItem();
			if (selected != null && heroes.indexOf(selected) >0) {
				int selectedIndex = heroes.indexOf(selected);
				int aboveselectedIndex = selectedIndex;
				aboveselectedIndex--;
				String aboveselected = heroes.get(aboveselectedIndex);
				
				heroes.set(aboveselectedIndex, selected);
				heroes.set(selectedIndex, aboveselected);
				heroListView.getSelectionModel().select(aboveselectedIndex);
			}
		});

		Button senddown = new Button(" V ");
		senddown.setOnAction((ActionEvent event) -> {
			String selected = candidatesListView.getSelectionModel().getSelectedItem();
			if (selected != null && candidates.indexOf(selected) != candidates.size()-1) {
				System.out.println(candidates.size());
				System.out.println(candidates.indexOf(selected));
				int selectedIndex = candidates.indexOf(selected);
				int belowselectedIndex = selectedIndex;
				belowselectedIndex++;
				String aboveselected = candidates.get(belowselectedIndex);

				candidates.set(belowselectedIndex, selected);
				candidates.set(selectedIndex, aboveselected);
				candidatesListView.getSelectionModel().select(belowselectedIndex);
			}
		});
		Button print = new Button(" print ");
		print.setOnAction((ActionEvent event) -> {
			String choosenbreakers[] = new String[heroes.size()];
			for (int i = 0; i < heroes.size(); i++) {
				choosenbreakers[i] = heroes.get(i);
			}
			for (String string : choosenbreakers) {
				System.out.println(string);
			}
			
			printSetup(candidatesListView, primaryStage);
		});
		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(sendRightButton, sendLeftButton, sendUp, senddown,print);

		gridpane.add(vbox, 1, 1);
		root.setCenter(gridpane);

		GridPane.setVgrow(root, Priority.ALWAYS);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void printSetup(Node node, Stage owner) 
	{
		// Create the PrinterJob		
		PrinterJob job = PrinterJob.createPrinterJob();
		//job.showPageSetupDialog(owner);
	
		if (job == null) 
		{
			return;
		}

		// Show the print setup dialog
		boolean proceed = job.showPrintDialog(owner);
		
		if (proceed) 
		{
			print(job, node);
		}
	}
	
	private void print(PrinterJob job, Node node) 
	{
		// Set the Job Status Message
		//jobStatus.textProperty().bind(job.jobStatusProperty().asString());
		
		// Print the node
		boolean printed = job.printPage(node);
	
		if (printed) 
		{
			job.endJob();
		}
	}	

	public static void main(String[] args) {
		launch(args);
	}

}
