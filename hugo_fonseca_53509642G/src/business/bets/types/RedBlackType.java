package business.bets.types;

public class RedBlackType implements BetType<Boolean> {
	
	// Constants
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	// Attributes
	private boolean playerBet;
	

	@Override
	public double getMultiplier() {
		return 1;
	}

	@Override
	public Boolean getPlayerBet() {
		return playerBet;
	}

	@Override
	public void setPlayerBet(Boolean playerBet) {
		this.playerBet = playerBet;
	}
	
	@Override
	public String toString() {
		return "Red/Black";
	}

}
