package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.Calculator;

/**
 * The class CalculatorTest holds the unit tests on which the Calculator class 
 * is built. Tests on exception handling are not included in this class.
 * @author Malin Albinsson
 * @version 1.0
 *
 */
class CalculatorTest {
	
	/**
	 * Should calculate expression with result 21
	 */
	@Test
	void shouldCalculateExpressionWithResultTwentyOne() {
	// Arrange
		Calculator calc = new Calculator();
	// Act
		String expected="21.0";
		String actual = calc.calculateExpression("7*6/2");
	// Assert
		assertEquals(expected, actual);
	}

	/**
	 * Should calculate expression with result 11.0.
	 */
	@Test
	void shouldCalculateExpressionWithResultEleven() {
	// Arrange
		Calculator calc = new Calculator();
	// Act
		String expected="11.0";
		String actual = calc.calculateExpression("5+6/2*2");
	// Assert
		assertEquals(expected, actual);
	}
	
	/**
	 * Should calculate more complicated expression with result 21.0.
	 */
	@Test
	void shouldCalculateMoreComplicatedExpressionWithResultTwentyOne() {
	// Arrange
	  Calculator calc = new Calculator();
	// Act
		String expected="21.0";
		String actual = calc.calculateExpression("5*4+7-3*0+4-10");
	// Assert
		assertEquals(expected, actual);
	}
	
	/**
	 * Should calculate expression with result 32.5.
	 */
	@Test
	void shouldCalculateExpressionWithResultThirtyTwoAndAHalf() {
	// Arrange
	 Calculator calc = new Calculator();
	// Act
		String expected="32.5";
		String actual = calc.calculateExpression("7*4+6-3/2");
	// Assert
		assertEquals(expected, actual);		
	}
	
	/**
	 * Should calculate expression with result -102.0
	@Test
	void shouldCalculateExpressionWithResultMinusOnehundredAndTwo() {
	// Arrange
	 Calculator calc = new Calculator();
	// Act
		String expected="-102.0";
		String actual = calc.calculateExpression("1-50*2-3");
	// Assert
		assertEquals(expected, actual);		
	}

	/**
	 * Should calculate modulus expression with result zero.
	 */
	@Test
	void shouldCalculateModulusExpressionWithResultZero() {
	// Arrange
	 Calculator calc = new Calculator();
	// Act
		String expected="0.0";
		String actual = calc.calculateExpression("18%3");
	// Assert
		assertEquals(expected, actual);		
	}
	
	/**
	 * Should calculate modulus expression with result 3.0.
	 */
	@Test
	void shouldCalculateModulusExpressionWithResultThree() {
	// Arrange
	 Calculator calc = new Calculator();
	// Act
		String expected="3.0";
		String actual = calc.calculateExpression("47%4");
	// Assert
		assertEquals(expected, actual);		
	}
	
	/**
	 * Should split string into operands and numbers and put in array list.
	 */
	@Test  // Will need an arrayList of the equation parts
	void shouldSplitStringIntoOperandsAndNumbersAndPutInArrayList() {  
		// Arrange
			Calculator calc = new Calculator();
			
			// Act
			ArrayList<String> expectedArray = new ArrayList<String>();
			expectedArray.add("30");
			expectedArray.add("-");
			expectedArray.add("2.5");
			expectedArray.add("*");
			expectedArray.add("4");
			expectedArray.add("+");
			expectedArray.add("5");
			expectedArray.add("/");
			expectedArray.add("2");
			expectedArray.add("-");
			expectedArray.add("4");
			expectedArray.add("%");
			expectedArray.add("3");

			ArrayList<String> resultArray = calc.createInfixArrayListFromString("30-2.5*4+5/2-4%3");
			// Assert
			assertEquals(expectedArray, resultArray);
	}
	
	

	
	
