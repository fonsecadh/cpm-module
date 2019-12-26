package business.roulette;

import java.util.ArrayList;
import java.util.List;

import business.bets.Bet;
import business.roulette.results.RoundResult;

public class Roulette {
	
	// Attributes
	private static Roulette r = new Roulette();
	private List<Bet> bets = new ArrayList<Bet>();
	private RoundResult roundResult;
	
	
	
	// Singleton
	public static Roulette getInstance() {
		return r;
	}
	
	// Spinning
	public void spin() {
		
	}
	
	public RoundResult getRoundResult() {
		return roundResult;
	}
	
	// Bet management
	public void attachBet(Bet bet) {
		bets.add(bet);
	}
	
	public void detachBet(Bet bet) {
		bets.remove(bet);
	}	
	
	public void notifyBets() {
		bets.parallelStream().forEach(b -> b.update());
	}
	
	public List<Bet> getResults() {
		return new ArrayList<Bet>(bets);		
	}

}
