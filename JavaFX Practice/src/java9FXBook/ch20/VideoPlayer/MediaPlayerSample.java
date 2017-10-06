package java9FXBook.ch20.VideoPlayer;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class MediaPlayerSample extends Application {

    private MediaPlayer player;
    private final ToggleButton playButton = new ToggleButton("Play");
    private final ToggleButton pauseButton = new ToggleButton("Pause");
    private final ToggleGroup group = new ToggleGroup();
    private final Label totalDuration = new Label();
    private final Label currentDuration = new Label();
    private final DecimalFormat formatter = new DecimalFormat("00.00");
    private final SliderBar timeSlider = new SliderBar();
    private Duration totalTime;

    @Override
    public void start(Stage primaryStage)
    {
        //Add a scene
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: ANTIQUEWHITE");

        HBox playPause = new HBox(playButton, pauseButton);
        HBox sliderBox = new HBox(timeSlider, currentDuration, totalDuration);

        HBox.setHgrow(sliderBox, Priority.ALWAYS);

        root.getChildren().addAll(sliderBox, playPause);
        Scene scene = new Scene(root, 300, 100);

        Media pick = new Media(getClass().getResource("don.mp3").toExternalForm());
        player = new MediaPlayer(pick);

        // Play the track and select the playButton
        player.play();
        playButton.setSelected(true);



        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                timeSlider
                        .sliderValueProperty()
                        .setValue(newValue.divide(totalTime.toMillis()).toMillis() * 100.0);
                currentDuration.setText(String.valueOf(formatter.format(newValue.toSeconds())));
            }
        });

        player.setOnReady(() -> {
            // Set the total duration
            totalTime = player.getMedia().getDuration();
            totalDuration.setText(" / " + String.valueOf(formatter.format(Math.floor(totalTime.toSeconds()))));
        });

        // Slider Binding
        timeSlider.sliderValueProperty().addListener((ov) -> {
            if (timeSlider.isTheValueChanging()) {
                if (null != player)
                    // multiply duration by percentage calculated by
                    // slider position
                    player.seek(totalTime.multiply(timeSlider
                            .sliderValueProperty().getValue() / 100.0));
                else
                    timeSlider.sliderValueProperty().setValue(0);
            }
        });


        //Applying Toggle Group to Buttons
        playButton.setToggleGroup(group);
        pauseButton.setToggleGroup(group);

        // Action for Buttons
        playButton.setOnAction(e -> {
            play();
        });

        pauseButton.setOnAction(e -> {
            pause();
        });

        //show the stage
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void play(){
        player.play();
        playButton.setSelected(true);
    }

    public void pause(){
        player.pause();
        playButton.setSelected(false);
    }


    private class SliderBar extends StackPane {

        private Slider slider = new Slider();

        private ProgressBar progressBar = new ProgressBar();

        public SliderBar() {
            getChildren().addAll(progressBar, slider);
            bindValues();
        }
        private void bindValues(){
            progressBar.prefWidthProperty().bind(slider.widthProperty());
            progressBar.progressProperty().bind(slider.valueProperty().divide(100));
        }

        public DoubleProperty sliderValueProperty() {
            return slider.valueProperty();
        }

        public boolean isTheValueChanging() {
            return slider.isValueChanging();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}