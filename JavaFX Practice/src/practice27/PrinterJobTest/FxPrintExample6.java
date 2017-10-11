package practice27.PrinterJobTest;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.Collation;
import javafx.print.JobSettings;
import javafx.print.PageOrientation;
import javafx.print.PrintSides;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxPrintExample6 extends Application
{
	// Create the TextArea
	final TextArea textArea = new TextArea();
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage)
	{
		// Create the Button
		Button button = new Button("Get all Printer Attributes");
		
		// Create the Event-Handlers for the Buttons
		button.setOnAction(new EventHandler <ActionEvent>() 
		{
            public void handle(ActionEvent event) 
            {
            	printAttributes();
            }
        });
		
		// Create the VBox with a 10px spacing
		VBox root = new VBox(10);	
		// Add the Children to the VBox
		root.getChildren().addAll(button, textArea);	
		// Set the Size of the VBox
		root.setPrefSize(400, 250);		
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
		stage.setTitle("Showing all Printer Attributes");
		// Display the Stage
		stage.show();			
	}
	
	private void printAttributes()
	{
		// Get the Default Printer
		Printer printer = Printer.getDefaultPrinter();
		// Get the Printer Attributes
		PrinterAttributes attribs = printer.getPrinterAttributes();

		// Read some printer attributes
		int maxCopies = attribs.getMaxCopies();
		PrintSides printSides = attribs.getDefaultPrintSides();
		Set<PageOrientation> orientations = attribs.getSupportedPageOrientations();
		Set<Collation> collations = attribs.getSupportedCollations();
		
		// Print the printer attributes
		textArea.appendText("Max. Copies: " + maxCopies + "\n");
		textArea.appendText("Print Sides: " + printSides + "\n");
		textArea.appendText("Supported Orientation: " + orientations + "\n");
		textArea.appendText("Supported Collations: " + collations + "\n");
		
		// Create a printer job for the default printer
		PrinterJob job = PrinterJob.createPrinterJob();
		// Get the JobSettings for the print job
		JobSettings jobSettings = job.getJobSettings();
		
		// Print the printer attributes
		textArea.appendText("Print Sides: " + jobSettings.getPrintSides() + "\n");
		
		// Set the printSides to DUPLEX
		jobSettings.setPrintSides(PrintSides.DUPLEX);
		
		// Print the printer attributes
		textArea.appendText("Print Sides: " + jobSettings.getPrintSides() + "\n");				
	}
}
