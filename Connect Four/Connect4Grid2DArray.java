public class Connect4Grid2DArray implements Connect4Grid {
	
	static final int NUM_OF_ROWS = 6;
	static final int NUM_OF_COLUMNS = 7;
	static final String EMPTY_SLOT = " ";
	
	String[][] gridArray = new String[NUM_OF_ROWS][NUM_OF_COLUMNS];

	public void emptyGrid() {
		for (int i = 0; i < NUM_OF_ROWS; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				gridArray[i][j] = EMPTY_SLOT;
			}
		}
	}

	public String toString() {
		String gridString = "";
		
		gridString += "|-+-+-+-+-+-+-|\n";
		gridString += "|"+gridArray[0][0]+"|"+gridArray[0][1]+"|"+gridArray[0][2]+"|"
		+gridArray[0][3]+"|"+gridArray[0][4]+"|"+gridArray[0][5]+"|"+gridArray[0][6]+"|\n";
		gridString += "|-+-+-+-+-+-+-|\n";
		gridString += "|"+gridArray[1][0]+"|"+gridArray[1][1]+"|"+gridArray[1][2]+"|"
		+gridArray[1][3]+"|"+gridArray[1][4]+"|"+gridArray[1][5]+"|"+gridArray[1][6]+"|\n";
		gridString += "|-+-+-+-+-+-+-|\n";
		gridString += "|"+gridArray[2][0]+"|"+gridArray[2][1]+"|"+gridArray[2][2]+"|"
		+gridArray[2][3]+"|"+gridArray[2][4]+"|"+gridArray[2][5]+"|"+gridArray[2][6]+"|\n";
		gridString += "|-+-+-+-+-+-+-|\n";
		gridString += "|"+gridArray[3][0]+"|"+gridArray[3][1]+"|"+gridArray[3][2]+"|"
		+gridArray[3][3]+"|"+gridArray[3][4]+"|"+gridArray[3][5]+"|"+gridArray[3][6]+"|\n";
		gridString += "|-+-+-+-+-+-+-|\n";
		gridString += "|"+gridArray[4][0]+"|"+gridArray[4][1]+"|"+gridArray[4][2]+"|"
		+gridArray[4][3]+"|"+gridArray[4][4]+"|"+gridArray[4][5]+"|"+gridArray[4][6]+"|\n";
		gridString += "|-+-+-+-+-+-+-|\n";
		gridString += "|"+gridArray[5][0]+"|"+gridArray[5][1]+"|"+gridArray[5][2]+"|"
		+gridArray[5][3]+"|"+gridArray[5][4]+"|"+gridArray[5][5]+"|"+gridArray[5][6]+"|\n";
		gridString += "|-+-+-+-+-+-+-|\n";
		
		return gridString;
	}

	public boolean isValidColumn(int column) {
		if (column >= 1 && column <= NUM_OF_COLUMNS && !isColumnFull(column)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isColumnFull(int column) {
		if (gridArray[0][column-1] == EMPTY_SLOT) {
			return false;
		} else {
			return true;
		}
	}

	public void dropPiece(ConnectPlayer player, int column) {
		boolean pieceDropped = false;
		for (int i = 0; i < NUM_OF_ROWS && !pieceDropped; i++) {
			if (gridArray[NUM_OF_ROWS-1][column-1] == EMPTY_SLOT) {
				gridArray[NUM_OF_ROWS-1][column-1] = player.getPlayerPiece();
				pieceDropped = true;
			} else if (gridArray[i+1][column-1] != EMPTY_SLOT) {
				gridArray[i][column-1] = player.getPlayerPiece();
				pieceDropped = true;
			}
		}
	}
	
	public boolean didLastPieceConnect4() {
		int currentRow = 5;
		int streakCount = 0;
		int rowIncrement = 1;
		int colIncrement = 1;
		for(; currentRow >= 0; currentRow--) {
			int currentCol = 6;
			for(; currentCol >= 0; currentCol--) {
				if(gridArray[currentRow][currentCol] != EMPTY_SLOT) {
					String piece = gridArray[currentRow][currentCol];
					while(rowIncrement <= 3) {
						try {
							if(gridArray[currentRow + rowIncrement][currentCol] == piece) {
								streakCount++;
								if(streakCount == 4) {
									return true;
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							break;
						}
						rowIncrement++;
					}
					streakCount = 0;
					rowIncrement = 0;
					colIncrement = 0;
					while(colIncrement <= 3) {
						try {
							if(gridArray[currentRow][currentCol + colIncrement] == piece) {
								streakCount++;
								if(streakCount == 4) {
									return true;
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							break;
						}
						colIncrement++;
					}
					streakCount = 0;
					rowIncrement = 0;
					colIncrement = 0;
					while(rowIncrement <= 3) {
						try {
							if(gridArray[currentRow + rowIncrement][currentCol + colIncrement] == piece) {
								streakCount++;
								if(streakCount == 4) {
									return true;
								}
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							break;
						}
						rowIncrement++;
						colIncrement++;
					}
					streakCount = 0;
					rowIncrement = 0;
					colIncrement = 0;
					while(rowIncrement <= 3) {
						try {
							if(gridArray[currentRow + rowIncrement][currentCol + colIncrement] == piece) {
								streakCount++;
								if(streakCount == 4) {
									return true;
								}
							} 
						} catch (ArrayIndexOutOfBoundsException e) {
							break;
						}
						rowIncrement++;
						colIncrement--;
					}
					streakCount = 0;
					rowIncrement = 0;
					colIncrement = 0;
				} 
			}
		}
		return false;
	}
	
	public boolean isGridFull() {
		for (int i = 0; i < NUM_OF_ROWS; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (gridArray[i][j] == EMPTY_SLOT) {
					return false;
				}
			}
		}
		return true;
	}
}