package business.bets;

import business.bets.managers.BetManager;
import business.bets.types.BetType;

public class BetImpl implements Bet {
	
	// Attributes
	private BetType<?> type;
	private double amount;
	private BetStatus status;
	private BetManager manager;
	
	
	
	public BetImpl() {
		this.status = BetStatus.DEFAULT;
	}
	
	

	@Override
	public BetType<?> getType() {
		return type;
	}

	@Override
	public void setType(BetType<?> type) {
		this.type = type;
	}

	@Override
	public double getBetAmount() {
		return amount;
	}

	@Override
	public void setBetAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public double getBetBenefit() {
		switch (status) {
			case ZERO:
				return amount + (amount / 2);
			case LOST:
				return 0;
			case WON:
				return amount + (amount * type.getMultiplier());
			default:
				return 0;
		}
	}

	@Override
	public BetManager getBetManager() {
		return manager;
	}

	@Override
	public void setBetManager(BetManager bm) {
		this.manager = bm;
	}

	@Override
	public void update() {
		setStatus(manager.evaluateBet(this));	
	}

	@Override
	public BetStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(BetStatus status) {
		this.status = status;
	}	
	
	@Override
	public String toString() {
		return "(" + status.toString() + ") Type: " + type.toString() + ", amount: " + amount + ", benefit: " + getBetBenefit();
	}

}
