package practice25.TextViewlisten;

import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NewAniControl {
	@FXML
	private Group nodegroup;
	@FXML
	private AnchorPane root;
	
	

	
	public void set(Stage stage) {
		 createTickerControl(stage,78);
	}
	private void createTickerControl(Stage stage, double rightPadding) {
	    Scene scene = stage.getScene();
	   

	    // create ticker area
	 //   nodegroup = new Group();
	    Rectangle tickerRect = new Rectangle(30, 30);
	   tickerRect.setStyle(" -fx-arc-width: 15px;\r\n" + 
	   		"    -fx-arc-height: 20px;\r\n" + 
	   		"    -fx-fill: rgba(0,0,0, .55);\r\n" + 
	   		"    -fx-stroke: rgba(255, 255, 255, .70);\r\n" + 
	   		"    -fx-stroke-width: 1;\r\n" + 
	   		"    -fx-smooth: true;");
	   //button.setStyle("-fx-font-size: 30px;");

	    Rectangle clipRegion = new Rectangle(30, 30);
	    clipRegion.setStyle("-fx-arc-width: 15px;\r\n" + 
	    		"    -fx-arc-height: 20px;\r\n" + 
	    		"    -fx-stroke-width: 1;");
	    nodegroup.setClip(clipRegion);

	    // Resize the ticker area when the window is resized
	    nodegroup.setTranslateX(6);
	    nodegroup.translateYProperty()
	            .bind(scene.heightProperty()
	                       .subtract(tickerRect.getHeight() + 6));
	    tickerRect.widthProperty()
	              .bind(scene.widthProperty()
	                         .subtract(rightPadding));
	    clipRegion.widthProperty()
	              .bind(scene.widthProperty()
	                         .subtract(rightPadding));
	    nodegroup.getChildren().add(tickerRect);

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

	    nodegroup.getChildren().add(tickerContent);

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
	    stage.setOnShown( windowEvent -> {
	        tickerScroller.play();
	    });

	}
}
