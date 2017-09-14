package practice19.fadingScene;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Transition {
	public void FadeOut(Pane firstPane, String fxmlfile ) {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(1000));
		ft.setNode(firstPane);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished(e->{
			loadNextScene(firstPane,fxmlfile);
		});
		ft.play();
	}
	
	//load next scene on the same window
	private void loadNextScene(Pane firstPane, String fxmlfile) {
		Parent stageView;
		try {
			stageView = (StackPane) FXMLLoader.load(getClass().getResource(fxmlfile));
			Scene ns = new Scene(stageView);
			
			Stage cS = (Stage) firstPane.getScene().getWindow();
			
			cS.setScene(ns);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
	
	public static void FadeIn(Pane firstPane) {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(1000));
		ft.setNode(firstPane);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		
	}

	
}//end class

