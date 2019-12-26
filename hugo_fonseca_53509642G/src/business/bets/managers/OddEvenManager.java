package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.bets.types.OddEvenType;
import business.roulette.Roulette;

public class OddEvenManager implements BetManager {
	
	@Override
	public BetStatus evaluateBet(Bet bet) {
		Roulette r = Roulette.getInstance();
		if ((boolean) bet.getType().getPlayerBet() == OddEvenType.EVEN 
				&& r.getRoundResult().isEven()) {
			return BetStatus.WON;
		} else if ((boolean) bet.getType().getPlayerBet() == !OddEvenType.EVEN 
				&& !r.getRoundResult().isEven()) {
			return BetStatus.WON;
		} else {
			return BetStatus.LOST;
		}
	}

}
