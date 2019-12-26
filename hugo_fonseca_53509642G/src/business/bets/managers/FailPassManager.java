package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.bets.types.FailPassType;
import business.roulette.Roulette;

public class FailPassManager implements BetManager {

	@Override
	public BetStatus evaluateBet(Bet bet) {
		Roulette r = Roulette.getInstance();
		
		// Special case: Zero
		if (r.getRoundResult().getNumber() == 0) {
			return BetStatus.ZERO;
		}
		
		if ((boolean) bet.getType().getPlayerBet() == FailPassType.PASS 
				&& r.getRoundResult().hasPassed()) {
			return BetStatus.WON;
		} else if ((boolean) bet.getType().getPlayerBet() == !FailPassType.PASS 
				&& !r.getRoundResult().hasPassed()) {
			return BetStatus.WON;
		} else {
			return BetStatus.LOST;
		}
	}

}
