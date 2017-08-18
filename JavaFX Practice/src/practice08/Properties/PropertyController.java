package practice08.Properties;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class PropertyController implements Initializable{

	MyNumber myNum = new MyNumber();
	
	@FXML
	private Label lblStatus;
	
	@FXML
	private ProgressBar probar;
	
	@FXML
	private ProgressIndicator proincator;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myNum.setNumber(0.0);
		myNum.numberProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				lblStatus.setText(new Double(myNum.getNumber()).toString());
				probar.progressProperty().bind(myNum.numberProperty());
				proincator.progressProperty().bind(myNum.numberProperty());
			}
			
		});
	}//end initialize
	
	public void BtnClick(ActionEvent e) {
		myNum.setNumber(myNum.getNumber() + 0.1);
	}
	public void Btn2Click(ActionEvent e) {
		myNum.setNumber(myNum.getNumber() - 0.1);
	}

}
