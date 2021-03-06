/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code?  
       Mark out of 5: 5
   2. Did I use easy-to-understand, meaningful CONSTANT names? 
       Mark out of 5: 5
   3. Did I format the CONSTANT names properly (in UPPERCASE)? 
       Mark out of 5: 5
   4. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   5. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
   6. Did I indent the code appropriately? 
       Mark out of 10: 10
   7. Did I use an appropriate for loop to test all possibilities?  There should be only one. 
       Mark out of 20:  20
   8. Did I correctly check if people alive today were or could be alive in a year that is the square of their age in that year. 
       Mark out of 30:  30
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class SquareAges {
	
	public static final int MAXIMUM_AGE = 123;
	public static final int CURRENT_YEAR = 2017;
	public static final int MINIMUM_YEAR_BORN = CURRENT_YEAR - MAXIMUM_AGE;
	
	public static void main(String[] args) {
		int ageSquared = 0;
		int yearOfBirth = 0;
		
		for (int ageCount = 0; ageCount <= MAXIMUM_AGE; ageCount++) {
			ageSquared = ageCount * ageCount;
			yearOfBirth = ageSquared - ageCount;
			
			if (yearOfBirth >= MINIMUM_YEAR_BORN && yearOfBirth <= CURRENT_YEAR) {
				System.out.println("People born in the year " + yearOfBirth + " will be " 
						+ ageCount + " years old in the year " + ageSquared + ", which is the square of their age.");
			}
		}
		
	}
}