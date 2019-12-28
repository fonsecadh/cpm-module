package business.chips;

public class ChipImpl implements Chip {
	
	// Attributes
	private double amount;
	
	

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
