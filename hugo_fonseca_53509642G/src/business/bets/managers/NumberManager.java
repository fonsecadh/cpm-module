package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.roulette.Roulette;

public class NumberManager implements BetManager {

	@Override
	public BetStatus evaluateBet(Bet bet) {
		Roulette r = Roulette.getInstance();
		if ((int) bet.getType().getPlayerBet() == r.getRoundResult().getNumber()) {
			return BetStatus.WON;
		} else {
			return BetStatus.LOST;
		}
	}

}
