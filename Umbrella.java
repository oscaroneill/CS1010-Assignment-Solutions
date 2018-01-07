/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10 (All self explanatory)
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10 (I didn't use any constants so all variables were in that format)
   3. Did I indent the code appropriately? 
       Mark out of 10: 10 (Each block is indented properly)
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 20: 20 (The questions are easy to understand and appropriate)
   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
       Mark out of 30: 25? (It got more complicated when I included the cancel option)
   6. Did I output the correct answer for each possibility in an easy to read format? 
       Mark out of 15: 15 (All answers easy to understand)
   7. How well did I complete this self-assessment? 
       Mark out of 5: 5 (I think it's pretty accurate)
   Total Mark out of 100 (Add all the previous marks): 100
*/

import javax.swing.JOptionPane;

public class Umbrella {
	public static void main(String[] args) {
		
		boolean isRaining = false;
		boolean mightRain = false;
		boolean cancelled = false;
		
		int userAnswer = JOptionPane.showConfirmDialog(null, "Is it raining?");
		isRaining = (userAnswer == JOptionPane.YES_OPTION);
		cancelled = (userAnswer == JOptionPane.CANCEL_OPTION);
		
		if (cancelled) {
			JOptionPane.showMessageDialog(null, "Please choose Yes or No.");
		} else {
			if (isRaining) {
				JOptionPane.showMessageDialog(null, "Bring an umbrella and put it up.");
			} else {
				userAnswer = JOptionPane.showConfirmDialog(null, "Does it look like it might rain?");
				mightRain = (userAnswer == JOptionPane.YES_OPTION);
				cancelled = (userAnswer == JOptionPane.CANCEL_OPTION);
				if (cancelled) {
					JOptionPane.showMessageDialog(null, "Please choose Yes or No.");
				} else {
					if (mightRain) {
						JOptionPane.showMessageDialog(null, "Bring an umbrella but don't put it up.");
					} else {
						JOptionPane.showMessageDialog(null, "Don't bring an umbrella.");
					}
				}
			}	
		}
		
	}
}