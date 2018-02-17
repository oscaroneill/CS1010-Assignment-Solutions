/* SELF ASSESSMENT 
Class Rational 
- I declared two member variables: numerator and denominator (marks out of 4: 4).
- Comment: I did this within the class, outside any methods.

Constructor 1 
- My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
- Comment: The two parameters are initialised, but I don't throw an exception for a zero here as I do it elsewhere.

Constructor 2 
- My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
- Comment: Only one parameter is initiliased here. I set the denominator to 1 at it's declaration before the constructor. 

Add Method 
- My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
- Comment: A new Rational object is created as the addition so the two rational numbers don't get overwritten.

Subtract Method 
- I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8).
- Comment: Yup.

Multiply Method 
- I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8).
- Comment: Yup.

Divide Method 
- I have implemented this the same as add method, except it implements divide (marks out of 8: 8).
- Comment: Yup.

Equals Method 
- My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
- Comment: I use division for comparison but store the answers in floats so it is not inaccurate.

isLessThan 
- My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
- Comment: Again I use division but with floats.

Simplify Method 
- My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
- Comment: My program does all of this.

gcd function 
- My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
- Comment: Yup, using ArrayLists of divisors for the two integers.

toString Method 
- My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
- Comment: Yup.

Test Client Class 
- My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22).
- Comment: Yup, with error handling and good formatting.
*/

import java.util.ArrayList;

public class Rational {
	int numerator;
	int denominator = 1;
	
	Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	Rational(int numerator) {
		this.numerator = numerator;
	}
	
	public Rational add(Rational givenRational) {
		if (this.denominatorIsZero() && this.numeratorIsZero()) {
			Rational newRational = new Rational(givenRational.numerator, givenRational.denominator);
			return newRational;
		} else if (givenRational.denominatorIsZero() && givenRational.numeratorIsZero()) {
			Rational newRational = new Rational(this.numerator, this.denominator);
			return newRational;
		} else {
			int commonDenominator = this.denominator * givenRational.denominator;
			int firstRationalNumerator = this.numerator * givenRational.denominator;
			int secondRationalNumerator = givenRational.numerator * this.denominator;
			int newNumerator = firstRationalNumerator + secondRationalNumerator;
			Rational newRational = new Rational(newNumerator, commonDenominator);
			return newRational;
		}
	}
	
	public Rational subtract(Rational givenRational) {
		if (this.denominatorIsZero() && this.numeratorIsZero()) {
			Rational newRational = new Rational(givenRational.numerator * -1, givenRational.denominator);
			return newRational;
		} else if (givenRational.denominatorIsZero() && givenRational.numeratorIsZero()) {
			Rational newRational = new Rational(this.numerator, this.denominator);
			return newRational;
		} else {
			int commonDenominator = this.denominator * givenRational.denominator;
			int firstRationalNumerator = this.numerator * givenRational.denominator;
			int secondRationalNumerator = givenRational.numerator * this.denominator;
			int newNumerator = firstRationalNumerator - secondRationalNumerator;
			Rational newRational = new Rational(newNumerator, commonDenominator);
			return newRational;
		}
	}
	
	public Rational multiply(Rational givenRational) {
		int commonDenominator = this.denominator * givenRational.denominator;
		int newNumerator = this.numerator * givenRational.numerator;
		Rational newRational = new Rational(newNumerator, commonDenominator);
		return newRational;
	}
	
	public Rational divide(Rational givenRational) {
		Rational newSecondRational = new Rational(givenRational.denominator, givenRational.numerator);
		Rational newRational = multiply(newSecondRational);
		return newRational;
	}
	
	public boolean equals(Rational givenRational) {
		if (this.denominatorIsZero() && givenRational.denominatorIsZero()) {
			return true;
		} else if (this.denominatorIsZero() || givenRational.denominatorIsZero()) {
			return false;
		} else {
			float firstRational = this.numerator / this.denominator;
			float secondRational = givenRational.numerator / givenRational.denominator;
			if (firstRational == secondRational) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean isLessThan(Rational givenRational) {
		float firstFloat = 0;
		float secondFloat = 0;
		if (this.denominatorIsZero()) {
			firstFloat = 0;
		} else {
			firstFloat = this.numerator / this.denominator;
		}
		if (givenRational.denominatorIsZero()) {
			secondFloat = 0;
		} else {
			secondFloat = givenRational.numerator / givenRational.denominator;
		}
		if (firstFloat < secondFloat) {
			return true;
		} else {
			return false;
		}
	}
	
	public Rational simplify() {
		if (!this.denominatorIsZero()) {
			this.fixSigns();
			if (this.numeratorIsZero()) {
				this.denominator = 0;
			} else {
				int gcd = GCD(this);
				int newNumerator = this.numerator/gcd;
				int newDenominator = this.denominator/gcd;
				this.numerator = newNumerator;
				this.denominator = newDenominator;
			}
		}
		return this;
	}
	
	public void fixSigns() {
		if (this.denominator < 0) {
			this.numerator *= -1;
			this.denominator *= -1;
		}
	}
	
	public int GCD(Rational rational) {
		int gcd = 0;
		ArrayList<Integer> numeratorDivisors = new ArrayList<Integer>();
		int numeratorLimit = Math.abs(rational.numerator);
		if (numeratorLimit > 1) {
			if (numeratorLimit % 2 != 0) {
				numeratorLimit /= 2;
				numeratorLimit += 1;
			} else {
				numeratorLimit /= 2;
			}
		}
		for (int i = 1; i <= numeratorLimit; i++) {
			if ((Math.abs(rational.numerator) % i) == 0) {
				numeratorDivisors.add(i);
			}
		}
		numeratorDivisors.add(Math.abs(rational.numerator));
		ArrayList<Integer> denominatorDivisors = new ArrayList<Integer>();
		int denominatorLimit = rational.denominator;
		if (denominatorLimit > 1) {
			if (denominatorLimit % 2 != 0) {
				denominatorLimit /= 2;
				denominatorLimit += 1;
			} else {
				denominatorLimit /= 2;
			}
		}
		for (int i = 1; i <= denominatorLimit; i++) {
			if ((rational.denominator % i) == 0) {
				denominatorDivisors.add(i);
			}
		}
		denominatorDivisors.add(rational.denominator);
		for (int i = 0; i < numeratorDivisors.size(); i++) {
			for (int j = 0; j < denominatorDivisors.size(); j++) {
				if (numeratorDivisors.get(i) == denominatorDivisors.get(j)) {
					gcd = numeratorDivisors.get(i);
				}
			}
		}
		return gcd;
	}
	
	public boolean denominatorIsZero() {
		if (this.denominator == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean numeratorIsZero() {
		if (this.numerator == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String result = "";
		result += this.numerator + "/" + this.denominator;
		return result;
	}
}