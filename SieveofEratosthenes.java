/* SELF ASSESSMENT 
1. createSequence:
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment: The method definition is correct
	Did I create an array of size n (passed as the parameter) and initialise it?
	Mark out of 5: 5
	Comment: The created array is the proper size and initiliased
	Did I return the correct item?
	Mark out of 5: 5
	Comment: I returned the array
2. crossOutMultiples
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment: The method definition is correct
	Did I ensure the parameters are not null and one of them is a valid index into the array
	Mark out of 2: 2
	Comment: The program makes sure that's not possible
	Did I loop through the array using the correct multiple?
	Mark out of 5: 5
	Comment: I did
	Did I cross out correct items in the array that were not already crossed out?
	Mark out of 3: 3
	Comment: I did by checking if the item contained a "[".
3. sieve   
	Did I have the correct function definition?
	Mark out of 5: 5
	Comment: The function definition is correct
	Did I make calls to other methods?
	Mark out of 5: 5
	Comment: I call createSequence and crossOutMultiples
	Did I return an array with all non-prime numbers are crossed out?
	Mark out of 2: 2
	Comment: It returns that
4. sequenceToString  
	Did I have the correct function definition?
	Mark out of 5: 5
	Comment: The function definition is correct
	Did I ensure the parameter to be used is not null?
	Mark out of 3: 3
	Comment: The program does not allow that to happen
	Did I Loop through the array updating the String variable with the non-crossed out numbers 
	and the crossed numbers in brackets? 
	Mark out of 10: 10
	Comment: It does that
5. nonCrossedOutSubseqToString  
	Did I have the correct function definition
	Mark out of 5: 5
	Comment: The function definition is correct
	Did I ensure the parameter to be used is not null?  
	Mark out of 3: 3
	Comment: The program does not allow that to happen
	Did I loop through the array updating the String variable with just the non-crossed out 
	numbers? 
	Mark out of 5: 5
	Comment: It does that
6. main  
	Did I ask  the user for input n and handles input errors?  
	Mark out of 5: 5
	Comments: It does that and handles all invalid input
	Did I make calls to other methods (at least one)?
	Mark out of 5: 5
	Comment: I call nonCrossedOutSubseqToString and sieve
	Did I print the output as shown in the question?  
	Mark out of 5: 0
	Comment: I wasn't able to do that, instead I just output the list of primes
7. Overall
	Is my code indented correctly?
	Mark out of 4: 4
	Comments: All the code is indented properly
	Do my variable names make sense?
	Mark out of 4: 4
	Comments: All variable names are self-explanatory
	Do my variable names, method names and class name follow the Java coding standard
	Mark out of 4: 4
	Comments: They do
Total Mark out of 100 (Add all the previous marks): 95
*/

import java.util.Scanner;

public class SieveofEratosthenes {
	
	public static void main(String[] args) {
		System.out.print("Enter int >= 2 : ");
		Scanner inputScanner = new Scanner(System.in);
		int userMaxNum = -1;
		if (inputScanner.hasNextInt()) {
			userMaxNum = inputScanner.nextInt();
			if (userMaxNum <= 1) {
				System.out.println("Invalid input.");
			} else {
				System.out.println(nonCrossedOutSubseqToString(sieve(userMaxNum)));
			}
		} else {
			System.out.println("Invalid input.");
		}
		inputScanner.close();
	}
	
	public static String[] createSequence(int maxNum) {
		String[] sequence = new String[maxNum];
		int count = 0;
		for (int i = 2; i <= maxNum; i++) {
			sequence[count] = String.valueOf(i);
			count++;
		}
		return sequence;
	}
	
	public static void crossOutHigherMultiples(String[] sequence, int multiple) {
		for (int i = multiple; i < sequence.length-1; i++) {
			if (sequence[i].contains("[") == false) {
				int tempNum = Integer.parseInt(sequence[i]);
				if (tempNum % multiple == 0) {
					sequence[i] = "[" + sequence[i] + "]";
				}
			}
		}
	}
	
	public static String[] sieve(int maxNum) {
		String[] primes = createSequence(maxNum);
		for (int i = 2; i < primes.length-1; i++) {
			crossOutHigherMultiples(primes, i);
		}
		return primes;
	}
	
	public static String sequenceToString(String[] sequence) {
		String convertedString = "";
		for (int i = 0; i < sequence.length-1; i++) {
			if (i == 0) {
				convertedString += sequence[i];
			} else {
				convertedString += ", " + sequence[i];
			}
		}
		return convertedString;
	}
	
	public static String nonCrossedOutSubseqToString(String[] sequence) {
		String convertedString = "";
		for (int i = 0; i < sequence.length-1; i++) {
			if (sequence[i].contains("[") == false) {
				if (convertedString == "") {
					convertedString += sequence[i];
				} else {
					convertedString += ", " + sequence[i];
				}
			}
		}
		return convertedString;
	}
	
}