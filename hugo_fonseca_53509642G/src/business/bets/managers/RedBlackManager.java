package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.bets.types.RedBlackType;
import business.roulette.Roulette;

public class RedBlackManager implements BetManager {

	@Override
	public BetStatus evaluateBet(Bet bet) {
		Roulette r = Roulette.getInstance();
		if ((boolean) bet.getType().getPlayerBet() == RedBlackType.RED 
				&& r.getRoundResult().isRed()) {
			return BetStatus.WON;
		} else if ((boolean) bet.getType().getPlayerBet() == !RedBlackType.RED 
				&& !r.getRoundResult().isRed()) {
			return BetStatus.WON;
		} else {
			return BetStatus.LOST;
		}
	}

}
