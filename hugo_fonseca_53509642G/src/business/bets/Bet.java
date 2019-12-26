package business.bets;

import business.bets.managers.BetManager;
import business.bets.types.BetType;

public interface Bet {
	
	// Bet types
	BetType getType();
	void setType(BetType type);
	
	// Bet amount
	double getBetAmmount();
	void setBetAmmount(double ammount);
	
	// Bet benefit
	double getBetBenefit();
	void setBetBenefit(double benefit);
	
	// Bet manager
	BetManager getBetManager();
	void setBetManager(BetManager bm);
	
	// Current round results
	double getAmmountForCurrentRound();

}
