package business.bets.factory;

import business.bets.types.BetType;

public interface BetTypeFactory {
	
	BetType<Integer> makeColumnType();
	BetType<Integer> makeDozenType();
	BetType<Boolean> makeFailPassType();
	BetType<Integer> makeNumberType();
	BetType<Boolean> makeOddEvenType();
	BetType<Boolean> makeRedBlackType();

}
