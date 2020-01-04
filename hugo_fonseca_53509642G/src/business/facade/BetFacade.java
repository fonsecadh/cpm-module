package business.facade;

import business.bets.Bet;
import business.bets.factory.BetFactory;
import business.bets.factory.BetFactoryImpl;

public class BetFacade {

	// Attributes
	private BetFactory betFactory = new BetFactoryImpl();

	public Bet makeColumnBet(double amount, int playerBet) {
		return betFactory.makeColumnBet(amount, playerBet);
	}

	public Bet makeDozenBet(double amount, int playerBet) {
		return betFactory.makeDozenBet(amount, playerBet);
	}

	public Bet makeFailPassBet(double amount, boolean playerBet) {
		return betFactory.makeFailPassBet(amount, playerBet);
	}

	public Bet makeNumberBet(double amount, int playerBet) {
		return betFactory.makeNumberBet(amount, playerBet);
	}

	public Bet makeOddEvenBet(double amount, boolean playerBet) {
		return betFactory.makeOddEvenBet(amount, playerBet);
	}

	public Bet makeRedBlackBet(double amount, boolean playerBet) {
		return betFactory.makeRedBlackBet(amount, playerBet);
	}

}
