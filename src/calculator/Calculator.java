package calculator;

import java.util.ArrayList;


public class Calculator {
	
	public ArrayList<String> infixArrayList;
	
	public Calculator() {
	infixArrayList = new ArrayList<String>();	
	}

	public String calculateExpression(String equationEntered) {
		infixArrayList = createInfixArrayListFromString(equationEntered);
		System.out.println("Now handling equation: " + equationEntered);
		while (infixArrayList.size()> 1) {
			// Block for equations with prio operators included
			if (checkIfAnyPrioOperators(infixArrayList)) {
				
				for (int i=1; i <infixArrayList.size(); i++) { //TODO invalid character?
					// Block for prio operators
					i = findFirstPrioOperator(infixArrayList);
					if (operatorHasPriority(infixArrayList.get(i)) && infixArrayList.size() - 1 != i) { 
						
					System.out.println("Prio operators in equation. Entered Priority if");
						
						double leftOperand = Double.parseDouble(findOperandBeforeTheOperator(i));
						double rightOperand = Double.parseDouble(findOperandAfterTheOperator(i));
						String operator = infixArrayList.get(i);
	
						double resultFromCalculation = performCalculation(leftOperand, rightOperand, operator);
						String result= Double.toString(resultFromCalculation);
					
						replaceOperandBeforeOperatorInInfixArrayListWithResult(i, result);
						removeOperatorAndOperandAfterFromInfixArrayList(i);
							for (String valueInInfix : infixArrayList) {
								System.out.println("Infix values after priority calculation: " +valueInInfix); 
							} //end printout loop for result of prio operators block
						i++;
						infixArrayList.trimToSize();
					}//end if for prio operators
				//}	//end for block for prio operators in having prio block
				
				//for (int i1=1; i1 <infixArrayList.size(); i1++) {
					// Block for nonprio operators
					else if (!operatorHasPriority(infixArrayList.get(i)) && infixArrayList.size() - 1 != i) { 
						System.out.println("Prio operators in equation handled. Now Entered non-priority if.");
						
						double leftOperand = Double.parseDouble(findOperandBeforeTheOperator(i));
						double rightOperand = Double.parseDouble(findOperandAfterTheOperator(i));
						String operator = infixArrayList.get(i);
	
						double resultFromCalculation = performCalculation(leftOperand, rightOperand, operator);
						String result= Double.toString(resultFromCalculation);
					
						replaceOperandBeforeOperatorInInfixArrayListWithResult(i, result);
						removeOperatorAndOperandAfterFromInfixArrayList(i);
							for (String valueInInfix : infixArrayList) {
								System.out.println("Prio operators in equation. Infix values after non priority calculation: " +valueInInfix); 
							} //end printout loop for result of NO-prio operators block within block WITH prio operators
						i++;
						infixArrayList.trimToSize();
					} //end if for non-prio operators within block WITH prio operators	
				//} //End for loop in block with prio operators included
			} // End outer if for block with prio operators included
			}
			// Block for equations with NO prio operators included
			if (!checkIfAnyPrioOperators(infixArrayList)) {
				for (int j=1; j <infixArrayList.size(); j++) { //TODO invalid character?
					// Block for nonprio operators
					if (!operatorHasPriority(infixArrayList.get(j)) && infixArrayList.size() - 1 != j) { 
						System.out.println("No prio operators in equation: Entered non-priority if.");
						
						double leftOperand = Double.parseDouble(findOperandBeforeTheOperator(j));
						double rightOperand = Double.parseDouble(findOperandAfterTheOperator(j));
						String operator = infixArrayList.get(j);
	
						double resultFromCalculation = performCalculation(leftOperand, rightOperand, operator);
						String result= Double.toString(resultFromCalculation);
					
						replaceOperandBeforeOperatorInInfixArrayListWithResult(j, result);
						removeOperatorAndOperandAfterFromInfixArrayList(j);
							for (String valueInInfix : infixArrayList) {
								System.out.println("Infix values after non priority calculation: " +valueInInfix); 
							} //end printout loop for result of NO-prio operators block
						j++;
						infixArrayList.trimToSize();
					} //end if for non-prio operators	
				} // end for block for equation with NO prio operators included
			 }	//end outer if block for equation with NO prio operators included
		}	//End while	
		if (infixArrayList.size()==1);
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
	
		
}
