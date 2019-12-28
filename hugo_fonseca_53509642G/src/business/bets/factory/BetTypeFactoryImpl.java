package business.bets.factory;

import business.bets.types.BetType;
import business.bets.types.ColumnType;
import business.bets.types.DozenType;
import business.bets.types.FailPassType;
import business.bets.types.NumberType;
import business.bets.types.OddEvenType;
import business.bets.types.RedBlackType;

public class BetTypeFactoryImpl implements BetTypeFactory {

	@Override
	public BetType<Integer> makeColumnType() {
		return new ColumnType();
	}

	@Override
	public BetType<Integer> makeDozenType() {
		return new DozenType();
	}

	@Override
	public BetType<Boolean> makeFailPassType() {
		return new FailPassType();
	}

	@Override
	public BetType<Integer> makeNumberType() {
		return new NumberType();
	}

	@Override
	public BetType<Boolean> makeOddEvenType() {
		return new OddEvenType();
	}

	@Override
	public BetType<Boolean> makeRedBlackType() {
		return new RedBlackType();
	}

}
