package business.bets.factory;

import business.bets.managers.ColumnManager;
import business.bets.managers.DozenManager;
import business.bets.managers.FailPassManager;
import business.bets.managers.NumberManager;
import business.bets.managers.OddEvenManager;
import business.bets.managers.RedBlackManager;

public class BetManagerFactoryImpl implements BetManagerFactory {

	@Override
	public ColumnManager makeColumnManager() {
		return new ColumnManager();
	}

	@Override
	public DozenManager makeDozenManager() {
		return new DozenManager();
	}

	@Override
	public FailPassManager makeFailPassManager() {
		return new FailPassManager();
	}

	@Override
	public NumberManager makeNumberManager() {
		return new NumberManager();
	}

	@Override
	public OddEvenManager makeOddEvenManager() {
		return new OddEvenManager();
	}

	@Override
	public RedBlackManager makeRedBlackManager() {
		return new RedBlackManager();
	}

}
