package business.bets.types;

public class FailPassType implements BetType<Boolean> {

	// Constants
	public static final boolean PASS = true;
	public static final boolean FAIL = false;
	
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
		return "Fail/Pass";
	}

}
