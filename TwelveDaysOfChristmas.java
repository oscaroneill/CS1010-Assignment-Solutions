/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment: I used a constant for the number of verses. Maybe could have used constants for the days
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: The constant I used is properly formatted
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment: I only used one (verse) which is formatted properly and self-explanatory
   4. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: All the code is indented properly
   5. Did I use an appropriate loop (or loops) to produce the different verses? 
       Mark out of 20: 20
       Comment: I used one for loop because the number of loops was known
   6. Did I use a switch to build up the verses? 
       Mark out of 25: 25
       Comment: I used a switch for everything past the first two lines of each verse
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
       Mark out of 10: 10
       Comment: Using the switch statement and the condition operator, each line was only used once in the code
   8. Does the program produce the correct output? 
       Mark out of 10: 10
       Comment: It's the complete song
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: It's all accurate
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class TwelveDaysOfChristmas {

	public static final int NUMBER_OF_VERSES = 12;
	
	public static void main(String[] args) {
		
		int verse = 0;
		
		for (verse = 1; verse <= NUMBER_OF_VERSES; verse++) {
			
			System.out.print("On the ");
			System.out.print(((verse == 1) ? "first" : (verse == 2) ? "second" : 
							(verse == 3) ? "third" : (verse == 4) ? "fourth" : 
							(verse == 5) ? "fifth" : (verse == 6) ? "sixth" : 
							(verse == 7) ? "seventh" : (verse == 8) ? "eighth" : 
							(verse == 9) ? "ninth" : (verse == 10) ? "tenth" : 
							(verse == 11) ? "eleventh" : "twelfth") 
							+ " day of Christmas \nmy true love sent to me:");
			System.out.println("");
			
			switch (verse) {
			case 12:
				System.out.println("12 Drummers Drumming");
			case 11:
				System.out.println("11 Pipers Piping");
			case 10:
				System.out.println("10 Lords a Leaping");
			case 9:
				System.out.println("9 Ladies Dancing");
			case 8:
				System.out.println("8 Maids a Milking");
			case 7:
				System.out.println("7 Swans a Swimming");
			case 6:
				System.out.println("6 Geese a Laying");
			case 5:
				System.out.println("5 Golden Rings");
			case 4:
				System.out.println("4 Calling Birds");
			case 3:
				System.out.println("3 French Hens");
			case 2:
				System.out.println("2 Turtle Doves");
			case 1:
				System.out.println(((verse == 1) ? "" : "and ") + "a Partridge in a Pear Tree");
			}
			
			System.out.println("");			
			
		}
		
	}

}