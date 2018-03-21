package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.Rule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import calculator.Calculator;

class CalculatorTestExceptions {
	

	@Test	
	void divideByZeroTest() {
	Calculator calc = new Calculator();
	assertThrows(ArithmeticException.class, () -> calc.divide(2.0,0));
	}

	
	 @Rule
	    public ExpectedException thrown = ExpectedException.none();

	@Test
	    public void testCheckIfNumberThrowsNumberFormatException() {
		Calculator calc = new Calculator();
		 if (calc.checkIfNumber("*") == true);
	        thrown.expect(NumberFormatException.class);
	     
	    }
	
	
	
	
	@Test
	void shouldThrowArithmeticExceptionMessageWhenDivisionWith0() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
        	calc.divide(10, 0);
           });
        assertEquals("Division with 0 is not allowed", exception.getMessage());
    }
	
	
	@Test
	public void shouldThrowArithmeticExceptionWhenDivisionWith0_() {
		Calculator calc = new Calculator();
	    assertThrows(ArithmeticException.class,
	            ()->{
	           calc.divide(10.0,0.0);
	            });
	}


	@Test
	void shouldThrowArithmeticExceptionWhenOverflowWhenAdding() {

		Double operand1 = 1.0E308;
		Double operand2 = 1.0E308;

		Calculator calc = new Calculator();

		assertThrows(ArithmeticException.class, () -> calc.add(operand1,operand2));

	}
	
	
	
	
	
	@Test
	void shouldThrowArithmeticExceptionWhenOverflowWhenMultiplying() {

		Double operand1 = 1.0E308;
		Double operand2 = 1.0E308;

		Calculator calc = new Calculator();

		assertThrows(ArithmeticException.class, () -> calc.multiply(operand1,operand2));

	}
	

	@Test //empty string
	void shouldThrowIllegalArgumentExceptionMessageWhenStringIsEmpty() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression(null);
           });
        assertEquals("Equation has no content.", exception.getMessage());
    }
	
	@Test //NotStartWithNumber
	void shouldThrowIllegalArgumentExceptionMessageWhenStringDoesNotStartWithNumber() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("*3");
           });
        assertEquals("Equation does not start with a digit.", exception.getMessage());
    }
	
	@Test //NotEndWithNumber
	void shouldThrowIllegalArgumentExceptionMessageWhenStringDoesNotEndWithNumber() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("0+0/");
           });
        assertEquals("Equation does not end with a digit.", exception.getMessage());
    }
	
	@Test //several operators
	void shouldThrowIllegalArgumentExceptionMessageWhenMoreThanOneConsequtiveOperator() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("5++4");
           });
        assertEquals("Several consequtive operators in the equation.", exception.getMessage());
    }
	
	@Test //Whitespace
	void shouldThrowIllegalArgumentExceptionMessageWhenWhitespaceInTheEquation() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("3    4");
           });
        assertEquals("Whitespace present in the equation.", exception.getMessage());
    }
	
	@Test //NotEndWithNumber
	void shouldThrowIllegalArgumentExceptionMessageWhenNonValidContentInEquation() {
		//Arrange
				Calculator calc = new Calculator();
							
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        	calc.calculateExpression("3sdf9");
           });
        assertEquals("Non-valid content in equation.", exception.getMessage());
    }
}