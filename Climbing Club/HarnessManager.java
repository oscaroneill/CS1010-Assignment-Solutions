/* SELF ASSESSMENT

Harness Class: Member variables (4/8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: I have no private data members as they are accessed by other classes but I do have a constant for the max uses.

Harness Class: Harness constructor 1 & constructor 2 (6/6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: I do this, using the this keyword in places.

Harness Class: checkHarness method (5/5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: My method does this.

Harness Class: isHarnessOnLoan method (2/2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: My method does this.

Harness Class: canHarnessBeLoaned method (4/4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: My method does this.

Harness Class: loanHarness method (6/6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: My method does this.
 
Harness Class: returnHarness method (5/5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: My method does this.

Harness Class: toString method (3/3 marks)
My method returns a String representation of all the member variables.
Comment: My method does this.

HarnessRecords Class: member variables (3/3 marks)
I declare the member variable as a private collection of Harnesses 
Comment: I did this.

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9/9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection. 
Comment: I do this differently but to the same effect. I create an empty arraylist in the first constructor instead of null and I have a readHarnesses() method in my Manager class which reads from file instead of having it in the constructor. I then call that method in the Manager class when constructing a HarnessRecords object.

HarnessRecords Class: isEmpty method (1/1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: Again I do this differently but to the same effect. I check if the arraylist is of size zero.

HarnessRecords Class: addHarness method (5/5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: My method does this.

HarnessRecords Class: findHarness method (6/6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: My method does this.

HarnessRecords Class: checkHarness method (4/6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: I do the same thing as the Harness method checkHarness in this method.

HarnessRecords Class: loanHarness method (7/7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: My method does this.

HarnessRecords Class: returnHarness method (5/7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: My method does the same thing as the Harness method returnHarness without calling it.

HarnessRecords Class: removeHarness method (8/8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: My method does this.

GUI (Java main line) (5/5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: My main line does this.
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HarnessManager {
	
	final static int ADD_HARNESS = 1;
	final static int REMOVE_HARNESS = 2;
	final static int SAFETY_CHECKED = 3;
	final static int LOAN_HARNESS = 4;
	final static int RETURN_HARNESS = 5;
	final static int EXIT_PROGRAM = 6;
	static HarnessRecords harnessRecords = new HarnessRecords(readHarnesses());
	
	public static void main(String[] args) {
		boolean finished = false;
		do {
			System.out.println("1. Add a new harness to the records.");
			System.out.println("2. Remove a harness from the club.");
			System.out.println("3. Record that an instructor has checked the safety of a harness.");
			System.out.println("4. Loan a harness to a member (if available).");
			System.out.println("5. Return a harness from a club member.");
			System.out.println("6. Exit.");
			System.out.print("What would you like to do? ");
			Scanner inputScanner = new Scanner(System.in);
			int userChoice = 0;
			if (inputScanner.hasNextInt()) {
				userChoice = inputScanner.nextInt();
			} else {
				System.out.println("Invalid input.");
			}
			switch (userChoice) {
			case ADD_HARNESS:
				System.out.print("What is the make of the harness? ");
				String makeToAdd;
				if (inputScanner.hasNext()) {
					makeToAdd = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Model number? ");
				int modelNoToAdd;
				if (inputScanner.hasNextInt()) {
					modelNoToAdd = inputScanner.nextInt();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				Harness harnessToAdd = new Harness(makeToAdd, modelNoToAdd, null);
				harnessRecords.addHarness(harnessToAdd);
				System.out.println("" + makeToAdd + " (model no: " + modelNoToAdd + ") harness added.");
				break;
			case REMOVE_HARNESS:
				System.out.print("What is the make of the harness? ");
				String makeToRemove;
				if (inputScanner.hasNext()) {
					makeToRemove = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Model number? ");
				int modelNoToRemove;
				if (inputScanner.hasNextInt()) {
					modelNoToRemove = inputScanner.nextInt();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				if (harnessRecords.findHarness(makeToRemove, modelNoToRemove) != null) {
					harnessRecords.removeHarness(makeToRemove, modelNoToRemove);
					System.out.println("" + makeToRemove + " (model no: " + modelNoToRemove + 
							") harness removed.");
				} else {
					System.out.println("Harness not found.");
				}
				break;
			case SAFETY_CHECKED:
				System.out.print("What is the make of the harness? ");
				String makeChecked;
				if (inputScanner.hasNext()) {
					makeChecked = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Model number? ");
				int modelNoChecked;
				if (inputScanner.hasNextInt()) {
					modelNoChecked = inputScanner.nextInt();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Who checked the harness? ");
				String instructorChecked;
				if (inputScanner.hasNext()) {
					instructorChecked = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				if (harnessRecords.findHarness(makeChecked, modelNoChecked) != null) {
					harnessRecords.checkHarness(instructorChecked, makeChecked, modelNoChecked);
					System.out.println("Safety check recorded.");
				} else {
					System.out.println("Harness not found.");
				}
				break;
			case LOAN_HARNESS:
				System.out.print("What is the make of the harness? ");
				String makeLoaned;
				if (inputScanner.hasNext()) {
					makeLoaned = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Model number? ");
				int modelNoLoaned;
				if (inputScanner.hasNextInt()) {
					modelNoLoaned = inputScanner.nextInt();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Who wants the harness? ");
				String memberLoaned;
				if (inputScanner.hasNext()) {
					memberLoaned = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				if (harnessRecords.findHarness(makeLoaned, modelNoLoaned) != null && harnessRecords.findHarness(makeLoaned, modelNoLoaned).canHarnessBeLoaned()) {
					harnessRecords.loanHarness(memberLoaned);
					harnessRecords.findHarness(makeLoaned, modelNoLoaned).isOnLoan = true;
					System.out.println("Harness loaned.");
				} else {
					System.out.println("Harness not found or cannot be loaned.");
				}
				break;
			case RETURN_HARNESS:
				System.out.print("What is the make of the harness? ");
				String makeReturned;
				if (inputScanner.hasNext()) {
					makeReturned = inputScanner.next();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				System.out.print("Model number? ");
				int modelNoReturned;
				if (inputScanner.hasNextInt()) {
					modelNoReturned = inputScanner.nextInt();
				} else {
					System.out.println("Invalid input.");
					break;
				}
				if (harnessRecords.findHarness(makeReturned, modelNoReturned) != null) {
					harnessRecords.returnHarness(makeReturned, modelNoReturned);
					System.out.println("Harness returned.");
				} else {
					System.out.println("Harness not found.");
				}
				break;
			case EXIT_PROGRAM:
				System.out.println("Quit.");
				finished = true;
				break;
			}
		} while (!finished);
	}
	
	public static ArrayList<Harness> readHarnesses() {
		ArrayList<Harness> harnessCollection = new ArrayList<Harness>();
		try {
			FileReader fileReader = new FileReader("C:\\Users\\Oscar\\Documents\\eclipse-workspace\\HarnessRecordSystem\\src\\harnesses.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean endOfFileFound = false;
			while (!endOfFileFound) {
				String harnessData = bufferedReader.readLine();
				if (harnessData == null) {
					endOfFileFound = true;
				} else {
					String[] harnessProperties = harnessData.split(",");
					Harness harness = new Harness(
							harnessProperties[0], 
							Integer.parseInt(harnessProperties[1]), 
							Integer.parseInt(harnessProperties[2]), 
							harnessProperties[3], 
							Boolean.parseBoolean(harnessProperties[4]),
							harnessProperties[5]);
					harnessCollection.add(harness);
				}
			}
			return harnessCollection;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}