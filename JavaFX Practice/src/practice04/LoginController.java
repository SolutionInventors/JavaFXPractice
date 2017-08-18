/**
 * @author ChineduKnight Oguejiofor
 *20 Jul. 2017
 * 6:22:11 pm
 */
package practice04;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Label lblstatus;
	
	@FXML 
	private TextField txtpassword;
	
	@FXML 
	private TextField txtusername;
	
	public void Login(ActionEvent e) throws IOException {
		if (txtusername.getText().equals("user") && txtpassword.getText().equals("pass")) {
			lblstatus.setText("Login Successful. Welcome");
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Welcome hahaha");
		}else
			lblstatus.setText("Who are you??");
	}
	
	
}
