package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.Rule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import calculator.Calculator;

/**
 * The class CalculatorTestExceptions holds the unit tests on exception handling.
 * @author Malin Albinsson
 * @version 1.0
 *
 */
class CalculatorTestExceptions {
	

	/**
	 * Divide by zero test.
	 */
	@Test	
	void divideByZeroTest() {
	Calculator calc = new Calculator();
	assertThrows(ArithmeticException.class, () -> calc.divide(2.0,0));
	}

	
	 /** The thrown. */
 	@Rule
	    public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test check if number throws number format exception.
	 */
	@Test //
	    public void testCheckIfNumberThrowsNumberFormatException() {
		Calculator calc = new Calculator();
		 if (calc.checkIfNumber("*"));
	        thrown.expect(NumberFormatException.class);
	     
	    }
	
	
	
	
	/**
	 * Should throw arithmetic exception message when division with 0.
	 */
	@Test
	void shouldThrowArithmeticExceptionMessageWhenDivisionWith0() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
        	calc.divide(10, 0);
           });
        assertEquals("Division with 0 is not allowed", exception.getMessage());
    }
	
	
	/**
	 * Should throw arithmetic exception when division with 0.
	 */
	@Test
	public void shouldThrowArithmeticExceptionWhenDivisionWith0_() {
		Calculator calc = new Calculator();
	    assertThrows(ArithmeticException.class,
	            ()->{
	           calc.divide(10.0,0.0);
	            });
	}


	/**
	 * Should throw arithmetic exception when overflow when adding.
	 */
	@Test
	void shouldThrowArithmeticExceptionWhenOverflowWhenAdding() {

		Double operand1 = 1.0E308;
		Double operand2 = 1.0E308;

		Calculator calc = new Calculator();

		assertThrows(ArithmeticException.class, () -> calc.add(operand1,operand2));

	}
	
	/**
	 * Should throw arithmetic exception when underflow when subtracting.
	 */
	@Test 
	void shouldThrowArithmeticExceptionWhenUnderflowWhenSubtracting() {

		Calculator calc = new Calculator();
		Double operand2 = 1.0E308;
		Double operand1 = 0.0-1.0E308; 

		assertThrows(ArithmeticException.class, () -> calc.subtract(operand1,operand2));

	}
	
	/**
	 * Should throw arithmetic exception message when underflow when subtracting.
	 */
	@Test 
	void shouldThrowArithmeticExceptionMessageWhenUnderflowWhenSubtracting() {

		Calculator calc = new Calculator();
		
		Double operand2 = 1.0E308;
		Double operand1 = 0.0-1.0E308; 


	     Throwable exception = assertThrows(ArithmeticException.class, () -> {
	        	calc.subtract(operand1,operand2);
	           });
	        assertEquals("Underflow exception", exception.getMessage());
	    }
		
	
	/**
	 * Should throw arithmetic exception when underflow when dividing.
	 */
	@Test  //underflow 4.9E-324
	void shouldThrowArithmeticExceptionWhenUnderflowWhenDividing() {

		Calculator calc = new Calculator();
		Double operand2 = 2.0;
		Double operand1 = 0-1.0E308-1.0E308; 


		assertThrows(ArithmeticException.class, () -> calc.divide(operand1,operand2));

	}
	
	/**
	 * Should throw arithmetic exception message when underflow when dividing.
	 */
	@Test 
	void shouldThrowArithmeticExceptionMessageWhenUnderflowWhenDividing() {

		Calculator calc = new Calculator();
		
		Double operand2 = 2.0;
		Double operand1 = 0-1.0E308-1.0E308;


	     Throwable exception = assertThrows(ArithmeticException.class, () -> {
	        	calc.subtract(operand1,operand2);
	           });
	        assertEquals("Underflow exception", exception.getMessage());
	    }
	
	/**
	 * Should throw arithmetic exception when overflow when multiplying.
	 */
	@Test
	void shouldThrowArithmeticExceptionWhenOverflowWhenMultiplying() {

		Double operand1 = 1.0E308;
		Double operand2 = 1.0E308;

		Calculator calc = new Calculator();

		assertThrows(ArithmeticException.class, () -> calc.multiply(operand1,operand2));

	}
	

	/**
	 * Should throw illegal argument exception message when string is empty.
	 */
	@Test 
	void shouldThrowIllegalArgumentExceptionMessageWhenStringIsEmpty() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression(null);
           });
        assertEquals("Equation has no content.", exception.getMessage());
    }
	
	/**
	 * Should throw illegal argument exception message when string does not start with number.
	 */
	@Test 
	void shouldThrowIllegalArgumentExceptionMessageWhenStringDoesNotStartWithNumber() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("*3");
           });
        assertEquals("Equation does not start with a digit.", exception.getMessage());
    }
	
	/**
	 * Should throw illegal argument exception message when string does not end with number.
	 */
	@Test 
	void shouldThrowIllegalArgumentExceptionMessageWhenStringDoesNotEndWithNumber() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("0+0/");
           });
        assertEquals("Equation does not end with a digit.", exception.getMessage());
    }
	
	/**
	 * Should throw illegal argument exception message when more than one consecutive operator.
	 */
	@Test 
	void shouldThrowIllegalArgumentExceptionMessageWhenMoreThanOneConsecutiveOperator() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("5++4");
           });
        assertEquals("Several consecutive operators in the equation.", exception.getMessage());
    }
	
	/**
	 * Should throw illegal argument exception message when whitespace in the equation.
	 */
	@Test
	void shouldThrowIllegalArgumentExceptionMessageWhenWhitespaceInTheEquation() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("3    4");
           });
        assertEquals("Whitespace present in the equation.", exception.getMessage());
    }
	
	/**
	 * Should throw illegal argument exception message when non valid content in equation.
	 */
	@Test 
	void shouldThrowIllegalArgumentExceptionMessageWhenNonValidContentInEquation() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("3sdf9");
           });
        assertEquals("Non-valid content in equation.", exception.getMessage());
    }
}