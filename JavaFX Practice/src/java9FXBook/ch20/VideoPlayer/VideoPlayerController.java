package java9FXBook.ch20.VideoPlayer;
import java.io.IOException;
// VideoPlayerController.java
// Using Media, MediaPlayer and MediaView to play a video. 
import java.net.URL;

import org.controlsfx.dialog.ExceptionDialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VideoPlayerController {  
   //@FXML private MediaView mediaView;
   @FXML private Button playPauseButton;
   @FXML private Button btnhide;
   private MediaPlayer mediaPlayer;
   private boolean playing = false;
   @FXML private BorderPane  rootPane;
   public void initialize() {
      // get URL of the video file
      URL url = VideoPlayerController.class.getResource("sts117.mp4");
    //  URL url = VideoPlayerController.class.getResource("don.mp3");
     
      
      // create a Media object for the specified URL
      Media media = new Media(url.toExternalForm());
      
      // create a MediaPlayer to control Media playback
      mediaPlayer = new MediaPlayer(media);
      
      // specify which MediaPlayer to display in the MediaView
   //   mediaView.setMediaPlayer(mediaPlayer); 

      // set handler to be called when the video completes playing
      mediaPlayer.setOnEndOfMedia(
         new Runnable() {
            public void run() {
               playing = false;
               playPauseButton.setText("Play");
               mediaPlayer.seek(Duration.ZERO);
               mediaPlayer.pause();
            }
         }
      );
 
      // set handler that displays an ExceptionDialog if an error occurs
      mediaPlayer.setOnError(
         new Runnable() {
            public void run() {
               ExceptionDialog dialog = new ExceptionDialog(mediaPlayer.getError());
               dialog.showAndWait();
            }
         }
      );
      
      // set handler that resizes window to video size once ready to play
     /* mediaPlayer.setOnReady(
         new Runnable() {
            public void run() {
               DoubleProperty width = mediaView.fitWidthProperty();
               DoubleProperty height = mediaView.fitHeightProperty();
               width.bind(Bindings.selectDouble(
                  mediaView.sceneProperty(), "width"));
               height.bind(Bindings.selectDouble(
                  mediaView.sceneProperty(), "height")); 
            }
         }
      );*/
   }  
   
   // toggle media playback and the text on the playPauseButton
   @FXML
   private void playPauseButtonPressed(ActionEvent e) {
      playing = !playing;

      if (playing) {
         playPauseButton.setText("Pause");
         mediaPlayer.play();
      }
      else {
         playPauseButton.setText("Play");
         mediaPlayer.pause();
      }
   } 

   @FXML
   private void hideMe(ActionEvent e) throws IOException {
	   ((Node)e.getSource()).getScene().getWindow().hide();
		// loadNextScene(rootPane);
		 Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("FirstScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage myStage = (Stage)btnhide.getScene().getWindow();
			primaryStage.setOnHidden(t -> myStage.show());
			primaryStage.setTitle("Welcome hahaha");
			
			
   }
   private void loadNextScene(Pane firstPane) {
		Parent sv;
		try {
			sv = (Pane) FXMLLoader.load(getClass().getResource("FirstScene.fxml"));
			Scene ns = new Scene(sv);
			
			Stage cS = (Stage) firstPane.getScene().getWindow();
			cS.setScene(ns);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
}

