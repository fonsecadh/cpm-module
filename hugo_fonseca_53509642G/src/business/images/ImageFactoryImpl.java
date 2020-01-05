package business.images;

import java.awt.Image;

import javax.swing.ImageIcon;

import business.bar.products.Product;
import business.chips.Chip;

public class ImageFactoryImpl implements ImageFactory {

	@Override
	public ImageIcon makeImageForChip(Chip chip) {
		String filename = getFilenameForChip(chip);
		ImageIcon imgIcon = new ImageIcon(ImageFactoryImpl.class.getResource(filename));
		Image img = imgIcon.getImage();
		Image newImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(newImg);
		return imgIcon;
	}

	private String getFilenameForChip(Chip chip) {
		String filename = "";
		if (chip.getAmount() == 5) {
			filename = "/img/chipFive.png";
		} else if (chip.getAmount() == 10) {
			filename = "/img/chipTen.png";
		} else if (chip.getAmount() == 20) {
			filename = "/img/chipTwenty.png";
		} else if (chip.getAmount() == 50) {
			filename = "/img/chipFifty.png";
		} else if (chip.getAmount() == 100) {
			filename = "/img/chipOneHundred.png";
		}
		return filename;
	}

	@Override
	public ImageIcon makeImageForProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
