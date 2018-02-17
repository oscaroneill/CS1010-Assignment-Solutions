import java.util.Scanner;

public class RationalTest {
	public static void main(String[] args) {
		System.out.print("Enter a fraction (a/b): ");
		Scanner inputScanner = new Scanner(System.in).useDelimiter("/|\r");
		if (inputScanner.hasNextInt()) {
			int firstRationalNumerator = inputScanner.nextInt();
			if (inputScanner.hasNextInt()) {
				int firstRationalDenominator = inputScanner.nextInt();
				Rational firstRational = new Rational(firstRationalNumerator, firstRationalDenominator);
				System.out.print("Enter a second fraction (a/b): ");
				inputScanner = new Scanner(System.in).useDelimiter("/|\r");
				if (inputScanner.hasNextInt()) {
					int secondRationalNumerator = inputScanner.nextInt();
					if (inputScanner.hasNextInt()) {
						int secondRationalDenominator = inputScanner.nextInt();
						Rational secondRational = new Rational(secondRationalNumerator, secondRationalDenominator);
						inputScanner.close();
						if (firstRational.denominatorIsZero() && !firstRational.numeratorIsZero()) {
							System.out.println("Cannot divide by zero!");			
						} else if (secondRational.denominatorIsZero() && !secondRational.numeratorIsZero()) {
							System.out.println("Cannot divide by zero!");
						} else {
							System.out.println("\nSimplified:");
							System.out.println("First fraction: " + firstRational.simplify().toString());
							System.out.println("Second fraction: " + secondRational.simplify().toString());
							System.out.println("\nAddition:");
							System.out.println("a + b = " + firstRational.add(secondRational).simplify().toString());
							System.out.println("\nSubtraction:");
							System.out.println("a - b = " + firstRational.subtract(secondRational).simplify().toString());
							System.out.println("b - a = " + secondRational.subtract(firstRational).simplify().toString());
							System.out.println("\nMultiplication:");
							System.out.println("a * b = " + firstRational.multiply(secondRational).simplify().toString());
							System.out.println("\nDivision:");
							if (secondRational.denominatorIsZero()) {
								System.out.println("a / b is undefined.");
							} else {
								System.out.println("a / b = " + firstRational.divide(secondRational).simplify().toString());
							}
							if (firstRational.denominatorIsZero()) {
								System.out.println("b / a is undefined.");
							} else {
								System.out.println("b / a = " + secondRational.divide(firstRational).simplify().toString());
							}
							System.out.println("\nEquals: " + firstRational.equals(secondRational));
							System.out.println("\nFirst is less than second: " + firstRational.isLessThan(secondRational));
							System.out.println("Second is less than first: " + secondRational.isLessThan(firstRational));
						}
					} else {
						System.out.println("Invalid input.");
					}
				} else {
					System.out.println("Invalid input.");
				}
			} else {
				System.out.println("Invalid input.");
			}
		} else {
			System.out.println("Invalid input.");
		}
	}
}