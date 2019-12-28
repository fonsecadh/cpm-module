package business.chips.factory;

import business.chips.Chip;

public interface ChipFactory {
	
	Chip makeChipFive();
	Chip makeChipTen();
	Chip makeChipTwenty();
	Chip makeChipFifty();
	Chip makeChipOneHundred();

}
