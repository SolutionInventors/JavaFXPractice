package practice27.PrinterJobTest;


import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SimplePrintingTest extends Application {

  private PrinterJob job = PrinterJob.createPrinterJob();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    BorderPane pane = new BorderPane();

    final Rectangle rect = new Rectangle(0, 0, 1000, 1000);
    pane.setCenter(rect);

    final ToolBar value = new ToolBar();

    final Button print = new Button("print");
    final Button dialog = new Button("print dialog");
    final Button pageLayout = new Button("page layout settings");
    value.getItems().add(print);
    value.getItems().add(dialog);
    value.getItems().add(pageLayout);
    print.setOnAction(event -> print(pane));
    dialog.setOnAction(event -> showPrintDialog(primaryStage));
    pageLayout.setOnAction(event -> showPageSetupDialog(primaryStage));

    pane.setTop(value);
    Scene scene = new Scene(pane, 1200, 1024, Color.GRAY);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void print(Node node) {
    if (job != null) {      
      // -- ???
      boolean success = job.printPage(node);
      if (success) {
        job.endJob();
        job = PrinterJob.createPrinterJob();
      }
    }
  }

  public void showPageSetupDialog(Stage stage) {
    if (job != null) {
      job.showPageSetupDialog(stage);
    }
  }

  public void showPrintDialog(Stage stage) {
    if (job != null) {
      job.showPrintDialog(stage);
    }
  }
}