	/**
	 * Should check if number is true.
	 */
	@Test
	void shouldCheckIfNumberIsTrue() { // will pass if turns out true
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.checkIfNumber("4"));

	}
	
	/**
	 * Should check if number is false.
	 */
	@Test
	void shouldCheckIfNumberIsFalse() { // will pass if turns out false
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.checkIfNumber("+"));
	}
	

	/**
	 * Should multiply two values given.
	 */
	@Test
	void shouldMultiplyTwoValuesGiven() {

		// Arrange
		Calculator calc = new Calculator();
		
		// Act
		double actual = calc.multiply(3,2);
		
		// Assert
		assertEquals(6d, actual, 0.111); 
	}
	
	/**
	 * Should add two values given with result max.
	 */
	@Test
	void shouldAddTwoValuesGivenWithResultMax() {
		// Arrange
				Calculator calc = new Calculator();
				double result = Double.MAX_VALUE; 
				
				// Act
				double operand1 = Double.MAX_VALUE-1;
				double operand2 = 1;
				double actual = calc.add(operand1,operand2);
				
				// Assert
				assertEquals(result, actual, 0.111); //
	}
	
	/**
	 * Should subtract two values given with result min.
	 */
	@Test
	void shouldSubtractTwoValuesGivenWithResultMin() {
		// Arrange
				Calculator calc = new Calculator();
				double result = Double.MIN_VALUE; 
				
				// Act
				double operand1 = Double.MIN_VALUE+1;
				double operand2 = 1;
				double actual = calc.subtract(operand1,operand2);
				
				// Assert
				assertEquals(result, actual, 0.111); //
	}

	/**
	 * Should divide the first value with the second.
	 */
	@Test
	void shouldDivideTheFirstValueWithTheSecond() {

		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.divide(3,2);

				
		// Assert
			assertEquals(1.5, actual, 0.111); 
		
	}
	
	
	
	/**
	 * Should subtract the second value given from the first.
	 */
	@Test
	void shouldSubtractTheSecondValueGivenFromTheFirst() {
		
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.subtract(5,2.5);
				
		// Assert
			assertEquals(2.5, actual, 0.111); 
	}
	
	/**
	 * Should add two values given.
	 */
	@Test
	void shouldAddTwoValuesGiven() {

		// Arrange
			Calculator calc = new Calculator();
						
		// Act
			double actual = calc.add(5,2.5);
						
		// Assert
			assertEquals(7.5, actual, 0.111); 
	}
	
	/**
	 * Should give modulus from the division.
	 */
	@Test
	void shouldGiveModulusFromTheDivision() {

		// Arrange
			Calculator calc = new Calculator();
								
		// Act
			double actual = calc.modulus(14,5);
								
		// Assert
			assertEquals(4, actual, 0.111); 
			}

	/**
	 * Should convert digits in string to numbers.
	 */
	@Test
	void shouldConvertDigitsInStringToNumbers() { 
		// Arrange
			Calculator calc = new Calculator();
			
			// Act
			double actual = calc.convertDigitsInStringToNumbers("3.0");
			
			// Assert
			assertEquals(3.0d, actual, 0.111); 
	}
	
	/**
	 * Should check that value for method isAnOperator is true for valid operators.
	 *
	 * @param stringToTest the string to test
	 */
	@ParameterizedTest
	@ValueSource(strings = { "*", "-","+", "/", "%" })
	void shouldCheckThatValueForIsAnOperatorIsTrue(String stringToTest) {
		// Arrange
			 Calculator calc = new Calculator();
		// Assert
		 assertTrue(calc.isOperator(stringToTest)); 
	}


	/**
	 * Should check that value for IsAnOperator is false for non-operators.
	 *
	 * @param stringToTest the string to test
	 */
	@ParameterizedTest
	@ValueSource(strings = { "*", "-","+", "/", "%" })
	void shouldCheckThatValueForIsAnOperatorIsFalse(String stringToTest) {
		// Arrange
			 Calculator calc = new Calculator();

		// Act/Assert
		 assertFalse(!calc.isOperator(stringToTest)); 
		 
	}	
	
	/**
	 * Should check that non-operator values for IsAnOperator is false.
	 *
	 * @param stringToTest the string to test
	 */
	@ParameterizedTest
	@ValueSource(strings = { "a", "A","abs", "3", "(", "]" })
	void shouldCheckThatNonOperatorValuesForIsAnOperatorIsFalse(String stringToTest) {
		// Arrange
	 	Calculator calc = new Calculator();

		// Act/Assert
		assertFalse(calc.isOperator(stringToTest)); 
	}

	/**
	 * Should check that operatorHasPriority is true.
	 *
	 * @param operator the operator
	 */
	@ParameterizedTest
	@ValueSource(strings = { "*", "/", "%" })
	void shouldCheckThatOperatorHasPriorityIsTrue(String operator) {
		// Arrange
	 	Calculator calc = new Calculator();

	 // Assert
	 assertTrue(calc.operatorHasPriority(operator)); 
	}
	
	/**
	 * Should check that operatorHasPriority is false for minus and plus.
	 *
	 * @param operator the operator
	 */
	@ParameterizedTest
	@ValueSource(strings = { "-", "+" })
	void shouldCheckThatOperatorHasPriorityIsFalseForMinusAndPlus(String operator) {
		// Arrange
	 	Calculator calc = new Calculator();

	 // Assert
	 assertFalse(calc.operatorHasPriority(operator)); 
	}

	/**
	 * Should check that operatorHasPriority is false for non operators.
	 *
	 * @param operator the operator
	 */
	@ParameterizedTest
	@ValueSource(strings = { "a", "A","abs", "3", "(", "]" })
	void shouldCheckThatOperatorHasPriorityIsFalseForNonOperators(String operator) {
		// Arrange
	 	Calculator calc = new Calculator();

	 // Assert
	 assertFalse(calc.operatorHasPriority(operator)); 
	}
	
	/**
	 * Should perform calculation using performCalculation to add two values given.
	 */
	@Test 
	void shouldPerformCalculationToAddTwoValuesGiven() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 40.6;
		// Act
		double actual = calc.performCalculation(30.2, 10.4, "+");
		// Assert
		assertEquals(expected, actual, 0.111);
	}

	/**
	 * Should perform calculation using performCalculation to subtract second value from first.
	 */
	@Test 
	void shouldPerformCalculationToSubtractSecondValueFromFirst() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 20.4;
		// Act
		double actual = calc.performCalculation(30.8, 10.4, "-");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	/**
	 * Should perform calculation to multiply two values using performCalculation.
	 */
	@Test 
	void shouldPerformCalculationToMultiplyTwoValues() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 48;
		// Act
		double actual = calc.performCalculation(6.0, 8, "*");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	/**
	 * Should perform calculation to divide the first value with the second using performCalculation.
	 */
	@Test 
	void shouldPerformCalculationToDivideTheFirstValueWithTheSecond() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 2;
		// Act
		double actual = calc.performCalculation(8.0, 4, "/");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	/**
	 * Should perform calculation to give modulus using performCalculation.
	 */
	@Test 
	void shouldPerformCalculationToGiveModulus() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 2;
		// Act
		double actual = calc.performCalculation(8.0, 3, "%");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	/**
	 * Should find operand before the operator.
	 */
	@Test
	void shouldFindOperandBeforeTheOperator() {
		// Arrange
		Calculator calc = new Calculator();
		
		// For equation 2.0+3.0*4-2
		calc.infixArrayList.add("2.0");
		calc.infixArrayList.add("+");
		calc.infixArrayList.add("3.0");
		calc.infixArrayList.add("*");
		calc.infixArrayList.add("4");
		calc.infixArrayList.add("-");
		calc.infixArrayList.add("2");

		String expectedLeftOperand = "3.0";

		// Act
		int operatorPosition = 3;
		String actualLeftOperand = calc.findOperandBeforeTheOperator(operatorPosition);	
		
		// Assert
		assertEquals(expectedLeftOperand, actualLeftOperand);
	}
	
	/**
	 * Should find operand after the operator.
	 */
	@Test
	void shouldFindOperandAfterTheOperator() {
		// Arrange
		Calculator calc = new Calculator();
		
		// For equation 2.0+3.0*4-2
		calc.infixArrayList.add("2.0");
		calc.infixArrayList.add("+");
		calc.infixArrayList.add("3.0");
		calc.infixArrayList.add("*");
		calc.infixArrayList.add("4");
		calc.infixArrayList.add("-");
		calc.infixArrayList.add("2");

		String expectedRightOperand = "4";

		// Act
		int operatorPosition = 3;
		String actualRightOperand = calc.findOperandAfterTheOperator(operatorPosition);	
		
		// Assert
		assertEquals(expectedRightOperand, actualRightOperand);
	}
	
	/**
	 * Should replace operand before operator in infix array list with result.
	 */
	@Test
	void shouldReplaceOperandBeforeOperatorInInfixArrayListWithResult() {
		// Arrange
		Calculator calc = new Calculator();
		
		// For equation 2.0+3.0*4
		calc.infixArrayList.add("2.0");
		calc.infixArrayList.add("+");
		calc.infixArrayList.add("3.0");
		calc.infixArrayList.add("*");
		calc.infixArrayList.add("4");

		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("2.0");
		expectedArray.add("+");
		expectedArray.add("5.0");
		expectedArray.add("*");
		expectedArray.add("4");

		// Act
		String result="5.0";
		int operatorPosition = 3;
		ArrayList<String> resultArray = calc.replaceOperandBeforeOperatorInInfixArrayListWithResult(operatorPosition, result);
				
		// Assert
		assertEquals(expectedArray, resultArray);
	}
	
	/**
	 * Should remove operator and operand after from infix array list.
	 */
	@Test
	void shouldRemoveOperatorAndOperandAfterFromInfixArrayList() {
		// Arrange
		Calculator calc = new Calculator();
		
		// For equation 2.0+3.0*4-2
		calc.infixArrayList.add("2.0");
		calc.infixArrayList.add("+");
		calc.infixArrayList.add("3.0");
		calc.infixArrayList.add("*");
		calc.infixArrayList.add("4");
		calc.infixArrayList.add("-");
		calc.infixArrayList.add("2");

		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("2.0");
		expectedArray.add("+");
		expectedArray.add("3.0");
		expectedArray.add("-");
		expectedArray.add("2");

		// Act
		int operatorPosition = 3;
		ArrayList<String> resultArray = calc.removeOperatorAndOperandAfterFromInfixArrayList(operatorPosition);
				
		// Assert
		assertEquals(expectedArray, resultArray);
	}
	
	/**
	 * Should return correct result of simple expression with non prio operator.
	 */
	@Test
	void shouldReturnCorrectResultOfSimpleExpressionWithNonPrioOperator() {
		// Arrange
				Calculator calc = new Calculator();
				
				// For equation 2.0+3.0-2
				String expected="3.0";

				// Act
				String equationEntered="2.0+3.0-2";
				String result = calc.calculateExpression(equationEntered);
						
				// Assert
				assertEquals(expected, result);
	}
	
	/**
	 * Should return correct result of simple expression with prio operator.
	 */
	@Test
	void shouldReturnCorrectResultOfSimpleExpressionWithPrioOperator() {
		// Arrange
				Calculator calc = new Calculator();
				
				// For equation 2.0*3.0*2
				String expected="3.0";

				// Act
				String equationEntered="2.0*3.0/2";
				String result = calc.calculateExpression(equationEntered);
						
				// Assert
				assertEquals(expected, result);
	}
	
	/**
	 * Should return correct result of expression with both prio and non prio operator.
	 */
	@Test
	void shouldReturnCorrectResultOfExpressionWithBothPrioAndNonPrioOperator() {
		// Arrange
			Calculator calc = new Calculator();
			
			// For equation 2.0+3.0*4/2-1
			String expected="7.0";

			// Act
			String equationEntered="2.0+3.0*4/2-1";
			String result = calc.calculateExpression(equationEntered);
					
			// Assert
			assertEquals(expected, result);
	}
	
	
	/**
	 * Should return correct result of complicated expression with both prio and non prio operator.
	 */
	@Test
	void shouldReturnCorrectResultOfComplicatedExpressionWithBothPrioAndNonPrioOperator() {
		// Arrange
			Calculator calc = new Calculator();
			
			// For equation 2+4-2+2*8-4/2
			String expected="18.0";

			// Act
			String equationEntered="2+4-2+2*8-4/2";
			String result = calc.calculateExpression(equationEntered);
					
			// Assert
			assertEquals(expected, result);
	}
	
	/**
	 * Should return correct result of expression with several non prio operator.
	 */
	@Test
	void shouldReturnCorrectResultOfExpressionWithSeveralNonPrioOperator() {
		// Arrange
			Calculator calc = new Calculator();
			
			// For equation 2+4-2+2+8-4+2-3
			String expected="9.0";

			// Act
			String equationEntered="2+4-2+2+8-4+2-3";
			String result = calc.calculateExpression(equationEntered);
					
			// Assert
			assertEquals(expected, result);
	}
	
	
	/**
	 * Should check if any prio operators is true.
	 */
	@Test
	void shouldCheckIfAnyPrioOperatorsIsTrue() { // will pass if turns out true
		// Arrange
		Calculator calc = new Calculator();
		
		ArrayList<String> testArrayList = new ArrayList<String>();
		// For equation 2.0+3.0*4-2/2
				testArrayList.add("2.0");
				testArrayList.add("+");
				testArrayList.add("3.0");
				testArrayList.add("*");
				testArrayList.add("4");
				testArrayList.add("-");
				testArrayList.add("2");
				testArrayList.add("/");
				testArrayList.add("2");

		// Act/Assert
		assertTrue (calc.checkIfAnyPrioOperators(testArrayList));

}

	/**
	 * Should check if any prio operators is false.
	 */
	@Test
	void shouldCheckIfAnyPrioOperatorsIsFalse() { // will pass if turns out false
	// Arrange
		Calculator calc = new Calculator();
		
		ArrayList<String> testArrayList = new ArrayList<String>();
		// For equation 2.0+3.0+4-2-2
				testArrayList.add("2.0");
				testArrayList.add("+");
				testArrayList.add("3.0");
				testArrayList.add("+");
				testArrayList.add("4");
				testArrayList.add("-");
				testArrayList.add("2");
				testArrayList.add("-");
				testArrayList.add("2");
		// Act/Assert
		assertFalse (calc.checkIfAnyPrioOperators(testArrayList));
}
	
	/**
	 * Should find first prio operator.
	 */
	@Test
	void shouldFindFirstPrioOperator() {
		// Arrange
			Calculator calc = new Calculator();
				
			ArrayList<String> testArrayList = new ArrayList<String>();
			// For equation 2.0+3.0*4-2/2*3
					testArrayList.add("2.0");
					testArrayList.add("+");
					testArrayList.add("3.0");
					testArrayList.add("*");
					testArrayList.add("4");
					testArrayList.add("-");
					testArrayList.add("2");
					testArrayList.add("/");
					testArrayList.add("2");
					testArrayList.add("+");
					testArrayList.add("3");
				
				int expectedIndex=3;
			// Act
			int resultIndex = calc.findFirstPrioOperator(testArrayList);
			
			// Assert
			assertEquals(expectedIndex, resultIndex); 
		}
	
	

	/**
	 * Should find first non prio operator.
	 */
	@Test
	void shouldFindFirstNonPrioOperator() {
		// Arrange
			Calculator calc = new Calculator();
				
			ArrayList<String> testArrayList = new ArrayList<String>();
			// For equation 2.0*3.0+4-2/2+3
					testArrayList.add("2.0");
					testArrayList.add("*");
					testArrayList.add("3.0");
					testArrayList.add("+");
					testArrayList.add("4");
					testArrayList.add("-");
					testArrayList.add("2");
					testArrayList.add("/");
					testArrayList.add("2");
					testArrayList.add("+");
					testArrayList.add("3");
				
				int expectedIndex=3;
			// Act
			int resultIndex = calc.findFirstNonPrioOperator(testArrayList);
			
			// Assert
			assertEquals(expectedIndex, resultIndex); 
		}
		

	/**
	 * Should check if any no prio operators is true.
	 */
	@Test
	void shouldCheckIfAnyNoPrioOperatorsIsTrue() { // will pass if turns out true
		// Arrange
		Calculator calc = new Calculator();
		
		ArrayList<String> testArrayList = new ArrayList<String>();
		// For equation 2.0*3.0+4-2/2
			testArrayList.add("2.0");
			testArrayList.add("*");
			testArrayList.add("3.0");
			testArrayList.add("+");
			testArrayList.add("3.0");
			testArrayList.add("-");
			testArrayList.add("2");
			testArrayList.add("/");
			testArrayList.add("2");
		
		// Act/Assert
		assertTrue (calc.checkIfAnyNonPrioOperators(testArrayList));

}

	/**
	 * Should check if any no prio operators is false.
	 */
	@Test
	void shouldCheckIfAnyNoPrioOperatorsIsFalse() { // will pass if turns out false
	// Arrange
		Calculator calc = new Calculator();
		
		ArrayList<String> testArrayList = new ArrayList<String>();
		// For equation 2.0*3.0*4/2%2
				testArrayList.add("2.0");
				testArrayList.add("*");
				testArrayList.add("3.0");
				testArrayList.add("*");
				testArrayList.add("4");
				testArrayList.add("/");
				testArrayList.add("2");
				testArrayList.add("%");
				testArrayList.add("2");
		// Act/Assert
		assertFalse (calc.checkIfAnyNonPrioOperators(testArrayList));
	}
	
	/**
	 * Should check if hasContent is true.
	 */
	@Test
	void shouldCheckIfHasContentIsTrue() { // will pass if turns out true
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.hasContent("3+4"));

	}
	
	/**
	 * Should check if hasContent is false.
	 */
	@Test
	void shouldCheckIfHasContentIsFalse() { // will pass if turns out false
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.hasContent(null));
	}
	
	/**
	 * Should check if first value is a number is true.
	 */
	@Test 
	void shouldCheckIfHasStartingNumberIsTrue() { // will pass if turns out true
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.hasStartingNumber("3+4"));

	}
	
	/**
	 * Should check if first value is a number is false.
	 */
	@Test
	void shouldCheckIfHasStartingNumberIsFalse() { // will pass if turns out false
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.hasStartingNumber("+3+4"));
	}
	
	/**
	 * Should check if last value is a number is true.
	 */
	@Test
	void shouldCheckIfHasNumberLastIsTrue() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.hasNumberLast("3+4"));
	}
	
	/**
	 * Should check if last value is a number is false.
	 */
	@Test
	void shouldCheckIfHasNumberLastIsFalse() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.hasNumberLast("3+4*"));
	}
	
	/**
	 * Should check if several consequtive operators is true.
	 */
	@Test
	void shouldCheckIfSeveralConsequtiveOperatorsIsTrue() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.severalConsequtiveOperators("3.91+4*%2"));
	}
	
	/**
	 * Should check if several consequtive operators is false.
	 */
	@Test
	void shouldCheckIfSeveralConsequtiveOperatorsIsFalse() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.severalConsequtiveOperators("3.91+4%2"));
	}
	
	/**
	 * Should check if whitespace in equation is true.
	 */
	@Test
	void shouldCheckIfWhitespaceInEquationIsTrue() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.whitespaceInEquation("3.9+4 *%2"));
	}
	
	/**
	 * Should check if whitespace in equation is false.
	 */
	@Test
	void shouldCheckIfWhitespaceInEquationIsFalse() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.whitespaceInEquation("3.91+4%2"));
	}
	
	/**
	 * Should check if non valid content in equation is true.
	 */
	@Test
	void shouldCheckIfNonValidContentInEquationIsTrue() {
		// Arrange
		Calculator calc = new Calculator();
		
		// Act/Assert
		assertTrue (calc.nonValidContentInEquation("a+!-3"));
	}
	
	/**
	 * Should check if non valid content in equation is false.
	 */
	@Test
	void shouldCheckIfNonValidContentInEquationIsFalse() {
		// Arrange
		Calculator calc = new Calculator();
		
		// Act/Assert
		assertFalse(calc.nonValidContentInEquation("20.4-3+5%2/4E1-6/7*8+9"));
	}
	
}
