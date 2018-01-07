/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5
        Comment: All the variables are self-explanatory and correctly formatted
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: All the code is properly indented
 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15
       Comment: The function is written correctly and works as intended
 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15
       Comment: The function is written correctly and works as intended
 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15
       Comment: The function is written correctly and works as intended
 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 10
       Comment: The function has the correct parameters and return type but it does not work as intended
 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
       Mark out of 20: 20
       Comment: The main function body is written correctly
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: It's all accurate
 Total Mark out of 100 (Add all the previous marks): 90
*/ 

/*
Write a program to maintain a list of the high scores obtained in a game.The program should 
first ask the user how many scores they want to maintain and then repeatedly accept new scores 
from the user and should add the score to the list of high scores (in the appropriate position) 
if it is higher than any of the existing high scores.  You must include the following functions:
- initialiseHighScores () which sets all high scores to zero.
- printHighScores() which prints the high scores in the format: “The high scores are 345, 300,
234”, for all existing high scores in the list (remember that sometimes it won’t be full).
- higherThan() which takes the high scores and a new score and returns whether the passed score is
higher than any of those in the high score list.
- insertScore() which takes the current high score list and a new score and updates it by 
inserting the new score at the appropriate position in the list.
*/

import java.util.Scanner;

public class HighScores {
	
	public static void main(String[] args) {
		System.out.print("How many high scores do you want to have? ");
		Scanner inputScanner = new Scanner(System.in);
		int maxNumOfScores = inputScanner.nextInt();
		int[] highscores = new int[maxNumOfScores];
		initialiseHighScores(highscores);
		boolean finished = false;
		while (!finished) {
			System.out.print("\nEnter a high score (or enter 'quit'): ");
			if (inputScanner.hasNext("quit")) {
				finished = true;
			} else if (inputScanner.hasNextInt()) {
				insertScore(highscores, inputScanner.nextInt());
				printHighScores(highscores);
			}
		}
		inputScanner.close();
	}
	
	public static void initialiseHighScores(int[] array) {
		for (int index = 0; index < array.length; index++) {
			array[index] = 0;
		}
	}
	
	public static void printHighScores(int[] array) {
		System.out.print("\nThe high scores are ");
		for (int index = 0; index < array.length; index++) {
			if (index == array.length-1) {
				System.out.print(array[index]);
			} else {
				System.out.print(array[index] + ", ");
			}
		}
	}
	
	public static boolean higherThan(int[] array, int newScore) {
		for (int index = 0; index < array.length; index++) {
			if (newScore >= array[index]) {
				return true;
			}
		}
		return false;
	}
	
	public static void insertScore(int[] array, int newScore) {
		if (higherThan(array, newScore)) {
			int newIndex = -1;
			while (newIndex == -1) {
				for (int index = array.length-1; index > 0; index--) {
					if (newScore > array[index]) {
						newIndex = index;
					}
				}
			}
			for (int index = 0; index <= newIndex; index++) {
				array[index] = array[index+1];
			}
			array[newIndex] = newScore;
		}
	}
}