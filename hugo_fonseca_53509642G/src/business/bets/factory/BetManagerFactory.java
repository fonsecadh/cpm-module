package business.bets.factory;

import business.bets.managers.ColumnManager;
import business.bets.managers.DozenManager;
import business.bets.managers.FailPassManager;
import business.bets.managers.NumberManager;
import business.bets.managers.OddEvenManager;
import business.bets.managers.RedBlackManager;

public interface BetManagerFactory {
	
	ColumnManager makeColumnManager();
	DozenManager makeDozenManager();
	FailPassManager makeFailPassManager();
	NumberManager makeNumberManager();
	OddEvenManager makeOddEvenManager();
	RedBlackManager makeRedBlackManager();

}
