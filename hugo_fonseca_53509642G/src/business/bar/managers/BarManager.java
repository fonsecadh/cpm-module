package business.bar.managers;

import java.util.List;

import business.bar.products.Product;

public interface BarManager {
	
	// Products
	Product[] loadProductsAsArray();
	List<Product> loadProductsAsList();
	
	// Filter
	Product[] filterProductByType(int type);

}
