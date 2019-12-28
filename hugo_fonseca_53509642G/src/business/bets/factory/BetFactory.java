package business.bets.factory;

import business.bets.Bet;

public interface BetFactory {
	
	Bet makeColumnBet(double amount, int playerBet);
	Bet makeDozenBet(double amount, int playerBet);
	Bet makeFailPassBet(double amount, boolean playerBet);
	Bet makeNumberBet(double amount, int playerBet);
	Bet makeOddEvenBet(double amount, boolean playerBet);
	Bet makeRedBlackBet(double amount, boolean playerBet);

}
