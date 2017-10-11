package practice27.PrinterJobTest;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxPrintExample5 extends Application
{
	// Create the JobStatus Label	
	private final Label jobStatus = new Label();
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(final Stage stage)
	{
		// Create the Text Label
		Label textLabel = new Label("Please insert your Text:");

		// Create the TextArea
		final TextArea textArea = new TextArea();

		// Create the Buttons
		Button printSetupButton = new Button("Print Setup and Print");
		
		// Create the Event-Handlers for the Button
		printSetupButton.setOnAction(new EventHandler <ActionEvent>() 
		{
            public void handle(ActionEvent event) 
            {
            	printSetup(textArea, stage);
            }
        });
		
		// Create the Status Box
		HBox jobStatusBox = new HBox(5, new Label("Job Status: "), jobStatus);
		// Create the Button Box
		HBox buttonBox = new HBox(printSetupButton);
		
		// Create the VBox
		VBox root = new VBox(5);

		// Add the Children to the VBox		
		root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
		// Set the Size of the VBox
		root.setPrefSize(400, 300);		
		
		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");
		
		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A Printing Dialog Example");
		// Display the Stage
		stage.show();		
	}
	
	private void printSetup(Node node, Stage owner) 
	{
		// Create the PrinterJob		
		PrinterJob job = PrinterJob.createPrinterJob();
	
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
		jobStatus.textProperty().bind(job.jobStatusProperty().asString());
		
		// Print the node
		boolean printed = job.printPage(node);
	
		if (printed) 
		{
			job.endJob();
		}
	}	
}
