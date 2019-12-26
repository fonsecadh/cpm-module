package business.bets.factory;

import business.bets.types.ColumnType;
import business.bets.types.DozenType;
import business.bets.types.FailPassType;
import business.bets.types.NumberType;
import business.bets.types.OddEvenType;
import business.bets.types.RedBlackType;

public class BetTypeFactoryImpl implements BetTypeFactory {

	@Override
	public ColumnType makeColumnType() {
		return new ColumnType();
	}

	@Override
	public DozenType makeDozenType() {
		return new DozenType();
	}

	@Override
	public FailPassType makeFailPassType() {
		return new FailPassType();
	}

	@Override
	public NumberType makeNumberType() {
		return new NumberType();
	}

	@Override
	public OddEvenType makeOddEvenType() {
		return new OddEvenType();
	}

	@Override
	public RedBlackType makeRedBlackType() {
		return new RedBlackType();
	}

}
