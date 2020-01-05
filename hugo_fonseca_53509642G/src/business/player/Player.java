package business.player;

import java.util.ArrayList;
import java.util.List;

import business.chips.Chip;
import business.player.type.DefaultPlayerType;
import business.player.type.PlayerType;
import business.users.User;

public class Player {

	// Attributes
	private static Player player = new Player();
	private User user;
	private List<Chip> chips = new ArrayList<Chip>();
	private PlayerType type;
	
	
	
	// Singleton
	private Player() {
		this.type = new DefaultPlayerType();
	}
	
	public static Player getInstance() {
		return player;
	}

	
	// Methods
	public User getAssociatedUser() {
		return user;
	}

	public void setAssociatedUser(User user) {
		this.user = user;
	}

	public List<Chip> getChips() {
		return new ArrayList<Chip>(chips);
	}

	public void addChip(Chip chip) {
		this.chips.add(chip);
	}

	public void removeChipOfType(double type) {
		Chip toRemove = null;
		for (Chip c : chips) {
			if (c.getAmount() == type) {
				toRemove = c;
				break;
			}
		}
		if (toRemove != null) {
			chips.remove(toRemove);
		}
	}

	public double getBalance() {
		return user.getBalance();
	}

	public void setBalance(double balance) {
		this.user.setBalance(balance);
	}

	public double getInitialBalance() {
		return type.getInitialBalance();
	}

	public PlayerType getPlayerType() {
		return this.type;
	}

	void setPlayerType(PlayerType type) {
		this.type = type;
	}

	public void removeAllChips() {
		this.chips.clear();
	}

}
