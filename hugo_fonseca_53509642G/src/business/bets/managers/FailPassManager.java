package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.bets.types.FailPassType;
import business.roulette.Roulette;

public class FailPassManager implements BetManager {

	// Attributes
	private Bet bet;
	

	@Override
	public Bet getBet() {
		return bet;
	}

	@Override
	public void setBet(Bet bet) {
		this.bet = bet;
	}

	@Override
	public void evaluateBet() {
		Roulette r = Roulette.getInstance();
		if ((boolean) bet.getType().getPlayerBet() == FailPassType.PASS 
				&& r.getRoundResult().hasPassed()) {
			bet.setStatus(BetStatus.WON);
		} else if ((boolean) bet.getType().getPlayerBet() == !FailPassType.PASS 
				&& !r.getRoundResult().hasPassed()) {
			bet.setStatus(BetStatus.WON);
		} else {
			bet.setStatus(BetStatus.LOST);
		}
	}

}
