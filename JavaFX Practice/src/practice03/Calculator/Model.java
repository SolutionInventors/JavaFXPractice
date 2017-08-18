/**
 * @author ChineduKnight Oguejiofor
 *20 Jul. 2017
 * 12:35:23 pm
 */
package practice03.Calculator;

public class Model {
	public float calculate(long num1, long num2, String operator) {
		switch (operator) {
			case "+":
				return num1 + num2;
			case "/":
				if (num2 == 0)
					return 0;
				else
					return num1 / num2;
			case "-":
				return num1 - num2;
			case "*":
				return num1 * num2;
			default:
				return 0;
		}

	}// end method calculate
}// end class
