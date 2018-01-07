/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:   10
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  4
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  8 
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
   6. Did I indent the code appropriately?
       Mark out of 10:  10
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  10
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  20
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
   10. How well did I complete this self-assessment?
       Mark out of 10:  9
   Total Mark out of 100 (Add all the previous marks):  96
*/

import java.util.Scanner;
import javax.swing.JOptionPane;

public class PoundsShillingsAndPennies {

	public static void main(String[] args) {
		final int NEW_PENNIES_PER_OLD_PENNIES = 67;
		final int OLD_PENNIES_PER_OLD_SHILLINGS = 12;
		final int OLD_SHILLINGS_PER_OLD_POUNDS = 20;
		final int NEW_PENNIES_PER_NEW_POUNDS = 100;
		double total = 0;
		double newPounds = 0;
		double newShillings = 0;
		double newPennies = 0;
		
		String input = JOptionPane.showInputDialog("Enter old Sterling pounds, shillings and pennies, separated by spaces:");
		Scanner inputScanner = new Scanner( input );
		int oldPounds = inputScanner.nextInt();
		int oldShillings = inputScanner.nextInt();
		int oldPennies = inputScanner.nextInt();
		inputScanner.close();
		
		newPounds = ((((double)(oldPounds) * OLD_SHILLINGS_PER_OLD_POUNDS) * OLD_PENNIES_PER_OLD_SHILLINGS) 
																* NEW_PENNIES_PER_OLD_PENNIES) 
																/ NEW_PENNIES_PER_NEW_POUNDS; 
		
		newShillings = (((double)(oldShillings) * OLD_PENNIES_PER_OLD_SHILLINGS) * NEW_PENNIES_PER_OLD_PENNIES)
																		/ NEW_PENNIES_PER_NEW_POUNDS;
		
		newPennies = ((double)(oldPennies) * NEW_PENNIES_PER_OLD_PENNIES) / NEW_PENNIES_PER_NEW_POUNDS;
		
		total = newPounds + newShillings + newPennies;
		
		JOptionPane.showMessageDialog(null, oldPounds + " old pound, " + oldShillings + " old shilling and " 
										+ oldPennies + " old pence = £" + total);
	}

}