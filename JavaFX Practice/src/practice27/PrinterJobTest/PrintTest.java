package practice27.PrinterJobTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PrintTest extends Application {

  private NodePrinter printer = new NodePrinter();

  private Node nodeToPrint;

  private Rectangle printRectangle;

  private PrinterJob job;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    job = PrinterJob.createPrinterJob();

    BorderPane root = new BorderPane();

    Group pane = new Group();

    pane.getChildren().addAll(getNodeToPrint(), getPrintRectangle());

    Button printButton = new Button("Print!");
    printButton.setOnAction(this::print);
    root.setTop(new ToolBar(printButton));
    root.setCenter(pane);
    Scene scene = new Scene(root, 1800, 700, Color.GRAY);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void print(final ActionEvent actionEvent) {
    printer.setScale(3);
    printer.setPrintRectangle(getPrintRectangle());
    boolean success = printer.print(job, true, getNodeToPrint());
    if (success) {
      job.endJob();
    }
  }

  private Rectangle getPrintRectangle() {
    if (printRectangle == null) {
      printRectangle = new Rectangle(600, 500, null);
      printRectangle.setStroke(Color.BLACK);
    }
    return printRectangle;
  }

  private Node getNodeToPrint() {
    if (nodeToPrint == null) {

      Group group = new Group();
      group.getChildren().addAll(
          new Rectangle(200, 100, Color.RED),
          new Rectangle(200,100, 200, 100),
          new Rectangle(400, 200, 200, 100),
          new Rectangle(600, 300, 200, 100),
          new Rectangle(800, 400, 200, 100)
      );

      nodeToPrint = group;
    }
    return nodeToPrint;
  }
}