package calculator;

import java.util.Scanner;

public class CalculatorUI {

	public static void runUI() {
		
		//print welcome message
		System.out.println("Welcome to Malin's Calculator!\n");
		

		while (true) {
			Calculator calc = new Calculator();
			
			Scanner input = new Scanner(System.in);
			
			try {
				String equationEntered;
				System.out.println("Please enter equation:");
				equationEntered = input.nextLine();

				String result = calc.calculateExpression(equationEntered);
				System.out.println("You entered the following equation: " + equationEntered +
						". The result is "+ result + ".");
			} catch (IllegalArgumentException e) {
				System.err.println("An exception occured: "+ e.getMessage() + "\n");
			} catch (ArithmeticException e) {
				System.err.println("An exception occured: "+ e.getMessage()+"\n");
			}
			
			
		}
		// closing scanner
			//input.close();
					
	}
	
	public static void main(String[] args) {
		runUI();
	}	
}
	