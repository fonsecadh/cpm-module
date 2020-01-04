package business.facade;

import business.chips.Chip;
import business.chips.factory.ChipFactory;
import business.chips.factory.ChipFactoryImpl;

public class ChipFacade {
	
	// Attributes
	private ChipFactory chipFactory = new ChipFactoryImpl();

	public Chip makeChipFive() {
		return chipFactory.makeChipFive();
	}

	public Chip makeChipTen() {
		return chipFactory.makeChipTen();
	}

	public Chip makeChipTwenty() {
		return chipFactory.makeChipTwenty();
	}

	public Chip makeChipFifty() {
		return chipFactory.makeChipFifty();
	}

	public Chip makeChipOneHundred() {
		return chipFactory.makeChipOneHundred();
	}

}
