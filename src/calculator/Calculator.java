package calculator;

import java.util.ArrayList;


public class Calculator {
	
	public ArrayList<String> infixArrayList;
	
	public Calculator() {
	infixArrayList = new ArrayList<String>();	
	}

	public String calculateExpression(String equationEntered) throws IllegalArgumentException, ArithmeticException {
		validateEquationEntered(equationEntered);
		
	    infixArrayList = createInfixArrayListFromString(equationEntered);

	    System.out.println("Now handling equation: " + equationEntered);

	    // As long as we have any prio operators
	    while (checkIfAnyPrioOperators(infixArrayList)) {
	        int i = findFirstPrioOperator(infixArrayList);

	        double leftOperand = Double.parseDouble(findOperandBeforeTheOperator(i));
	        double rightOperand = Double.parseDouble(findOperandAfterTheOperator(i));
	        String operator = infixArrayList.get(i);

	        double resultFromCalculation = performCalculation(leftOperand, rightOperand, operator);
	        String result= Double.toString(resultFromCalculation);

	        replaceOperandBeforeOperatorInInfixArrayListWithResult(i, result);
	        removeOperatorAndOperandAfterFromInfixArrayList(i);
	        infixArrayList.trimToSize();
	    }

	    // As long as we have no prio operators
	    while (checkIfAnyNonPrioOperators(infixArrayList))
	    {
	        int i = findFirstNonPrioOperator(infixArrayList);

	        double leftOperand = Double.parseDouble(findOperandBeforeTheOperator(i));
	        double rightOperand = Double.parseDouble(findOperandAfterTheOperator(i));
	        String operator = infixArrayList.get(i);

	        double resultFromCalculation = performCalculation(leftOperand, rightOperand, operator);
	        String result= Double.toString(resultFromCalculation);

	        replaceOperandBeforeOperatorInInfixArrayListWithResult(i, result);
	        removeOperatorAndOperandAfterFromInfixArrayList(i);
	        infixArrayList.trimToSize();
	    }

	    String result = infixArrayList.get(0);

	    return result;

	} //end method
	
	
	

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
		double result = a * b;
	    if(result == Double.POSITIVE_INFINITY)
			throw new ArithmeticException("Overflow exception");
		  else if(result == Double.NEGATIVE_INFINITY) 
			  throw new ArithmeticException("Underflow exception");
	 
