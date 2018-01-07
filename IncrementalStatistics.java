/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10:  10
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5:   5
   3. Did I indent the code appropriately? 
       Mark out of 10:  10
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10:  10
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  20
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30:  30
   8. How well did I complete this self-assessment? 
       Mark out of 5:   5
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class IncrementalStatistics {

	public static void main(String[] args) {
		
		boolean finished = false;
		double average = 0.0;
		double oldAverage = 0.0;
		double variance = 0.0;
		double currentNumber = 0;
		int numberCount = 0;
		
		do {
			
			Scanner numberInput = new Scanner( System.in );
			System.out.print("Enter a number (or type 'exit' or 'quit'): ");
			
			if (numberInput.hasNextDouble()) {
			
				numberCount++;
				currentNumber = numberInput.nextDouble();
				
				average = average + (currentNumber - average) / numberCount;
				variance = ((variance * (numberCount-1)) + (currentNumber - oldAverage) 
						* (currentNumber - average)) / numberCount;
				
				System.out.println("So far the average is " + average 
						+ " and the variance is " + variance);
				
				oldAverage = average;
			
			} else if (numberInput.hasNext("exit") || numberInput.hasNext("quit")) {
				
				System.out.print("Goodbye.");
				numberInput.close();
				finished = true;
				
			} else if (!numberInput.hasNextDouble()) {
				
				System.out.println("Input invalid. Please use numbers or quit/exit only.");
			
			}
		} while (!finished);
		
	}
}