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
	
	// TODO testa specialfall och gr�nsv�rden f�r ber�kningarna
	@Test
	void shouldMultiplyTwoValuesGiven() {

		// Arrange
		Calculator calc = new Calculator();
		
		// Act
		double actual = calc.multiply(3,2);
		
		// Assert
		assertEquals(6d, actual, 0.111); // TODO vettigare testv�rden, anv�nda parameters?
	}

	@Test
	void shouldDivideTheFirstValueWithTheSecond() {
		// fail("Not yet implemented"); // TODO 
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.divide(3,2);

				
		// Assert
			assertEquals(1.5, actual, 0.111); // TODO vettigare testv�rden, anv�nda parameters?
		
	}
	
	@Test
	void shouldSubtractTheSecondValueGivenFromTheFirst() {
		// fail("Not yet implemented"); // TODO
		
		// Arrange
			Calculator calc = new Calculator();
				
		// Act
			double actual = calc.subtract(5,2.5);
				
		// Assert
			assertEquals(2.5, actual, 0.111); // TODO vettigare testv�rden, anv�nda parameters?
	}
	
	@Test
	void shouldAddTwoValuesGiven() {
		// fail("Not yet implemented"); //TODO
		// Arrange
			Calculator calc = new Calculator();
						
		// Act
			double actual = calc.add(5,2.5);
						
		// Assert
			assertEquals(7.5, actual, 0.111); // TODO vettigare testv�rden, anv�nda parameters?	
	}
	
	@Test
	void shouldGiveModulusFromTheDivision() {
		// fail("Not yet implemented"); // TODO
		// Arrange
			Calculator calc = new Calculator();
								
		// Act
			double actual = calc.modulus(14,5);
								
		// Assert
			assertEquals(4, actual, 0.111); // TODO vettigare testv�rden, anv�nda parameters?	
			}

	@Test
	void shouldConvertDigitsInStringToNumbers() { // testa att jag kan konvertera en str�ng till ett tal
		// Arrange
			Calculator calc = new Calculator();
			
			// Act
			double actual = calc.convertDigitsInStringToNumbers("3.0");
			
			// Assert
			assertEquals(3.0d, actual, 0.111); // TODO vettigare testv�rden, anv�nda parameters?
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
	
	@Test
	void shouldPerformCalculationToAddTwoValuesGiven() {
		//fail("Not yet implemented"); // TODO
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
		//fail("Not yet implemented"); // TODO
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
		//fail("Not yet implemented"); // TODO
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
		//fail("Not yet implemented"); // TODO
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
		//fail("Not yet implemented"); // TODO
		// Arrange
		Calculator calc = new Calculator();
		double expected = 2;
		// Act
		double actual = calc.performCalculation(8.0, 3, "%");
		// Assert
		assertEquals(expected, actual, 0.111);
	}
	
}
