package business.bets.factory;

import business.bets.managers.BetManager;

public interface BetManagerFactory {
	
	BetManager makeColumnManager();
	BetManager makeDozenManager();
	BetManager makeFailPassManager();
	BetManager makeNumberManager();
	BetManager makeOddEvenManager();
	BetManager makeRedBlackManager();

}
