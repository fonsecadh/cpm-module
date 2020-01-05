package business.facade;

import javax.swing.ImageIcon;

import business.bar.products.Product;
import business.chips.Chip;
import business.images.ImageFactory;
import business.images.ImageFactoryImpl;

public class ImageFacade {
	
	// Attributes
	private ImageFactory imgFactory = new ImageFactoryImpl();

	public ImageIcon getImageForProduct(Product product) {
		return imgFactory.makeImageForProduct(product);
	}

	public ImageIcon getImageForChip(Chip chip) {
		return imgFactory.makeImageForChip(chip);
	}

}
