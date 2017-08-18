package practice09.Media;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController implements Initializable {
	@FXML
	private MediaView mv;
	private MediaPlayer mp;
	private Media me;
	private Double speed = 1.0;
	
	@FXML Slider volumeSlider;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String path = new File("src/video/AI.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		mp.setVolume(.7);//just to set the volume to about 70%
		volumeSlider.setValue(mp.getVolume()*100);//this multiplication is done cos the getvol retruns 0 to 1
		//while the slider uses 1 to 100
		volumeSlider.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable arg0) {
				mp.setVolume(volumeSlider.getValue()/100);
			}
			
		});
	
	}//end initialize
	
	public void play(ActionEvent e) {
		mp.play();
	}
	
	public void pause(ActionEvent e) {
		mp.pause();
	}

	
	public void fast(ActionEvent e) {
		speed+=.1;
		mp.setRate(speed);
	}

	
	public void slow(ActionEvent e) {
		speed-=.1;
		mp.setRate(speed);
	}

	
	public void reload(ActionEvent e) {
		mp.seek(mp.getStartTime());
		mp.play();
	}

	
	public void start(ActionEvent e) {
		mp.seek(mp.getStartTime());
		mp.stop();
	}

	
	public void last(ActionEvent e) {
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}

	
	

}
