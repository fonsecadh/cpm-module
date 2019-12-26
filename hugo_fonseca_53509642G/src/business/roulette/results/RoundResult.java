package business.roulette.results;

public interface RoundResult {	
	
	// Red - Black
	boolean isRed();
	void setRed(boolean red);
	
	// Odd - Even
	boolean isEven();
	void setEven(boolean even);
	
	// Fail - Pass
	boolean hasPassed();
	void setPass(boolean pass);
	
	// Dozens
	int getDozen();
	void setDozen(int dozen);
	
	// Column
	int getColumn();
	void setColumn(int column);
	
	// Number
	int getNumber();
	void setNumber(int number);

}
