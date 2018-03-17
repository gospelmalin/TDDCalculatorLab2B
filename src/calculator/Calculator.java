package calculator;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Calculator {
	
	public ArrayList<String> infixArrayList;
	
	public Calculator()
	{
	infixArrayList = new ArrayList<String>();	
	}

	public String calculateExpression(String equationEntered) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> createInfixArrayListFromString(String expressionToCalculate) {
			String infixArray[] = expressionToCalculate.split("[^/*\\-+%0-9\\.]+|(?<=[/*\\-+%])(?=[0-9])|(?<=[0-9])(?=[/*\\-+%])");
			for (String stringVal : infixArray) {
				//System.out.println("split: "+ stringVal);
					infixArrayList.add(stringVal);
			}
		
			return infixArrayList;
			
		}

	/**
	 * Checks whether the token is a number
	 */
	public boolean checkIfNumber(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public double multiply(double a, double b) {
		return a * b;
		}

		public double divide(double a, double b) {
			if (b == 0) {
			//	return 0; // TODO replace with better solution
			    throw new ArithmeticException("Division with 0 is not allowed");
			 }
			return a / b;
		}

		public double subtract(double a, double b) {
			return a - b;
		}

		public double add(double a, double b) {
			return a + b;
		}

		public double modulus(double a, double b) {
			// TODO kan man ha double på indata här eller blir det fel?
			return a % b;
		}

		public double convertDigitsInStringToNumbers(String stringDigit) {
			Double numberFromString = Double.parseDouble(stringDigit);
			return numberFromString;
		}

		public boolean operatorHasPriority(String operator) {
			if (operator.toString().equals("*") || operator.toString().equals("/") || operator.toString().equals("%")) {
				return true;
			}
			
			return false;
		}

		public boolean isOperator(String operatorToTest) {
			if (operatorToTest.toString().equals("*") || operatorToTest.toString().equals("/") 
					|| operatorToTest.toString().equals("%") || operatorToTest.toString().equals("-")
					|| operatorToTest.toString().equals("+")) {
				return true;
			}
			
			return false;
		}

		
		
}
