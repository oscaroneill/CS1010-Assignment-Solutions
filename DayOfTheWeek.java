/* SELF ASSESSMENT
 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
        Mark out of 5: 5
        Comment: The four constants I use are self-explanatory and formatted appropriately
 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5
        Comment: All variables are self-explanatory and formatted appropriately
 3. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: All the code is indented properly
 4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
       Mark out of 20: 20
       Comment: I defined all the functions required with the proper parameters and outputs
 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
       Mark out of 20: 20
       Comment: Yes
 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
       Mark out of 20: 20
       Comment: Yes
 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?
       Mark out of 10: 10
       Comment: Yes, input is dealt with regardless of validity
 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
       Mark out of 10: 10
       Comment: Yes
 9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: It's all accurate 
 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;
import javax.swing.JOptionPane;

public class DayOfTheWeek {

	public static final int DAYS_IN_APR_JUNE_SEP_NOV = 30;
	public static final int DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC = 31;
	public static final int DAYS_IN_FEB_NORMAL = 28;
	public static final int DAYS_IN_FEB_LEAP = 29;
	
	public static void main(String[] args) {
		
		int day = -1;
		int month = -1;
		int year = -1;
		
		String dayInput = JOptionPane.showInputDialog("Enter a date to check if it is valid. "
				+ "What is the day?");
		Scanner inputScanner = new Scanner(dayInput);
		if (inputScanner.hasNextInt()) {
			day = inputScanner.nextInt();
			inputScanner.close();
			String monthInput = JOptionPane.showInputDialog("What is the month?");
			inputScanner = new Scanner(monthInput);
			if (inputScanner.hasNextInt()) {
				month = inputScanner.nextInt();
				inputScanner.close();
				String yearInput = JOptionPane.showInputDialog("What is the year?");
				inputScanner = new Scanner(yearInput);
				if (inputScanner.hasNextInt()) {
					
					year = inputScanner.nextInt();

					if (validDate(year, month, day)) {
						JOptionPane.showMessageDialog(null, "" + dayOfTheWeek(day, month, year) 
						+ ", " + day + numberEnding(day) + " " 
						+ monthName(month) + " " + year);
					} else {
						JOptionPane.showMessageDialog(null, "That is an invalid date.");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid input.");
		}

		inputScanner.close();
		
	}
	
	public static String numberEnding(int day) {
		
		if (((day % 100) / 10) == 1) {
			
			return "th";
			
		} else {
			
			switch (day % 10) {
			case 1:
				return "st";
			case 2:
				return "nd";
			case 3:
				return "rd";
			default:
				return "th";
			}
			
		}
		
	}
	
	public static String monthName(int month) {
		
		switch(month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Error";
		}

	}
	
	public static String dayOfTheWeek(int day, int month, int year) {
		
		int y = year;
		y = y % 1000;
		y = y % 100;
		int c = year;
		c = c / 1000;
		c = c / 100;
		
		// Gaussian algorithm
		int w = (int)(day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + Math.floor(y/4) + Math.floor(c/4) - (2 * c)) % 7;
		
		switch(w) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "Error";
								
		}
		
	}
	
	// Valid date functions
	public static boolean validDate(int year, int month, int day) {
		
		if ((day <= 0) || (month <= 0) || (month >= 13)) {
			return false;
		} else if (day <= daysInMonth(month, year)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static int daysInMonth(int month, int year) {
		
		switch(month) {
		case 2:
			if (isLeapYear(year)) {
				return DAYS_IN_FEB_LEAP;
			} else {
				return DAYS_IN_FEB_NORMAL;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			return DAYS_IN_APR_JUNE_SEP_NOV;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC;
		default:
			return 32;
		}
		
	}
	
	public static boolean isLeapYear(int year) {
		
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
		
	}

}