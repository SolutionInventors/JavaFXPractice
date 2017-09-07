package practice19.fadingScene;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SecondSceneController {
	@FXML
	private StackPane rootPane;
	Transition trans = new Transition();
	public void initialize() {
		Transition.FadeIn(rootPane);
		
		playTransition();
	}
	private void playTransition() {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(1000));
		ft.setNode(rootPane);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		
	}

	public void goBack(ActionEvent e) {
		makeFadeOut();
	}
	
	private void loadprevScene() {
		Parent sv;
		try {
			sv = (StackPane) FXMLLoader.load(getClass().getResource("FirstScene.fxml"));
			Scene ns = new Scene(sv);
			Stage cS = (Stage) rootPane.getScene().getWindow();
			cS.setScene(ns);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void makeFadeOut() {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(1000));
		ft.setNode(rootPane);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished(e->{
			loadprevScene();
		});
		ft.play();
	}
}