	return result;

		}

	
		
		public double divide(double a, double b) {
			if (b == 0) {
			//	return 0; // TODO replace with better solution
			    throw new ArithmeticException("Division with 0 is not allowed");
			}  
			double result = a / b;
			    if(result == Double.POSITIVE_INFINITY)
					throw new ArithmeticException("Overflow exception");
				  else if(result == Double.NEGATIVE_INFINITY) 
					  throw new ArithmeticException("Underflow exception");
			 
			return result;
		}

		public double subtract(double a, double b) {
			double result = a - b;
			
				if(result == Double.NEGATIVE_INFINITY) 
					  throw new ArithmeticException("Underflow exception");
				if(result == Double.POSITIVE_INFINITY)
					throw new ArithmeticException("Overflow exception");
			return result;
		}

		public double add(double a, double b) {
			double result = a + b;
			if(result == Double.POSITIVE_INFINITY)
				throw new ArithmeticException("Overflow exception");
			  else if(result == Double.NEGATIVE_INFINITY) 
				  throw new ArithmeticException("Underflow exception");

			return result;
		}

		public double modulus(double a, double b) {
			double result = a % b;
			if(result == Double.POSITIVE_INFINITY)
				throw new ArithmeticException("Overflow exception");
			  else if(result == Double.NEGATIVE_INFINITY) 
				  throw new ArithmeticException("Underflow exception");
			return result;
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

		public String findOperandBeforeTheOperator(int operatorPosition) {
			String leftOperand = infixArrayList.get(operatorPosition-1);
			return leftOperand;
		}
		
		public String findOperandAfterTheOperator(int operatorPosition) {
			String rightOperand = infixArrayList.get(operatorPosition+1);
			return rightOperand;
		}

		public boolean checkIfAnyPrioOperators(ArrayList<String> testArrayList) {
			infixArrayList = testArrayList;
			for (String optionalOperator : infixArrayList) {
				if (!checkIfNumber(optionalOperator)) {
					for (int i = 0; i < infixArrayList.size(); i++) {
						if (operatorHasPriority(optionalOperator)) {
						return true;
						}
					}
				//	return false;
				}
			}
			return false;		
		}

		public int findFirstPrioOperator(ArrayList<String> testArrayList) {
			infixArrayList = testArrayList;
			ArrayList<Integer> operatorIndexArrayList = new ArrayList<Integer>();
				for (String operator : infixArrayList) {
					if (operatorHasPriority(operator)) {
					int	operatorIndex=infixArrayList.indexOf(operator);
					// System.out.println(operator + " " + operatorIndex ); //For testing purposes only
					operatorIndexArrayList.add(operatorIndex);
					}			
			} int firstPrioOperatorIndex = operatorIndexArrayList.get(0);
			return firstPrioOperatorIndex;
		}

		public boolean checkIfAnyNonPrioOperators(ArrayList<String> testArrayList) {
			infixArrayList = testArrayList;
			for (String optionalOperator : infixArrayList) {
				if (!checkIfNumber(optionalOperator)) {
					for (int i = 0; i < infixArrayList.size(); i++) {
						if (isOperator(optionalOperator) && !operatorHasPriority(optionalOperator)) {
						return true;
						}
					}
				//	return false;
				}
			}
			return false;		
		}

		public int findFirstNonPrioOperator(ArrayList<String> testArrayList) {
			infixArrayList = testArrayList;
			ArrayList<Integer> operatorIndexArrayList = new ArrayList<Integer>();
				for (String operator : infixArrayList) {
					if (isOperator(operator) && !operatorHasPriority(operator)) {
					int	operatorIndex=infixArrayList.indexOf(operator);
					// System.out.println(operator + " " + operatorIndex ); //For testing purposes only
					operatorIndexArrayList.add(operatorIndex);
					}			
			} int firstNonPrioOperatorIndex = operatorIndexArrayList.get(0);
			return firstNonPrioOperatorIndex;
		}

		/**
		 * Checks whether the string has content
		 */
		public boolean hasContent(String equationEntered) {
			if(equationEntered != null && equationEntered.length() > 0) 
				return true;
				return false;
			}

		public boolean hasStartingNumber(String equationEntered) {
			return equationEntered.matches("^\\d.*"); 

			}

		
				
		public boolean hasNumberLast(String equationEntered) {
		return equationEntered.matches(".*\\d$");

	}
		
		public boolean severalConsequtiveOperators(String equationEntered) {
			return equationEntered.matches("(.*[/*\\-+%][/*\\-+%]+).*");
		}
		
		public boolean whitespaceInEquation(String equationEntered) {
			return equationEntered.matches("(.*[\\s]+).*");

		}
		
		public boolean invalidContentInEquation(String equationEntered) {  //TODO test needed
			return !equationEntered.matches("([\\d/*\\-+%.E]+)*");
			
		}

		private void validateEquationEntered(String equationEntered) {
		
		// check for empty string
		if (!hasContent(equationEntered)) throw new IllegalArgumentException("Equation has no content.");
		// check that first value of the string represents a number
		if (!hasStartingNumber(equationEntered)) throw new IllegalArgumentException("Equation does not start with a digit.");
		// check that last value of the string represents a number
		if (!hasNumberLast(equationEntered)) throw new IllegalArgumentException("Equation does not end with a digit.");
		// check if there are more than one consecutive operator
		if (severalConsequtiveOperators(equationEntered)) throw new IllegalArgumentException("Several consequtive operators in the equation.");
		// check if the equation contains whitespace
		if (whitespaceInEquation(equationEntered)) throw new IllegalArgumentException("Whitespace present in the equation.");
		// check for invalid content in the equation
		if (invalidContentInEquation(equationEntered)) throw new IllegalArgumentException("Invalid content in equation.");
		
		}

		
}
