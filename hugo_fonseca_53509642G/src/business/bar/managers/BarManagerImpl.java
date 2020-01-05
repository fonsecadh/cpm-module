package business.bar.managers;

import java.util.List;
import java.util.stream.Collectors;

import business.bar.factory.ProductFactoryImpl;
import business.bar.products.Product;
import persistence.bar.BarDataAccess;
import persistence.bar.BarDataAccessImpl;

public class BarManagerImpl implements BarManager {
	
	// Attributes
	private BarDataAccess bda;
	
	
	// Constructor
	public BarManagerImpl() {
		BarDataAccess aux = new BarDataAccessImpl();
		aux.setProductFactory(new ProductFactoryImpl());
		this.bda = aux;
	}

	@Override
	public Product[] loadProductsAsArray() {
		List<Product> prodList = bda.loadProducts();		
		Product[] aux = new Product[prodList.size()];
		return prodList.toArray(aux);
	}

	@Override
	public List<Product> loadProductsAsList() {
		return bda.loadProducts();
	}

	@Override
	public Product[] filterProductByType(int type) {
		List<Product> filteredProducts = bda
				.loadProducts()
				.parallelStream()
				.filter(p -> p.getType() == type)
				.collect(Collectors.toList());
		Product[] aux = new Product[filteredProducts.size()];
		return filteredProducts.toArray(aux);
	}

}
