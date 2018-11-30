package calculator;

import java.util.ArrayList;

/**
 * The class Calculator holds all methods for calculations in the calculator.
 *
 * @author Malin Albinsson
 * @version 1.0
 */
public class Calculator {
	
	/** The infix array list. */
	public ArrayList<String> infixArrayList;
	
	/**
	 * Instantiates a new calculator.
	 */
	public Calculator() {
	infixArrayList = new ArrayList<String>();	
	}

	/**
	 * Calculate expression takes an equation in string format and returns the result 
	 * of the calculated expression as a string. Complicated equations with several operators
	 * are handled. Operator precedence is handled. Negative values and parentheses are not handled.
	 *
	 * @param equationEntered the equation entered
	 * @return the result of the calculated equation as a string
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws ArithmeticException the arithmetic exception
	 */
	public String calculateExpression(String equationEntered) throws IllegalArgumentException, ArithmeticException {
		// Check that the equation entered is valid
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
	
	
	

	/**
	 * Creates the infix array list from string.
	 *
	 * @param expressionToCalculate the expression to calculate
	 * @return the array list
	 */
	public ArrayList<String> createInfixArrayListFromString(String expressionToCalculate) {
			String infixArray[] = expressionToCalculate.split("[^/*\\-+%0-9\\.]+|(?<=[/*\\-+%])(?=[0-9])|(?<=[0-9])(?=[/*\\-+%])");
			for (String stringVal : infixArray) {
				//System.out.println("split: "+ stringVal);
					infixArrayList.add(stringVal);
			}
		
			return infixArrayList;
			
		}
	


	/**
	 * Checks whether the token is a number.
	 *
	 * @param token the token
	 * @return true, if successful
	 */
	public boolean checkIfNumber(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Multiply.
	 *
	 * @param a the first operand
	 * @param b the second operand
	 * @return the double
	 */
	public double multiply(double a, double b) {
		double result = a * b;
	    if(result == Double.POSITIVE_INFINITY)
			throw new ArithmeticException("Overflow exception");
		  else if(result == Double.NEGATIVE_INFINITY) 
			  throw new ArithmeticException("Underflow exception");
	 
	return result;

		}

	
		
		/**
		 * Divide.
		 *
		 * @param a the first operand
		 * @param b the second operand
		 * @return the double
		 */
		public double divide(double a, double b) {
			if (b == 0) {
			    throw new ArithmeticException("Division with 0 is not allowed");
			}  
			double result = a / b;
			    if(result == Double.POSITIVE_INFINITY)
					throw new ArithmeticException("Overflow exception");
				  else if(result == Double.NEGATIVE_INFINITY) 
					  throw new ArithmeticException("Underflow exception");
			 
			return result;
		}

		/**
		 * Subtract.
		 *
		 * @param a the first operand
		 * @param b the second operand
		 * @return the double
		 */
		public double subtract(double a, double b) {
			double result = a - b;
			
				if(result == Double.NEGATIVE_INFINITY) 
					  throw new ArithmeticException("Underflow exception");
				if(result == Double.POSITIVE_INFINITY)
					throw new ArithmeticException("Overflow exception");
			return result;
		}

		/**
		 * Adds the operands.
		 *
		 * @param a the first operand
		 * @param b the second operand
		 * @return the double
		 */
		public double add(double a, double b) {
			double result = a + b;
			if(result == Double.POSITIVE_INFINITY)
				throw new ArithmeticException("Overflow exception");
			  else if(result == Double.NEGATIVE_INFINITY) 
				  throw new ArithmeticException("Underflow exception");

			return result;
		}

		/**
		 * Modulus.
		 *
		 * @param a the first operand
		 * @param b the second operand
		 * @return the double
		 */
		public double modulus(double a, double b) {
			double result = a % b;
			if(result == Double.POSITIVE_INFINITY)
				throw new ArithmeticException("Overflow exception");
			  else if(result == Double.NEGATIVE_INFINITY) 
				  throw new ArithmeticException("Underflow exception");
			return result;
		}

		/**
		 * Convert digits in string to numbers.
		 *
		 * @param stringDigit the string digit
		 * @return the double
		 */
		public double convertDigitsInStringToNumbers(String stringDigit) {
			Double numberFromString = Double.parseDouble(stringDigit);
			return numberFromString;
		}

		/**
		 * Operator has priority.
		 *
		 * @param operator the operator
		 * @return true, if successful
		 */
		public boolean operatorHasPriority(String operator) {
			if (operator.toString().equals("*") || operator.toString().equals("/") || operator.toString().equals("%")) {
				return true;
			}
			
			return false;
		}

		/**
		 * Checks if is operator.
		 *
		 * @param operatorToTest the operator to test
		 * @return true, if is operator
		 */
		public boolean isOperator(String operatorToTest) {
			if (operatorToTest.toString().equals("*") || operatorToTest.toString().equals("/") 
					|| operatorToTest.toString().equals("%") || operatorToTest.toString().equals("-")
					|| operatorToTest.toString().equals("+")) {
				return true;
			}
			
			return false;
		}

		/**
		 * Perform calculation.
		 *
		 * @param leftOperand the left operand
		 * @param rightOperand the right operand
		 * @param operator the operator
		 * @return the double
		 */
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


		/**
		 * Replace operand before operator in infix array list with result.
		 *
		 * @param operatorPosition the operator position
		 * @param result the result
		 * @return the array list
		 */
		public ArrayList<String> replaceOperandBeforeOperatorInInfixArrayListWithResult(int operatorPosition, String result) {
			infixArrayList.set((operatorPosition-1), result);
			return infixArrayList;
		}

		/**
		 * Removes the operator and operand after from infix array list.
		 *
		 * @param operatorPosition the operator position
		 * @return the array list
		 */
		public ArrayList<String> removeOperatorAndOperandAfterFromInfixArrayList(int operatorPosition) {
			infixArrayList.remove(operatorPosition+1);
			infixArrayList.remove(operatorPosition);
			return infixArrayList;
		}

		/**
		 * Find operand before the operator.
		 *
		 * @param operatorPosition the operator position
		 * @return the string
		 */
		public String findOperandBeforeTheOperator(int operatorPosition) {
			String leftOperand = infixArrayList.get(operatorPosition-1);
			return leftOperand;
		}
		
		/**
		 * Find operand after the operator.
		 *
		 * @param operatorPosition the operator position
		 * @return the string
		 */
		public String findOperandAfterTheOperator(int operatorPosition) {
			String rightOperand = infixArrayList.get(operatorPosition+1);
			return rightOperand;
		}

		/**
		 * Check if any prio operators.
		 *
		 * @param testArrayList the test array list
		 * @return true, if successful
		 */
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

		/**
		 * Find first prio operator.
		 *
		 * @param testArrayList the test array list
		 * @return the index of the first Prio Operator as an int
		 */
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

		/**
		 * Check if any non prio operators.
		 *
		 * @param testArrayList the test array list
		 * @return true, if successful
		 */
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

		/**
		 * Find first non prio operator.
		 *
		 * @param testArrayList the test array list
		 * @return the index of the first non-Prio Operator as an int
		 */
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
		 * Checks whether the string has content.
		 *
		 * @param equationEntered the equation entered
		 * @return true, if successful
		 */
		public boolean hasContent(String equationEntered) {
			if(equationEntered != null && equationEntered.length() > 0) 
				return true;
				return false;
			}

		/**
		 * Checks if the starting value in the string corresponds to a number.
		 *
		 * @param equationEntered the equation entered
		 * @return true, if successful
		 */
		public boolean hasStartingNumber(String equationEntered) {
			return equationEntered.matches("^\\d.*"); 

			}

		
				
		/**
		 * Checks if the last value in the string corresponds to a number.
		 *
		 * @param equationEntered the equation entered
		 * @return true, if successful
		 */
		public boolean hasNumberLast(String equationEntered) {
		return equationEntered.matches(".*\\d$");

	}
		
		/**
		 * Check if Several consecutive operators.
		 *
		 * @param equationEntered the equation entered
		 * @return true, if successful
		 */
		public boolean severalConsecutiveOperators(String equationEntered) {
			return equationEntered.matches("(.*[/*\\-+%][/*\\-+%]+).*");
		}
		
		/**
		 * Check if whitespace in equation.
		 *
		 * @param equationEntered the equation entered
		 * @return true, if successful
		 */
		public boolean whitespaceInEquation(String equationEntered) {
			return equationEntered.matches("(.*[\\s]+).*");

		}
		
		/**
		 * Check if Non-valid content in equation.
		 *
		 * @param equationEntered the equation entered
		 * @return true, if successful
		 */
		public boolean nonValidContentInEquation(String equationEntered) { 
			return !equationEntered.matches("([\\d/*\\-+%.E]+)*");
			
		}

		/**
		 * Validate equation entered.
		 *
		 * @param equationEntered the equation entered
		 */
		private void validateEquationEntered(String equationEntered) {
		
		// check for empty string
		if (!hasContent(equationEntered)) throw new IllegalArgumentException("Equation has no content.");
		// check that first value of the string represents a number
		if (!hasStartingNumber(equationEntered)) throw new IllegalArgumentException("Equation does not start with a digit.");
		// check that last value of the string represents a number
		if (!hasNumberLast(equationEntered)) throw new IllegalArgumentException("Equation does not end with a digit.");
		// check if there are more than one consecutive operator
		if (severalConsecutiveOperators(equationEntered)) throw new IllegalArgumentException("Several consecutive operators in the equation.");
		// check if the equation contains whitespace
		if (whitespaceInEquation(equationEntered)) throw new IllegalArgumentException("Whitespace present in the equation.");
		// check for non-valid content in the equation
		if (nonValidContentInEquation(equationEntered)) throw new IllegalArgumentException("Non-valid content in equation.");
		
		}

		
}
