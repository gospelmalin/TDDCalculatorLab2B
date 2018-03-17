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

		public double performCalculation(double leftOperand, double rightOperand, String operator) {
			switch (operator) {
			case "+":
				return add(leftOperand, rightOperand);
			case "-":
				return subtract(leftOperand, rightOperand);
			case "*":
				return multiply(leftOperand, rightOperand);
			case "/":
				return divide(leftOperand, rightOperand);
			case "%":
				return modulus(leftOperand, rightOperand);
			default:
				return 0;
			}
		}


		public ArrayList<String> replaceOperandBeforeOperatorInInfixArrayListWithResult(int operatorPosition, String result) {
			infixArrayList.set((operatorPosition-1), result);
			return infixArrayList;
		}

		public ArrayList<String> removeOperatorAndOperandAfterFromInfixArrayList(int operatorPosition) {
			infixArrayList.remove(operatorPosition+1);
			infixArrayList.remove(operatorPosition);
			return infixArrayList;
		}





		
		
}
