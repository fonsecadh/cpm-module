package business.roulette.results;

public class RoundResultImpl implements RoundResult {
	
	// Attributes
	private boolean isRed;
	private boolean isEven;
	private boolean hasPassed;
	private int dozen;
	private int column;
	private int number;
	
	

	@Override
	public boolean isRed() {
		return isRed;
	}

	@Override
	public void setRed(boolean red) {
		this.isRed = red;
	}

	@Override
	public boolean isEven() {
		return isEven;
	}

	@Override
	public void setEven(boolean even) {
		this.isEven = even;
	}

	@Override
	public boolean hasPassed() {
		return hasPassed;
	}

	@Override
	public void setPass(boolean pass) {
		this.hasPassed = pass;
	}

	@Override
	public int getDozen() {
		return dozen;
	}

	@Override
	public void setDozen(int dozen) {
		this.dozen = dozen;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}

}
