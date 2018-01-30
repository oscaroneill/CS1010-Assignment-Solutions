/* SELF ASSESSMENT 
1. clearBoard:
	- Did I use the correct method definition?
	Mark out of 5: 5
	Comment: The method definition is correct
	- Did I use loops to set each position to the BLANK character?
	Mark out of 5: 5
	Comment: I did that
2. printBoard
	- Did I use the correct method definition?
	Mark out of 5: 5
	Comment: The method definition is correct
	- Did I loop through the array and prints out the board in a way that it looked like a board?
	Mark out of 5: 5
	Comment: I used "|", "-" and "+" around the array elements to make the board look like a board
3. canMakeMove
	- Did I have the correct function definition and returned the correct item?
	Mark out of 5: 5
	Comment: I did
	- Did I check if a specified location was BLANK?
	Mark out of 5: 5
	Comment: I did
4. makeMove
	- Did I have the correct function definition?
	Mark out of 5: 5
	Comment: The function definition is correct
	- Did I set the currentPlayerPiece in the specified location?
	Mark out of 5: 5
	Comment: The currentPlayerPiece gets set to the specified location
5. isBoardFull
	- Did I have the correct function definition and returned the correct item?
	Mark out of 5: 5
	Comment: The definition and return are correct
	- Did I loop through the board to check if there are any BLANK characters?
	Mark out of 5: 5
	Comment: Yes
6. winner
	- Did I have the correct function definition and returned the winning character
	Mark out of 5: 5
	Comment: The function definition and return are correct
	- Did I identify all possible horizontal, vertical and diagonal winners  
	Mark out of 15: 15
	Comment: I did
7.main
	- Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
	Mark out of 3: 3
	Comments: I did
	- Did I loop asking the user for a location until wither the board was full or there was a winner?
	Mark out of 5: 5
	Comments: I did
	- Did I call all of the methods above?
	Mark out of 5: 5
	Comments: I did
	- Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
	Mark out of 3: 3
	Comments: Yes
	- Did I switch the current player piece from cross to nought and vice versa after every valid move?
	Mark out of 3: 3
	Comments: Yes
	- Did I display the winning player piece or a draw at the end of the game?
	Mark out of 3: 3
	Comments: I did
8. Overall
	- Is my code indented correctly?
	Mark out of 3: 3
	Comments: All the code is formatted properly
	- Do my variable names and Constants (at least four of them) make sense?
	Mark out of 3: 3
	Comments: The names are all self-explanatory and I used four constants
	- Do my variable names, method names and class name follow the Java coding standard
	Mark out of 2: 2
	Comments: They do
Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class NoughtsAndCrosses {

	public static final int NUMBER_OF_ROWS = 3;
	public static final int NUMBER_OF_COLUMNS = 3;
	public static final char X_PIECE_CHAR = 'x';
	public static final char O_PIECE_CHAR = 'o';
	
	public static void main(String[] args) {
		char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		clearBoard(board);
		Scanner inputScanner = new Scanner(System.in);
		int userRow = -1;
		int userColumn = -1;
		boolean isFinished = false;
		char currentPiece = X_PIECE_CHAR;
		while(!isFinished) {
			System.out.print("Co-ords for " + currentPiece + "'s move (row, column): ");
			inputScanner = new Scanner(System.in);
			inputScanner.useDelimiter(", |\r");
			if (inputScanner.hasNextInt()) {
				userRow = inputScanner.nextInt();
				if (inputScanner.hasNextInt()) {
					userColumn = inputScanner.nextInt();
					if (!isBoardFull(board) && canMakeMove(board, userRow, userColumn)) {
						makeMove(board, currentPiece, userRow, userColumn);
						if (currentPiece == X_PIECE_CHAR) {
							currentPiece = O_PIECE_CHAR;
						} else if (currentPiece == O_PIECE_CHAR) {
							currentPiece = X_PIECE_CHAR;
						}
					} else if (!canMakeMove(board, userRow, userColumn)) {
						System.out.println("Cannot make that move.");
					}
					printBoard(board);
					if (isBoardFull(board)) {
						System.out.println("There is no winner.");
						isFinished = true;
					} else if (winner(board) != ' ') {
						System.out.println("The winner is " + winner(board) + ".");
						isFinished = true;
					}
				} else {
					System.out.println("Invalid input.");
				}
			} else {
				System.out.println("Invalid input.");
			}
		}
		inputScanner.close();
	}
	
	public static void clearBoard(char[][] board) {
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public static void printBoard(char[][] board) {	
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				if (i > 0 && j == 0) {
					System.out.print("- + - + -\n");
				}
				System.out.print(board[i][j]);
				if (j < NUMBER_OF_COLUMNS-1) {
					System.out.print(" | ");
				}
				if (j == NUMBER_OF_COLUMNS-1) {
					System.out.print("\n");
				}
			}
		}	
	}
	
	public static boolean canMakeMove(char[][] board, int row, int column) {
		if (row <= NUMBER_OF_ROWS && column <= NUMBER_OF_COLUMNS && board[row-1][column-1] == ' ') {
			return true;
		} else {
			return false;
		}
	}
	
	public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column) {
		board[row-1][column-1] = currentPlayerPiece;
	}
	
	public static boolean isBoardFull(char[][] board) {
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public static char winner(char[][] board) {
		char currentChar = ' ';
		// Row check
		currentChar = board[0][0];
		if (board[0][1] == currentChar && board[0][2] == currentChar) {
			return currentChar;
		}
		currentChar = board[1][0];
		if (board[1][1] == currentChar && board[1][2] == currentChar) {
			return currentChar;
		}
		currentChar = board[2][0];
		if (board[2][1] == currentChar && board[2][2] == currentChar) {
			return currentChar;
		}
		// Column check
		currentChar = board[0][0];
		if (board[1][0] == currentChar && board[2][0] == currentChar) {
			return currentChar;
		}
		currentChar = board[0][1];
		if (board[1][1] == currentChar && board[2][1] == currentChar) {
			return currentChar;
		}
		currentChar = board[0][2];
		if (board[1][2] == currentChar && board[2][2] == currentChar) {
			return currentChar;
		}
		// Diagonal check
		currentChar = board[0][0];
		if (board[1][1] == currentChar && board[2][2] == currentChar) {
			return currentChar;
		}
		currentChar = board[2][0];
		if (board[1][1] == currentChar && board[0][2] == currentChar) {
			return currentChar;
		}
		return ' ';
	}
}