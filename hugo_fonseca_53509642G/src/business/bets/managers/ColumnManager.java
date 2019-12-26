package business.bets.managers;

import business.bets.Bet;
import business.bets.BetStatus;
import business.roulette.Roulette;

public class ColumnManager implements BetManager {

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
		if ((int) bet.getType().getPlayerBet() == r.getRoundResult().getColumn()) {
			bet.setStatus(BetStatus.WON);
		} else {
			bet.setStatus(BetStatus.LOST);
		}
	}

}
