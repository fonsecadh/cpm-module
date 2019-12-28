package business.bets.factory;

import business.bets.managers.BetManager;
import business.bets.managers.ColumnManager;
import business.bets.managers.DozenManager;
import business.bets.managers.FailPassManager;
import business.bets.managers.NumberManager;
import business.bets.managers.OddEvenManager;
import business.bets.managers.RedBlackManager;

public class BetManagerFactoryImpl implements BetManagerFactory {

	@Override
	public BetManager makeColumnManager() {
		return new ColumnManager();
	}

	@Override
	public BetManager makeDozenManager() {
		return new DozenManager();
	}

	@Override
	public BetManager makeFailPassManager() {
		return new FailPassManager();
	}

	@Override
	public BetManager makeNumberManager() {
		return new NumberManager();
	}

	@Override
	public BetManager makeOddEvenManager() {
		return new OddEvenManager();
	}

	@Override
	public BetManager makeRedBlackManager() {
		return new RedBlackManager();
	}

}
