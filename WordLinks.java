/* SELF ASSESSMENT 
1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: The method definition is correct. It returns an array of Strings and has no arguments.
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: It does this using a FileReader and a BufferedReader.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: It does this.

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: The method definition is correct. It returns an array of Strings and has one argument.
- My method reads the words provided (which are separated by commas), saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: It does this using the split() function and saves them to an array.

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: The method definition is correct, returning a boolean with one argument.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: It does this with two for loops.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: It does this by comparing the address and contents of the current word.
- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: It does this.

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: The method definition is correct, returning a boolean with one argument.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 3]
- Comment: It does.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: It does.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: The method definition is correct, returning a boolean with two arguments.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
- Comment: It does this by tracking a "numberOfDifferences" variable and checking if it is over 1 at the end of the loop.

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: The method definition is correct, returning a boolean with one argument.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
- Comment: It does this.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: It does this.
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: It does this.

 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordLinks {

	public static void main(String[] args) {boolean finished = false;
		while (!finished) {
			System.out.print("Enter a comma separated list of words (or an empty list to quit): ");
			Scanner inputScanner = new Scanner(System.in);
			String stringOfWords = inputScanner.nextLine();
			String[] arrayOfWords = readWordList(stringOfWords);
			if (arrayOfWords.length == 1) {
				if (arrayOfWords[0].isEmpty()) {
					finished = true;
				} else {
					System.out.println("A chain of words must be longer than one word.");
				}
			} else {
				if (isWordChain(arrayOfWords)) {
					System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
				} else {
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
				}
			}
		}
	}
	
	public static String[] readDictionary() {
		ArrayList<String> readWords = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader("words.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean fileRead = false;
			while (!fileRead) {
				String word = bufferedReader.readLine();
				if (word == null) {
					fileRead = true;
				} else {
					readWords.add(word);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String readWordsArray[] = readWords.toArray(new String[readWords.size()]);
		return readWordsArray;
	}
	
	public static String[] readWordList(String words) {
		String[] wordsArray = words.split(", ");
		return wordsArray;
	}
	
	public static boolean isUniqueList(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (j != i && words[j].equals(words[i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isEnglishWord(String word) {
		String[] dictionary = readDictionary();
		int arrayAddress = Arrays.binarySearch(dictionary, word);
		if (arrayAddress >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isDifferentByOne(String firstWord, String secondWord) {
		int numberOfDifferences = 0;
		if (firstWord.length() == secondWord.length()) {
			String[] firstWordArray = firstWord.split("");
			String[] secondWordArray = secondWord.split("");
			for (int i = 0; i < firstWord.length(); i++) {
				char letter1 = firstWordArray[i].charAt(0);
				char letter2 = secondWordArray[i].charAt(0);
				if (letter1 != letter2) {
					numberOfDifferences++;
				}
			}
			if (numberOfDifferences != 1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static boolean isWordChain(String[] words) {
		if (isUniqueList(words)) {
			for (int i = 0; i < words.length; i++) {
				if (i != words.length-1) {
					String firstWord = words[i];
					String secondWord = words[i+1];
					if (isEnglishWord(firstWord) && isEnglishWord(secondWord)) {
						if (!isDifferentByOne(firstWord, secondWord)) {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
		return true;
	}
}