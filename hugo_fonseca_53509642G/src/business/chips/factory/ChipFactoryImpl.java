package business.chips.factory;

import business.chips.Chip;
import business.chips.ChipImpl;

public class ChipFactoryImpl implements ChipFactory {

	@Override
	public Chip makeChipFive() {
		Chip chip = new ChipImpl();
		chip.setAmount(5);
		return chip;
	}

	@Override
	public Chip makeChipTen() {
		Chip chip = new ChipImpl();
		chip.setAmount(10);
		return chip;
	}

	@Override
	public Chip makeChipTwenty() {
		Chip chip = new ChipImpl();
		chip.setAmount(20);
		return chip;
	}

	@Override
	public Chip makeChipFifty() {
		Chip chip = new ChipImpl();
		chip.setAmount(50);
		return chip;
	}

	@Override
	public Chip makeChipOneHundred() {
		Chip chip = new ChipImpl();
		chip.setAmount(100);
		return chip;
	}

}
