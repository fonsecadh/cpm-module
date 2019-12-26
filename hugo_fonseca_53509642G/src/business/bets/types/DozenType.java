package business.bets.types;

public class DozenType implements BetType<Integer> {

	// Attributes
	private Integer playerBet;
	

	@Override
	public double getMultiplier() {
		return 2;
	}

	@Override
	public Integer getPlayerBet() {
		return playerBet;
	}

	@Override
	public void setPlayerBet(Integer playerBet) {
		this.playerBet = playerBet;
	}

}
