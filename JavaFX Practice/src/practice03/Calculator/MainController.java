/**
 * @author ChineduKnight Oguejiofor
 *20 Jul. 2017
 * 12:35:33 pm
 */
package practice03.Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label result;
	private long num1 = 0;
	private String operator = "";
	private boolean start = true;
	Model model = new Model();
	
	
	
	@FXML
	public void processnumber(ActionEvent e) {
		if (start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)e.getSource()).getText();
		result.setText(result.getText()+value);
	}
	@FXML
	public void processoperator(ActionEvent e) {
		String value = ((Button)e.getSource()).getText();
		if (!value.equals("=")) {
			if (!operator.isEmpty()) 
				return;
			
			operator = value;
			num1= Long.parseLong(result.getText());
			result.setText("");
			
		}else {
			if (operator.isEmpty()) 
				return;
			long num2 = Long.parseLong(result.getText());
			float output = model.calculate(num1, num2, operator);
			result.setText(String.valueOf(output));
			operator = "";
			start = true;
		}
	}
}// end class
