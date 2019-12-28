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
	public BetType<?> makeColumnType() {
		return new ColumnType();
	}

	@Override
	public BetType<?> makeDozenType() {
		return new DozenType();
	}

	@Override
	public BetType<?> makeFailPassType() {
		return new FailPassType();
	}

	@Override
	public BetType<?> makeNumberType() {
		return new NumberType();
	}

	@Override
	public BetType<?> makeOddEvenType() {
		return new OddEvenType();
	}

	@Override
	public BetType<?> makeRedBlackType() {
		return new RedBlackType();
	}

}
