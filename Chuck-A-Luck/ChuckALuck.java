/* SELF ASSESSMENT 
1. ResolveBet
- I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: The function definition is correct with the right arguments and return type.
- My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: The function does that using two System.out statements.
- My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: The function does that by calling the check() method from the Wallet class.
- My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15].
Comment: The function does this with the diceOne, diceTwo, diceThree, rollOne, rollTwo, rollThree and rollTotal variables.
- My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: The function does this using different comparison operations.
- My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: The function does this with a System.out statement and the put() function from the Wallet class.

2. Main
- I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: The mainline does this with a System.out statement, an object declaration and the put() function from the Wallet class.
- My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: The mainline does this using the check() function from the Wallet class and the equals() function to compare Strings.
- I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: The mainline does this using a System.out statement.
- My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: The mainline does this.
- At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: The mainline outputs a message telling the user how much money they started with and how much money they ended with.

 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class ChuckALuck {
	
	public static void main(String[] args) {
		System.out.print("How much cash do you have?: ");
		Scanner inputScanner = new Scanner(System.in);
		if (inputScanner.hasNextInt()) {
			int initPlayerCash = inputScanner.nextInt();
			if (initPlayerCash < 0) {
				System.out.println("Invalid amount of cash.");
			} else {
				int playerCash = initPlayerCash;
				Wallet playerWallet = new Wallet();
				playerWallet.put(playerCash);
				boolean finished = false;
				while (!finished) {
					if (playerWallet.check() == 0) {
						finished = true;
					} else {
						System.out.print("Place your bet (Triple, Field, High, or Low) or enter 'quit': ");
						String userInput = "";
						if (inputScanner.hasNext()) {
							userInput = inputScanner.next();
							if (userInput.equals("quit")) {
								finished = true;
							} else if (userInput.equals("Triple") || 
									userInput.equals("Field") || 
									userInput.equals("High") || 
									userInput.equals("Low")) {
								resolveBet(userInput, playerWallet);
							} else {
								System.out.println("Invalid input.");
							}
						} else {
							System.out.println("No input available!");				
						}
					}
					playerCash = (int)(playerWallet.check());
				}
				inputScanner.close();
				System.out.println("You now have €" + playerCash + " after starting with €" + 
						initPlayerCash);
			}
		} else {
			System.out.println("Invalid input.");
		}
	}
	
	public static void resolveBet(String betType, Wallet wallet) {
		System.out.println("You have €" + wallet.check());
		System.out.print("How much would you like to bet?: ");
		Scanner inputScanner = new Scanner(System.in);
		int betAmount = -1;
		if (inputScanner.hasNextInt()) {
			betAmount = inputScanner.nextInt();
			if (betAmount < 0) {
				System.out.println("Invalid betting amount.");
			} else {
				if (betAmount > wallet.check()) {
					System.out.println("You don't have enough money for that bet.");
				} else {
					Dice diceOne = new Dice();
					Dice diceTwo = new Dice();
					Dice diceThree = new Dice();
					int rollOne = diceOne.roll();
					int rollTwo = diceTwo.roll();
					int rollThree = diceThree.roll();
					int rollTotal = rollOne + rollTwo + rollThree;
					switch (betType) {
					case "Triple":
						if ((rollOne == rollTwo && rollTwo == rollThree) && 
								(rollOne != 1 && rollOne != 6)) {
							System.out.println("Win!");
							wallet.put(betAmount * 30);
						} else {
							System.out.println("Loss!");
							wallet.get(betAmount);
						}
						break;
					case "Field":
						if ((rollTotal < 8) || (rollTotal > 12)) {
							System.out.println("Win!");
							wallet.put(betAmount);
						} else {
							System.out.println("Loss!");
							wallet.get(betAmount);
						}
						break;
					case "High":
						if ((rollOne != rollTwo || rollTwo != rollThree || rollThree != rollOne) && 
								(rollTotal > 10)) {
							System.out.println("Win!");
							wallet.put(betAmount);
						} else {
							System.out.println("Loss!");
							wallet.get(betAmount);
						}
						break;
					case "Low":
						if ((rollOne != rollTwo || rollTwo != rollThree || rollThree != rollOne) && 
								(rollTotal < 11)) {
							System.out.println("Win!");
							wallet.put(betAmount);
						} else {
							System.out.println("Loss!");
							wallet.get(betAmount);
						}
						break;
					}	
				}
			}
		} else {
			System.out.println("Invalid input.");
		}
	}
}