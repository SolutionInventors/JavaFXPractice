/*package practice27.PrinterJobTest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXPrint extends Application {
    public static void main(String[] args) { launch(FXPrint.class); }

    @Override
    public void start(Stage stage) throws Exception {
        TableView<String> table = new TableView<>();
        for (int i = 0; i < 25; i++) {
            TableColumn<String, String> tc = new TableColumn<>("" + i);
            int index = i;
            tc.setCellValueFactory(param -> {
                String s = param.getValue();
                if (s.length() <= index) return new SimpleStringProperty();
                else return new SimpleStringProperty(s.substring(index, index + 1));
            });
            table.getColumns().add(tc);
        }
        for (int i = 0; i < 50; i++) table.getItems().add(i + "sdfghjklrthyjkcasdghasfdsfgdfgsdfggfdg");

        Button print =  new Button("print");
        print.setOnAction(e -> print(table));

        VBox box = new VBox(10, table, print);
        VBox.setVgrow(table, Priority.ALWAYS);
        stage.setScene(new Scene(box));
        stage.setWidth(600);
        stage.setHeight(1200);
        stage.show();
    }

    public void print(final TableView<?> table) {
        Printer printer = Printer.getAllPrinters().stream().filter(p -> p.getName().contains("Adobe")).findAny().get();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);

        PrinterJob job = PrinterJob.createPrinterJob(printer);
        if (job != null) {
            job.getJobSettings().setPageLayout(pageLayout);
            if (job.printPage(table)) {
                job.endJob();
            }
        }
    }
    
    public static List<Node> getLineRecordPages(Collection<LineRecord> lineRecords, PageLayout layout) {
        LinkedList<Node> result = new LinkedList<>();
        VBox node = null;
        double totalHeight = Double.POSITIVE_INFINITY;
        for (LineRecord record : lineRecords) {
            PrintLineRecordView view = new PrintLineRecordView();
            final PrintLineRecordPresenter presenter = (PrintLineRecordPresenter) view.getPresenter();
            presenter.bind(record);
            final double elementHeight = view.getView().prefHeight(layout.getPrintableWidth());
            if (elementHeight + totalHeight > layout.getPrintableHeight()) {
                node = new VBox();
                node.setMaxWidth(layout.getPrintableWidth());
                result.add(node);
                totalHeight = 0;
            }
            totalHeight+=elementHeight;
            if (node != null) {
                node.getChildren().add(view.getView());
            }
        }
        return result;
    }
}*/