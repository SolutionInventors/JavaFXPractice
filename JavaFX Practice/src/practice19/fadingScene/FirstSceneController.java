package practice19.fadingScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class FirstSceneController {
	@FXML
	private StackPane firstPane;
	Transition trans = new Transition();

	
	
	
	public void initialize() {
		firstPane.setOpacity(0);
		Transition.FadeIn(firstPane);
	}

	
	
	// Event Listener on Button.onAction
	@FXML
	public void btnClicked(ActionEvent event) {
	trans.FadeOut(firstPane, "SecondScene.fxml");
	}

/*	private void makeFadeOut() {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(1000));
		ft.setNode(firstPane);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished(e->{
			loadNextScene();
		});
		ft.play();
	}
	
	private void loadNextScene() {
		Parent sv;
		try {
			sv = (StackPane) FXMLLoader.load(getClass().getResource("SecondScene.fxml"));
			Scene ns = new Scene(sv);
			
			Stage cS = (Stage) firstPane.getScene().getWindow();
			
			cS.setScene(ns);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}


private void playTransition() {
	FadeTransition ft = new FadeTransition();
	ft.setDuration(Duration.millis(1000));
	ft.setNode(firstPane);
	ft.setFromValue(0);
	ft.setToValue(1);
	ft.play();
	
}
*/
}