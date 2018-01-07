/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5        
        Comment: All variables used are formatted correctly and meaningful
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: All code is indented correctly
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20         
       Comment: Yes
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20        
       Comment: Yes
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15: 15    
       Comment: I think so
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10: 0   
       Comment: No, it runs indefinitely
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20: 15  
       Comment: I think there should be a fifth?
 8. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: It's all accurate
 Total Mark out of 100 (Add all the previous marks): 85
*/ 

/*
A “star number”, s, is a number defined by the formula: s = 6n(n-1) + 1
where n is the index of the star number.
Thus the star numbers are: 1, 13, 37, 73, 121, 181, 253, …
A “triangle number”, t, is the sum of the numbers from 1 to n: t = 1 + 2 + … + (n-1) + n.
Thus the triangle numbers are:  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 
153, 171, 190, 210, 231, 253, …
Write a Java application that produces a list of all the values of type int that are 
simultaneously star numbers and triangle numbers.  As part of this problem you must write 
and use the following functions:
- An isStarNumber() routine which determines if the passed number is a star number or not.
- A determineStarNumber() function which returns the star number of a passed index 
(i.e. value of n) OR a determineTriangleNumber() function which returns the triangle number 
for a passed index (i.e. value of n)
*/

public class TriangularStars {

	public static void main(String[] args) {
		
		int count = 0;
		
		while (true) {
			
			int triangle = ((count * (count + 1)) / 2);
			
			if (triangle >= 0) {
				
			  	if (isStarNumber(triangle)) {
					
					System.out.println(triangle);
					count++;
				
				} else {
				
					count++;
				
				}
				
			}
			
		}
		
	}

	public static boolean isStarNumber(int s) {
		
		boolean finished = false;
		int count = 0; 
		boolean isStar = true;
		
		while (!finished) {
			
			double star = determineStarNumber(count);
			
			if (star <= s) {
				
				if (star == s) {
				
					finished = true;
					isStar = true;
				
				} else {
					
					count++;
					
				}
				
			} else {
				
				finished = true;
				isStar = false;
			
			}
		
		}
		
		return isStar;
		
	}
	
	public static int determineStarNumber(int n) {
		
		return (((6 * n) * (n - 1)) + 1);
		
	}
	
}