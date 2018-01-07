/*
Write a Java program which repeatedly converts (user entered) plain text to cipher text using a 
substitution cipher (in which plain text letters are randomly assigned to cipher text letters), 
and then converts it back again (just to be sure that we can decrypt it).  Note that a 
Substitution Cipher replaces plaintext with cipher-text. The most common substitution ciphers 
replace single characters of plaintext with predefined single characters of cipher-text 
(e.g. the plain-text character `a' might be replaced by cipher text character 'q', 'b' might be 
replaced by 'x', 'c' by 'k' and so on).  Each plain-text character should be replaced by a 
different cipher-text character.

As part of your solution you must write and use at least the following functions/methods:
(i) createCipher() which determines and returns the mapping from plain text to cipher text.
Each plain text character ('a' .. 'z', ' ') must be randomly assigned a cipher-text character;
(ii) an encrypt() method which takes a plain text phrase (as an array of characters) & the cipher 
and returns an encrypted version of the phrase according to the substitution cipher;
(iii) a decrypt() which takes an encrypted phrase (as an array of characters) & the cipher mapping 
and returns a plain text version of the phrase according to the substitution cipher

Hints:
A 27 element 1-D array (26 letters and the space character) can be used for the mapping where 
each element is the cipher-text character corresponding to a particular letter.

Given a String called myString you can create an array of characters as follows:
- char[] characterArray = myString.toCharArray();

To convert back to a String:
- String anotherString = new String( characterArray );

To convert a String to lowercase:
- String lowercaseString = myString.toLowerCase(); 
*/

/* 
SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5
        Comment: All the variables are self-explanatory and properly formatted
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: All the code is indented properly
 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20
       Comment: The createCipher function uses the correct parameters, returns an array, works as intended and is invoked correctly
 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20
       Comment: The encrypt function uses the correct parameters, returns a String (the encrypted phrase), works as intended and is invoked correctly
 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20
       Comment: The decrypt function uses the correct parameters, returns a String (the decrypted phrase), works as intended and is invoked correctly
 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
       Mark out of 25: 25
       Comment: The main function is written and works correctly
 7. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: It's all accurate
 Total Mark out of 100 (Add all the previous marks): 100
 */
import java.util.Random;
import java.util.Scanner;

public class Cipher {

	public static final char[] ALPHABET_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
												'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
												'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
	
	public static void main(String[] args) {
		boolean finished = false;
		Scanner inputScanner = new Scanner(System.in);
		do {
			System.out.print("Enter a phrase to encrypt (or 'quit' to exit): ");
			if (inputScanner.hasNext("quit")) {
				System.out.println("Goodbye.");
				finished = true;
			} else {
				String userPhrase = inputScanner.nextLine();	
				System.out.println("Your phrase: " + userPhrase.toLowerCase());
				char[] cipherArray = createCipher();
				String encryptedUserPhrase = encrypt(userPhrase, cipherArray);
				System.out.println("Encrypted: " + encryptedUserPhrase);
				String origUserPhrase = decrypt(encryptedUserPhrase, cipherArray);
				System.out.println("Decrypted: " + origUserPhrase);
			}	
		} while (!finished);
		inputScanner.close();
	}
	
	// Determines and returns the mapping from plain text to cipher text
	public static char[] createCipher() {
		char[] cipherArray = new char[27];
		char[] tempAlphabet = ALPHABET_LETTERS;
		int count = 0;
		while (tempAlphabet.length > 0) {
			int randomLetterAddr = new Random().nextInt(tempAlphabet.length);
		    char randomLetter = tempAlphabet[randomLetterAddr];
		    cipherArray[count] = randomLetter;
		    int j = 0;
			char[] secondTemp = new char[tempAlphabet.length - 1];
			for (int i = 0; i < tempAlphabet.length; i++) {
			   if (tempAlphabet[i] != randomLetter) {
			       secondTemp[j++] = tempAlphabet[i];
			   }
			}
		    tempAlphabet = secondTemp;
		    count++;
		}
		return cipherArray;
	}
	
	// Returns an encrypted version of a phrase according to a substitution cipher
	public static String encrypt(String userPhrase, char[] cipherArray) {
		userPhrase = userPhrase.toLowerCase();
		char[] charArray = userPhrase.toCharArray();
		for (int i = 0; i <= charArray.length-1; i++) {
			switch(charArray[i]) {
			case 'a':
				charArray[i] = cipherArray[0];
				break;
			case 'b':
				charArray[i] = cipherArray[1];
				break;
			case 'c':
				charArray[i] = cipherArray[2];
				break;
			case 'd':
				charArray[i] = cipherArray[3];
				break;
			case 'e':
				charArray[i] = cipherArray[4];
				break;
			case 'f':
				charArray[i] = cipherArray[5];
				break;
			case 'g':
				charArray[i] = cipherArray[6];
				break;
			case 'h':
				charArray[i] = cipherArray[7];
				break;
			case 'i':
				charArray[i] = cipherArray[8];
				break;
			case 'j':
				charArray[i] = cipherArray[9];
				break;
			case 'k':
				charArray[i] = cipherArray[10];
				break;
			case 'l':
				charArray[i] = cipherArray[11];
				break;
			case 'm':
				charArray[i] = cipherArray[12];
				break;
			case 'n':
				charArray[i] = cipherArray[13];
				break;
			case 'o':
				charArray[i] = cipherArray[14];
				break;
			case 'p':
				charArray[i] = cipherArray[15];
				break;
			case 'q':
				charArray[i] = cipherArray[16];
				break;
			case 'r':
				charArray[i] = cipherArray[17];
				break;
			case 's':
				charArray[i] = cipherArray[18];
				break;
			case 't':
				charArray[i] = cipherArray[19];
				break;
			case 'u':
				charArray[i] = cipherArray[20];
				break;
			case 'v':
				charArray[i] = cipherArray[21];
				break;
			case 'w':
				charArray[i] = cipherArray[22];
				break;
			case 'x':
				charArray[i] = cipherArray[23];
				break;
			case 'y':
				charArray[i] = cipherArray[24];
				break;
			case 'z':
				charArray[i] = cipherArray[25];
				break;
			case ' ':
				charArray[i] = cipherArray[26];
				break;
			}
		}
		String encryptedUserPhrase = new String(charArray);
		return encryptedUserPhrase;
	}
	
	// Returns a plain text version of an encrypted phrase according to a substitution cipher
	public static String decrypt(String encryptedUserPhrase, char[] cipherArray) {
		char[] charArray = encryptedUserPhrase.toCharArray();		
		for (int i = 0; i <= charArray.length-1; i++) {
			for (int j = 0; j <= cipherArray.length-1; j++) {
				if (charArray[i] == cipherArray[j]) {
					charArray[i] = ALPHABET_LETTERS[j];
					break;
				}
			}
		}
		String origUserPhrase = new String(charArray);
		return origUserPhrase;
	}
	
}