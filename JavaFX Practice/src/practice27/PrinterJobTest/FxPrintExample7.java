package practice27.PrinterJobTest;
import javafx.print.JobSettings;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class FxPrintExample7 extends Application
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
		Button button = new Button("Get all Page Attributes");
		
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
		stage.setTitle("Showing all Page Layout Attributes");
		// Display the Stage
		stage.show();			
	}

	private void printAttributes()
	{
		// Create the Printer Job
		PrinterJob printerJob = PrinterJob.createPrinterJob();
		
		// Get The Printer Job Settings
		JobSettings jobSettings = printerJob.getJobSettings();
		
		// Get the Page Layout
		PageLayout pageLayout = jobSettings.getPageLayout();
		
		// Get the Page Attributes
		double pgW = pageLayout.getPrintableWidth();
		double pgH = pageLayout.getPrintableHeight();
		double pgLM = pageLayout.getLeftMargin();
		double pgRM = pageLayout.getRightMargin();
		double pgTM = pageLayout.getTopMargin();
		double pgBM = pageLayout.getBottomMargin();
		
		// Show the Page Attributes
		textArea.appendText("Printable Width: " + pgW + "\n");				
		textArea.appendText("Printable Height: " + pgH + "\n");	
		textArea.appendText("Page Left Margin: " + pgLM + "\n");	
		textArea.appendText("Page Right Margin: " + pgRM + "\n");	
		textArea.appendText("Page Top Margin: " + pgTM + "\n");	
		textArea.appendText("Page Bottom Margin: " + pgBM + "\n");	
		
		// Get The Printer
		Printer printer = printerJob.getPrinter();
		// Create the Page Layout of the Printer
		pageLayout = printer.createPageLayout(Paper.A4,
				PageOrientation.LANDSCAPE,Printer.MarginType.EQUAL);
		
		jobSettings.setPageLayout(pageLayout);
		
		// Get the Page Attributes
		pgW = pageLayout.getPrintableWidth();
		pgH = pageLayout.getPrintableHeight();
		pgLM = pageLayout.getLeftMargin();
		pgRM = pageLayout.getRightMargin();
		pgTM = pageLayout.getTopMargin();
		pgBM = pageLayout.getBottomMargin();
		
		// Show the Page Attributes
		textArea.appendText("Printable Width: " + pgW + "\n");				
		textArea.appendText("Printable Height: " + pgH + "\n");	
		textArea.appendText("Page Left Margin: " + pgLM + "\n");	
		textArea.appendText("Page Right Margin: " + pgRM + "\n");	
		textArea.appendText("Page Top Margin: " + pgTM + "\n");	
		textArea.appendText("Page Bottom Margin: " + pgBM + "\n");			
	}
	
}
