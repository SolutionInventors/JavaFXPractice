package practice27.PrinterJobTest;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.Printer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxPrintExample2 extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage)
	{
		// Create the TextArea
		final TextArea textArea = new TextArea();
		// Create the Button
		Button button = new Button("Get the Default Printer");

		// Create the Event-Handlers for the Buttons
		button.setOnAction(new EventHandler <ActionEvent>() 
		{
            public void handle(ActionEvent event) 
            {
            	//Get the Default Printer
        		Printer defaultprinter = Printer.getDefaultPrinter();

        		if (defaultprinter != null) 
        		{
        			String name = defaultprinter.getName();
        			textArea.appendText("Default printer name: " + name);
        		} 
        		else 
        		{
        			textArea.appendText("No printers installed.");
        		}		
            }
        });
		
		// Create the VBox with a 10px spacing
		VBox root = new VBox(10);	
		// Add the Children to the VBox
		root.getChildren().addAll(button,textArea);	
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
		stage.setTitle("Show the default Printer");
		// Display the Stage
		stage.show();		
	}
}
