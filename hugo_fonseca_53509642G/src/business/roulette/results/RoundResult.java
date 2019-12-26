package business.roulette.results;

import business.bets.Bet;

public interface RoundResult {
	
	// Status
	ResultStatus getStatus();
	void setStatsus(ResultStatus result);
	
	// Bet
	Bet getBet();
	void setBet(Bet bet);

}
