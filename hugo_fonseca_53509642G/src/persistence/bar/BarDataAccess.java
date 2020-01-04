package persistence.bar;

import java.util.List;

import business.bar.factory.ProductFactory;
import business.bar.products.Product;

public interface BarDataAccess {
	
	// Products
	List<Product> loadProducts();

	// Product Factory
	ProductFactory getProductFactory();
	void setProductFactory(ProductFactory productFactory);
	
}
