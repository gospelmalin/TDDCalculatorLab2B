package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import calculator.Calculator;

class CalculatorTest {

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
	
	// TODO testa specialfall och gränsvärden för beräkningarna
	@Test
	void shouldMultiplyTwoValuesGiven() {

		// Arrange
		Calculator calc = new Calculator();
		
		// Act
		double actual = calc.multiply(3,2);
		
		// Assert
		assertEquals(6d, actual, 0.111); // TODO vettigare testvärden, använda parameters?
	}

	@Test
	void shouldDivideTheFirstValueWithTheSecond() {
		// fail("Not yet implemented"); // TODO 
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.divide(3,2);

				
		// Assert
			assertEquals(1.5, actual, 0.111); // TODO vettigare testvärden, använda parameters?
		
	}
	
	@Test
	void shouldSubtractTheSecondValueGivenFromTheFirst() {
		// fail("Not yet implemented"); // TODO
		
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.subtract(5,2.5);
				
		// Assert
			assertEquals(2.5, actual, 0.111); // TODO vettigare testvärden, använda parameters?
	}
	
	@Test
	void shouldAddTwoValuesGiven() {
		// fail("Not yet implemented"); //TODO
		// Arrange
			Calculator calc = new Calculator();
						
		// Act
			double actual = calc.add(5,2.5);
						
		// Assert
			assertEquals(7.5, actual, 0.111); // TODO vettigare testvärden, använda parameters?	
	}
	
	@Test
	void shouldGiveModulusFromTheDivision() {
		// fail("Not yet implemented"); // TODO
		// Arrange
			Calculator calc = new Calculator();
								
		// Act
			double actual = calc.modulus(14,5);
								
		// Assert
			assertEquals(4, actual, 0.111); // TODO vettigare testvärden, använda parameters?	
			}

	@Test
	void shouldConvertDigitsInStringToNumbers() { // testa att jag kan konvertera en sträng till ett tal
		// Arrange
			Calculator calc = new Calculator();
			
			// Act
			double actual = calc.convertDigitsInStringToNumbers("3.0");
			
			// Assert
			assertEquals(3.0d, actual, 0.111); // TODO vettigare testvärden, använda parameters?
	}
	
	@Test //TODO need to check all values, use parameters?
	void shouldCheckThatValueIsAnOperatorIsTrue() {
		// Arrange
			 	Calculator calc = new Calculator();
			 // Act
				String stringToTest="+";
			 // Assert
			 assertTrue(calc.isOperator(stringToTest)); 
	}
	
	@Test
	void shouldCheckThatValueIsAnOperatorIsTrueFalse() {
		// Arrange
	 	Calculator calc = new Calculator();
		// Act
		String stringToTest ="a";
		// Assert
		assertFalse(calc.isOperator(stringToTest)); 
	}

	@Test //TODO need to check all values, use parameters?
	void shouldCheckThatOperatorHasPriorityIsTrue() {
		// Arrange
	 	Calculator calc = new Calculator();
	 // Act
		String operator="*";
	 // Assert
	 assertTrue(calc.operatorHasPriority(operator)); 
	}

	@Test //TODO need to check all values, use parameters?
	void shouldCheckThatOperatorHasPriorityIsFalse() {
		// Arrange
	 	Calculator calc = new Calculator();
	 // Act
		String operator="-";
	 // Assert
	 assertFalse(calc.operatorHasPriority(operator)); 
	}
	
	@Test //TODO kontrollera gränsfall, special cases
	void shouldPerformCalculationToAddTwoValuesGiven() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 40.6;
		// Act
		double actual = calc.performCalculation(30.2, 10.4, "+");
		// Assert
		assertEquals(expected, actual, 0.111);
	}

	@Test //TODO kontrollera gränsfall, special cases
	void shouldPerformCalculationToSubtractSecondValueFromFirst() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 20.4;
		// Act
		double actual = calc.performCalculation(30.8, 10.4, "-");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	@Test //TODO kontrollera gränsfall, special cases
	void shouldPerformCalculationToMultiplyTwoValues() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 48;
		// Act
		double actual = calc.performCalculation(6.0, 8, "*");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	@Test //TODO kontrollera gränsfall, special cases //TODO division with 0
	void shouldPerformCalculationToDivideTheFirstValueWithTheSecond() {
		// Arrange
		Calculator calc = new Calculator();
		double expected = 2;
		// Act
		double actual = calc.performCalculation(8.0, 4, "/");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
	@Test //TODO kontrollera gränsfall, special cases
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
//something not good enough within method, makes test halt
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
}
