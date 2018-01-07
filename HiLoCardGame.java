/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment: Used MAX_ATTEMPTS to cap attempts
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: MAX_ATTEMPTS is properly formatted
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: All variable names are self-explanatory
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
       Comment: All the variables are properly formatted
   5. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: All code blocks are indented accordingly
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20: 20
       Comment: I used a do-while loop as the user will always input an answer at least once
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 10
       Comment: Any input other than higher, lower or equal is handled, and the question is repeated
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment: Yes, assuming java.util.Random supplies properly random numbers
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment: Yes, including changing "a 8" to "an 8"
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10: 10
       Comment: Yes, it says congratulations if the user guesses correctly 4 times and says they lost if they guess incorrectly before then
   11. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: It's all accurate
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Random;
import java.util.Scanner;

public class HiLoCardGame {
	
	public static final int MAX_ATTEMPTS = 4;
	
	public static void main(String[] args) {

		boolean finished = false;
		Random randomGen = new Random();
		int answer = 0;
		int randomNum = randomGen.nextInt(13) + 1;
		int randomNum2 = randomGen.nextInt(13) + 1;
		int count = MAX_ATTEMPTS;
		
		do {
			
			randomNum2 = randomGen.nextInt(13) + 1;
			
			if (randomNum == 7) {
				System.out.println("The card is an 8");
			} else if (randomNum >= 1 && randomNum <= 9) {
				System.out.println("The card is a " + randomNum);
			} else if (randomNum == 10) {
				System.out.println("The card is a Jack");
			} else if (randomNum == 11) {
				System.out.println("The card is a Queen");
			} else if (randomNum == 12) {
				System.out.println("The card is a King");
			} else if (randomNum == 13) {
				System.out.println("The card is an Ace");
			}
			
			Scanner inputScanner = new Scanner(System.in);
			System.out.print("Do you think the next card will be higher, lower or equal? ");
			
			if (inputScanner.hasNext("higher")) {
				answer = 1;
			} else if (inputScanner.hasNext("lower")) {
				answer = -1;
			} else if (inputScanner.hasNext("equal")) {
				answer = 0;
			} else {
				System.out.println("Invalid input.");
				continue;
			}
			
			if (randomNum < randomNum2) {
				if (answer == 1) {
					randomNum = randomNum2;
					count--;
				} else if (answer == -1 || answer == 0) {
					if (randomNum2 == 7) {
						System.out.println("You lose, the card was an 8");
					} else if (randomNum2 >= 1 && randomNum2 <= 9) {
						System.out.println("You lose, the card was a " + randomNum2);
					} else if (randomNum2 == 10) {
						System.out.println("You lose, the card was a Jack");
					} else if (randomNum2 == 11) {
						System.out.println("You lose, the card was a Queen");
					} else if (randomNum2 == 12) {
						System.out.println("You lose, the card was a King");
					} else if (randomNum2 == 13) {
						System.out.println("You lose, the card was an Ace");
					}
					inputScanner.close();
					finished = true;
				}
			} else if (randomNum > randomNum2) {
				if (answer == -1) {
					randomNum = randomNum2;
					count--;
				} else if (answer == 1 || answer == 0) {
					if (randomNum2 == 7) {
						System.out.println("You lose, the card was an 8");
					} else if (randomNum2 >= 1 && randomNum2 <= 9) {
						System.out.println("You lose, the card was a " + randomNum2);
					} else if (randomNum2 == 10) {
						System.out.println("You lose, the card was a Jack");
					} else if (randomNum2 == 11) {
						System.out.println("You lose, the card was a Queen");
					} else if (randomNum2 == 12) {
						System.out.println("You lose, the card was a King");
					} else if (randomNum2 == 13) {
						System.out.println("You lose, the card was an Ace");
					}
					inputScanner.close();
					finished = true;
				}
			} else if (randomNum == randomNum2) {
				if (answer == 0) {
					randomNum = randomNum2;
					count--;
				} else if (answer == 1 || answer == -1) {
					if (randomNum2 == 7) {
						System.out.println("You lose, the card was an 8");
					} else if (randomNum2 >= 1 && randomNum2 <= 9) {
						System.out.println("You lose, the card was a " + randomNum2);
					} else if (randomNum2 == 10) {
						System.out.println("You lose, the card was a Jack");
					} else if (randomNum2 == 11) {
						System.out.println("You lose, the card was a Queen");
					} else if (randomNum2 == 12) {
						System.out.println("You lose, the card was a King");
					} else if (randomNum2 == 13) {
						System.out.println("You lose, the card was an Ace");
					}
					inputScanner.close();
					finished = true;
				}
			}
			
			if (count == 0) {
				
				if (randomNum == 7) {
					System.out.println("The card is an 8");
				} else if (randomNum >= 1 && randomNum <= 9) {
					System.out.println("The card is a " + randomNum);
				} else if (randomNum == 10) {
					System.out.println("The card is a Jack");
				} else if (randomNum == 11) {
					System.out.println("The card is a Queen");
				} else if (randomNum == 12) {
					System.out.println("The card is a King");
				} else if (randomNum == 13) {
					System.out.println("The card is an Ace");
				}
				
				System.out.println("Congratulations. You got them all correct.");
				inputScanner.close();
				finished = true;
			
			}
			
		} while (!finished);		
		
	}

}