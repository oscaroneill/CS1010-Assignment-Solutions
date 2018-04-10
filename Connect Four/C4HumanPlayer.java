public class C4HumanPlayer extends ConnectPlayer {
	
	String playerType = "Human";
	String playerPiece;
	
	public String getPlayerType() {
		return playerType;
	}
	
	public String getPlayerPiece() {
		return playerPiece;
	}

	public void setPlayerPiece(String piece) {
		playerPiece = piece;
	}
}