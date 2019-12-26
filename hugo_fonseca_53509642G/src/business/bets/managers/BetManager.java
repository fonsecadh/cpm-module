package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;

public interface BetManager {
	
	// Evaluate bet
	BetStatus evaluateBet(Bet bet);

}
