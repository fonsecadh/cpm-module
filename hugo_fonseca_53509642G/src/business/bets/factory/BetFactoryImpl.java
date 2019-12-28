package business.bets.factory;

import business.bets.Bet;
import business.bets.BetImpl;
import business.bets.managers.BetManager;
import business.bets.types.BetType;

public class BetFactoryImpl implements BetFactory {
	
	// Attributes
	private BetTypeFactory typeFactory = new BetTypeFactoryImpl();
	private BetManagerFactory managerFactory = new BetManagerFactoryImpl();
	
		
	
	@Override
	public Bet makeColumnBet(double amount, int playerBet) {
		Bet bet = new BetImpl();
		BetType<Integer> type = typeFactory.makeColumnType();
		BetManager manager = managerFactory.makeColumnManager();
		
		type.setPlayerBet(playerBet);		
		bet.setType(type);
		bet.setBetManager(manager);
		bet.setBetAmount(amount);
		
		return bet;
	}
	
	@Override
	public Bet makeDozenBet(double amount, int playerBet) {
		Bet bet = new BetImpl();
		BetType<Integer> type = typeFactory.makeDozenType();
		BetManager manager = managerFactory.makeDozenManager();
		
		type.setPlayerBet(playerBet);		
		bet.setType(type);
		bet.setBetManager(manager);
		bet.setBetAmount(amount);
		
		return bet;
	}
	
	@Override
	public Bet makeFailPassBet(double amount, boolean playerBet) {
		Bet bet = new BetImpl();
		BetType<Boolean> type = typeFactory.makeFailPassType();
		BetManager manager = managerFactory.makeFailPassManager();
		
		type.setPlayerBet(playerBet);		
		bet.setType(type);
		bet.setBetManager(manager);
		bet.setBetAmount(amount);
		
		return bet;
	}
	
	@Override
	public Bet makeNumberBet(double amount, int playerBet) {
		Bet bet = new BetImpl();
		BetType<Integer> type = typeFactory.makeNumberType();
		BetManager manager = managerFactory.makeNumberManager();
		
		type.setPlayerBet(playerBet);		
		bet.setType(type);
		bet.setBetManager(manager);
		bet.setBetAmount(amount);
		
		return bet;
	}
	
	@Override
	public Bet makeOddEvenBet(double amount, boolean playerBet) {
		Bet bet = new BetImpl();
		BetType<Boolean> type = typeFactory.makeOddEvenType();
		BetManager manager = managerFactory.makeOddEvenManager();
		
		type.setPlayerBet(playerBet);		
		bet.setType(type);
		bet.setBetManager(manager);
		bet.setBetAmount(amount);
		
		return bet;
	}
	
	@Override
	public Bet makeRedBlackBet(double amount, boolean playerBet) {
		Bet bet = new BetImpl();
		BetType<Boolean> type = typeFactory.makeRedBlackType();
		BetManager manager = managerFactory.makeRedBlackManager();
		
		type.setPlayerBet(playerBet);		
		bet.setType(type);
		bet.setBetManager(manager);
		bet.setBetAmount(amount);
		
		return bet;
	}

}
