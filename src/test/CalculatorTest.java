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
	
	

	
	
	@Test
	void shouldCheckIfNumberIsTrue() { // will pass if turns out true
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.checkIfNumber("4"));

	}
	
	@Test
	void shouldCheckIfNumberIsFalse() { // will pass if turns out false
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.checkIfNumber("+"));
	}
	

	@Test
	void shouldMultiplyTwoValuesGiven() {

		// Arrange
		Calculator calc = new Calculator();
		
		// Act
		double actual = calc.multiply(3,2);
		
		// Assert
		assertEquals(6d, actual, 0.111); 
	}
	
	@Test
	void shouldAddTwoValuesGivenwithResultMax() {
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
	
	@Test
	void shouldSubtractTwoValuesGivenwithResultMin() {
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

	@Test
	void shouldDivideTheFirstValueWithTheSecond() {
		// fail("Not yet implemented"); // TODO 
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.divide(3,2);

				
		// Assert
			assertEquals(1.5, actual, 0.111); 
		
	}
	
	
	
	@Test
	void shouldSubtractTheSecondValueGivenFromTheFirst() {
		// fail("Not yet implemented"); // TODO
		
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.subtract(5,2.5);
				
		// Assert
			assertEquals(2.5, actual, 0.111); 
	}
	
	@Test
	void shouldAddTwoValuesGiven() {
		// fail("Not yet implemented"); //TODO
		// Arrange
			Calculator calc = new Calculator();
						
		// Act
			double actual = calc.add(5,2.5);
						
		// Assert
			assertEquals(7.5, actual, 0.111); 
	}
	
	@Test
	void shouldGiveModulusFromTheDivision() {

		// Arrange
			Calculator calc = new Calculator();
								
		// Act
			double actual = calc.modulus(14,5);
								
		// Assert
			assertEquals(4, actual, 0.111); 
			}

	@Test // testa att jag kan konvertera en sträng till ett tal
	void shouldConvertDigitsInStringToNumbers() { 
		// Arrange
			Calculator calc = new Calculator();
			
			// Act
			double actual = calc.convertDigitsInStringToNumbers("3.0");
			
			// Assert
			assertEquals(3.0d, actual, 0.111); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "*", "-","+", "/", "%" })
	void shouldCheckThatValueForIsAnOperatorIsTrue(String stringToTest) {
		// Arrange
			 Calculator calc = new Calculator();
		// Assert
		 assertTrue(calc.isOperator(stringToTest)); 
	}


	@ParameterizedTest
	@ValueSource(strings = { "*", "-","+", "/", "%" })
	void shouldCheckThatValueForIsAnOperatorIsFalse(String stringToTest) {
		// Arrange
			 Calculator calc = new Calculator();

		// Act/Assert
		 assertFalse(!calc.isOperator(stringToTest)); 
		 
	}	
	
	@ParameterizedTest
	@ValueSource(strings = { "a", "A","abs", "3", "(", "]" })
	void shouldCheckThatNonOperatorValuesForIsAnOperatorIsFalse(String stringToTest) {
		// Arrange
	 	Calculator calc = new Calculator();

		// Act/Assert
		assertFalse(calc.isOperator(stringToTest)); 
	}

	@ParameterizedTest
	@ValueSource(strings = { "*", "/", "%" })
	void shouldCheckThatOperatorHasPriorityIsTrue(String operator) {
		// Arrange
	 	Calculator calc = new Calculator();

	 // Assert
	 assertTrue(calc.operatorHasPriority(operator)); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "-", "+" })
	void shouldCheckThatOperatorHasPriorityIsFalseForMinusAndPlus(String operator) {
		// Arrange
	 	Calculator calc = new Calculator();

	 // Assert
	 assertFalse(calc.operatorHasPriority(operator)); 
	}

	@ParameterizedTest
	@ValueSource(strings = { "a", "A","abs", "3", "(", "]" })
	void shouldCheckThatOperatorHasPriorityIsFalseForNonOperators(String operator) {
		// Arrange
	 	Calculator calc = new Calculator();

	 // Assert
	 assertFalse(calc.operatorHasPriority(operator)); 
	}
	
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
	
	@Test
	void shouldCheckIfHasContentIsTrue() { // will pass if turns out true
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.hasContent("3+4"));

	}
	
	@Test
	void shouldCheckIfHasContentIsFalse() { // will pass if turns out false
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.hasContent(null));
	}
	
	@Test 
	void shouldCheckIfHasStartingNumberIsTrue() { // will pass if turns out true
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.hasStartingNumber("3+4"));

	}
	
	@Test
	void shouldCheckIfHasStartingNumberIsFalse() { // will pass if turns out false
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.hasStartingNumber("+3+4"));
	}
	
	@Test
	void shouldCheckIfhasNumberLastIsTrue() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.hasNumberLast("3+4"));
	}
	
	@Test
	void shouldCheckIfhasNumberLastIsFalse() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.hasNumberLast("3+4*"));
	}
	
	@Test
	void shouldCheckIfSeveralConsequtiveOperatorsIsTrue() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.severalConsequtiveOperators("3.91+4*%2"));
	}
	
	@Test
	void shouldCheckIfSeveralConsequtiveOperatorsIsFalse() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.severalConsequtiveOperators("3.91+4%2"));
	}
	
	@Test
	void shouldCheckIfWhitespaceInEquationIsTrue() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertTrue (calc.whitespaceInEquation("3.9+4 *%2"));
	}
	
	@Test
	void shouldCheckIfWhitespaceInEquationIsFalse() {
		// Arrange
			Calculator calc = new Calculator();
			
			// Act/Assert
			assertFalse (calc.whitespaceInEquation("3.91+4%2"));
	}
	
	@Test
	void shouldCheckIfNonValidContentInEquationIsTrue() {
		// Arrange
		Calculator calc = new Calculator();
		
		// Act/Assert
		assertTrue (calc.nonValidContentInEquation("a+!-3"));
	}
	
	@Test
	void shouldCheckIfNonValidContentInEquationIsFalse() {
		// Arrange
		Calculator calc = new Calculator();
		
		// Act/Assert
		assertFalse(calc.nonValidContentInEquation("20.4-3+5%2/4E1-6/7*8+9"));
	}
	
}
