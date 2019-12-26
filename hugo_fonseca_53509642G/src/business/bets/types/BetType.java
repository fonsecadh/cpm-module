package business.bets.types;

public interface BetType<T> {	
	
	// Multiplier
	double getMultiplier();
	
	// Player Bet
	T getPlayerBet();
	void setPlayerBet(T playerBet);

}
