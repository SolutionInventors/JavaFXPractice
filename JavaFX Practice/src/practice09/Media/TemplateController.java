package practice09.Media;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TemplateController {
	@FXML
	private Button btnplay;
	@FXML
	private Button btnstop;
	@FXML
	private Button btnchangesong;
	@FXML
	private Slider seekslider;
	@FXML
	private Slider volumeSlider;
	private boolean playing;
	MediaPlayer mediaPlayer;

	public void initialize() {
		seekslider.valueProperty()
         .addListener((observable) -> {
             if (seekslider.isValueChanging()) {
               // must check if media is paused before seeking 
               if (mediaPlayer != null && 
                   mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                  
                  // convert seconds to millis
                  double dur = seekslider.getValue() * 1000;
                  mediaPlayer.seek(Duration.millis(dur));
               }
             }
         }); //addListener()
		
		
		playsong("C:\\Users\\Knight\\Music\\Ave Maria.mp3");
		mediaPlayer.setVolume(.7);// just to set the volume to about 70%
		volumeSlider.setValue(mediaPlayer.getVolume() * 100);// this multiplication is done cos the getvol retruns 0 to
																// 1
		// while the slider uses 1 to 100
		volumeSlider.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable arg0) {
				mediaPlayer.setVolume(volumeSlider.getValue() / 100);
			}

		});
	
	 
       /*  seekslider.setValue(0);
         seekslider.setMax(mediaPlayer.getMedia()
                                          .getDuration()
                                          .toSeconds());*/
	
	}

	@FXML
	private void playPauseButtonPressed(ActionEvent e) {
		playing = !playing;

		if (playing) {
			btnplay.setText("Pause");
			mediaPlayer.play();
		} else {
			btnplay.setText("Play");
			mediaPlayer.pause();
		}
	}

	@FXML
	private void stop(ActionEvent e) {
		mediaPlayer.stop();
		playing = false;
		btnplay.setText("Play");

	}

	private void playsong(String path) {
		/*
		 * String path = new File("src/video/AI.mp4").getAbsolutePath(); me = new
		 * Media(new File(path).toURI().toString());
		 */

		// URL resource = getClass().getResource("/audio/study.mp3");
		// Media media = new Media(path.toString());
		if (mediaPlayer != null) {
			stop(null);
		}

		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		playing = true;
		btnplay.setText("Pause");
	}

	public void changeSong() throws MalformedURLException {
		FileChooser fc = new FileChooser();
		Stage primaryStage = new Stage();
		File seletedfile = fc.showOpenDialog(primaryStage);
		// for the song
		String path = seletedfile.getAbsolutePath();
		playsong(path);

	}
}
