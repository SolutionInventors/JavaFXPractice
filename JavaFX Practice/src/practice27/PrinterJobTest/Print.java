package practice27.PrinterJobTest;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Print extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Node node = new Circle(100, 200, 200);
		PrinterJob job = PrinterJob.createPrinterJob();
		if (job != null) {
			boolean success = job.printPage(node); 
			if (success) {
				job.endJob();
			}
		}

	}
}