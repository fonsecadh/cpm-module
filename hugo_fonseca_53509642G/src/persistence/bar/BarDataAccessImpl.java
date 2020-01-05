package persistence.bar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.bar.factory.ProductFactory;
import business.bar.products.Product;

public class BarDataAccessImpl implements BarDataAccess {

	// Constants
	private static final String PRODUCTS_FILENAME_URL = "files/drinks.dat";

	// Attributes
	private ProductFactory productFactory;

	@Override
	public List<Product> loadProducts() {
		String line;
		String[] productData = null;		
		List<Product> products = new ArrayList<Product>();

		try {
			BufferedReader file = new BufferedReader(new FileReader(PRODUCTS_FILENAME_URL));
			while (file.ready()) {
				Product product = productFactory.makeDrink();
				
				line = file.readLine();
				productData = line.split("@");

				product.setCode(productData[0]);
				product.setName(productData[1]);
				product.setType(Integer.parseInt(productData[2]));
				product.setPrice(Double.parseDouble(productData[3]));

				products.add(product);
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}

		return products;
	}

	@Override
	public ProductFactory getProductFactory() {
		return productFactory;
	}

	@Override
	public void setProductFactory(ProductFactory productFactory) {
		this.productFactory = productFactory;
	}

}
