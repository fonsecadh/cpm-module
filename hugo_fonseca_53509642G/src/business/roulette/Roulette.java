package business.roulette;

import java.util.List;

import business.bets.Bet;
import business.roulette.results.RoundResult;

public interface Roulette {
	
	// Singleton
	Roulette getInstance();
	
	// Spinning
	void spin();
	
	// Bet management
	void attachBet(Bet bet);
	void detachBet(Bet bet);
	void notifyBets();
	List<RoundResult> getResults();

}
