package business.bets;

import business.bets.managers.BetManager;
import business.bets.types.BetType;

public interface Bet {
	
	// Bet types
	BetType<?> getType();
	void setType(BetType<?> type);
	
	// Bet amount
	double getBetAmmount();
	void setBetAmmount(double ammount);
	
	// Bet benefit
	double getBetBenefit();
	
	// Bet manager
	BetManager getBetManager();
	void setBetManager(BetManager bm);
	
	// Current round results
	void update();
	
	// Status
	BetStatus getStatus();
	void setStatus(BetStatus status);

}
