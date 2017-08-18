package practice013.Spinner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SpinnerDemo extends Application {

	@Override
	public void start(Stage stage) {

		Label label = new Label("Select Level:");
		final Spinner<Integer> spinner = new Spinner<Integer>();

		final int initialValue = 3;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactory = 
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);

		spinner.setValueFactory(valueFactory);

		FlowPane root = new FlowPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10));

		root.getChildren().addAll(label, spinner);

		Scene scene = new Scene(root, 400, 200);

		stage.setTitle("JavaFX Spinner (o7planning.org)");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}