/**
 * 
 */
package practice08.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author ChineduKnight
 *
 */
public class MyNumber {

	private DoubleProperty number;

	public final Double getNumber() {
		if (number != null) {
			return number.get();
		}
		return 0.0;
	}

	public void setNumber(Double number) {
		this.numberProperty().set(number); 
	}
	
	public final DoubleProperty numberProperty() {
		if (number == null) {
			number =  new SimpleDoubleProperty(0);
		}
		return number;
	}
}
