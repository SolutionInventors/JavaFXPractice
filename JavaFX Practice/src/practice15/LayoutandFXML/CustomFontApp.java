/**
 * @author Chinedu Oguejiofor
 *6 Sep. 2017
 * 3:49:45 pm
 */
package practice15.LayoutandFXML;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

// demonstrates the use of a custom font.
public class CustomFontApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("TRON Synopsis");

		// load the tron font.
		Font.loadFont("/practice15/LayoutandFXML/TRON.TTF", 10);

		Label title = new Label("TRON");
		title.getStyleClass().add("title");

		Label caption = new Label("A sci-fi flick set in an alternate reality.");
		caption.getStyleClass().add("caption");
		caption.setMaxWidth(220);
		caption.setWrapText(true);
		caption.setTextAlignment(TextAlignment.CENTER);

		VBox layout = new VBox(10);
		layout.setStyle("-fx-padding: 20px; -fx-background-color: silver");
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().setAll(title,
				new ImageView(new Image(
						"http://ia.media-imdb.com/images/M/MV5BMTY5NjM2MjAwOV5BMl5BanBnXkFtZTYwMTgyMzA5.V1.SY317.jpg")),
				caption);

		// layout the scene.
		final Scene scene = new Scene(layout);
		scene.getStylesheets().add(getClass().getResource("custom-font-styles.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}