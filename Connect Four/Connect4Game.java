/* SELF ASSESSMENT

Connect4Game class (35/35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: I do all of this, checking for errors with hasNextInt() and using a while loop for the main part of the game.

Connect4Grid interface (10/10 marks)
I define all 7 methods within this interface.
Comment: I do this.

Connect4Grid2DArray class (25/25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: I do all of this, using constants to go through the array, and using multiple for and while loops to check if the last piece dropped won the game. 

ConnectPlayer abstract class (5/10 marks)
My class provides at least one non-abstract method and at least one abstract method. 
Comment: My class only provides abstract methods. 

C4HumanPlayer class (10/10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class does this, specifying itself as a “Human” playerType.

C4RandomAIPlayer class (10/10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: My class does this, specifying itself as an “AI” playerType.

Total Marks out of 100: 95

*/

import java.util.Random;
import java.util.Scanner;

public class Connect4Game {

	static final int PLAY_PLAYER = 1;
	static final int PLAY_AI = 2;
	static final String PLAYER_TYPE_HUMAN = "Human";
	static final String PLAYER_TYPE_AI = "AI";
	public static final String PIECE_X = "X";
	public static final String PIECE_O = "O";
	
	public static void main(String[] args) {
		System.out.println("1. Another player.");
		System.out.println("2. AI.");
		System.out.println("Who would you like to play against? ");
		Scanner inputScanner = new Scanner(System.in);
		int userOpponentChoice = -1;
		if (inputScanner.hasNextInt()) {
			userOpponentChoice = inputScanner.nextInt();
			
			ConnectPlayer playerOne = new C4HumanPlayer();
			ConnectPlayer playerTwo = null;
			
			switch (userOpponentChoice) {
			case PLAY_PLAYER:
				playerTwo = new C4HumanPlayer();
				break;
			case PLAY_AI:
				playerTwo = new C4RandomAIPlayer();
				break;
			}
			
			Connect4Grid2DArray grid = new Connect4Grid2DArray();
			ConnectPlayer currentPlayer = playerOne;
			boolean finished = false;
			int columnChoice = -1;
			Random random = new Random();
			
			int colourChoice = random.nextInt(2);
			if (colourChoice == 0) {
				playerOne.setPlayerPiece(PIECE_X);
				playerTwo.setPlayerPiece(PIECE_O);
			} else if (colourChoice == 1) {
				playerOne.setPlayerPiece(PIECE_O);
				playerTwo.setPlayerPiece(PIECE_X);
			}
			
			grid.emptyGrid();
			while (!finished) {
				System.out.println(grid.toString());
				if (!grid.isGridFull()) {
					System.out.println("" + currentPlayer.getPlayerPiece() + "'s turn.");
					if (currentPlayer.getPlayerType() == PLAYER_TYPE_HUMAN) {
						inputScanner = new Scanner(System.in);
						System.out.println("Which column would you like to drop a piece? (Or enter 0 to exit)");
						if (inputScanner.hasNextInt()) {
							columnChoice = inputScanner.nextInt();
						} else {
							System.out.println("Invalid input.");
							columnChoice = -1;
						}
					} else {
						columnChoice = random.nextInt(Connect4Grid2DArray.NUM_OF_COLUMNS) + 1;
					}
					
					if (columnChoice == 0) {
						System.out.println("Exited.");
						finished = true;
					} else if (grid.isValidColumn(columnChoice)) {
						grid.dropPiece(currentPlayer, columnChoice);
						if (grid.didLastPieceConnect4()) {
							System.out.println(grid.toString());
							System.out.println("" + currentPlayer.getPlayerPiece() + " wins!");
							finished = true;
						} else if (currentPlayer == playerOne) {
							currentPlayer = playerTwo;
						} else {
							currentPlayer = playerOne;
						}
					}			
				} else {
					finished = true;
				}
			}
		} else {
			System.out.println("Invalid input.");
		}
		inputScanner.close();
	}
}