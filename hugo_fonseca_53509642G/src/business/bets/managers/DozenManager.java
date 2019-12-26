package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.roulette.Roulette;

public class DozenManager implements BetManager {
	
	@Override
	public BetStatus evaluateBet(Bet bet) {
		Roulette r = Roulette.getInstance();
		
		// Special case: Zero
		if (r.getRoundResult().getNumber() == 0) {
			return BetStatus.ZERO;
		}
		
		if ((int) bet.getType().getPlayerBet() == r.getRoundResult().getDozen()) {
			return BetStatus.WON;
		} else {
			return BetStatus.LOST;
		}
	}

}
