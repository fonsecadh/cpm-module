package business.bets.factory;

import business.bets.types.ColumnType;
import business.bets.types.DozenType;
import business.bets.types.FailPassType;
import business.bets.types.NumberType;
import business.bets.types.OddEvenType;
import business.bets.types.RedBlackType;

public interface BetTypeFactory {
	
	ColumnType makeColumnType();
	DozenType makeDozenType();
	FailPassType makeFailPassType();
	NumberType makeNumberType();
	OddEvenType makeOddEvenType();
	RedBlackType makeRedBlackType();

}
