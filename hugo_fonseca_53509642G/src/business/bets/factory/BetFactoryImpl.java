package business.bets.factory;

import business.bets.Bet;
import business.bets.BetImpl;

public class BetFactoryImpl implements BetFactory {

	@Override
	public Bet makeBet() {
		return new BetImpl();
	}

}
