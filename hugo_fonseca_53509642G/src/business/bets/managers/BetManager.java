package business.bets.managers;

import business.bets.Bet;

public interface BetManager {
	
	// Bet
	Bet getBet();
	void setBet(Bet bet);
	
	// Evaluate bet
	void evaluateBet();

}
