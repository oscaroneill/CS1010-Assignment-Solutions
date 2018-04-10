public class C4RandomAIPlayer extends ConnectPlayer {
	
	String playerType = "AI";
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