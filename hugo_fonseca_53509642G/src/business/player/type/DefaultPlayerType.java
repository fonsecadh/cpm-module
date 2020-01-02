package business.player.type;

public class DefaultPlayerType implements PlayerType {

	@Override
	public double getInitialBalance() {
		return 100;
	}

}
