package business.bar;

import business.bar.products.Product;
import business.exceptions.order.OrderException;

public interface Order {
	
	// Comments
	String getComment();
	void addComment(String comment);
	
	// Products
	void addProduct(Product product, int units) throws OrderException;
	void removeProduct(Product product, int units) throws OrderException;
	boolean canDeleteUnitsFromProduct(Product product, int units) throws OrderException;
	
	// Total
	double getTotal();
	
	// Initialize
	void initialize();

}
