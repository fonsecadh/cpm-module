package business.bar.factory;

import business.bar.products.Drink;
import business.bar.products.Product;

public class ProductFactoryImpl implements ProductFactory {

	@Override
	public Product makeDrink() {
		return new Drink();
	}

}
