package practice24.Animation;

import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class finalTestController {
	@FXML AnchorPane root;
	
	public void load() {
		System.out.println("i am called");
		Stage cS = (Stage) root.getScene().getWindow();
		Group newsTicker = createTickerControl(cS, 78);
		root.getChildren().add(newsTicker);
	}
	
	private Group createTickerControl(Stage stage, double rightPadding) {
	    Scene scene = stage.getScene();

	    // create ticker area
	    Group tickerArea = new Group();
	    Rectangle tickerRect = new Rectangle(scene.getWidth(), 30);
	    tickerRect.getStyleClass().add("ticker-border");

	    Rectangle clipRegion = new Rectangle(scene.getWidth(), 30);
	    clipRegion.getStyleClass().add("ticker-clip-region");
	    tickerArea.setClip(clipRegion);

	    // Resize the ticker area when the window is resized
	    tickerArea.setTranslateX(6);
	    tickerArea.translateYProperty()
	            .bind(scene.heightProperty()
	                       .subtract(tickerRect.getHeight() + 6));
	    tickerRect.widthProperty()
	              .bind(scene.widthProperty()
	                         .subtract(rightPadding));
	    clipRegion.widthProperty()
	              .bind(scene.widthProperty()
	                         .subtract(rightPadding));
	    tickerArea.getChildren().add(tickerRect);

	    // news feed container
	    FlowPane tickerContent = new FlowPane();

	    // add some news
	    Text news = new Text();
	    news.setText("JavaFX 8.0 News! | 85 and sunny | :)");
	    news.setFill(Color.WHITE);
	    tickerContent.getChildren().add(news);

	    DoubleProperty centerContentY = new SimpleDoubleProperty();
	    centerContentY.bind(
	            clipRegion.heightProperty()
	                      .divide(2)
	                      .subtract(tickerContent.heightProperty()
	                                             .divide(2)));

	    tickerContent.translateYProperty().bind(centerContentY);

	    tickerArea.getChildren().add(tickerContent);

	    // scroll news feed 
	    TranslateTransition tickerScroller = new TranslateTransition();
	    tickerScroller.setNode(tickerContent);
	    tickerScroller.setDuration(
	            Duration.millis(scene.getWidth() * 40));
	    tickerScroller.fromXProperty()
	                  .bind(scene.widthProperty());
	    tickerScroller.toXProperty()
	                  .bind(tickerContent.widthProperty()
	                                  .negate());

	    // when ticker has finished reset and replay ticker animation
	    tickerScroller.setOnFinished((ActionEvent ae) -> {
	        tickerScroller.stop();
	        tickerScroller.setDuration(
	            Duration.millis(scene.getWidth() * 40));
	        tickerScroller.playFromStart();
	    });
	    // start ticker after nodes are shown.
	   /* stage.setOnShown( windowEvent -> {
	        tickerScroller.play();
	    });*/
	    tickerScroller.play();
	    return tickerArea;
	}
	 
}
