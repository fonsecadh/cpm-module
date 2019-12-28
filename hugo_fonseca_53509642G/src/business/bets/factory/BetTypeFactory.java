package business.bets.factory;

import business.bets.types.BetType;

public interface BetTypeFactory {
	
	BetType<?> makeColumnType();
	BetType<?> makeDozenType();
	BetType<?> makeFailPassType();
	BetType<?> makeNumberType();
	BetType<?> makeOddEvenType();
	BetType<?> makeRedBlackType();

}
