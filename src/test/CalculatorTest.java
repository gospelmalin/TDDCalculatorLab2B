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
}
