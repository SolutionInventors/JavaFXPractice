package practice11.FromJFXBook;

import java.net.MalformedURLException;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * Chapter 7 Playing Audio using JavaFX media API.
 *
 * @author cdea
 */
public class PlayingAudio extends Application {
	private MediaPlayer mediaPlayer;
	private Point2D anchorPt;
	private Point2D previousLocation;
	private ChangeListener<Duration> progressListener;
	private static Stage PRIMARY_STAGE;
	private static final String STOP_BUTTON_ID = "stop-button";
	private static final String PLAY_BUTTON_ID = "play-button";
	private static final String PAUSE_BUTTON_ID = "pause-button";
	private static final String CLOSE_BUTTON_ID = "close-button";
	private static final String VIS_CONTAINER_ID = "viz-container";
	private static final String SEEK_POS_SLIDER_ID = "seek-position-slider";

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		PRIMARY_STAGE = primaryStage;
		PRIMARY_STAGE.initStyle(StageStyle.TRANSPARENT);
		PRIMARY_STAGE.centerOnScreen();
		Group root = new Group();
		Scene scene = new Scene(root, 551, 270, Color.rgb(0, 0, 0, 0));
		// load JavaFX CSS style
		scene.getStylesheets().add(getClass().getResource("playing-audio.css").toExternalForm());
		PRIMARY_STAGE.setScene(scene);
		// Initialize stage to be movable via mouse
		initMovablePlayer();
		// application area
		Node applicationArea = createApplicationArea();
		// Container for random circles bouncing about
		Node vizContainer = new Group();
		vizContainer.setId(VIS_CONTAINER_ID);
		// Create the button panel
		Node buttonPanel = createButtonPanel();
		// Progress and seek position slider
		Slider progressSlider = createSlider();
		// Update slider as video is progressing
		progressListener = (observable, oldValue, newValue) -> progressSlider.setValue(newValue.toSeconds());
		// Initializing to accept files
		// dragged over surface to load media
		initFileDragNDrop();
		// Create the close button
		Node closeButton = createCloseButton();
		root.getChildren().addAll(applicationArea, vizContainer, buttonPanel, progressSlider, closeButton);
		primaryStage.show();
	}

	/**
	 * Initialize the stage to allow the mouse cursor to move the application using
	 * dragging.
	 *
	 */
	private void initMovablePlayer() {
		Scene scene = PRIMARY_STAGE.getScene();
		// starting initial anchor point
		scene.setOnMousePressed(mouseEvent -> anchorPt = new Point2D(mouseEvent.getScreenX(), mouseEvent.getScreenY()));
		// dragging the entire stage
		scene.setOnMouseDragged(mouseEvent -> {
			if (anchorPt != null && previousLocation != null) {
				PRIMARY_STAGE.setX(previousLocation.getX() + mouseEvent.getScreenX() - anchorPt.getX());
				PRIMARY_STAGE.setY(previousLocation.getY() + mouseEvent.getScreenY() - anchorPt.getY());
			}
		});
		// set the current location
		scene.setOnMouseReleased(
				mouseEvent -> previousLocation = new Point2D(PRIMARY_STAGE.getX(), PRIMARY_STAGE.getY()));
		// Initialize previousLocation after Stage is shown
		PRIMARY_STAGE.addEventHandler(WindowEvent.WINDOW_SHOWN, (WindowEvent t) -> {
			previousLocation = new Point2D(PRIMARY_STAGE.getX(), PRIMARY_STAGE.getY());
		});
	}

	/**
	 * A simple rectangular area as the surface of the app.
	 * 
	 * @return Node a Rectangle node.
	 */
	private Node createApplicationArea() {
		Scene scene = PRIMARY_STAGE.getScene();
		Rectangle applicationArea = new Rectangle();
		// add selector to style app-area
		applicationArea.setId("app-area");
		// make the app area rectangle the size of the scene.
		applicationArea.widthProperty().bind(scene.widthProperty());
		applicationArea.heightProperty().bind(scene.heightProperty());
		return applicationArea;
	}

	/**
	 * Initialize the Drag and Drop ability for media files.
	 *
	 */
	private void initFileDragNDrop() {
		Scene scene = PRIMARY_STAGE.getScene();
		scene.setOnDragOver(dragEvent -> {
			Dragboard db = dragEvent.getDragboard();
			if (db.hasFiles() || db.hasUrl()) {
				dragEvent.acceptTransferModes(TransferMode.LINK);
			} else {
				dragEvent.consume();
			}
		});
		// Dropping over surface
		scene.setOnDragDropped(dragEvent -> {
			Dragboard db = dragEvent.getDragboard();
			boolean success = false;
			String filePath = null;
			// String path = new File("src/audio/study.mp3").getAbsolutePath();
			if (db.hasFiles()) {
				success = true;
				if (db.getFiles().size() > 0) {
					try {
						filePath = db.getFiles().get(0).toURI().toURL().toString();
						playMedia(filePath);
					} catch (MalformedURLException ex) {
						ex.printStackTrace();
					}
				}
			} else {
				// audio file from some host or jar
				playMedia(db.getUrl());// i removed their ref
				// playMedia(path);
				success = true;
			}
			dragEvent.setDropCompleted(success);
			dragEvent.consume();
		}); // end of setOnDragDropped
	}

	/**
	 * Creates a node containing the audio player's stop, pause and play buttons.
	 *
	 * @return Node A button panel having play, pause and stop buttons.
	 */
	private Node createButtonPanel() {
		Scene scene = PRIMARY_STAGE.getScene();
		// create button control panel
		Group buttonGroup = new Group();
		// Button area
		Rectangle buttonArea = new Rectangle(60, 30);
		buttonArea.setId("button-area");
		buttonGroup.getChildren().add(buttonArea);
		// stop button control
		Node stopButton = new Rectangle(10, 10);
		stopButton.setId(STOP_BUTTON_ID);
		stopButton.setOnMousePressed(mouseEvent -> {
			if (mediaPlayer != null) {
				updatePlayAndPauseButtons(true);
				if (mediaPlayer.getStatus() == Status.PLAYING) {
					mediaPlayer.stop();
				}
			}
		}); // setOnMousePressed()
		// play button
		Arc playButton = new Arc(12, // center x
				16, // center y
				15, // radius x
				15, // radius y
				150, // start angle
				60); // length

		playButton.setId(PLAY_BUTTON_ID);
		playButton.setType(ArcType.ROUND);
		playButton.setOnMousePressed(mouseEvent -> mediaPlayer.play());
		// pause control
		Group pauseButton = new Group();
		pauseButton.setId(PAUSE_BUTTON_ID);
		Node pauseBackground = new Circle(12, 16, 10);
		pauseBackground.getStyleClass().add("pause-circle");
		Node firstLine = new Line(6, // start x
				6, // start y
				6, // end x
				14); // end y
		firstLine.getStyleClass().add("pause-line");
		firstLine.setStyle("-fx-translate-x: 34;");
		Node secondLine = new Line(6, // start x
				6, // start y
				6, // end x
				14); // end y
		secondLine.getStyleClass().add("pause-line");
		secondLine.setStyle("-fx-translate-x: 38;");
		pauseButton.getChildren().addAll(pauseBackground, firstLine, secondLine);
		pauseButton.setOnMousePressed(mouseEvent -> {
			if (mediaPlayer != null) {
				updatePlayAndPauseButtons(true);
				if (mediaPlayer.getStatus() == Status.PLAYING) {
					mediaPlayer.pause();
				}
			}
		}); // setOnMousePressed()
		playButton.setOnMousePressed(mouseEvent -> {
			if (mediaPlayer != null) {
				updatePlayAndPauseButtons(false);
				mediaPlayer.play();
			}
		}); // setOnMousePressed()
		buttonGroup.getChildren().addAll(stopButton, playButton, pauseButton);
		// move button group when scene is resized
		buttonGroup.translateXProperty().bind(scene.widthProperty().subtract(buttonArea.getWidth() + 6));
		buttonGroup.translateYProperty().bind(scene.heightProperty().subtract(buttonArea.getHeight() + 6));
		return buttonGroup;
	}

	/**
	 * The close button to exit application
	 *
	 * @return Node representing a close button.
	 */
	private Node createCloseButton() {
		Scene scene = PRIMARY_STAGE.getScene();
		Group closeButton = new Group();
		closeButton.setId(CLOSE_BUTTON_ID);
		Node closeBackground = new Circle(5, 0, 7);
		closeBackground.setId("close-circle");
		Node closeXmark = new Text(2, 4, "X");
		closeButton.translateXProperty().bind(scene.widthProperty().subtract(15));
		closeButton.setTranslateY(10);
		closeButton.getChildren().addAll(closeBackground, closeXmark);
		// exit app
		closeButton.setOnMouseClicked(mouseEvent -> Platform.exit());
		return closeButton;
	}

	/**
	 * After a file is dragged onto the application a new MediaPlayer instance is
	 * created with a media file.
	 *
	 * @param stage
	 *            The stage window (primaryStage)
	 * @param url
	 *            The URL pointing to an audio file
	 */
	private void playMedia(String url) {
		Scene scene = PRIMARY_STAGE.getScene();
		if (mediaPlayer != null) {
			mediaPlayer.pause();
			mediaPlayer.setOnPaused(null);
			mediaPlayer.setOnPlaying(null);
			mediaPlayer.setOnReady(null);
			mediaPlayer.currentTimeProperty().removeListener(progressListener);
			mediaPlayer.setAudioSpectrumListener(null);
		}
		Media media = new Media(url);
		// display media's metadata
		for (String s : media.getMetadata().keySet()) {
			System.out.println(s);
		}
		mediaPlayer = new MediaPlayer(media);
		// as the media is playing move the slider for progress
		mediaPlayer.currentTimeProperty().addListener(progressListener);
		mediaPlayer.setOnReady(() -> {
			updatePlayAndPauseButtons(false);
			Slider progressSlider = (Slider) scene.lookup("#" + SEEK_POS_SLIDER_ID);
			progressSlider.setValue(0);
			progressSlider.setMax(mediaPlayer.getMedia().getDuration().toSeconds());
			mediaPlayer.play();
		}); // setOnReady()
		// back to the beginning
		mediaPlayer.setOnEndOfMedia(() -> {
			updatePlayAndPauseButtons(true);
			// change buttons to play and rewind
			mediaPlayer.stop();
		}); // setOnEndOfMedia()
		// setup visualization (circle container)
		Group vizContainer = (Group) PRIMARY_STAGE.getScene().lookup("#" + VIS_CONTAINER_ID);
		mediaPlayer
				.setAudioSpectrumListener((double timestamp, double duration, float[] magnitudes, float[] phases) -> {
					vizContainer.getChildren().clear();
					int i = 0;
					int x = 10;
					double y = PRIMARY_STAGE.getScene().getHeight() / 2;
					Random rand = new Random(System.currentTimeMillis());
					// Build random colored circles
					for (float phase : phases) {
						int red = rand.nextInt(255);
						int green = rand.nextInt(255);
						int blue = rand.nextInt(255);
						Circle circle = new Circle(10);
						circle.setCenterX(x + i);
						circle.setCenterY(y + (phase * 100));
						circle.setFill(Color.rgb(red, green, blue, .70));
						vizContainer.getChildren().add(circle);
						i += 5;
					}
				}); // setAudioSpectrumListener()
	}

	/**
	 * Sets play button visible and pause button not visible when playVisible is
	 * true otherwise the opposite.
	 ** 
	 * @param playVisible
	 *            - value of true the play becomes visible and pause non visible,
	 *            otherwise the opposite.
	 */
	private void updatePlayAndPauseButtons(boolean playVisible) {
		Scene scene = PRIMARY_STAGE.getScene();
		Node playButton = scene.lookup("#" + PLAY_BUTTON_ID);
		Node pauseButton = scene.lookup("#" + PAUSE_BUTTON_ID);
		// hide or show buttons
		playButton.setVisible(playVisible);
		pauseButton.setVisible(!playVisible);
		if (playVisible) {
			// show play button
			playButton.toFront();
			pauseButton.toBack();
		} else {
			// show pause button
			pauseButton.toFront();
			playButton.toBack();
		}
	}

	/**
	 * A position slider to seek backward and forward that is bound to a media
	 * player control.
	 *
	 * @return Slider control bound to media player.
	 */
	private Slider createSlider() {
		Slider slider = new Slider(0, 100, 1);
		slider.setId(SEEK_POS_SLIDER_ID);
		slider.valueProperty().addListener((observable) -> {
			if (slider.isValueChanging()) {
				// must check if media is paused before seeking
				if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
					// convert seconds to millis
					double dur = slider.getValue() * 1000;
					mediaPlayer.seek(Duration.millis(dur));
				}
			}
		}); // addListener()
		Scene scene = PRIMARY_STAGE.getScene();
		slider.setTranslateX(10);
		slider.translateYProperty().bind(scene.heightProperty().subtract(50));
		return slider;
	}
}
