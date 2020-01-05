package business.images;

import javax.swing.ImageIcon;

import business.bar.products.Product;
import business.chips.Chip;

public interface ImageFactory {
	
	ImageIcon makeImageForChip(Chip chip);
	ImageIcon makeImageForProduct(Product product);

}
