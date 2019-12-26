package business.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import business.bets.Bet;
import business.roulette.results.RoundResult;
import business.roulette.results.RoundResultImpl;

public class Roulette {
	
	// Attributes
	private static final Roulette r = new Roulette();
	private List<Bet> bets = new ArrayList<Bet>();
	private RoundResult roundResult;
	Random rand = new Random();
	Integer[] redN = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
	ArrayList<Integer> firstColumn = new ArrayList<Integer>();
	ArrayList<Integer> secondColumn = new ArrayList<Integer>();
	ArrayList<Integer> thirdColumn = new ArrayList<Integer>();
		
	
	
	// Singleton
	private Roulette() {		
		for (int i = 1; i <= 34; i+=3) {
			firstColumn.add(i);
		}
		
		for (int i = 2; i <= 35; i+=3) {
			secondColumn.add(i);
		}
		
		for (int i = 3; i <= 36; i+=3) {
			thirdColumn.add(i);
		}
	}
	
	public static Roulette getInstance() {
		return r;
	}
	
	// Spinning
	public void spin() {
		int resultingNumber = generateRandomNumberInRange(0, 36);
		roundResult = new RoundResultImpl();
		roundResult.setNumber(resultingNumber);
		roundResult.setEven(isEvenNumber(resultingNumber));
		roundResult.setRed(isRedNumber(resultingNumber));
		roundResult.setPass(hasPassedNumber(resultingNumber));
		roundResult.setColumn(getColumn(resultingNumber));
		roundResult.setDozen(getDozen(resultingNumber));
	}
	
	private int getDozen(int n) {
		if (n >= 1 && n <= 12) {
			return 1;
		} else if (n >= 13 && n <= 24) {
			return 2;
		} else if (n >= 25 && n <= 36) {
			return 3;
		} else { // Special case: Zero
			return -1;
		}
	}

	private int getColumn(int n) {
		if (firstColumn.indexOf(n) != -1) {
			return 1;
		} else if (secondColumn.indexOf(n) != -1) {
			return 2;
		} else if (thirdColumn.indexOf(n) != -1) {
			return 3;
		} else {
			return -1;
		}
	}

	private boolean hasPassedNumber(int n) {
		return n >= 1 && n <= 18 ? false : true;
	}

	private boolean isRedNumber(int n) {
		int index = Arrays.asList(redN).indexOf(n);
		return index == -1 ? false : true;
	}

	private boolean isEvenNumber(int n) {
		if ((n % 2) == 0) {
			return true;
		} else {
			return false;
		}
	}

	private int generateRandomNumberInRange(int min, int max) {
		return rand.nextInt((max - min) + 1) + min;
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
