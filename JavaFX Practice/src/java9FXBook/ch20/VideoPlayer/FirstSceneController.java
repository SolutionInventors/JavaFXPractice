package java9FXBook.ch20.VideoPlayer;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FirstSceneController {
	@FXML private AnchorPane  rootPane;
	@FXML private Button mybtn;
	static int abc = 1;
	 @FXML
	   private void audioplayer(ActionEvent e) throws IOException {
		if (abc == 1) {
		 ((Node)e.getSource()).getScene().getWindow().hide();
		// loadNextScene(rootPane);
		 Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("VideoPlayer.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		//	Stage myStage = (Stage)mybtn.getScene().getWindow();
			//primaryStage.setOnHidden(t -> myStage.show());
			primaryStage.setTitle("Welcome hahaha");
			abc++;
			
		}
		else {
			 ((Node)e.getSource()).getScene().getWindow().hide();
		}
	   }
		@SuppressWarnings("unused")
		private void loadNextScene(Pane firstPane) {
			Parent sv;
			try {
				sv = (Pane) FXMLLoader.load(getClass().getResource("VideoPlayer.fxml"));
				Scene ns = new Scene(sv);
				
				Stage cS = (Stage) firstPane.getScene().getWindow();
				cS.setScene(ns);
			
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		}
}
